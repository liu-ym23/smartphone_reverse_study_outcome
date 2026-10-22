package com.larus.uaigc.createpage.component.helper;

import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.a1;

/* JADX INFO: loaded from: classes31.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f371584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super List<? extends Uri>, Unit> f371585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f371586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f371587d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f371588e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, ? extends Object> f371589f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableSharedFlow<b> f371590g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a1 f371591h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ActivityResultLauncher<String> f371592i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ActivityResultLauncher<Intent> f371593j;

    public static final class a {
    }

    static {
    }

    public f(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f371584a = r100;
        this.f371586c = 1;
        this.f371587d = 1;
        MutableSharedFlow<b> r101 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.f371590g = r101;
        this.f371591h = kotlinx.coroutines.flow.e.a(r101);
        this.f371592i = r100.registerForActivityResult(new ActivityResultContracts.GetMultipleContents(), new d(this));
        this.f371593j = r100.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new e(this));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r100), null, null, new VideoEditorPickPhotoHelper$initObservers$1(this, null), 3, null);
    }
}
