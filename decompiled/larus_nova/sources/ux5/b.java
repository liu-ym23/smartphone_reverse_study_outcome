package ux5;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.queryfilter.QueryFilterEngine;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import com.bytedance.retrofit2.client.Request;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends c {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f551984l = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<String> f551985i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f551986j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f551987k;

    static {
        f551984l = b.class.getSimpleName();
    }

    public b(int r100) {
        super(r100);
        this.f551985i = new ArrayList();
        this.f551986j = false;
        this.f551987k = false;
    }

    @Override // ux5.c
    public final void d(JSONObject r100) {
        e(r100);
        QueryFilterEngine.parseArrayListConfig(r100.optJSONArray("encrypt_query_list"), this.f551985i);
        boolean r101 = false;
        if (r100.optInt("encrypt_body_enabled", 0) <= 0) goto L5;
        r101 = true;
    L5:
        this.f551987k = r101;
        if (((ArrayList) this.f551985i).isEmpty() == true) goto L8;
        return;
    L8:
        if (this.f551987k == true) goto L12;
        this.f551986j = true;
        return;
    }

    @Override // ux5.c
    public final boolean a(Request r110, Map<String, List<String>> r111) {
        boolean r100 = false;
        if (this.f551986j == false) goto L5;
    L61:
        return r100;
    L5:
        if (c(r110) == false) goto L61;
        if (this.f551987k == false) goto L11;
        r110.setBodyEncryptEnabled(true);
        r100 = true;
    L11:
        if (r111.isEmpty() == false) goto L14;
        return r100;
    L14:
        if (((ArrayList) this.f551985i).isEmpty() == true) goto L61;
        if (r111.containsKey("x-tt-encrypt-queries") == true) goto L61;
        LinkedList r101 = new LinkedList();
        Iterator r102 = ((ArrayList) this.f551985i).iterator();
    L20:
        if (r102.hasNext() == false) goto L25;
        String r103 = (String) r102.next();
        if (r111.containsKey(r103) == false) goto L20;
        r101.add(new Pair(r103, r111.get(r103)));
        goto L20
    L25:
        if (r101.isEmpty() == false) goto L27;
        return r100;
    L27:
        StringBuilder r104 = new StringBuilder();
        Iterator r105 = r101.iterator();
    L29:
        if (r105.hasNext() == false) goto L41;
        Pair r106 = (Pair) r105.next();
        String r107 = (String) r106.first;
        List r108 = (List) r106.second;
        if (r108 == null) goto L29;
        if (r108.size() <= 0) goto L29;
        Iterator r109 = r108.iterator();
    L36:
        if (r109.hasNext() == false) goto L29;
        String r112 = (String) r109.next();
        if (r104.length() <= 0) goto L40;
        r104.append("&");
    L40:
        r104.append(r107);
        r104.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r104.append(r112);
        goto L36
    L41:
        String r113 = r104.toString();
        if (TextUtils.isEmpty(r113) == false) goto L62;
        return r100;
    L62:
        byte[] r114 = r113.getBytes("UTF-8");     // Catch: UnsupportedEncodingException -> L46
    L48:
        if (r114 != null) goto L50;
        return r100;
    L50:
        byte[] r115 = EncryptorUtil.b(r114, r114.length);
        if (r115 != null) goto L53;
        return r100;
    L53:
        String r116 = Base64.encodeToString(r115, 2);
        if (Logger.debug() == false) goto L56;
        Logger.d(f551984l, "encryptBytes:" + r115 + " , encryptString:" + r116);
    L56:
        LinkedList r117 = new LinkedList();
        r117.add(r116);
        r110.setQueryEncryptEnabled(true);
        r111.put("x-tt-encrypt-queries", r117);
        Iterator r118 = ((ArrayList) this.f551985i).iterator();
    L58:
        if (r118.hasNext() == false) goto L60;
        r111.remove((String) r118.next());
        goto L58
    L60:
        return true;
    L46:
        e = move-exception;
        e.printStackTrace();
        r114 = null;
        goto L48
    }
}
