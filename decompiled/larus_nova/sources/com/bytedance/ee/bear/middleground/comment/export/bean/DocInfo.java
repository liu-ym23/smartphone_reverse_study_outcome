package com.bytedance.ee.bear.middleground.comment.export.bean;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rB\t\b\u0016¢\u0006\u0004\b\f\u0010\u000eJ\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0004HÆ\u0003JO\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0004HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010¨\u0006'"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/export/bean/DocInfo;", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/Result;", "Ljava/io/Serializable;", "title", "", "editTime", "", "createTime", "editUserName", "createUid", "createUserName", "type", "<init>", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()V", "getTitle", "()Ljava/lang/String;", "getEditTime", "()J", "getCreateTime", "getEditUserName", "getCreateUid", "getCreateUserName", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "middleground-comment-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocInfo extends Result<Serializable> {
    private final long createTime;
    private final String createUid;
    private final String createUserName;
    private final long editTime;
    private final String editUserName;
    private final String title;
    private final String type;

    public static /* synthetic */ DocInfo copy$default(DocInfo r110, String r111, long r112, long r113, String r114, String r115, String r116, String r117, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.title;
    L7:
        if ((r210 & 2) == 0) goto L9;
        long r101 = r110.editTime;
    L11:
        if ((r210 & 4) == 0) goto L13;
        long r102 = r110.createTime;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = r110.editUserName;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = r110.createUid;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r105 = r110.createUserName;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r106 = r110.type;
    L31:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106);
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
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

    public final DocInfo copy(String r110, long r111, long r112, String r113, String r114, String r115, String r210) {
        Intrinsics.checkNotNullParameter(r110, "title");
        Intrinsics.checkNotNullParameter(r113, "editUserName");
        Intrinsics.checkNotNullParameter(r114, "createUid");
        Intrinsics.checkNotNullParameter(r115, "createUserName");
        Intrinsics.checkNotNullParameter(r210, "type");
        return new DocInfo(r110, r111, r112, r113, r114, r115, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DocInfo) == true) goto L8;
        return false;
    L8:
        DocInfo r101 = (DocInfo) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
        return false;
    L12:
        if (this.editTime == r101.editTime) goto L15;
        return false;
    L15:
        if (this.createTime == r101.createTime) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.editUserName, r101.editUserName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.createUid, r101.createUid) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.createUserName, r101.createUserName) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r100 = this.title.hashCode() * 31;
        long r101 = this.editTime;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.createTime;
        return ((((((((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.editUserName.hashCode()) * 31) + this.createUid.hashCode()) * 31) + this.createUserName.hashCode()) * 31) + this.type.hashCode();
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

    public DocInfo(String r100, long r101, long r102, String r103, String r104, String r105, String r110) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r103, "editUserName");
        Intrinsics.checkNotNullParameter(r104, "createUid");
        Intrinsics.checkNotNullParameter(r105, "createUserName");
        Intrinsics.checkNotNullParameter(r110, "type");
        this.title = r100;
        this.editTime = r101;
        this.createTime = r102;
        this.editUserName = r103;
        this.createUid = r104;
        this.createUserName = r105;
        this.type = r110;
    }
}
