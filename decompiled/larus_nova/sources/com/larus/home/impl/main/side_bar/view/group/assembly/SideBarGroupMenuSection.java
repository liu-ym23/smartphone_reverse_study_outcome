package com.larus.home.impl.main.side_bar.view.group.assembly;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/home/impl/main/side_bar/view/group/assembly/SideBarGroupMenuSection;", "", "id", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "GROUP_SORT_POLICY", "CONVERSATION_OPTIONS", "ARCHIVE_ACTIONS", "PROJECT_ACTIONS", "CREATE_ACTIONS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SideBarGroupMenuSection extends Enum<SideBarGroupMenuSection> {
    public static final SideBarGroupMenuSection ARCHIVE_ACTIONS = null;
    public static final SideBarGroupMenuSection CONVERSATION_OPTIONS = null;
    public static final SideBarGroupMenuSection CREATE_ACTIONS = null;
    public static final SideBarGroupMenuSection GROUP_SORT_POLICY = null;
    public static final SideBarGroupMenuSection PROJECT_ACTIONS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SideBarGroupMenuSection[] f345144a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f345145b = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f345146id;

    public static EnumEntries<SideBarGroupMenuSection> getEntries() {
        return f345145b;
    }

    static {
        SideBarGroupMenuSection r100 = new SideBarGroupMenuSection("GROUP_SORT_POLICY", 0, "group_sort_policy");
        GROUP_SORT_POLICY = r100;
        SideBarGroupMenuSection r101 = new SideBarGroupMenuSection("CONVERSATION_OPTIONS", 1, "conversation_options");
        CONVERSATION_OPTIONS = r101;
        SideBarGroupMenuSection r102 = new SideBarGroupMenuSection("ARCHIVE_ACTIONS", 2, "archive_actions");
        ARCHIVE_ACTIONS = r102;
        SideBarGroupMenuSection r103 = new SideBarGroupMenuSection("PROJECT_ACTIONS", 3, "project_actions");
        PROJECT_ACTIONS = r103;
        SideBarGroupMenuSection r104 = new SideBarGroupMenuSection("CREATE_ACTIONS", 4, "create_actions");
        CREATE_ACTIONS = r104;
        SideBarGroupMenuSection[] r105 = {r100, r101, r102, r103, r104};
        f345144a = r105;
        f345145b = EnumEntriesKt.enumEntries(r105);
    }

    public static SideBarGroupMenuSection[] values() {
        return (SideBarGroupMenuSection[]) f345144a.clone();
    }

    public final String getId() {
        return this.f345146id;
    }

    public static SideBarGroupMenuSection valueOf(String r100) {
        return (SideBarGroupMenuSection) r27.a.a(SideBarGroupMenuSection.class, r100);
    }

    public SideBarGroupMenuSection(String r100, int r101, String r102) {
        super(r100, r101);
        this.f345146id = r102;
    }
}
