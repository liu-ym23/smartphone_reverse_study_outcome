package com.larus.bmhome.chat.standarduikit.coderenderandinterceptor.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.bmhome.chat.layout.widget.ShimmerLinearLayout;
import com.larus.bmhome.chat.markdown.code.ClickableMarkdownCodeView;
import com.larus.im.bean.message.Message;
import com.larus.mainbot.impl.databinding.LarusFlowMarkdownCodeViewHeaderBinding;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import qj8.g;
import qj8.l;
import qj8.m;
import ri8.c;
import ri8.d;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 =2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002:\u0001=B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0004H\u0016J_\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u00122\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0!2\b\u0010\"\u001a\u0004\u0018\u00010\u001d2\u0006\u0010#\u001a\u00020\u00122\b\u0010$\u001a\u0004\u0018\u00010\n2\b\u0010%\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010&J\u0018\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010)\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0012H\u0002JF\u0010*\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010+\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u00122\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0!2\u0006\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010-\u001a\u00020\u0018H\u0002J\b\u0010.\u001a\u00020\u0012H\u0002J\b\u0010/\u001a\u00020\nH\u0002J\u0018\u00100\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0004H\u0002J5\u00101\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\n\b\u0002\u00102\u001a\u0004\u0018\u0001032\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0002\u00105J\u0010\u00106\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0003H\u0002J\u0006\u00107\u001a\u00020\u0018J\u001a\u00108\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u00109\u001a\u00020\u0012H\u0002J\u001a\u0010:\u001a\u00020;2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00032\u0006\u0010<\u001a\u00020\nH\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/coderenderandinterceptor/view/FlowMarkdownCodeView;", "Landroid/widget/LinearLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/coderenderandinterceptor/view/FlowMarkdownCodeViewInput;", "Lcom/larus/bmhome/chat/standarduikit/coderenderandinterceptor/view/FlowMarkdownCodeViewOutput;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "markdownCodeView", "Lcom/larus/bmhome/chat/markdown/code/ClickableMarkdownCodeView;", "headerBinding", "Lcom/larus/mainbot/impl/databinding/LarusFlowMarkdownCodeViewHeaderBinding;", "isFold", "", "userClicked", "mobCardPosition", "runnable", "Ljava/lang/Runnable;", "bindData", "", "input", BdpAppEventConstant.PARAMS_OUTPUT, "bindContentData", "code", "", "realLanguage", "isFinish", "extraMap", "", "title", "enableDynamicCodeFence", "addedLines", "deletedLines", "(Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;)V", "setArrow", "isUserFold", "setArrowRotation", "bindHeaderData", "icon", "extra", "refreshCodeViewVisibility", "needShowCodeArea", "getTitleWidth", "mobShowCardHeader", "mobShowCard", "timeCost", "", "isSuccess", "(Lcom/larus/bmhome/chat/standarduikit/coderenderandinterceptor/view/FlowMarkdownCodeViewInput;Ljava/lang/Long;Ljava/lang/Boolean;Lcom/larus/bmhome/chat/standarduikit/coderenderandinterceptor/view/FlowMarkdownCodeViewOutput;)V", "getCodeWidgetOrder", "onRecycle", "getCardId", "isHeader", "sizeThatFits", "Landroid/util/Size;", "preferredMaxWidth", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowMarkdownCodeView extends LinearLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f308980g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClickableMarkdownCodeView f308981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LarusFlowMarkdownCodeViewHeaderBinding f308982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f308983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f308984d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f308985e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g f308986f;

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowMarkdownCodeView f308987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f308988b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationCancel(r100);
            FlowMarkdownCodeView.a(this.f308987a, this.f308988b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationEnd(r100);
            FlowMarkdownCodeView.a(this.f308987a, this.f308988b);
        }

        public b(FlowMarkdownCodeView r100, boolean r101) {
            this.f308987a = r100;
            this.f308988b = r101;
        }
    }

    static {
    }

    public FlowMarkdownCodeView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FlowMarkdownCodeView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final int getTitleWidth() {
        LarusFlowMarkdownCodeViewHeaderBinding r100 = this.f308982b;
        if (r100 == null) goto L9;
        ShimmerLinearLayout r101 = r100.f358597a;
        if (r101 == null) goto L9;
        if (r101.getVisibility() != 8) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        return 0;
    L12:
        LarusFlowMarkdownCodeViewHeaderBinding r103 = this.f308982b;
        if (r103 == null) goto L18;
        TextView r104 = r103.f358601e;
        if (r104 != null) goto L17;
        return 0;
    L17:
        return r104.getMeasuredWidth();
    L18:
        return 0;
    L9:
        r102 = false;
        goto L10
    }

    public final boolean d() {
        ClickableMarkdownCodeView r100 = this.f308981a;
        if (r100 != null) goto L5;
    L13:
        boolean r101 = false;
    L14:
        if (r101 == true) goto L16;
    L18:
        return false;
    L16:
        if (this.f308983c == true) goto L18;
        return true;
    L5:
        if (Intrinsics.areEqual(r100.f306934j, "STDOUT") == false) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 != true) goto L13;
        r101 = true;
        goto L14
    L8:
        if (r100.f306933i.length() <= 0) goto L10;
        r102 = true;
        goto L11
    }

    public final void e() {
        if (d() == false) goto L16;
        LarusFlowMarkdownCodeViewHeaderBinding r100 = this.f308982b;
        if (r100 == null) goto L13;
        ShimmerLinearLayout r101 = r100.f358598b;
        if (r101 == null) goto L13;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 == null) goto L12;
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
        r103.bottomMargin = i5.h();
        r101.setLayoutParams(r103);
        goto L13
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L13:
        ClickableMarkdownCodeView r104 = this.f308981a;
        if (r104 == null) goto L29;
        r104.setVisibility(0);
        return;
    L29:
        return;
    L16:
        LarusFlowMarkdownCodeViewHeaderBinding r105 = this.f308982b;
        if (r105 == null) goto L25;
        ShimmerLinearLayout r106 = r105.f358598b;
        if (r106 == null) goto L25;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if (r107 == null) goto L24;
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r107;
        r108.bottomMargin = 0;
        r106.setLayoutParams(r108);
        goto L25
    L24:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L25:
        ClickableMarkdownCodeView r109 = this.f308981a;
        if (r109 == null) goto L31;
        r109.setVisibility(8);
        return;
    }

    private final void setArrowRotation(boolean r100) {
        LarusFlowMarkdownCodeViewHeaderBinding r101 = this.f308982b;
        if (r101 == null) goto L11;
        AppCompatImageView r102 = r101.f358599c;
        if (r102 == null) goto L12;
        if (r100 == false) goto L8;
        float r103 = 270.0f;
    L9:
        r102.setRotation(r103);
        return;
    L8:
        r103 = 360.0f;
        goto L9
    L12:
        return;
    }

    public final int c(m r100) {
        int r101 = this.f308985e;
        if (r101 < 0) goto L5;
        return r101;
    L5:
        c r102 = c.f537890a;
        Intrinsics.checkNotNullParameter(this, "view");
        ViewParent r103 = getParent();
        if ((r103 instanceof ViewGroup) == false) goto L8;
        ViewGroup r104 = (ViewGroup) r103;
    L9:
        int r105 = 0;
        if (r104 != null) goto L13;
    L43:
        this.f308985e = r105;
        if (r105 != 0) goto L47;
        this.f308985e = r100.f533410e;
    L47:
        return this.f308985e;
    L13:
        if ((r104 instanceof FrameLayout) == false) goto L43;
        IntRange r106 = RangesKt.until(0, ((FrameLayout) r104).getChildCount());
        ArrayList r107 = new ArrayList();
        Iterator<Integer> r108 = r106.iterator();
    L17:
        if (r108.hasNext() == false) goto L34;
        View r109 = r104.getChildAt(((IntIterator) r108).nextInt());
        if ((r109 instanceof FlowMarkdownCodeView) == false) goto L21;
        FlowMarkdownCodeView r110 = (FlowMarkdownCodeView) r109;
    L22:
        if (r110 == null) goto L31;
        ViewGroup.LayoutParams r111 = ((FlowMarkdownCodeView) r109).getLayoutParams();
        if ((r111 instanceof ViewGroup.MarginLayoutParams) == false) goto L26;
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r111;
    L27:
        if (r112 == null) goto L29;
        int r113 = r112.topMargin;
    L30:
        Pair r114 = new Pair(r109, Integer.valueOf(r113));
    L32:
        if (r114 == null) goto L17;
        r107.add(r114);
        goto L17
    L29:
        r113 = 0;
        goto L30
    L26:
        r112 = null;
        goto L27
    L31:
        r114 = null;
        goto L32
    L21:
        r110 = null;
        goto L22
    L34:
        Iterator r115 = CollectionsKt.sortedWith(r107, new d()).iterator();
    L36:
        if (r115.hasNext() == false) goto L41;
        if (Intrinsics.areEqual(((Pair) r115.next()).getFirst(), this) == true) goto L42;
        r105 = r105 + 1;
    L42:
        r105 = r105 + 1;
        goto L43
    L41:
        r105 = -1;
        goto L42
    L8:
        r104 = null;
        goto L9
    }

    public static final /* synthetic */ void a(FlowMarkdownCodeView r100, boolean r101) {
        r100.setArrowRotation(r101);
    }

    public static String b(m r100, boolean r101) {
        String r102 = null;
        if (r101 == false) goto L9;
        StringBuilder r103 = new StringBuilder();
        Message r104 = r100.f533407b;
        if (r104 == null) goto L7;
        r102 = r104.getMessageId();
    L7:
        r103.append(r102);
        r103.append('_');
        r103.append(r100.f533410e);
        r103.append("_code_header");
        return r103.toString();
    L9:
        StringBuilder r105 = new StringBuilder();
        Message r106 = r100.f533407b;
        if (r106 == null) goto L12;
        r102 = r106.getMessageId();
    L12:
        r105.append(r102);
        r105.append('_');
        r105.append(r100.f533410e);
        r105.append("_code");
        return r105.toString();
    }

    public final void f(boolean r100, boolean r101) {
        if (r100 == false) goto L8;
        float r102 = 360.0f;
        float r103 = 270.0f;
        if (r101 == true) goto L7;
        r102 = 270.0f;
        r103 = 360.0f;
    L7:
        ValueAnimator r104 = ValueAnimator.ofFloat(new float[]{r102, r103});
        r104.setDuration(150);
        r104.addUpdateListener(new l(this));
        r104.addListener(new b(this, r101));
        r104.start();
        return;
    L8:
        setArrowRotation(r101);
    }

    public final Size g(m r100, int r101) {
        int r102 = View.MeasureSpec.makeMeasureSpec(r101, 1073741824);
        int r103 = 0;
        int r104 = View.MeasureSpec.makeMeasureSpec(0, 0);
        ClickableMarkdownCodeView r105 = this.f308981a;
        if (r105 == null) goto L5;
        r105.measure(r102, r104);
    L5:
        String r106 = r100.f533418m;
        if (r106 != null) goto L8;
    L11:
        boolean r107 = true;
    L12:
        if (r107 == false) goto L14;
        r101 = getTitleWidth();
    L14:
        ClickableMarkdownCodeView r108 = this.f308981a;
        if (r108 == null) goto L18;
        r103 = r108.getMeasuredHeight();
    L18:
        return new Size(r101, r103);
    L8:
        if (r106.length() == 0) goto L11;
        r107 = false;
        goto L12
    }

    public FlowMarkdownCodeView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f308985e = -1;
        setOrientation(1);
        AttributeSet r103 = null;
        ClickableMarkdownCodeView r104 = new ClickableMarkdownCodeView(r100, r103, 6, 0);
        this.f308981a = r104;
        addView(r104, -1, -2);
        r104.setVisibility(8);
    }

    public /* synthetic */ FlowMarkdownCodeView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
