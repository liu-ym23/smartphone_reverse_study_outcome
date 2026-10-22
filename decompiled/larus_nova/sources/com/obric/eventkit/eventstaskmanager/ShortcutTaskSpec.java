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
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u001b\b\u0087\b\u0018\u0000 H2\u00020\u0001:\u0001IB\u008f\u0001\u0012\b\u0010!\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0018\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u001b\u0012\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e¢\u0006\u0004\bE\u0010FBc\b\u0016\u0012\b\u0010!\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010$\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0004\u0012\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0018\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\bE\u0010GJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\b\u0010\tJ\"\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0012J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0012J\u0017\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0018HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eHÆ\u0003J\u009a\u0001\u0010+\u001a\u00020\u00002\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00182\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u001b2\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eHÆ\u0001¢\u0006\u0004\b+\u0010,J\t\u0010-\u001a\u00020\u000fHÖ\u0001J\t\u0010.\u001a\u00020\u0004HÖ\u0001J\u0013\u00101\u001a\u00020\u001b2\b\u00100\u001a\u0004\u0018\u00010/HÖ\u0003R\u001c\u0010!\u001a\u0004\u0018\u00010\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u00102\u001a\u0004\b3\u00104R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u00105\u001a\u0004\b6\u0010\u0012R\u001c\u0010#\u001a\u0004\u0018\u00010\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u00107\u001a\u0004\b8\u00109R\u001c\u0010$\u001a\u0004\u0018\u00010\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u00102\u001a\u0004\b:\u00104R\u001c\u0010%\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u00105\u001a\u0004\b;\u0010\u0012R\u001c\u0010&\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u00105\u001a\u0004\b<\u0010\u0012R(\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00188\u0016X\u0096\u0004¢\u0006\f\n\u0004\b'\u0010=\u001a\u0004\b>\u0010?R\u0019\u0010(\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b(\u00102\u001a\u0004\b@\u00104R\u0019\u0010)\u001a\u0004\u0018\u00010\u001b8\u0006¢\u0006\f\n\u0004\b)\u0010A\u001a\u0004\b)\u0010\u001dR\u001f\u0010*\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e8\u0006¢\u0006\f\n\u0004\b*\u0010B\u001a\u0004\bC\u0010D¨\u0006J"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/ShortcutTaskSpec;", "Lcom/obric/eventkit/eventstaskmanager/EventTaskSpec;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "writeSubClassExtensionFieldToParcel$eventstaskkit_release", "(Landroid/os/Parcel;)V", "writeSubClassExtensionFieldToParcel", "Ljava/lang/ClassLoader;", "currentClassLoader", "version", "onReadSubClassExtensionField", "", "component1", "component2", "()Ljava/lang/Integer;", "Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "component3", "component4", "component5", "component6", "", "component7", "component8", "", "component9", "()Ljava/lang/Boolean;", "", "Lcom/obric/eventkit/eventstaskmanager/ShortcutTaskAction;", "component10", "name", "taskMode", "taskKnowledge", GXTemplateKey.GAIAX_TEMPLATE_ID, "taskStatus", "enableStatus", "ext", "shortInstruct", "isShortInstructEnable", SlcCommonAction.KEY_ACTIONS, "copy", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)Lcom/obric/eventkit/eventstaskmanager/ShortcutTaskSpec;", "toString", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "Ljava/lang/Integer;", "getTaskMode", "Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "getTaskKnowledge", "()Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;", "getTemplateId", "getTaskStatus", "getEnableStatus", "Ljava/util/Map;", "getExt", "()Ljava/util/Map;", "getShortInstruct", "Ljava/lang/Boolean;", "Ljava/util/List;", "getActions", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)V", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/obric/eventkit/eventstaskmanager/TaskKnowledge;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Map;Landroid/os/Parcel;)V", "Companion", "b", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1})
public final class ShortcutTaskSpec extends EventTaskSpec {
    public static final Parcelable.Creator<ShortcutTaskSpec> CREATOR = null;
    public static final b Companion = null;
    private static final int FIELD_VERSION = 0;
    private final List<ShortcutTaskAction> actions;
    private final Integer enableStatus;
    private final Map<String, String> ext;
    private final Boolean isShortInstructEnable;
    private final String name;
    private final String shortInstruct;
    private final TaskKnowledge taskKnowledge;
    private final Integer taskMode;
    private final Integer taskStatus;
    private final String templateId;

