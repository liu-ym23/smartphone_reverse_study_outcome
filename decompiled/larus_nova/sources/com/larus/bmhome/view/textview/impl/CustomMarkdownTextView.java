package com.larus.bmhome.view.textview.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.byted.cast.common.CastMonitor;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.api.t;
import com.larus.bmhome.utils.s2;
import com.larus.bmhome.view.textview.impl.phone.PhoneAppLogHelper;
import com.larus.business.markdown.api.depend.IMarkdownLoggerKt;
import com.larus.business.markdown.api.depend.d;
import com.larus.business.markdown.impl.markwon.MarkwonContent;
import com.larus.business.markdown.impl.markwon.c;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import fh8.f;
import fh8.h;
import io.noties.markwon.onetex.LatexMathBlock;
import io.noties.markwon.onetex.LatexMathNode;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import lsc.i;
import lsc.v;
import lsc.w;
import lw8.l;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.node.Link;
import org.commonmark.node.StrongEmphasis;
import tsc.o;
import uvc.b;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 f2\u00020\u00012\u00020\u0002:\u0001fB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001a\u00103\u001a\u00020\u000e2\b\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u00020\u000eH\u0016J\b\u00107\u001a\u000208H\u0014J\u0018\u00109\u001a\u0002082\u0006\u0010:\u001a\u00020\b2\u0006\u0010;\u001a\u00020\bH\u0014J0\u0010<\u001a\u0002082\u0006\u0010=\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020\b2\u0006\u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\bH\u0014J(\u0010B\u001a\u0002082\u0006\u0010>\u001a\u00020\b2\u0006\u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\bH\u0016J(\u0010C\u001a\u0002082\u0006\u0010D\u001a\u00020\b2\u0006\u0010?\u001a\u00020\b2\u0006\u0010E\u001a\u00020\b2\u0006\u0010A\u001a\u00020\bH\u0016J\u0010\u0010F\u001a\u0002082\u0006\u0010G\u001a\u00020HH\u0014J0\u0010I\u001a\u0002082\b\u0010J\u001a\u0004\u0018\u00010\u00152\b\u0010K\u001a\u0004\u0018\u00010L2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\u0012\u0010O\u001a\u0002082\b\u0010P\u001a\u0004\u0018\u00010QH\u0016J\u0012\u0010I\u001a\u0002082\b\u0010J\u001a\u0004\u0018\u00010\u0015H\u0016J\u001c\u0010R\u001a\u0002082\b\u0010S\u001a\u0004\u0018\u00010T2\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\b\u0010W\u001a\u00020\u0000H\u0016J\b\u0010X\u001a\u00020\bH\u0016J\b\u0010Y\u001a\u000208H\u0016J\u001e\u0010Z\u001a\u0002082\b\u0010S\u001a\u0004\u0018\u00010T2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010VH\u0002J\b\u0010[\u001a\u000208H\u0002J.\u0010\\\u001a\u0002082\b\u0010J\u001a\u0004\u0018\u00010\u00152\u0006\u0010]\u001a\u00020\u000e2\b\u0010^\u001a\u0004\u0018\u00010\u00192\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J\n\u0010a\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010b\u001a\u000208H\u0016J\b\u0010/\u001a\u00020\u000eH\u0016J\b\u00100\u001a\u00020\u000eH\u0016J\b\u00101\u001a\u00020\u000eH\u0016J\b\u00102\u001a\u00020\u000eH\u0016J\u0012\u0010b\u001a\u0002082\b\u0010c\u001a\u0004\u0018\u00010dH\u0002J\b\u0010e\u001a\u000208H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\"\u0010!\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u001c\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020%\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R@\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020%\u0018\u00010$2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020%\u0018\u00010$8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010\u0019X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001b\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006g"}, d2 = {"Lcom/larus/bmhome/view/textview/impl/CustomMarkdownTextView;", "Lcom/larus/bmhome/view/textview/impl/CustomUnderlineTextView;", "Lcom/larus/bmhome/view/textview/api/ICustomMarkdownTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "jumpAnalyzer", "Lcom/larus/business/markdown/impl/markwon/JumpAnalyzer;", "settingMd", "", "markdownWidth", "getMarkdownWidth", "()I", "setMarkdownWidth", "(I)V", "markdownContent", "Lcom/larus/business/markdown/api/model/MarkdownContent;", "getMarkdownContent", "()Lcom/larus/business/markdown/api/model/MarkdownContent;", "onBoardingType", "", "getOnBoardingType", "()Ljava/lang/String;", "value", "Lcom/larus/business/markdown/impl/markwon/MarkwonContent;", "markwonContent", "getMarkwonContent", "()Lcom/larus/business/markdown/impl/markwon/MarkwonContent;", "onboardingType", "getOnboardingType", "payloadParam", "", "", WsConstants.KEY_PAYLOAD, "getPayload", "()Ljava/util/Map;", "setPayload", "(Ljava/util/Map;)V", "markdownTextMonitorCache", "getMarkdownTextMonitorCache", "setMarkdownTextMonitorCache", "(Ljava/lang/String;)V", "hasLink", "hasFormula", "hasTable", "hasBold", "requestRectangleOnScreen", "rectangle", "Landroid/graphics/Rect;", "immediate", "onAttachedToWindow", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "setPadding", "setPaddingRelative", "start", "end", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setMarkdown", "content", "highlight", "Lkotlin/ranges/IntRange;", "setMarkdownCallback", "Lio/noties/markwon/SetMarkdownCallback;", "onInitializeAccessibilityNodeInfo", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "setText", "text", "", "type", "Landroid/widget/TextView$BufferType;", "asTextView", "getSelectedColor", "onRecycled", "setTextDirectly", "onSpanRecycled", "analysisJump", "stream", "messageId", "listener", "Lcom/larus/business/markdown/api/view/text/JumpListener;", "getOriginText", "checkNode", "node", "Lorg/commonmark/node/Node;", "startAppLogJob", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomMarkdownTextView extends CustomUnderlineTextView implements rt8.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f317419j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f317420k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f317421l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public MarkwonContent f317422m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f317423n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Map<String, Object> f317424o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f317425p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f317426q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f317427r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f317428s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f317429t;

    public static final class a {
    }

    static {
    }

    public CustomMarkdownTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CustomMarkdownTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // rt8.a
    public final void a() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L17
        CharSequence r101 = getText();     // Catch: Throwable -> L17
        if ((r101 instanceof Spanned) == false) goto L6;
        Spanned r102 = (Spanned) r101;     // Catch: Throwable -> L17
    L7:
        int r103 = 0;
        if (r102 == null) goto L11;
        o[] r104 = (o[]) r102.getSpans(0, getText().length(), o.class);     // Catch: Throwable -> L17
        if (r104 == null) goto L11;
    L12:
        int r105 = r104.length;     // Catch: Throwable -> L17
    L13:
        if (r103 >= r105) goto L15;
        r104[r103].f(this);     // Catch: Throwable -> L17
        r103 = r103 + 1;     // Catch: Throwable -> L17
        goto L13
    L15:
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L22;
        FLogger.f375446a.i("MarkdownTextView", r107.toString());
    L22:
        this.f317419j.getClass();
        Map<String, Object> r108 = this.f317424o;
        if (r108 == null) goto L33;
        f r109 = h.b(r108);
        if (r109 == null) goto L33;
        Message r110 = r109.f477072b;
        if (r110 == null) goto L33;
        String r111 = r110.getMessageId();
        if (r111 == null) goto L33;
        t r112 = ILegacyChatUiServiceDelegate.f297164b.V8();
        if (r112 == null) goto L33;
        r112.b(r111, this);
    L33:
        super.setText("", TextView.BufferType.NORMAL);
        MarkwonContent r113 = this.f317422m;
        if (r113 == null) goto L38;
        SpannableStringBuilder r114 = r113.f320556a;
        if (r114 == null) goto L38;
        r114.clear();
    L38:
        MarkwonContent r115 = this.f317422m;
        if (r115 == null) goto L41;
        r115.j(this);
    L41:
        MarkwonContent r116 = this.f317422m;
        if (r116 == null) goto L44;
        r116.k(this);
    L44:
        MarkwonContent r117 = this.f317422m;
        if (r117 == null) goto L47;
        r117.l(this);
    L47:
        this.f317422m = null;
        this.f317423n = null;
        setMarkdownTextMonitorCache(null);
        return;
    L11:
        r104 = new o[0];     // Catch: Throwable -> L17
        goto L12
    L6:
        r102 = null;
    L17:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    @Override // ow8.a
    public final TextView o() {
        return this;
    }

    @Override // android.view.View
    public final boolean requestRectangleOnScreen(Rect r100, boolean r101) {
        return false;
    }

    @Override // rt8.a
    public String getOriginText() {
        MarkwonContent r100 = this.f317422m;
        if (r100 == null) goto L7;
        b r101 = r100.f320560e;
        if (r101 == null) goto L7;
        return r101.f551905f;
    L7:
        return null;
    }

    @Override // ow8.a
    public int getSelectedColor() {
        return ContextCompat.getColor(getContext(), R.color.larus_text_highlight);
    }

    @Override // rt8.a
    public final void h() {
        long r100 = SystemClock.elapsedRealtime();
        this.f317426q = false;
        this.f317427r = false;
        this.f317428s = false;
        this.f317429t = false;
        MarkwonContent r101 = this.f317422m;
        if (r101 == null) goto L5;
        b r102 = r101.f320560e;
    L6:
        B(r102);
        FLogger.f375446a.d("MarkdownTextView", "checkNode, hasLink[" + this.f317426q + "], cost: " + (SystemClock.elapsedRealtime() - r100));
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.larus.bmhome.view.textview.impl.SelectorTextView, android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        MarkwonContent r100 = this.f317422m;
        if (r100 == null) goto L9;
        List r101 = (List) r100.f320568m.getValue();
        if (r101 == null) goto L9;
        boolean r102 = true;
        if ((!r101.isEmpty()) != true) goto L9;
    L10:
        if (r102 == false) goto L12;
        C(this.f317422m, null, null, null);
    L12:
        Map<String, Object> r103 = this.f317424o;
        if (r103 == null) goto L24;
        f r104 = h.b(r103);
        if (r104 == null) goto L25;
        Message r105 = r104.f477072b;
        if (r105 == null) goto L26;
        String r106 = r105.getMessageId();
        if (r106 == null) goto L27;
        t r107 = ILegacyChatUiServiceDelegate.f297164b.V8();
        if (r107 == null) goto L28;
        r107.f(r106, this);
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L9:
        r102 = false;
        goto L10
    }

    @Override // rt8.a
    public final boolean d() {
        return this.f317428s;
    }

    @Override // rt8.a
    public final boolean e() {
        return this.f317427r;
    }

    @Override // rt8.a
    public final boolean g() {
        return this.f317426q;
    }

    @Override // ow8.a
    public l getMarkdownContent() {
        return this.f317422m;
    }

    @Override // rt8.a
    public String getMarkdownTextMonitorCache() {
        return this.f317425p;
    }

    @Override // ow8.a
    public int getMarkdownWidth() {
        return this.f317421l;
    }

    public final MarkwonContent getMarkwonContent() {
        return this.f317422m;
    }

    public String getOnBoardingType() {
        return this.f317423n;
    }

    public final String getOnboardingType() {
        return this.f317423n;
    }

    @Override // rt8.a
    public Map<String, Object> getPayload() {
        return this.f317424o;
    }

    @Override // rt8.a
    public final boolean m() {
        return this.f317429t;
    }

    public final void B(b r100) {
        if ((r100 instanceof Link) == false) goto L6;
        this.f317426q = true;
    L17:
        if (r100 == null) goto L19;
        b r101 = r100.f551901b;
    L20:
        if (r101 == null) goto L22;
        B(r101);
        r101 = r101.f551904e;
        goto L20
    L22:
        return;
    L19:
        r101 = null;
        goto L20
    L6:
        if ((r100 instanceof LatexMathNode) == false) goto L8;
    L16:
        this.f317427r = true;
        goto L17
    L8:
        if ((r100 instanceof LatexMathBlock) == true) goto L16;
        if ((r100 instanceof TableBlock) == false) goto L14;
        this.f317428s = true;
        goto L17
    L14:
        if ((r100 instanceof StrongEmphasis) == false) goto L17;
        this.f317429t = true;
        goto L17
    }

    @Override // com.larus.bmhome.view.textview.impl.CustomUnderlineTextView, android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r100) {
        super.onInitializeAccessibilityNodeInfo(r100);
        if (r100 == null) goto L6;
        int r101 = s2.f315111a;
        r100.setContentDescription(s2.b(this.f317422m, null, 6));
        return;
    }

    public void setMarkdown(l r100) {
        C(r100, null, null, null);
    }

    @Override // rt8.a
    public void setMarkdownTextMonitorCache(String r100) {
        this.f317425p = r100;
    }

    public void setMarkdownWidth(int r100) {
        this.f317421l = r100;
    }

    public void setPayload(Map<String, Object> r100) {
        this.f317424o = r100;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = w.f510624a;     // Catch: Throwable -> L16
        getPaint();     // Catch: Throwable -> L16
        if (getMarkdownWidth() <= 0) goto L6;
        getMarkdownWidth();     // Catch: Throwable -> L16
        getPaddingStart();     // Catch: Throwable -> L16
        getPaddingEnd();     // Catch: Throwable -> L16
    L6:
        if (getMarkdownWidth() <= 0) goto L14;
        MarkwonContent r103 = this.f317422m;     // Catch: Throwable -> L16
        boolean r104 = false;
        if (r103 != null) goto L10;
    L12:
        if (r104 == false) goto L14;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(getMarkdownWidth(), 1073741824), r101);     // Catch: Throwable -> L16
        return;
    L10:
        if (r103.f320558c != true) goto L12;
        r104 = true;
    L14:
        super.onMeasure(r100, r101);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        int r105 = w.f510624a;
        throw th;
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        if (this.f317420k == true) goto L25;
        MarkwonContent r102 = this.f317422m;
        if (r102 == null) goto L25;
        lw8.h r103 = r102.f320561f;
        if (r103 == null) goto L25;
        i r104 = r103.a();
        if (r104 == null) goto L25;
        this.f317420k = true;     // Catch: Throwable -> L22
        if ((r100 instanceof Spanned) == false) goto L16;
        Spanned r105 = (Spanned) r100;     // Catch: Throwable -> L22
    L17:
        if (r105 != null) goto L19;
        r105 = new SpannableString(r100);     // Catch: Throwable -> L22
    L19:
        r104.d(this, r105, null);     // Catch: Throwable -> L22
        this.f317420k = false;
        return;
    L16:
        r105 = null;
    L22:
        th = move-exception;
        this.f317420k = false;
        throw th;
    L25:
        if (r101 != null) goto L27;
        r101 = TextView.BufferType.NORMAL;
    L27:
        super.setText(r100, r101);
    }

    public CustomMarkdownTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f317419j = new c();
        setHighlightColor(0);
    }

    public /* synthetic */ CustomMarkdownTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void C(l r110, IntRange r111, String r112, v r113) {
        SpannableStringBuilder r100 = null;
        if (r110 == null) goto L11;
        if ((r110 instanceof MarkwonContent) == true) goto L11;
        d r101 = IMarkdownLoggerKt.a();
        if (r101 == null) goto L13;
        r101.e("mark_down", "unsupport markdown: " + r110);
    L13:
        MarkwonContent r114 = null;
    L14:
        this.f317422m = r114;
        this.f317423n = r112;
        if (r114 == null) goto L17;
        SpannableStringBuilder r115 = r114.f320556a;
    L18:
        if (r115 != null) goto L21;
        super.setText("", TextView.BufferType.NORMAL);
        return;
    L21:
        boolean r102 = false;
        if (r111 == null) goto L24;
        int r103 = RangesKt.coerceAtLeast(r111.getFirst(), 0);
    L26:
        if (r111 == null) goto L28;
        int r116 = RangesKt.coerceAtMost(r111.getLast() + 1, r115.length());
    L30:
        if (r116 <= r103) goto L93;
        SpannableStringBuilder r104 = new SpannableStringBuilder(r115);
        r104.setSpan(new BackgroundColorSpan(ContextCompat.getColor(getContext(), v19.c.b(R.attr.primary_transparent_2, getContext(), R.color.primary_transparent_2))), r103, r116, 17);
        if (AppHost.f326268a.isDebug() == false) goto L36;
        d r117 = IMarkdownLoggerKt.a();
        if (r117 == null) goto L36;
        r117.v("MarkdownTextView", "MdRead: [" + r103 + ", " + r116 + ")==>" + r104.subSequence(r103, r116).toString());
    L36:
        r115 = r104;
    L93:
        int r118 = w.f510624a;     // Catch: Throwable -> L88
        getPaint();     // Catch: Throwable -> L88
        if (getMarkdownWidth() <= 0) goto L40;
        getMarkdownWidth();     // Catch: Throwable -> L88
        getPaddingStart();     // Catch: Throwable -> L88
        getPaddingEnd();     // Catch: Throwable -> L88
    L40:
        this.f317420k = true;     // Catch: Throwable -> L88
        Intrinsics.checkNotNullParameter(r115, "builder");     // Catch: Throwable -> L88
        tt8.b r119 = m8544getTextSelector();     // Catch: Throwable -> L88
        if (r119 == null) goto L91;
        int r105 = Math.max(r119.f551665l, 0);     // Catch: Throwable -> L88
        int r106 = Math.min(r119.f551666m, r115.length());     // Catch: Throwable -> L88
        if (r106 <= r105) goto L91;
        r115.setSpan(r119.f551668o, r105, r106, 17);     // Catch: Throwable -> L88
    L91:
        Result.Companion r120 = Result.Companion;     // Catch: Throwable -> L53
        lw8.h r121 = r114.f320561f;     // Catch: Throwable -> L53
        if (r121 == null) goto L50;
        i r122 = r121.a();     // Catch: Throwable -> L53
        if (r122 == null) goto L50;
        r122.d(this, r115, r113);     // Catch: Throwable -> L53
    L51:
        Object r123 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L53
    L55:
        Throwable r124 = Result.m9452exceptionOrNullimpl(r123);     // Catch: Throwable -> L88
        if (r124 == null) goto L58;
        EnsureManager.ensureNotReachHere(r124);     // Catch: Throwable -> L88
        super.setText(r115, TextView.BufferType.NORMAL);     // Catch: Throwable -> L88
    L58:
        this.f317420k = false;
        int r125 = w.f510624a;
        MarkwonContent r126 = this.f317422m;
        if (r126 != null) goto L61;
    L63:
        if (r102 == false) goto L97;
        Map<String, Object> r127 = this.f317424o;
        if (r127 == null) goto L68;
        f r128 = h.b(r127);
    L69:
        if (r128 == null) goto L95;
        Message r129 = r128.f477072b;
        if (r129 == null) goto L96;
        String r107 = r129.getMessageId();
        if (r107 == null) goto L98;
        String r130 = r128.f477074d;
        if (r130 != null) goto L83;
        Message r131 = r128.f477072b;
        if (r131 == null) goto L80;
        r130 = r131.getSenderId();
    L81:
        if (r130 != null) goto L83;
        return;
    L80:
        r130 = null;
    L83:
        String r108 = r130;
        int r132 = PhoneAppLogHelper.f317451a;
        Context r109 = getContext();
        MarkwonContent r133 = this.f317422m;
        if (r133 == null) goto L86;
        r100 = r133.f320556a;
    L86:
        PhoneAppLogHelper.a(r109, r107, r108, r100, r128.f477087q, false);
        return;
    L98:
        return;
    L96:
        return;
    L95:
        return;
    L68:
        r128 = null;
        goto L69
    L97:
        return;
    L61:
        if (r126.f320563h != true) goto L63;
        r102 = true;
        goto L63
    L50:
        super.setText(r115, TextView.BufferType.NORMAL);     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        Result.Companion r134 = Result.Companion;     // Catch: Throwable -> L88
        r123 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L88
    L88:
        th = move-exception;
        this.f317420k = false;
        int r135 = w.f510624a;
        throw th;
    L28:
        r116 = 0;
        goto L30
    L24:
        r103 = 0;
        goto L26
    L17:
        r115 = null;
    L11:
        if ((r110 instanceof MarkwonContent) == false) goto L13;
        r114 = (MarkwonContent) r110;
        goto L14
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int r100, int r101, int r102, int r103) {
        super.setPadding(r100, r101, r102, r103);
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPaddingRelative(int r100, int r101, int r102, int r103) {
        super.setPaddingRelative(r100, r101, r102, r103);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
