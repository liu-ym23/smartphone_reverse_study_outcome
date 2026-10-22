package com.bytedance.ies.argus.api.params;

import android.view.InputDevice;
import android.view.MotionEvent;
import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class f extends BaseAspectParams<g> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MotionEvent f245739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public s f245740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f245741d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f245742e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f245743f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f245744g;

    @Override // com.bytedance.ies.argus.api.params.BaseAspectParams
    public final com.bytedance.ies.argus.strategy.a f() {
        return new g(0);
    }

    public final String g() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L14
        int r101 = this.f245739b.getAction();     // Catch: Throwable -> L14
        if (r101 == 0) goto L11;
        if (r101 == 1) goto L10;
        if (r101 == 2) goto L9;
        if (r101 == 3) goto L8;
        String r102 = "UNKNOWN_ACTION";
    L12:
        Object r103 = Result.m9449constructorimpl(MapsKt.mapOf(new Pair[]{TuplesKt.to("action", r102), TuplesKt.to("x", Float.valueOf(this.f245739b.getX())), TuplesKt.to("y", Float.valueOf(this.f245739b.getY()))}).toString());     // Catch: Throwable -> L14
    L17:
        if (Result.m9455isFailureimpl(r103) == false) goto L20;
        r103 = null;
    L20:
        return (String) r103;
    L8:
        r102 = "ACTION_CANCEL";
        goto L12
    L9:
        r102 = "ACTION_MOVE";
        goto L12
    L10:
        r102 = "ACTION_UP";
        goto L12
    L11:
        r102 = "ACTION_DOWN";
    L14:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    @Override // com.bytedance.ies.argus.strategy.b
    public final JSONObject d(ArgusVerifyAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        JSONObject r101 = new JSONObject();
        g r102 = e();
        Boolean r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.f245745b;
    L6:
        JSONUtilsKt.d(r101, "scene", r104);
        JSONUtilsKt.e(r101, "url", this.f245741d);
        s r105 = this.f245740c;
        if (r105 == null) goto L9;
        Long r106 = Long.valueOf(r105.b());
    L10:
        JSONUtilsKt.e(r101, "fe_id", r106);
        Integer r107 = this.f245742e;
        if (r107 == null) goto L15;
        InputDevice r108 = InputDevice.getDevice(r107.intValue());
        if (r108 == null) goto L15;
        r103 = Boolean.valueOf(r108.isVirtual());
    L15:
        JSONUtilsKt.e(r101, "is_virtual", r103);
        JSONUtilsKt.e(r101, "motion_did", this.f245742e);
        JSONUtilsKt.e(r101, "tool_type", this.f245743f);
        JSONUtilsKt.d(r101, "event", this.f245744g);
        return r101;
    L9:
        r106 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    public f(MotionEvent r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.f245739b = r100;
        String r102 = null;
        this.f245740c = null;
        this.f245741d = r101;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L26
        this.f245742e = Integer.valueOf(r100.getDeviceId());     // Catch: Throwable -> L26
        Integer r104 = Integer.valueOf(r100.getPointerCount());     // Catch: Throwable -> L26
        if (r104.intValue() < 1) goto L6;
        boolean r105 = true;
    L7:
        if (r105 == true) goto L10;
        r104 = null;
    L10:
        if (r104 == null) goto L24;
        r104.intValue();     // Catch: Throwable -> L26
        int r106 = r100.getToolType(0);     // Catch: Throwable -> L26
        if (r106 == 0) goto L22;
        if (r106 != 1) goto L15;
        r102 = "TOOL_TYPE_FINGER";
    L23:
        this.f245743f = r102;     // Catch: Throwable -> L26
        goto L24
    L15:
        if (r106 != 3) goto L17;
        r102 = "TOOL_TYPE_MOUSE";
        goto L23
    L17:
        if (r106 != 4) goto L23;
        r102 = "TOOL_TYPE_ERASER";
        goto L23
    L22:
        r102 = "TOOL_TYPE_UNKNOWN";
    L24:
        this.f245744g = g();     // Catch: Throwable -> L26
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L26
        return;
    L6:
        r105 = false;
    L26:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
