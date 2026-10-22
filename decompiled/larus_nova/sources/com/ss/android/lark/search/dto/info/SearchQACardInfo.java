package com.ss.android.lark.search.dto.info;

import com.bytedance.lark.pb.search.v2.QaCardMeta;
import com.ss.android.lark.search.dto.constant.SearchCommonConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/search/dto/info/SearchQACardInfo;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "renderContent", "", "jumpType", "Lcom/bytedance/lark/pb/search/v2/QaCardMeta$JumpType;", "<init>", "(Ljava/lang/String;Lcom/bytedance/lark/pb/search/v2/QaCardMeta$JumpType;)V", "getRenderContent", "()Ljava/lang/String;", "getJumpType", "()Lcom/bytedance/lark/pb/search/v2/QaCardMeta$JumpType;", "getResultTypeForReport", "getTagForReport", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchQACardInfo extends SearchBaseInfo {
    private final QaCardMeta.JumpType jumpType;
    private final String renderContent;

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public String getResultTypeForReport() {
        return "kg_card";
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public String getTagForReport() {
        StringBuilder r100 = new StringBuilder(super.getTagForReport());
        r100.append("accurate_kg_staff_service_card,");
        QaCardMeta.JumpType r101 = this.jumpType;
        if (r101 != QaCardMeta.JumpType.ENTERPRISE_QA) goto L6;
        r100.append("to_enterprise_qa_section,");
    L9:
        return r100.toString();
    L6:
        if (r101 != QaCardMeta.JumpType.HELPDESK) goto L9;
        r100.append("to_helpdesk,");
        goto L9
    }

    public final QaCardMeta.JumpType getJumpType() {
        return this.jumpType;
    }

    public final String getRenderContent() {
        return this.renderContent;
    }

    public SearchQACardInfo(String r100, QaCardMeta.JumpType r101) {
        Intrinsics.checkNotNullParameter(r100, "renderContent");
        Intrinsics.checkNotNullParameter(r101, "jumpType");
        this.renderContent = r100;
        this.jumpType = r101;
        this.type = SearchCommonConstants.SearchResultType.QA_CARD;
    }
}
