package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.alipay.sdk.m.u.i;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.TTDelayStateManager;
import com.bytedance.frameworks.baselib.network.http.util.h;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DelayTypedAction extends BaseDispatchAction {
    private static final String TAG = null;
    private static final String kProcessTagKey = "p";
    private static final String kStartUpTagKey = "s";
    private int mDelayTime;
    private int mRandomLeft;
    private int mRandomRight;
    private final Map<String, Set<String>> mTncTagMap;

    static {
        TAG = "DelayTypedAction";
    }

    private int getDelayTimeForRequest() {
        int r100 = this.mDelayTime;
        if (r100 <= 0) goto L6;
        return r100;
    L6:
        if (this.mRandomLeft < this.mRandomRight) goto L8;
        return 0;
    L8:
        return new Random().nextInt(this.mRandomRight - this.mRandomLeft) + this.mRandomLeft;
    }

    public DelayTypedAction() {
        this.mDelayTime = 0;
        this.mRandomLeft = 0;
        this.mRandomRight = 0;
        this.mTncTagMap = new HashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private BaseDispatchAction.DispatchResultEnum findDelayResult(String r110, String r111, List<Integer> r112) {
        Uri r113 = UriProtector.parse(r110);
        if (r113.getHost() == null) goto L90;
        if (isMatchRules(r113) == false) goto L90;
        if (this.mTncTagMap.isEmpty() == false) goto L15;
        ListProtector.set(r112, 0, Integer.valueOf(getDelayTimeForRequest()));
        if (Logger.debug() == false) goto L13;
        Logger.d(TAG, "tnc tag map is empty, result delay time is " + ListProtector.get(r112, 0));
    L13:
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_DELAY;
    L15:
        if (TTDelayStateManager.f244593c.get() == true) goto L22;
        if (Logger.debug() == false) goto L20;
        Logger.d(TAG, "this action with tag is not enabled");
    L20:
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L22:
        if ("".equals(r111) == false) goto L24;
        r111 = "s=0;p=0";
    L24:
        HashMap r114 = new HashMap();
        ArrayList r100 = new ArrayList();
        if (h.c(r111, i.f25853b, r100) == false) goto L27;
        Iterator r101 = r100.iterator();
    L30:
        if (r101.hasNext() == false) goto L32;
        Pair r102 = (Pair) r101.next();
        r114.put((String) r102.first, (String) r102.second);
        goto L30
    L32:
        TTDelayStateManager.AppStartState r103 = TTDelayStateManager.AppStartState.NormalStart;
        String r104 = Integer.toString(r103.getValue());
        if (TTDelayStateManager.f244592b != r103) goto L35;
    L66:
        r114.put("s", r104);
        Context r105 = URLDispatcher.inst().getContext();
        if (r105 == null) goto L69;
        boolean r106 = com.bytedance.frameworks.baselib.network.http.util.i.d(r105);
    L70:
        r114.put("p", Integer.toString(!r106));
        if (Logger.debug() == false) goto L73;
        Logger.d(TAG, "request tag string is " + r111);
    L73:
        BaseDispatchAction.DispatchResultEnum r115 = BaseDispatchAction.DispatchResultEnum.DISPATCH_DELAY;
        Iterator<Map.Entry<String, Set<String>>> r107 = this.mTncTagMap.entrySet().iterator();
    L75:
        if (r107.hasNext() == false) goto L83;
        Map.Entry<String, Set<String>> r108 = r107.next();
        String r109 = (String) r114.get(r108.getKey());
        if (r109 == null) goto L78;
        if (r108.getValue().contains(r109) == true) goto L75;
        r115 = BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
        goto L83
    L78:
        r115 = BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L83:
        if (r115 != BaseDispatchAction.DispatchResultEnum.DISPATCH_DELAY) goto L86;
        ListProtector.set(r112, 0, Integer.valueOf(getDelayTimeForRequest()));
    L86:
        if (Logger.debug() == false) goto L88;
        String r116 = TAG;
        Logger.d(r116, "match tag result is " + r115);
        Logger.d(r116, "will delay time is " + ListProtector.get(r112, 0));
        Logger.d(r116, "request tag map is " + r114);
        Logger.d(r116, "tnc tag map is " + this.mTncTagMap);
    L88:
        return r115;
    L69:
        r106 = 1;
        goto L70
    L35:
        if (Logger.debug() == false) goto L37;
        Logger.d(TTDelayStateManager.f244591a, "get coldDuration hostDuration warmDuration " + TTDelayStateManager.f244595e.get() + TTDelayStateManager.f244596f.get() + TTDelayStateManager.f244597g.get());
    L37:
        int r117 = TTDelayStateManager.a.f244599a[TTDelayStateManager.f244592b.ordinal()];
        if (r117 != 1) goto L40;
        long r118 = TTDelayStateManager.f244594d.get();
        if (((System.currentTimeMillis() / 1000) - r118) <= TTDelayStateManager.f244595e.get()) goto L61;
        boolean r119 = true;
    L62:
        if (r119 == false) goto L64;
        TTDelayStateManager.f244592b = r103;
    L64:
        TTDelayStateManager.AppStartState r120 = TTDelayStateManager.f244592b;
    L65:
        r104 = Integer.toString(r120.getValue());
        goto L66
    L61:
        r119 = false;
        goto L62
    L40:
        if (r117 != 2) goto L42;
        long r121 = TTDelayStateManager.f244594d.get();
        if (((System.currentTimeMillis() / 1000) - r121) <= TTDelayStateManager.f244596f.get()) goto L54;
        boolean r122 = true;
    L55:
        if (r122 == false) goto L57;
        TTDelayStateManager.f244592b = r103;
    L57:
        r120 = TTDelayStateManager.f244592b;
        goto L65
    L54:
        r122 = false;
        goto L55
    L42:
        if (r117 == 3) goto L44;
        r120 = TTDelayStateManager.f244592b;
        goto L65
    L44:
        long r123 = TTDelayStateManager.f244594d.get();
        if (((System.currentTimeMillis() / 1000) - r123) <= TTDelayStateManager.f244597g.get()) goto L47;
        boolean r124 = true;
    L48:
        if (r124 == false) goto L50;
        TTDelayStateManager.f244592b = r103;
    L50:
        r120 = TTDelayStateManager.f244592b;
        goto L65
    L47:
        r124 = false;
        goto L48
    L27:
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L90:
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.BaseDispatchAction
    public boolean initWithActionParam(JSONObject r100, String r101, long r102) {
        loadMatchRules(r100);
        String r103 = r100.optString("tag");
        int r104 = 0;
        if (TextUtils.isEmpty(r103) == true) goto L17;
        String[] r105 = r103.split(i.f25853b);
        int r106 = r105.length;
        int r107 = 0;
    L5:
        if (r107 >= r106) goto L17;
        String r108 = r105[r107];
        ArrayList r109 = new ArrayList();
        if (h.c(r108, ",", r109) == false) goto L16;
        Iterator r110 = r109.iterator();
    L11:
        if (r110.hasNext() == false) goto L16;
        Pair r111 = (Pair) r110.next();
        Set<String> r112 = this.mTncTagMap.get(r111.first);
        if (r112 != null) goto L15;
        r112 = new HashSet();
    L15:
        r112.add((String) r111.second);
        this.mTncTagMap.put((String) r111.first, r112);
    L16:
        r107 = r107 + 1;
    L17:
        this.mDelayTime = r100.optInt("delay");
        JSONArray r113 = r100.optJSONArray("random");
        if (this.mDelayTime > 0) goto L37;
        if (r113 == null) goto L37;
        if (r113.length() == 2) goto L44;
        return false;
    L44:
        int r114 = JSONArrayProtectorUtils.getInt(r113, 0);     // Catch: JSONException -> L28
        int r115 = JSONArrayProtectorUtils.getInt(r113, 1);     // Catch: JSONException -> L26
    L31:
        if (r114 <= 0) goto L36;
        if (r115 <= 0) goto L36;
        if (r114 >= r115) goto L36;
        r104 = r114;
    L38:
        this.mRandomLeft = r104;
        this.mRandomRight = r115;
        if (Logger.debug() == false) goto L41;
        Logger.d(TAG, "initwithparam tnc tag map is " + this.mTncTagMap);
    L41:
        return true;
    L36:
        return false;
    L26:
        e = e;
    L30:
        e.printStackTrace();
        r115 = 0;
    L28:
        e = e;
        r114 = 0;
    L37:
        r115 = 0;
        goto L38
    }

    public BaseDispatchAction.DispatchResultEnum takeDelayAction(String r100, String r101, List<Integer> r102) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "take delay action");
    L6:
        if (isDelayActionEffective() == true) goto L8;
    L12:
        ListProtector.set(r102, 0, 0);
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    L8:
        if (TextUtils.isEmpty(r100) == true) goto L12;
        return findDelayResult(r100, r101, r102);
    }
}
