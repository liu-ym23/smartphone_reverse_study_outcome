package com.ss.android.lark.todo.impl.features.center.v3.data;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.bytedance.lark.pb.todo.v1.DueTimeGroupCategory;
import com.bytedance.lark.pb.todo.v1.StartTimeGroupCategory;
import com.bytedance.lark.pb.todo.v1.TodoSource;
import com.bytedance.lark.pb.todo.v1.TodoUser;
import com.ss.android.lark.todo.impl.features.center.v3.type.TaskFieldType;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class SectionHeaderItem implements c, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f441435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f441436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f441437c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f441438d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f441439e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<TodoUser> f441440f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f441441g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f441442h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f441443i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f441444j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f441445k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final HeaderType f441446l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final TodoSource f441447m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f441448n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final TaskFieldType f441449o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final DueTimeGroupCategory f441450p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final StartTimeGroupCategory f441451q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f441452r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f441453s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f441454t;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/data/SectionHeaderItem$HeaderType;", "", "<init>", "(Ljava/lang/String;I)V", CardAdapter.TEXT, "CREATOR", "ASSIGNEES", "SOURCE", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum HeaderType extends Enum<HeaderType> {
        public static final HeaderType ASSIGNEES = null;
        public static final HeaderType CREATOR = null;
        public static final HeaderType SOURCE = null;
        public static final HeaderType TEXT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ HeaderType[] f441455a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f441456b = null;

        public static EnumEntries<HeaderType> getEntries() {
            return f441456b;
        }

        static {
            HeaderType r100 = new HeaderType(CardAdapter.TEXT, 0);
            TEXT = r100;
            HeaderType r101 = new HeaderType("CREATOR", 1);
            CREATOR = r101;
            HeaderType r102 = new HeaderType("ASSIGNEES", 2);
            ASSIGNEES = r102;
            HeaderType r103 = new HeaderType("SOURCE", 3);
            SOURCE = r103;
            HeaderType[] r104 = {r100, r101, r102, r103};
            f441455a = r104;
            f441456b = EnumEntriesKt.enumEntries(r104);
        }

        public static HeaderType[] values() {
            return (HeaderType[]) f441455a.clone();
        }

        public static HeaderType valueOf(String r100) {
            return (HeaderType) r27.a.a(HeaderType.class, r100);
        }

        public HeaderType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public SectionHeaderItem() {
        this(null, null, null, null, false, false, null, null, null, null, null, 524287);
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.data.a
    public final int c() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SectionHeaderItem) == true) goto L8;
        return false;
    L8:
        SectionHeaderItem r101 = (SectionHeaderItem) r100;
        if (Intrinsics.areEqual(this.f441435a, r101.f441435a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f441436b, r101.f441436b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f441437c, r101.f441437c) == true) goto L18;
        return false;
    L18:
        if (this.f441438d == r101.f441438d) goto L21;
        return false;
    L21:
        if (this.f441439e == r101.f441439e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f441440f, r101.f441440f) == true) goto L27;
        return false;
    L27:
        if (this.f441441g == r101.f441441g) goto L30;
        return false;
    L30:
        if (this.f441442h == r101.f441442h) goto L33;
        return false;
    L33:
        if (this.f441443i == r101.f441443i) goto L36;
        return false;
    L36:
        if (this.f441444j == r101.f441444j) goto L39;
        return false;
    L39:
        if (this.f441445k == r101.f441445k) goto L42;
        return false;
    L42:
        if (this.f441446l == r101.f441446l) goto L45;
        return false;
    L45:
        if (this.f441447m == r101.f441447m) goto L48;
        return false;
    L48:
        if (this.f441448n == r101.f441448n) goto L51;
        return false;
    L51:
        if (this.f441449o == r101.f441449o) goto L54;
        return false;
    L54:
        if (this.f441450p == r101.f441450p) goto L57;
        return false;
    L57:
        if (this.f441451q == r101.f441451q) goto L60;
        return false;
    L60:
        if (this.f441452r == r101.f441452r) goto L63;
        return false;
    L63:
        if (this.f441453s == r101.f441453s) goto L65;
        return false;
    L65:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((this.f441435a.hashCode() * 31) + this.f441436b.hashCode()) * 31) + this.f441437c.hashCode()) * 31) + this.f441438d) * 31) + this.f441439e) * 31) + this.f441440f.hashCode()) * 31;
        int r101 = 1231;
        if (this.f441441g == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f441442h == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f441443i == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f441444j == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        if (this.f441445k == false) goto L21;
        int r110 = 1231;
    L22:
        int r111 = (((((r109 + r110) * 31) + this.f441446l.hashCode()) * 31) + this.f441447m.hashCode()) * 31;
        if (this.f441448n == false) goto L25;
        int r112 = 1231;
    L26:
        int r113 = (((((((r111 + r112) * 31) + this.f441449o.hashCode()) * 31) + this.f441450p.hashCode()) * 31) + this.f441451q.hashCode()) * 31;
        if (this.f441452r == false) goto L29;
        int r114 = 1231;
    L30:
        int r115 = (r113 + r114) * 31;
        if (this.f441453s == true) goto L35;
        r101 = 1237;
    L35:
        return r115 + r101;
    L29:
        r114 = 1237;
        goto L30
    L25:
        r112 = 1237;
        goto L26
    L21:
        r110 = 1237;
        goto L22
    L17:
        r108 = 1237;
        goto L18
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "SectionHeaderItem(sectionGuid=" + this.f441435a + ", titleString=" + this.f441436b + ", rank=" + this.f441437c + ", count=" + this.f441438d + ", badgeCount=" + this.f441439e + ", members=" + this.f441440f + ", canExpand=" + this.f441441g + ", isExpand=" + this.f441442h + ", isDefined=" + this.f441443i + ", isDefault=" + this.f441444j + ", hasMoreItem=" + this.f441445k + ", headerType=" + this.f441446l + ", source=" + this.f441447m + ", canEdit=" + this.f441448n + ", groupField=" + this.f441449o + ", dueTimeGroupCategory=" + this.f441450p + ", startTimeGroupCategory=" + this.f441451q + ", isSectionFirstItem=" + this.f441452r + ", isSectionLastItem=" + this.f441453s + ')';
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.data.a
    public final boolean a() {
        return this.f441453s;
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.data.a
    public final String d() {
        return this.f441435a;
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.data.c
    public final boolean e() {
        return this.f441454t;
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.data.a
    public final boolean f() {
        return this.f441452r;
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.data.a
    public final void b(boolean r100) {
        this.f441452r = r100;
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.data.a
    public final void g(boolean r100) {
        this.f441453s = r100;
    }

    public SectionHeaderItem(String r110, String r111, String r210, List r211, boolean r212, boolean r213, HeaderType r214, TodoSource r215, TaskFieldType r216, DueTimeGroupCategory r217, StartTimeGroupCategory r218, int r219) {
        if ((r219 & 1) == 0) goto L5;
        String r100 = UUID.randomUUID().toString();
    L6:
        String r101 = "";
        if ((r219 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r219 & 4) != 0) goto L15;
        r101 = r210;
    L15:
        if ((r219 & 32) == 0) goto L17;
        List r103 = CollectionsKt.emptyList();
    L19:
        if ((r219 & 64) == 0) goto L21;
        boolean r104 = true;
    L23:
        if ((r219 & 128) == 0) goto L25;
        boolean r105 = true;
    L27:
        if ((r219 & 256) == 0) goto L29;
        boolean r112 = false;
    L31:
        if ((r219 & 512) == 0) goto L33;
        boolean r113 = false;
    L35:
        if ((r219 & 2048) == 0) goto L37;
        HeaderType r114 = HeaderType.TEXT;
    L39:
        if ((r219 & 4096) == 0) goto L41;
        TodoSource r115 = TodoSource.UNKNOWN_SOURCE;
    L43:
        if ((r219 & 8192) == 0) goto L45;
        boolean r116 = true;
    L47:
        if ((r219 & 16384) == 0) goto L49;
        TaskFieldType r117 = TaskFieldType.TASK_NO_SECTION;
    L51:
        if ((r219 & 32768) == 0) goto L53;
        DueTimeGroupCategory r106 = DueTimeGroupCategory.UNKNOWN_DUE_TIME;
    L55:
        if ((r219 & 65536) == 0) goto L57;
        StartTimeGroupCategory r107 = StartTimeGroupCategory.UNKNOWN_START_TIME;
    L59:
        if ((r219 & 131072) == 0) goto L61;
        boolean r108 = true;
    L62:
        Intrinsics.checkNotNullParameter(r100, "sectionGuid");
        Intrinsics.checkNotNullParameter(r102, "titleString");
        Intrinsics.checkNotNullParameter(r101, "rank");
        Intrinsics.checkNotNullParameter(r103, "members");
        Intrinsics.checkNotNullParameter(r114, "headerType");
        Intrinsics.checkNotNullParameter(r115, "source");
        Intrinsics.checkNotNullParameter(r117, "groupField");
        Intrinsics.checkNotNullParameter(r106, "dueTimeGroupCategory");
        Intrinsics.checkNotNullParameter(r107, "startTimeGroupCategory");
        this.f441435a = r100;
        this.f441436b = r102;
        this.f441437c = r101;
        this.f441438d = 0;
        this.f441439e = 0;
        this.f441440f = r103;
        this.f441441g = r104;
        this.f441442h = r105;
        this.f441443i = r112;
        this.f441444j = r113;
        this.f441445k = false;
        this.f441446l = r114;
        this.f441447m = r115;
        this.f441448n = r116;
        this.f441449o = r117;
        this.f441450p = r106;
        this.f441451q = r107;
        this.f441452r = r108;
        this.f441453s = false;
        this.f441454t = true;
        return;
    L61:
        r108 = false;
        goto L62
    L57:
        r107 = r218;
        goto L59
    L53:
        r106 = r217;
        goto L55
    L49:
        r117 = r216;
        goto L51
    L45:
        r116 = false;
        goto L47
    L41:
        r115 = r215;
        goto L43
    L37:
        r114 = r214;
        goto L39
    L33:
        r113 = r213;
        goto L35
    L29:
        r112 = r212;
        goto L31
    L25:
        r105 = false;
        goto L27
    L21:
        r104 = false;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }
}
