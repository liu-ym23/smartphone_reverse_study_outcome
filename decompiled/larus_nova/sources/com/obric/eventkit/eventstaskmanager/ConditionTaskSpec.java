package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 B2\u00020\u0001:\u0001CB\u009b\u0001\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010%\u0012\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000100\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000105\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010:¢\u0006\u0004\b?\u0010@Bc\b\u0016\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0004\u0012\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010%\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b?\u0010AJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\b\u0010\tJ\"\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0016R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010\u0017R$\u0010!\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0015\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010$R(\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010%8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001f\u0010,\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0019\u00101\u001a\u0004\u0018\u0001008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0019\u00106\u001a\u0004\u0018\u0001058\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u0019\u0010;\u001a\u0004\u0018\u00010:8\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>¨\u0006D"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/ConditionTaskSpec;", "Lcom/obric/eventkit/eventstaskmanager/EventTaskSpec;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "writeSubClassExtensionFieldToParcel$eventstaskkit_release", "(Landroid/os/Parcel;)V", "writeSubClassExtensionFieldToParcel", "Ljava/lang/ClassLoader;", "currentClassLoader", "version", "onReadSubClassExtensionField", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "taskMode", "Ljava/lang/Integer;", "getTaskMode", "()Ljava/lang/Integer;", "Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "taskKnowledge", "Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "getTaskKnowledge", "()Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", GXTemplateKey.GAIAX_TEMPLATE_ID, "getTemplateId", "taskStatus", "getTaskStatus", "enableStatus", "getEnableStatus", "setEnableStatus", "(Ljava/lang/Integer;)V", "", "ext", "Ljava/util/Map;", "getExt", "()Ljava/util/Map;", "", "Lcom/obric/eventkit/eventstaskmanager/ConditionTaskAction;", SlcCommonAction.KEY_ACTIONS, "Ljava/util/List;", "getActions", "()Ljava/util/List;", "Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;", "conditions", "Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;", "getConditions", "()Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;", "Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;", "periodicPolicy", "Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;", "getPeriodicPolicy", "()Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;", "Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;", "triggerControlPolicy", "Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;", "getTriggerControlPolicy", "()Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;Ljava/util/List;Lcom/obric/eventkit/eventstaskmanager/ConditionGroup;Lcom/obric/eventkit/eventstaskmanager/PeriodicPolicy;Lcom/obric/eventkit/eventstaskmanager/TriggerControlPolicy;)V", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;Landroid/os/Parcel;)V", "Companion", "b", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public final class ConditionTaskSpec extends EventTaskSpec {
    public static final Parcelable.Creator<ConditionTaskSpec> CREATOR = null;
    public static final b Companion = null;
    private static final int FIELD_VERSION = 0;
    private final List<ConditionTaskAction> actions;
    private final ConditionGroup conditions;
    private Integer enableStatus;
    private final Map<String, String> ext;
    private final String name;
    private final PeriodicPolicy periodicPolicy;
    private final TaskKnowledge taskKnowledge;
    private final Integer taskMode;
    private final Integer taskStatus;
    private final String templateId;
    private final TriggerControlPolicy triggerControlPolicy;

    public static final class a implements Parcelable.Creator<ConditionTaskSpec> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ConditionTaskSpec createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            EventTaskSpec r101 = EventTaskSpec.CREATOR.createFromParcel(r100);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.obric.eventkit.eventstaskmanager.ConditionTaskSpec");
            return (ConditionTaskSpec) r101;
        }

        @Override // android.os.Parcelable.Creator
        public final ConditionTaskSpec[] newArray(int r100) {
            return new ConditionTaskSpec[r100];
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

    public ConditionTaskSpec(String r110, Integer r111, TaskKnowledge r112, String r113, Integer r114, Integer r210, Map<String, String> r211, Parcel r212) {
        Intrinsics.checkNotNullParameter(r212, "parcel");
        if (r111 != null) goto L6;
    L8:
        Integer r100 = r111;
    L9:
        if (r114 != null) goto L12;
    L14:
        Integer r101 = r114;
    L15:
        if (r210 != null) goto L18;
    L20:
        Integer r102 = r210;
    L21:
        this(r110, r100, r112, r113, r101, r102, r211, r212.createTypedArrayList(ConditionTaskAction.CREATOR), (ConditionGroup) r212.readParcelable(ConditionGroup.class.getClassLoader()), (PeriodicPolicy) r212.readParcelable(PeriodicPolicy.class.getClassLoader()), (TriggerControlPolicy) r212.readParcelable(TriggerControlPolicy.class.getClassLoader()));
        readExtensionFieldFromParcel$eventstaskkit_release(r212);
        readSubClassExtensionFieldFromParcel$eventstaskkit_release(r212, 0);
        return;
    L18:
        if (r210.intValue() != (-1)) goto L20;
        r102 = null;
        goto L21
    L12:
        if (r114.intValue() != (-1)) goto L14;
        r101 = null;
        goto L15
    L6:
        if (r111.intValue() != (-1)) goto L8;
        r100 = null;
        goto L9
    }

    public ConditionTaskSpec(String r110, Integer r111, TaskKnowledge r112, String r113, Integer r114, Integer r115, Map<String, String> r116, List<ConditionTaskAction> r117, ConditionGroup r118, PeriodicPolicy r210, TriggerControlPolicy r211) {
        super(2, r110, r111, r112, r113, r114, r115, r116);
        this.name = r110;
        this.taskMode = r111;
        this.taskKnowledge = r112;
        this.templateId = r113;
        this.taskStatus = r114;
        this.enableStatus = r115;
        this.ext = r116;
        this.actions = r117;
        this.conditions = r118;
        this.periodicPolicy = r210;
        this.triggerControlPolicy = r211;
    }

    public /* synthetic */ ConditionTaskSpec(String r110, Integer r111, TaskKnowledge r112, String r113, Integer r114, Integer r115, Map r116, List r117, ConditionGroup r210, PeriodicPolicy r211, TriggerControlPolicy r212, int r213, DefaultConstructorMarker r214) {
        TriggerControlPolicy r100 = null;
        if ((r213 & 2) == 0) goto L5;
        Integer r101 = null;
    L7:
        if ((r213 & 4) == 0) goto L9;
        TaskKnowledge r102 = null;
    L11:
        if ((r213 & 8) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r213 & 16) == 0) goto L17;
        Integer r104 = null;
    L19:
        if ((r213 & 32) == 0) goto L21;
        Integer r105 = null;
    L23:
        if ((r213 & 64) == 0) goto L25;
        Map r106 = null;
    L27:
        if ((r213 & 128) == 0) goto L29;
        List r107 = null;
    L31:
        if ((r213 & 256) == 0) goto L33;
        ConditionGroup r108 = null;
    L35:
        if ((r213 & 512) == 0) goto L37;
        PeriodicPolicy r118 = null;
    L39:
        if ((r213 & 1024) != 0) goto L42;
        r100 = r212;
    L42:
        this(r110, r101, r102, r103, r104, r105, r106, r107, r108, r118, r100);
        return;
    L37:
        r118 = r211;
        goto L39
    L33:
        r108 = r210;
        goto L35
    L29:
        r107 = r117;
        goto L31
    L25:
        r106 = r116;
        goto L27
    L21:
        r105 = r115;
        goto L23
    L17:
        r104 = r114;
        goto L19
    L13:
        r103 = r113;
        goto L15
    L9:
        r102 = r112;
        goto L11
    L5:
        r101 = r111;
        goto L7
    }

    public final List<ConditionTaskAction> getActions() {
        return this.actions;
    }

    public final ConditionGroup getConditions() {
        return this.conditions;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskSpec
    public Integer getEnableStatus() {
        return this.enableStatus;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskSpec
    public Map<String, String> getExt() {
        return this.ext;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskSpec
    public String getName() {
        return this.name;
    }

    public final PeriodicPolicy getPeriodicPolicy() {
        return this.periodicPolicy;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskSpec
    public TaskKnowledge getTaskKnowledge() {
        return this.taskKnowledge;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskSpec
    public Integer getTaskMode() {
        return this.taskMode;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskSpec
    public Integer getTaskStatus() {
        return this.taskStatus;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskSpec
    public String getTemplateId() {
        return this.templateId;
    }

    public final TriggerControlPolicy getTriggerControlPolicy() {
        return this.triggerControlPolicy;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskSpec
    public void onReadSubClassExtensionField(Parcel r100, ClassLoader r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
    }

    public void setEnableStatus(Integer r100) {
        this.enableStatus = r100;
    }

    public final void writeSubClassExtensionFieldToParcel$eventstaskkit_release(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(0);
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskSpec, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        super.writeToParcel(r100, r101);
        r100.writeTypedList(this.actions);
        r100.writeParcelable(this.conditions, r101);
        r100.writeParcelable(this.periodicPolicy, r101);
        r100.writeParcelable(this.triggerControlPolicy, r101);
        writeExtensionFieldToParcel$eventstaskkit_release(r100);
        writeSubClassExtensionFieldToParcel$eventstaskkit_release(r100);
    }
}
