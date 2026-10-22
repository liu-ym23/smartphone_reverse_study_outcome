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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00016B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u007f\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\b\u0010+\u001a\u00020,H\u0016J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u0015H\u0016J\"\u0010/\u001a\u0002002\u0006\u0010\u0003\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u00020\fH\u0016J\u0018\u00104\u001a\u0002002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u00105\u001a\u00020\fH\u0016R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\u001aR\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010\u001a¨\u00067"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/OrderMovieTicketMemoryEntity;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "productType", "", "movieName", "movieDate", DyPayConstant.KEY_START_TIME, "endTime", "movieTheaterName", "movieTheaterAddress", "movieHallNumber", "seatNumber", "", "(Ljava/lang/String;JJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getEndTime", "()Ljava/lang/String;", "setEndTime", "(Ljava/lang/String;)V", "getMovieDate", "setMovieDate", "getMovieHallNumber", "setMovieHallNumber", "getMovieName", "setMovieName", "getMovieTheaterAddress", "setMovieTheaterAddress", "getMovieTheaterName", "setMovieTheaterName", "getSeatNumber", "()Ljava/util/List;", "setSeatNumber", "(Ljava/util/List;)V", "getStartTime", "setStartTime", "convertToModelInput", "Lorg/json/JSONObject;", "getSharedUris", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OrderMovieTicketMemoryEntity extends MemoryEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private String endTime;
    private String movieDate;
    private String movieHallNumber;
    private String movieName;
    private String movieTheaterAddress;
    private String movieTheaterName;
    private List<String> seatNumber;
    private String startTime;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/OrderMovieTicketMemoryEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/memory/OrderMovieTicketMemoryEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/memory/OrderMovieTicketMemoryEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<OrderMovieTicketMemoryEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderMovieTicketMemoryEntity createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            AppEntity r101 = AppEntity.CREATOR.createFromParcel(r100);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.OrderMovieTicketMemoryEntity");
            return (OrderMovieTicketMemoryEntity) r101;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderMovieTicketMemoryEntity createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderMovieTicketMemoryEntity[] newArray(int r100) {
            return new OrderMovieTicketMemoryEntity[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderMovieTicketMemoryEntity[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public OrderMovieTicketMemoryEntity(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "parcel");
        this(EntityExtKt.e(r110), r110.readLong(), r110.readLong(), r110.readInt(), EntityExtKt.e(r110), EntityExtKt.e(r110), EntityExtKt.e(r110), r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.createStringArrayList());
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r110);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r110, 0, r110.readInt());
    }

    public OrderMovieTicketMemoryEntity(String r110, long r111, long r112, int r113, String r114, String r210, String r211, String r212, String r213, String r214, String r215, List<String> r216) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r114, "movieName");
        Intrinsics.checkNotNullParameter(r210, "movieDate");
        Intrinsics.checkNotNullParameter(r211, DyPayConstant.KEY_START_TIME);
        super(r110, r111, r112, 10003, r113);
        this.movieName = r114;
        this.movieDate = r210;
        this.startTime = r211;
        this.endTime = r212;
        this.movieTheaterName = r213;
        this.movieTheaterAddress = r214;
        this.movieHallNumber = r215;
        this.seatNumber = r216;
    }

    public /* synthetic */ OrderMovieTicketMemoryEntity(String r110, long r210, long r211, int r212, String r213, String r214, String r215, String r216, String r217, String r310, String r311, List r312, int r313, DefaultConstructorMarker r314) {
        if ((r313 & 128) == 0) goto L5;
        String r111 = null;
    L7:
        if ((r313 & 256) == 0) goto L9;
        String r112 = null;
    L11:
        if ((r313 & 512) == 0) goto L13;
        String r113 = null;
    L15:
        if ((r313 & 1024) == 0) goto L17;
        String r114 = null;
    L19:
        if ((r313 & 2048) == 0) goto L21;
        List r115 = null;
    L22:
        this(r110, r210, r211, r212, r213, r214, r215, r111, r112, r113, r114, r115);
        return;
    L21:
        r115 = r312;
        goto L22
    L17:
        r114 = r311;
        goto L19
    L13:
        r113 = r310;
        goto L15
    L9:
        r112 = r217;
        goto L11
    L5:
        r111 = r216;
        goto L7
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity
    public JSONObject convertToModelInput() {
        JSONObject r100 = new JSONObject();
        r100.put("type", getType());
        r100.put("createTime", getCreateTime());
        r100.put("modifyTime", getLastModifiedTime());
        r100.put("ecaId", getEcaId());
        r100.put("movieName", makeModelInputValue("电影名称", this.movieName));
        r100.put("movieDate", makeModelInputValue("观影日期", this.movieDate));
        r100.put(DyPayConstant.KEY_START_TIME, makeModelInputValue("开场时间", this.startTime));
        String r101 = this.endTime;
        if (r101 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        r100.put("endTime", makeModelInputValue("结束时间", r101));
    L5:
        String r102 = this.movieTheaterName;
        if (r102 == null) goto L8;
        Intrinsics.checkNotNull(r102);
        r100.put("movieTheaterName", makeModelInputValue("电影院名称", r102));
    L8:
        String r103 = this.movieTheaterAddress;
        if (r103 == null) goto L11;
        Intrinsics.checkNotNull(r103);
        r100.put("movieTheaterAddress", makeModelInputValue("电影院地址", r103));
    L11:
        String r104 = this.movieHallNumber;
        if (r104 == null) goto L14;
        Intrinsics.checkNotNull(r104);
        r100.put("movieHallNumber", makeModelInputValue("电影厅号", r104));
    L14:
        List<String> r105 = this.seatNumber;
        if (r105 == null) goto L17;
        r100.put("seatNumber", makeModelInputValue("座位号", String.valueOf(r105)));
    L17:
        return r100;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final String getMovieDate() {
        return this.movieDate;
    }

    public final String getMovieHallNumber() {
        return this.movieHallNumber;
    }

    public final String getMovieName() {
        return this.movieName;
    }

    public final String getMovieTheaterAddress() {
        return this.movieTheaterAddress;
    }

    public final String getMovieTheaterName() {
        return this.movieTheaterName;
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

    public final void setEndTime(String r100) {
        this.endTime = r100;
    }

    public final void setMovieDate(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.movieDate = r100;
    }

    public final void setMovieHallNumber(String r100) {
        this.movieHallNumber = r100;
    }

    public final void setMovieName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.movieName = r100;
    }

    public final void setMovieTheaterAddress(String r100) {
        this.movieTheaterAddress = r100;
    }

    public final void setMovieTheaterName(String r100) {
        this.movieTheaterName = r100;
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
        r100.writeString(this.movieName);
        r100.writeString(this.movieDate);
        r100.writeString(this.startTime);
        r100.writeString(this.endTime);
        r100.writeString(this.movieTheaterName);
        r100.writeString(this.movieTheaterAddress);
        r100.writeString(this.movieHallNumber);
        r100.writeStringList(this.seatNumber);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r100, r101);
        r100.writeInt(0);
    }
}
