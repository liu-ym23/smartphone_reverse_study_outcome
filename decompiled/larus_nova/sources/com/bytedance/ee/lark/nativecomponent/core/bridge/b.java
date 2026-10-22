package com.bytedance.ee.lark.nativecomponent.core.bridge;

import com.ss.android.lark.officewebview.webview_api.bridge.Status;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements js5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function3<c, Status, JSONObject, Unit> f242821a;

    /* JADX WARN: Multi-variable type inference failed */
    public b(Function3<? super c, ? super Status, ? super JSONObject, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "invoker");
        this.f242821a = r100;
    }

    @Override // js5.c
    public final void onSuccess(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Function3<c, Status, JSONObject, Unit> r101 = this.f242821a;
        c r102 = c.f242822f;
        r101.invoke(c.f242822f, Status.SUCCESS, r100);
    }
}
