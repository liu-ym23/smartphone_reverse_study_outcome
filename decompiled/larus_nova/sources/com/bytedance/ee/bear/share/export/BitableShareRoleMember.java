package com.bytedance.ee.bear.share.export;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0011\u001a\u00020\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/share/export/BitableShareRoleMember;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "memberId", "", "getMemberId", "()Ljava/lang/String;", "setMemberId", "(Ljava/lang/String;)V", "memberType", "", "getMemberType", "()Ljava/lang/Integer;", "setMemberType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "isUserType", "", "features-share-export-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableShareRoleMember implements NonProguard {
    private String memberId;
    private Integer memberType;

    public BitableShareRoleMember() {
    }

    public final boolean isUserType() {
        Integer r100 = this.memberType;
        if (r100 != null) goto L6;
    L7:
        Integer r101 = this.memberType;
        if (r101 != null) goto L11;
    L12:
        Integer r102 = this.memberType;
        if (r102 != null) goto L16;
    L18:
        return false;
    L16:
        if (r102.intValue() != 17) goto L18;
        return true;
    L11:
        if (r101.intValue() != 1) goto L12;
        return true;
    L6:
        if (r100.intValue() != 0) goto L7;
        return true;
    }

    public final String getMemberId() {
        return this.memberId;
    }

    public final Integer getMemberType() {
        return this.memberType;
    }

    public final void setMemberId(String r100) {
        this.memberId = r100;
    }

    public final void setMemberType(Integer r100) {
        this.memberType = r100;
    }
}
