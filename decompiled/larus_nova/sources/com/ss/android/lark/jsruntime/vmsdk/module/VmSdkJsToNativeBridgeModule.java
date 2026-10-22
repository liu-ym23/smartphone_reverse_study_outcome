package com.ss.android.lark.jsruntime.vmsdk.module;

import android.content.Context;
import com.bytedance.vmsdk.jsbridge.JSMethod;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tnb.f;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\rH\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/jsruntime/vmsdk/module/VmSdkJsToNativeBridgeModule;", "Lcom/bytedance/vmsdk/jsbridge/JSModule;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "delegate", "", "<init>", "(Landroid/content/Context;Ljava/lang/Object;)V", "getDelegate", "()Ljava/lang/Object;", "responseFromJs", "", "pbDataString", "", "responseFromDocs", "jsonString", "Companion", "jsruntime_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VmSdkJsToNativeBridgeModule extends JSModule {
    public static final a Companion = null;
    public static final String NAME = "VMJsToNativeBridge";
    private static final String TAG = "VMSDK_VmSdkJsToNativeBridgeModule";
    private final Object delegate;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final Object getDelegate() {
        return this.delegate;
    }

    @JSMethod
    public final void responseFromDocs(String r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonString");
        Object r101 = this.delegate;
        if ((r101 instanceof f) == false) goto L5;
        f r102 = (f) r101;
    L6:
        if (r102 == null) goto L9;
        r102.c(r100);
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @JSMethod
    public final void responseFromJs(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pbDataString");
        Object r101 = this.delegate;
        if ((r101 instanceof f) == false) goto L5;
        f r102 = (f) r101;
    L6:
        if (r102 == null) goto L9;
        r102.d(r100);
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public VmSdkJsToNativeBridgeModule(Context r100, Object r101) {
        Intrinsics.checkNotNullParameter(r101, "delegate");
        super(r100);
        this.delegate = r101;
    }
}
