package uu9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 C2\u00020\u0001:\u0001CB¿\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0007HÆ\u0003J\t\u00100\u001a\u00020\u0007HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u00109\u001a\u00020\u0007HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\fHÆ\u0003JÁ\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010>\u001a\u00020\u00032\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020\u0007HÖ\u0001J\t\u0010A\u001a\u00020BHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\"R\u0016\u0010\u0012\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001dR\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0019R\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0019R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\"¨\u0006D"}, d2 = {"Lcom/larus/settings/provider/home/ConversationGroupExperimentConfig;", "", "enable", "", "enableMergeMainConversation", "enableDragAndDrop", "defaultGroupType", "", "defaultSortType", "socialIndependentGroup", "enableAddLocalFolder", "pinPagingConfig", "Lcom/larus/settings/provider/home/ConversationGroupPagingExperimentConfig;", "socialPagingConfig", "projectPagingConfig", "projectConversationPagingConfig", "deviceConversationPagingConfig", "chatPagingConfig", "projectListUpdateStrategy", "conversationMemoryMutation", "enableArchive", "archivedPageConfig", "<init>", "(ZZZIIZZLcom/larus/settings/provider/home/ConversationGroupPagingExperimentConfig;Lcom/larus/settings/provider/home/ConversationGroupPagingExperimentConfig;Lcom/larus/settings/provider/home/ConversationGroupPagingExperimentConfig;Lcom/larus/settings/provider/home/ConversationGroupPagingExperimentConfig;Lcom/larus/settings/provider/home/ConversationGroupPagingExperimentConfig;Lcom/larus/settings/provider/home/ConversationGroupPagingExperimentConfig;IZZLcom/larus/settings/provider/home/ConversationGroupPagingExperimentConfig;)V", "getEnable", "()Z", "getEnableMergeMainConversation", "getEnableDragAndDrop", "getDefaultGroupType", "()I", "getDefaultSortType", "getSocialIndependentGroup", "getEnableAddLocalFolder", "getPinPagingConfig", "()Lcom/larus/settings/provider/home/ConversationGroupPagingExperimentConfig;", "getSocialPagingConfig", "getProjectPagingConfig", "getProjectConversationPagingConfig", "getDeviceConversationPagingConfig", "getChatPagingConfig", "getProjectListUpdateStrategy", "getConversationMemoryMutation", "getEnableArchive", "getArchivedPageConfig", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f551781a = null;

    @SerializedName("archive_paging_config")
    private final c archivedPageConfig;

    @SerializedName("chat_paging_config")
    private final c chatPagingConfig;

    @SerializedName("conversation_memory_mutation")
    private final boolean conversationMemoryMutation;

    @SerializedName("default_group_type")
    private final int defaultGroupType;

    @SerializedName("default_sort_type")
    private final int defaultSortType;

    @SerializedName("device_conversation_paging_config")
    private final c deviceConversationPagingConfig;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("enable_add_local_folder")
    private final boolean enableAddLocalFolder;

    @SerializedName("enable_archive")
    private final boolean enableArchive;

    @SerializedName("enable_drag_and_drop")
    private final boolean enableDragAndDrop;

    @SerializedName("enable_merge_main_conversation")
    private final boolean enableMergeMainConversation;

    @SerializedName("pin_paging_config")
    private final c pinPagingConfig;

    @SerializedName("project_conversation_paging_config")
    private final c projectConversationPagingConfig;

    @SerializedName("project_list_update_strategy")
    private final int projectListUpdateStrategy;

    @SerializedName("project_paging_config")
    private final c projectPagingConfig;

    @SerializedName("social_independent_group")
    private final boolean socialIndependentGroup;

    @SerializedName("social_paging_config")
    private final c socialPagingConfig;

    /* JADX INFO: renamed from: uu9.a$a, reason: collision with other inner class name */
    public static final class C7938a {
    }

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.enable == r101.enable) goto L12;
        return false;
    L12:
        if (this.enableMergeMainConversation == r101.enableMergeMainConversation) goto L15;
        return false;
    L15:
        if (this.enableDragAndDrop == r101.enableDragAndDrop) goto L18;
        return false;
    L18:
        if (this.defaultGroupType == r101.defaultGroupType) goto L21;
        return false;
    L21:
        if (this.defaultSortType == r101.defaultSortType) goto L24;
        return false;
    L24:
        if (this.socialIndependentGroup == r101.socialIndependentGroup) goto L27;
        return false;
    L27:
        if (this.enableAddLocalFolder == r101.enableAddLocalFolder) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.pinPagingConfig, r101.pinPagingConfig) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.socialPagingConfig, r101.socialPagingConfig) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.projectPagingConfig, r101.projectPagingConfig) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.projectConversationPagingConfig, r101.projectConversationPagingConfig) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.deviceConversationPagingConfig, r101.deviceConversationPagingConfig) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.chatPagingConfig, r101.chatPagingConfig) == true) goto L48;
        return false;
    L48:
        if (this.projectListUpdateStrategy == r101.projectListUpdateStrategy) goto L51;
        return false;
    L51:
        if (this.conversationMemoryMutation == r101.conversationMemoryMutation) goto L54;
        return false;
    L54:
        if (this.enableArchive == r101.enableArchive) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.archivedPageConfig, r101.archivedPageConfig) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enable == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enableMergeMainConversation == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.enableDragAndDrop == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (((((r104 + r105) * 31) + this.defaultGroupType) * 31) + this.defaultSortType) * 31;
        if (this.socialIndependentGroup == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.enableAddLocalFolder == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        c r111 = this.pinPagingConfig;
        int r112 = 0;
        if (r111 != null) goto L25;
        int r113 = 0;
    L26:
        int r114 = (r110 + r113) * 31;
        c r115 = this.socialPagingConfig;
        if (r115 != null) goto L29;
        int r116 = 0;
    L30:
        int r117 = (r114 + r116) * 31;
        c r118 = this.projectPagingConfig;
        if (r118 != null) goto L33;
        int r119 = 0;
    L34:
        int r120 = (r117 + r119) * 31;
        c r121 = this.projectConversationPagingConfig;
        if (r121 != null) goto L37;
        int r122 = 0;
    L38:
        int r123 = (r120 + r122) * 31;
        c r124 = this.deviceConversationPagingConfig;
        if (r124 != null) goto L41;
        int r125 = 0;
    L42:
        int r126 = (r123 + r125) * 31;
        c r127 = this.chatPagingConfig;
        if (r127 != null) goto L45;
        int r128 = 0;
    L46:
        int r129 = (((r126 + r128) * 31) + this.projectListUpdateStrategy) * 31;
        if (this.conversationMemoryMutation == false) goto L49;
        int r130 = 1231;
    L50:
        int r131 = (r129 + r130) * 31;
        if (this.enableArchive == true) goto L54;
        r100 = 1237;
    L54:
        int r132 = (r131 + r100) * 31;
        c r133 = this.archivedPageConfig;
        if (r133 == null) goto L59;
        r112 = r133.hashCode();
    L59:
        return r132 + r112;
    L49:
        r130 = 1237;
        goto L50
    L45:
        r128 = r127.hashCode();
        goto L46
    L41:
        r125 = r124.hashCode();
        goto L42
    L37:
        r122 = r121.hashCode();
        goto L38
    L33:
        r119 = r118.hashCode();
        goto L34
    L29:
        r116 = r115.hashCode();
        goto L30
    L25:
        r113 = r111.hashCode();
        goto L26
    L21:
        r109 = 1237;
        goto L22
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ConversationGroupExperimentConfig(enable=" + this.enable + ", enableMergeMainConversation=" + this.enableMergeMainConversation + ", enableDragAndDrop=" + this.enableDragAndDrop + ", defaultGroupType=" + this.defaultGroupType + ", defaultSortType=" + this.defaultSortType + ", socialIndependentGroup=" + this.socialIndependentGroup + ", enableAddLocalFolder=" + this.enableAddLocalFolder + ", pinPagingConfig=" + this.pinPagingConfig + ", socialPagingConfig=" + this.socialPagingConfig + ", projectPagingConfig=" + this.projectPagingConfig + ", projectConversationPagingConfig=" + this.projectConversationPagingConfig + ", deviceConversationPagingConfig=" + this.deviceConversationPagingConfig + ", chatPagingConfig=" + this.chatPagingConfig + ", projectListUpdateStrategy=" + this.projectListUpdateStrategy + ", conversationMemoryMutation=" + this.conversationMemoryMutation + ", enableArchive=" + this.enableArchive + ", archivedPageConfig=" + this.archivedPageConfig + ')';
    }

    static {
        f551781a = new a(0);
    }

    public final c a() {
        return this.archivedPageConfig;
    }

    public final c b() {
        return this.chatPagingConfig;
    }

    public final boolean c() {
        return this.conversationMemoryMutation;
    }

    public final int d() {
        return this.defaultGroupType;
    }

    public final int e() {
        return this.defaultSortType;
    }

    public final c f() {
        return this.deviceConversationPagingConfig;
    }

    public final boolean g() {
        return this.enable;
    }

    public final boolean h() {
        return this.enableAddLocalFolder;
    }

    public final boolean i() {
        return this.enableArchive;
    }

    public final boolean j() {
        return this.enableDragAndDrop;
    }

    public final boolean k() {
        return this.enableMergeMainConversation;
    }

    public final c l() {
        return this.pinPagingConfig;
    }

    public final c m() {
        return this.projectConversationPagingConfig;
    }

    public final int n() {
        return this.projectListUpdateStrategy;
    }

    public final c o() {
        return this.projectPagingConfig;
    }

    public final boolean p() {
        return this.socialIndependentGroup;
    }

    public final c q() {
        return this.socialPagingConfig;
    }

    public a(int r100) {
        c r101 = new c(100, 100, 100);
        c r102 = new c(3, 10, 20);
        c r103 = new c(5, 10, 20);
        c r104 = new c(5, 10, 20);
        c r105 = new c(5, 10, 20);
        c r106 = new c(20, 20, 20);
        c r107 = new c(20, 20, 20);
        this.enable = true;
        this.enableMergeMainConversation = false;
        this.enableDragAndDrop = true;
        this.defaultGroupType = 0;
        this.defaultSortType = 0;
        this.socialIndependentGroup = true;
        this.enableAddLocalFolder = false;
        this.pinPagingConfig = r101;
        this.socialPagingConfig = r102;
        this.projectPagingConfig = r103;
        this.projectConversationPagingConfig = r104;
        this.deviceConversationPagingConfig = r105;
        this.chatPagingConfig = r106;
        this.projectListUpdateStrategy = 0;
        this.conversationMemoryMutation = true;
        this.enableArchive = true;
        this.archivedPageConfig = r107;
    }
}
