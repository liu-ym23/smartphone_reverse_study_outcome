package com.larus.bmhome.chat.markdown.imagegroup;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.im.bean.message.Message;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import v19.c7;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ>\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\"\u0018\u00010!H\u0016J\u0016\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&H\u0002J\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020)0&2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&H\u0002J\u0016\u0010*\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&H\u0002JV\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020-2\u001e\u0010.\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u000f000&0/2\u0006\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u00020\u001f2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u00103\u001a\u00020\u001fH\u0002J\b\u00104\u001a\u00020\u000fH\u0016J\u0018\u00105\u001a\u00020$2\u0006\u00106\u001a\u0002072\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/larus/bmhome/chat/markdown/imagegroup/SimpleImageGroupWidget;", "Landroid/widget/FrameLayout;", "Lio/noties/markwon/html/customdata/ICustomDataWidget;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "spanSize", "Landroid/util/Size;", "widgetSize", "lastBindJob", "Lkotlinx/coroutines/Job;", "currInflateView", "Landroid/view/View;", "mobChatType", "", "mobBotId", "mobCurrentPage", "mobPreviousPage", "markdownCommonInputData", "Lcom/larus/bmhome/chat/markdown/MarkdownCommonInputData;", "bindData", "textView", "Landroid/widget/TextView;", "text", "Landroid/text/Spanned;", "span", "Lio/noties/markwon/html/customdata/ICustomDataSpan;", "maxWidth", "", WsConstants.KEY_PAYLOAD, "", "", "updateSimpleImageGroupUISingle", "", "images", "", "Lcom/larus/bmhome/chat/markdown/imagegroup/SimpleImageGroupImageInfo;", "getBigImageInfoList", "Lcom/larus/bmhome/bigimg/BigImageInfo;", "updateSimpleImageGroupUIMore", "bindImage", "imageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageViewListGetter", "Lkotlin/Function0;", "Lkotlin/Pair;", "targetWidth", "targetHeight", "index", "asView", "updateSpanSize", "data", "Lcom/larus/bmhome/chat/markdown/imagegroup/SimpleImageGroupData;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SimpleImageGroupWidget extends FrameLayout implements usc.f {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f307041i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Size f307042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Size f307043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Job f307044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f307045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f307046e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f307047f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f307048g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public fh8.f f307049h;

    @Override // usc.f
    public final void a() {
    }

    @Override // usc.f
    public final View asView() {
        return this;
    }

    @Override // usc.f
    public final Integer b(Size r100, TextView r101, Canvas r102, Paint r103) {
        return null;
    }

    @Override // usc.f
    public final Size c(TextView r100, usc.e r101, Map<String, ? extends Object> r102) {
        return null;
    }

    @Override // usc.f
    public final void e() {
    }

    @Override // usc.f
    public final void f() {
    }

    public SimpleImageGroupWidget(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public SimpleImageGroupWidget(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f307042a = new Size(0, 0);
        this.f307043b = new Size(0, 0);
    }

    @Override // usc.f
    public final Size d(TextView r100, Spanned r101, usc.e r102, int r110, Map<String, ? extends Object> r111) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r102, "span");
        fh8.f r103 = fh8.h.b(r111);
        this.f307049h = r103;
        if (r103 == null) goto L5;
        String r112 = r103.f477075e;
    L6:
        this.f307047f = r112;
        if (r103 == null) goto L9;
        String r113 = r103.f477076f;
    L10:
        this.f307048g = r113;
        if (r103 == null) goto L13;
        String r114 = r103.f477074d;
    L14:
        this.f307046e = r114;
        if (r103 == null) goto L17;
        String r104 = r103.f477071a;
    L18:
        this.f307045d = r104;
    L57:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        return this.f307042a;
    L20:
        if (r102.k().length() != 0) goto L22;
        boolean r105 = true;
    L23:
        if (r105 == false) goto L25;
        final String r106 = r102.h();     // Catch: Exception -> L57
    L38:
        if (r106 != null) goto L40;
        r106 = SliceInitService.DEFAULT_SWITCH;
    L40:
        d r107 = (d) fh8.b.a(r102, new h(r106));     // Catch: Exception -> L57
        Intrinsics.checkNotNull(r107);
        if (r107.a() == null) goto L47;
        if (r107.a().size() != 1) goto L47;
        int r108 = (r110 * 9) / 16;
        this.f307042a = new Size(r110, r108);
        this.f307043b = new Size(r110, r108);
    L52:
        Job r109 = this.f307044c;
        if (r109 == null) goto L55;
        Job.DefaultImpls.cancel$default(r109, null, 1, null);
    L55:
        this.f307044c = BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new SimpleImageGroupWidget$bindData$1(r107, this, null), 3, null);
        return this.f307042a;
    L47:
        if (r107.a() != null) goto L49;
    L51:
        this.f307042a = new Size(0, 0);
        this.f307043b = new Size(0, 0);
        goto L52
    L49:
        if (r107.a().size() <= 1) goto L51;
        int r115 = (r110 - (c7.b(4) * 2)) / 3;
        this.f307042a = new Size(r110, r115);
        this.f307043b = new Size(r115, r115);
        goto L52
    L25:
        fh8.f r116 = this.f307049h;     // Catch: Exception -> L57
        if (r116 == null) goto L29;
        Message r117 = r116.f477072b;     // Catch: Exception -> L57
    L31:
        if (r117 == null) goto L37;
        wc8.b r118 = wc8.b.f559187a;     // Catch: Exception -> L57
        String r119 = r117.getMessageId();     // Catch: Exception -> L57
        if (r119 != null) goto L35;
        r119 = "";
    L35:
        r106 = r118.c(r119, r102.k(), "SimpleImageGroupWidget");     // Catch: Exception -> L57
        if (r106 != null) goto L38;
    L37:
        r106 = wc8.b.f559187a.b(r102.k(), "SimpleImageGroupWidget");     // Catch: Exception -> L57
        goto L38
    L29:
        r117 = null;
        goto L31
    L22:
        r105 = false;
        goto L23
    L17:
        r104 = null;
        goto L18
    L13:
        r114 = null;
        goto L14
    L9:
        r113 = null;
        goto L10
    L5:
        r112 = null;
        goto L6
    }

    public final void g(SimpleDraweeView r110, final Function0<? extends List<? extends Pair<Integer, ? extends View>>> r111, int r112, int r113, final List<e> r114, final int r115) {
        e r100 = (e) ListProtector.get(r114, r115);
        int r101 = oi8.j.f523459a;
        String r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        oi8.j.b(r110, r102, "markdown.simple_image_group_cover_thumb", Integer.valueOf(r112), Integer.valueOf(r113), null, null, null, false, 992);
        r110.setOnClickListener(new i(this, r111, r114, r115));
    }
}
