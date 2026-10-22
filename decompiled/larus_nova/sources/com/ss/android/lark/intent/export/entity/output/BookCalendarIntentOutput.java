package com.ss.android.lark.intent.export.entity.output;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003JZ\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010!J\u0006\u0010\"\u001a\u00020#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020#HÖ\u0001J\t\u0010)\u001a\u00020\u000bHÖ\u0001J\u0016\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020#R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018¨\u0006/"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/BookCalendarIntentOutput;", "Lcom/ss/android/lark/intent/export/entity/output/common/CommonSuccessIntentOutput;", DyPayConstant.KEY_START_TIME, "", "endTime", "roomDetail", "Lcom/ss/android/lark/intent/export/entity/output/CalendarRoomDetail;", "participants", "", "Lcom/ss/android/lark/intent/export/entity/output/CalendarParticipant;", "agoda", "", "display", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Lcom/ss/android/lark/intent/export/entity/output/CalendarRoomDetail;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getStartTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEndTime", "getRoomDetail", "()Lcom/ss/android/lark/intent/export/entity/output/CalendarRoomDetail;", "getParticipants", "()Ljava/util/List;", "getAgoda", "()Ljava/lang/String;", "getDisplay", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Lcom/ss/android/lark/intent/export/entity/output/CalendarRoomDetail;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lcom/ss/android/lark/intent/export/entity/output/BookCalendarIntentOutput;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BookCalendarIntentOutput extends CommonSuccessIntentOutput {
    public static final Parcelable.Creator<BookCalendarIntentOutput> CREATOR = null;
    private final String agoda;
    private final String display;
    private final Long endTime;
    private final List<CalendarParticipant> participants;
    private final CalendarRoomDetail roomDetail;
    private final Long startTime;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<BookCalendarIntentOutput> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BookCalendarIntentOutput createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            CalendarRoomDetail r100 = null;
            if (r110.readInt() != 0) goto L5;
            Long r101 = null;
        L7:
            if (r110.readInt() != 0) goto L9;
            Long r102 = null;
        L11:
            if (r110.readInt() == 0) goto L14;
            r100 = CalendarRoomDetail.CREATOR.createFromParcel(r110);
        L14:
            CalendarRoomDetail r103 = r100;
            int r104 = r110.readInt();
            ArrayList r105 = new ArrayList(r104);
            int r106 = 0;
        L15:
            if (r106 == r104) goto L18;
            r105.add(CalendarParticipant.CREATOR.createFromParcel(r110));
            r106 = r106 + 1;
            goto L15
        L18:
            return new BookCalendarIntentOutput(r101, r102, r103, r105, r110.readString(), r110.readString());
        L9:
            r102 = Long.valueOf(r110.readLong());
            goto L11
        L5:
            r101 = Long.valueOf(r110.readLong());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BookCalendarIntentOutput createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BookCalendarIntentOutput[] newArray(int r100) {
            return new BookCalendarIntentOutput[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ BookCalendarIntentOutput[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BookCalendarIntentOutput copy$default(BookCalendarIntentOutput r100, Long r101, Long r102, CalendarRoomDetail r103, List r104, String r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.startTime;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.endTime;
    L8:
        Long r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.roomDetail;
    L11:
        CalendarRoomDetail r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.participants;
    L14:
        List r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.agoda;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.display;
    L20:
        Long r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final Long component1() {
        return this.startTime;
    }

    public final Long component2() {
        return this.endTime;
    }

    public final CalendarRoomDetail component3() {
        return this.roomDetail;
    }

    public final List<CalendarParticipant> component4() {
        return this.participants;
    }

    public final String component5() {
        return this.agoda;
    }

    public final String component6() {
        return this.display;
    }

    public final BookCalendarIntentOutput copy(Long r100, Long r110, CalendarRoomDetail r111, List<CalendarParticipant> r112, String r113, String r114) {
        Intrinsics.checkNotNullParameter(r112, "participants");
        return new BookCalendarIntentOutput(r100, r110, r111, r112, r113, r114);
    }

    @Override // com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput, com.ss.android.lark.intent.export.entity.output.IntentOutput, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BookCalendarIntentOutput) == true) goto L8;
        return false;
    L8:
        BookCalendarIntentOutput r101 = (BookCalendarIntentOutput) r100;
        if (Intrinsics.areEqual(this.startTime, r101.startTime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.endTime, r101.endTime) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.roomDetail, r101.roomDetail) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.participants, r101.participants) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.agoda, r101.agoda) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.display, r101.display) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        Long r100 = this.startTime;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.endTime;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        CalendarRoomDetail r107 = this.roomDetail;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r106 + r108) * 31) + this.participants.hashCode()) * 31;
        String r110 = this.agoda;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.display;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "BookCalendarIntentOutput(startTime=" + this.startTime + ", endTime=" + this.endTime + ", roomDetail=" + this.roomDetail + ", participants=" + this.participants + ", agoda=" + this.agoda + ", display=" + this.display + ')';
    }

    @Override // com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput, com.ss.android.lark.intent.export.entity.output.IntentOutput, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Long r102 = this.startTime;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Long r103 = this.endTime;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        CalendarRoomDetail r104 = this.roomDetail;
        if (r104 != null) goto L13;
        r100.writeInt(0);
    L14:
        List<CalendarParticipant> r105 = this.participants;
        r100.writeInt(r105.size());
        Iterator<CalendarParticipant> r106 = r105.iterator();
    L16:
        if (r106.hasNext() == false) goto L18;
        r106.next().writeToParcel(r100, r101);
        goto L16
    L18:
        r100.writeString(this.agoda);
        r100.writeString(this.display);
        return;
    L13:
        r100.writeInt(1);
        r104.writeToParcel(r100, r101);
        goto L14
    L9:
        r100.writeInt(1);
        r100.writeLong(r103.longValue());
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeLong(r102.longValue());
        goto L6
    }

    public final String getAgoda() {
        return this.agoda;
    }

    public final String getDisplay() {
        return this.display;
    }

    public final Long getEndTime() {
        return this.endTime;
    }

    public final List<CalendarParticipant> getParticipants() {
        return this.participants;
    }

    public final CalendarRoomDetail getRoomDetail() {
        return this.roomDetail;
    }

    public final Long getStartTime() {
        return this.startTime;
    }

    public BookCalendarIntentOutput(Long r100, Long r101, CalendarRoomDetail r102, List<CalendarParticipant> r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r103, "participants");
        super(Direction.CALENDER_EDIT, r105);
        this.startTime = r100;
        this.endTime = r101;
        this.roomDetail = r102;
        this.participants = r103;
        this.agoda = r104;
        this.display = r105;
    }

    public /* synthetic */ BookCalendarIntentOutput(Long r100, Long r101, CalendarRoomDetail r110, List r111, String r112, String r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 32) == 0) goto L5;
        r113 = null;
    L5:
        this(r100, r101, r110, r111, r112, r113);
    }
}
