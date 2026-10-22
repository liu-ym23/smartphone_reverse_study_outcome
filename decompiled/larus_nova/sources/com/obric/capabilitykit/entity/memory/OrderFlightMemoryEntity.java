package com.obric.capabilitykit.entity.memory;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.ec.core.event.a;
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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0001BB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B©\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0018\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0018¢\u0006\u0002\u0010\u001aJ\b\u00107\u001a\u000208H\u0016J\u000e\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u0018H\u0016J\"\u0010;\u001a\u00020<2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010?\u001a\u00020\fH\u0016J\u0018\u0010@\u001a\u00020<2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\fH\u0016R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u001a\u0010\u0010\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001c\"\u0004\b(\u0010\u001eR\u001a\u0010\u0012\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001eR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001c\"\u0004\b,\u0010\u001eR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001c\"\u0004\b.\u0010\u001eR\u001a\u0010\u0011\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001c\"\u0004\b0\u0010\u001eR\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00102\"\u0004\b6\u00104¨\u0006C"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/OrderFlightMemoryEntity;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "productType", "", "departureDate", "departurePlace", a.KEY_DESTINATION, "departureTime", "landingTime", "flightNumber", "landingDate", "departureAirport", "landingAirport", "boardingGate", "passengerName", "", "seatNumber", "(Ljava/lang/String;JJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getBoardingGate", "()Ljava/lang/String;", "setBoardingGate", "(Ljava/lang/String;)V", "getDepartureAirport", "setDepartureAirport", "getDepartureDate", "setDepartureDate", "getDeparturePlace", "setDeparturePlace", "getDepartureTime", "setDepartureTime", "getDestination", "setDestination", "getFlightNumber", "setFlightNumber", "getLandingAirport", "setLandingAirport", "getLandingDate", "setLandingDate", "getLandingTime", "setLandingTime", "getPassengerName", "()Ljava/util/List;", "setPassengerName", "(Ljava/util/List;)V", "getSeatNumber", "setSeatNumber", "convertToModelInput", "Lorg/json/JSONObject;", "getSharedUris", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OrderFlightMemoryEntity extends MemoryEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private String boardingGate;
    private String departureAirport;
    private String departureDate;
    private String departurePlace;
    private String departureTime;
    private String destination;
    private String flightNumber;
    private String landingAirport;
    private String landingDate;
    private String landingTime;
    private List<String> passengerName;
    private List<String> seatNumber;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/OrderFlightMemoryEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/memory/OrderFlightMemoryEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/memory/OrderFlightMemoryEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<OrderFlightMemoryEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderFlightMemoryEntity createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            AppEntity r101 = AppEntity.CREATOR.createFromParcel(r100);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.OrderFlightMemoryEntity");
            return (OrderFlightMemoryEntity) r101;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderFlightMemoryEntity createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderFlightMemoryEntity[] newArray(int r100) {
            return new OrderFlightMemoryEntity[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderFlightMemoryEntity[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public OrderFlightMemoryEntity(Parcel r210) {
        Intrinsics.checkNotNullParameter(r210, "parcel");
        this(EntityExtKt.e(r210), r210.readLong(), r210.readLong(), r210.readInt(), EntityExtKt.e(r210), EntityExtKt.e(r210), EntityExtKt.e(r210), EntityExtKt.e(r210), EntityExtKt.e(r210), EntityExtKt.e(r210), r210.readString(), r210.readString(), r210.readString(), r210.readString(), r210.createStringArrayList(), r210.createStringArrayList());
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r210);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r210, 0, r210.readInt());
    }

    public OrderFlightMemoryEntity(String r110, long r111, long r112, int r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r310, String r311, List<String> r312, List<String> r313) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r211, "departureDate");
        Intrinsics.checkNotNullParameter(r212, "departurePlace");
        Intrinsics.checkNotNullParameter(r213, a.KEY_DESTINATION);
        Intrinsics.checkNotNullParameter(r214, "departureTime");
        Intrinsics.checkNotNullParameter(r215, "landingTime");
        Intrinsics.checkNotNullParameter(r216, "flightNumber");
        super(r110, r111, r112, 10001, r210);
        this.departureDate = r211;
        this.departurePlace = r212;
        this.destination = r213;
        this.departureTime = r214;
        this.landingTime = r215;
        this.flightNumber = r216;
        this.landingDate = r217;
        this.departureAirport = r218;
        this.landingAirport = r310;
        this.boardingGate = r311;
        this.passengerName = r312;
        this.seatNumber = r313;
    }

    public /* synthetic */ OrderFlightMemoryEntity(String r210, long r211, long r212, int r213, String r214, String r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, String r318, List r319, List r410, int r411, DefaultConstructorMarker r412) {
        if ((r411 & 1024) == 0) goto L5;
        String r110 = null;
    L7:
        if ((r411 & 2048) == 0) goto L9;
        String r111 = null;
    L11:
        if ((r411 & 4096) == 0) goto L13;
        String r112 = null;
    L15:
        if ((r411 & 8192) == 0) goto L17;
        String r113 = null;
    L19:
        if ((r411 & 16384) == 0) goto L21;
        List r215 = null;
    L23:
        if ((r411 & 32768) == 0) goto L25;
        List r216 = null;
    L26:
        this(r210, r211, r212, r213, r214, r310, r311, r312, r313, r314, r110, r111, r112, r113, r215, r216);
        return;
    L25:
        r216 = r410;
        goto L26
    L21:
        r215 = r319;
        goto L23
    L17:
        r113 = r318;
        goto L19
    L13:
        r112 = r317;
        goto L15
    L9:
        r111 = r316;
        goto L11
    L5:
        r110 = r315;
        goto L7
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity
    public JSONObject convertToModelInput() {
        JSONObject r100 = new JSONObject();
        r100.put("type", getType());
        r100.put("createTime", getCreateTime());
        r100.put("modifyTime", getLastModifiedTime());
        r100.put("ecaId", getEcaId());
        r100.put("departureDate", makeModelInputValue("出发日期", this.departureDate));
        r100.put("departurePlace", makeModelInputValue("出发地", this.departurePlace));
        r100.put(a.KEY_DESTINATION, makeModelInputValue("目的地", this.destination));
        r100.put("departureTime", makeModelInputValue("起飞时间", this.departureTime));
        r100.put("landingTime", makeModelInputValue("落地时间", this.landingTime));
        r100.put("flightNumber", makeModelInputValue("航班号", this.flightNumber));
        String r101 = this.landingDate;
        if (r101 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        r100.put("landingDate", makeModelInputValue("落地日期", r101));
    L5:
        String r102 = this.departureAirport;
        if (r102 == null) goto L8;
        Intrinsics.checkNotNull(r102);
        r100.put("departureAirport", makeModelInputValue("起飞机场", r102));
    L8:
        String r103 = this.landingAirport;
        if (r103 == null) goto L11;
        Intrinsics.checkNotNull(r103);
        r100.put("landingAirport", makeModelInputValue("落地机场", r103));
    L11:
        String r104 = this.boardingGate;
        if (r104 == null) goto L14;
        Intrinsics.checkNotNull(r104);
        r100.put("boardingGate", makeModelInputValue("登机口", r104));
    L14:
        List<String> r105 = this.passengerName;
        if (r105 == null) goto L17;
        r100.put("passengerName", makeModelInputValue("乘客名", String.valueOf(r105)));
    L17:
        List<String> r106 = this.seatNumber;
        if (r106 == null) goto L20;
        r100.put("seatNumber", makeModelInputValue("座位号", String.valueOf(r106)));
    L20:
        return r100;
    }

    public final String getBoardingGate() {
        return this.boardingGate;
    }

    public final String getDepartureAirport() {
        return this.departureAirport;
    }

    public final String getDepartureDate() {
        return this.departureDate;
    }

    public final String getDeparturePlace() {
        return this.departurePlace;
    }

    public final String getDepartureTime() {
        return this.departureTime;
    }

    public final String getDestination() {
        return this.destination;
    }

    public final String getFlightNumber() {
        return this.flightNumber;
    }

    public final String getLandingAirport() {
        return this.landingAirport;
    }

    public final String getLandingDate() {
        return this.landingDate;
    }

    public final String getLandingTime() {
        return this.landingTime;
    }

    public final List<String> getPassengerName() {
        return this.passengerName;
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

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r100, ClassLoader r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
    }

    public final void setBoardingGate(String r100) {
        this.boardingGate = r100;
    }

    public final void setDepartureAirport(String r100) {
        this.departureAirport = r100;
    }

    public final void setDepartureDate(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.departureDate = r100;
    }

    public final void setDeparturePlace(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.departurePlace = r100;
    }

    public final void setDepartureTime(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.departureTime = r100;
    }

    public final void setDestination(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.destination = r100;
    }

    public final void setFlightNumber(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.flightNumber = r100;
    }

    public final void setLandingAirport(String r100) {
        this.landingAirport = r100;
    }

    public final void setLandingDate(String r100) {
        this.landingDate = r100;
    }

    public final void setLandingTime(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.landingTime = r100;
    }

    public final void setPassengerName(List<String> r100) {
        this.passengerName = r100;
    }

    public final void setSeatNumber(List<String> r100) {
        this.seatNumber = r100;
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity, com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        writeMemoryBaseFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeString(this.departureDate);
        r100.writeString(this.departurePlace);
        r100.writeString(this.destination);
        r100.writeString(this.departureTime);
        r100.writeString(this.landingTime);
        r100.writeString(this.flightNumber);
        r100.writeString(this.landingDate);
        r100.writeString(this.departureAirport);
        r100.writeString(this.landingAirport);
        r100.writeString(this.boardingGate);
        r100.writeStringList(this.passengerName);
        r100.writeStringList(this.seatNumber);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r100, r101);
        r100.writeInt(0);
    }
}
