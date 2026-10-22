package com.ss.android.lark.search.dto.info;

import com.ss.android.lark.pb.usearch.SearchPlaceholder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0017\u001a\u00020\u000fJ\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016J$\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001f0!j\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001f`\"H\u0016J$\u0010#\u001a\u001e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001f0!j\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001f`\"H\u0016J\u0013\u0010$\u001a\u00020\u000f2\b\u0010%\u001a\u0004\u0018\u00010\u001fH\u0096\u0002J\b\u0010&\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013¨\u0006'"}, d2 = {"Lcom/ss/android/lark/search/dto/info/SearchQARecommendInfo;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "qaInfo", "Lcom/ss/android/lark/pb/usearch/SearchPlaceholder;", "<init>", "(Lcom/ss/android/lark/pb/usearch/SearchPlaceholder;)V", "getQaInfo", "()Lcom/ss/android/lark/pb/usearch/SearchPlaceholder;", "positionInQAList", "", "getPositionInQAList", "()I", "setPositionInQAList", "(I)V", "needShowHongBao", "", "getNeedShowHongBao", "()Z", "setNeedShowHongBao", "(Z)V", "currentShowingHongBao", "getCurrentShowingHongBao", "setCurrentShowingHongBao", "showAnswer", "answer", "", "getEntityIdForReport", "getResultTypeForReport", "getTagForReport", "getExtraParams", "", "", "getClickEventExtraParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getShowEventExtraParams", "equals", "other", "hashCode", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchQARecommendInfo extends SearchBaseInfo {
    private boolean currentShowingHongBao;
    private boolean needShowHongBao;
    private int positionInQAList;
    private final SearchPlaceholder qaInfo;

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public String getResultTypeForReport() {
        return "enterprise_qa_question";
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public String getTagForReport() {
        return "enterprise_qa_question_section";
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public int hashCode() {
        return Objects.hash(new Object[]{getId(), Integer.valueOf(this.positionInQAList), Integer.valueOf(this.type)});
    }

    public final String answer() {
        String r100 = this.qaInfo.manswer;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public HashMap<String, Object> getClickEventExtraParams() {
        HashMap<String, Object> r100 = new HashMap();
        JSONObject r101 = new JSONObject();
        r101.put("is_display_redpacket", this.needShowHongBao);
        r100.put("sub_click_detail", r101);
        return r100;
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public Map<String, Object> getExtraParams() {
        LinkedHashMap r100 = new LinkedHashMap();
        int r101 = this.positionInQAList;
        if (r101 < 0) goto L5;
        r100.put("qa_pos", Integer.valueOf(r101));
    L5:
        return r100;
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public HashMap<String, Object> getShowEventExtraParams() {
        HashMap<String, Object> r100 = new HashMap();
        r100.put("is_display_redpacket", Boolean.valueOf(this.currentShowingHongBao));
        return r100;
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public String getEntityIdForReport() {
        return getId();
    }

    public final boolean showAnswer() {
        if (answer().length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean getCurrentShowingHongBao() {
        return this.currentShowingHongBao;
    }

    public final boolean getNeedShowHongBao() {
        return this.needShowHongBao;
    }

    public final int getPositionInQAList() {
        return this.positionInQAList;
    }

    public final SearchPlaceholder getQaInfo() {
        return this.qaInfo;
    }

    public SearchQARecommendInfo(SearchPlaceholder r100) {
        Intrinsics.checkNotNullParameter(r100, "qaInfo");
        this.qaInfo = r100;
        this.positionInQAList = -1;
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public boolean equals(Object r100) {
        boolean r101 = super.equals(r100);
        if ((r100 instanceof SearchQARecommendInfo) == true) goto L5;
        return r101;
    L5:
        if (this.positionInQAList != ((SearchQARecommendInfo) r100).positionInQAList) goto L8;
        if (r101 == false) goto L8;
        return true;
    L8:
        return false;
    }

    public final void setCurrentShowingHongBao(boolean r100) {
        this.currentShowingHongBao = r100;
    }

    public final void setNeedShowHongBao(boolean r100) {
        this.needShowHongBao = r100;
    }

    public final void setPositionInQAList(int r100) {
        this.positionInQAList = r100;
    }
}
