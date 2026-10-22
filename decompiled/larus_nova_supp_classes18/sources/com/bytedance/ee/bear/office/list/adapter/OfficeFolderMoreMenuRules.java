package com.bytedance.ee.bear.office.list.adapter;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class OfficeFolderMoreMenuRules {
    public static final /* synthetic */ int a = 0;

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
        public static final /* synthetic */ Action[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Action> getEntries() {
            return b;
        }

        static {
            Action r0 = new Action("CREATE_DOC", 0);
            CREATE_DOC = r0;
            Action r1 = new Action("CREATE_PPT", 1);
            CREATE_PPT = r1;
            Action r3 = new Action("CREATE_BITABLE", 2);
            CREATE_BITABLE = r3;
            Action r5 = new Action("CREATE_SHEET", 3);
            CREATE_SHEET = r5;
            Action r7 = new Action("CREATE_FOLDER", 4);
            CREATE_FOLDER = r7;
            Action r9 = new Action("UPLOAD_IMAGE", 5);
            UPLOAD_IMAGE = r9;
            Action r11 = new Action("UPLOAD_FILE", 6);
            UPLOAD_FILE = r11;
            Action r13 = new Action("LIST_VIEW", 7);
            LIST_VIEW = r13;
            Action r15 = new Action("GRID_VIEW", 8);
            GRID_VIEW = r15;
            Action r14 = new Action("SORT", 9);
            SORT = r14;
            Action[] r12 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
            a = r12;
            b = EnumEntriesKt.enumEntries(r12);
        }

        public static Action[] values() {
            return (Action[]) a.clone();
        }

        public static Action valueOf(String r1) {
            return (Action) r27.a.a(Action.class, r1);
        }

        public Action(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/office/list/adapter/OfficeFolderMoreMenuRules$Group;", "", "<init>", "(Ljava/lang/String;I)V", "CREATE", "UPLOAD", "DISPLAY", "SORT", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Group extends Enum<Group> {
        public static final Group CREATE = null;
        public static final Group DISPLAY = null;
        public static final Group SORT = null;
        public static final Group UPLOAD = null;
        public static final /* synthetic */ Group[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Group> getEntries() {
            return b;
        }

        static {
            Group r0 = new Group("CREATE", 0);
            CREATE = r0;
            Group r1 = new Group("UPLOAD", 1);
            UPLOAD = r1;
            Group r3 = new Group("DISPLAY", 2);
            DISPLAY = r3;
            Group r5 = new Group("SORT", 3);
            SORT = r5;
            Group[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static Group[] values() {
            return (Group[]) a.clone();
        }

        public static Group valueOf(String r1) {
            return (Group) r27.a.a(Group.class, r1);
        }

        public Group(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final Action a;
        public final Group b;
        public final String c;
        public final boolean d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            if (this.d == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "Entry(action=" + this.a + ", group=" + this.b + ", title=" + this.c + ", enabled=" + this.d + ')';
        }

        public a(Action r2, Group r3, String r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r2, "action");
            Intrinsics.checkNotNullParameter(r3, "group");
            Intrinsics.checkNotNullParameter(r4, "title");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    static {
    }
}