    public static final class a implements Parcelable.Creator<ShortcutTaskSpec> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ShortcutTaskSpec createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            EventTaskSpec r101 = EventTaskSpec.CREATOR.createFromParcel(r100);
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.obric.eventkit.eventstaskmanager.ShortcutTaskSpec");
            return (ShortcutTaskSpec) r101;
        }

        @Override // android.os.Parcelable.Creator
        public final ShortcutTaskSpec[] newArray(int r100) {
            return new ShortcutTaskSpec[r100];
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

    public ShortcutTaskSpec(String r110, Integer r111, TaskKnowledge r112, String r113, Integer r114, Integer r115, Map<String, String> r116, String r117, Boolean r118, List<ShortcutTaskAction> r210) {
        super(3, r110, r111, r112, r113, r114, r115, r116);
        this.name = r110;
        this.taskMode = r111;
        this.taskKnowledge = r112;
        this.templateId = r113;
        this.taskStatus = r114;
        this.enableStatus = r115;
        this.ext = r116;
        this.shortInstruct = r117;
        this.isShortInstructEnable = r118;
        this.actions = r210;
    }

    public /* synthetic */ ShortcutTaskSpec(String r110, Integer r111, TaskKnowledge r112, String r113, Integer r114, Integer r115, Map r116, String r117, Boolean r118, List r210, int r211, DefaultConstructorMarker r212) {
        List r100 = null;
        if ((r211 & 2) == 0) goto L5;
        Integer r101 = null;
    L7:
        if ((r211 & 4) == 0) goto L9;
        TaskKnowledge r102 = null;
    L11:
        if ((r211 & 8) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r211 & 16) == 0) goto L17;
        Integer r104 = null;
    L19:
        if ((r211 & 32) == 0) goto L21;
        Integer r105 = null;
    L23:
        if ((r211 & 64) == 0) goto L25;
        Map r106 = null;
    L27:
        if ((r211 & 128) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r211 & 256) == 0) goto L33;
        Boolean r108 = null;
    L35:
        if ((r211 & 512) != 0) goto L38;
        r100 = r210;
    L38:
        this(r110, r101, r102, r103, r104, r105, r106, r107, r108, r100);
        return;
    L33:
        r108 = r118;
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

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShortcutTaskSpec copy$default(ShortcutTaskSpec r110, String r111, Integer r112, TaskKnowledge r113, String r114, Integer r115, Integer r116, Map r117, String r118, Boolean r210, List r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.getName();
    L7:
        if ((r212 & 2) == 0) goto L9;
        Integer r101 = r110.getTaskMode();
    L11:
        if ((r212 & 4) == 0) goto L13;
        TaskKnowledge r102 = r110.getTaskKnowledge();
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.getTemplateId();
    L19:
        if ((r212 & 16) == 0) goto L21;
        Integer r104 = r110.getTaskStatus();
    L23:
        if ((r212 & 32) == 0) goto L25;
        Integer r105 = r110.getEnableStatus();
    L27:
        if ((r212 & 64) == 0) goto L29;
        Map r106 = r110.getExt();
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r107 = r110.shortInstruct;
    L35:
        if ((r212 & 256) == 0) goto L37;
        Boolean r119 = r110.isShortInstructEnable;
    L39:
        if ((r212 & 512) == 0) goto L41;
        List r108 = r110.actions;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
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
        return getName();
    }

    public final List<ShortcutTaskAction> component10() {
        return this.actions;
    }

    public final Integer component2() {
        return getTaskMode();
    }

    public final TaskKnowledge component3() {
        return getTaskKnowledge();
    }

    public final String component4() {
        return getTemplateId();
    }

    public final Integer component5() {
        return getTaskStatus();
    }

    public final Integer component6() {
        return getEnableStatus();
    }

    public final Map<String, String> component7() {
        return getExt();
    }

    public final String component8() {
        return this.shortInstruct;
    }

    public final Boolean component9() {
        return this.isShortInstructEnable;
    }

    public final ShortcutTaskSpec copy(String r110, Integer r111, TaskKnowledge r112, String r113, Integer r114, Integer r115, Map<String, String> r116, String r210, Boolean r211, List<ShortcutTaskAction> r212) {
        return new ShortcutTaskSpec(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ShortcutTaskSpec) == true) goto L8;
        return false;
    L8:
        ShortcutTaskSpec r101 = (ShortcutTaskSpec) r100;
        if (Intrinsics.areEqual(getName(), r101.getName()) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(getTaskMode(), r101.getTaskMode()) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(getTaskKnowledge(), r101.getTaskKnowledge()) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(getTemplateId(), r101.getTemplateId()) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(getTaskStatus(), r101.getTaskStatus()) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(getEnableStatus(), r101.getEnableStatus()) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(getExt(), r101.getExt()) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.shortInstruct, r101.shortInstruct) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.isShortInstructEnable, r101.isShortInstructEnable) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.actions, r101.actions) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final List<ShortcutTaskAction> getActions() {
        return this.actions;
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

    public final String getShortInstruct() {
        return this.shortInstruct;
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

    public int hashCode() {
        int r100 = 0;
        if (getName() != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (getTaskMode() != null) goto L9;
        int r103 = 0;
    L10:
        int r104 = (r102 + r103) * 31;
        if (getTaskKnowledge() != null) goto L13;
        int r105 = 0;
    L14:
        int r106 = (r104 + r105) * 31;
        if (getTemplateId() != null) goto L17;
        int r107 = 0;
    L18:
        int r108 = (r106 + r107) * 31;
        if (getTaskStatus() != null) goto L21;
        int r109 = 0;
    L22:
        int r110 = (r108 + r109) * 31;
        if (getEnableStatus() != null) goto L25;
        int r111 = 0;
    L26:
        int r112 = (r110 + r111) * 31;
        if (getExt() != null) goto L29;
        int r113 = 0;
    L30:
        int r114 = (r112 + r113) * 31;
        String r115 = this.shortInstruct;
        if (r115 != null) goto L33;
        int r116 = 0;
    L34:
        int r117 = (r114 + r116) * 31;
        Boolean r118 = this.isShortInstructEnable;
        if (r118 != null) goto L37;
        int r119 = 0;
    L38:
        int r120 = (r117 + r119) * 31;
        List<ShortcutTaskAction> r121 = this.actions;
        if (r121 == null) goto L43;
        r100 = r121.hashCode();
    L43:
        return r120 + r100;
    L37:
        r119 = r118.hashCode();
        goto L38
    L33:
        r116 = r115.hashCode();
        goto L34
    L29:
        r113 = getExt().hashCode();
        goto L30
    L25:
        r111 = getEnableStatus().hashCode();
        goto L26
    L21:
        r109 = getTaskStatus().hashCode();
        goto L22
    L17:
        r107 = getTemplateId().hashCode();
        goto L18
    L13:
        r105 = getTaskKnowledge().hashCode();
        goto L14
    L9:
        r103 = getTaskMode().hashCode();
        goto L10
    L5:
        r101 = getName().hashCode();
        goto L6
    }

    public final Boolean isShortInstructEnable() {
        return this.isShortInstructEnable;
    }

    @Override // com.obric.eventkit.eventstaskmanager.EventTaskSpec
    public void onReadSubClassExtensionField(Parcel r100, ClassLoader r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
    }

    public String toString() {
        return "ShortcutTaskSpec(name=" + getName() + ", taskMode=" + getTaskMode() + ", taskKnowledge=" + getTaskKnowledge() + ", templateId=" + getTemplateId() + ", taskStatus=" + getTaskStatus() + ", enableStatus=" + getEnableStatus() + ", ext=" + getExt() + ", shortInstruct=" + this.shortInstruct + ", isShortInstructEnable=" + this.isShortInstructEnable + ", actions=" + this.actions + ')';
    }

    public final void writeSubClassExtensionFieldToParcel$eventstaskkit_release(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.Parcel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v7 */
    @Override // com.obric.eventkit.eventstaskmanager.EventTaskSpec, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        super.writeToParcel(r100, r101);
        r100.writeString(this.shortInstruct);
        Boolean r102 = this.isShortInstructEnable;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r102 == null) goto L5;
        ?? r103 = r102.booleanValue();
    L6:
        r100.writeInt(r103);
        r100.writeTypedList(this.actions);
        writeExtensionFieldToParcel$eventstaskkit_release(r100);
        writeSubClassExtensionFieldToParcel$eventstaskkit_release(r100);
        return;
    L5:
        r103 = -1;
        goto L6
    }

    public ShortcutTaskSpec(String r110, Integer r111, TaskKnowledge r112, String r113, Integer r114, Integer r115, Map<String, String> r210, Parcel r211) {
        Intrinsics.checkNotNullParameter(r211, "parcel");
        Boolean r100 = null;
        if (r111 != null) goto L6;
    L8:
        Integer r101 = r111;
    L9:
        if (r114 != null) goto L12;
    L14:
        Integer r102 = r114;
    L15:
        if (r115 != null) goto L18;
    L20:
        Integer r103 = r115;
    L21:
        String r104 = r211.readString();
        Intrinsics.checkNotNullParameter(r211, "<this>");
        int r105 = r211.readInt();
        if (r105 == (-1)) goto L26;
        if (r105 == 0) goto L25;
        r100 = Boolean.TRUE;
        goto L26
    L25:
        r100 = Boolean.FALSE;
    L26:
        this(r110, r101, r112, r113, r102, r103, r210, r104, r100, r211.createTypedArrayList(ShortcutTaskAction.CREATOR));
        readExtensionFieldFromParcel$eventstaskkit_release(r211);
        readSubClassExtensionFieldFromParcel$eventstaskkit_release(r211, 0);
        return;
    L18:
        if (r115.intValue() != (-1)) goto L20;
        r103 = null;
        goto L21
    L12:
        if (r114.intValue() != (-1)) goto L14;
        r102 = null;
        goto L15
    L6:
        if (r111.intValue() != (-1)) goto L8;
        r101 = null;
        goto L9
    }
}
