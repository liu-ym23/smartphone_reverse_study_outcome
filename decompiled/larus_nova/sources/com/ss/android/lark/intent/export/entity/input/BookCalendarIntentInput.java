package com.ss.android.lark.intent.export.entity.input;

import com.ss.android.dypay.api.DyPayConstant;
import java.io.Serializable;
import java.util.ArrayList;
import knb.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002Bo\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\n\u0012\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u001d\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\nHÆ\u0003J\u001d\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\nHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010$\u001a\u00020\u000eHÆ\u0003J\u0084\u0001\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\n2\u001c\b\u0002\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001R\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R%\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R%\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006-"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/input/BookCalendarIntentInput;", "Lcom/ss/android/lark/intent/export/entity/input/IntentInput;", "Ljava/io/Serializable;", DyPayConstant.KEY_START_TIME, "", "endTime", "roomDesc", "", "participants", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "participantIds", "agenda", "version", "Lcom/ss/android/lark/intent/export/entity/input/IntentInputVersion;", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Lcom/ss/android/lark/intent/export/entity/input/IntentInputVersion;)V", "getStartTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEndTime", "getRoomDesc", "()Ljava/lang/String;", "getParticipants", "()Ljava/util/ArrayList;", "getParticipantIds", "getAgenda", "getVersion", "()Lcom/ss/android/lark/intent/export/entity/input/IntentInputVersion;", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Lcom/ss/android/lark/intent/export/entity/input/IntentInputVersion;)Lcom/ss/android/lark/intent/export/entity/input/BookCalendarIntentInput;", "equals", "", "other", "", "hashCode", "", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BookCalendarIntentInput extends IntentInput implements Serializable {
    private final String agenda;
    private final Long endTime;
    private final ArrayList<String> participantIds;
    private final ArrayList<String> participants;
    private final String roomDesc;
    private final Long startTime;
    private final IntentInputVersion version;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BookCalendarIntentInput copy$default(BookCalendarIntentInput r100, Long r101, Long r102, String r103, ArrayList r104, ArrayList r110, String r111, IntentInputVersion r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.startTime;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.endTime;
    L8:
        Long r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.roomDesc;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.participants;
    L14:
        ArrayList r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.participantIds;
    L17:
        ArrayList r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.agenda;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.version;
    L23:
        Long r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final Long component1() {
        return this.startTime;
    }

    public final Long component2() {
        return this.endTime;
    }

    public final String component3() {
        return this.roomDesc;
    }

    public final ArrayList<String> component4() {
        return this.participants;
    }

    public final ArrayList<String> component5() {
        return this.participantIds;
    }

    public final String component6() {
        return this.agenda;
    }

    public final IntentInputVersion component7() {
        return this.version;
    }

    public final BookCalendarIntentInput copy(Long r110, Long r111, String r112, ArrayList<String> r113, ArrayList<String> r114, String r115, IntentInputVersion r116) {
        Intrinsics.checkNotNullParameter(r116, "version");
        return new BookCalendarIntentInput(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BookCalendarIntentInput) == true) goto L8;
        return false;
    L8:
        BookCalendarIntentInput r101 = (BookCalendarIntentInput) r100;
        if (Intrinsics.areEqual(this.startTime, r101.startTime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.endTime, r101.endTime) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.roomDesc, r101.roomDesc) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.participants, r101.participants) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.participantIds, r101.participantIds) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.agenda, r101.agenda) == true) goto L27;
        return false;
    L27:
        if (this.version == r101.version) goto L29;
        return false;
    L29:
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
        String r107 = this.roomDesc;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        ArrayList<String> r110 = this.participants;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        ArrayList<String> r113 = this.participantIds;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.agenda;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return ((r115 + r101) * 31) + this.version.hashCode();
    L21:
        r114 = r113.hashCode();
        goto L22
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
        StringBuilder r100 = new StringBuilder("BookCalendarIntentInput(startTime=");
        Object r101 = this.startTime;
        String r102 = "null";
        if (r101 != null) goto L5;
        r101 = "null";
    L5:
        r100.append(r101);
        r100.append(", endTime=");
        Object r103 = this.endTime;
        if (r103 != null) goto L8;
        r103 = "null";
    L8:
        r100.append(r103);
        r100.append(", roomDesc=");
        String r104 = this.roomDesc;
        if (r104 == null) goto L12;
        String r105 = a.a(r104);
        if (r105 == null) goto L12;
    L13:
        r100.append(r105);
        r100.append(", participants=");
        Object r106 = this.participants;
        if (r106 != null) goto L17;
        r106 = "null";
    L17:
        r100.append(r106);
        r100.append(", participantIds=");
        Object r107 = this.participantIds;
        if (r107 != null) goto L21;
        r107 = "null";
    L21:
        r100.append(r107);
        r100.append(", agenda=");
        String r108 = this.agenda;
        if (r108 == null) goto L27;
        String r109 = a.a(r108);
        if (r109 == null) goto L27;
        r102 = r109;
    L27:
        r100.append(r102);
        r100.append(", version=");
        r100.append(this.version);
        r100.append(')');
        return r100.toString();
    L12:
        r105 = "null";
        goto L13
    }

    public final String getAgenda() {
        return this.agenda;
    }

    public final Long getEndTime() {
        return this.endTime;
    }

    public final ArrayList<String> getParticipantIds() {
        return this.participantIds;
    }

    public final ArrayList<String> getParticipants() {
        return this.participants;
    }

    public final String getRoomDesc() {
        return this.roomDesc;
    }

    public final Long getStartTime() {
        return this.startTime;
    }

    public final IntentInputVersion getVersion() {
        return this.version;
    }

    public BookCalendarIntentInput(Long r100, Long r101, String r102, ArrayList<String> r103, ArrayList<String> r104, String r105, IntentInputVersion r106) {
        Intrinsics.checkNotNullParameter(r106, "version");
        super(IntentInput.IntentType.BOOKING_CALENDAR);
        this.startTime = r100;
        this.endTime = r101;
        this.roomDesc = r102;
        this.participants = r103;
        this.participantIds = r104;
        this.agenda = r105;
        this.version = r106;
    }
}
