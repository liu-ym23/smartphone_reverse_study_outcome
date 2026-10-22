package com.obric.capabilitykit.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.Gson;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0001-B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BC\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003JK\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\b\u0010#\u001a\u00020$H\u0016J\u0013\u0010%\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020$HÖ\u0001J\t\u0010)\u001a\u00020\u0006HÖ\u0001J\u0018\u0010*\u001a\u00020+2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010,\u001a\u00020$H\u0016R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0010¨\u0006."}, d2 = {"Lcom/obric/capabilitykit/entity/search/InAppSearchEntityParam;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "keyword", "", "field", "value", "isSemantic", "", a.KEY_SCORE, "Lcom/obric/capabilitykit/entity/search/SearchScoreParam;", "fieldArrayUniqueKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/obric/capabilitykit/entity/search/SearchScoreParam;Ljava/lang/String;)V", "getField", "()Ljava/lang/String;", "setField", "(Ljava/lang/String;)V", "getFieldArrayUniqueKey", "setFieldArrayUniqueKey", "()Z", "getKeyword", "getScore", "()Lcom/obric/capabilitykit/entity/search/SearchScoreParam;", "setScore", "(Lcom/obric/capabilitykit/entity/search/SearchScoreParam;)V", "getValue", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InAppSearchEntityParam implements Parcelable {
    public static final CREATOR CREATOR = null;
    private static final String VERSION = "1";
    private String field;
    private String fieldArrayUniqueKey;
    private final boolean isSemantic;
    private final String keyword;
    private SearchScoreParam score;
    private final String value;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001d\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/capabilitykit/entity/search/InAppSearchEntityParam$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/search/InAppSearchEntityParam;", "()V", "VERSION", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/capabilitykit/entity/search/InAppSearchEntityParam;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<InAppSearchEntityParam> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InAppSearchEntityParam createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new InAppSearchEntityParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InAppSearchEntityParam createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InAppSearchEntityParam[] newArray(int r100) {
            return new InAppSearchEntityParam[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InAppSearchEntityParam[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public InAppSearchEntityParam(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "parcel");
        this(EntityExtKt.e(r110), EntityExtKt.e(r110), r110.readString(), EntityExtKt.d(r110), (SearchScoreParam) r110.readParcelable(SearchScoreParam.class.getClassLoader()), null, 32, null);
        int r100 = r110.dataPosition();
        String r101 = r110.readString();
        int r102 = 0;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        r110.setDataPosition(r100);
    L12:
        int r104 = CastIntegerProtector.parseInt("1");
        if (r102 > r104) goto L16;
        r104 = r102;
    L16:
        ClassLoader r105 = InAppSearchEntityParam.class.getClassLoader();
        int r106 = 1;
    L17:
        if (r106 > r104) goto L21;
        if (r106 != 1) goto L20;
        this.fieldArrayUniqueKey = (String) r110.readValue(r105);
    L20:
        r106 = r106 + 1;
    L21:
        if (r106 > r102) goto L23;
        ParcelUtils.INSTANCE.skipValueSafely(r110, r105);
        r106 = r106 + 1;
        goto L21
    L23:
        return;
    L11:
        r102 = CastIntegerProtector.parseInt(r101);
        goto L12
    L5:
        if (r101.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    public InAppSearchEntityParam(String r100, String r101, String r102, boolean r103, SearchScoreParam r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "keyword");
        Intrinsics.checkNotNullParameter(r101, "field");
        this.keyword = r100;
        this.field = r101;
        this.value = r102;
        this.isSemantic = r103;
        this.score = r104;
        this.fieldArrayUniqueKey = r105;
    }

    public /* synthetic */ InAppSearchEntityParam(String r110, String r111, String r112, boolean r113, SearchScoreParam r114, String r115, int r116, DefaultConstructorMarker r117) {
        if ((r116 & 4) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r116 & 8) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r116 & 16) == 0) goto L13;
        SearchScoreParam r102 = null;
    L15:
        if ((r116 & 32) == 0) goto L17;
        String r103 = null;
    L18:
        this(r110, r111, r100, r101, r102, r103);
        return;
    L17:
        r103 = r115;
        goto L18
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }

    public static /* synthetic */ InAppSearchEntityParam copy$default(InAppSearchEntityParam r100, String r101, String r102, String r103, boolean r104, SearchScoreParam r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.keyword;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.field;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.value;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.isSemantic;
    L14:
        boolean r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.score;
    L17:
        SearchScoreParam r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.fieldArrayUniqueKey;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.keyword;
    }

    public final String component2() {
        return this.field;
    }

    public final String component3() {
        return this.value;
    }

    public final boolean component4() {
        return this.isSemantic;
    }

    public final SearchScoreParam component5() {
        return this.score;
    }

    public final String component6() {
        return this.fieldArrayUniqueKey;
    }

    public final InAppSearchEntityParam copy(String r100, String r110, String r111, boolean r112, SearchScoreParam r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "keyword");
        Intrinsics.checkNotNullParameter(r110, "field");
        return new InAppSearchEntityParam(r100, r110, r111, r112, r113, r114);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof InAppSearchEntityParam) == true) goto L8;
        return false;
    L8:
        InAppSearchEntityParam r101 = (InAppSearchEntityParam) r100;
        if (Intrinsics.areEqual(this.keyword, r101.keyword) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.field, r101.field) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.value, r101.value) == true) goto L18;
        return false;
    L18:
        if (this.isSemantic == r101.isSemantic) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.score, r101.score) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.fieldArrayUniqueKey, r101.fieldArrayUniqueKey) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final String getField() {
        return this.field;
    }

    public final String getFieldArrayUniqueKey() {
        return this.fieldArrayUniqueKey;
    }

    public final String getKeyword() {
        return this.keyword;
    }

    public final SearchScoreParam getScore() {
        return this.score;
    }

    public final String getValue() {
        return this.value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    public int hashCode() {
        int r100 = ((this.keyword.hashCode() * 31) + this.field.hashCode()) * 31;
        String r101 = this.value;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        boolean r105 = this.isSemantic;
        ?? r106 = r105;
        if (r105 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r104 + r106) * 31;
        SearchScoreParam r108 = this.score;
        if (r108 != null) goto L12;
        int r109 = 0;
    L13:
        int r110 = (r107 + r109) * 31;
        String r111 = this.fieldArrayUniqueKey;
        if (r111 == null) goto L18;
        r102 = r111.hashCode();
    L18:
        return r110 + r102;
    L12:
        r109 = r108.hashCode();
        goto L13
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final boolean isSemantic() {
        return this.isSemantic;
    }

    public final void setField(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.field = r100;
    }

    public final void setFieldArrayUniqueKey(String r100) {
        this.fieldArrayUniqueKey = r100;
    }

    public final void setScore(SearchScoreParam r100) {
        this.score = r100;
    }

    public String toString() {
        return "InAppSearchEntityParam(keyword=" + this.keyword + ", field=" + this.field + ", value=" + this.value + ", isSemantic=" + this.isSemantic + ", score=" + this.score + ", fieldArrayUniqueKey=" + this.fieldArrayUniqueKey + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.keyword);
        r100.writeString(this.field);
        r100.writeString(this.value);
        boolean r102 = this.isSemantic;
        Gson r103 = EntityExtKt.f396198a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.writeInt(r102 ? 1 : 0);
        r100.writeParcelable(this.score, r101);
        r100.writeString("1");
        r100.writeValue(this.fieldArrayUniqueKey);
    }
}
