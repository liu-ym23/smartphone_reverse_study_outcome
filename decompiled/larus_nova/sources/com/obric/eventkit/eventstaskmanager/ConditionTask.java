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

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bE\b\u0087\b\u0018\u0000 i2\u00020\u0001:\u0001jB\u0085\u0001\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010-\u001a\u0004\u0018\u00010\u001a\u0012\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001d\u0012\f\u0010/\u001a\b\u0012\u0004\u0012\u00020 0\u001f\u0012\u0006\u00100\u001a\u00020\"\u0012\u0006\u00101\u001a\u00020$\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010&\u0012\b\b\u0002\u00103\u001a\u00020\u001a¢\u0006\u0004\bf\u0010gBY\b\u0016\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010-\u001a\u0004\u0018\u00010\u001a\u0012\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\bf\u0010hJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\b\u0010\tJ\"\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0018J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001dHÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001fHÆ\u0003J\t\u0010#\u001a\u00020\"HÆ\u0003J\t\u0010%\u001a\u00020$HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010&HÆ\u0003J\t\u0010(\u001a\u00020\u001aHÆ\u0003J\u009e\u0001\u00104\u001a\u00020\u00002\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u001a2\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001d2\u000e\b\u0002\u0010/\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\b\b\u0002\u00100\u001a\u00020\"2\b\b\u0002\u00101\u001a\u00020$2\n\b\u0002\u00102\u001a\u0004\u0018\u00010&2\b\b\u0002\u00103\u001a\u00020\u001aHÆ\u0001¢\u0006\u0004\b4\u00105J\t\u00106\u001a\u00020\u0014HÖ\u0001R$\u0010)\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b)\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010*\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b*\u00107\u001a\u0004\b<\u00109\"\u0004\b=\u0010;R$\u0010+\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b+\u0010>\u001a\u0004\b?\u0010\u0018\"\u0004\b@\u0010AR$\u0010,\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b,\u0010>\u001a\u0004\bB\u0010\u0018\"\u0004\bC\u0010AR$\u0010-\u001a\u0004\u0018\u00010\u001a8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b-\u0010D\u001a\u0004\bE\u0010\u001c\"\u0004\bF\u0010GR0\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001d8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b.\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR(\u0010/\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\"\u00100\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\"\u00101\u001a\u00020$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R$\u00102\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\"\u00103\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010e¨\u0006k"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/ConditionTask;", "Lcom/obric/eventkit/eventstaskmanager/EventTask;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "writeSubClassExtensionFieldToParcel$eventstaskkit_release", "(Landroid/os/Parcel;)V", "writeSubClassExtensionFieldToParcel", "Ljava/lang/ClassLoader;", "currentClassLoader", "version", "onReadSubClassExtensionField", "", "other", "", "equals", "hashCode", "", "component1", "component2", "component3", "()Ljava/lang/Integer;", "component4", "", "component5", "()Ljava/lang/Long;", "", "component6", "", "Lcom/obric/eventkit/eventstaskmanager/ConditionTaskAction;", "component7", "Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;", "component8", "Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;", "component9", "Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;", "component10", "component11", "id", "name", "taskStatus", "enableStatus", "createTime", "ext", SlcCommonAction.KEY_ACTIONS, "conditions", "periodicPolicy", "triggerControlPolicy", "nextTriggerTime", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;Ljava/util/List;Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;J)Lcom/obric/eventkit/eventstaskmanager/ConditionTask;", "toString", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getName", "setName", "Ljava/lang/Integer;", "getTaskStatus", "setTaskStatus", "(Ljava/lang/Integer;)V", "getEnableStatus", "setEnableStatus", "Ljava/lang/Long;", "getCreateTime", "setCreateTime", "(Ljava/lang/Long;)V", "Ljava/util/Map;", "getExt", "()Ljava/util/Map;", "setExt", "(Ljava/util/Map;)V", "Ljava/util/List;", "getActions", "()Ljava/util/List;", "setActions", "(Ljava/util/List;)V", "Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;", "getConditions", "()Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;", "setConditions", "(Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;)V", "Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;", "getPeriodicPolicy", "()Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;", "setPeriodicPolicy", "(Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;)V", "Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;", "getTriggerControlPolicy", "()Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;", "setTriggerControlPolicy", "(Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;)V", "J", "getNextTriggerTime", "()J", "setNextTriggerTime", "(J)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;Ljava/util/List;Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;J)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/util/Map;Landroid/os/Parcel;)V", "Companion", "b", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public final class ConditionTask extends EventTask {
    public static final Parcelable.Creator<ConditionTask> CREATOR = null;
    public static final b Companion = null;
    private static final int FIELD_VERSION = 0;
    private List<ConditionTaskAction> actions;
    private ConditionGroup conditions;
    private Long createTime;
    private Integer enableStatus;
    private Map<String, String> ext;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f396870id;
    private String name;
    private long nextTriggerTime;
    private PeriodicPolicy periodicPolicy;
    private Integer taskStatus;
    private TriggerControlPolicy triggerControlPolicy;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<ConditionTask> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ConditionTask createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            EventTask r101 = EventTask.CREATOR.createFromParcel(r100);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.obric.eventkit.eventstaskmanager.ConditionTask");
            return (ConditionTask) r101;
        }

        @Override // android.os.Parcelable.Creator
        public final ConditionTask[] newArray(int r100) {
            return new ConditionTask[r100];
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final class b {
        public b() {
        }
    }

    static {
        Companion = new b();
        CREATOR = new a();
    }

    public ConditionTask(String r110, String r111, Integer r112, Integer r113, Long r210, Map<String, String> r211, Parcel r212) {
        Intrinsics.checkNotNullParameter(r212, "parcel");
        if (r112 != null) goto L6;
    L8:
        Integer r100 = r112;
    L9:
        if (r113 != null) goto L12;
    L14:
        Integer r101 = r113;
    L15:
        if (r210 != null) goto L18;
    L20:
        Long r102 = r210;
    L21:
        List r103 = r212.createTypedArrayList(ConditionTaskAction.CREATOR);
        if (r103 != null) goto L24;
        r103 = CollectionsKt.emptyList();
    L24:
        List r104 = r103;
        Parcelable r105 = r212.readParcelable(ConditionGroup.class.getClassLoader());
        Intrinsics.checkNotNull(r105);
        ConditionGroup r106 = (ConditionGroup) r105;
        Parcelable r107 = r212.readParcelable(PeriodicPolicy.class.getClassLoader());
        Intrinsics.checkNotNull(r107);
        this(r110, r111, r100, r101, r102, r211, r104, r106, (PeriodicPolicy) r107, (TriggerControlPolicy) r212.readParcelable(TriggerControlPolicy.class.getClassLoader()), r212.readLong());
        readExtensionFieldFromParcel$eventstaskkit_release(r212);
        readSubClassExtensionFieldFromParcel$eventstaskkit_release(r212, 0);
        return;
    L18:
        if (r210.longValue() != (-1)) goto L20;
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

    public ConditionTask(String r110, String r111, Integer r112, Integer r113, Long r114, Map<String, String> r115, List<ConditionTaskAction> r116, ConditionGroup r210, PeriodicPolicy r211, TriggerControlPolicy r212, long r213) {
        Intrinsics.checkNotNullParameter(r116, SlcCommonAction.KEY_ACTIONS);
        Intrinsics.checkNotNullParameter(r210, "conditions");
        Intrinsics.checkNotNullParameter(r211, "periodicPolicy");
        super(2, r110, r111, r112, r113, r114, r115);
        this.f396870id = r110;
        this.name = r111;
        this.taskStatus = r112;
        this.enableStatus = r113;
        this.createTime = r114;
        this.ext = r115;
        this.actions = r116;
        this.conditions = r210;
        this.periodicPolicy = r211;
        this.triggerControlPolicy = r212;
        this.nextTriggerTime = r213;
    }

    public /* synthetic */ ConditionTask(String r110, String r111, Integer r112, Integer r210, Long r211, Map r212, List r213, ConditionGroup r214, PeriodicPolicy r215, TriggerControlPolicy r216, long r217, int r218, DefaultConstructorMarker r310) {
        if ((r218 & 32) == 0) goto L5;
        Map r100 = null;
    L7:
        if ((r218 & 512) == 0) goto L9;
        TriggerControlPolicy r113 = null;
    L11:
        if ((r218 & 1024) == 0) goto L13;
        long r114 = 0;
    L14:
        this(r110, r111, r112, r210, r211, r100, r213, r214, r215, r113, r114);
        return;
    L13:
        r114 = r217;
        goto L14
    L9:
        r113 = r216;
        goto L11
    L5:
        r100 = r212;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConditionTask copy$default(ConditionTask r110, String r111, String r112, Integer r113, Integer r114, Long r115, Map r210, List r211, ConditionGroup r212, PeriodicPolicy r213, TriggerControlPolicy r214, long r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        String r100 = r110.getId();
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r101 = r110.getName();
    L11:
        if ((r216 & 4) == 0) goto L13;
        Integer r102 = r110.getTaskStatus();
    L15:
        if ((r216 & 8) == 0) goto L17;
        Integer r103 = r110.getEnableStatus();
    L19:
        if ((r216 & 16) == 0) goto L21;
        Long r104 = r110.getCreateTime();
    L23:
        if ((r216 & 32) == 0) goto L25;
        Map r105 = r110.getExt();
    L27:
        if ((r216 & 64) == 0) goto L29;
        List r106 = r110.actions;
    L31:
        if ((r216 & 128) == 0) goto L33;
        ConditionGroup r107 = r110.conditions;
    L35:
        if ((r216 & 256) == 0) goto L37;
        PeriodicPolicy r116 = r110.periodicPolicy;
    L39:
        if ((r216 & 512) == 0) goto L41;
        TriggerControlPolicy r117 = r110.triggerControlPolicy;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        long r118 = r110.nextTriggerTime;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r116, r117, r118);
    L45:
        r118 = r215;
        goto L47
    L41:
        r117 = r214;
        goto L43
    L37:
        r116 = r213;
        goto L39
    L33:
        r107 = r212;
        goto L35
    L29:
        r106 = r211;
        goto L31
    L25:
        r105 = r210;
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

    public final TriggerControlPolicy component10() {
        return this.triggerControlPolicy;
    }

    public final long component11() {
        return this.nextTriggerTime;
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

    public final List<ConditionTaskAction> component7() {
        return this.actions;
    }

    public final ConditionGroup component8() {
        return this.conditions;
    }

    public final PeriodicPolicy component9() {
        return this.periodicPolicy;
    }

    public final ConditionTask copy(String r110, String r111, Integer r112, Integer r113, Long r114, Map<String, String> r210, List<ConditionTaskAction> r211, ConditionGroup r212, PeriodicPolicy r213, TriggerControlPolicy r214, long r215) {
        Intrinsics.checkNotNullParameter(r211, SlcCommonAction.KEY_ACTIONS);
        Intrinsics.checkNotNullParameter(r212, "conditions");
        Intrinsics.checkNotNullParameter(r213, "periodicPolicy");
        return new ConditionTask(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(ConditionTask.class, r101) == true) goto L13;
        return false;
    L13:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.obric.eventkit.eventstaskmanager.ConditionTask");
        return Intrinsics.areEqual(getId(), ((ConditionTask) r100).getId());
    L8:
        r101 = null;
        goto L10
    }

    public final List<ConditionTaskAction> getActions() {
        return this.actions;
    }

    public final ConditionGroup getConditions() {
        return this.conditions;
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
        return this.f396870id;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public String getName() {
        return this.name;
    }

    public final long getNextTriggerTime() {
        return this.nextTriggerTime;
    }

    public final PeriodicPolicy getPeriodicPolicy() {
        return this.periodicPolicy;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public Integer getTaskStatus() {
        return this.taskStatus;
    }

    public final TriggerControlPolicy getTriggerControlPolicy() {
        return this.triggerControlPolicy;
    }

    public int hashCode() {
        String r100 = getId();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public void onReadSubClassExtensionField(Parcel r100, ClassLoader r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
    }

    public final void setActions(List<ConditionTaskAction> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.actions = r100;
    }

    public final void setConditions(ConditionGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.conditions = r100;
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
        this.f396870id = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public final void setNextTriggerTime(long r100) {
        this.nextTriggerTime = r100;
    }

    public final void setPeriodicPolicy(PeriodicPolicy r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.periodicPolicy = r100;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask
    public void setTaskStatus(Integer r100) {
        this.taskStatus = r100;
    }

    public final void setTriggerControlPolicy(TriggerControlPolicy r100) {
        this.triggerControlPolicy = r100;
    }

    public String toString() {
        return "ConditionTask(id=" + getId() + ", name=" + getName() + ", taskStatus=" + getTaskStatus() + ", enableStatus=" + getEnableStatus() + ", createTime=" + getCreateTime() + ", ext=" + getExt() + ", actions=" + this.actions + ", conditions=" + this.conditions + ", periodicPolicy=" + this.periodicPolicy + ", triggerControlPolicy=" + this.triggerControlPolicy + ", nextTriggerTime=" + this.nextTriggerTime + ')';
    }

    public final void writeSubClassExtensionFieldToParcel$eventstaskkit_release(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(0);
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTask, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        super.writeToParcel(r100, r101);
        r100.writeTypedList(this.actions);
        r100.writeParcelable(this.conditions, r101);
        r100.writeParcelable(this.periodicPolicy, r101);
        r100.writeParcelable(this.triggerControlPolicy, r101);
        r100.writeLong(this.nextTriggerTime);
        writeExtensionFieldToParcel$eventstaskkit_release(r100);
        writeSubClassExtensionFieldToParcel$eventstaskkit_release(r100);
    }
}
