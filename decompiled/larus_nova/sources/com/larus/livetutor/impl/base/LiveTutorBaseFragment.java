package com.larus.livetutor.impl.base;

import android.os.Bundle;
import android.view.View;
import ej9.j;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/larus/livetutor/impl/base/LiveTutorBaseFragment;", "Lcom/larus/livetutor/impl/base/BaseFragment;", "<init>", "()V", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", "onClose", "Lkotlin/Function0;", "", "getOnClose", "()Lkotlin/jvm/functions/Function0;", "setOnClose", "(Lkotlin/jvm/functions/Function0;)V", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "isOutside", "", "event", "Landroid/view/MotionEvent;", "interceptTouchEvent", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class LiveTutorBaseFragment extends BaseFragment {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f355892f = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f355893d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f355894e;

    public static final class a {
    }

    static {
    }

    public LiveTutorBaseFragment() {
        this.f355894e = new j();
    }

    @Override // com.larus.livetutor.impl.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f355893d = r100;
        super.onViewCreated(r100, r101);
        r100.setTag("LIVE_TUTOR_FRAGMENT");
    }
}
