package com.obric.capabilitykit.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0001$B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B+\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t¢\u0006\u0002\u0010\fJ\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u0017\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tHÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tHÆ\u0001J\b\u0010\u001b\u001a\u00020\u0014H\u0016J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0014HÖ\u0001J\t\u0010 \u001a\u00020\nHÖ\u0001J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0014H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/obric/capabilitykit/entity/search/InAppSearchResultWithoutEntity;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "entities", "", "Lcom/obric/capabilitykit/entity/search/InAppSearchSimpleData;", ControlRule.KEY_EXTRA_DATA, "", "", "", "(Ljava/util/List;Ljava/util/Map;)V", "getEntities", "()Ljava/util/List;", "getExtraData", "()Ljava/util/Map;", "setExtraData", "(Ljava/util/Map;)V", "<set-?>", "", "remoteClientVersion", "getRemoteClientVersion", "()I", "component1", "component2", "copy", "describeContents", "equals", "", "other", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InAppSearchResultWithoutEntity implements Parcelable {
    public static final CREATOR CREATOR = null;
    private static final String VERSION = "1";
    private final List<InAppSearchSimpleData> entities;
    private Map<String, ? extends Object> extraData;
    private transient int remoteClientVersion;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001d\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/capabilitykit/entity/search/InAppSearchResultWithoutEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/search/InAppSearchResultWithoutEntity;", "()V", "VERSION", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/capabilitykit/entity/search/InAppSearchResultWithoutEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<InAppSearchResultWithoutEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InAppSearchResultWithoutEntity createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new InAppSearchResultWithoutEntity(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InAppSearchResultWithoutEntity createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InAppSearchResultWithoutEntity[] newArray(int r100) {
            return new InAppSearchResultWithoutEntity[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InAppSearchResultWithoutEntity[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InAppSearchResultWithoutEntity(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        List r101 = r100.createTypedArrayList(InAppSearchSimpleData.CREATOR);
        if (r101 != null) goto L5;
        r101 = CollectionsKt.emptyList();
    L5:
        this(r101, null, 2, 0 == true ? 1 : 0);
        int r102 = r100.dataPosition();
        String r103 = r100.readString();
        int r104 = 0;
        if (r103 != null) goto L8;
    L11:
        boolean r105 = true;
    L12:
        if (r105 == false) goto L14;
        r100.setDataPosition(r102);
    L15:
        this.remoteClientVersion = r104;
        int r106 = CastIntegerProtector.parseInt("1");
        if (r104 > r106) goto L19;
        r106 = r104;
    L19:
        ClassLoader r107 = InAppSearchResultWithoutEntity.class.getClassLoader();
        int r108 = 1;
    L20:
        if (r108 > r106) goto L28;
        if (r108 != 1) goto L27;
        Object r109 = r100.readValue(r107);
        if ((r109 instanceof Map) == false) goto L25;
        Map<String, ? extends Object> r110 = (Map) r109;
    L26:
        this.extraData = r110;
        goto L27
    L25:
        r110 = null;
    L27:
        r108 = r108 + 1;
    L28:
        if (r108 > r104) goto L30;
        ParcelUtils.INSTANCE.skipValueSafely(r100, r107);
        r108 = r108 + 1;
        goto L28
    L30:
        return;
    L14:
        r104 = CastIntegerProtector.parseInt(r103);
        goto L15
    L8:
        if (r103.length() == 0) goto L11;
        r105 = false;
        goto L12
    }

    public InAppSearchResultWithoutEntity(List<InAppSearchSimpleData> r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "entities");
        this.entities = r100;
        this.extraData = r101;
    }

    public /* synthetic */ InAppSearchResultWithoutEntity(List r100, Map r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InAppSearchResultWithoutEntity copy$default(InAppSearchResultWithoutEntity r100, List r101, Map r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.entities;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.extraData;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<InAppSearchSimpleData> component1() {
        return this.entities;
    }

    public final Map<String, Object> component2() {
        return this.extraData;
    }

    public final InAppSearchResultWithoutEntity copy(List<InAppSearchSimpleData> r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "entities");
        return new InAppSearchResultWithoutEntity(r100, r101);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof InAppSearchResultWithoutEntity) == true) goto L8;
        return false;
    L8:
        InAppSearchResultWithoutEntity r101 = (InAppSearchResultWithoutEntity) r100;
        if (Intrinsics.areEqual(this.entities, r101.entities) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extraData, r101.extraData) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final List<InAppSearchSimpleData> getEntities() {
        return this.entities;
    }

    public final Map<String, Object> getExtraData() {
        return this.extraData;
    }

    public final int getRemoteClientVersion() {
        return this.remoteClientVersion;
    }

    public int hashCode() {
        int r100 = this.entities.hashCode() * 31;
        Map<String, ? extends Object> r101 = this.extraData;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final void setExtraData(Map<String, ? extends Object> r100) {
        this.extraData = r100;
    }

    public String toString() {
        return "InAppSearchResultWithoutEntity(entities=" + this.entities + ", extraData=" + this.extraData + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeTypedList(this.entities);
        r100.writeString("1");
        r100.writeValue(this.extraData);
    }
}
