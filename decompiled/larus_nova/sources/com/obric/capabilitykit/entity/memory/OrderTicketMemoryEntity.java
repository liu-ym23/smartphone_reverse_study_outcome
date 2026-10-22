package com.obric.capabilitykit.entity.memory;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00019B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u008b\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017J\b\u0010.\u001a\u00020/H\u0016J\u000e\u00100\u001a\b\u0012\u0004\u0012\u0002010\u0016H\u0016J\"\u00102\u001a\u0002032\u0006\u0010\u0003\u001a\u00020\u00042\b\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u00020\fH\u0016J\u0018\u00107\u001a\u0002032\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u00108\u001a\u00020\fH\u0016R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010\u001bR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\u001bR\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001bR\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0019\"\u0004\b-\u0010\u001b¨\u0006:"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/OrderTicketMemoryEntity;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "productType", "", "name", "date", DyPayConstant.KEY_START_TIME, "endTime", "city", "auditoriumName", "auditoriumAddress", "hallNumber", "seatNumber", "", "(Ljava/lang/String;JJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAuditoriumAddress", "()Ljava/lang/String;", "setAuditoriumAddress", "(Ljava/lang/String;)V", "getAuditoriumName", "setAuditoriumName", "getCity", "setCity", "getDate", "setDate", "getEndTime", "setEndTime", "getHallNumber", "setHallNumber", "getName", "setName", "getSeatNumber", "()Ljava/util/List;", "setSeatNumber", "(Ljava/util/List;)V", "getStartTime", "setStartTime", "convertToModelInput", "Lorg/json/JSONObject;", "getSharedUris", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OrderTicketMemoryEntity extends MemoryEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private String auditoriumAddress;
    private String auditoriumName;
    private String city;
    private String date;
    private String endTime;
    private String hallNumber;
    private String name;
    private List<String> seatNumber;
    private String startTime;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/OrderTicketMemoryEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/memory/OrderTicketMemoryEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/memory/OrderTicketMemoryEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<OrderTicketMemoryEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderTicketMemoryEntity createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            AppEntity r101 = AppEntity.CREATOR.createFromParcel(r100);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.OrderTicketMemoryEntity");
            return (OrderTicketMemoryEntity) r101;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderTicketMemoryEntity createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderTicketMemoryEntity[] newArray(int r100) {
            return new OrderTicketMemoryEntity[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderTicketMemoryEntity[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public OrderTicketMemoryEntity(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "parcel");
        this(EntityExtKt.e(r110), r110.readLong(), r110.readLong(), r110.readInt(), EntityExtKt.e(r110), EntityExtKt.e(r110), EntityExtKt.e(r110), r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.createStringArrayList());
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r110);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r110, 0, r110.readInt());
    }

    public OrderTicketMemoryEntity(String r110, long r111, long r112, int r113, String r114, String r210, String r211, String r212, String r213, String r214, String r215, String r216, List<String> r217) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r114, "name");
        Intrinsics.checkNotNullParameter(r210, "date");
        Intrinsics.checkNotNullParameter(r211, DyPayConstant.KEY_START_TIME);
        super(r110, r111, r112, 10006, r113);
        this.name = r114;
        this.date = r210;
        this.startTime = r211;
        this.endTime = r212;
        this.city = r213;
        this.auditoriumName = r214;
        this.auditoriumAddress = r215;
        this.hallNumber = r216;
        this.seatNumber = r217;
    }

    public /* synthetic */ OrderTicketMemoryEntity(String r210, long r211, long r212, int r213, String r214, String r215, String r216, String r217, String r310, String r311, String r312, String r313, List r314, int r315, DefaultConstructorMarker r316) {
        if ((r315 & 128) == 0) goto L5;
        String r110 = null;
    L7:
        if ((r315 & 256) == 0) goto L9;
        String r111 = null;
    L11:
        if ((r315 & 512) == 0) goto L13;
        String r112 = null;
    L15:
        if ((r315 & 1024) == 0) goto L17;
        String r113 = null;
    L19:
        if ((r315 & 2048) == 0) goto L21;
        String r114 = null;
    L23:
        if ((r315 & 4096) == 0) goto L25;
        List r115 = null;
    L26:
        this(r210, r211, r212, r213, r214, r215, r216, r110, r111, r112, r113, r114, r115);
        return;
    L25:
        r115 = r314;
        goto L26
    L21:
        r114 = r313;
        goto L23
    L17:
        r113 = r312;
        goto L19
    L13:
        r112 = r311;
        goto L15
    L9:
        r111 = r310;
        goto L11
    L5:
        r110 = r217;
        goto L7
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity
    public JSONObject convertToModelInput() {
        JSONObject r100 = new JSONObject();
        r100.put("type", getType());
        r100.put("createTime", getCreateTime());
        r100.put("modifyTime", getLastModifiedTime());
        r100.put("ecaId", getEcaId());
        r100.put("name", makeModelInputValue("名称", this.name));
        r100.put("date", makeModelInputValue("日期", this.date));
        r100.put(DyPayConstant.KEY_START_TIME, makeModelInputValue("开始时间", this.startTime));
        String r101 = this.endTime;
        if (r101 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        r100.put("endTime", makeModelInputValue("结束时间", r101));
    L5:
        String r102 = this.city;
        if (r102 == null) goto L8;
        Intrinsics.checkNotNull(r102);
        r100.put("city", makeModelInputValue("城市", r102));
    L8:
        String r103 = this.auditoriumName;
        if (r103 == null) goto L11;
        Intrinsics.checkNotNull(r103);
        r100.put("auditoriumName", makeModelInputValue("影院/演出厅名称", r103));
    L11:
        String r104 = this.auditoriumAddress;
        if (r104 == null) goto L14;
        Intrinsics.checkNotNull(r104);
        r100.put("auditoriumAddress", makeModelInputValue("具体地址", r104));
    L14:
        String r105 = this.hallNumber;
        if (r105 == null) goto L17;
        Intrinsics.checkNotNull(r105);
        r100.put("hallNumber", makeModelInputValue("厅号", r105));
    L17:
        List<String> r106 = this.seatNumber;
        if (r106 == null) goto L20;
        r100.put("seatNumber", makeModelInputValue("座位号", String.valueOf(r106)));
    L20:
        return r100;
    }

    public final String getAuditoriumAddress() {
        return this.auditoriumAddress;
    }

    public final String getAuditoriumName() {
        return this.auditoriumName;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final String getHallNumber() {
        return this.hallNumber;
    }

    public final String getName() {
        return this.name;
    }

    public final List<String> getSeatNumber() {
        return this.seatNumber;
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

    public final String getStartTime() {
        return this.startTime;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r100, ClassLoader r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
    }

    public final void setAuditoriumAddress(String r100) {
        this.auditoriumAddress = r100;
    }

    public final void setAuditoriumName(String r100) {
        this.auditoriumName = r100;
    }

    public final void setCity(String r100) {
        this.city = r100;
    }

    public final void setDate(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.date = r100;
    }

    public final void setEndTime(String r100) {
        this.endTime = r100;
    }

    public final void setHallNumber(String r100) {
        this.hallNumber = r100;
    }

    public final void setName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.name = r100;
    }

    public final void setSeatNumber(List<String> r100) {
        this.seatNumber = r100;
    }

    public final void setStartTime(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.startTime = r100;
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity, com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        writeMemoryBaseFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeString(this.name);
        r100.writeString(this.date);
        r100.writeString(this.startTime);
        r100.writeString(this.endTime);
        r100.writeString(this.city);
        r100.writeString(this.auditoriumName);
        r100.writeString(this.auditoriumAddress);
        r100.writeString(this.hallNumber);
        r100.writeStringList(this.seatNumber);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r100, r101);
        r100.writeInt(0);
    }
}
