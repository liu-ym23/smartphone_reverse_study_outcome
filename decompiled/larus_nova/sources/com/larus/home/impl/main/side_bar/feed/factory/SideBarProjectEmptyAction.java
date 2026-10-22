package com.larus.home.impl.main.side_bar.feed.factory;

import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B%\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/home/impl/main/side_bar/feed/factory/SideBarProjectEmptyAction;", "", "cardId", "", "titleRes", "", "iconRes", "<init>", "(Ljava/lang/String;ILjava/lang/String;II)V", "getCardId", "()Ljava/lang/String;", "getTitleRes", "()I", "getIconRes", "CREATE_BLANK_PROJECT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SideBarProjectEmptyAction extends Enum<SideBarProjectEmptyAction> {
    public static final SideBarProjectEmptyAction CREATE_BLANK_PROJECT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SideBarProjectEmptyAction[] f344707a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f344708b = null;
    private final String cardId;
    private final int iconRes;
    private final int titleRes;

    public static EnumEntries<SideBarProjectEmptyAction> getEntries() {
        return f344708b;
    }

    static {
        SideBarProjectEmptyAction r100 = new SideBarProjectEmptyAction();
        CREATE_BLANK_PROJECT = r100;
        SideBarProjectEmptyAction[] r101 = {r100};
        f344707a = r101;
        f344708b = EnumEntriesKt.enumEntries(r101);
    }

    public SideBarProjectEmptyAction() {
        super("CREATE_BLANK_PROJECT", 0);
        this.cardId = "create_blank_project";
        this.titleRes = R.string.larus_groupChats_navBar_project_more_menuOption_newProject;
        this.iconRes = R.drawable.larus_ic_create_blank_project_emtpy_view;
    }

    public static SideBarProjectEmptyAction[] values() {
        return (SideBarProjectEmptyAction[]) f344707a.clone();
    }

    public final String getCardId() {
        return this.cardId;
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    public final int getTitleRes() {
        return this.titleRes;
    }

    public static SideBarProjectEmptyAction valueOf(String r100) {
        return (SideBarProjectEmptyAction) a.a(SideBarProjectEmptyAction.class, r100);
    }
}
