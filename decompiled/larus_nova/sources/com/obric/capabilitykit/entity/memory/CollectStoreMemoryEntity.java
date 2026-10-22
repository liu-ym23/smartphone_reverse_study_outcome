package com.obric.capabilitykit.entity.memory;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005Bi\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0013J\b\u0010\"\u001a\u00020#H\u0016J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%H\u0016J\"\u0010'\u001a\u00020(2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\fH\u0016J\u0018\u0010,\u001a\u00020(2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\fH\u0016R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017¨\u0006/"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/CollectStoreMemoryEntity;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "productType", "", "storeName", "appName", "appPkgName", "address", "storeType", "city", "(Ljava/lang/String;JJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "getAppName", "setAppName", "getAppPkgName", "setAppPkgName", "getCity", "setCity", "getStoreName", "setStoreName", "getStoreType", "setStoreType", "convertToModelInput", "Lorg/json/JSONObject;", "getSharedUris", "", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CollectStoreMemoryEntity extends MemoryEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 1;
    private static final int RELATED_VERSION = 0;
    private String address;
    private String appName;
    private String appPkgName;
    private String city;
    private String storeName;
    private String storeType;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/CollectStoreMemoryEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/memory/CollectStoreMemoryEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/memory/CollectStoreMemoryEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<CollectStoreMemoryEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CollectStoreMemoryEntity createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            AppEntity r101 = AppEntity.CREATOR.createFromParcel(r100);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.CollectStoreMemoryEntity");
            return (CollectStoreMemoryEntity) r101;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CollectStoreMemoryEntity createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        public final int getVersion() {
            return 1;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CollectStoreMemoryEntity[] newArray(int r100) {
            return new CollectStoreMemoryEntity[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CollectStoreMemoryEntity[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public CollectStoreMemoryEntity(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "parcel");
        this(EntityExtKt.e(r110), r110.readLong(), r110.readLong(), r110.readInt(), EntityExtKt.e(r110), r110.readString(), r110.readString(), r110.readString(), r110.readString(), null, 512, null);
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r110);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r110, 1, r110.readInt());
    }

    public CollectStoreMemoryEntity(String r110, long r111, long r112, int r113, String r114, String r115, String r116, String r210, String r211, String r212) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r114, "storeName");
        super(r110, r111, r112, 10202, r113);
        this.storeName = r114;
        this.appName = r115;
        this.appPkgName = r116;
        this.address = r210;
        this.storeType = r211;
        this.city = r212;
    }

    public /* synthetic */ CollectStoreMemoryEntity(String r110, long r111, long r210, int r211, String r212, String r213, String r214, String r215, String r216, String r217, int r218, DefaultConstructorMarker r310) {
        if ((r218 & 32) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r218 & 64) == 0) goto L9;
        String r113 = null;
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

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity
    public JSONObject convertToModelInput() {
        JSONObject r100 = new JSONObject();
        r100.put("type", getType());
        r100.put("createTime", getCreateTime());
        r100.put("modifyTime", getLastModifiedTime());
        r100.put("ecaId", getEcaId());
        r100.put("storeName", makeModelInputValue("店铺名称", this.storeName));
        String r101 = this.appName;
        if (r101 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        r100.put("appName", makeModelInputValue("店铺平台", r101));
    L5:
        String r102 = this.address;
        if (r102 == null) goto L8;
        Intrinsics.checkNotNull(r102);
        r100.put("address", makeModelInputValue("店铺地址", r102));
    L8:
        String r103 = this.storeType;
        if (r103 == null) goto L11;
        Intrinsics.checkNotNull(r103);
        r100.put("storeType", makeModelInputValue("店铺类型", r103));
    L11:
        String r104 = this.city;
        if (r104 == null) goto L14;
        Intrinsics.checkNotNull(r104);
        r100.put("city", makeModelInputValue("店铺城市", r104));
    L14:
        return r100;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getAppPkgName() {
        return this.appPkgName;
    }

    public final String getCity() {
        return this.city;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity
    public List<Uri> getSharedUris() {
        FileEntity r100 = getScreenshot();
        if (r100 == null) goto L7;
        List<Uri> r101 = r100.getSharedUris();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return CollectionsKt.emptyList();
    }

    public final String getStoreName() {
        return this.storeName;
    }

    public final String getStoreType() {
        return this.storeType;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r100, ClassLoader r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        if (r102 != 1) goto L6;
        this.city = (String) r100.readValue(r101);
        return;
    }

    public final void setAddress(String r100) {
        this.address = r100;
    }

    public final void setAppName(String r100) {
        this.appName = r100;
    }

    public final void setAppPkgName(String r100) {
        this.appPkgName = r100;
    }

    public final void setCity(String r100) {
        this.city = r100;
    }

    public final void setStoreName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.storeName = r100;
    }

    public final void setStoreType(String r100) {
        this.storeType = r100;
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity, com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        writeMemoryBaseFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeString(this.storeName);
        r100.writeString(this.appName);
        r100.writeString(this.appPkgName);
        r100.writeString(this.address);
        r100.writeString(this.storeType);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r100, r101);
        r100.writeInt(1);
        r100.writeValue(this.city);
    }
}
