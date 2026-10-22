package com.larus.dora.impl.util;

import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.common_ui.dialog.CommonDialog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes27.dex */
public final class DoraConnectChecker {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f338094e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f338095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ActivityResultLauncher<Intent> f338096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CommonDialog f338097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f338098d;

    public static final class a {
    }

    static {
    }

    public DoraConnectChecker(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f338095a = r100;
        this.f338098d = new i();
    }

    public final void a(String r110, String r111, Function0<Unit> r112) {
        g49.d.d("DoraConnectChecker", "checkReady: " + r110 + " start");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.f338095a), null, null, new DoraConnectChecker$checkReady$1(r110, r112, this, r111, null), 3, null);
    }
}
