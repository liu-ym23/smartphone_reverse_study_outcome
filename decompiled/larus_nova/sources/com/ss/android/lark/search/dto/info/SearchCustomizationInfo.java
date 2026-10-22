package com.ss.android.lark.search.dto.info;

import com.bytedance.lark.pb.search.v2.CustomizationMeta;
import com.ss.android.lark.search.dto.constant.SearchCommonConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0016\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000f\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/search/dto/info/SearchCustomizationInfo;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "cardType", "Lcom/bytedance/lark/pb/search/v2/CustomizationMeta$CardType;", "customizationId", "", "renderContent", "dataSourceId", "templateName", "channel", "<init>", "(Lcom/bytedance/lark/pb/search/v2/CustomizationMeta$CardType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCardType", "()Lcom/bytedance/lark/pb/search/v2/CustomizationMeta$CardType;", "getCustomizationId", "()Ljava/lang/String;", "getRenderContent", "setRenderContent", "(Ljava/lang/String;)V", "getDataSourceId", "getTemplateName", "getChannel", "getResultTypeForReport", "getTagForReport", "Companion", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SearchCustomizationInfo extends SearchBaseInfo {
    public static final a Companion = null;
    private final CustomizationMeta.CardType cardType;
    private final String channel;
    private final String customizationId;
    private final String dataSourceId;
    private String renderContent;
    private final String templateName;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public String getResultTypeForReport() {
        if (Intrinsics.areEqual(this.dataSourceId, "mobile-card-service") == false) goto L5;
        return "service_card";
    L5:
        return "slash_command";
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public String getTagForReport() {
        if (Intrinsics.areEqual(this.dataSourceId, "mobile-card-service") == false) goto L5;
        return "fuzzy_kg_staff_service_card";
    L5:
        return "slash_command_card";
    }

    public final CustomizationMeta.CardType getCardType() {
        return this.cardType;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final String getCustomizationId() {
        return this.customizationId;
    }

    public final String getDataSourceId() {
        return this.dataSourceId;
    }

    public final String getRenderContent() {
        return this.renderContent;
    }

    public final String getTemplateName() {
        return this.templateName;
    }

    public final void setRenderContent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.renderContent = r100;
    }

    public SearchCustomizationInfo(CustomizationMeta.CardType r100, String r101, String r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r101, "customizationId");
        Intrinsics.checkNotNullParameter(r102, "renderContent");
        Intrinsics.checkNotNullParameter(r103, "dataSourceId");
        Intrinsics.checkNotNullParameter(r104, "templateName");
        Intrinsics.checkNotNullParameter(r105, "channel");
        this.cardType = r100;
        this.customizationId = r101;
        this.renderContent = r102;
        this.dataSourceId = r103;
        this.templateName = r104;
        this.channel = r105;
        this.type = SearchCommonConstants.SearchResultType.CUSTOMIZATION;
    }
}
