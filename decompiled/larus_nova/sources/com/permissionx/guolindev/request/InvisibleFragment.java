package com.permissionx.guolindev.request;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/permissionx/guolindev/request/InvisibleFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "permissionx_release"}, k = 1, mv = {1, 7, 1})
public final class InvisibleFragment extends Fragment {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f404352o = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f404353d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public o f404354e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f404355f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ActivityResultLauncher<String[]> f404356g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ActivityResultLauncher<String> f404357h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ActivityResultLauncher<Intent> f404358i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ActivityResultLauncher<Intent> f404359j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ActivityResultLauncher<Intent> f404360k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ActivityResultLauncher<Intent> f404361l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ActivityResultLauncher<Intent> f404362m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ActivityResultLauncher<String> f404363n;

    public final boolean S90() {
        if (this.f404354e != null) goto L5;
        return false;
    L5:
        if (this.f404355f == null) goto L11;
        return true;
    L11:
        return false;
    }

    public InvisibleFragment() {
        this.f404353d = new Handler(Looper.getMainLooper());
        this.f404356g = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new f(this));
        this.f404357h = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new g(this));
        this.f404358i = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new h(this));
        this.f404359j = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new i(this));
        this.f404360k = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new j(this));
        this.f404361l = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new k(this));
        this.f404362m = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new l(this));
        this.f404363n = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new m(this));
        registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new n(this));
    }

    public final void T90() {
        if (S90() == false) goto L27;
        b r100 = null;
        b r101 = null;
        o r102 = null;
        if (Build.VERSION.SDK_INT >= 23) goto L7;
        b r103 = this.f404355f;
        if (r103 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("task");
    L25:
        r100.finish();
        return;
    L24:
        r100 = r103;
        goto L25
    L7:
        if (Settings.canDrawOverlays(requireContext()) == false) goto L13;
        b r104 = this.f404355f;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("task");
    L12:
        r101.finish();
        return;
    L11:
        r101 = r104;
        goto L12
    L13:
        o r105 = this.f404354e;
        if (r105 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("pb");
        r105 = null;
    L16:
        r105.getClass();
        o r106 = this.f404354e;
        if (r106 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("pb");
    L20:
        r102.getClass();
        return;
    L19:
        r102 = r106;
        goto L20
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        if (S90() == false) goto L9;
        o r100 = this.f404354e;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("pb");
        r100 = null;
    L7:
        r100.getClass();
        return;
    }

    public final void U90(final Function0<Unit> r100) {
        this.f404353d.post(new e(r100));
    }
}
