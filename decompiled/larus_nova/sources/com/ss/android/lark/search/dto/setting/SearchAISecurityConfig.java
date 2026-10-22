package com.ss.android.lark.search.dto.setting;

import a4c.c;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@AppConfig(key = "knowledge_ai_setting")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/search/dto/setting/SearchAISecurityConfig;", "", "privacyLink", "Lcom/ss/android/lark/search/dto/setting/PrivacyLink;", "<init>", "(Lcom/ss/android/lark/search/dto/setting/PrivacyLink;)V", "getPrivacyLink", "()Lcom/ss/android/lark/search/dto/setting/PrivacyLink;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchAISecurityConfig {

    @SerializedName("knowledge_ai_heplcenter")
    private final c privacyLink;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SearchAISecurityConfig) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.privacyLink, ((SearchAISecurityConfig) r100).privacyLink) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        c r100 = this.privacyLink;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "SearchAISecurityConfig(privacyLink=" + this.privacyLink + ')';
    }

    public SearchAISecurityConfig() {
        this.privacyLink = null;
    }
}
