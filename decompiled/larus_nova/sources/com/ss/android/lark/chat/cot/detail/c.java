package com.ss.android.lark.chat.cot.detail;

import android.content.Context;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.extension.panel.drag.view.DragPanelLayout;
import com.ss.android.lark.chat.cot.detail.blueprint.CotDetailBlueprintAdapter;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.textview.ShineTextView;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f414947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.chat.cot.a f414948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f414949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<k, Unit> f414950d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function2<k, String, Unit> f414951e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.ss.android.lark.biz.im.extension.panel.drag.i f414952f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RecyclerView f414953g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ShineTextView f414954h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f414955i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CotDetailBlueprintAdapter f414956j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function0<Unit> f414957k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public InvalidDecorationObserver f414958l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public g f414959m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CotStepExposureTracker f414960n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CotDetailContentController$setupStepTracking$2 f414961o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public q f414962p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f414963q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f414964r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f414965s;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f414966a = null;

        static {
            int[] r100 = new int[CotDetailBlockType.values().length];
            r100[CotDetailBlockType.GROUP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[CotDetailBlockType.TOOLCALL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[CotDetailBlockType.ACTION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[CotDetailBlockType.THINKING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[CotDetailBlockType.STATUS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f414966a = r100;
        }
    }

    static {
    }

    public static final void a(c r110, String r111) {
        RecyclerView r100 = r110.f414953g;
        if (r100 == null) goto L36;
        RecyclerView.LayoutManager r101 = r100.getLayoutManager();
        CotDetailBlockType r102 = null;
        if ((r101 instanceof LinearLayoutManager) == false) goto L8;
        LinearLayoutManager r103 = (LinearLayoutManager) r101;
    L9:
        if (r103 == null) goto L37;
        CotDetailBlueprintAdapter r104 = r110.f414956j;
        if (r104 == null) goto L14;
        int r105 = r104.getItemCount();
    L15:
        int r106 = r105 - 1;
        if (r106 < 0) goto L38;
        CotDetailBlueprintAdapter r112 = r110.f414956j;
        if (r112 == null) goto L23;
        List<k> r113 = r112.f414852c.getCurrentList();
        if (r113 == null) goto L23;
        k r114 = (k) CollectionsKt.getOrNull(r113, r106);
    L24:
        View r107 = r103.findViewByPosition(r106);
        if (r107 != null) goto L30;
        StringBuilder r108 = new StringBuilder("scroll reason=");
        r108.append(r111);
        r108.append(", last=");
        r108.append(r106);
        r108.append(", lastType=");
        if (r114 == null) goto L29;
        r102 = r114.f414983b;
    L29:
        r108.append(r102);
        r108.append(", lastView=null -> scrollToPosition");
        com.ss.android.lark.chat.cot.f.c("detail_autoscroll", r108.toString());
        r103.scrollToPosition(r106);
        return;
    L30:
        int r115 = (r100.getHeight() - r100.getPaddingTop()) - r100.getPaddingBottom();
        int r109 = r103.getDecoratedMeasuredHeight(r107);
        int r116 = RangesKt.coerceAtLeast(r115 - r109, 0);
        StringBuilder r117 = new StringBuilder("scroll reason=");
        r117.append(r111);
        r117.append(", last=");
        r117.append(r106);
        r117.append(", lastType=");
        if (r114 == null) goto L33;
        r102 = r114.f414983b;
    L33:
        r117.append(r102);
        r117.append(", rawH=");
        r117.append(r107.getHeight());
        r117.append(", decoratedH=");
        r117.append(r109);
        r117.append(", visibleH=");
        r117.append(r115);
        r117.append(", top=");
        r117.append(r107.getTop());
        r117.append(", bottom=");
        r117.append(r107.getBottom());
        r117.append(", decoratedTop=");
        r117.append(r103.getDecoratedTop(r107));
        r117.append(", decoratedBottom=");
        r117.append(r103.getDecoratedBottom(r107));
        r117.append(", offset=");
        r117.append(r116);
        com.ss.android.lark.chat.cot.f.c("detail_autoscroll", r117.toString());
        r103.scrollToPositionWithOffset(r106, r116);
        return;
    L23:
        r114 = null;
        goto L24
    L38:
        return;
    L14:
        r105 = 0;
        goto L15
    L37:
        return;
    L8:
        r103 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.recyclerview.widget.RecyclerView$OnItemTouchListener, com.ss.android.lark.chat.cot.detail.CotDetailContentController$setupStepTracking$2] */
    public final View c(Context r100, DragPanelLayout r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "parent");
        View r102 = LayoutInflater.from(r100).inflate(R.layout.im_cot_detail_sheet, r101, false);
        this.f414954h = (ShineTextView) r102.findViewById(R.id.cot_detail_header_title);
        this.f414955i = r102.findViewById(R.id.cot_detail_bottom_action_container);
        View r103 = r102.findViewById(R.id.cot_detail_header_close);
        if (r103 == null) goto L5;
        r103.setOnClickListener(new d(this));
    L5:
        View r104 = r102.findViewById(R.id.cot_detail_stop_button);
        if (r104 == null) goto L8;
        r104.setOnClickListener(new e(this));
    L8:
        RecyclerView r105 = (RecyclerView) r102.findViewById(R.id.cot_detail_recycler_view);
        this.f414953g = r105;
        int r106 = com.ss.android.lark.chat.cot.detail.blueprint.a.f414857a;
        CotDetailBlueprintAdapter r107 = com.ss.android.lark.chat.cot.detail.blueprint.a.a(r105.getContext(), this.f414947a, this.f414948b, this.f414949c, new CotDetailContentController$setupRecyclerView$blueprintAdapter$1(this), new CotDetailContentController$setupRecyclerView$blueprintAdapter$2(this));
        this.f414956j = r107;
        r105.setLayoutManager(new LinearLayoutManager(r105.getContext()));
        r105.setAdapter(r107);
        if (this.f414949c == false) goto L11;
        RecyclerView.ItemDecoration r108 = new CotDetailSpacingDecoration(r105.getContext());
    L12:
        r105.addItemDecoration(r108);
        InvalidDecorationObserver r109 = new InvalidDecorationObserver(r105);
        r107.registerAdapterDataObserver(r109);
        this.f414958l = r109;
        r105.setItemAnimator(null);
        r105.addOnScrollListener(new CotDetailContentController$setupRecyclerView$2(this));
        if (this.f414949c == false) goto L20;
        CotStepExposureTracker r110 = new CotStepExposureTracker(r105, r107, this.f414950d);
        if (r110.f414839e == true) goto L19;
        r110.f414839e = true;
        r110.f414835a.addOnScrollListener(r110.f414843i);
        r110.f414835a.addOnChildAttachStateChangeListener(r110.f414844j);
        r110.a();
    L19:
        this.f414960n = r110;
        final GestureDetector r111 = new GestureDetector(r105.getContext(), new h(this, r105, r107));
        ?? r112 = new CotDetailContentController$setupStepTracking$2(r111);
        r105.addOnItemTouchListener(r112);
        this.f414961o = r112;
    L20:
        g r113 = new g(r105, this);
        r105.getViewTreeObserver().addOnGlobalLayoutListener(r113);
        this.f414959m = r113;
        Intrinsics.checkNotNull(r102);
        return r102;
    L11:
        r108 = new CotDotItemDecoration(r105.getContext());
        goto L12
    }

    public static final void b(c r100, RecyclerView r101, CotDetailBlueprintAdapter r102, MotionEvent r103) {
        r100.getClass();
        View r104 = r101.findChildViewUnder(r103.getX(), r103.getY());
        if (r104 == null) goto L81;
        k r105 = (k) CollectionsKt.getOrNull(r102.f414852c.getCurrentList(), r101.getChildAdapterPosition(r104));
        if (r105 == null) goto L82;
        CotDetailBlockType r106 = r105.f414983b;
        int[] r107 = b.f414966a;
        int r108 = r107[r106.ordinal()];
        boolean r109 = false;
        View r110 = null;
        if (r108 != 1) goto L11;
        View r111 = r104.findViewById(R.id.cot_tool_call_group_title_row);
    L47:
        if (r111 != null) goto L49;
        return;
    L49:
        if (r111.getVisibility() != 0) goto L51;
        boolean r112 = true;
    L52:
        if (r112 == false) goto L54;
        r110 = r111;
    L54:
        if (r110 == null) goto L83;
        int r113 = (int) r103.getRawX();
        int r114 = (int) r103.getRawY();
        Rect r115 = new Rect();
        if (r110.getGlobalVisibleRect(r115) == true) goto L59;
    L61:
        if (r109 == true) goto L64;
        return;
    L64:
        if (r110.hasOnClickListeners() == true) goto L69;
        if (r105.f414983b != CotDetailBlockType.TOOLCALL) goto L79;
        r100.f414951e.invoke(r105, "none");
        return;
    L79:
        return;
    L69:
        if (r107[r105.f414983b.ordinal()] != 1) goto L71;
        boolean r116 = r100.f414947a.b(r105.f414982a);
    L72:
        Function2<k, String, Unit> r117 = r100.f414951e;
        if (r116 == false) goto L75;
        String r118 = "collapse";
    L76:
        r117.invoke(r105, r118);
        return;
    L75:
        r118 = BitableAnalytic.LinkSceneClickType.EXPAND;
        goto L76
    L71:
        r116 = r110.isSelected();
        goto L72
    L59:
        if (r115.contains(r113, r114) == false) goto L61;
        r109 = true;
        goto L61
    L83:
        return;
    L51:
        r112 = false;
        goto L52
    L11:
        if (r108 != 2) goto L13;
        r111 = r104.findViewById(R.id.cot_tool_call_title_row);
        goto L47
    L13:
        if (r108 != 3) goto L15;
        r111 = r104.findViewById(R.id.cot_action_title_movable);
        if (r111 != null) goto L36;
    L44:
        r111 = r104.findViewById(R.id.cot_action_title);
        goto L47
    L36:
        if (r111.getVisibility() != 0) goto L38;
        boolean r119 = true;
    L39:
        if (r119 == true) goto L42;
        r111 = null;
    L42:
        if (r111 == null) goto L44;
    L38:
        r119 = false;
        goto L39
    L15:
        if (r108 != 4) goto L17;
        r111 = r104.findViewById(R.id.cot_thinking_body_movable);
        if (r111 != null) goto L24;
    L32:
        r111 = r104.findViewById(R.id.cot_thinking_body);
        goto L47
    L24:
        if (r111.getVisibility() != 0) goto L26;
        boolean r120 = true;
    L27:
        if (r120 == true) goto L30;
        r111 = null;
    L30:
        if (r111 == null) goto L32;
    L26:
        r120 = false;
        goto L27
    L17:
        if (r108 != 5) goto L20;
        r111 = r104.findViewById(R.id.cot_status_text);
        goto L47
    L20:
        throw new NoWhenBranchMatchedException();
    L82:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(j r100, com.ss.android.lark.chat.cot.a r101, boolean r102, Function1<? super k, Unit> r103, Function2<? super k, ? super String, Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, "expandStore");
        Intrinsics.checkNotNullParameter(r101, "cotFeatureGate");
        Intrinsics.checkNotNullParameter(r103, "onStepView");
        Intrinsics.checkNotNullParameter(r104, "onStepClick");
        this.f414947a = r100;
        this.f414948b = r101;
        this.f414949c = r102;
        this.f414950d = r103;
        this.f414951e = r104;
        this.f414964r = true;
    }
}
