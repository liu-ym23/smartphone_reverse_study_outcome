package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.google.gson.Gson;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 =2\u00020\u0001:\u0001=B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B/\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010\fJ\u001a\u00103\u001a\u0004\u0018\u00010\u00062\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"H\u0002J\u0019\u00104\u001a\u0004\u0018\u00010\u00062\b\u0010*\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0002\u00105J\"\u00106\u001a\u0002072\u0006\u0010\u0002\u001a\u00020\u00032\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020#H\u0016J\u0018\u0010;\u001a\u0002072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010<\u001a\u00020#H\u0016R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R4\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010*\u001a\u0004\u0018\u00010#2\b\u0010!\u001a\u0004\u0018\u00010#@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0010\u00100\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0015\"\u0004\b2\u0010\u0017¨\u0006>"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "name", DyPayConstant.KEY_START_TIME, "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;)V", "closeInHoliday", "", "getCloseInHoliday", "()Z", "setCloseInHoliday", "(Z)V", "date", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "isEnabled", "setEnabled", "isRinging", "()Ljava/lang/Boolean;", "setRinging", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getName", "setName", "value", "", "", "repeatDayOfWeek", "getRepeatDayOfWeek", "()Ljava/util/List;", "setRepeatDayOfWeek", "(Ljava/util/List;)V", "repeatDayOfWeekDesc", "repeatType", "getRepeatType", "()Ljava/lang/Integer;", "setRepeatType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "repeatTypeDesc", "getStartTime", "setStartTime", "generateRepeatDesc", "generateRepeatTypeDesc", "(Ljava/lang/Integer;)Ljava/lang/String;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AlarmEntity extends AppEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 4;
    private static final int RELATED_VERSION = 0;
    private boolean closeInHoliday;
    private String date;
    private boolean isEnabled;
    private Boolean isRinging;
    private String name;
    private List<Integer> repeatDayOfWeek;
    private String repeatDayOfWeekDesc;
    private Integer repeatType;
    private String repeatTypeDesc;
    private String startTime;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AlarmEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<AlarmEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlarmEntity createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            AppEntity r101 = AppEntity.CREATOR.createFromParcel(r100);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.AlarmEntity");
            return (AlarmEntity) r101;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AlarmEntity createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        public final int getVersion() {
            return 4;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AlarmEntity[] newArray(int r100) {
            return new AlarmEntity[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AlarmEntity[] newArray(int r100) {
            return newArray(r100);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", AbsMethodDelegate.TAG_INVOKE, "(I)Ljava/lang/CharSequence;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class a extends Lambda implements Function1<Integer, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map<Integer, String> f396204a;

        public a(Map<Integer, String> r100) {
            this.f396204a = r100;
            super(1);
        }

        public final CharSequence a(int r100) {
            String r101 = this.f396204a.get(Integer.valueOf(r100));
            if (r101 != null) goto L7;
            return "";
        L7:
            return r101;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(Integer r100) {
            return a(r100.intValue());
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public AlarmEntity(Parcel r110) {
        Intrinsics.checkNotNullParameter(r110, "parcel");
        this(EntityExtKt.e(r110), r110.readLong(), r110.readLong(), EntityExtKt.e(r110), EntityExtKt.e(r110));
        readExtensionFieldFromParcel$capabilitykitcommon_release(r110);
        int r100 = r110.readInt();
        this.isEnabled = EntityExtKt.d(r110);
        ArrayList r101 = new ArrayList();
        r110.readList(r101, Integer.TYPE.getClassLoader());
        setRepeatDayOfWeek(r101);
        this.closeInHoliday = EntityExtKt.d(r110);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r110, 4, r100);
    }

    public AlarmEntity(String r100, long r110, long r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r112, "name");
        Intrinsics.checkNotNullParameter(r113, DyPayConstant.KEY_START_TIME);
        super(r100, r110, r111, 701);
        this.name = r112;
        this.startTime = r113;
    }

    public /* synthetic */ AlarmEntity(String r110, long r111, long r112, String r113, String r114, int r115, DefaultConstructorMarker r116) {
        if ((r115 & 16) == 0) goto L5;
        String r100 = "";
    L6:
        this(r110, r111, r112, r113, r100);
        return;
    L5:
        r100 = r114;
        goto L6
    }

    private final String generateRepeatDesc(List<Integer> r110) {
        if (r110 != null) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == false) goto L12;
        return null;
    L12:
        Map r101 = MapsKt.mapOf(new Pair[]{TuplesKt.to(1, "周一"), TuplesKt.to(2, "周二"), TuplesKt.to(3, "周三"), TuplesKt.to(4, "周四"), TuplesKt.to(5, "周五"), TuplesKt.to(6, "周六"), TuplesKt.to(7, "周日")});
        if (r110.containsAll(CollectionsKt.toList(new IntRange(1, 7))) == false) goto L16;
        return "每天";
    L16:
        return "每" + CollectionsKt.joinToString$default(CollectionsKt.sorted(r110), "", null, null, 0, null, new a(r101), 30, null);
    L5:
        if (r110.isEmpty() == true) goto L8;
        r100 = false;
        goto L9
    }

    private final String generateRepeatTypeDesc(Integer r100) {
        if (r100 == null) goto L16;
        int r101 = r100.intValue();
        if (r101 != 0) goto L6;
        return "不重复";
    L6:
        if (r101 != 1) goto L8;
        return "每天";
    L8:
        if (r101 != 2) goto L10;
        return "法定工作日";
    L10:
        if (r101 != 3) goto L16;
        return "法定节假日及周末";
    L16:
        return null;
    }

    public final boolean getCloseInHoliday() {
        return this.closeInHoliday;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getName() {
        return this.name;
    }

    public final List<Integer> getRepeatDayOfWeek() {
        return this.repeatDayOfWeek;
    }

    public final Integer getRepeatType() {
        return this.repeatType;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final Boolean isRinging() {
        return this.isRinging;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r100, ClassLoader r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        if (r102 != 1) goto L5;
        this.date = (String) r100.readValue(r101);
        return;
    L5:
        if (r102 != 2) goto L7;
        this.isRinging = (Boolean) r100.readValue(r101);
        return;
    L7:
        if (r102 != 3) goto L9;
        setRepeatType((Integer) r100.readValue(r101));
        return;
    L9:
        if (r102 != 4) goto L19;
        this.repeatTypeDesc = (String) r100.readValue(r101);
        return;
    }

    public final void setCloseInHoliday(boolean r100) {
        this.closeInHoliday = r100;
    }

    public final void setDate(String r100) {
        this.date = r100;
    }

    public final void setEnabled(boolean r100) {
        this.isEnabled = r100;
    }

    public final void setName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.name = r100;
    }

    public final void setRepeatDayOfWeek(List<Integer> r100) {
        this.repeatDayOfWeekDesc = generateRepeatDesc(r100);
        this.repeatDayOfWeek = r100;
    }

    public final void setRepeatType(Integer r100) {
        this.repeatTypeDesc = generateRepeatTypeDesc(r100);
        this.repeatType = r100;
    }

    public final void setRinging(Boolean r100) {
        this.isRinging = r100;
    }

    public final void setStartTime(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.startTime = r100;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeString(this.name);
        r100.writeString(this.startTime);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r100);
        r100.writeInt(4);
        boolean r102 = this.isEnabled;
        Gson r103 = EntityExtKt.f396198a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.writeInt(r102 ? 1 : 0);
        r100.writeList(this.repeatDayOfWeek);
        boolean r104 = this.closeInHoliday;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.writeInt(r104 ? 1 : 0);
        r100.writeValue(this.date);
        r100.writeValue(this.isRinging);
        r100.writeValue(this.repeatType);
        r100.writeValue(this.repeatTypeDesc);
    }
}
