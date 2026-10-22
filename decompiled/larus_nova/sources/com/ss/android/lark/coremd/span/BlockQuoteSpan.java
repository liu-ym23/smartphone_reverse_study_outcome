package com.ss.android.lark.coremd.span;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.LineHeightSpan;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.coremd.base.parse.j;
import com.ss.android.lark.coremd.base.parse.k;
import com.ss.android.lark.coremd.base.theme.BlockQuoteThemeData;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.utils.e;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\rH\u0016Jh\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010,\u001a\u00020-H\u0016J<\u0010.\u001a\u00020\u001f2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0010\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\rH\u0002J\u0010\u00105\u001a\u00020\t2\u0006\u00106\u001a\u00020\rH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u0016\u0010\u0015\u001a\n \u0017*\u0004\u0018\u00010\u00160\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/ss/android/lark/coremd/span/BlockQuoteSpan;", "Landroid/text/style/LeadingMarginSpan;", "Landroid/text/style/LineHeightSpan;", "Landroid/text/style/ForegroundColorSpan;", "theme", "Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", GXTemplateKey.FLEXBOX_PADDING, "", "<init>", "(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;Landroid/content/Context;I)V", "showTopPadding", "", "getShowTopPadding$core_md_release", "()Z", "setShowTopPadding$core_md_release", "(Z)V", "showBottomPadding", "getShowBottomPadding$core_md_release", "setShowBottomPadding$core_md_release", "paint", "Landroid/graphics/Paint;", "kotlin.jvm.PlatformType", "themeData", "Lcom/ss/android/lark/coremd/base/theme/BlockQuoteThemeData;", "quoteWidth", "quoteMargin", "getLeadingMargin", SoloKtvContext.SOLO_PAGE_FIRST, "drawLeadingMargin", "", "c", "Landroid/graphics/Canvas;", "p", "x", MapBundleKey.MapObjKey.OBJ_DIR, "top", "baseline", "bottom", "text", "", "start", "end", "layout", "Landroid/text/Layout;", "chooseHeight", "spanstartv", "lineHeight", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "obtainTopPadding", "isFirst", "obtainBottomPadding", "isLast", "core-md_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BlockQuoteSpan extends ForegroundColorSpan implements LeadingMarginSpan, LineHeightSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f419925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f419926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f419927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f419928d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f419929e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BlockQuoteThemeData f419930f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f419931g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f419932h;

    @Override // android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean r100) {
        return this.f419931g + this.f419932h;
    }

    public BlockQuoteSpan(j r100, Context r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "theme");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        k.a r103 = k.f419543b;
        BlockQuoteThemeData r104 = r103.b(r100);
        c r105 = r104.f419553i;
        KProperty<Object>[] r106 = BlockQuoteThemeData.f419547j;
        super(UIUtils.getColor(r101, ((Number) r105.getValue(r104, r106[5])).intValue()));
        this.f419925a = r101;
        this.f419926b = r102;
        this.f419927c = true;
        this.f419928d = true;
        this.f419929e = e.f419972c;
        BlockQuoteThemeData r107 = r103.b(r100);
        this.f419930f = r107;
        this.f419931g = UIUtils.dp2px(r101, ((Number) r107.f419549e.getValue(r107, r106[1])).intValue());
        this.f419932h = UIUtils.dp2px(r101, ((Number) r107.f419552h.getValue(r107, r106[4])).intValue());
    }

    @Override // android.text.style.LineHeightSpan
    public final void chooseHeight(CharSequence r100, int r101, int r102, int r103, int r104, Paint.FontMetricsInt r105) {
        if (r105 != null) goto L4;
        return;
    L4:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.text.Spanned");
        Spanned r106 = (Spanned) r100;
        int r107 = r106.getSpanStart(this);
        int r108 = r106.getSpanEnd(this);
        boolean r109 = true;
        int r110 = 0;
        if (r107 != r101) goto L7;
        boolean r111 = true;
    L9:
        if (r108 != (r102 - 1)) goto L11;
    L14:
        int r112 = r105.descent;
        int r113 = r105.ascent;
        if ((r112 - r113) > 0) goto L18;
        return;
    L18:
        if (this.f419927c == false) goto L21;
        if (r111 == false) goto L21;
        int r114 = this.f419926b;
    L22:
        int r115 = r112 + r114;
        r105.descent = r115;
        if (this.f419928d == false) goto L26;
        if (r109 == false) goto L26;
        r110 = this.f419926b;
    L26:
        int r116 = r113 - r110;
        r105.ascent = r116;
        r105.top = r116;
        r105.bottom = r115;
        return;
    L21:
        r114 = 0;
        goto L22
    L11:
        if (r108 == r106.length()) goto L14;
        r109 = false;
        goto L14
    L7:
        r111 = false;
        goto L9
    }

    @Override // android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas r110, Paint r111, int r112, int r113, int r114, int r115, int r210, CharSequence r211, int r212, int r213, boolean r214, Layout r215) {
        Intrinsics.checkNotNullParameter(r110, "c");
        Intrinsics.checkNotNullParameter(r111, "p");
        Intrinsics.checkNotNullParameter(r211, "text");
        Intrinsics.checkNotNullParameter(r215, "layout");
        Spanned r100 = (Spanned) r211;
        int r101 = r100.getSpanStart(this);
        int r102 = r100.getSpanEnd(this);
        int r103 = 0;
        boolean r104 = true;
        if (r101 != r212) goto L5;
        boolean r105 = true;
    L6:
        if (r212 <= r102) goto L8;
    L10:
        r104 = false;
    L11:
        int r106 = this.f419931g;
        this.f419929e.set(r111);
        this.f419929e.setStyle(Paint.Style.FILL);
        Paint r107 = this.f419929e;
        Context r108 = this.f419925a;
        BlockQuoteThemeData r109 = this.f419930f;
        r107.setColor(UIUtils.getColor(r108, ((Number) r109.f419551g.getValue(r109, BlockQuoteThemeData.f419547j[3])).intValue()));
        float r116 = r112;
        float r117 = r114;
        if (this.f419927c == false) goto L15;
        if (r105 == false) goto L15;
        int r118 = this.f419926b;
    L16:
        float r119 = r117 + r118;
        float r120 = r112 + (r106 * r113);
        float r121 = r210;
        if (this.f419928d == false) goto L20;
        if (r104 == false) goto L20;
        r103 = this.f419926b;
    L20:
        r110.drawRect(r116, r119, r120, r121 - r103, this.f419929e);
        return;
    L15:
        r118 = 0;
        goto L16
    L8:
        if (r102 > r213) goto L10;
    L5:
        r105 = false;
        goto L6
    }
}
