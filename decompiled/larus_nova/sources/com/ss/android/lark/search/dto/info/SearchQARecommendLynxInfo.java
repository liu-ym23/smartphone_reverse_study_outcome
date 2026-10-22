package com.ss.android.lark.search.dto.info;

import com.bytedance.lark.pb.search.v2.CustomizationMeta;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B?\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/search/dto/info/SearchQARecommendLynxInfo;", "Lcom/ss/android/lark/search/dto/info/SearchCustomizationInfo;", "qaInfos", "Ljava/util/LinkedList;", "Lcom/ss/android/lark/search/dto/info/SearchQARecommendInfo;", "cardType", "Lcom/bytedance/lark/pb/search/v2/CustomizationMeta$CardType;", "customizationId", "", "renderContent", "templateName", "channel", "<init>", "(Ljava/util/LinkedList;Lcom/bytedance/lark/pb/search/v2/CustomizationMeta$CardType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getQaInfos", "()Ljava/util/LinkedList;", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchQARecommendLynxInfo extends SearchCustomizationInfo {
    private final LinkedList<SearchQARecommendInfo> qaInfos;

    public final LinkedList<SearchQARecommendInfo> getQaInfos() {
        return this.qaInfos;
    }

    public SearchQARecommendLynxInfo(LinkedList<SearchQARecommendInfo> r100, CustomizationMeta.CardType r110, String r111, String r112, String r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "qaInfos");
        Intrinsics.checkNotNullParameter(r111, "customizationId");
        Intrinsics.checkNotNullParameter(r112, "renderContent");
        Intrinsics.checkNotNullParameter(r113, "templateName");
        Intrinsics.checkNotNullParameter(r114, "channel");
        super(r110, r111, r112, "", r113, r114);
        this.qaInfos = r100;
    }
}
