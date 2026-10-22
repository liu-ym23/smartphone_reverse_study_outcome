package com.ss.android.lark.search.dto.setting;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@AppConfig(key = "chat_tab_i18n_name")
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003JI\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\tHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/search/dto/setting/SearchInChatQAQueryConfig;", "", "queryText1", "Lcom/ss/android/lark/search/dto/setting/LanguageConfig;", "queryText2", "knowledgeInputPlaceHolder", "searchAskCardTitle", "doubaoSkillList", "", "", "<init>", "(Lcom/ss/android/lark/search/dto/setting/LanguageConfig;Lcom/ss/android/lark/search/dto/setting/LanguageConfig;Lcom/ss/android/lark/search/dto/setting/LanguageConfig;Lcom/ss/android/lark/search/dto/setting/LanguageConfig;Ljava/util/List;)V", "getQueryText1", "()Lcom/ss/android/lark/search/dto/setting/LanguageConfig;", "getQueryText2", "getKnowledgeInputPlaceHolder", "getSearchAskCardTitle", "getDoubaoSkillList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchInChatQAQueryConfig {

    @SerializedName("doubao_skill_list")
    private final List<String> doubaoSkillList;

    @SerializedName("search_ask_or_search_placeholder")
    private final LanguageConfig knowledgeInputPlaceHolder;

    @SerializedName("chat_search_qa_entrance_test_query_text1")
    private final LanguageConfig queryText1;

    @SerializedName("chat_search_qa_entrance_test_query_text2")
    private final LanguageConfig queryText2;

    @SerializedName("search_ask_card_title")
    private final LanguageConfig searchAskCardTitle;

    public SearchInChatQAQueryConfig() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchInChatQAQueryConfig copy$default(SearchInChatQAQueryConfig r100, LanguageConfig r101, LanguageConfig r102, LanguageConfig r103, LanguageConfig r104, List r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.queryText1;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.queryText2;
    L8:
        LanguageConfig r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.knowledgeInputPlaceHolder;
    L11:
        LanguageConfig r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.searchAskCardTitle;
    L14:
        LanguageConfig r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.doubaoSkillList;
    L17:
        LanguageConfig r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final LanguageConfig component1() {
        return this.queryText1;
    }

    public final LanguageConfig component2() {
        return this.queryText2;
    }

    public final LanguageConfig component3() {
        return this.knowledgeInputPlaceHolder;
    }

    public final LanguageConfig component4() {
        return this.searchAskCardTitle;
    }

    public final List<String> component5() {
        return this.doubaoSkillList;
    }

    public final SearchInChatQAQueryConfig copy(LanguageConfig r100, LanguageConfig r101, LanguageConfig r110, LanguageConfig r111, List<String> r112) {
        Intrinsics.checkNotNullParameter(r112, "doubaoSkillList");
        return new SearchInChatQAQueryConfig(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SearchInChatQAQueryConfig) == true) goto L8;
        return false;
    L8:
        SearchInChatQAQueryConfig r101 = (SearchInChatQAQueryConfig) r100;
        if (Intrinsics.areEqual(this.queryText1, r101.queryText1) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.queryText2, r101.queryText2) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.knowledgeInputPlaceHolder, r101.knowledgeInputPlaceHolder) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.searchAskCardTitle, r101.searchAskCardTitle) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.doubaoSkillList, r101.doubaoSkillList) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        LanguageConfig r100 = this.queryText1;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        LanguageConfig r104 = this.queryText2;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        LanguageConfig r107 = this.knowledgeInputPlaceHolder;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        LanguageConfig r110 = this.searchAskCardTitle;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return ((r109 + r101) * 31) + this.doubaoSkillList.hashCode();
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "SearchInChatQAQueryConfig(queryText1=" + this.queryText1 + ", queryText2=" + this.queryText2 + ", knowledgeInputPlaceHolder=" + this.knowledgeInputPlaceHolder + ", searchAskCardTitle=" + this.searchAskCardTitle + ", doubaoSkillList=" + this.doubaoSkillList + ')';
    }

    public final List<String> getDoubaoSkillList() {
        return this.doubaoSkillList;
    }

    public final LanguageConfig getKnowledgeInputPlaceHolder() {
        return this.knowledgeInputPlaceHolder;
    }

    public final LanguageConfig getQueryText1() {
        return this.queryText1;
    }

    public final LanguageConfig getQueryText2() {
        return this.queryText2;
    }

    public final LanguageConfig getSearchAskCardTitle() {
        return this.searchAskCardTitle;
    }

    public SearchInChatQAQueryConfig(LanguageConfig r100, LanguageConfig r101, LanguageConfig r102, LanguageConfig r103, List<String> r104) {
        Intrinsics.checkNotNullParameter(r104, "doubaoSkillList");
        this.queryText1 = r100;
        this.queryText2 = r101;
        this.knowledgeInputPlaceHolder = r102;
        this.searchAskCardTitle = r103;
        this.doubaoSkillList = r104;
    }

    public /* synthetic */ SearchInChatQAQueryConfig(LanguageConfig r100, LanguageConfig r101, LanguageConfig r102, LanguageConfig r103, List r104, int r105, DefaultConstructorMarker r110) {
        LanguageConfig r106 = null;
        if ((r105 & 1) == 0) goto L5;
        LanguageConfig r111 = null;
    L7:
        if ((r105 & 2) == 0) goto L9;
        LanguageConfig r107 = null;
    L11:
        if ((r105 & 4) == 0) goto L13;
        LanguageConfig r108 = null;
    L15:
        if ((r105 & 8) != 0) goto L19;
        r106 = r103;
    L19:
        if ((r105 & 16) == 0) goto L21;
        r104 = CollectionsKt.emptyList();
    L21:
        this(r111, r107, r108, r106, r104);
        return;
    L13:
        r108 = r102;
        goto L15
    L9:
        r107 = r101;
        goto L11
    L5:
        r111 = r100;
        goto L7
    }
}
