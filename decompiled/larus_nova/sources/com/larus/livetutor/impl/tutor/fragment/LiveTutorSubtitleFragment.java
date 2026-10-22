package com.larus.livetutor.impl.tutor.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.livetutor.impl.base.LiveTutorBaseFragment;
import com.larus.livetutor.impl.databinding.FragmentLiveTutorSubtitleLayoutBinding;
import com.larus.livetutor.impl.tutor.controller.LiveTutorSubtitleControllerV2;
import com.larus.livetutor.impl.utils.UtilsKt;
import com.larus.livetutor.impl.utils.d;
import com.larus.livetutor.impl.utils.track.LiveTutorTrackerService;
import com.larus.nova.R;
import com.larus.platform.service.e2;
import com.larus.utils.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import pj9.j;
import pj9.k;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0004()*+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0014J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016J \u0010\"\u001a\u00020!2\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00120$2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\b\u0010%\u001a\u00020!H\u0016J\b\u0010&\u001a\u00020!H\u0002J\b\u0010'\u001a\u00020!H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0018\u00010\u000fR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/larus/livetutor/impl/tutor/fragment/LiveTutorSubtitleFragment;", "Lcom/larus/livetutor/impl/base/LiveTutorBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/livetutor/impl/databinding/FragmentLiveTutorSubtitleLayoutBinding;", "fragmentLayoutId", "", "viewModel", "Lcom/larus/livetutor/impl/repository/viewmodel/LiveTutorViewModel;", "getViewModel", "()Lcom/larus/livetutor/impl/repository/viewmodel/LiveTutorViewModel;", "setViewModel", "(Lcom/larus/livetutor/impl/repository/viewmodel/LiveTutorViewModel;)V", "subtitleAdapter", "Lcom/larus/livetutor/impl/tutor/fragment/LiveTutorSubtitleFragment$SubtitleAdapter;", "subtitleData", "", "Lcom/larus/livetutor/impl/tutor/controller/LiveTutorSubtitleControllerV2$Part;", "partInTutorIdx", "", "showAnim", "Landroid/animation/AnimatorSet;", "dismissAnim", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "initView", "", "setSubtitleData", "data", "", WidgetCostModule.TYPE_ON_START, "handleCloseFragment", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "SubtitleViewHolder", "FooterViewHolder", "SubtitleAdapter", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LiveTutorSubtitleFragment extends LiveTutorBaseFragment {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f356572m = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FragmentLiveTutorSubtitleLayoutBinding f356573g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SubtitleAdapter f356574h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<LiveTutorSubtitleControllerV2.Part> f356575i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f356576j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public AnimatorSet f356577k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AnimatorSet f356578l;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/livetutor/impl/tutor/fragment/LiveTutorSubtitleFragment$FooterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/livetutor/impl/tutor/fragment/LiveTutorSubtitleFragment;Landroid/view/View;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class FooterViewHolder extends RecyclerView.ViewHolder {
        public FooterViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/livetutor/impl/tutor/fragment/LiveTutorSubtitleFragment$SubtitleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "data", "", "Lcom/larus/livetutor/impl/tutor/controller/LiveTutorSubtitleControllerV2$Part;", "<init>", "(Lcom/larus/livetutor/impl/tutor/fragment/LiveTutorSubtitleFragment;Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "getItemViewType", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class SubtitleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<LiveTutorSubtitleControllerV2.Part> f356579a;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return this.f356579a.size() + 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int r100) {
            if (r100 != this.f356579a.size()) goto L5;
            return 1;
        L5:
            return 0;
        }

        public SubtitleAdapter(LiveTutorSubtitleFragment r100, List<LiveTutorSubtitleControllerV2.Part> r101) {
            Intrinsics.checkNotNullParameter(r101, "data");
            this.f356579a = r101;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "holder");
            if ((r100 instanceof SubtitleViewHolder) == false) goto L14;
            LiveTutorSubtitleControllerV2.Part r102 = (LiveTutorSubtitleControllerV2.Part) ListProtector.get(this.f356579a, r101);
            CustomMarkdownTextView r103 = ((SubtitleViewHolder) r100).f356580a;
            r103.setMarkdownWidth(i.d(UtilsKt.c()) - (i5.W() * 2));
            if (r102.isAsr() == false) goto L7;
            int r104 = ContextCompat.getColor(r103.getContext(), R.color.live_tutor_subtitle_asr);
        L8:
            r103.setTextColor(r104);
            if (r102.isAsr() == false) goto L11;
            float r105 = 15.0f;
        L12:
            r103.setTextSize(1, r105);
            TextViewCompat.setLineHeight(r103, i5.E());
            UtilsKt.k(r103, r102.getCurrentContent());
            return;
        L11:
            r105 = 16.0f;
            goto L12
        L7:
            r104 = ContextCompat.getColor(r103.getContext(), R.color.black);
            goto L8
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            if (r101 != 0) goto L5;
            View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.live_tutor_subtitle_item_layout, r100, false);
            Intrinsics.checkNotNull(r102);
            return new SubtitleViewHolder(r102);
        L5:
            View r103 = new View(r100.getContext());
            r103.setLayoutParams(new RecyclerView.LayoutParams(1, c7.b(142)));
            return new FooterViewHolder(r103);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/larus/livetutor/impl/tutor/fragment/LiveTutorSubtitleFragment$SubtitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/livetutor/impl/tutor/fragment/LiveTutorSubtitleFragment;Landroid/view/View;)V", "content", "Lcom/larus/bmhome/view/textview/impl/CustomMarkdownTextView;", "getContent", "()Lcom/larus/bmhome/view/textview/impl/CustomMarkdownTextView;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class SubtitleViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CustomMarkdownTextView f356580a;

        public SubtitleViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f356580a = (CustomMarkdownTextView) r100.findViewById(R.id.content);
        }
    }

    public static final class a {
    }

    public static final class b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveTutorSubtitleFragment f356581a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
        }

        public b(LiveTutorSubtitleFragment r100) {
            this.f356581a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            FragmentLiveTutorSubtitleLayoutBinding r101 = this.f356581a.f356573g;
            String r102 = null;
            if (r101 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r101 = null;
        L5:
            TextView r103 = r101.f355918b;
            Context r104 = this.f356581a.getContext();
            if (r104 == null) goto L8;
            r102 = r104.getString(R.string.larus_tutor_back_session_cn);
        L8:
            r103.setText(r102);
        }
    }

    public static final class c implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveTutorSubtitleFragment f356582a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        public c(LiveTutorSubtitleFragment r100) {
            this.f356582a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            FragmentLiveTutorSubtitleLayoutBinding r101 = this.f356582a.f356573g;
            if (r101 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r101 = null;
        L5:
            r101.f355918b.setText("");
        }
    }

    static {
    }

    @Override // com.larus.livetutor.impl.base.BaseFragment
    public final void S90() {
    }

    @Override // com.larus.livetutor.impl.base.BaseFragment
    public final void initView() {
        FragmentLiveTutorSubtitleLayoutBinding r100 = this.f356573g;
        FragmentLiveTutorSubtitleLayoutBinding r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r100 = null;
    L5:
        ConstraintLayout r102 = r100.f355921e;
        Intrinsics.checkNotNull(r102);
        UtilsKt.r(r102);
        int r103 = d.f356670a;
        r102.setBackground(d.a(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{ColorProtector.parseColor("#E9F7F7"), ColorProtector.parseColor("#E9F7F7"), ColorProtector.parseColor("#E0EEFF"), ColorProtector.parseColor("#E0E3FF"), ColorProtector.parseColor("#E0E3FF")}));
        FragmentLiveTutorSubtitleLayoutBinding r104 = this.f356573g;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r104 = null;
    L8:
        TextView r105 = r104.f355918b;
        Drawable r106 = ContextCompat.getDrawable(r105.getContext(), R.drawable.live_tutor_subtile_back);
        if (r106 == null) goto L11;
        r106.setBounds(new Rect(0, 0, i5.q(), i5.q()));
        r105.setCompoundDrawables(r106, null, null, null);
    L11:
        r105.setCompoundDrawablePadding(i5.Y());
        FragmentLiveTutorSubtitleLayoutBinding r107 = this.f356573g;
        if (r107 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r107 = null;
    L14:
        UtilsKt.h(r107.f355919c, new j(this));
        FragmentLiveTutorSubtitleLayoutBinding r108 = this.f356573g;
        if (r108 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r108 = null;
    L17:
        final RecyclerView r109 = r108.f355922f;
        r109.setLayoutManager(new LinearLayoutManager(r109.getContext()));
        SubtitleAdapter r110 = new SubtitleAdapter(this, this.f356575i);
        this.f356574h = r110;
        r109.setAdapter(r110);
        r109.addItemDecoration(new LiveTutorSubtitleFragment$initView$4$1());
        r109.addOnScrollListener(new LiveTutorSubtitleFragment$initView$4$2(this));
        r109.post(new k(r109, this));
        FragmentLiveTutorSubtitleLayoutBinding r111 = this.f356573g;
        if (r111 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r111 = null;
    L20:
        r111.f355924h.setBackground(d.a(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{ColorProtector.parseColor("#E9F7F7"), 0}));
        FragmentLiveTutorSubtitleLayoutBinding r112 = this.f356573g;
        if (r112 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L24:
        r101.f355920d.setBackground(d.a(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{ColorProtector.parseColor("#00E0E3FF"), ColorProtector.parseColor("#CCE0E3FF"), ColorProtector.parseColor("#EBE0E3FF"), ColorProtector.parseColor("#E0E3FF"), ColorProtector.parseColor("#E0E3FF")}));
        return;
    L23:
        r101 = r112;
        goto L24
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        kj9.b.a("[LiveTutorSubtitleFragment] onDestroy");
        super.onDestroy();
        AnimatorSet r100 = this.f356577k;
        if (r100 == null) goto L5;
        r100.removeAllListeners();
    L5:
        AnimatorSet r101 = this.f356577k;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        this.f356577k = null;
        AnimatorSet r102 = this.f356578l;
        if (r102 == null) goto L11;
        r102.removeAllListeners();
    L11:
        AnimatorSet r103 = this.f356578l;
        if (r103 == null) goto L14;
        r103.cancel();
    L14:
        this.f356578l = null;
        LiveTutorTrackerService r104 = kj9.b.c();
        if (r104 == null) goto L20;
        List r105 = CollectionsKt.listOf("sub_page_name");
        Intrinsics.checkNotNullParameter(r105, "keys");
        Iterator r106 = r105.iterator();
    L18:
        if (r106.hasNext() == false) goto L22;
        String r107 = (String) r106.next();
        ((ConcurrentHashMap) r104.f356687a).remove(r107);
        goto L18
    L22:
        return;
    }

    public LiveTutorSubtitleFragment() {
        this.f356575i = new ArrayList();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        kj9.b.a("[LiveTutorSubtitleFragment] onStart");
        LiveTutorTrackerService r100 = kj9.b.c();
        FragmentLiveTutorSubtitleLayoutBinding r101 = null;
        if (r100 == null) goto L5;
        r100.d(MapsKt.mapOf(TuplesKt.to("sub_page_name", "subtitle_page")), null);
    L5:
        LiveTutorTrackerService r102 = kj9.b.c();
        if (r102 == null) goto L8;
        long r103 = this.f356576j;
        JSONObject r104 = new JSONObject();
        r104.put("sub_page_name", "subtitle_page");
        r104.put("part_in_tutor_idx", r103);
        Unit r105 = Unit.INSTANCE;
        LiveTutorTrackerService.b(r102, "live_tutor_enter_sub_page", r104, 4);
    L8:
        LiveTutorTrackerService r106 = kj9.b.c();
        if (r106 == null) goto L12;
        com.larus.livetutor.impl.utils.track.a.b(r106, "subtitle", null, null, null, null, "subtitle_page", 30);
    L12:
        if (this.f356577k != null) goto L43;
        FragmentLiveTutorSubtitleLayoutBinding r107 = this.f356573g;
        if (r107 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r107 = null;
    L16:
        ObjectAnimator r108 = ObjectAnimator.ofFloat(r107.f355921e, View.ALPHA, new float[]{0.0f, 1.0f});
        FragmentLiveTutorSubtitleLayoutBinding r109 = this.f356573g;
        if (r109 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r109 = null;
    L19:
        ObjectAnimator r110 = ObjectAnimator.ofFloat(r109.f355922f, View.TRANSLATION_Y, new float[]{i5.d(), 0.0f});
        if (e2.f365734a.isPad() == false) goto L22;
        final int r111 = c7.b(306);
    L42:
        ValueAnimator r112 = ValueAnimator.ofInt(new int[]{i5.d(), r111});
        r112.addUpdateListener(new pj9.i(this, r111));
        AnimatorSet r113 = new AnimatorSet();
        r113.setDuration(250);
        r113.playTogether(new Animator[]{r108, r110, r112});
        r113.addListener(new c(this));
        r113.addListener(new b(this));
        this.f356577k = r113;
        goto L43
    L22:
        FragmentLiveTutorSubtitleLayoutBinding r114 = this.f356573g;
        if (r114 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r114 = null;
    L25:
        Integer r115 = Integer.valueOf(r114.f355919c.getMeasuredWidth());
        if (r115.intValue() <= 0) goto L28;
        boolean r116 = true;
    L29:
        if (r116 == true) goto L32;
        r115 = null;
    L32:
        if (r115 == null) goto L34;
        r111 = r115.intValue();
        goto L42
    L34:
        FragmentLiveTutorSubtitleLayoutBinding r117 = this.f356573g;
        if (r117 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r117 = null;
    L37:
        r117.f355919c.measure(0, 0);
        FragmentLiveTutorSubtitleLayoutBinding r118 = this.f356573g;
        if (r118 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L41:
        r111 = r101.f355919c.getMeasuredWidth();
        goto L42
    L40:
        r101 = r118;
        goto L41
    L28:
        r116 = false;
    L43:
        AnimatorSet r119 = this.f356577k;
        if (r119 == null) goto L47;
        r119.start();
        return;
    }

    @Override // com.larus.livetutor.impl.base.BaseFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r113 = r110.inflate(R.layout.fragment_live_tutor_subtitle_layout, r111, false);
        int r114 = R.id.back;
        TextView r100 = (TextView) ViewBindings.findChildViewById(r113, R.id.back);
        if (r100 == null) goto L23;
        r114 = R.id.back_container;
        FrameLayout r101 = (FrameLayout) ViewBindings.findChildViewById(r113, R.id.back_container);
        if (r101 == null) goto L23;
        r114 = R.id.bottom_mask;
        View r102 = ViewBindings.findChildViewById(r113, R.id.bottom_mask);
        if (r102 == null) goto L23;
        ConstraintLayout r115 = (ConstraintLayout) r113;
        RecyclerView r103 = (RecyclerView) ViewBindings.findChildViewById(r113, R.id.subtitle_list);
        if (r103 == null) goto L21;
        FrameLayout r104 = (FrameLayout) ViewBindings.findChildViewById(r113, R.id.subtitle_list_layout);
        if (r104 != null) goto L13;
        r114 = R.id.subtitle_list_layout;
        goto L23
    L13:
        if (((TextView) ViewBindings.findChildViewById(r113, R.id.title)) == null) goto L19;
        View r105 = ViewBindings.findChildViewById(r113, R.id.top_mask);
        if (r105 == null) goto L18;
        this.f356573g = new FragmentLiveTutorSubtitleLayoutBinding(r115, r100, r101, r102, r115, r103, r104, r105);
        return r115;
    L18:
        r114 = R.id.top_mask;
        goto L23
    L19:
        r114 = R.id.title;
        goto L23
    L21:
        r114 = R.id.subtitle_list;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r114)));
    }
}
