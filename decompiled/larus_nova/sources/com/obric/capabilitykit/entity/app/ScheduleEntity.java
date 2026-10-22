package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.enums.CalendarTypeEnum;
import com.ss.android.dypay.api.DyPayConstant;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b:\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 c2\u00020\u0001:\u0001cB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B5\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0002\u0010\rJ\"\u0010[\u001a\u00020\\2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010]\u001a\u0004\u0018\u00010^2\u0006\u0010_\u001a\u00020`H\u0016J\u0018\u0010a\u001a\u00020\\2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010b\u001a\u00020`H\u0016R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\f\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0010\"\u0004\b-\u0010\u0012R\u001e\u0010.\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00104\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0010\"\u0004\b6\u0010\u0012R\u001c\u00107\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0010\"\u0004\b9\u0010\u0012R\u001a\u0010:\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0016\"\u0004\b;\u0010\u0018R\u001e\u0010<\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\b=\u00100\"\u0004\b>\u00102R\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0010\"\u0004\b@\u0010\u0012R\u001c\u0010A\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0010\"\u0004\bC\u0010\u0012R\u001c\u0010D\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0010\"\u0004\bF\u0010\u0012R\u001c\u0010G\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0010\"\u0004\bI\u0010\u0012R\u001c\u0010J\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0010\"\u0004\bL\u0010\u0012R\u001c\u0010M\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0010\"\u0004\bO\u0010\u0012R\u001c\u0010P\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0010\"\u0004\bR\u0010\u0012R\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0010\"\u0004\bT\u0010\u0012R\u001e\u0010U\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\bV\u00100\"\u0004\bW\u00102R\u001c\u0010X\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u0010\"\u0004\bZ\u0010\u0012¨\u0006d"}, d2 = {"Lcom/obric/capabilitykit/entity/app/ScheduleEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "name", DyPayConstant.KEY_START_TIME, "endTime", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "address", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "allDay", "", "getAllDay", "()Z", "setAllDay", "(Z)V", "attendees", "", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "getAttendees", "()Ljava/util/List;", "setAttendees", "(Ljava/util/List;)V", "calendarType", "Lcom/obric/capabilitykit/entity/enums/CalendarTypeEnum;", "getCalendarType", "()Lcom/obric/capabilitykit/entity/enums/CalendarTypeEnum;", "setCalendarType", "(Lcom/obric/capabilitykit/entity/enums/CalendarTypeEnum;)V", "completed", "getCompleted", "()Ljava/lang/Boolean;", "setCompleted", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getEndTime", "setEndTime", "endTimestamp", "getEndTimestamp", "()Ljava/lang/Long;", "setEndTimestamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "iCalendarText", "getICalendarText", "setICalendarText", "icsId", "getIcsId", "setIcsId", Keys.API_EVENT_KEY_IS_FAVORITE, "setFavorite", "jumpCalendarPageStartTimeStamp", "getJumpCalendarPageStartTimeStamp", "setJumpCalendarPageStartTimeStamp", "getName", "setName", "note", "getNote", "setNote", "rawRrule", "getRawRrule", "setRawRrule", "recurrenceId", "getRecurrenceId", "setRecurrenceId", "reminderDesc", "getReminderDesc", "setReminderDesc", "repeatDescription", "getRepeatDescription", "setRepeatDescription", "rruleDescription", "getRruleDescription", "setRruleDescription", "getStartTime", "setStartTime", "startTimestamp", "getStartTimestamp", "setStartTimestamp", "timeDescription", "getTimeDescription", "setTimeDescription", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ScheduleEntity extends AppEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 15;
    private static final int RELATED_VERSION = 2;
    private String address;
    private boolean allDay;
    private List<ContactEntity> attendees;
    private CalendarTypeEnum calendarType;
    private Boolean completed;
    private String endTime;
    private Long endTimestamp;
    private String iCalendarText;
    private String icsId;
    private boolean isFavorite;
    private Long jumpCalendarPageStartTimeStamp;
    private String name;
    private String note;
    private String rawRrule;
    private String recurrenceId;
    private String reminderDesc;
    private String repeatDescription;
    private String rruleDescription;
    private String startTime;
    private Long startTimestamp;
    private String timeDescription;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/ScheduleEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/ScheduleEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/ScheduleEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<ScheduleEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ScheduleEntity createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            AppEntity r101 = AppEntity.CREATOR.createFromParcel(r100);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.ScheduleEntity");
            return (ScheduleEntity) r101;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ScheduleEntity createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        public final int getVersion() {
            return 17;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ScheduleEntity[] newArray(int r100) {
            return new ScheduleEntity[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ScheduleEntity[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public ScheduleEntity(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "parcel");
        this(EntityExtKt.e(r110), r110.readLong(), r110.readLong(), EntityExtKt.e(r110), EntityExtKt.e(r110), EntityExtKt.e(r110));
        readExtensionFieldFromParcel$capabilitykitcommon_release(r110);
        int r100 = r110.readInt();
        this.address = r110.readString();
        this.attendees = r110.createTypedArrayList(ContactEntity.CREATOR);
        this.repeatDescription = r110.readString();
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r110, 15, r100);
    }

    public ScheduleEntity(String r110, long r111, long r112, String r113, String r114, String r115) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r113, "name");
        Intrinsics.checkNotNullParameter(r114, DyPayConstant.KEY_START_TIME);
        Intrinsics.checkNotNullParameter(r115, "endTime");
        super(r110, r111, r112, 401);
        this.name = r113;
        this.startTime = r114;
        this.endTime = r115;
        this.startTimestamp = StringsKt.toLongOrNull(r114);
        this.endTimestamp = StringsKt.toLongOrNull(this.endTime);
    }

    public final String getAddress() {
        return this.address;
    }

    public final boolean getAllDay() {
        return this.allDay;
    }

    public final List<ContactEntity> getAttendees() {
        return this.attendees;
    }

    public final CalendarTypeEnum getCalendarType() {
        return this.calendarType;
    }

    public final Boolean getCompleted() {
        return this.completed;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final Long getEndTimestamp() {
        return this.endTimestamp;
    }

    public final String getICalendarText() {
        return this.iCalendarText;
    }

    public final String getIcsId() {
        return this.icsId;
    }

    public final Long getJumpCalendarPageStartTimeStamp() {
        return this.jumpCalendarPageStartTimeStamp;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNote() {
        return this.note;
    }

    public final String getRawRrule() {
        return this.rawRrule;
    }

    public final String getRecurrenceId() {
        return this.recurrenceId;
    }

    public final String getReminderDesc() {
        return this.reminderDesc;
    }

    public final String getRepeatDescription() {
        return this.repeatDescription;
    }

    public final String getRruleDescription() {
        return this.rruleDescription;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final Long getStartTimestamp() {
        return this.startTimestamp;
    }

    public final String getTimeDescription() {
        return this.timeDescription;
    }

    public final boolean isFavorite() {
        return this.isFavorite;
    }

    public final void setAddress(String r100) {
        this.address = r100;
    }

    public final void setAllDay(boolean r100) {
        this.allDay = r100;
    }

    public final void setAttendees(List<ContactEntity> r100) {
        this.attendees = r100;
    }

    public final void setCalendarType(CalendarTypeEnum r100) {
        this.calendarType = r100;
    }

    public final void setCompleted(Boolean r100) {
        this.completed = r100;
    }

    public final void setEndTime(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.endTime = r100;
    }

    public final void setEndTimestamp(Long r100) {
        this.endTimestamp = r100;
    }

    public final void setFavorite(boolean r100) {
        this.isFavorite = r100;
    }

    public final void setICalendarText(String r100) {
        this.iCalendarText = r100;
    }

    public final void setIcsId(String r100) {
        this.icsId = r100;
    }

    public final void setJumpCalendarPageStartTimeStamp(Long r100) {
        this.jumpCalendarPageStartTimeStamp = r100;
    }

    public final void setName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.name = r100;
    }

    public final void setNote(String r100) {
        this.note = r100;
    }

    public final void setRawRrule(String r100) {
        this.rawRrule = r100;
    }

    public final void setRecurrenceId(String r100) {
        this.recurrenceId = r100;
    }

    public final void setReminderDesc(String r100) {
        this.reminderDesc = r100;
    }

    public final void setRepeatDescription(String r100) {
        this.repeatDescription = r100;
    }

    public final void setRruleDescription(String r100) {
        this.rruleDescription = r100;
    }

    public final void setStartTime(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.startTime = r100;
    }

    public final void setStartTimestamp(Long r100) {
        this.startTimestamp = r100;
    }

    public final void setTimeDescription(String r100) {
        this.timeDescription = r100;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeString(this.name);
        r100.writeString(this.startTime);
        r100.writeString(this.endTime);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeInt(15);
        r100.writeString(this.address);
        r100.writeTypedList(this.attendees);
        r100.writeString(this.repeatDescription);
        r100.writeValue(this.startTimestamp);
        r100.writeValue(this.endTimestamp);
        r100.writeValue(Boolean.valueOf(this.allDay));
        r100.writeValue(this.note);
        r100.writeValue(this.completed);
        r100.writeValue(Boolean.valueOf(this.isFavorite));
        r100.writeValue(this.reminderDesc);
        r100.writeValue(this.timeDescription);
        r100.writeValue(this.rruleDescription);
        r100.writeValue(this.icsId);
        r100.writeValue(this.recurrenceId);
        CalendarTypeEnum r102 = this.calendarType;
        if (r102 == null) goto L5;
        String r103 = r102.name();
    L6:
        r100.writeValue(r103);
        r100.writeValue(this.iCalendarText);
        r100.writeValue(this.jumpCalendarPageStartTimeStamp);
        r100.writeValue(this.rawRrule);
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r100, ClassLoader r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        Boolean r103 = null;
        CalendarTypeEnum r104 = null;
        r104 = null;
        switch(r102) {
            case 1: goto L28;
            case 2: goto L27;
            case 3: goto L26;
            case 4: goto L25;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L18;
            case 9: goto L17;
            case 10: goto L16;
            case 11: goto L15;
            case 12: goto L8;
            case 13: goto L7;
            case 14: goto L6;
            case 15: goto L5;
            default: goto L46;
        };
    L5:
        this.rawRrule = (String) r100.readValue(r101);
        return;
    L6:
        this.jumpCalendarPageStartTimeStamp = (Long) r100.readValue(r101);
        return;
    L7:
        this.iCalendarText = (String) r100.readValue(r101);
        return;
    L8:
        String r105 = (String) r100.readValue(r101);
        if (r105 == null) goto L14;
        CalendarTypeEnum.Companion.getClass();
        r104 = CalendarTypeEnum.valueOf(r105);     // Catch: IllegalArgumentException -> L13
    L13:
        Reflection.getOrCreateKotlinClass(CalendarTypeEnum.class).getSimpleName();
    L14:
        this.calendarType = r104;
        return;
    L15:
        this.recurrenceId = (String) r100.readValue(r101);
        return;
    L16:
        this.icsId = (String) r100.readValue(r101);
        return;
    L17:
        this.rruleDescription = (String) r100.readValue(r101);
        return;
    L18:
        this.timeDescription = (String) r100.readValue(r101);
        return;
    L19:
        this.reminderDesc = (String) r100.readValue(r101);
        return;
    L20:
        Object r106 = r100.readValue(r101);
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type kotlin.Boolean");
        this.isFavorite = ((Boolean) r106).booleanValue();
        return;
    L21:
        Object r107 = r100.readValue(r101);
        if ((r107 instanceof Boolean) == false) goto L24;
        r103 = (Boolean) r107;
    L24:
        this.completed = r103;
        return;
    L25:
        this.note = (String) r100.readValue(r101);
        return;
    L26:
        Object r108 = r100.readValue(r101);
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type kotlin.Boolean");
        this.allDay = ((Boolean) r108).booleanValue();
        return;
    L27:
        this.endTimestamp = (Long) r100.readValue(r101);
        return;
    L28:
        this.startTimestamp = (Long) r100.readValue(r101);
        return;
    }
}
