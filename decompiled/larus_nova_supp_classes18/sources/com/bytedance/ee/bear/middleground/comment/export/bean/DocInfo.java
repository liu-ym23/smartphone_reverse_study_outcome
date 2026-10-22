package com.bytedance.ee.bear.middleground.comment.export.bean;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rB\t\b\u0016¢\u0006\u0004\b\f\u0010\u000eJ\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0004HÆ\u0003JO\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0004HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010¨\u0006'"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/export/bean/DocInfo;", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/Result;", "Ljava/io/Serializable;", "title", "", "editTime", "", "createTime", "editUserName", "createUid", "createUserName", ResourceData.KEY_TYPE, "<init>", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()V", "getTitle", "()Ljava/lang/String;", "getEditTime", "()J", "getCreateTime", "getEditUserName", "getCreateUid", "getCreateUserName", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "middleground-comment-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocInfo extends Result<Serializable> {
    private final long createTime;
    private final String createUid;
    private final String createUserName;
    private final long editTime;
    private final String editUserName;
    private final String title;
    private final String type;

    public static /* synthetic */ DocInfo copy$default(DocInfo r10, String r11, long r12, long r14, String r16, String r17, String r18, String r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        String r1 = r10.title;
    L7:
        if ((r20 & 2) == 0) goto L9;
        long r2 = r10.editTime;
    L11:
        if ((r20 & 4) == 0) goto L13;
        long r4 = r10.createTime;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r6 = r10.editUserName;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r7 = r10.createUid;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r8 = r10.createUserName;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r9 = r10.type;
    L31:
        return r10.copy(r1, r2, r4, r6, r7, r8, r9);
    L29:
        r9 = r19;
        goto L31
    L25:
        r8 = r18;
        goto L27
    L21:
        r7 = r17;
        goto L23
    L17:
        r6 = r16;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r2 = r12;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }

    public final String component1() {
        return this.title;
    }

    public final long component2() {
        return this.editTime;
    }

    public final long component3() {
        return this.createTime;
    }

    public final String component4() {
        return this.editUserName;
    }

    public final String component5() {
        return this.createUid;
    }

    public final String component6() {
        return this.createUserName;
    }

    public final String component7() {
        return this.type;
    }

    public final DocInfo copy(String r12, long r13, long r15, String r17, String r18, String r19, String r20) {
        Intrinsics.checkNotNullParameter(r12, "title");
        Intrinsics.checkNotNullParameter(r17, "editUserName");
        Intrinsics.checkNotNullParameter(r18, "createUid");
        Intrinsics.checkNotNullParameter(r19, "createUserName");
        Intrinsics.checkNotNullParameter(r20, ResourceData.KEY_TYPE);
        return new DocInfo(r12, r13, r15, r17, r18, r19, r20);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof DocInfo) == true) goto L8;
        return false;
    L8:
        DocInfo r9 = (DocInfo) r8;
        if (Intrinsics.areEqual(this.title, r9.title) == true) goto L12;
        return false;
    L12:
        if (this.editTime == r9.editTime) goto L15;
        return false;
    L15:
        if (this.createTime == r9.createTime) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.editUserName, r9.editUserName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.createUid, r9.createUid) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.createUserName, r9.createUserName) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.type, r9.type) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = this.title.hashCode() * 31;
        long r1 = this.editTime;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.createTime;
        return ((((((((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.editUserName.hashCode()) * 31) + this.createUid.hashCode()) * 31) + this.createUserName.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "DocInfo(title=" + this.title + ", editTime=" + this.editTime + ", createTime=" + this.createTime + ", editUserName=" + this.editUserName + ", createUid=" + this.createUid + ", createUserName=" + this.createUserName + ", type=" + this.type + ')';
    }

    public DocInfo() {
        this("", 0, 0, "", "", "", "");
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final String getCreateUid() {
        return this.createUid;
    }

    public final String getCreateUserName() {
        return this.createUserName;
    }

    public final long getEditTime() {
        return this.editTime;
    }

    public final String getEditUserName() {
        return this.editUserName;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType() {
        return this.type;
    }

    public DocInfo(String r2, long r3, long r5, String r7, String r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r2, "title");
        Intrinsics.checkNotNullParameter(r7, "editUserName");
        Intrinsics.checkNotNullParameter(r8, "createUid");
        Intrinsics.checkNotNullParameter(r9, "createUserName");
        Intrinsics.checkNotNullParameter(r10, ResourceData.KEY_TYPE);
        this.title = r2;
        this.editTime = r3;
        this.createTime = r5;
        this.editUserName = r7;
        this.createUid = r8;
        this.createUserName = r9;
        this.type = r10;
    }
}
