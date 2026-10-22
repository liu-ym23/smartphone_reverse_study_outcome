package com.larus.bmhome.chat.deepresearch.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.api.SelectionRangeType;
import com.larus.bmhome.chat.layout.widget.ShimmerTextView;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.list.expose.ExposureTrackerExtKt;
import com.larus.mainbot.impl.databinding.LarusBlockItemMarkdownTextWithIconBinding;
import com.larus.mainbot.impl.databinding.LarusBlockItemMarkdownTextWithIconSubBinding;
import com.larus.nova.R;
import com.larus.platform.model.MarkDownSelectorSettings;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.subtitle.SubtitleListUpdateType;
import com.obric.sva.sdk.data.ISmModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u009b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0001,\u0018\u0000 L2\u00020\u0001:\u0001LB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010'\u001a\u00020\u0016H\u0002J\b\u0010(\u001a\u00020\u0016H\u0002J\u0010\u0010.\u001a\u00020/2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u001a\u00100\u001a\u00020/2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J(\u00106\u001a\u00020/2\b\u00107\u001a\u0004\u0018\u0001082\u0014\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020;\u0018\u00010:H\u0016J\u0012\u0010<\u001a\u00020/2\b\u00107\u001a\u0004\u0018\u000108H\u0002J\u0006\u0010=\u001a\u00020/J\u001a\u0010>\u001a\u00020/2\b\u0010?\u001a\u0004\u0018\u00010@2\b\b\u0002\u0010A\u001a\u00020\u0016J\u001a\u0010B\u001a\u00020/2\b\u0010?\u001a\u0004\u0018\u00010@2\b\b\u0002\u0010A\u001a\u00020\u0016J4\u0010C\u001a\u00020/2\b\u0010D\u001a\u0004\u0018\u00010E2\b\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010F\u001a\u00020\u00182\u0006\u0010G\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0016H\u0002J\b\u0010H\u001a\u00020/H\u0014J\b\u0010I\u001a\u00020/H\u0016J\u0012\u0010J\u001a\u00020\u00162\b\u00107\u001a\u0004\u0018\u000108H\u0002J(\u0010K\u001a\u00020\u00072\b\u00107\u001a\u0004\u0018\u0001082\u0014\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020;\u0018\u00010:H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$R\u000e\u0010)\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0004\n\u0002\u0010-R\u001b\u00101\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010&\u001a\u0004\b3\u00104¨\u0006M"}, d2 = {"Lcom/larus/bmhome/chat/deepresearch/view/MarkdownIconTextBlockView;", "Lcom/larus/bmhome/chat/deepresearch/view/AbsBlockView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusBlockItemMarkdownTextWithIconBinding;", "iconBinding", "Lcom/larus/mainbot/impl/databinding/LarusBlockItemMarkdownTextWithIconSubBinding;", "mobMessage", "Lcom/larus/im/bean/message/Message;", "mobBotModel", "Lcom/larus/im/bean/bot/BotModel;", "mobChatKey", "", "Ljava/lang/Long;", "isProgressContent", "", "currentPage", "", "mobPreviousPage", "mobResearchId", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "markDownSelectHelper", "Lcom/larus/bmhome/chat/api/IMarkDownSelectHelper;", "getMarkDownSelectHelper", "()Lcom/larus/bmhome/chat/api/IMarkDownSelectHelper;", "markDownSelectorSettings", "Lcom/larus/platform/model/MarkDownSelectorSettings;", "getMarkDownSelectorSettings", "()Lcom/larus/platform/model/MarkDownSelectorSettings;", "markDownSelectorSettings$delegate", "Lkotlin/Lazy;", "isTripleClickEnabled", "isReClickEnabled", "latestDoubleClickTime", "latestTripleClickTime", "clickRunnable", "com/larus/bmhome/chat/deepresearch/view/MarkdownIconTextBlockView$clickRunnable$1", "Lcom/larus/bmhome/chat/deepresearch/view/MarkdownIconTextBlockView$clickRunnable$1;", "bindRecycleView", "", "init", "markdownRenderHelper", "Lcom/larus/bmhome/chat/list/cell/text/markdown/MarkdownRenderHelper;", "getMarkdownRenderHelper", "()Lcom/larus/bmhome/chat/list/cell/text/markdown/MarkdownRenderHelper;", "markdownRenderHelper$delegate", "bindData", "data", "Lcom/larus/im/bean/message/block/Block;", "extra", "", "", "tryMobCardShow", "performSingleClick", "performDoubleClick", "markdownTextView", "Lcom/larus/bmhome/view/textview/impl/CustomMarkdownTextView;", "isReClick", "performTripleClick", "doPerformClick", WidgetService.PARAM_FRAGMENT, "Lcom/larus/trace/tracknode/TraceFragment;", "clickFrom", "clickCount", "onDetachedFromWindow", "onViewRecycled", "needShowIcon", "getMaxContentWidth", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MarkdownIconTextBlockView extends AbsBlockView {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f302264r = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LarusBlockItemMarkdownTextWithIconBinding f302265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LarusBlockItemMarkdownTextWithIconSubBinding f302266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Message f302267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BotModel f302268e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Long f302269f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f302270g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f302271h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f302272i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f302273j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RecyclerView f302274k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.larus.bmhome.chat.api.z f302275l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f302276m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f302277n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f302278o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final b f302279p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f302280q;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f302281a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CustomMarkdownTextView f302282b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MarkdownIconTextBlockView f302283c;

        public final void a() {
            int r100 = this.f302281a;
            if (r100 != 1) goto L6;
            this.f302283c.getClass();
            zh8.a.f572196a.getReceiver().c().i6("MarkdownIconTextBlockView performSingleClick", true);
        L13:
            this.f302281a = 0;
            return;
        L6:
            if (r100 != 2) goto L9;
            MarkdownIconTextBlockView r101 = this.f302283c;
            r101.f302277n = SystemClock.elapsedRealtime();
            this.f302283c.g(this.f302282b, false);
            goto L13
        L9:
            if (r100 != 3) goto L13;
            MarkdownIconTextBlockView r102 = this.f302283c;
            int r103 = MarkdownIconTextBlockView.f302264r;
            if (r102.f() == false) goto L13;
            MarkdownIconTextBlockView r104 = this.f302283c;
            r104.f302278o = SystemClock.elapsedRealtime();
            this.f302283c.h(this.f302282b, false);
            goto L13
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(MarkdownIconTextBlockView r100) {
            this.f302283c = r100;
        }
    }

    public static final class c implements com.larus.bmhome.chat.api.d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomMarkdownTextView f302284a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MarkdownIconTextBlockView f302285b;

        public c(CustomMarkdownTextView r100, MarkdownIconTextBlockView r101) {
            this.f302284a = r100;
            this.f302285b = r101;
        }

        @Override // com.larus.bmhome.chat.api.d0
        public final void a(View r100, int r101, int r102) {
            if (r100 != null) goto L4;
            return;
        L4:
            if (Intrinsics.areEqual(r100, this.f302284a) == true) goto L7;
            return;
        L7:
            if (r102 == 2) goto L9;
            return;
        L9:
            if (MarkdownIconTextBlockView.d(this.f302285b) == false) goto L14;
            final MarkdownIconTextBlockView r103 = this.f302285b;
            final CustomMarkdownTextView r104 = this.f302284a;
            r100.postDelayed(new o0(r103, r104), 100);
            return;
        }

        @Override // com.larus.bmhome.chat.api.d0
        public final void b(SelectionRangeType r100, int r101, int r102, boolean r103, boolean r104, Rect r105, String r106) {
            com.larus.bmhome.chat.api.d0.a.a(r100, r106);
        }
    }

    static {
    }

    public MarkdownIconTextBlockView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MarkdownIconTextBlockView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final MarkDownSelectorSettings getMarkDownSelectorSettings() {
        return (MarkDownSelectorSettings) this.f302276m.getValue();
    }

    private final vg8.m getMarkdownRenderHelper() {
        return (vg8.m) this.f302280q.getValue();
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void c() {
        vg8.m r100 = getMarkdownRenderHelper();
        LarusBlockItemMarkdownTextWithIconBinding r101 = this.f302265b;
        if (r101 == null) goto L5;
        LinearLayout r102 = r101.f358468c;
    L6:
        r100.d(r102);
        b r103 = this.f302279p;
        r103.f302281a = 0;
        com.larus.utils.t0.f375468a.removeCallbacks(r103);
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final boolean f() {
        if (getMarkDownSelectorSettings().getTripleClickStrategy() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getMarkdownRenderHelper().c();
    }

    public final com.larus.bmhome.chat.api.z getMarkDownSelectHelper() {
        return this.f302275l;
    }

    public static final boolean d(MarkdownIconTextBlockView r100) {
        if (r100.getMarkDownSelectorSettings().getDoubleClickShiftStrategy() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void a(final Block r210, Map<String, Object> r211) {
        String r100 = null;
        if (r211 == null) goto L5;
        Object r101 = r211.get("block_view_extra_message");
    L6:
        this.f302267d = (Message) r101;
        if (r211 == null) goto L9;
        Object r102 = r211.get("block_view_extra_bot_model");
    L11:
        if ((r102 instanceof BotModel) == false) goto L13;
        BotModel r103 = (BotModel) r102;
    L14:
        this.f302268e = r103;
        if (r211 == null) goto L17;
        Object r104 = r211.get("block_view_extra_chat_key");
    L19:
        if ((r104 instanceof Long) == false) goto L21;
        Long r105 = (Long) r104;
    L22:
        if (r105 != null) goto L24;
        r105 = 0L;
    L24:
        this.f302269f = r105;
        if (r211 == null) goto L27;
        Object r106 = r211.get("block_view_extra_current_page");
    L29:
        if ((r106 instanceof String) == false) goto L31;
        String r107 = (String) r106;
    L32:
        this.f302271h = r107;
        if (r211 == null) goto L35;
        Object r108 = r211.get("block_view_extra_previous_page");
    L37:
        if ((r108 instanceof String) == false) goto L39;
        String r109 = (String) r108;
    L40:
        this.f302272i = r109;
        if (r211 == null) goto L43;
        Object r110 = r211.get("block_view_extra_mob_research_id");
    L45:
        if ((r110 instanceof String) == false) goto L47;
        String r111 = (String) r110;
    L48:
        this.f302273j = r111;
        if (r211 == null) goto L51;
        Object r112 = r211.get("block_view_markdown_common_input");
    L53:
        if ((r112 instanceof fh8.f) == false) goto L55;
        fh8.f r113 = (fh8.f) r112;
    L56:
        if (r113 != null) goto L58;
        r113 = new fh8.g().a();
    L58:
        boolean r114 = Intrinsics.areEqual(this.f302271h, "dr_process_detail");
        this.f302270g = r114;
        boolean r115 = true;
        String r116 = AbsBlockView.a.f(r210, r114, true);
        if (r116 != null) goto L61;
    L64:
        boolean r117 = true;
    L66:
        if (r117 == false) goto L73;
        LarusBlockItemMarkdownTextWithIconBinding r118 = this.f302265b;
        if (r118 == null) goto L230;
        FrameLayout r119 = r118.f358466a;
        if (r119 == null) goto L231;
        r119.setVisibility(8);
        return;
    L231:
        return;
    L230:
        return;
    L73:
        LarusBlockItemMarkdownTextWithIconBinding r120 = this.f302265b;
        if (r120 == null) goto L78;
        FrameLayout r121 = r120.f358466a;
        if (r121 == null) goto L78;
        r121.setVisibility(0);
    L78:
        LarusBlockItemMarkdownTextWithIconBinding r122 = this.f302265b;
        if (r122 == null) goto L229;
        if (r211 == null) goto L82;
        Object r123 = r211.get("block_view_extra_max_width");
    L84:
        if ((r123 instanceof Integer) == false) goto L86;
        Integer r124 = (Integer) r123;
    L87:
        if (r124 == null) goto L89;
        int r125 = r124.intValue();
    L90:
        if (r210 != null) goto L92;
    L94:
        boolean r126 = false;
    L95:
        if (r126 == false) goto L101;
        if (this.f302270g == false) goto L99;
        int r127 = i5.l0();
    L114:
        int r128 = r125 - r127;
        if (this.f302270g == true) goto L117;
    L116:
        boolean r129 = false;
    L126:
        if (r129 == true) goto L136;
        LinearLayout r130 = r122.f358468c;
        ViewGroup.LayoutParams r131 = r130.getLayoutParams();
        if (r131 == null) goto L135;
        FrameLayout.LayoutParams r132 = (FrameLayout.LayoutParams) r131;
        r132.setMarginStart(0);
        r130.setLayoutParams(r132);
        LarusBlockItemMarkdownTextWithIconSubBinding r133 = this.f302266c;
        if (r133 == null) goto L156;
        LinearLayout r134 = r133.f358469a;
        if (r134 == null) goto L156;
        r134.setVisibility(8);
    L156:
        if (r210 != null) goto L158;
    L160:
        boolean r135 = false;
    L161:
        if (r135 == false) goto L193;
        LarusBlockItemMarkdownTextWithIconBinding r136 = this.f302265b;
        if (r136 == null) goto L167;
        LinearLayout r137 = r136.f358468c;
        if (r137 == null) goto L167;
        r137.setVisibility(0);
    L167:
        LarusBlockItemMarkdownTextWithIconSubBinding r138 = this.f302266c;
        if (r138 == null) goto L172;
        ShimmerTextView r139 = r138.f358471c;
        if (r139 == null) goto L172;
        r139.setVisibility(8);
    L172:
        LarusBlockItemMarkdownTextWithIconSubBinding r140 = this.f302266c;
        if (r140 == null) goto L178;
        ShimmerTextView r141 = r140.f358471c;
        if (r141 == null) goto L178;
        r141.x();
    L178:
        if (this.f302270g == false) goto L180;
        fh8.t.a r142 = new fh8.t.a();
        r142.f477166a = ContextCompat.getColor(getContext(), v19.c.b(R.attr.larus_neutral_70, getContext(), R.color.larus_neutral_70));
        r142.f477167b = i5.o();
        r142.f477168c = i5.E();
        r142.f477169d = false;
        r142.f477174i = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        r142.f477170e = false;
        r142.f477171f = 0;
        r142.f477172g = false;
        r142.f477173h = r128;
        i5.l0();
        fh8.t r143 = r142.a();
    L181:
        fh8.t r144 = r143;
        fh8.l r145 = new fh8.l(false, false, "markdownIconTextBlock-" + r210.getBlockId(), false, null, false, true, false, false, null, null, 3952);
        fh8.g r146 = fh8.h.a(r113);
        r146.f477106j = r145.f477130e;
        fh8.f r147 = r146.a();
        vg8.m r148 = getMarkdownRenderHelper();
        LinearLayout r149 = r122.f358468c;
        String r150 = "";
        if (r116 != null) goto L184;
        String r151 = "";
    L185:
        Function1 r152 = new g0(this);
        Function1 r153 = new h0(this);
        Function1 r154 = new i0();
        Pair[] r155 = new Pair[3];
        StringBuilder r156 = new StringBuilder();
        Message r157 = this.f302267d;
        if (r157 == null) goto L188;
        r100 = r157.getMessageId();
    L188:
        r156.append(r100);
        r156.append("-deepThink");
        r155[0] = TuplesKt.to("forceRefreshId", r156.toString());
        r155[1] = TuplesKt.to("viewAlphaTag", SubtitleListUpdateType.DEEP_THINKING);
        String r158 = this.f302271h;
        if (r158 == null) goto L192;
        r150 = r158;
    L192:
        r155[2] = TuplesKt.to("current_page", r150);
        fh8.e.a(r148, r149, r151, r144, r145, r152, r153, r154, MapsKt.mutableMapOf(r155), r147, null, null, ISmModel.VERSION_0600);
    L218:
        String r159 = AbsBlockView.a.d(r210);
        if (r159 != null) goto L221;
    L224:
        if (r115 == true) goto L233;
        ExposureTrackerExtKt.a(this, new l0(r210, this));
        return;
    L233:
        return;
    L221:
        if (r159.length() == 0) goto L224;
        r115 = false;
        goto L224
    L184:
        r151 = r116;
        goto L185
    L180:
        fh8.t.a r160 = new fh8.t.a();
        r160.f477169d = false;
        r160.f477170e = false;
        r160.f477171f = 0;
        r160.f477174i = new RectF(i5.q(), 0.0f, i5.q(), 0.0f);
        r160.f477172g = false;
        r160.f477173h = r128;
        r143 = r160.a();
        goto L181
    L193:
        LarusBlockItemMarkdownTextWithIconBinding r161 = this.f302265b;
        if (r161 == null) goto L198;
        LinearLayout r162 = r161.f358468c;
        if (r162 == null) goto L198;
        r162.setVisibility(8);
    L198:
        LarusBlockItemMarkdownTextWithIconSubBinding r163 = this.f302266c;
        if (r163 == null) goto L203;
        ShimmerTextView r164 = r163.f358471c;
        if (r164 == null) goto L203;
        r164.setVisibility(0);
    L203:
        LarusBlockItemMarkdownTextWithIconSubBinding r165 = this.f302266c;
        if (r165 == null) goto L208;
        ShimmerTextView r166 = r165.f358471c;
        if (r166 == null) goto L208;
        we8.a.b(r166, i5.t(), false, null, null, 12);
    L208:
        LarusBlockItemMarkdownTextWithIconSubBinding r167 = this.f302266c;
        if (r167 == null) goto L213;
        ShimmerTextView r168 = r167.f358471c;
        if (r168 == null) goto L213;
        r168.setText(r116);
    L213:
        LarusBlockItemMarkdownTextWithIconSubBinding r169 = this.f302266c;
        if (r169 == null) goto L218;
        ShimmerTextView r170 = r169.f358471c;
        if (r170 == null) goto L218;
        int r171 = ShimmerTextView.f304901h;
        r170.z(false);
        goto L218
    L158:
        if (r210.isFinish() != true) goto L160;
        r135 = true;
        goto L161
    L135:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L136:
        LinearLayout r172 = r122.f358468c;
        ViewGroup.LayoutParams r173 = r172.getLayoutParams();
        if (r173 == null) goto L228;
        FrameLayout.LayoutParams r174 = (FrameLayout.LayoutParams) r173;
        r174.setMarginStart(i5.Q());
        r172.setLayoutParams(r174);
        if (this.f302266c != null) goto L147;
        LayoutInflater r175 = LayoutInflater.from(getContext());
        FrameLayout r176 = r122.f358467b;
        View r177 = r175.inflate(R.layout.larus_block_item_markdown_text_with_icon_sub, r176, false);
        r176.addView(r177);
        int r178 = R.id.deep_research_item_icon;
        SimpleDraweeView r179 = (SimpleDraweeView) ViewBindings.findChildViewById(r177, R.id.deep_research_item_icon);
        if (r179 == null) goto L146;
        r178 = R.id.deep_research_shimmer_text;
        ShimmerTextView r180 = (ShimmerTextView) ViewBindings.findChildViewById(r177, R.id.deep_research_shimmer_text);
        if (r180 == null) goto L146;
        this.f302266c = new LarusBlockItemMarkdownTextWithIconSubBinding((LinearLayout) r177, r179, r180);
    L146:
        throw new NullPointerException("Missing required view with ID: ".concat(r177.getResources().getResourceName(r178)));
    L147:
        LarusBlockItemMarkdownTextWithIconSubBinding r181 = this.f302266c;
        if (r181 == null) goto L150;
        SimpleDraweeView r182 = r181.f358470b;
    L151:
        AbsBlockView.a.e(r182, r210);
        LarusBlockItemMarkdownTextWithIconSubBinding r183 = this.f302266c;
        if (r183 == null) goto L156;
        SimpleDraweeView r184 = r183.f358470b;
        if (r184 == null) goto L156;
        r184.setVisibility(0);
        goto L156
    L150:
        r182 = null;
        goto L151
    L228:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L117:
        if (r210 != null) goto L119;
    L121:
        boolean r185 = false;
    L122:
        if (r185 == true) goto L116;
        r129 = true;
        goto L126
    L119:
        if (r210.getBlockType() != j.f302431o) goto L121;
        r185 = true;
        goto L122
    L99:
        r127 = i5.Q();
        goto L114
    L101:
        if (this.f302270g == true) goto L103;
    L102:
        boolean r186 = false;
    L111:
        if (r186 == false) goto L113;
        r127 = i5.l0();
        goto L114
    L113:
        r127 = i5.Q();
        goto L114
    L103:
        if (r210 != null) goto L105;
    L107:
        boolean r187 = false;
    L108:
        if (r187 == true) goto L102;
        r186 = true;
        goto L111
    L105:
        if (r210.getBlockType() != j.f302431o) goto L107;
        r187 = true;
        goto L108
    L92:
        if (r210.getBlockType() != j.f302431o) goto L94;
        r126 = true;
        goto L95
    L89:
        r125 = 0;
        goto L90
    L86:
        r124 = null;
        goto L87
    L82:
        r123 = null;
        goto L84
    L229:
        return;
    L61:
        if (r116.length() == 0) goto L64;
        r117 = false;
        goto L66
    L55:
        r113 = null;
        goto L56
    L51:
        r112 = null;
        goto L53
    L47:
        r111 = null;
        goto L48
    L43:
        r110 = null;
        goto L45
    L39:
        r109 = null;
        goto L40
    L35:
        r108 = null;
        goto L37
    L31:
        r107 = null;
        goto L32
    L27:
        r106 = null;
        goto L29
    L21:
        r105 = null;
        goto L22
    L17:
        r104 = null;
        goto L19
    L13:
        r103 = null;
        goto L14
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void b(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        View r102 = LayoutInflater.from(r100).inflate(R.layout.larus_block_item_markdown_text_with_icon, this, false);
        addView(r102);
        FrameLayout r103 = (FrameLayout) r102;
        LinearLayout r104 = (LinearLayout) ViewBindings.findChildViewById(r102, R.id.deep_research_item_text_container);
        if (r104 == null) goto L7;
        this.f302265b = new LarusBlockItemMarkdownTextWithIconBinding(r103, r103, r104);
        return;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(R.id.deep_research_item_text_container)));
    }

    public final void g(CustomMarkdownTextView r100, boolean r101) {
        FLogger.f375446a.i("MarkdownIconTextBlockView", "performDoubleClick, isReClick:" + r101);
        LarusBlockItemMarkdownTextWithIconBinding r102 = this.f302265b;
        if (r102 == null) goto L7;
        FrameLayout r103 = r102.f358466a;
        if (r103 == null) goto L7;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        TraceFragment r104 = (TraceFragment) FragmentManager.findFragment(r103);
    L8:
        e(r104, r100, "double_click_text", 2, r101);
        return;
    L7:
        r104 = null;
        goto L8
    }

    public final void h(CustomMarkdownTextView r100, boolean r101) {
        FLogger.f375446a.i("MarkdownIconTextBlockView", "performTripleClick, isReClick:" + r101);
        LarusBlockItemMarkdownTextWithIconBinding r102 = this.f302265b;
        if (r102 == null) goto L7;
        FrameLayout r103 = r102.f358466a;
        if (r103 == null) goto L7;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        TraceFragment r104 = (TraceFragment) FragmentManager.findFragment(r103);
    L8:
        e(r104, r100, "triple_click_text", 3, r101);
        return;
    L7:
        r104 = null;
        goto L8
    }

    public MarkdownIconTextBlockView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f302275l = ILegacyChatUiServiceDelegate.f297164b.F8();
        this.f302276m = LazyKt.lazy(new j0());
        this.f302279p = new b(this);
        this.f302280q = LazyKt.lazy(new k0());
    }

    public /* synthetic */ MarkdownIconTextBlockView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void e(TraceFragment r210, CustomMarkdownTextView r211, String r212, int r213, boolean r214) {
        com.larus.bmhome.chat.api.z r100 = this.f302275l;
        if (r100 == null) goto L17;
        TraceFragment r101 = r210;
        if ((r101 instanceof by7.e) == true) goto L8;
        r101 = null;
    L8:
        BotModel r102 = this.f302268e;
        Long r103 = this.f302269f;
        if (r103 == null) goto L11;
        long r104 = r103.longValue();
    L12:
        if (r211 != null) goto L14;
        CustomMarkdownTextView r110 = null;
    L15:
        com.larus.bmhome.chat.api.z.a.a(r100, r101, r102, "default", r104, r110, this.f302267d, r212, this.f302271h, this.f302274k, true, r213, r214, null, new c(r211, this), false, null, null, null, 512000);
        return;
    L14:
        r110 = r211;
        goto L15
    L11:
        r104 = 0;
        goto L12
    }
}
