package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.EntityExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 02\u00020\u0001:\u00010B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004Be\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0013J\b\u0010'\u001a\u00020(H\u0016J\"\u0010)\u001a\u00020*2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\rH\u0016J\u0018\u0010.\u001a\u00020*2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\rH\u0016R\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017¨\u00061"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AppInfoEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "appName", "appPackageName", "appStatus", "", "isExactMatch", "", "icon", "openStoreDetailDeeplink", "packageSize", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppName", "()Ljava/lang/String;", "setAppName", "(Ljava/lang/String;)V", "getAppPackageName", "setAppPackageName", "getAppStatus", "()I", "setAppStatus", "(I)V", "getIcon", "setIcon", "()Z", "setExactMatch", "(Z)V", "getOpenStoreDetailDeeplink", "setOpenStoreDetailDeeplink", "getPackageSize", "setPackageSize", "getDisplayRepresentation", "Lcom/obric/capabilitykit/entity/app/DisplayRepresentation;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AppInfoEntity extends AppEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    public static final int STATUS_INSTALLED = 2;
    public static final int STATUS_INSTALLING = 1;
    public static final int STATUS_NOT_INSTALLED = 0;
    public static final int STATUS_UPDATE_AVAILABLE = 4;
    public static final int STATUS_UPDATING = 3;
    private String appName;
    private String appPackageName;
    private int appStatus;
    private String icon;
    private boolean isExactMatch;
    private String openStoreDetailDeeplink;
    private String packageSize;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0006\u0010\u000f\u001a\u00020\u0005J\u001d\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AppInfoEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/AppInfoEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "STATUS_INSTALLED", "STATUS_INSTALLING", "STATUS_NOT_INSTALLED", "STATUS_UPDATE_AVAILABLE", "STATUS_UPDATING", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/AppInfoEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<AppInfoEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppInfoEntity createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            AppEntity r101 = AppEntity.CREATOR.createFromParcel(r100);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.AppInfoEntity");
            return (AppInfoEntity) r101;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppInfoEntity createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppInfoEntity[] newArray(int r100) {
            return new AppInfoEntity[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppInfoEntity[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public AppInfoEntity(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "parcel");
        String r100 = EntityExtKt.e(r110);
        long r101 = r110.readLong();
        long r102 = r110.readLong();
        String r103 = EntityExtKt.e(r110);
        String r104 = EntityExtKt.e(r110);
        int r111 = r110.readInt();
        if (r110.readInt() != 1) goto L5;
        boolean r112 = true;
    L6:
        this(r100, r101, r102, r103, r104, r111, r112, r110.readString(), r110.readString(), r110.readString());
        readExtensionFieldFromParcel$capabilitykitcommon_release(r110);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r110, 0, r110.readInt());
        return;
    L5:
        r112 = false;
        goto L6
    }

    public AppInfoEntity(String r110, long r111, long r112, String r113, String r114, int r115, boolean r116, String r210, String r211, String r212) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r113, "appName");
        Intrinsics.checkNotNullParameter(r114, "appPackageName");
        super(r110, r111, r112, 1701);
        this.appName = r113;
        this.appPackageName = r114;
        this.appStatus = r115;
        this.isExactMatch = r116;
        this.icon = r210;
        this.openStoreDetailDeeplink = r211;
        this.packageSize = r212;
    }

    public /* synthetic */ AppInfoEntity(String r110, long r111, long r210, String r211, String r212, int r213, boolean r214, String r215, String r216, String r217, int r218, DefaultConstructorMarker r310) {
        if ((r218 & 32) == 0) goto L5;
        int r112 = 0;
    L7:
        if ((r218 & 64) == 0) goto L9;
        boolean r113 = false;
    L11:
        if ((r218 & 128) == 0) goto L13;
        String r114 = null;
    L15:
        if ((r218 & 256) == 0) goto L17;
        String r115 = null;
    L19:
        if ((r218 & 512) == 0) goto L21;
        String r116 = null;
    L22:
        this(r110, r111, r210, r211, r212, r112, r113, r114, r115, r116);
        return;
    L21:
        r116 = r217;
        goto L22
    L17:
        r115 = r216;
        goto L19
    L13:
        r114 = r215;
        goto L15
    L9:
        r113 = r214;
        goto L11
    L5:
        r112 = r213;
        goto L7
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getAppPackageName() {
        return this.appPackageName;
    }

    public final int getAppStatus() {
        return this.appStatus;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public DisplayRepresentation getDisplayRepresentation() {
        return new DisplayRepresentation(null, this.appName, null, getLastModifiedTime(), 5, null);
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getOpenStoreDetailDeeplink() {
        return this.openStoreDetailDeeplink;
    }

    public final String getPackageSize() {
        return this.packageSize;
    }

    public final boolean isExactMatch() {
        return this.isExactMatch;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r100, ClassLoader r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
    }

    public final void setAppName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.appName = r100;
    }

    public final void setAppPackageName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.appPackageName = r100;
    }

    public final void setAppStatus(int r100) {
        this.appStatus = r100;
    }

    public final void setExactMatch(boolean r100) {
        this.isExactMatch = r100;
    }

    public final void setIcon(String r100) {
        this.icon = r100;
    }

    public final void setOpenStoreDetailDeeplink(String r100) {
        this.openStoreDetailDeeplink = r100;
    }

    public final void setPackageSize(String r100) {
        this.packageSize = r100;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeString(this.appName);
        r100.writeString(this.appPackageName);
        r100.writeInt(this.appStatus);
        r100.writeInt(this.isExactMatch ? 1 : 0);
        r100.writeString(this.icon);
        r100.writeString(this.openStoreDetailDeeplink);
        r100.writeString(this.packageSize);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeInt(0);
    }
}
