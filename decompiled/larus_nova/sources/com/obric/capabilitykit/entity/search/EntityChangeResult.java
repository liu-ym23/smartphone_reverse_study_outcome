package com.obric.capabilitykit.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/obric/capabilitykit/entity/search/EntityChangeResult;", "Landroid/os/Parcelable;", "changeType", "", "entities", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "(ILjava/util/List;)V", "getChangeType", "()I", "getEntities", "()Ljava/util/List;", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntityChangeResult implements Parcelable {
    public static final CREATOR CREATOR = null;
    private final int changeType;
    private final List<AppEntity> entities;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/capabilitykit/entity/search/EntityChangeResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/search/EntityChangeResult;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/capabilitykit/entity/search/EntityChangeResult;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<EntityChangeResult> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EntityChangeResult createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return (EntityChangeResult) GsonProtectorUtils.fromJson(EntityExtKt.a(), r100.readString(), EntityChangeResult.class);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ EntityChangeResult createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EntityChangeResult[] newArray(int r100) {
            return new EntityChangeResult[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ EntityChangeResult[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EntityChangeResult(int r100, List<? extends AppEntity> r101) {
        Intrinsics.checkNotNullParameter(r101, "entities");
        this.changeType = r100;
        this.entities = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EntityChangeResult copy$default(EntityChangeResult r100, int r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.changeType;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.entities;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.changeType;
    }

    public final List<AppEntity> component2() {
        return this.entities;
    }

    public final EntityChangeResult copy(int r100, List<? extends AppEntity> r101) {
        Intrinsics.checkNotNullParameter(r101, "entities");
        return new EntityChangeResult(r100, r101);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof EntityChangeResult) == true) goto L8;
        return false;
    L8:
        EntityChangeResult r101 = (EntityChangeResult) r100;
        if (this.changeType == r101.changeType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.entities, r101.entities) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int getChangeType() {
        return this.changeType;
    }

    public final List<AppEntity> getEntities() {
        return this.entities;
    }

    public int hashCode() {
        return (this.changeType * 31) + this.entities.hashCode();
    }

    public String toString() {
        return "EntityChangeResult(changeType=" + this.changeType + ", entities=" + this.entities + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(GsonProtectorUtils.toJson(EntityExtKt.a(), this));
    }
}
