package com.bytedance.ee.bear.document.authors;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/document/authors/Author;", "Lcom/bytedance/ee/util/io/NonProguard;", "avatarUrl", "", "department", "i18nValue", "Lcom/bytedance/ee/bear/document/authors/I18nValue;", "id", "userType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ee/bear/document/authors/I18nValue;Ljava/lang/String;Ljava/lang/String;)V", "getAvatarUrl", "()Ljava/lang/String;", "getDepartment", "getI18nValue", "()Lcom/bytedance/ee/bear/document/authors/I18nValue;", "getId", "getUserType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Author implements NonProguard {
    private final String avatarUrl;
    private final String department;
    private final I18nValue i18nValue;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f219132id;
    private final String userType;

    public Author() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ Author copy$default(Author r100, String r101, String r102, I18nValue r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.avatarUrl;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.department;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.i18nValue;
    L11:
        I18nValue r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.f219132id;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.userType;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.avatarUrl;
    }

    public final String component2() {
        return this.department;
    }

    public final I18nValue component3() {
        return this.i18nValue;
    }

    public final String component4() {
        return this.f219132id;
    }

    public final String component5() {
        return this.userType;
    }

    public final Author copy(@JSONField(name = "avatar_url") String r100, String r101, @JSONField(name = "i18n_value") I18nValue r110, String r111, @JSONField(name = "user_type") String r112) {
        return new Author(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Author) == true) goto L8;
        return false;
    L8:
        Author r101 = (Author) r100;
        if (Intrinsics.areEqual(this.avatarUrl, r101.avatarUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.department, r101.department) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.i18nValue, r101.i18nValue) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f219132id, r101.f219132id) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.userType, r101.userType) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.avatarUrl;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.department;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        I18nValue r107 = this.i18nValue;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f219132id;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.userType;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "Author(avatarUrl=" + this.avatarUrl + ", department=" + this.department + ", i18nValue=" + this.i18nValue + ", id=" + this.f219132id + ", userType=" + this.userType + ')';
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getDepartment() {
        return this.department;
    }

    public final I18nValue getI18nValue() {
        return this.i18nValue;
    }

    public final String getId() {
        return this.f219132id;
    }

    public final String getUserType() {
        return this.userType;
    }

    public Author(@JSONField(name = "avatar_url") String r100, String r101, @JSONField(name = "i18n_value") I18nValue r102, String r103, @JSONField(name = "user_type") String r104) {
        this.avatarUrl = r100;
        this.department = r101;
        this.i18nValue = r102;
        this.f219132id = r103;
        this.userType = r104;
    }

    public /* synthetic */ Author(String r100, String r101, I18nValue r102, String r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        I18nValue r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        String r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
