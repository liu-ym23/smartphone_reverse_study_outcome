package com.larus.bmhome.chat.component.camera;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.internal.attach.FragmentAttachExtKt;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.larus.utils.logger.FLogger;
import de8.c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import s1a.a;
import t1a.b;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0017J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/chat/component/camera/CameraInputFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "cameraContainer", "Lcom/larus/ui/arch/component/external/api/receiver/Container;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", LiveCommonConstants.REASON_ON_DEDTROY, "attachComponents", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraInputFragment extends Fragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f300541d = 0;

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        z2.f365865a.w3();
        FragmentActivity r100 = getActivity();
        if ((r100 instanceof AppCompatActivity) == false) goto L5;
        AppCompatActivity r101 = (AppCompatActivity) r100;
    L6:
        if (r101 == null) goto L11;
        AppCompatDelegate r102 = r101.getDelegate();
        if (r102 == null) goto L12;
        r102.setLocalNightMode(AppCompatDelegate.getDefaultNightMode());
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public CameraInputFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        z2.f365865a.w3();
        FragmentActivity r101 = getActivity();
        if ((r101 instanceof AppCompatActivity) == false) goto L5;
        AppCompatActivity r102 = (AppCompatActivity) r101;
    L6:
        if (r102 == null) goto L10;
        AppCompatDelegate r103 = r102.getDelegate();
        if (r103 == null) goto L10;
        r103.setLocalNightMode(2);
    L10:
        b r104 = a.g(this);
        c r105 = c.f468084s;
        r104.n(c.a.a(getArguments()), c.class);
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L13
        FragmentAttachExtKt.b(this, ContainerFilter.INPUT_ONLY);     // Catch: Throwable -> L13
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L19;
        FLogger.f375446a.e("CameraInputFragment", "build container error ,info is ", r108);
    L19:
        k1a.b.a(this, new od8.a(this));
        return;
    L13:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.larus_layout_camera_input_view, r101, false);
        ViewStub r104 = (ViewStub) r103.findViewById(R.id.input_delegate);
        InputViewCreatorDelegate r105 = InputViewCreatorDelegate.f298409b;
        Intrinsics.checkNotNull(r104);
        r105.a(r104, Integer.valueOf(R.id.input_delegate));
        z2.f365865a.w3();
        return r103;
    }
}
