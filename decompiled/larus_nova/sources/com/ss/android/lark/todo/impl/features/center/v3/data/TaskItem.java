package com.ss.android.lark.todo.impl.features.center.v3.data;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.lark.pb.todo.v1.CustomComplete;
import com.bytedance.lark.pb.todo.v1.DueTimeGroupCategory;
import com.bytedance.lark.pb.todo.v1.Progress;
import com.bytedance.lark.pb.todo.v1.StartTimeGroupCategory;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.todo.impl.features.center.v3.view.TaskItemViewHolder;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class TaskItem implements a, b {
    public final int A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f441483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f441484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence f441485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<com.ss.android.lark.todo.impl.features.detail.sections.c> f441486d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f441487e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f441488f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f441489g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f441490h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DueTimeGroupCategory f441491i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final StartTimeGroupCategory f441492j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f441493k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f441494l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f441495m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Progress f441496n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f441497o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f441498p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f441499q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final CompleteType f441500r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final CustomComplete.Action f441501s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final List<TaskItemViewHolder.SwipeType> f441502t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final List<TaskItemViewHolder.SwipeType> f441503u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final DragState f441504v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f441505w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f441506x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f441507y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f441508z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/data/TaskItem$CompleteType;", "", "<init>", "(Ljava/lang/String;I)V", "UserComplete", "UserRevoke", "TaskComplete", "TaskRevoke", "TaskCompleteDialog", "TaskRevokeDialog", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CompleteType extends Enum<CompleteType> {
        public static final CompleteType TaskComplete = null;
        public static final CompleteType TaskCompleteDialog = null;
        public static final CompleteType TaskRevoke = null;
        public static final CompleteType TaskRevokeDialog = null;
        public static final CompleteType UserComplete = null;
        public static final CompleteType UserRevoke = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CompleteType[] f441509a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f441510b = null;

        public static EnumEntries<CompleteType> getEntries() {
            return f441510b;
        }

        static {
            CompleteType r100 = new CompleteType("UserComplete", 0);
            UserComplete = r100;
            CompleteType r101 = new CompleteType("UserRevoke", 1);
            UserRevoke = r101;
            CompleteType r102 = new CompleteType("TaskComplete", 2);
            TaskComplete = r102;
            CompleteType r103 = new CompleteType("TaskRevoke", 3);
            TaskRevoke = r103;
            CompleteType r104 = new CompleteType("TaskCompleteDialog", 4);
            TaskCompleteDialog = r104;
            CompleteType r105 = new CompleteType("TaskRevokeDialog", 5);
            TaskRevokeDialog = r105;
            CompleteType[] r110 = {r100, r101, r102, r103, r104, r105};
            f441509a = r110;
            f441510b = EnumEntriesKt.enumEntries(r110);
        }

        public static CompleteType[] values() {
            return (CompleteType[]) f441509a.clone();
        }

        public static CompleteType valueOf(String r100) {
            return (CompleteType) r27.a.a(CompleteType.class, r100);
        }

        public CompleteType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/data/TaskItem$DragState;", "", "<init>", "(Ljava/lang/String;I)V", "UNEDITABLE", "INVALID_SORT", "INVALID_SECTION", "CAN_DRAG", UserProfileEvent.POSITION_NONE, "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DragState extends Enum<DragState> {
        public static final DragState CAN_DRAG = null;
        public static final DragState INVALID_SECTION = null;
        public static final DragState INVALID_SORT = null;
        public static final DragState NONE = null;
        public static final DragState UNEDITABLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DragState[] f441511a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f441512b = null;

        public static EnumEntries<DragState> getEntries() {
            return f441512b;
        }

        static {
            DragState r100 = new DragState("UNEDITABLE", 0);
            UNEDITABLE = r100;
            DragState r101 = new DragState("INVALID_SORT", 1);
            INVALID_SORT = r101;
            DragState r102 = new DragState("INVALID_SECTION", 2);
            INVALID_SECTION = r102;
            DragState r103 = new DragState("CAN_DRAG", 3);
            CAN_DRAG = r103;
            DragState r104 = new DragState(UserProfileEvent.POSITION_NONE, 4);
            NONE = r104;
            DragState[] r105 = {r100, r101, r102, r103, r104};
            f441511a = r105;
            f441512b = EnumEntriesKt.enumEntries(r105);
        }

        public static DragState[] values() {
            return (DragState[]) f441511a.clone();
        }

        public static DragState valueOf(String r100) {
            return (DragState) r27.a.a(DragState.class, r100);
        }

        public DragState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final int hashCode() {
        int r100 = ((((((this.f441483a.hashCode() * 31) + this.f441484b.hashCode()) * 31) + this.f441485c.hashCode()) * 31) + this.f441486d.hashCode()) * 31;
        long r101 = this.f441487e;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f441488f;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f441489g;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.f441490h;
        int r108 = (((((r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31) + this.f441491i.hashCode()) * 31) + this.f441492j.hashCode()) * 31;
        int r109 = 1231;
        if (this.f441493k == false) goto L5;
        int r110 = 1231;
    L6:
        int r111 = (r108 + r110) * 31;
        if (this.f441494l == false) goto L9;
        int r112 = 1231;
    L10:
        int r113 = (r111 + r112) * 31;
        if (this.f441495m == false) goto L13;
        int r114 = 1231;
    L14:
        int r115 = (r113 + r114) * 31;
        Progress r116 = this.f441496n;
        int r117 = 0;
        if (r116 != null) goto L17;
        int r118 = 0;
    L18:
        int r119 = (((((r115 + r118) * 31) + this.f441497o) * 31) + this.f441498p) * 31;
        if (this.f441499q == false) goto L21;
        int r120 = 1231;
    L22:
        int r121 = (((r119 + r120) * 31) + this.f441500r.hashCode()) * 31;
        CustomComplete.Action r122 = this.f441501s;
        if (r122 == null) goto L26;
        r117 = r122.hashCode();
    L26:
        int r123 = (((((((r121 + r117) * 31) + this.f441502t.hashCode()) * 31) + this.f441503u.hashCode()) * 31) + this.f441504v.hashCode()) * 31;
        if (this.f441505w == false) goto L29;
        int r124 = 1231;
    L30:
        int r125 = (r123 + r124) * 31;
        if (this.f441506x == false) goto L33;
        int r126 = 1231;
    L34:
        int r127 = (r125 + r126) * 31;
        if (this.f441507y == false) goto L37;
        int r128 = 1231;
    L38:
        int r129 = (r127 + r128) * 31;
        if (this.f441508z == true) goto L43;
        r109 = 1237;
    L43:
        return r129 + r109;
    L37:
        r128 = 1237;
        goto L38
    L33:
        r126 = 1237;
        goto L34
    L29:
        r124 = 1237;
        goto L30
    L21:
        r120 = 1237;
        goto L22
    L17:
        r118 = r116.hashCode();
        goto L18
    L13:
        r114 = 1237;
        goto L14
    L9:
        r112 = 1237;
        goto L10
    L5:
        r110 = 1237;
        goto L6
    }

    public final String toString() {
        return "TaskItem(guid=" + this.f441483a + ", sectionGuid=" + this.f441484b + ", summaryDigest=" + this.f441485c + ", owners=" + this.f441486d + ", dueTimeMillis=" + this.f441487e + ", startTimeMillis=" + this.f441488f + ", originDueTimeMillis=" + this.f441489g + ", originStartTimeMillis=" + this.f441490h + ", dueTimeGroupCategory=" + this.f441491i + ", startTimeGroupCategory=" + this.f441492j + ", isAllDay=" + this.f441493k + ", hasRemind=" + this.f441494l + ", hasRepeat=" + this.f441495m + ", subTaskProgress=" + this.f441496n + ", attachmentCount=" + this.f441497o + ", commentCount=" + this.f441498p + ", canComplete=" + this.f441499q + ", completeType=" + this.f441500r + ", completeAction=" + this.f441501s + ", swipeLefts=" + this.f441502t + ", swipeRights=" + this.f441503u + ", dragState=" + this.f441504v + ", isMileStone=" + this.f441505w + ", isSectionFirstItem=" + this.f441506x + ", isSectionLastItem=" + this.f441507y + ", isTwentyFourHours=" + this.f441508z + ')';
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.data.a
    public final boolean a() {
        return this.f441507y;
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.data.a
    public final int c() {
        return this.A;
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.data.a
    public final String d() {
        return this.f441484b;
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.data.b
    public final String e() {
        return this.f441483a;
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.data.a
    public final boolean f() {
        return this.f441506x;
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.data.a
    public final void b(boolean r100) {
        this.f441506x = r100;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof TaskItem) == true) goto L5;
        return false;
    L5:
        TaskItem r101 = (TaskItem) r100;
        if (Intrinsics.areEqual(this.f441483a, r101.f441483a) == true) goto L8;
    L90:
        return false;
    L8:
        if (Intrinsics.areEqual(this.f441485c, r101.f441485c) == false) goto L90;
        if (this.f441508z == r101.f441508z) goto L14;
        return false;
    L14:
        if (this.f441486d.size() == r101.f441486d.size()) goto L16;
        return false;
    L16:
        Iterator<T> r102 = this.f441486d.iterator();
        int r103 = 0;
    L18:
        if (r102.hasNext() == false) goto L27;
        int r104 = r103 + 1;
        com.ss.android.lark.todo.impl.features.detail.sections.c r105 = (com.ss.android.lark.todo.impl.features.detail.sections.c) r102.next();
        if (Intrinsics.areEqual(r105.f443342a, ((com.ss.android.lark.todo.impl.features.detail.sections.c) ListProtector.get(r101.f441486d, r103)).f443342a) == false) goto L21;
        if (r105.f443344c != ((com.ss.android.lark.todo.impl.features.detail.sections.c) ListProtector.get(r101.f441486d, r103)).f443344c) goto L24;
        r103 = r104;
        goto L18
    L24:
        return false;
    L21:
        return false;
    L27:
        if (this.f441489g != r101.f441489g) goto L90;
        if (this.f441490h != r101.f441490h) goto L90;
        if (this.f441491i != r101.f441491i) goto L90;
        if (this.f441492j != r101.f441492j) goto L90;
        if (this.f441493k != r101.f441493k) goto L90;
        if (this.f441494l != r101.f441494l) goto L90;
        if (this.f441495m == r101.f441495m) goto L42;
        return false;
    L42:
        Progress r106 = this.f441496n;
        Integer r107 = null;
        if (r106 == null) goto L45;
        Integer r108 = r106.total;
    L46:
        Progress r109 = r101.f441496n;
        if (r109 == null) goto L49;
        Integer r110 = r109.total;
    L51:
        if (Intrinsics.areEqual(r108, r110) == false) goto L90;
        Progress r111 = this.f441496n;
        if (r111 == null) goto L55;
        Integer r112 = r111.completed;
    L56:
        Progress r113 = r101.f441496n;
        if (r113 == null) goto L60;
        r107 = r113.completed;
    L60:
        if (Intrinsics.areEqual(r112, r107) == false) goto L90;
        if (this.f441497o != r101.f441497o) goto L90;
        if (this.f441498p != r101.f441498p) goto L90;
        if (this.f441499q != r101.f441499q) goto L90;
        if (this.f441500r != r101.f441500r) goto L90;
        if (Intrinsics.areEqual(this.f441502t, r101.f441502t) == false) goto L90;
        if (Intrinsics.areEqual(this.f441503u, r101.f441503u) == false) goto L90;
        if (this.f441504v == r101.f441504v) goto L81;
        return false;
    L81:
        if (this.f441506x != r101.f441506x) goto L90;
        if (this.f441507y != r101.f441507y) goto L90;
        if (this.f441505w == r101.f441505w) goto L88;
        return false;
    L88:
        return true;
    L55:
        r112 = null;
        goto L56
    L49:
        r110 = null;
        goto L51
    L45:
        r108 = null;
        goto L46
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.data.a
    public final void g(boolean r100) {
        this.f441507y = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TaskItem(String r110, String r111, CharSequence r112, List<com.ss.android.lark.todo.impl.features.detail.sections.c> r113, long r114, long r115, long r210, long r211, DueTimeGroupCategory r212, StartTimeGroupCategory r213, boolean r214, boolean r215, boolean r216, Progress r310, int r311, int r312, boolean r313, CompleteType r314, CustomComplete.Action r315, List<? extends TaskItemViewHolder.SwipeType> r316, List<? extends TaskItemViewHolder.SwipeType> r317, DragState r318, boolean r319, boolean r410, boolean r411, boolean r412) {
        Intrinsics.checkNotNullParameter(r110, "guid");
        Intrinsics.checkNotNullParameter(r111, "sectionGuid");
        Intrinsics.checkNotNullParameter(r112, "summaryDigest");
        Intrinsics.checkNotNullParameter(r113, "owners");
        Intrinsics.checkNotNullParameter(r212, "dueTimeGroupCategory");
        Intrinsics.checkNotNullParameter(r213, "startTimeGroupCategory");
        Intrinsics.checkNotNullParameter(r314, "completeType");
        Intrinsics.checkNotNullParameter(r316, "swipeLefts");
        Intrinsics.checkNotNullParameter(r317, "swipeRights");
        Intrinsics.checkNotNullParameter(r318, "dragState");
        this.f441483a = r110;
        this.f441484b = r111;
        this.f441485c = r112;
        this.f441486d = r113;
        this.f441487e = r114;
        this.f441488f = r115;
        this.f441489g = r210;
        this.f441490h = r211;
        this.f441491i = r212;
        this.f441492j = r213;
        this.f441493k = r214;
        this.f441494l = r215;
        this.f441495m = r216;
        this.f441496n = r310;
        this.f441497o = r311;
        this.f441498p = r312;
        this.f441499q = r313;
        this.f441500r = r314;
        this.f441501s = r315;
        this.f441502t = r316;
        this.f441503u = r317;
        this.f441504v = r318;
        this.f441505w = r319;
        this.f441506x = r410;
        this.f441507y = r411;
        this.f441508z = r412;
        this.A = 1;
    }
}
