package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.model.GXScroll;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larksuite.framework.ui.StableLinearLayoutManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.MmSubtitleScrollMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001/B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0017H\u0002J\u0018\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0006\u0010 \u001a\u00020\u0015J\b\u0010!\u001a\u00020\u0015H\u0002J\b\u0010\"\u001a\u00020\u0015H\u0002J\u0010\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u000fH\u0002J\u0018\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u001eH\u0016J \u0010'\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u001eH\u0016J\b\u0010*\u001a\u00020+H\u0002J\u0018\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020\u0017H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleScrollHelper;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "backToBottomView", "Landroid/view/View;", "stackFromEndController", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleStackFromEndController;", "callback", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleScrollHelper$Callback;", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/LinearLayoutManager;Landroid/view/View;Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleStackFromEndController;Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleScrollHelper$Callback;)V", "scrollMode", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/MmSubtitleScrollMode;", "adapterDataObserver", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "getAdapterDataObserver", "()Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "initListeners", "", "pendingRecheckSource", "", "itemHeightRecheckRunnable", "Ljava/lang/Runnable;", "scheduleItemHeightRecheck", "source", "handleItemRangeInserted", "positionStart", "", "itemCount", "scrollToBottomOnInitialized", "scrollToBottom", "scrollToBottomInternal", "setScrollMode", "mode", GXScroll.TYPE_ON_SCROLL_STATE_CHANGED, "newState", GXScroll.TYPE_ON_SCROLLED, "dx", "dy", "isReachBottom", "", "updateFloatingViews", "showBackToBottom", "from", "Callback", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmSubtitleScrollHelper extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f436478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayoutManager f436479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f436480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w f436481d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f436482e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MmSubtitleScrollMode f436483f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MmSubtitleScrollHelper$adapterDataObserver$1 f436484g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f436485h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final u f436486i;

    public interface a {
        void a();

        void b(MmSubtitleScrollMode r100);

        void c();
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MmSubtitleScrollHelper f436488a;

        public b(MmSubtitleScrollHelper r100) {
            this.f436488a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f436488a.m();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final boolean k() {
        int r100 = this.f436479b.findLastCompletelyVisibleItemPosition();
        if (r100 >= 0) goto L5;
        return false;
    L5:
        if (this.f436479b.getChildCount() != 0) goto L8;
        return false;
    L8:
        if (r100 < (this.f436479b.getItemCount() - 1)) goto L12;
        return true;
    L12:
        return false;
    }

    public final void l() {
        n(MmSubtitleScrollMode.FOLLOW);
        this.f436481d.e(false, "scrollToBottom");
        this.f436478a.stopScroll();
        this.f436478a.postDelayed(new b(this), 20);
        o(false);
    }

    public final void m() {
        if (this.f436479b.getItemCount() <= 0) goto L6;
        LinearLayoutManager r100 = this.f436479b;
        r100.scrollToPositionWithOffset(r100.getItemCount() - 1, 0);
        return;
    }

    public final void n(MmSubtitleScrollMode r100) {
        if (this.f436483f == r100) goto L6;
        this.f436483f = r100;
        this.f436482e.b(r100);
        int r101 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.SUBTITLE, "setScrollMode", "mode=" + r100, null, 8);
        return;
    }

    public final void o(boolean r100) {
        View r101 = this.f436480c;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public static final void j(MmSubtitleScrollHelper r100, String r101) {
        if (r100.f436483f == MmSubtitleScrollMode.FOLLOW) goto L5;
        return;
    L5:
        if (r100.f436481d.f436541e == true) goto L10;
        r100.f436485h = r101;
        r100.f436478a.removeCallbacks(r100.f436486i);
        r100.f436478a.post(r100.f436486i);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onScrollStateChanged(r100, r101);
        if (r101 != 1) goto L13;
        this.f436482e.c();
        MmSubtitleScrollMode r102 = this.f436483f;
        MmSubtitleScrollMode r103 = MmSubtitleScrollMode.FREE;
        if (r102 == r103) goto L13;
        n(r103);
        if (this.f436479b.getItemCount() > 0) goto L9;
    L11:
        boolean r104 = false;
    L12:
        o(r104);
        goto L13
    L9:
        if (k() == true) goto L11;
        r104 = true;
    L13:
        int r105 = this.f436479b.findFirstVisibleItemPosition();
        if (r105 == 0) goto L17;
        if (r105 == 1) goto L17;
        return;
    L17:
        this.f436482e.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onScrolled(r100, r101, r102);
        if (this.f436479b.getItemCount() > 0) goto L5;
        return;
    L5:
        if (k() == false) goto L11;
        MmSubtitleScrollMode r103 = this.f436483f;
        MmSubtitleScrollMode r104 = MmSubtitleScrollMode.FOLLOW;
        if (r103 == r104) goto L9;
        n(r104);
        this.f436481d.e(false, "onScrolledToBottom");
    L9:
        o(false);
        return;
    L11:
        if (this.f436483f != MmSubtitleScrollMode.FREE) goto L16;
        o(true);
        return;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui.MmSubtitleScrollHelper$adapterDataObserver$1] */
    public MmSubtitleScrollHelper(RecyclerView r100, StableLinearLayoutManager r101, UDShadowLayout r102, w r103, n r104) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "layoutManager");
        Intrinsics.checkNotNullParameter(r102, "backToBottomView");
        Intrinsics.checkNotNullParameter(r103, "stackFromEndController");
        Intrinsics.checkNotNullParameter(r104, "callback");
        this.f436478a = r100;
        this.f436479b = r101;
        this.f436480c = r102;
        this.f436481d = r103;
        this.f436482e = r104;
        this.f436483f = MmSubtitleScrollMode.FOLLOW;
        this.f436484g = new MmSubtitleScrollHelper$adapterDataObserver$1(this);
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h.a(r102, new MmSubtitleScrollHelper$initListeners$1(this));
        this.f436486i = new u(this);
    }
}
