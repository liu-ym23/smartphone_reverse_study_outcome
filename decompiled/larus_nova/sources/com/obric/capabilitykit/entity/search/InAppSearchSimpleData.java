package com.obric.capabilitykit.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0001)B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B3\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010\u000fJ\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003JA\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0001J\b\u0010\u001f\u001a\u00020\u000bH\u0016J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u000bHÖ\u0001J\t\u0010%\u001a\u00020\u0006HÖ\u0001J\u0018\u0010&\u001a\u00020'2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u000bH\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006*"}, d2 = {"Lcom/obric/capabilitykit/entity/search/InAppSearchSimpleData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "lastModifiedTime", "type", "", "params", "", "Lcom/obric/capabilitykit/entity/search/InAppSearchEntityParam;", "(Ljava/lang/String;JJILjava/util/List;)V", "getCreateTime", "()J", "getId", "()Ljava/lang/String;", "getLastModifiedTime", "getParams", "()Ljava/util/List;", "getType", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InAppSearchSimpleData implements Parcelable {
    public static final CREATOR CREATOR = null;
    private static final String VERSION = "0";
    private final long createTime;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f396253id;
    private final long lastModifiedTime;
    private final List<InAppSearchEntityParam> params;
    private final int type;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001d\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/capabilitykit/entity/search/InAppSearchSimpleData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/search/InAppSearchSimpleData;", "()V", "VERSION", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/capabilitykit/entity/search/InAppSearchSimpleData;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<InAppSearchSimpleData> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InAppSearchSimpleData createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new InAppSearchSimpleData(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InAppSearchSimpleData createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InAppSearchSimpleData[] newArray(int r100) {
            return new InAppSearchSimpleData[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InAppSearchSimpleData[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public InAppSearchSimpleData(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "parcel");
        String r100 = EntityExtKt.e(r110);
        long r101 = r110.readLong();
        long r102 = r110.readLong();
        int r103 = r110.readInt();
        ArrayList r104 = r110.createTypedArrayList(InAppSearchEntityParam.CREATOR);
        Intrinsics.checkNotNull(r104);
        this(r100, r101, r102, r103, r104);
        int r105 = r110.dataPosition();
        String r106 = r110.readString();
        int r107 = 1;
        int r108 = 0;
        if (r106 != null) goto L5;
    L8:
        boolean r109 = true;
    L9:
        if (r109 == false) goto L11;
        r110.setDataPosition(r105);
    L12:
        int r111 = CastIntegerProtector.parseInt("0");
        if (r108 > r111) goto L16;
        r111 = r108;
    L16:
        ClassLoader r112 = InAppSearchSimpleData.class.getClassLoader();
    L17:
        if (r107 > r111) goto L19;
        r107 = r107 + 1;
    L19:
        if (r107 > r108) goto L21;
        ParcelUtils.INSTANCE.skipValueSafely(r110, r112);
        r107 = r107 + 1;
        goto L19
    L21:
        return;
    L11:
        r108 = CastIntegerProtector.parseInt(r106);
        goto L12
    L5:
        if (r106.length() == 0) goto L8;
        r109 = false;
        goto L9
    }

    public InAppSearchSimpleData(String r100, long r101, long r102, int r103, List<InAppSearchEntityParam> r104) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r104, "params");
        this.f396253id = r100;
        this.createTime = r101;
        this.lastModifiedTime = r102;
        this.type = r103;
        this.params = r104;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InAppSearchSimpleData copy$default(InAppSearchSimpleData r100, String r101, long r102, long r103, int r110, List r111, int r112, Object r113) {
        if ((r112 & 1) == 0) goto L6;
        r101 = r100.f396253id;
    L6:
        if ((r112 & 2) == 0) goto L8;
        r102 = r100.createTime;
    L8:
        long r104 = r102;
        if ((r112 & 4) == 0) goto L11;
        r103 = r100.lastModifiedTime;
    L11:
        long r105 = r103;
        if ((r112 & 8) == 0) goto L14;
        r110 = r100.type;
    L14:
        int r114 = r110;
        if ((r112 & 16) == 0) goto L17;
        r111 = r100.params;
    L17:
        String r106 = r101;
        return r100.copy(r106, r104, r105, r114, r111);
    }

    public final String component1() {
        return this.f396253id;
    }

    public final long component2() {
        return this.createTime;
    }

    public final long component3() {
        return this.lastModifiedTime;
    }

    public final int component4() {
        return this.type;
    }

    public final List<InAppSearchEntityParam> component5() {
        return this.params;
    }

    public final InAppSearchSimpleData copy(String r110, long r111, long r112, int r113, List<InAppSearchEntityParam> r114) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r114, "params");
        return new InAppSearchSimpleData(r110, r111, r112, r113, r114);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof InAppSearchSimpleData) == true) goto L8;
        return false;
    L8:
        InAppSearchSimpleData r101 = (InAppSearchSimpleData) r100;
        if (Intrinsics.areEqual(this.f396253id, r101.f396253id) == true) goto L12;
        return false;
    L12:
        if (this.createTime == r101.createTime) goto L15;
        return false;
    L15:
        if (this.lastModifiedTime == r101.lastModifiedTime) goto L18;
        return false;
    L18:
        if (this.type == r101.type) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final String getId() {
        return this.f396253id;
    }

    public final long getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    public final List<InAppSearchEntityParam> getParams() {
        return this.params;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int r100 = this.f396253id.hashCode() * 31;
        long r101 = this.createTime;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.lastModifiedTime;
        return ((((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.type) * 31) + this.params.hashCode();
    }

    public String toString() {
        return "InAppSearchSimpleData(id=" + this.f396253id + ", createTime=" + this.createTime + ", lastModifiedTime=" + this.lastModifiedTime + ", type=" + this.type + ", params=" + this.params + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.f396253id);
        r100.writeLong(this.createTime);
        r100.writeLong(this.lastModifiedTime);
        r100.writeInt(this.type);
        r100.writeTypedList(this.params);
        r100.writeString("0");
    }
}
