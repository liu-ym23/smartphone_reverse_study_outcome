package com.larus.office.plugins.slides.media.imggen;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0015\u001a\u00020\bH\u0002R\"\u0010\u0004\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000RB\u0010\t\u001a6\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/office/plugins/slides/media/imggen/AIGenerateImageBridgeFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "onLaunch", "Lkotlin/Function1;", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "", "onResult", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "resultCode", "data", "launcher", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", WidgetCostModule.TYPE_ON_START, "detachSelf", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIGenerateImageBridgeFragment extends Fragment {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Function1<? super ActivityResultLauncher<Intent>, Unit> f363277g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Function2<? super Integer, ? super Intent, Unit> f363278h;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super ActivityResultLauncher<Intent>, Unit> f363279d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function2<? super Integer, ? super Intent, Unit> f363280e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ActivityResultLauncher<Intent> f363281f;

    public static final class a {
    }

    static {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        ActivityResultLauncher<Intent> r100 = this.f363281f;
        if (r100 == null) goto L9;
        Function1<? super ActivityResultLauncher<Intent>, Unit> r101 = this.f363279d;
        if (r101 == null) goto L7;
        r101.invoke(r100);
    L7:
        this.f363279d = null;
        return;
    }

    public AIGenerateImageBridgeFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f363279d = f363277g;
        this.f363280e = f363278h;
        f363277g = null;
        f363278h = null;
        this.f363281f = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new b(this));
    }
}
