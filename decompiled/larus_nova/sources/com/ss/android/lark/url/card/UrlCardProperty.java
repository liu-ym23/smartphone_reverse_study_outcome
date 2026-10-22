package com.ss.android.lark.url.card;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.lark.pb.basic.v1.UniversalCardEntity;
import com.larksuite.component.card.monitor.UniversalCardMonitorData;
import com.larksuite.component.card.navigation.UniversalCardLargeScreenAdapt;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.CardData;
import com.larksuite.component.card.protocol.context.CardStyle;
import com.larksuite.component.card.protocol.data.action.CardActionDependencyData;
import com.ss.android.lark.export.engine.smartcard.SmartCardEngineProperty;
import com.ss.android.lark.export.params.URLPreviewParams;
import com.ss.android.lark.export.parser.ModelParserRenderRouterEntity;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import com.ss.android.lark.url.card.action.UrlCardActionContext;
import com.ss.android.lark.url.card.action.UrlCardBizContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001#B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J2\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0018HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/ss/android/lark/url/card/UrlCardProperty;", "Lcom/ss/android/lark/export/engine/smartcard/SmartCardEngineProperty;", "cardData", "Lcom/larksuite/component/card/protocol/CardData;", "pbEntity", "Lcom/bytedance/lark/pb/basic/v1/UniversalCardEntity;", "<init>", "(Lcom/larksuite/component/card/protocol/CardData;Lcom/bytedance/lark/pb/basic/v1/UniversalCardEntity;)V", "getCardData", "()Lcom/larksuite/component/card/protocol/CardData;", "getPbEntity", "()Lcom/bytedance/lark/pb/basic/v1/UniversalCardEntity;", "cardContext", "Lcom/larksuite/component/card/protocol/CardContext;", "getCardContext", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "renderTrace", "Lcom/ss/android/lark/opmonitor/trace/OPTrace;", "dependency", "Lcom/ss/android/lark/export/dependency/UrlPreviewDependency;", "maxWidth", "", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "url-card_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrlCardProperty extends SmartCardEngineProperty {
    public static final a Companion = null;
    public static final String URL_PREVIEW_BUSINESS_HOST = "im_message";
    public static final String URL_PREVIEW_BUSINESS_TYPE = "url_preview";
    private CardContext cardContext;
    private final CardData cardData;
    private final UniversalCardEntity pbEntity;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ UrlCardProperty copy$default(UrlCardProperty r100, CardData r101, UniversalCardEntity r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.cardData;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.pbEntity;
    L9:
        return r100.copy(r101, r102);
    }

    public final CardData component1() {
        return this.cardData;
    }

    public final UniversalCardEntity component2() {
        return this.pbEntity;
    }

    public final UrlCardProperty copy(CardData r100, UniversalCardEntity r101) {
        Intrinsics.checkNotNullParameter(r100, "cardData");
        Intrinsics.checkNotNullParameter(r101, "pbEntity");
        return new UrlCardProperty(r100, r101);
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UrlCardProperty) == true) goto L8;
        return false;
    L8:
        UrlCardProperty r101 = (UrlCardProperty) r100;
        if (Intrinsics.areEqual(this.cardData, r101.cardData) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pbEntity, r101.pbEntity) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public int hashCode() {
        return (this.cardData.hashCode() * 31) + this.pbEntity.hashCode();
    }

    public String toString() {
        return "UrlCardProperty(cardData=" + this.cardData + ", pbEntity=" + this.pbEntity + ')';
    }

    public final CardData getCardData() {
        return this.cardData;
    }

    public final UniversalCardEntity getPbEntity() {
        return this.pbEntity;
    }

    public UrlCardProperty(CardData r100, UniversalCardEntity r101) {
        Intrinsics.checkNotNullParameter(r100, "cardData");
        Intrinsics.checkNotNullParameter(r101, "pbEntity");
        super(ModelParserRenderRouterEntity.CardEngineType.UNIVERSAL_CARD, null);
        this.cardData = r100;
        this.pbEntity = r101;
    }

    public final CardContext getCardContext(Context r310, Fragment r311, OPTrace r312, vcb.d r313, int r314) {
        Intrinsics.checkNotNullParameter(r310, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r312, "renderTrace");
        Intrinsics.checkNotNullParameter(r313, "dependency");
        if (this.cardContext != null) goto L9;
        boolean r100 = UniversalCardLargeScreenAdapt.c(r310, r314);
        b r101 = b.f444611a;
        UniversalCardEntity r110 = this.pbEntity;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r310, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r312, "renderTrace");
        Intrinsics.checkNotNullParameter(r110, "universalEntity");
        Intrinsics.checkNotNullParameter(URL_PREVIEW_BUSINESS_HOST, "host");
        Intrinsics.checkNotNullParameter("", "scene");
        Intrinsics.checkNotNullParameter(URL_PREVIEW_BUSINESS_TYPE, "businessType");
        Intrinsics.checkNotNullParameter(r313, "dependency");
        CardStyle r111 = new CardStyle(r100, false, false, null, 8, null);
        URLPreviewParams r102 = r313.f554144d;
        String r112 = r102.f420690f;
        if (r112 != null) goto L8;
        r112 = "";
    L8:
        UrlCardBizContext r103 = new UrlCardBizContext(r102.f420691g, r112, r110.source_id);
        UrlCardActionContext r104 = new UrlCardActionContext(r313.f554144d.f420691g, r112);
        String r210 = r112;
        CardActionDependencyData r105 = new CardActionDependencyData(r210, r313.f554144d.f420688d, false, null, 8, null);
        UniversalCardMonitorData r113 = new UniversalCardMonitorData(URL_PREVIEW_BUSINESS_TYPE, "");
        CardContext.a.C3903a r114 = new CardContext.a.C3903a();
        Intrinsics.checkNotNullParameter(r310, PerfLog.PARAM_KEY_CONTEXT_ID);
        r114.f283865c = r310;
        r114.f283866d = r311;
        String r106 = r110.card_id;
        Intrinsics.checkNotNullParameter(r106, "key");
        r114.f283863a = r106;
        Intrinsics.checkNotNullParameter(r312, "renderTrace");
        r114.f283864b = r312;
        Intrinsics.checkNotNullParameter(r103, "bizContext");
        r114.f283868f = r103;
        r114.f283869g = r104;
        Intrinsics.checkNotNullParameter(URL_PREVIEW_BUSINESS_HOST, "host");
        r114.f283870h = URL_PREVIEW_BUSINESS_HOST;
        Intrinsics.checkNotNullParameter(r113, "monitorData");
        r114.f283867e = r113;
        Intrinsics.checkNotNullParameter(URL_PREVIEW_BUSINESS_TYPE, "deliveryType");
        r114.f283871i = URL_PREVIEW_BUSINESS_TYPE;
        Intrinsics.checkNotNullParameter(r105, "cardActionDependencyData");
        r114.f283872j = r105;
        UrlCardDependencyImpl r107 = new UrlCardDependencyImpl(r313, r103);
        Intrinsics.checkNotNullParameter(r107, "dependency");
        r114.f283873k = r107;
        Intrinsics.checkNotNullParameter(r111, "cardStyle");
        r114.f283874l = r111;
        UrlCardProperty r108 = this;
        r108.cardContext = r114.a();
    L11:
        return r108.cardContext;
    L9:
        r108 = this;
        goto L11
    }
}
