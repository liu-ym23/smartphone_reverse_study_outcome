package com.larus.bmhome.share.network;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\rHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/share/network/LarkMetaIdentity;", "", "larkMetaId", "", "larkMetaToken", "larkMetaObjectType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLarkMetaId", "()Ljava/lang/String;", "getLarkMetaToken", "getLarkMetaObjectType", "objectTypeOrNull", "", "()Ljava/lang/Integer;", "isValid", "", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarkMetaIdentity {

    @SerializedName("lark_meta_id")
    private final String larkMetaId;

    @SerializedName("lark_meta_object_type")
    private final String larkMetaObjectType;

    @SerializedName("lark_meta_token")
    private final String larkMetaToken;

    public LarkMetaIdentity() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ LarkMetaIdentity copy$default(LarkMetaIdentity r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.larkMetaId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.larkMetaToken;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.larkMetaObjectType;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.larkMetaId;
    }

    public final String component2() {
        return this.larkMetaToken;
    }

    public final String component3() {
        return this.larkMetaObjectType;
    }

    public final LarkMetaIdentity copy(String r100, String r101, String r102) {
        return new LarkMetaIdentity(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LarkMetaIdentity) == true) goto L8;
        return false;
    L8:
        LarkMetaIdentity r101 = (LarkMetaIdentity) r100;
        if (Intrinsics.areEqual(this.larkMetaId, r101.larkMetaId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.larkMetaToken, r101.larkMetaToken) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.larkMetaObjectType, r101.larkMetaObjectType) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.larkMetaId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.larkMetaToken;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.larkMetaObjectType;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "LarkMetaIdentity(larkMetaId=" + this.larkMetaId + ", larkMetaToken=" + this.larkMetaToken + ", larkMetaObjectType=" + this.larkMetaObjectType + ')';
    }

    public final boolean isValid() {
        String r100 = this.larkMetaToken;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L16;
        Integer r102 = objectTypeOrNull();
        if (r102 == null) goto L13;
        int r103 = r102.intValue();
    L14:
        if (r103 <= 0) goto L16;
        return true;
    L13:
        r103 = 0;
    L16:
        return false;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L9
    }

    public final Integer objectTypeOrNull() {
        String r100 = this.larkMetaObjectType;
        if (r100 == null) goto L7;
        String r101 = StringsKt.trim(r100).toString();
        if (r101 == null) goto L7;
        return StringsKt.toIntOrNull(r101);
    L7:
        return null;
    }

    public final String getLarkMetaId() {
        return this.larkMetaId;
    }

    public final String getLarkMetaObjectType() {
        return this.larkMetaObjectType;
    }

    public final String getLarkMetaToken() {
        return this.larkMetaToken;
    }

    public LarkMetaIdentity(String r100, String r101, String r102) {
        this.larkMetaId = r100;
        this.larkMetaToken = r101;
        this.larkMetaObjectType = r102;
    }

    public /* synthetic */ LarkMetaIdentity(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
