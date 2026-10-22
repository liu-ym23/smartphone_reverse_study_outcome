package com.ss.android.lark.search.dto.info;

import com.bytedance.lark.pb.search.v2.MailContactMeta;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/search/dto/info/SearchMailContactInfo;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "mailId", "", "email", "contactType", "Lcom/bytedance/lark/pb/search/v2/MailContactMeta$ContactType;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/lark/pb/search/v2/MailContactMeta$ContactType;)V", "getMailId", "()Ljava/lang/String;", "getEmail", "getContactType", "()Lcom/bytedance/lark/pb/search/v2/MailContactMeta$ContactType;", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchMailContactInfo extends SearchBaseInfo {
    private final MailContactMeta.ContactType contactType;
    private final String email;
    private final String mailId;

    public final MailContactMeta.ContactType getContactType() {
        return this.contactType;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getMailId() {
        return this.mailId;
    }

    public SearchMailContactInfo(String r100, String r101, MailContactMeta.ContactType r102) {
        Intrinsics.checkNotNullParameter(r100, "mailId");
        Intrinsics.checkNotNullParameter(r101, "email");
        Intrinsics.checkNotNullParameter(r102, "contactType");
        this.mailId = r100;
        this.email = r101;
        this.contactType = r102;
        this.type = 16;
    }
}
