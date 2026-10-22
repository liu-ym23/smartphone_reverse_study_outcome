package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b.\b\u0087\b\u0018\u0000 N2\u00020\u0001:\u0001OBu\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010(\u001a\u0004\u0018\u00010\u001a\u0012\u0016\b\u0002\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001d\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010+\u001a\u00020\u0011\u0012\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\"0!¢\u0006\u0004\bK\u0010LBY\b\u0016\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010(\u001a\u0004\u0018\u00010\u001a\u0012\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\bK\u0010MJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\b\u0010\tJ\"\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0018J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001dHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\t\u0010 \u001a\u00020\u0011HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!HÆ\u0003J\u008a\u0001\u0010-\u001a\u00020\u00002\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u001a2\u0016\b\u0002\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001d2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010+\u001a\u00020\u00112\u000e\b\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00020\"0!HÆ\u0001¢\u0006\u0004\b-\u0010.J\t\u0010/\u001a\u00020\u0014HÖ\u0001R$\u0010$\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b$\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u0010%\u001a\u0004\u0018\u00010\u00148\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u00100\u001a\u0004\b5\u00102R$\u0010&\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b&\u00106\u001a\u0004\b7\u0010\u0018\"\u0004\b8\u00109R$\u0010'\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b'\u00106\u001a\u0004\b:\u0010\u0018\"\u0004\b;\u00109R$\u0010(\u001a\u0004\u0018\u00010\u001a8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b(\u0010<\u001a\u0004\b=\u0010\u001c\"\u0004\b>\u0010?R0\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001d8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b)\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0019\u0010*\u001a\u0004\u0018\u00010\u00148\u0006¢\u0006\f\n\u0004\b*\u00100\u001a\u0004\bE\u00102R\u0017\u0010+\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b+\u0010F\u001a\u0004\b+\u0010GR\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0006¢\u0006\f\n\u0004\b,\u0010H\u001a\u0004\bI\u0010J¨\u0006P"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/ShortcutTask;", "Lcom/obric/eventkit/eventstaskmanager/EventTask;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "writeSubClassExtensionFieldToParcel$eventstaskkit_release", "(Landroid/os/Parcel;)V", "writeSubClassExtensionFieldToParcel", "Ljava/lang/ClassLoader;", "currentClassLoader", "version", "onReadSubClassExtensionField", "", "other", "", "equals", "hashCode", "", "component1", "component2", "component3", "()Ljava/lang/Integer;", "component4", "", "component5", "()Ljava/lang/Long;", "", "component6", "component7", "component8", "", "Lcom/obric/eventkit/eventstaskmanager/ShortcutTaskAction;", "component9", "id", "name", "taskStatus", "enableStatus", "createTime", "ext", "shortInstruct", "isShortInstructEnable", SlcCommonAction.KEY_ACTIONS, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;Ljava/lang/String;ZLjava/util/List;)Lcom/obric/eventkit/eventstaskmanager/ShortcutTask;", "toString", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getName", "Ljava/lang/Integer;", "getTaskStatus", "setTaskStatus", "(Ljava/lang/Integer;)V", "getEnableStatus", "setEnableStatus", "Ljava/lang/Long;", "getCreateTime", "setCreateTime", "(Ljava/lang/Long;)V", "Ljava/util/Map;", "getExt", "()Ljava/util/Map;", "setExt", "(Ljava/util/Map;)V", "getShortInstruct", "Z", "()Z", "Ljava/util/List;", "getActions", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;Ljava/lang/String;ZLjava/util/List;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;Landroid/os/Parcel;)V", "Companion", "b", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public final class ShortcutTask extends EventTask {
    public static final Parcelable.Creator<ShortcutTask> CREATOR = null;
    public static final b Companion = null;
    private static final int FIELD_VERSION = 0;
    private final List<ShortcutTaskAction> actions;
    private Long createTime;
    private Integer enableStatus;
    private Map<String, String> ext;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f396877id;
    private final boolean isShortInstructEnable;
    private final String name;
    private final String shortInstruct;
    private Integer taskStatus;

    public static final class a implements Parcelable.Creator<ShortcutTask> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ShortcutTask createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            EventTask r101 = EventTask.CREATOR.createFromParcel(r100);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.obric.eventkit.eventstaskmanager.ShortcutTask");
            return (ShortcutTask) r101;
        }

        @Override // android.os.Parcelable.Creator
        public final ShortcutTask[] newArray(int r100) {
            return new ShortcutTask[r100];
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        Companion = new b();
        CREATOR = new a();
    }

    public ShortcutTask(String r110, String r111, Integer r112, Integer r113, Long r114, Map<String, String> r115, Parcel r210) {
        Intrinsics.checkNotNullParameter(r210, "parcel");
        if (r112 != null) goto L6;
    L8:
        Integer r100 = r112;
    L9:
        if (r113 != null) goto L12;
    L14:
        Integer r101 = r113;
    L15:
        if (r114 != null) goto L18;
    L20:
        Long r102 = r114;
    L21:
        String r103 = r210.readString();
        if (r210.readInt() == 0) goto L24;
        boolean r104 = true;
    L25:
        List r105 = r210.createTypedArrayList(ShortcutTaskAction.CREATOR);
        if (r105 != null) goto L28;
        r105 = CollectionsKt.emptyList();
    L28:
        this(r110, r111, r100, r101, r102, r115, r103, r104, r105);
        readExtensionFieldFromParcel$eventstaskkit_release(r210);
        readSubClassExtensionFieldFromParcel$eventstaskkit_release(r210, 0);
        return;
    L24:
        r104 = false;
        goto L25
    L18:
        if (r114.longValue() != (-1)) goto L20;
        r102 = null;
        goto L21
    L12:
        if (r113.intValue() != (-1)) goto L14;
        r101 = null;
        goto L15
    L6:
        if (r112.intValue() != (-1)) goto L8;
        r100 = null;
        goto L9
    }

    public ShortcutTask(String r110, String r111, Integer r112, Integer r113, Long r114, Map<String, String> r115, String r116, boolean r117, List<ShortcutTaskAction> r118) {
        Intrinsics.checkNotNullParameter(r118, SlcCommonAction.KEY_ACTIONS);
        super(3, r110, r111, r112, r113, r114, r115);
        this.f396877id = r110;
        this.name = r111;
        this.taskStatus = r112;
        this.enableStatus = r113;
        this.createTime = r114;
        this.ext = r115;
        this.shortInstruct = r116;
        this.isShortInstructEnable = r117;
        this.actions = r118;
    }

    public /* synthetic */ ShortcutTask(String r110, String r111, Integer r112, Integer r113, Long r114, Map r115, String r210, boolean r211, List r212, int r213, DefaultConstructorMarker r214) {
        if ((r213 & 32) == 0) goto L5;
        Map r100 = null;
    L7:
        if ((r213 & 64) == 0) goto L9;
        String r116 = null;
    L11:
        if ((r213 & 128) == 0) goto L13;
        boolean r117 = false;
    L14:
        this(r110, r111, r112, r113, r114, r100, r116, r117, r212);
        return;
    L13:
        r117 = r211;
        goto L14
    L9:
        r116 = r210;
        goto L11
    L5:
        r100 = r115;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShortcutTask copy$default(ShortcutTask r110, String r111, String r112, Integer r113, Integer r114, Long r115, Map r116, String r117, boolean r118, List r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.getId();
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.getName();
    L11:
        if ((r210 & 4) == 0) goto L13;
        Integer r102 = r110.getTaskStatus();
    L15:
        if ((r210 & 8) == 0) goto L17;
        Integer r103 = r110.getEnableStatus();
    L19:
        if ((r210 & 16) == 0) goto L21;
        Long r104 = r110.getCreateTime();
    L23:
        if ((r210 & 32) == 0) goto L25;
        Map r105 = r110.getExt();
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r106 = r110.shortInstruct;
    L31:
        if ((r210 & 128) == 0) goto L33;
        boolean r107 = r110.isShortInstructEnable;
    L35:
        if ((r210 & 256) == 0) goto L37;
        List r108 = r110.actions;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return getId();
    }

    public final String component2() {
        return getName();
    }

    public final Integer component3() {
        return getTaskStatus();
    }

    public final Integer component4() {
        return getEnableStatus();
    }

    public final Long component5() {
        return getCreateTime();
    }

    public final Map<String, String> component6() {
        return getExt();
    }

    public final String component7() {
        return this.shortInstruct;
    }

    public final boolean component8() {
        return this.isShortInstructEnable;
    }

    public final List<ShortcutTaskAction> component9() {
        return this.actions;
    }

    public final ShortcutTask copy(String r110, String r111, Integer r112, Integer r113, Long r114, Map<String, String> r115, String r116, boolean r117, List<ShortcutTaskAction> r210) {
        Intrinsics.checkNotNullParameter(r210, SlcCommonAction.KEY_ACTIONS);
        return new ShortcutTask(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(ShortcutTask.class, r101) == true) goto L13;
        return false;
    L13:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.obric.eventkit.eventstaskmanager.ShortcutTask");
        return Intrinsics.areEqual(getId(), ((ShortcutTask) r100).getId());
    L8:
        r101 = null;
        goto L10
    }

    public final List<ShortcutTaskAction> getActions() {
        return this.actions;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public Long getCreateTime() {
        return this.createTime;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public Integer getEnableStatus() {
        return this.enableStatus;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public Map<String, String> getExt() {
        return this.ext;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public String getId() {
        return this.f396877id;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public String getName() {
        return this.name;
    }

    public final String getShortInstruct() {
        return this.shortInstruct;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public Integer getTaskStatus() {
        return this.taskStatus;
    }

    public int hashCode() {
        String r100 = getId();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final boolean isShortInstructEnable() {
        return this.isShortInstructEnable;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public void onReadSubClassExtensionField(Parcel r100, ClassLoader r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public void setCreateTime(Long r100) {
        this.createTime = r100;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public void setEnableStatus(Integer r100) {
        this.enableStatus = r100;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public void setExt(Map<String, String> r100) {
        this.ext = r100;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public void setId(String r100) {
        this.f396877id = r100;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public void setTaskStatus(Integer r100) {
        this.taskStatus = r100;
    }

    public String toString() {
        return "ShortcutTask(id=" + getId() + ", name=" + getName() + ", taskStatus=" + getTaskStatus() + ", enableStatus=" + getEnableStatus() + ", createTime=" + getCreateTime() + ", ext=" + getExt() + ", shortInstruct=" + this.shortInstruct + ", isShortInstructEnable=" + this.isShortInstructEnable + ", actions=" + this.actions + ')';
    }

    public final void writeSubClassExtensionFieldToParcel$eventstaskkit_release(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(0);
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        super.writeToParcel(r100, r101);
        r100.writeString(this.shortInstruct);
        r100.writeInt(this.isShortInstructEnable ? 1 : 0);
        r100.writeTypedList(this.actions);
        writeExtensionFieldToParcel$eventstaskkit_release(r100);
        writeSubClassExtensionFieldToParcel$eventstaskkit_release(r100);
    }
}
