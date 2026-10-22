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
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00011B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005Bq\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0014J\b\u0010%\u001a\u00020&H\u0016J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0016J\"\u0010*\u001a\u00020+2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\fH\u0016J\u0018\u0010/\u001a\u00020+2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u00100\u001a\u00020\fH\u0016R\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018¨\u00062"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/OrderHotelMemoryEntity;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "productType", "", "checkInDate", "hotelName", "checkOutDate", "hotelAddress", "checkInTime", "checkOutTime", "city", "(Ljava/lang/String;JJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCheckInDate", "()Ljava/lang/String;", "setCheckInDate", "(Ljava/lang/String;)V", "getCheckInTime", "setCheckInTime", "getCheckOutDate", "setCheckOutDate", "getCheckOutTime", "setCheckOutTime", "getCity", "setCity", "getHotelAddress", "setHotelAddress", "getHotelName", "setHotelName", "convertToModelInput", "Lorg/json/JSONObject;", "getSharedUris", "", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OrderHotelMemoryEntity extends MemoryEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 1;
    private static final int RELATED_VERSION = 0;
    private String checkInDate;
    private String checkInTime;
    private String checkOutDate;
    private String checkOutTime;
    private String city;
    private String hotelAddress;
    private String hotelName;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/OrderHotelMemoryEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/memory/OrderHotelMemoryEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/memory/OrderHotelMemoryEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<OrderHotelMemoryEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderHotelMemoryEntity createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            AppEntity r101 = AppEntity.CREATOR.createFromParcel(r100);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.OrderHotelMemoryEntity");
            return (OrderHotelMemoryEntity) r101;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderHotelMemoryEntity createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        public final int getVersion() {
            return 1;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderHotelMemoryEntity[] newArray(int r100) {
            return new OrderHotelMemoryEntity[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderHotelMemoryEntity[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public OrderHotelMemoryEntity(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "parcel");
        this(EntityExtKt.e(r110), r110.readLong(), r110.readLong(), r110.readInt(), EntityExtKt.e(r110), EntityExtKt.e(r110), r110.readString(), r110.readString(), r110.readString(), r110.readString(), null, 1024, null);
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r110);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r110, 1, r110.readInt());
    }

    public OrderHotelMemoryEntity(String r110, long r111, long r112, int r113, String r114, String r115, String r210, String r211, String r212, String r213, String r214) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r114, "checkInDate");
        Intrinsics.checkNotNullParameter(r115, "hotelName");
        super(r110, r111, r112, 10004, r113);
        this.checkInDate = r114;
        this.hotelName = r115;
        this.checkOutDate = r210;
        this.hotelAddress = r211;
        this.checkInTime = r212;
        this.checkOutTime = r213;
        this.city = r214;
    }

    public /* synthetic */ OrderHotelMemoryEntity(String r110, long r111, long r210, int r211, String r212, String r213, String r214, String r215, String r216, String r217, String r310, int r311, DefaultConstructorMarker r312) {
        if ((r311 & 64) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r311 & 128) == 0) goto L9;
        String r113 = null;
    L11:
        if ((r311 & 256) == 0) goto L13;
        String r114 = null;
    L15:
        if ((r311 & 512) == 0) goto L17;
        String r115 = null;
    L19:
        if ((r311 & 1024) == 0) goto L21;
        String r116 = null;
    L22:
        this(r110, r111, r210, r211, r212, r213, r112, r113, r114, r115, r116);
        return;
    L21:
        r116 = r310;
        goto L22
    L17:
        r115 = r217;
        goto L19
    L13:
        r114 = r216;
        goto L15
    L9:
        r113 = r215;
        goto L11
    L5:
        r112 = r214;
        goto L7
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity
    public JSONObject convertToModelInput() {
        JSONObject r100 = new JSONObject();
        r100.put("type", getType());
        r100.put("createTime", getCreateTime());
        r100.put("modifyTime", getLastModifiedTime());
        r100.put("ecaId", getEcaId());
        r100.put("checkInDate", makeModelInputValue("入住日期", this.checkInDate));
        r100.put("hotelName", makeModelInputValue("酒店名称", this.hotelName));
        String r101 = this.checkOutDate;
        if (r101 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        r100.put("checkOutDate", makeModelInputValue("退房日期", r101));
    L5:
        String r102 = this.city;
        if (r102 == null) goto L8;
        Intrinsics.checkNotNull(r102);
        r100.put("city", makeModelInputValue("城市", r102));
    L8:
        String r103 = this.hotelAddress;
        if (r103 == null) goto L11;
        Intrinsics.checkNotNull(r103);
        r100.put("hotelAddress", makeModelInputValue("酒店地址", r103));
    L11:
        String r104 = this.checkInTime;
        if (r104 == null) goto L14;
        Intrinsics.checkNotNull(r104);
        r100.put("checkInTime", makeModelInputValue("入住时间", r104));
    L14:
        String r105 = this.checkOutTime;
        if (r105 == null) goto L17;
        Intrinsics.checkNotNull(r105);
        r100.put("checkOutTime", makeModelInputValue("退房时间", r105));
    L17:
        return r100;
    }

    public final String getCheckInDate() {
        return this.checkInDate;
    }

    public final String getCheckInTime() {
        return this.checkInTime;
    }

    public final String getCheckOutDate() {
        return this.checkOutDate;
    }

    public final String getCheckOutTime() {
        return this.checkOutTime;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getHotelAddress() {
        return this.hotelAddress;
    }

    public final String getHotelName() {
        return this.hotelName;
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
        if (r102 != 1) goto L6;
        this.city = (String) r100.readValue(r101);
        return;
    }

    public final void setCheckInDate(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.checkInDate = r100;
    }

    public final void setCheckInTime(String r100) {
        this.checkInTime = r100;
    }

    public final void setCheckOutDate(String r100) {
        this.checkOutDate = r100;
    }

    public final void setCheckOutTime(String r100) {
        this.checkOutTime = r100;
    }

    public final void setCity(String r100) {
        this.city = r100;
    }

    public final void setHotelAddress(String r100) {
        this.hotelAddress = r100;
    }

    public final void setHotelName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.hotelName = r100;
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity, com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        writeMemoryBaseFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeString(this.checkInDate);
        r100.writeString(this.hotelName);
        r100.writeString(this.checkOutDate);
        r100.writeString(this.hotelAddress);
        r100.writeString(this.checkInTime);
        r100.writeString(this.checkOutTime);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r100, r101);
        r100.writeInt(1);
        r100.writeValue(this.city);
    }
}
