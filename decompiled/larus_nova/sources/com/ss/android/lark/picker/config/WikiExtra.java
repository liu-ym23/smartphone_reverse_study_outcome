package com.ss.android.lark.picker.config;

import com.bytedance.lark.pb.basic.v1.DocSortRuleType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/picker/config/WikiExtra;", "Lcom/ss/android/lark/picker/config/Extra;", "<init>", "()V", "sortRule", "Lcom/bytedance/lark/pb/basic/v1/DocSortRuleType;", "getSortRule", "()Lcom/bytedance/lark/pb/basic/v1/DocSortRuleType;", "setSortRule", "(Lcom/bytedance/lark/pb/basic/v1/DocSortRuleType;)V", "isEnableCrossLanguage", "", "()Ljava/lang/Boolean;", "setEnableCrossLanguage", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "extendedSearch", "Lcom/ss/android/lark/picker/config/ExtendedSearch;", "getExtendedSearch", "()Lcom/ss/android/lark/picker/config/ExtendedSearch;", "setExtendedSearch", "(Lcom/ss/android/lark/picker/config/ExtendedSearch;)V", "isReturnRelationTag", "()Z", "setReturnRelationTag", "(Z)V", "isNeedWikiOwner", "setNeedWikiOwner", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiExtra implements Extra {
    private ExtendedSearch extendedSearch;
    private Boolean isEnableCrossLanguage;
    private boolean isNeedWikiOwner;
    private boolean isReturnRelationTag;
    private DocSortRuleType sortRule;

    public WikiExtra() {
        this.isReturnRelationTag = true;
    }

    public final ExtendedSearch getExtendedSearch() {
        return this.extendedSearch;
    }

    public final DocSortRuleType getSortRule() {
        return this.sortRule;
    }

    public final Boolean isEnableCrossLanguage() {
        return this.isEnableCrossLanguage;
    }

    public final boolean isNeedWikiOwner() {
        return this.isNeedWikiOwner;
    }

    public final boolean isReturnRelationTag() {
        return this.isReturnRelationTag;
    }

    public final void setEnableCrossLanguage(Boolean r100) {
        this.isEnableCrossLanguage = r100;
    }

    public final void setExtendedSearch(ExtendedSearch r100) {
        this.extendedSearch = r100;
    }

    public final void setNeedWikiOwner(boolean r100) {
        this.isNeedWikiOwner = r100;
    }

    public final void setReturnRelationTag(boolean r100) {
        this.isReturnRelationTag = r100;
    }

    public final void setSortRule(DocSortRuleType r100) {
        this.sortRule = r100;
    }
}
