package com.obric.memorydata.sdk.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.app.FileEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J1\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006#"}, d2 = {"Lcom/obric/memorydata/sdk/realtime/FileActionContext;", "Lcom/obric/memorydata/sdk/realtime/ActionContext;", "type", "", "packageName", "", "activityName", "entity", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lcom/obric/capabilitykit/entity/app/FileEntity;)V", "getType", "()I", "getPackageName", "()Ljava/lang/String;", "getActivityName", "getEntity", "()Lcom/obric/capabilitykit/entity/app/FileEntity;", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FileActionContext extends ActionContext {
    public static final CREATOR CREATOR = null;
    private final String activityName;
    private final FileEntity entity;
    private final String packageName;
    private final int type;

    /* JADX INFO: loaded from: classes33.dex */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/sdk/realtime/FileActionContext$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/memorydata/sdk/realtime/FileActionContext;", "<init>", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/memorydata/sdk/realtime/FileActionContext;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<FileActionContext> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileActionContext createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            String r101 = r100.readString();
            Intrinsics.checkNotNull(r101);
            String r102 = r100.readString();
            Intrinsics.checkNotNull(r102);
            Parcelable r103 = r100.readParcelable(FileEntity.class.getClassLoader());
            Intrinsics.checkNotNull(r103);
            return new FileActionContext(0, r101, r102, (FileEntity) r103, 1, null);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ FileActionContext[] newArray(int r100) {
            return newArray(r100);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ FileActionContext createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileActionContext[] newArray(int r100) {
            return new FileActionContext[r100];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public static /* synthetic */ FileActionContext copy$default(FileActionContext r100, int r101, String r102, String r103, FileEntity r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.packageName;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.activityName;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.entity;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.packageName;
    }

    public final String component3() {
        return this.activityName;
    }

    public final FileEntity component4() {
        return this.entity;
    }

    public final FileActionContext copy(int r100, String r101, String r102, FileEntity r103) {
        Intrinsics.checkNotNullParameter(r101, "packageName");
        Intrinsics.checkNotNullParameter(r102, "activityName");
        Intrinsics.checkNotNullParameter(r103, "entity");
        return new FileActionContext(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FileActionContext) == true) goto L8;
        return false;
    L8:
        FileActionContext r101 = (FileActionContext) r100;
        if (this.type == r101.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.packageName, r101.packageName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.activityName, r101.activityName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.entity, r101.entity) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.type * 31) + this.packageName.hashCode()) * 31) + this.activityName.hashCode()) * 31) + this.entity.hashCode();
    }

    public String toString() {
        return "FileActionContext(type=" + this.type + ", packageName=" + this.packageName + ", activityName=" + this.activityName + ", entity=" + this.entity + ')';
    }

    @Override // com.obric.memorydata.sdk.realtime.ActionContext
    public String getActivityName() {
        return this.activityName;
    }

    public final FileEntity getEntity() {
        return this.entity;
    }

    @Override // com.obric.memorydata.sdk.realtime.ActionContext
    public String getPackageName() {
        return this.packageName;
    }

    @Override // com.obric.memorydata.sdk.realtime.ActionContext
    public int getType() {
        return this.type;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        super.writeToParcelBase(r100, r101);
        r100.writeString(getPackageName());
        r100.writeString(getActivityName());
        r100.writeParcelable(this.entity, r101);
    }

    public FileActionContext(int r100, String r101, String r102, FileEntity r103) {
        Intrinsics.checkNotNullParameter(r101, "packageName");
        Intrinsics.checkNotNullParameter(r102, "activityName");
        Intrinsics.checkNotNullParameter(r103, "entity");
        this.type = r100;
        this.packageName = r101;
        this.activityName = r102;
        this.entity = r103;
    }

    public /* synthetic */ FileActionContext(int r100, String r101, String r102, FileEntity r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L5;
        r100 = 2;
    L5:
        this(r100, r101, r102, r103);
    }
}
