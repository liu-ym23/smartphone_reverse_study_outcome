package com.bytedance.scene.ktx;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.scene.Scene;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class SceneExtensionsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f268730a = null;

    public static final class a implements na7.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f268731a;

        public a(Function1 r100) {
            this.f268731a = r100;
        }

        @Override // na7.c
        public final void onResult(int[] r100) {
            this.f268731a.invoke(r100);
        }
    }

    public static final class b implements na7.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2 f268732a;

        public b(Function2 r100) {
            this.f268732a = r100;
        }

        @Override // na7.a
        public final void onResult(int r100, Intent r101) {
            this.f268732a.invoke(Integer.valueOf(r100), r101);
        }
    }

    public static final class c implements na7.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2 f268733a;

        public c(Function2 r100) {
            this.f268733a = r100;
        }

        @Override // na7.a
        public final void onResult(int r100, Intent r101) {
            this.f268733a.invoke(Integer.valueOf(r100), r101);
        }
    }

    static {
        f268730a = LazyKt.lazy(SceneExtensionsKt$HANDLER$2.INSTANCE);
    }

    public static final void requestPermissions(Scene r100, String[] r101, int r102, Function1<? super int[], Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$requestPermissions");
        Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
        Intrinsics.checkNotNullParameter(r103, "resultCallback");
        Activity r104 = r100.getActivity();
        if (r104 == null) goto L6;
        com.bytedance.scene.a.requestPermissions(r104, r100, r101, r102, new a(r103));
        return;
    }

    public static final void startActivityForResult(Scene r100, Intent r101, int r102, Function2<? super Integer, ? super Intent, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$startActivityForResult");
        Intrinsics.checkNotNullParameter(r101, "intent");
        Intrinsics.checkNotNullParameter(r103, "resultCallback");
        Activity r104 = r100.getActivity();
        if (r104 == null) goto L6;
        com.bytedance.scene.a.startActivityForResult(r104, r100, r101, r102, new b(r103));
        return;
    }

    @Deprecated(message = "use Scene.requestPermissions(Array<String>, Int, (IntArray?) -> Unit)) instead")
    public static final void requestPermissions(Scene r100, String[] r101, int r102, na7.c r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$requestPermissions");
        Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
        Intrinsics.checkNotNullParameter(r103, "resultCallback");
        Activity r104 = r100.getActivity();
        if (r104 == null) goto L6;
        com.bytedance.scene.a.requestPermissions(r104, r100, r101, r102, r103);
        return;
    }

    @Deprecated(message = "use Scene.startActivityForResult(Intent, Int, (Int, Intent?) -> Unit)) instead")
    public static final void startActivityForResult(Scene r100, Intent r101, int r102, na7.a r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$startActivityForResult");
        Intrinsics.checkNotNullParameter(r101, "intent");
        Intrinsics.checkNotNullParameter(r103, "resultCallback");
        Activity r104 = r100.getActivity();
        if (r104 == null) goto L6;
        com.bytedance.scene.a.startActivityForResult(r104, r100, r101, r102, r103);
        return;
    }

    public static final void startActivityForResult(Scene r100, Intent r101, int r102, Bundle r110, Function2<? super Integer, ? super Intent, Unit> r111) {
        Intrinsics.checkNotNullParameter(r100, "$this$startActivityForResult");
        Intrinsics.checkNotNullParameter(r101, "intent");
        Intrinsics.checkNotNullParameter(r111, "resultCallback");
        Activity r103 = r100.getActivity();
        if (r103 == null) goto L6;
        com.bytedance.scene.a.startActivityForResult(r103, r100, r101, r102, r110, new c(r111));
        return;
    }
}
