package com.larus.bmhome.chat.model.api;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.actionbar.model.w1;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BQ\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0019\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010&\u001a\u0004\u0018\u00010\fHÆ\u0003JX\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\bHÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R.\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u0016R \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006."}, d2 = {"Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuDataV2;", "", "menuConfV2", "Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuConfigV2;", "useMenuConfV2", "", "switchMemory", "", "", "Lcom/larus/bmhome/chat/model/api/DefaultReplySwitchMemory;", "newActiveSwitchContainer", "reasoningEffortSectionConf", "Lcom/larus/bmhome/actionbar/model/ReasoningEffortSectionConf;", "<init>", "(Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuConfigV2;Ljava/lang/Boolean;Ljava/util/Map;Ljava/lang/Boolean;Lcom/larus/bmhome/actionbar/model/ReasoningEffortSectionConf;)V", "getMenuConfV2", "()Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuConfigV2;", "setMenuConfV2", "(Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuConfigV2;)V", "getUseMenuConfV2", "()Ljava/lang/Boolean;", "setUseMenuConfV2", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getSwitchMemory", "()Ljava/util/Map;", "setSwitchMemory", "(Ljava/util/Map;)V", "getNewActiveSwitchContainer", "setNewActiveSwitchContainer", "getReasoningEffortSectionConf", "()Lcom/larus/bmhome/actionbar/model/ReasoningEffortSectionConf;", "setReasoningEffortSectionConf", "(Lcom/larus/bmhome/actionbar/model/ReasoningEffortSectionConf;)V", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuConfigV2;Ljava/lang/Boolean;Ljava/util/Map;Ljava/lang/Boolean;Lcom/larus/bmhome/actionbar/model/ReasoningEffortSectionConf;)Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuDataV2;", "equals", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultReplyMenuDataV2 {

    @SerializedName("menu_conf_v2")
    private DefaultReplyMenuConfigV2 menuConfV2;

    @SerializedName("new_active_switch_container")
    private Boolean newActiveSwitchContainer;

    @SerializedName("reasoning_effort_section_conf")
    private w1 reasoningEffortSectionConf;

    @SerializedName("switch_memory")
    private Map<String, DefaultReplySwitchMemory> switchMemory;

    @SerializedName("use_menu_conf_v2")
    private Boolean useMenuConfV2;

    public DefaultReplyMenuDataV2() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DefaultReplyMenuDataV2 copy$default(DefaultReplyMenuDataV2 r100, DefaultReplyMenuConfigV2 r101, Boolean r102, Map r103, Boolean r104, w1 r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.menuConfV2;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.useMenuConfV2;
    L8:
        Boolean r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.switchMemory;
    L11:
        Map r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.newActiveSwitchContainer;
    L14:
        Boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.reasoningEffortSectionConf;
    L17:
        DefaultReplyMenuConfigV2 r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final DefaultReplyMenuConfigV2 component1() {
        return this.menuConfV2;
    }

    public final Boolean component2() {
        return this.useMenuConfV2;
    }

    public final Map<String, DefaultReplySwitchMemory> component3() {
        return this.switchMemory;
    }

    public final Boolean component4() {
        return this.newActiveSwitchContainer;
    }

    public final w1 component5() {
        return this.reasoningEffortSectionConf;
    }

    public final DefaultReplyMenuDataV2 copy(DefaultReplyMenuConfigV2 r100, Boolean r101, Map<String, DefaultReplySwitchMemory> r110, Boolean r111, w1 r112) {
        return new DefaultReplyMenuDataV2(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DefaultReplyMenuDataV2) == true) goto L8;
        return false;
    L8:
        DefaultReplyMenuDataV2 r101 = (DefaultReplyMenuDataV2) r100;
        if (Intrinsics.areEqual(this.menuConfV2, r101.menuConfV2) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.useMenuConfV2, r101.useMenuConfV2) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.switchMemory, r101.switchMemory) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.newActiveSwitchContainer, r101.newActiveSwitchContainer) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.reasoningEffortSectionConf, r101.reasoningEffortSectionConf) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        DefaultReplyMenuConfigV2 r100 = this.menuConfV2;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.useMenuConfV2;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, DefaultReplySwitchMemory> r107 = this.switchMemory;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.newActiveSwitchContainer;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        w1 r113 = this.reasoningEffortSectionConf;
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
        return "DefaultReplyMenuDataV2(menuConfV2=" + this.menuConfV2 + ", useMenuConfV2=" + this.useMenuConfV2 + ", switchMemory=" + this.switchMemory + ", newActiveSwitchContainer=" + this.newActiveSwitchContainer + ", reasoningEffortSectionConf=" + this.reasoningEffortSectionConf + ')';
    }

    public final DefaultReplyMenuConfigV2 getMenuConfV2() {
        return this.menuConfV2;
    }

    public final Boolean getNewActiveSwitchContainer() {
        return this.newActiveSwitchContainer;
    }

    public final w1 getReasoningEffortSectionConf() {
        return this.reasoningEffortSectionConf;
    }

    public final Map<String, DefaultReplySwitchMemory> getSwitchMemory() {
        return this.switchMemory;
    }

    public final Boolean getUseMenuConfV2() {
        return this.useMenuConfV2;
    }

    public final void setMenuConfV2(DefaultReplyMenuConfigV2 r100) {
        this.menuConfV2 = r100;
    }

    public final void setNewActiveSwitchContainer(Boolean r100) {
        this.newActiveSwitchContainer = r100;
    }

    public final void setReasoningEffortSectionConf(w1 r100) {
        this.reasoningEffortSectionConf = r100;
    }

    public final void setSwitchMemory(Map<String, DefaultReplySwitchMemory> r100) {
        this.switchMemory = r100;
    }

    public final void setUseMenuConfV2(Boolean r100) {
        this.useMenuConfV2 = r100;
    }

    public DefaultReplyMenuDataV2(DefaultReplyMenuConfigV2 r100, Boolean r101, Map<String, DefaultReplySwitchMemory> r102, Boolean r103, w1 r104) {
        this.menuConfV2 = r100;
        this.useMenuConfV2 = r101;
        this.switchMemory = r102;
        this.newActiveSwitchContainer = r103;
        this.reasoningEffortSectionConf = r104;
    }

    public /* synthetic */ DefaultReplyMenuDataV2(DefaultReplyMenuConfigV2 r100, Boolean r101, Map r102, Boolean r103, w1 r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        DefaultReplyMenuConfigV2 r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        Boolean r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        Map r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        Boolean r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        w1 r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
