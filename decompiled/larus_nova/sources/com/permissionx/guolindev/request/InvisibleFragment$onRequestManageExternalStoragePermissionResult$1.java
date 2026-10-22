package com.permissionx.guolindev.request;

import android.os.Build;
import android.os.Environment;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class InvisibleFragment$onRequestManageExternalStoragePermissionResult$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ InvisibleFragment this$0;

    public InvisibleFragment$onRequestManageExternalStoragePermissionResult$1(InvisibleFragment r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        b r100 = null;
        b r101 = null;
        o r102 = null;
        if (Build.VERSION.SDK_INT >= 30) goto L5;
        b r103 = this.this$0.f404355f;
        if (r103 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("task");
    L23:
        r100.finish();
        return;
    L22:
        r100 = r103;
        goto L23
    L5:
        if (Environment.isExternalStorageManager() == false) goto L11;
        b r104 = this.this$0.f404355f;
        if (r104 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("task");
    L10:
        r101.finish();
        return;
    L9:
        r101 = r104;
        goto L10
    L11:
        o r105 = this.this$0.f404354e;
        if (r105 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("pb");
        r105 = null;
    L14:
        r105.getClass();
        o r106 = this.this$0.f404354e;
        if (r106 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("pb");
    L18:
        r102.getClass();
        return;
    L17:
        r102 = r106;
        goto L18
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
