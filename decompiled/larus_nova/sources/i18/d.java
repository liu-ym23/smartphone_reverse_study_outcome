package i18;

import android.content.Intent;
import com.larksuite.framework.apiplugin.LKApiCode;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larksuite.framework.apiplugin.entity.LKPluginHandleResult;
import com.ss.android.lark.log.Log;
import j18.e;
import j18.g;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public abstract class d implements g, Comparable<d> {
    private static final String TAG = "LKPlugin";

    public d() {
    }

    public abstract void addEvents(e r100);

    public abstract void onRelease();

    public int priority() {
        return 0;
    }

    public boolean shouldHandleActivityResult() {
        return false;
    }

    public void callBackOk(LKEvent r100) {
        r100.getClass();
        JSONObject r101 = new JSONObject();
        if (r100.f285494g == null) goto L6;
        r100.a(r101);
        r100.f285494g.onSuccess(r101);
        return;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(d r100) {
        return priority() - r100.priority();
    }

    @Override // j18.g
    public LKPluginHandleResult handleEvent(LKEvent r100) {
        r100.getClass();
        LKPluginHandleResult.a r101 = new LKPluginHandleResult.a();
        r101.f285527c = Integer.MIN_VALUE;
        r101.f285533e = true;
        return new LKPluginHandleResult(r101);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(d r100) {
        return compareTo2(r100);
    }

    public void callBackFail(String r100, LKEvent r101) {
        callBackFail(LKApiCode.GENERAL_UNKONW_ERROR.code, r100, r101);
    }

    public void callBackFail(int r100, String r101, LKEvent r102) {
        r102.b(new LKBaseResponseModel(new k18.b(r100, r101)));
    }

    public boolean handleActivityResult(int r100, int r101, Intent r102) {
        Log.i(TAG, "requestCode:" + r100 + " resultCode:" + r101);
        return false;
    }
}
