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
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005BQ\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0011J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016J\"\u0010!\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\fH\u0016J\u0018\u0010&\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\fH\u0016R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015¨\u0006)"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/OrderCommonMemoryEntity;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "productType", "", "orderName", "orderDesc", "orderCreateDate", "orderCreateTime", "(Ljava/lang/String;JJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getOrderCreateDate", "()Ljava/lang/String;", "setOrderCreateDate", "(Ljava/lang/String;)V", "getOrderCreateTime", "setOrderCreateTime", "getOrderDesc", "setOrderDesc", "getOrderName", "setOrderName", "convertToModelInput", "Lorg/json/JSONObject;", "getSharedUris", "", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OrderCommonMemoryEntity extends MemoryEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private String orderCreateDate;
    private String orderCreateTime;
    private String orderDesc;
    private String orderName;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/OrderCommonMemoryEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/memory/OrderCommonMemoryEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/memory/OrderCommonMemoryEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<OrderCommonMemoryEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderCommonMemoryEntity createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            AppEntity r101 = AppEntity.CREATOR.createFromParcel(r100);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.OrderCommonMemoryEntity");
            return (OrderCommonMemoryEntity) r101;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderCommonMemoryEntity createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderCommonMemoryEntity[] newArray(int r100) {
            return new OrderCommonMemoryEntity[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderCommonMemoryEntity[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public OrderCommonMemoryEntity(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "parcel");
        this(EntityExtKt.e(r110), r110.readLong(), r110.readLong(), r110.readInt(), EntityExtKt.e(r110), r110.readString(), r110.readString(), r110.readString());
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r110);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r110, 0, r110.readInt());
    }

    public OrderCommonMemoryEntity(String r110, long r111, long r112, int r113, String r114, String r115, String r116, String r210) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r114, "orderName");
        super(r110, r111, r112, 10005, r113);
        this.orderName = r114;
        this.orderDesc = r115;
        this.orderCreateDate = r116;
        this.orderCreateTime = r210;
    }

    public /* synthetic */ OrderCommonMemoryEntity(String r110, long r111, long r112, int r210, String r211, String r212, String r213, String r214, int r215, DefaultConstructorMarker r216) {
        if ((r215 & 32) == 0) goto L5;
        String r113 = null;
    L7:
        if ((r215 & 64) == 0) goto L9;
        String r114 = null;
    L11:
        if ((r215 & 128) == 0) goto L13;
        String r115 = null;
    L14:
        this(r110, r111, r112, r210, r211, r113, r114, r115);
        return;
    L13:
        r115 = r214;
        goto L14
    L9:
        r114 = r213;
        goto L11
    L5:
        r113 = r212;
        goto L7
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity
    public JSONObject convertToModelInput() {
        JSONObject r100 = new JSONObject();
        r100.put("type", getType());
        r100.put("createTime", getCreateTime());
        r100.put("modifyTime", getLastModifiedTime());
        r100.put("ecaId", getEcaId());
        r100.put("orderName", makeModelInputValue("订单名称", this.orderName));
        String r101 = this.orderDesc;
        if (r101 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        r100.put("orderDesc", makeModelInputValue("订单描述", r101));
    L5:
        String r102 = this.orderCreateDate;
        if (r102 == null) goto L8;
        Intrinsics.checkNotNull(r102);
        r100.put("orderCreateDate", makeModelInputValue("订单创建日期", r102));
    L8:
        String r103 = this.orderCreateTime;
        if (r103 == null) goto L11;
        Intrinsics.checkNotNull(r103);
        r100.put("orderCreateTime", makeModelInputValue("订单创建时间", r103));
    L11:
        return r100;
    }

    public final String getOrderCreateDate() {
        return this.orderCreateDate;
    }

    public final String getOrderCreateTime() {
        return this.orderCreateTime;
    }

    public final String getOrderDesc() {
        return this.orderDesc;
    }

    public final String getOrderName() {
        return this.orderName;
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

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r100, ClassLoader r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
    }

    public final void setOrderCreateDate(String r100) {
        this.orderCreateDate = r100;
    }

    public final void setOrderCreateTime(String r100) {
        this.orderCreateTime = r100;
    }

    public final void setOrderDesc(String r100) {
        this.orderDesc = r100;
    }

    public final void setOrderName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.orderName = r100;
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity, com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        writeMemoryBaseFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeString(this.orderName);
        r100.writeString(this.orderDesc);
        r100.writeString(this.orderCreateDate);
        r100.writeString(this.orderCreateTime);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r100, r101);
        r100.writeInt(0);
    }
}
