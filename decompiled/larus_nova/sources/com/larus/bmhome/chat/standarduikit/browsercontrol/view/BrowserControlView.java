package com.larus.bmhome.chat.standarduikit.browsercontrol.view;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.markdown.reference.ToolType;
import com.larus.bmhome.chat.markdown.view.DeepThinkCommonToolHeader;
import com.larus.bmhome.chat.monitor.IMessageImageLoaderService;
import com.larus.bmhome.chat.monitor.MessageImageLoader;
import com.larus.bmhome.chat.monitor.MessageImageType;
import com.larus.common_ui.widget.shimmer.ShimmerMaskView;
import com.larus.mainbot.impl.databinding.LarusLayoutBrowserControlBlockViewBinding;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import fj8.b;
import fj8.d;
import fj8.e;
import fj8.f;
import fj8.g;
import fj8.h;
import fj8.i;
import fj8.j;
import fj8.k;
import fj8.l;
import fj8.m;
import fj8.n;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.c;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u0004H\u0016J\b\u0010+\u001a\u0004\u0018\u00010,J\u0010\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020(2\u0006\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u00020(H\u0002J\b\u00104\u001a\u00020(H\u0002R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001b\u0010\u0018R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0014\u001a\u0004\b\u001f\u0010 R\u001d\u0010\"\u001a\u0004\u0018\u00010#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0014\u001a\u0004\b$\u0010%¨\u00065"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/browsercontrol/view/BrowserControlView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/browsercontrol/view/BrowserControlBlockInput;", "Lcom/larus/bmhome/chat/standarduikit/browsercontrol/view/BrowserControlBlockOutput;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusLayoutBrowserControlBlockViewBinding;", "toolHeader", "Lcom/larus/bmhome/chat/markdown/view/DeepThinkCommonToolHeader;", "getToolHeader", "()Lcom/larus/bmhome/chat/markdown/view/DeepThinkCommonToolHeader;", "toolHeader$delegate", "Lkotlin/Lazy;", "btnLeft", "Landroid/widget/FrameLayout;", "getBtnLeft", "()Landroid/widget/FrameLayout;", "btnLeft$delegate", "btnRight", "getBtnRight", "btnRight$delegate", "browserControlCover", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getBrowserControlCover", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "browserControlCover$delegate", "browserControlCoverMask", "Lcom/larus/common_ui/widget/shimmer/ShimmerMaskView;", "getBrowserControlCoverMask", "()Lcom/larus/common_ui/widget/shimmer/ShimmerMaskView;", "browserControlCoverMask$delegate", "bindData", "", "input", BdpAppEventConstant.PARAMS_OUTPUT, "currentToolTitle", "", "processButtonStatus", "buttonStatus", "Lcom/larus/bmhome/chat/standarduikit/browsercontrol/view/ButtonStatus;", "refreshControlGroup", "isFold", "", "hideControlGroup", "showControlGroup", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BrowserControlView extends ConstraintLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f308928g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusLayoutBrowserControlBlockViewBinding f308929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f308930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f308931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f308932d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f308933e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f308934f;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f308935a = null;

        static {
            int[] r100 = new int[ButtonStatus.values().length];
            r100[ButtonStatus.DISABLED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ButtonStatus.ENABLED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ButtonStatus.HIDE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f308935a = r100;
        }
    }

    public BrowserControlView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BrowserControlView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final SimpleDraweeView getBrowserControlCover() {
        return (SimpleDraweeView) this.f308933e.getValue();
    }

    private final ShimmerMaskView getBrowserControlCoverMask() {
        return (ShimmerMaskView) this.f308934f.getValue();
    }

    private final FrameLayout getBtnLeft() {
        return (FrameLayout) this.f308931c.getValue();
    }

    private final FrameLayout getBtnRight() {
        return (FrameLayout) this.f308932d.getValue();
    }

    private final DeepThinkCommonToolHeader getToolHeader() {
        return (DeepThinkCommonToolHeader) this.f308930b.getValue();
    }

    public static Unit R5(BrowserControlView r100) {
        ShimmerMaskView r101 = r100.getBrowserControlCoverMask();
        if (r101 == null) goto L5;
        e1.o(r101);
    L5:
        ShimmerMaskView r102 = r100.getBrowserControlCoverMask();
        if (r102 == null) goto L9;
        r102.a();
    L9:
        return Unit.INSTANCE;
    }

    public static Unit S5(BrowserControlView r100) {
        ShimmerMaskView r101 = r100.getBrowserControlCoverMask();
        if (r101 == null) goto L5;
        e1.o(r101);
    L5:
        ShimmerMaskView r102 = r100.getBrowserControlCoverMask();
        if (r102 == null) goto L9;
        r102.a();
    L9:
        return Unit.INSTANCE;
    }

    public static Unit T5(BrowserControlView r100) {
        ShimmerMaskView r101 = r100.getBrowserControlCoverMask();
        if (r101 == null) goto L5;
        e1.x(r101);
    L5:
        ShimmerMaskView r102 = r100.getBrowserControlCoverMask();
        if (r102 == null) goto L9;
        r102.c();
    L9:
        return Unit.INSTANCE;
    }

    public final void U5(fj8.a r210, final b r211) {
        Intrinsics.checkNotNullParameter(r210, "input");
        Intrinsics.checkNotNullParameter(r211, BdpAppEventConstant.PARAMS_OUTPUT);
        ToolType r100 = ToolType.BrowserControl;
        DeepThinkCommonToolHeader r101 = getToolHeader();
        if (r101 == null) goto L5;
        r101.b(r100, r210.f477482b, r210.f477488h, r210.f477487g);
    L5:
        DeepThinkCommonToolHeader r102 = getToolHeader();
        if (r102 == null) goto L16;
        String r103 = r210.f477485e;
        boolean r104 = r210.f477481a;
        Boolean r105 = Boolean.valueOf(r210.f477482b);
        Function0 r106 = null;
        if (r105.booleanValue() == false) goto L10;
        Boolean r107 = r105;
    L12:
        if (r210.f477483c == true) goto L15;
        r106 = new j(r211);
    L15:
        r102.d(r100, r103, r104, r107, r106);
        goto L16
    L10:
        r107 = null;
    L16:
        DeepThinkCommonToolHeader r108 = getToolHeader();
        if (r108 == null) goto L19;
        r108.setBackgroundResource(R.color.transparent);
    L19:
        final String r109 = r210.f477486f;
        SimpleDraweeView r110 = getBrowserControlCover();
        if (r110 != null) goto L22;
    L27:
        boolean r111 = true;
        ShimmerMaskView r112 = getBrowserControlCoverMask();
        if (r112 == null) goto L30;
        e1.x(r112);
    L30:
        ShimmerMaskView r113 = getBrowserControlCoverMask();
        if (r113 == null) goto L33;
        r113.c();
    L33:
        e1.d(getBtnRight(), new n(r211));
        if (r210.f477481a == false) goto L53;
        LarusLayoutBrowserControlBlockViewBinding r114 = this.f308929a;
        if (r114 == null) goto L40;
        SimpleDraweeView r115 = r114.f358706b;
        if (r115 == null) goto L40;
        e1.o(r115);
    L40:
        LarusLayoutBrowserControlBlockViewBinding r116 = this.f308929a;
        if (r116 == null) goto L45;
        View r117 = r116.f358708d;
        if (r117 == null) goto L45;
        e1.o(r117);
    L45:
        LarusLayoutBrowserControlBlockViewBinding r118 = this.f308929a;
        if (r118 == null) goto L50;
        ShimmerMaskView r119 = r118.f358707c;
        if (r119 == null) goto L50;
        e1.o(r119);
    L50:
        ShimmerMaskView r120 = getBrowserControlCoverMask();
        if (r120 == null) goto L63;
        r120.a();
    L63:
        int r121 = a.f308935a[r210.f477484d.ordinal()];
        if (r121 != r111) goto L66;
        FrameLayout r122 = getBtnRight();
        if (r122 == null) goto L120;
        r122.setClickable(false);
    L120:
        FrameLayout r123 = getBtnLeft();
        if (r123 == null) goto L123;
        r123.setClickable(false);
    L123:
        int r124 = ContextCompat.getColor(getContext(), c.b(com.larus.nova.R.attr.larus_neutral_50, getContext(), com.larus.nova.R.color.larus_neutral_50));
        LarusLayoutBrowserControlBlockViewBinding r125 = this.f308929a;
        if (r125 == null) goto L128;
        TextView r126 = r125.f358713i;
        if (r126 == null) goto L128;
        r126.setTextColor(r124);
    L128:
        LarusLayoutBrowserControlBlockViewBinding r127 = this.f308929a;
        if (r127 == null) goto L133;
        TextView r128 = r127.f358715k;
        if (r128 == null) goto L133;
        r128.setTextColor(r124);
    L133:
        LarusLayoutBrowserControlBlockViewBinding r129 = this.f308929a;
        if (r129 == null) goto L138;
        AppCompatImageView r130 = r129.f358712h;
        if (r130 == null) goto L138;
        r130.setColorFilter(r124);
    L138:
        LarusLayoutBrowserControlBlockViewBinding r131 = this.f308929a;
        if (r131 == null) goto L143;
        AppCompatImageView r132 = r131.f358714j;
        if (r132 == null) goto L143;
        r132.setColorFilter(r124);
    L143:
        e1.d(getBtnLeft(), new d(this));
        e1.d(getBrowserControlCover(), new e(r211, r109));
        return;
    L66:
        if (r121 != 2) goto L68;
        FrameLayout r133 = getBtnRight();
        if (r133 == null) goto L84;
        r133.setClickable(r111);
    L84:
        FrameLayout r134 = getBtnLeft();
        if (r134 == null) goto L87;
        r134.setClickable(r111);
    L87:
        LarusLayoutBrowserControlBlockViewBinding r135 = this.f308929a;
        if (r135 == null) goto L92;
        FrameLayout r136 = r135.f358710f;
        if (r136 == null) goto L92;
        e1.x(r136);
    L92:
        LarusLayoutBrowserControlBlockViewBinding r137 = this.f308929a;
        if (r137 == null) goto L97;
        FrameLayout r138 = r137.f358709e;
        if (r138 == null) goto L97;
        e1.x(r138);
    L97:
        int r139 = ContextCompat.getColor(getContext(), c.b(com.larus.nova.R.attr.larus_neutral_100, getContext(), com.larus.nova.R.color.larus_neutral_100));
        LarusLayoutBrowserControlBlockViewBinding r140 = this.f308929a;
        if (r140 == null) goto L102;
        TextView r141 = r140.f358713i;
        if (r141 == null) goto L102;
        r141.setTextColor(r139);
    L102:
        LarusLayoutBrowserControlBlockViewBinding r142 = this.f308929a;
        if (r142 == null) goto L107;
        TextView r143 = r142.f358715k;
        if (r143 == null) goto L107;
        r143.setTextColor(r139);
    L107:
        LarusLayoutBrowserControlBlockViewBinding r144 = this.f308929a;
        if (r144 == null) goto L112;
        AppCompatImageView r145 = r144.f358712h;
        if (r145 == null) goto L112;
        r145.setColorFilter(r139);
    L112:
        LarusLayoutBrowserControlBlockViewBinding r146 = this.f308929a;
        if (r146 == null) goto L143;
        AppCompatImageView r147 = r146.f358714j;
        if (r147 == null) goto L143;
        r147.setColorFilter(r139);
        goto L143
    L68:
        if (r121 != 3) goto L80;
        LarusLayoutBrowserControlBlockViewBinding r148 = this.f308929a;
        if (r148 == null) goto L74;
        FrameLayout r149 = r148.f358710f;
        if (r149 == null) goto L74;
        e1.o(r149);
    L74:
        LarusLayoutBrowserControlBlockViewBinding r150 = this.f308929a;
        if (r150 == null) goto L143;
        FrameLayout r151 = r150.f358709e;
        if (r151 == null) goto L143;
        e1.o(r151);
        goto L143
    L80:
        throw new NoWhenBranchMatchedException();
    L53:
        LarusLayoutBrowserControlBlockViewBinding r152 = this.f308929a;
        if (r152 == null) goto L58;
        SimpleDraweeView r153 = r152.f358706b;
        if (r153 == null) goto L58;
        e1.x(r153);
    L58:
        LarusLayoutBrowserControlBlockViewBinding r154 = this.f308929a;
        if (r154 == null) goto L63;
        View r155 = r154.f358708d;
        if (r155 == null) goto L63;
        e1.x(r155);
        goto L63
    L22:
        if (r109.length() <= 0) goto L24;
        boolean r156 = true;
    L25:
        if (r156 == false) goto L27;
        r111 = true;
        IMessageImageLoaderService.a.b(MessageImageLoader.f308183a, null, MessageImageType.IMAGE, r110, r109, "BrowserControlCover", null, null, new k(this), new l(this), new m(this), false, 1120);
        goto L33
    L24:
        r156 = false;
        goto L25
    }

    public BrowserControlView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        this.f308930b = LazyKt.lazy(new fj8.c(this));
        this.f308931c = LazyKt.lazy(new f(this));
        this.f308932d = LazyKt.lazy(new g(this));
        this.f308933e = LazyKt.lazy(new h(this));
        this.f308934f = LazyKt.lazy(new i(this));
        LayoutInflater.from(r110).inflate(com.larus.nova.R.layout.larus_layout_browser_control_block_view, this);
        int r113 = com.larus.nova.R.id.browser_control_cover;
        SimpleDraweeView r100 = (SimpleDraweeView) ViewBindings.findChildViewById(this, com.larus.nova.R.id.browser_control_cover);
        if (r100 == null) goto L25;
        r113 = com.larus.nova.R.id.browser_control_cover_mask;
        ShimmerMaskView r101 = (ShimmerMaskView) ViewBindings.findChildViewById(this, com.larus.nova.R.id.browser_control_cover_mask);
        if (r101 == null) goto L25;
        r113 = com.larus.nova.R.id.browser_control_cover_stub;
        View r102 = ViewBindings.findChildViewById(this, com.larus.nova.R.id.browser_control_cover_stub);
        if (r102 == null) goto L25;
        r113 = com.larus.nova.R.id.btn_left;
        FrameLayout r103 = (FrameLayout) ViewBindings.findChildViewById(this, com.larus.nova.R.id.btn_left);
        if (r103 == null) goto L25;
        r113 = com.larus.nova.R.id.btn_right;
        FrameLayout r104 = (FrameLayout) ViewBindings.findChildViewById(this, com.larus.nova.R.id.btn_right);
        if (r104 == null) goto L25;
        r113 = com.larus.nova.R.id.common_tool_header;
        DeepThinkCommonToolHeader r105 = (DeepThinkCommonToolHeader) ViewBindings.findChildViewById(this, com.larus.nova.R.id.common_tool_header);
        if (r105 == null) goto L25;
        r113 = com.larus.nova.R.id.left_button_icon;
        AppCompatImageView r106 = (AppCompatImageView) ViewBindings.findChildViewById(this, com.larus.nova.R.id.left_button_icon);
        if (r106 == null) goto L25;
        r113 = com.larus.nova.R.id.left_button_text;
        TextView r107 = (TextView) ViewBindings.findChildViewById(this, com.larus.nova.R.id.left_button_text);
        if (r107 == null) goto L25;
        r113 = com.larus.nova.R.id.right_button_icon;
        AppCompatImageView r114 = (AppCompatImageView) ViewBindings.findChildViewById(this, com.larus.nova.R.id.right_button_icon);
        if (r114 == null) goto L25;
        r113 = com.larus.nova.R.id.right_button_text;
        TextView r115 = (TextView) ViewBindings.findChildViewById(this, com.larus.nova.R.id.right_button_text);
        if (r115 == null) goto L25;
        this.f308929a = new LarusLayoutBrowserControlBlockViewBinding(this, r100, r101, r102, r103, r104, r105, r106, r107, r114, r115);
        return;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r113)));
    }

    public /* synthetic */ BrowserControlView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
