package com.ss.android.ugc.aweme.discover.commodity.holder.guidesearch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAppInfo;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService;
import com.ss.android.ugc.aweme.search.service.TradeSearch;
import com.ss.android.ugc.aweme.search.utils.extensions.DimenExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001.B\u0011\b\u0016\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(B\u001b\b\u0016\u0012\u0006\u0010&\u001a\u00020%\u0012\b\u0010*\u001a\u0004\u0018\u00010)¢\u0006\u0004\b'\u0010+B#\b\u0016\u0012\u0006\u0010&\u001a\u00020%\u0012\b\u0010*\u001a\u0004\u0018\u00010)\u0012\u0006\u0010,\u001a\u00020\n¢\u0006\u0004\b'\u0010-R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0013R*\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u001d\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0013R$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006/"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/CommodityGuideSearchFixWidthContainer;", "Landroid/widget/FrameLayout;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, FaceService.girlLabel, "getFontScale", "()F", "setFontScale", "(F)V", "fontScale", "", "b", "I", "getDefaultItemWidth", "()I", "defaultItemWidth", "c", "getMinItemWidth", "setMinItemWidth", "(I)V", "minItemWidth", "value", "d", "getMaxItemWidth", "setMaxItemWidth", "maxItemWidth", "e", "getPosition", "setPosition", "position", "Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/CommodityGuideSearchFixWidthContainer$OnItemOversizeListener;", "itemOversizeListener", "Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/CommodityGuideSearchFixWidthContainer$OnItemOversizeListener;", "getItemOversizeListener", "()Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/CommodityGuideSearchFixWidthContainer$OnItemOversizeListener;", "setItemOversizeListener", "(Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/CommodityGuideSearchFixWidthContainer$OnItemOversizeListener;)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OnItemOversizeListener", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommodityGuideSearchFixWidthContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f450121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f450122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f450123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f450124d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f450125e;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/holder/guidesearch/CommodityGuideSearchFixWidthContainer$OnItemOversizeListener;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface OnItemOversizeListener {
    }

    public final OnItemOversizeListener getItemOversizeListener() {
        return null;
    }

    public final void setItemOversizeListener(OnItemOversizeListener r100) {
    }

    public final int getDefaultItemWidth() {
        return this.f450122b;
    }

    public final float getFontScale() {
        return this.f450121a;
    }

    public final float getMaxItemWidth() {
        return this.f450124d;
    }

    public final int getMinItemWidth() {
        return this.f450123c;
    }

    public final int getPosition() {
        return this.f450125e;
    }

    public CommodityGuideSearchFixWidthContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null);
        ITradeSearchHostService r101 = TradeSearch.c(TradeSearch.f453393a);
        float r102 = 1.0f;
        if (r101 == null) goto L9;
        ITradeSearchHostAppInfo r103 = r101.getITradeSearchHostAppInfo();
        if (r103 == null) goto L9;
        Float r104 = r103.getCurrentFontScale();
        if (r104 == null) goto L9;
        float r105 = r104.floatValue();
    L10:
        ITradeSearchHostService r106 = TradeSearch.b(0);
        if (r106 == null) goto L16;
        ITradeSearchHostAppInfo r107 = r106.getITradeSearchHostAppInfo();
        if (r107 == null) goto L16;
        r107.isLargeFontMode();
    L16:
        if (r105 < 1.0f) goto L18;
        r102 = r105;
    L18:
        this.f450121a = r102;
        int r108 = DimenExtensionsKt.b(81);
        this.f450122b = r108;
        this.f450123c = r108;
        this.f450124d = DimenExtensionsKt.b(92) * this.f450121a;
        return;
    L9:
        r105 = 1.0f;
        goto L10
    }

    public final void setFontScale(float r100) {
        this.f450121a = r100;
    }

    public final void setMaxItemWidth(float r100) {
        if (r100 == Float.MAX_VALUE) goto L5;
        r100 = r100 * this.f450121a;
    L5:
        this.f450124d = r100;
    }

    public final void setMinItemWidth(int r100) {
        this.f450123c = r100;
    }

    public final void setPosition(int r100) {
        this.f450125e = r100;
    }

    public CommodityGuideSearchFixWidthContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        ITradeSearchHostService r102 = TradeSearch.c(TradeSearch.f453393a);
        float r103 = 1.0f;
        if (r102 == null) goto L9;
        ITradeSearchHostAppInfo r104 = r102.getITradeSearchHostAppInfo();
        if (r104 == null) goto L9;
        Float r105 = r104.getCurrentFontScale();
        if (r105 == null) goto L9;
        float r106 = r105.floatValue();
    L10:
        ITradeSearchHostService r107 = TradeSearch.b(0);
        if (r107 == null) goto L16;
        ITradeSearchHostAppInfo r108 = r107.getITradeSearchHostAppInfo();
        if (r108 == null) goto L16;
        r108.isLargeFontMode();
    L16:
        if (r106 < 1.0f) goto L18;
        r103 = r106;
    L18:
        this.f450121a = r103;
        int r109 = DimenExtensionsKt.b(81);
        this.f450122b = r109;
        this.f450123c = r109;
        this.f450124d = DimenExtensionsKt.b(92) * this.f450121a;
        return;
    L9:
        r106 = 1.0f;
        goto L10
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r102 = getMeasuredWidth();
        float r103 = r102;
        float r104 = this.f450124d;
        if (r103 <= r104) goto L5;
        Logger.a("GuideSearchOpt", "itemWidth = " + r102 + " > maxItemWidth = " + this.f450124d);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) this.f450124d, 1073741824), r101);
        return;
    L5:
        int r105 = this.f450123c;
        if (r102 > r105) goto L8;
    L10:
        if (r102 > r105) goto L15;
        Logger.a("GuideSearchOpt", "itemWidth = " + r102 + " < minItemWidth = " + this.f450123c);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.f450123c, 1073741824), r101);
        return;
    L15:
        return;
    L8:
        if (r103 > r104) goto L10;
        Logger.a("GuideSearchOpt", "minItemWidth = " + this.f450123c + " < itemWidth = " + r102 + " < maxItemWidth = " + this.f450124d);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) this.f450124d, 1073741824), r101);
    }

    public CommodityGuideSearchFixWidthContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ITradeSearchHostService r103 = TradeSearch.c(TradeSearch.f453393a);
        float r104 = 1.0f;
        if (r103 == null) goto L9;
        ITradeSearchHostAppInfo r105 = r103.getITradeSearchHostAppInfo();
        if (r105 == null) goto L9;
        Float r106 = r105.getCurrentFontScale();
        if (r106 == null) goto L9;
        float r107 = r106.floatValue();
    L10:
        ITradeSearchHostService r108 = TradeSearch.b(0);
        if (r108 == null) goto L16;
        ITradeSearchHostAppInfo r109 = r108.getITradeSearchHostAppInfo();
        if (r109 == null) goto L16;
        r109.isLargeFontMode();
    L16:
        if (r107 < 1.0f) goto L18;
        r104 = r107;
    L18:
        this.f450121a = r104;
        int r110 = DimenExtensionsKt.b(81);
        this.f450122b = r110;
        this.f450123c = r110;
        this.f450124d = DimenExtensionsKt.b(92) * this.f450121a;
        return;
    L9:
        r107 = 1.0f;
        goto L10
    }
}
