package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000¡\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0018\u0018\u0000 L2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001LBc\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r\u0012\u001e\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010(\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010)\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 H\u0016J \u0010*\u001a\u00020\u000f2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000e0,2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010'J\u000e\u0010.\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\"J\u0014\u00100\u001a\u00020\u000f2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\"0%J\u0010\u00102\u001a\u00020\"2\u0006\u00103\u001a\u00020\u0012H\u0016J\u0018\u00104\u001a\u00020\u00022\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0012H\u0016J\u0018\u00108\u001a\u00020\u000f2\u0006\u00109\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u0012H\u0016J&\u00108\u001a\u00020\u000f2\u0006\u00109\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u00122\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;H\u0016J\u0010\u0010=\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u0012H\u0016J\b\u0010>\u001a\u00020\u0012H\u0016J\u0010\u0010?\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u0012H\u0002J\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u000e0,J\u0018\u0010A\u001a\u00020\u000f2\u0006\u00109\u001a\u00020B2\u0006\u00103\u001a\u00020\u0012H\u0002J\u0017\u0010C\u001a\u00020\u000f2\b\u0010/\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0002\u0010DJ\u0010\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u000eH\u0002J\u0018\u0010H\u001a\u00020\u00142\u0006\u0010I\u001a\u00020\u000e2\u0006\u0010J\u001a\u00020\u000eH\u0002J\u0018\u0010K\u001a\u00020\u00142\u0006\u0010I\u001a\u00020\u000e2\u0006\u0010J\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u001c\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u001c*\u0004\u0018\u00010\u000e0\u000e0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0004\n\u0002\u0010#R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "recordingSessionId", "", "uccApi", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;", "meetingId", "uiLaunchMode", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onEditSpeakerClick", "Lkotlin/Function1;", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/subtitle/MmSubtitleItem;", "", "onSubtitleLongClick", "Lkotlin/Function3;", "", "Landroid/view/View;", "", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/officesdk/minutes/service/foundation/userscope/IMinutesUCC;Ljava/lang/String;Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)V", "diffCallback", "com/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleAdapter$diffCallback$1", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleAdapter$diffCallback$1;", "mDiffer", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", "firstSubtitleItemTopMargin", "subtitleItemTopMargin", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "highlightedSegId", "", "Ljava/lang/Long;", "selectedSegIds", "", "clearHighlightRunnable", "Ljava/lang/Runnable;", "onAttachedToRecyclerView", "onDetachedFromRecyclerView", "submitList", "list", "", "commitCallback", "highlightSubtitle", "segId", "updateSelectedSegIds", "segIds", "getItemId", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "payloads", "", "", "getItemViewType", "getItemCount", "getItem", "currentItems", "applyNormalItemTopMargin", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleNormalContentViewHolder;", "notifyHighlightChanged", "(Ljava/lang/Long;)V", "resolveHighlightStyle", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/subtitle/ui/MmSubtitleHighlightStyle;", MapController.ITEM_LAYER_TAG, "isSpeakerDisplayChanged", "oldItem", "newItem", "isSpeakerAvatarChanged", "Companion", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmSubtitleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f436394o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f436395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f436396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f436397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MmRecordingUILaunchMode f436398d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LifecycleOwner f436399e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h, Unit> f436400f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function3<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h, Integer, View, Boolean> f436401g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AsyncListDiffer<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h> f436402h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f436403i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f436404j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RecyclerView f436405k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Long f436406l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Set<Long> f436407m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public f f436408n;

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f436402h.getCurrentList().size();
    }

    public final MmSubtitleHighlightStyle A2(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h r100) {
        if (this.f436407m.contains(Long.valueOf(r100.f435222a)) == true) goto L13;
        long r101 = r100.f435222a;
        Long r102 = this.f436406l;
        if (r102 == null) goto L12;
        if (r101 != r102.longValue()) goto L12;
        return MmSubtitleHighlightStyle.JUMP;
    L12:
        return MmSubtitleHighlightStyle.NONE;
    L13:
        return MmSubtitleHighlightStyle.SELECTED;
    }

    public final void B2(Set<Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "segIds");
        Set<Long> r101 = this.f436407m;
        if (Intrinsics.areEqual(r101, r100) == false) goto L5;
        return;
    L5:
        this.f436407m = r100;
        Iterator r102 = SetsKt.plus(r101, r100).iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        z2((Long) r102.next());
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        return y2(r100).f435222a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (y2(r100).f435233l == false) goto L5;
        return 2;
    L5:
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onAttachedToRecyclerView(r100);
        this.f436405k = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onDetachedFromRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        f r101 = this.f436408n;
        if (r101 == null) goto L5;
        r100.removeCallbacks(r101);
    L5:
        this.f436408n = null;
        this.f436405k = null;
        super.onDetachedFromRecyclerView(r100);
    }

    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h y2(int r100) {
        return (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h) ListProtector.get(this.f436402h.getCurrentList(), r100);
    }

    public final void z2(Long r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h> r101 = this.f436402h.getCurrentList().iterator();
        int r102 = 0;
    L6:
        if (r101.hasNext() == false) goto L14;
        if (r101.next().f435222a != r100.longValue()) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == true) goto L15;
        r102 = r102 + 1;
    L15:
        if (r102 < 0) goto L30;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h r104 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h) ListProtector.get(this.f436402h.getCurrentList(), r102);
        Intrinsics.checkNotNull(r104);
        MmSubtitleHighlightStyle r105 = A2(r104);
        RecyclerView r106 = this.f436405k;
        if (r106 == null) goto L19;
        RecyclerView.ViewHolder r107 = r106.findViewHolderForAdapterPosition(r102);
    L21:
        if ((r107 instanceof MmSubtitleNormalContentViewHolder) == false) goto L24;
        MmSubtitleNormalContentViewHolder r108 = (MmSubtitleNormalContentViewHolder) r107;
        r108.getClass();
        Intrinsics.checkNotNullParameter(r104, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r105, "highlightStyle");
        r108.f436455w = r104;
        r108.V3(r104, r105);
        return;
    L24:
        if ((r107 instanceof MmSubtitlePureContentViewHolder) == false) goto L26;
        MmSubtitlePureContentViewHolder r109 = (MmSubtitlePureContentViewHolder) r107;
        r109.getClass();
        Intrinsics.checkNotNullParameter(r104, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r105, "highlightStyle");
        r109.f436475g = r104;
        r109.T3(r104, r105);
        return;
    L26:
        notifyItemChanged(r102, MmSubtitlePayload.HIGHLIGHT);
        return;
    L19:
        r107 = null;
        goto L21
    L30:
        return;
    L10:
        r103 = false;
        goto L11
    L14:
        r102 = -1;
        goto L15
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h r102 = y2(r101);
        if ((r100 instanceof MmSubtitleNormalContentViewHolder) == false) goto L13;
        MmSubtitleNormalContentViewHolder r103 = (MmSubtitleNormalContentViewHolder) r100;
        if (r101 != 0) goto L7;
        int r104 = this.f436403i;
    L8:
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h.b(r103.itemView, null, Integer.valueOf(r104), 13);
        MmSubtitleHighlightStyle r105 = A2(r102);
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r105, "highlightStyle");
        r103.f436455w = r102;
        r103.T3(r102);
        TextView r106 = r103.f436435c.f516103i;
        int r107 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.c.f434036a;
        MmSubtitleNormalContentViewHolder.Z3(r106, com.ss.android.lark.officesdk.minutes.service.foundation.utils.c.a(r102.f435224c));
        r103.W3(r102, true);
        r103.U3(r102);
        Drawable r108 = r103.f436435c.f516102h.getBackground();
        Drawable r109 = r103.f436450r;
        if (r108 == r109) goto L11;
        r103.f436435c.f516102h.setBackground(r109);
    L11:
        r103.V3(r102, r105);
        r103.X3(r102);
        return;
    L7:
        r104 = this.f436404j;
        goto L8
    L13:
        if ((r100 instanceof MmSubtitlePureContentViewHolder) == false) goto L17;
        MmSubtitlePureContentViewHolder r110 = (MmSubtitlePureContentViewHolder) r100;
        MmSubtitleHighlightStyle r111 = A2(r102);
        r110.getClass();
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r111, "highlightStyle");
        r110.f436475g = r102;
        r110.T3(r102, r111);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "parent");
        LayoutInflater r100 = LayoutInflater.from(com.ss.android.lark.officesdk.minutes.ui.style.c.c(r110.getContext(), this.f436398d));
        if (r111 != 1) goto L5;
        com.ss.android.lark.officesdk.minutes.ui.style.e r112 = com.ss.android.lark.officesdk.minutes.ui.style.e.f436896a;
        MmRecordingUILaunchMode r101 = this.f436398d;
        r112.getClass();
        com.ss.android.lark.officesdk.minutes.ui.style.contract.f r113 = com.ss.android.lark.officesdk.minutes.ui.style.e.b(r101).getLayout();
        Intrinsics.checkNotNull(r100);
        mwb.j r102 = r113.p(r100, r110);
        uvb.b.b(r102.f516095a);
        return new MmSubtitleNormalContentViewHolder(this.f436395a, this.f436396b, r102, this.f436397c, this.f436399e, this.f436400f, this.f436401g);
    L5:
        if (r111 == 2) goto L7;
        final FrameLayout r114 = new FrameLayout(r110.getContext());
        return new AnonymousClass1(r114);
    L7:
        com.ss.android.lark.officesdk.minutes.ui.style.e r115 = com.ss.android.lark.officesdk.minutes.ui.style.e.f436896a;
        MmRecordingUILaunchMode r103 = this.f436398d;
        r115.getClass();
        com.ss.android.lark.officesdk.minutes.ui.style.contract.f r116 = com.ss.android.lark.officesdk.minutes.ui.style.e.b(r103).getLayout();
        Intrinsics.checkNotNull(r100);
        mwb.k r117 = r116.f(r100, r110);
        uvb.b.b(r117.f516107a);
        return new MmSubtitlePureContentViewHolder(r117, this.f436401g);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.util.ArrayList] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List<Object> r110) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r110, "payloads");
        if (r110.isEmpty() == false) goto L6;
        onBindViewHolder(r100, r101);
        return;
    L6:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h r102 = y2(r101);
        ArrayList r103 = new ArrayList();
        Iterator r111 = r110.iterator();
    L8:
        if (r111.hasNext() == false) goto L22;
        Object r104 = r111.next();
        if ((r104 instanceof Set) == false) goto L18;
        ?? r105 = new ArrayList();
        Iterator r106 = ((Iterable) r104).iterator();
    L13:
        if (r106.hasNext() == false) goto L21;
        Object r107 = r106.next();
        if ((r107 instanceof MmSubtitlePayload) == false) goto L13;
        r105.add(r107);
    L21:
        CollectionsKt.addAll(r103, (Iterable) r105);
        goto L8
    L18:
        if ((r104 instanceof MmSubtitlePayload) == false) goto L20;
        r105 = CollectionsKt.listOf(r104);
        goto L21
    L20:
        r105 = CollectionsKt.emptyList();
        goto L21
    L22:
        Set r112 = CollectionsKt.toSet(r103);
        if (r112.isEmpty() == false) goto L27;
        onBindViewHolder(r100, r101);
        return;
    L27:
        if ((r100 instanceof MmSubtitleNormalContentViewHolder) == false) goto L51;
        MmSubtitleNormalContentViewHolder r108 = (MmSubtitleNormalContentViewHolder) r100;
        if (r101 != 0) goto L31;
        int r109 = this.f436403i;
    L32:
        com.ss.android.lark.officesdk.minutes.ui.foundation.widget.h.b(r108.itemView, null, Integer.valueOf(r109), 13);
        MmSubtitleHighlightStyle r113 = A2(r102);
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r112, "payloads");
        Intrinsics.checkNotNullParameter(r113, "highlightStyle");
        r108.f436455w = r102;
        boolean r114 = r112.contains(MmSubtitlePayload.CONTENT);
        boolean r115 = r112.contains(MmSubtitlePayload.SPEAKER);
        boolean r116 = r112.contains(MmSubtitlePayload.AVATAR);
        boolean r117 = r112.contains(MmSubtitlePayload.EDIT_STATE);
        boolean r118 = r112.contains(MmSubtitlePayload.TIME);
        boolean r119 = r112.contains(MmSubtitlePayload.HIGHLIGHT);
        if (r114 == true) goto L35;
        if (r119 == true) goto L35;
    L36:
        if (r118 == false) goto L38;
        TextView r120 = r108.f436435c.f516103i;
        int r121 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.c.f434036a;
        MmSubtitleNormalContentViewHolder.Z3(r120, com.ss.android.lark.officesdk.minutes.service.foundation.utils.c.a(r102.f435224c));
    L38:
        if (r115 == false) goto L40;
        r108.W3(r102, true);
    L42:
        if (r117 == false) goto L44;
        r108.U3(r102);
    L44:
        if (r119 == true) goto L46;
        if (r117 == true) goto L46;
    L47:
        if (r115 == true) goto L49;
        if (r116 == true) goto L49;
        return;
    L49:
        r108.X3(r102);
        return;
    L46:
        r108.V3(r102, r113);
        goto L47
    L40:
        if (r116 == false) goto L42;
        r108.W3(r102, false);
    L35:
        r108.T3(r102);
        goto L36
    L31:
        r109 = this.f436404j;
        goto L32
    L51:
        if ((r100 instanceof MmSubtitlePureContentViewHolder) == false) goto L57;
        MmSubtitlePureContentViewHolder r122 = (MmSubtitlePureContentViewHolder) r100;
        MmSubtitleHighlightStyle r123 = A2(r102);
        r122.getClass();
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r112, "payloads");
        Intrinsics.checkNotNullParameter(r123, "highlightStyle");
        r122.f436475g = r102;
        if (r112.contains(MmSubtitlePayload.HIGHLIGHT) == false) goto L55;
    L56:
        r122.T3(r102, r123);
        return;
    L55:
        if (r112.contains(MmSubtitlePayload.CONTENT) == true) goto L56;
        return;
    L57:
        onBindViewHolder(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MmSubtitleAdapter(String r100, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r101, String r102, MmRecordingUILaunchMode r103, LifecycleOwner r104, Function1<? super com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h, Unit> r105, Function3<? super com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h, ? super Integer, ? super View, Boolean> r106) {
        Intrinsics.checkNotNullParameter(r100, "recordingSessionId");
        Intrinsics.checkNotNullParameter(r101, "uccApi");
        Intrinsics.checkNotNullParameter(r102, "meetingId");
        Intrinsics.checkNotNullParameter(r103, "uiLaunchMode");
        Intrinsics.checkNotNullParameter(r104, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r105, "onEditSpeakerClick");
        Intrinsics.checkNotNullParameter(r106, "onSubtitleLongClick");
        this.f436395a = r100;
        this.f436396b = r101;
        this.f436397c = r102;
        this.f436398d = r103;
        this.f436399e = r104;
        this.f436400f = r105;
        this.f436401g = r106;
        this.f436402h = new AsyncListDiffer(this, new MmSubtitleAdapter$diffCallback$1(this));
        this.f436403i = UIHelper.dp2px(20.0f);
        this.f436404j = UIHelper.dp2px(28.0f);
        this.f436407m = SetsKt.emptySet();
        setHasStableIds(true);
    }
}
