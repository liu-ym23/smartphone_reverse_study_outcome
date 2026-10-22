package com.bytedance.ee.bear.office.list.adapter;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class OfficeFolderMoreMenuRules {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f235611a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/office/list/adapter/OfficeFolderMoreMenuRules$Action;", "", "<init>", "(Ljava/lang/String;I)V", "CREATE_DOC", "CREATE_PPT", "CREATE_BITABLE", "CREATE_SHEET", "CREATE_FOLDER", "UPLOAD_IMAGE", "UPLOAD_FILE", "LIST_VIEW", "GRID_VIEW", "SORT", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Action extends Enum<Action> {
        public static final Action CREATE_BITABLE = null;
        public static final Action CREATE_DOC = null;
        public static final Action CREATE_FOLDER = null;
        public static final Action CREATE_PPT = null;
        public static final Action CREATE_SHEET = null;
        public static final Action GRID_VIEW = null;
        public static final Action LIST_VIEW = null;
        public static final Action SORT = null;
        public static final Action UPLOAD_FILE = null;
        public static final Action UPLOAD_IMAGE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Action[] f235612a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f235613b = null;

        public static EnumEntries<Action> getEntries() {
            return f235613b;
        }

        static {
            Action r100 = new Action("CREATE_DOC", 0);
            CREATE_DOC = r100;
            Action r101 = new Action("CREATE_PPT", 1);
            CREATE_PPT = r101;
            Action r102 = new Action("CREATE_BITABLE", 2);
            CREATE_BITABLE = r102;
            Action r103 = new Action("CREATE_SHEET", 3);
            CREATE_SHEET = r103;
            Action r104 = new Action("CREATE_FOLDER", 4);
            CREATE_FOLDER = r104;
            Action r105 = new Action("UPLOAD_IMAGE", 5);
            UPLOAD_IMAGE = r105;
            Action r110 = new Action("UPLOAD_FILE", 6);
            UPLOAD_FILE = r110;
            Action r111 = new Action("LIST_VIEW", 7);
            LIST_VIEW = r111;
            Action r112 = new Action("GRID_VIEW", 8);
            GRID_VIEW = r112;
            Action r113 = new Action("SORT", 9);
            SORT = r113;
            Action[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
            f235612a = r114;
            f235613b = EnumEntriesKt.enumEntries(r114);
        }

        public static Action[] values() {
            return (Action[]) f235612a.clone();
        }

        public static Action valueOf(String r100) {
            return (Action) r27.a.a(Action.class, r100);
        }

        public Action(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/office/list/adapter/OfficeFolderMoreMenuRules$Group;", "", "<init>", "(Ljava/lang/String;I)V", "CREATE", "UPLOAD", "DISPLAY", "SORT", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Group extends Enum<Group> {
        public static final Group CREATE = null;
        public static final Group DISPLAY = null;
        public static final Group SORT = null;
        public static final Group UPLOAD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Group[] f235614a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f235615b = null;

        public static EnumEntries<Group> getEntries() {
            return f235615b;
        }

        static {
            Group r100 = new Group("CREATE", 0);
            CREATE = r100;
            Group r101 = new Group("UPLOAD", 1);
            UPLOAD = r101;
            Group r102 = new Group("DISPLAY", 2);
            DISPLAY = r102;
            Group r103 = new Group("SORT", 3);
            SORT = r103;
            Group[] r104 = {r100, r101, r102, r103};
            f235614a = r104;
            f235615b = EnumEntriesKt.enumEntries(r104);
        }

        public static Group[] values() {
            return (Group[]) f235614a.clone();
        }

        public static Group valueOf(String r100) {
            return (Group) r27.a.a(Group.class, r100);
        }

        public Group(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Action f235616a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Group f235617b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f235618c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f235619d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f235616a == r101.f235616a) goto L12;
            return false;
        L12:
            if (this.f235617b == r101.f235617b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f235618c, r101.f235618c) == true) goto L18;
            return false;
        L18:
            if (this.f235619d == r101.f235619d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f235616a.hashCode() * 31) + this.f235617b.hashCode()) * 31) + this.f235618c.hashCode()) * 31;
            if (this.f235619d == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "Entry(action=" + this.f235616a + ", group=" + this.f235617b + ", title=" + this.f235618c + ", enabled=" + this.f235619d + ')';
        }

        public a(Action r100, Group r101, String r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, "action");
            Intrinsics.checkNotNullParameter(r101, "group");
            Intrinsics.checkNotNullParameter(r102, "title");
            this.f235616a = r100;
            this.f235617b = r101;
            this.f235618c = r102;
            this.f235619d = r103;
        }
    }

    static {
    }
}
