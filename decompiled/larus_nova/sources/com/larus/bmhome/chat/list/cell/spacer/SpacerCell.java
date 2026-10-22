package com.larus.bmhome.chat.list.cell.spacer;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.cell.BaseMessageListCell;
import com.larus.bmhome.chat.model.strategy.AnswerAnchorTopStrategy;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 72\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003567B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\nH\u0016J \u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\nH\u0002JF\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001bH\u0002J:\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001bH\u0002JB\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001bH\u0002J \u0010\u001e\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 H\u0002J\f\u0010\u001f\u001a\u00020 *\u00020\u0017H\u0002J\u0014\u0010!\u001a\u00020\"*\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0018\u0010#\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\nH\u0002J\u0014\u0010%\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\nH\u0002J\b\u0010&\u001a\u00020\u0019H\u0002J\u0012\u0010'\u001a\u00020\u00192\b\b\u0002\u0010(\u001a\u00020\nH\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\nH\u0002J\u0018\u0010,\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\nH\u0002J\f\u0010.\u001a\u00020\u0019*\u00020/H\u0002J\f\u00100\u001a\u00020\r*\u00020\u0006H\u0002J\u000e\u00101\u001a\u0004\u0018\u000102*\u00020\u0006H\u0002J\u0016\u00103\u001a\u00020\r*\u00020\u00062\b\u00104\u001a\u0004\u0018\u000102H\u0002¨\u00068"}, d2 = {"Lcom/larus/bmhome/chat/list/cell/spacer/SpacerCell;", "Lcom/larus/bmhome/chat/cell/BaseMessageListCell;", "Lcom/larus/bmhome/chat/list/cell/spacer/SpacerCellState;", "<init>", "()V", "onCreateBoxView", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "viewType", "", "boxType", "onBindView", "", "view", "state", "position", "bindAnimation", "playHeightAnimation", "Landroid/animation/ValueAnimator;", "fromHeight", "toHeight", "animationSpec", "Lcom/larus/bmhome/chat/list/cell/spacer/SpacerAnimationSpec;", "allowNegativeFollowScroll", "", "onEnd", "Lkotlin/Function0;", "playDefaultHeightAnimation", "playTimelineHeightAnimation", "interpolateHeight", "progress", "", "remainingDuration", "", "updateHeight", "height", "effectiveHeight", "shouldFollowLatest", "settleLatestAtBottomIfNeeded", "maxDistance", "followLatestOnHeightChanged", "Lcom/larus/bmhome/chat/list/cell/spacer/SpacerCell$FollowLatestResult;", "deltaHeight", "finishFollowingLatest", "pendingDelta", "isReadyForBubbleBannerScroll", "Landroidx/recyclerview/widget/RecyclerView;", "cancelSpacerAnimation", "animationTag", "Lcom/larus/bmhome/chat/list/cell/spacer/SpacerCell$AnimationTag;", "setAnimationTag", "tag", "AnimationTag", "FollowLatestResult", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpacerCell extends BaseMessageListCell<j> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final PathInterpolator f305892e = null;

    /* JADX INFO: loaded from: classes25.dex */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/list/cell/spacer/SpacerCell$FollowLatestResult;", "", "<init>", "(Ljava/lang/String;I)V", "APPLIED", "DEFERRED", "STOPPED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FollowLatestResult extends Enum<FollowLatestResult> {
        public static final FollowLatestResult APPLIED = null;
        public static final FollowLatestResult DEFERRED = null;
        public static final FollowLatestResult STOPPED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FollowLatestResult[] f305893a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f305894b = null;

        public static EnumEntries<FollowLatestResult> getEntries() {
            return f305894b;
        }

        static {
            FollowLatestResult r100 = new FollowLatestResult("APPLIED", 0);
            APPLIED = r100;
            FollowLatestResult r101 = new FollowLatestResult("DEFERRED", 1);
            DEFERRED = r101;
            FollowLatestResult r102 = new FollowLatestResult("STOPPED", 2);
            STOPPED = r102;
            FollowLatestResult[] r103 = {r100, r101, r102};
            f305893a = r103;
            f305894b = EnumEntriesKt.enumEntries(r103);
        }

        public static FollowLatestResult[] values() {
            return (FollowLatestResult[]) f305893a.clone();
        }

        public static FollowLatestResult valueOf(String r100) {
            return (FollowLatestResult) r27.a.a(FollowLatestResult.class, r100);
        }

        public FollowLatestResult(String r100, int r101) {
            super(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes25.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f305895a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ValueAnimator f305896b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f305895a, r101.f305895a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f305896b, r101.f305896b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f305895a.hashCode() * 31) + this.f305896b.hashCode();
        }

        public final String toString() {
            return "AnimationTag(key=" + this.f305895a + ", animator=" + this.f305896b + ')';
        }

        public a(String r100, ValueAnimator r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "animator");
            this.f305895a = r100;
            this.f305896b = r101;
        }
    }

    /* JADX INFO: loaded from: classes25.dex */
    public static final class b {
    }

    /* JADX INFO: loaded from: classes25.dex */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f305897a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f305898b = null;

        static {
            int[] r100 = new int[SpacerAnimationState.values().length];
            r100[SpacerAnimationState.WAITING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L26:
            r100[SpacerAnimationState.COLLAPSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L34:
            r100[SpacerAnimationState.EXPAND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L28:
            r100[SpacerAnimationState.NONE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L9:
            f305897a = r100;
            int[] r101 = new int[FollowLatestResult.values().length];
            r101[FollowLatestResult.APPLIED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L30:
            r101[FollowLatestResult.DEFERRED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L22:
            r101[FollowLatestResult.STOPPED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L13:
            f305898b = r101;
        }
    }

    static {
        f305892e = new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f);
    }

    public final boolean w() {
        RecyclerView r100 = this.f297616b;
        if ((r100 instanceof ChatMessageList) == false) goto L5;
        ChatMessageList r101 = (ChatMessageList) r100;
    L7:
        if (r101 != null) goto L10;
        return false;
    L10:
        if (r101.isAttachedToWindow() == true) goto L12;
        return false;
    L12:
        if (r101.getScrollState() == 0) goto L14;
        return false;
    L14:
        if (r101.f315433j == false) goto L16;
    L22:
        boolean r102 = false;
    L23:
        if (r102 == false) goto L28;
        return true;
    L28:
        return false;
    L16:
        if (r101.f315432i == true) goto L22;
        if (r101.P() == false) goto L20;
    L21:
        r102 = true;
        goto L23
    L20:
        if (AnswerAnchorTopStrategy.f307886c == false) goto L22;
    L5:
        r101 = null;
        goto L7
    }

    public SpacerCell() {
    }

    public static void r(View r100) {
        Object r101 = r100.getTag(R.id.spacer_cell_animation_tag);
        if ((r101 instanceof a) == false) goto L5;
        a r102 = (a) r101;
    L6:
        if (r102 == null) goto L10;
        ValueAnimator r103 = r102.f305896b;
        if (r103 == null) goto L10;
        r103.cancel();
    L10:
        r100.setTag(R.id.spacer_cell_animation_tag, null);
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final FollowLatestResult s(int r100) {
        if (r100 == 0) goto L4;
        RecyclerView r101 = this.f297616b;
        if ((r101 instanceof ChatMessageList) == false) goto L8;
        ChatMessageList r102 = (ChatMessageList) r101;
    L9:
        if (r102 != null) goto L13;
        return FollowLatestResult.STOPPED;
    L13:
        if (r102.isAttachedToWindow() == false) goto L37;
        if (r102.getScrollState() != 0) goto L37;
        if (r102.f315433j == false) goto L20;
    L26:
        boolean r103 = false;
    L27:
        if (r103 == true) goto L31;
        return FollowLatestResult.STOPPED;
    L31:
        if (r102.isComputingLayout() == true) goto L33;
        r102.a0(r100);
        return FollowLatestResult.APPLIED;
    L33:
        return FollowLatestResult.DEFERRED;
    L20:
        if (r102.f315432i == true) goto L26;
        if (r102.P() == false) goto L24;
    L25:
        r103 = true;
        goto L27
    L24:
        if (AnswerAnchorTopStrategy.f307886c == false) goto L26;
    L37:
        return FollowLatestResult.STOPPED;
    L8:
        r102 = null;
        goto L9
    L4:
        return FollowLatestResult.APPLIED;
    }

    public final boolean u(int r100) {
        RecyclerView r101 = this.f297616b;
        if ((r101 instanceof ChatMessageList) == false) goto L5;
        ChatMessageList r102 = (ChatMessageList) r101;
    L7:
        if (r102 != null) goto L10;
        return false;
    L10:
        if (r102.isAttachedToWindow() == true) goto L12;
    L14:
        boolean r103 = false;
    L15:
        if (r103 == true) goto L17;
    L27:
        return false;
    L17:
        if (r102.getScrollState() != 0) goto L27;
        if (r102.P() == true) goto L27;
        int r104 = r102.B();
        if (r104 <= 0) goto L27;
        if (r104 > r100) goto L27;
        r102.scrollBy(0, r104);
        return true;
    L12:
        if (r102.isComputingLayout() == true) goto L14;
        r103 = true;
        goto L15
    L5:
        r102 = null;
        goto L7
    }

    public static void x(View r100, int r101) {
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 != null) goto L6;
        r102 = new RecyclerView.LayoutParams(-1, r101);
    L6:
        if (r102.height == r101) goto L9;
        r102.height = RangesKt.coerceAtLeast(r101, 0);
        r100.setLayoutParams(r102);
        return;
    }

    public static final void o(final SpacerCell r100, View r101, final int r102) {
        FollowLatestResult r103 = r100.s(r102);
        int r104 = c.f305898b[r103.ordinal()];
        if (r104 != 1) goto L5;
        RecyclerView r105 = r100.f297616b;
        if ((r105 instanceof ChatMessageList) == false) goto L15;
        ChatMessageList r106 = (ChatMessageList) r105;
    L16:
        if (r106 == null) goto L18;
        int r107 = r106.getSpacing();
    L19:
        r100.u(r107);
        return;
    L18:
        r107 = 0;
        goto L19
    L15:
        r106 = null;
        goto L16
    L5:
        if (r104 != 2) goto L7;
        r101.post(new f(r100, r102));
        return;
    L7:
        if (r104 != 3) goto L10;
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.bmhome.chat.cell.BaseMessageListCell
    public final View m(Context r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new View(r100);
    }

    @Override // com.larus.list.arch.IFlowListCell
    public final void onBindView(View r110, ei9.f r111, int r112) {
        final j r100 = (j) r111;
        Intrinsics.checkNotNullParameter(r110, "view");
        Intrinsics.checkNotNullParameter(r100, "state");
        RecyclerView r101 = this.f297616b;
        Integer r102 = null;
        String r103 = null;
        if ((r101 instanceof ChatMessageList) == false) goto L5;
        ChatMessageList r104 = (ChatMessageList) r101;
    L6:
        boolean r105 = false;
        if (r104 != null) goto L10;
        int r106 = r100.f305941f;
    L9:
        int r107 = r106;
        int r108 = c.f305897a[r100.f305942g.ordinal()];
        if (r108 != 1) goto L28;
        r(r110);
        x(r110, 0);
        return;
    L28:
        if (r108 != 2) goto L30;
        String r113 = "collapse_" + r100.f305940e;
        Object r109 = r110.getTag(R.id.spacer_cell_animation_tag);
        if ((r109 instanceof a) == false) goto L54;
        a r114 = (a) r109;
    L55:
        if (r114 == null) goto L57;
        String r115 = r114.f305895a;
    L59:
        if (Intrinsics.areEqual(r115, r113) == true) goto L61;
    L63:
        r(r110);
        r100.f305946k.c(r100.f305940e);
        Integer r116 = Integer.valueOf(r107);
        r116.intValue();
        if (r100.f305944i == null) goto L66;
        boolean r117 = true;
    L67:
        if (r117 == true) goto L70;
        r116 = null;
    L70:
        if (r116 == null) goto L72;
        int r118 = r116.intValue();
    L79:
        int r119 = r118;
    L81:
        r110.setTag(R.id.spacer_cell_animation_tag, new a(r113, t(r110, r119, 0, r100.f305944i, false, new com.larus.bmhome.chat.list.cell.spacer.b(r100))));
        return;
    L72:
        Integer r120 = Integer.valueOf(r110.getHeight());
        if (r120.intValue() <= 0) goto L75;
        r105 = true;
    L75:
        if (r105 == false) goto L77;
        r102 = r120;
    L77:
        if (r102 == null) goto L80;
        r118 = r102.intValue();
        goto L79
    L80:
        r119 = r107;
        goto L81
    L66:
        r117 = false;
        goto L67
    L61:
        if (r114.f305896b.isRunning() == false) goto L63;
        return;
    L57:
        r115 = null;
        goto L59
    L54:
        r114 = null;
        goto L55
    L30:
        if (r108 != 3) goto L32;
        String r121 = "expand_" + r100.f305940e;
        Object r122 = r110.getTag(R.id.spacer_cell_animation_tag);
        if ((r122 instanceof a) == false) goto L39;
        a r123 = (a) r122;
    L40:
        if (r123 == null) goto L43;
        r103 = r123.f305895a;
    L43:
        if (Intrinsics.areEqual(r103, r121) == false) goto L48;
        if (r123.f305896b.isRunning() == false) goto L48;
        return;
    L48:
        if (r100.f305943h == false) goto L50;
        r(r110);
        x(r110, r107);
        return;
    L50:
        r(r110);
        r100.f305946k.b(r100.f305940e);
        r110.setTag(R.id.spacer_cell_animation_tag, new a(r121, t(r110, 0, r107, r100.f305944i, true, new com.larus.bmhome.chat.list.cell.spacer.c(r100))));
        return;
    L39:
        r123 = null;
        goto L40
    L32:
        if (r108 != 4) goto L35;
        r(r110);
        x(r110, r107);
        return;
    L35:
        throw new NoWhenBranchMatchedException();
    L10:
        RecyclerView.LayoutManager r124 = r104.getLayoutManager();
        if ((r124 instanceof LinearLayoutManager) == false) goto L13;
        LinearLayoutManager r125 = (LinearLayoutManager) r124;
    L14:
        if (r125 != null) goto L17;
        r106 = r100.f305941f;
        goto L9
    L17:
        if (r125.getReverseLayout() == false) goto L24;
        if (r112 != 0) goto L24;
        if (r100.f305945j == false) goto L23;
        r106 = RangesKt.coerceAtLeast(r100.f305941f - r104.getCurrentBottomInset(), 0);
        goto L9
    L23:
        r106 = r100.f305941f;
    L24:
        r106 = r100.f305941f;
        goto L9
    L13:
        r125 = null;
        goto L14
    L5:
        r104 = null;
        goto L6
    }

    public final ValueAnimator t(final View r110, final int r111, final int r112, com.larus.bmhome.chat.list.cell.spacer.a r113, final boolean r114, Function0<Unit> r210) {
        if (r113 != null) goto L7;
        x(r110, r111);
        final Ref.IntRef r100 = new Ref.IntRef();
        final int r115 = r112 - r111;
        final Ref.BooleanRef r116 = new Ref.BooleanRef();
        r116.element = w();
        ValueAnimator r117 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r117.setDuration(500);
        r117.setInterpolator(f305892e);
        r117.addUpdateListener(new d(r111, r112, r110, this, r116, r115, r100, r114));
        r117.addListener(new g(this, r110, r112, r116, r114, r115, r100, r210));
        r117.start();
        return r117;
    L7:
        if (r113.f305901c > 0) goto L9;
        float r101 = 1.0f;
    L10:
        int r102 = r111 + ((int) ((r112 - r111) * r101));
        final Ref.BooleanRef r103 = new Ref.BooleanRef();
        r103.element = w();
        x(r110, r102);
        final Ref.IntRef r104 = new Ref.IntRef();
        r104.element = r102;
        final Ref.IntRef r118 = new Ref.IntRef();
        ValueAnimator r119 = ValueAnimator.ofFloat(new float[]{r101, 1.0f});
        r119.setDuration(RangesKt.coerceAtLeast((long) (r113.f305901c * (1.0f - r101)), 0));
        r119.setInterpolator(new LinearInterpolator());
        r119.addUpdateListener(new e(this, r111, r112, r104, r110, r103, r114, r118));
        r119.addListener(new h(this, r110, r112, r103, r114, r111, r118, r210));
        r119.start();
        return r119;
    L9:
        r101 = RangesKt.coerceIn((SystemClock.uptimeMillis() - r113.f305900b) / r113.f305901c, 0.0f, 1.0f);
        goto L10
    }
}
