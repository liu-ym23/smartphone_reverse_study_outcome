package ew;

import android.app.Activity;
import android.content.Context;
import com.android.ttcjpaysdk.base.utils.CJFontServiceUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements bw.b {
    public e() {
    }

    @Override // bw.b
    public final Activity A1() {
        return null;
    }

    @Override // bw.b
    public final void G1(Context r100, String r101, String r102, Map r103, Map r104, Map r105, com.bytedance.android.gamecp.business.props.k r106) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "aid");
        Intrinsics.checkNotNullParameter(r102, com.bytedance.android.ec.core.event.a.KEY_DID);
    }

    @Override // bw.b
    public final void M0(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
    }

    @Override // bw.b
    public final String P() {
        return "";
    }

    @Override // bw.b
    public final void V1(Context r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // bw.b
    public final void X1(com.bytedance.android.gamecp.host_api.model.i r100) {
        Intrinsics.checkNotNullParameter(r100, "pushInfo");
    }

    @Override // bw.b
    public final Activity c0() {
        return null;
    }

    @Override // bw.b
    public final void centerToast(Context r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // bw.b
    public final void f1() {
    }

    @Override // bw.b
    public final Activity[] getActivityStack() {
        return null;
    }

    @Override // bw.b
    public final Activity getCurrentActivity() {
        return null;
    }

    @Override // bw.b
    public final float getDeviceScore() {
        return -1.0f;
    }

    @Override // bw.b
    public final void getFontScale() {
    }

    @Override // bw.b
    public final Activity getMainActivity() {
        return null;
    }

    @Override // bw.b
    public final String getSessionId() {
        return "";
    }

    @Override // bw.b
    public final Activity getTopActivity() {
        return null;
    }

    @Override // bw.b
    public final void h0(Context r100, dw.l r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "callback");
    }

    @Override // bw.b
    public final boolean isAppBackground() {
        return false;
    }

    @Override // bw.b
    public final void m2(Function1 r100) {
        Intrinsics.checkNotNullParameter(CJFontServiceUtils.DOUYIN_SANS_BOLD_FONT, "fontName");
        Intrinsics.checkNotNullParameter(r100, "callback");
    }

    @Override // bw.b
    public final void y0(dw.d r100) {
    }

    @Override // bw.b
    public final Map<String, String> getNQEParams() {
        return new LinkedHashMap();
    }
}
