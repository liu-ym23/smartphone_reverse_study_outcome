package com.ss.android.lark.todo.impl.features.center.v3;

import android.icu.text.Collator;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.lark.pb.todo.v1.DueTimeGroupCategory;
import com.bytedance.lark.pb.todo.v1.StartTimeGroupCategory;
import com.bytedance.lark.pb.todo.v1.Todo;
import com.bytedance.lark.pb.todo.v1.TodoAssignee;
import com.bytedance.lark.pb.todo.v1.TodoUser;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.todo.impl.features.center.v3.data.TaskSectionData;
import com.ss.android.lark.todo.impl.features.center.v3.type.TaskFieldType;
import java.util.Comparator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C5319f f441581a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f441582b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i f441583c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final o f441584d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final p f441585e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f441586f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final e f441587g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final r f441588h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final s f441589i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final b f441590j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final c f441591k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final q f441592l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final j f441593m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final n f441594n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final k f441595o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final m f441596p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final l f441597q = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f441598a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f441599b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f441600c = null;

        static {
            int[] r100 = new int[TaskFieldType.values().length];
            r100[TaskFieldType.COMPLETE_TIME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L31
        L75:
            r100[TaskFieldType.UPDATE_TIME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L32
        L89:
            r100[TaskFieldType.CREATE_TIME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L33
        L55:
            r100[TaskFieldType.DUE_TIME.ordinal()] = 4;     // Catch: NoSuchFieldError -> L34
        L57:
            r100[TaskFieldType.START_TIME.ordinal()] = 5;     // Catch: NoSuchFieldError -> L35
        L71:
            r100[TaskFieldType.TASK_DEFAULT_SORT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L36
        L87:
            r100[TaskFieldType.TASK_DEFAULT_SECTION.ordinal()] = 7;     // Catch: NoSuchFieldError -> L37
        L65:
            r100[TaskFieldType.ASSIGNEE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L38
        L77:
            r100[TaskFieldType.CREATOR.ordinal()] = 9;     // Catch: NoSuchFieldError -> L39
        L79:
            r100[TaskFieldType.SOURCE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L40
        L17:
            f441598a = r100;
            int[] r101 = new int[DueTimeGroupCategory.values().length];
            r101[DueTimeGroupCategory.OVERDUE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L41
        L69:
            r101[DueTimeGroupCategory.TODAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L42
        L81:
            r101[DueTimeGroupCategory.TOMORROW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L43
        L51:
            r101[DueTimeGroupCategory.NEXT_SEVEN_DAYS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L44
        L59:
            r101[DueTimeGroupCategory.LATER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L45
        L23:
            f441599b = r101;
            int[] r102 = new int[StartTimeGroupCategory.values().length];
            r102[StartTimeGroupCategory.ALREADY_STARTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L46
        L53:
            r102[StartTimeGroupCategory.START_TODAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L47
        L63:
            r102[StartTimeGroupCategory.START_TOMORROW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L48
        L73:
            r102[StartTimeGroupCategory.START_NEXT_SEVEN_DAYS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L49
        L83:
            r102[StartTimeGroupCategory.START_LATER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L50
        L29:
            f441600c = r102;
        }
    }

    public static final class b<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<T> f441601a = null;

        static {
            f441601a = new b();
        }

        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            Todo r102 = (Todo) r100;
            Todo r103 = (Todo) r101;
            Long r104 = r102.display_completed_milli_time;
            if (r104 != null) goto L6;
        L13:
            Long r105 = r102.display_completed_milli_time;
            if (r105 != null) goto L17;
        L18:
            Long r106 = r103.display_completed_milli_time;
            if (r106 != null) goto L22;
        L24:
            C5319f r107 = f.f441581a;
            Intrinsics.checkNotNull(r102);
            Intrinsics.checkNotNull(r103);
            int r108 = f.a(r102, r103, true);
            if (r108 == 0) goto L28;
            return r108;
        L28:
            return f.f441581a.compare(r102, r103);
        L22:
            if (r106.longValue() != 0) goto L24;
            return -1;
        L17:
            if (r105.longValue() == 0) goto L24;
        L6:
            if (r104.longValue() != 0) goto L13;
            Long r109 = r103.display_completed_milli_time;
            if (r109 != null) goto L11;
            return 1;
        L11:
            if (r109.longValue() == 0) goto L13;
            return 1;
        }
    }

    public static final class c<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T> f441602a = null;

        static {
            f441602a = new c();
        }

        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            Todo r102 = (Todo) r100;
            Todo r103 = (Todo) r101;
            Long r104 = r102.display_completed_milli_time;
            if (r104 != null) goto L6;
        L13:
            Long r105 = r102.display_completed_milli_time;
            if (r105 != null) goto L17;
        L18:
            Long r106 = r103.display_completed_milli_time;
            if (r106 != null) goto L22;
        L24:
            C5319f r107 = f.f441581a;
            Intrinsics.checkNotNull(r102);
            Intrinsics.checkNotNull(r103);
            int r108 = f.a(r102, r103, false);
            if (r108 == 0) goto L28;
            return r108;
        L28:
            return f.f441581a.compare(r102, r103);
        L22:
            if (r106.longValue() != 0) goto L24;
            return -1;
        L17:
            if (r105.longValue() == 0) goto L24;
        L6:
            if (r104.longValue() != 0) goto L13;
            Long r109 = r103.display_completed_milli_time;
            if (r109 != null) goto L11;
        L12:
            return 1;
        L11:
            if (r109.longValue() == 0) goto L13;
            goto L12
        }
    }

    public static final class d<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d<T> f441603a = null;

        static {
            f441603a = new d();
        }

        public d() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            Todo r102 = (Todo) r100;
            Todo r103 = (Todo) r101;
            C5319f r104 = f.f441581a;
            Intrinsics.checkNotNull(r102);
            Intrinsics.checkNotNull(r103);
            int r105 = f.g(r102, r103, true);
            if (r105 == 0) goto L6;
            return r105;
        L6:
            return f.f441581a.compare(r102, r103);
        }
    }

    public static final class e<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e<T> f441604a = null;

        static {
            f441604a = new e();
        }

        public e() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            Todo r102 = (Todo) r100;
            Todo r103 = (Todo) r101;
            C5319f r104 = f.f441581a;
            Intrinsics.checkNotNull(r102);
            Intrinsics.checkNotNull(r103);
            int r105 = f.g(r102, r103, false);
            if (r105 == 0) goto L6;
            return r105;
        L6:
            return f.f441581a.compare(r102, r103);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.todo.impl.features.center.v3.f$f, reason: collision with other inner class name */
    public static final class C5319f<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C5319f<T> f441605a = null;

        static {
            f441605a = new C5319f();
        }

        public C5319f() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            Todo r102 = (Todo) r100;
            Todo r103 = (Todo) r101;
            C5319f r104 = f.f441581a;
            Intrinsics.checkNotNull(r102);
            Intrinsics.checkNotNull(r103);
            int r105 = f.g(r102, r103, false);
            if (r105 == 0) goto L6;
            return r105;
        L6:
            return r102.guid.compareTo(r103.guid);
        }
    }

    public static final class g<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f441606a = 0;

        static {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            return ((TodoAssignee) r100).assigner_id.compareTo(((TodoAssignee) r101).assigner_id);
        }
    }

    public static final class h<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h<T> f441607a = null;

        static {
            f441607a = new h();
        }

        public h() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            Todo r102 = (Todo) r100;
            Todo r103 = (Todo) r101;
            C5319f r104 = f.f441581a;
            Intrinsics.checkNotNull(r102);
            Intrinsics.checkNotNull(r103);
            int r105 = f.b(r102, r103, true);
            if (r105 == 0) goto L6;
            return r105;
        L6:
            return f.f441581a.compare(r102, r103);
        }
    }

    public static final class i<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i<T> f441608a = null;

        static {
            f441608a = new i();
        }

        public i() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            Todo r102 = (Todo) r100;
            Todo r103 = (Todo) r101;
            C5319f r104 = f.f441581a;
            Intrinsics.checkNotNull(r102);
            Intrinsics.checkNotNull(r103);
            int r105 = f.b(r102, r103, false);
            if (r105 == 0) goto L6;
            return r105;
        L6:
            return f.f441581a.compare(r102, r103);
        }
    }

    public static final class j<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j<T> f441609a = null;

        static {
            f441609a = new j();
        }

        public j() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            C5319f r102 = f.f441581a;
            return f.c(((TaskSectionData) r100).f441528p) - f.c(((TaskSectionData) r101).f441528p);
        }
    }

    public static final class k<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k<T> f441610a = null;

        static {
            f441610a = new k();
        }

        public k() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            TaskSectionData r102 = (TaskSectionData) r100;
            TaskSectionData r103 = (TaskSectionData) r101;
            if (r102.f441526n.isEmpty() == false) goto L6;
            return 1;
        L6:
            if (r103.f441526n.isEmpty() == false) goto L8;
            return -1;
        L8:
            int r104 = Intrinsics.compare(r102.f441526n.size(), r103.f441526n.size());
            if (r104 != 0) goto L21;
            int r105 = r102.f441526n.size();
            int r106 = 0;
        L12:
            if (r106 >= r105) goto L21;
            r104 = f.f441592l.compare(ListProtector.get(r102.f441526n, r106), ListProtector.get(r103.f441526n, r106));
            if (r104 != 0) goto L21;
            r106 = r106 + 1;
        L21:
            return r104;
        }
    }

    public static final class l<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l<T> f441611a = null;

        static {
            f441611a = new l();
        }

        public l() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            TaskSectionData r102 = (TaskSectionData) r100;
            TaskSectionData r103 = (TaskSectionData) r101;
            if (TextUtils.isEmpty(r102.f441520h) == false) goto L8;
            if (TextUtils.isEmpty(r103.f441520h) == false) goto L8;
        L15:
            return 0;
        L8:
            if (TextUtils.isEmpty(r102.f441520h) == true) goto L13;
            if (TextUtils.isEmpty(r103.f441520h) == true) goto L13;
            return r102.f441520h.compareTo(r103.f441520h);
        L13:
            if (TextUtils.isEmpty(r102.f441520h) == false) goto L15;
            return 1;
        }
    }

    public static final class m<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m<T> f441612a = null;

        static {
            f441612a = new m();
        }

        public m() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            TaskSectionData r102 = (TaskSectionData) r100;
            TaskSectionData r103 = (TaskSectionData) r101;
            TaskSectionData.c r104 = r102.f441527o;
            int r105 = Integer.MAX_VALUE;
            if (r104 == null) goto L5;
            int r106 = r104.f441546h;
        L6:
            TaskSectionData.c r107 = r103.f441527o;
            if (r107 == null) goto L9;
            r105 = r107.f441546h;
        L9:
            int r108 = Intrinsics.compare(r106, r105);
            if (r108 != 0) goto L73;
            String r109 = "";
            if (Build.VERSION.SDK_INT < 24) goto L42;
            Collator r110 = Collator.getInstance(Locale.getDefault());
            int r111 = r110.compare(r102.f441516d, r103.f441516d);
            if (r111 != 0) goto L71;
            TaskSectionData.c r112 = r102.f441527o;
            if (r112 == null) goto L21;
            String r113 = r112.f441540b;
            if (r113 == null) goto L21;
        L22:
            TaskSectionData.c r114 = r103.f441527o;
            if (r114 == null) goto L26;
            String r115 = r114.f441540b;
            if (r115 == null) goto L26;
        L27:
            r111 = r110.compare(r113, r115);
            if (r111 != 0) goto L71;
            TaskSectionData.c r116 = r102.f441527o;
            if (r116 == null) goto L34;
            String r117 = r116.f441543e;
            if (r117 == null) goto L34;
        L35:
            TaskSectionData.c r118 = r103.f441527o;
            if (r118 == null) goto L72;
            String r119 = r118.f441543e;
            if (r119 == null) goto L72;
            r109 = r119;
        L72:
            return r110.compare(r117, r109);
        L34:
            r117 = "";
        L26:
            r115 = "";
        L21:
            r113 = "";
        L71:
            return r111;
        L42:
            int r120 = r102.f441516d.compareTo(r103.f441516d);
            if (r120 != 0) goto L74;
            TaskSectionData.c r121 = r102.f441527o;
            if (r121 == null) goto L49;
            String r122 = r121.f441540b;
            if (r122 == null) goto L49;
        L50:
            TaskSectionData.c r123 = r103.f441527o;
            if (r123 == null) goto L54;
            String r124 = r123.f441540b;
            if (r124 == null) goto L54;
        L55:
            int r125 = r122.compareTo(r124);
            if (r125 != 0) goto L75;
            TaskSectionData.c r126 = r102.f441527o;
            if (r126 == null) goto L62;
            String r127 = r126.f441543e;
            if (r127 == null) goto L62;
        L63:
            TaskSectionData.c r128 = r103.f441527o;
            if (r128 == null) goto L70;
            String r129 = r128.f441543e;
            if (r129 == null) goto L70;
            r109 = r129;
        L70:
            return r127.compareTo(r109);
        L62:
            r127 = "";
            goto L63
        L75:
            return r125;
        L54:
            r124 = "";
        L49:
            r122 = "";
            goto L50
        L74:
            return r120;
        L73:
            return r108;
        L5:
            r106 = Integer.MAX_VALUE;
            goto L6
        }
    }

    public static final class n<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n<T> f441613a = null;

        static {
            f441613a = new n();
        }

        public n() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            C5319f r102 = f.f441581a;
            return f.e(((TaskSectionData) r100).f441529q) - f.e(((TaskSectionData) r101).f441529q);
        }
    }

    public static final class o<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o<T> f441614a = null;

        static {
            f441614a = new o();
        }

        public o() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            Todo r102 = (Todo) r100;
            Todo r103 = (Todo) r101;
            C5319f r104 = f.f441581a;
            Intrinsics.checkNotNull(r102);
            Intrinsics.checkNotNull(r103);
            int r105 = f.d(r102, r103, true);
            if (r105 == 0) goto L6;
            return r105;
        L6:
            return f.f441581a.compare(r102, r103);
        }
    }

    public static final class p<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p<T> f441615a = null;

        static {
            f441615a = new p();
        }

        public p() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            Todo r102 = (Todo) r100;
            Todo r103 = (Todo) r101;
            C5319f r104 = f.f441581a;
            Intrinsics.checkNotNull(r102);
            Intrinsics.checkNotNull(r103);
            int r105 = f.d(r102, r103, false);
            if (r105 == 0) goto L6;
            return r105;
        L6:
            return f.f441581a.compare(r102, r103);
        }
    }

    public static final class q<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final q<T> f441616a = null;

        static {
            f441616a = new q();
        }

        public q() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            TodoUser r102 = (TodoUser) r100;
            TodoUser r103 = (TodoUser) r101;
            if (Build.VERSION.SDK_INT < 24) goto L5;
            int r104 = Collator.getInstance(Locale.getDefault()).compare(r102.name, r103.name);
        L6:
            if (r104 == 0) goto L9;
            return r104;
        L9:
            return r102.user_id.compareTo(r103.user_id);
        L5:
            r104 = r102.name.compareTo(r103.name);
            goto L6
        }
    }

    public static final class r<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final r<T> f441617a = null;

        static {
            f441617a = new r();
        }

        public r() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            Todo r102 = (Todo) r100;
            Todo r103 = (Todo) r101;
            C5319f r104 = f.f441581a;
            Intrinsics.checkNotNull(r102);
            Intrinsics.checkNotNull(r103);
            int r105 = f.f(r102, r103, true);
            if (r105 == 0) goto L6;
            return r105;
        L6:
            return f.f441581a.compare(r102, r103);
        }
    }

    public static final class s<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final s<T> f441618a = null;

        static {
            f441618a = new s();
        }

        public s() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            Todo r102 = (Todo) r100;
            Todo r103 = (Todo) r101;
            C5319f r104 = f.f441581a;
            Intrinsics.checkNotNull(r102);
            Intrinsics.checkNotNull(r103);
            int r105 = f.f(r102, r103, false);
            if (r105 == 0) goto L6;
            return r105;
        L6:
            return f.f441581a.compare(r102, r103);
        }
    }

    public f() {
    }

    static {
        int r100 = g.f441606a;
        f441581a = C5319f.f441605a;
        f441582b = h.f441607a;
        f441583c = i.f441608a;
        f441584d = o.f441614a;
        f441585e = p.f441615a;
        f441586f = d.f441603a;
        f441587g = e.f441604a;
        f441588h = r.f441617a;
        f441589i = s.f441618a;
        f441590j = b.f441601a;
        f441591k = c.f441602a;
        f441592l = q.f441616a;
        f441593m = j.f441609a;
        f441594n = n.f441613a;
        f441595o = k.f441610a;
        f441596p = m.f441612a;
        f441597q = l.f441611a;
    }

    public static final int c(DueTimeGroupCategory r100) {
        int r101 = a.f441599b[r100.ordinal()];
        if (r101 != 1) goto L5;
        return 0;
    L5:
        if (r101 != 2) goto L7;
        return 1;
    L7:
        if (r101 != 3) goto L9;
        return 2;
    L9:
        if (r101 != 4) goto L11;
        return 3;
    L11:
        if (r101 == 5) goto L13;
        return Integer.MAX_VALUE;
    L13:
        return 4;
    }

    public static final int e(StartTimeGroupCategory r100) {
        int r101 = a.f441600c[r100.ordinal()];
        if (r101 != 1) goto L5;
        return 0;
    L5:
        if (r101 != 2) goto L7;
        return 1;
    L7:
        if (r101 != 3) goto L9;
        return 2;
    L9:
        if (r101 != 4) goto L11;
        return 3;
    L11:
        if (r101 == 5) goto L13;
        return Integer.MAX_VALUE;
    L13:
        return 4;
    }

    public static final int a(Todo r100, Todo r101, boolean r102) {
        if (r100.display_completed_milli_time.longValue() <= r101.display_completed_milli_time.longValue()) goto L6;
        int r103 = 1;
    L9:
        if (r102 == false) goto L11;
        return r103;
    L11:
        return r103 * (-1);
    L6:
        if (r100.display_completed_milli_time.longValue() >= r101.display_completed_milli_time.longValue()) goto L8;
        r103 = -1;
        goto L9
    L8:
        r103 = 0;
        goto L9
    }

    public static final int b(Todo r110, Todo r111, boolean r112) {
        Long r100 = r110.due_time;
        int r101 = 0;
        long r102 = 0;
        if (r100 != null) goto L6;
    L13:
        Long r103 = r110.due_time;
        if (r103 != null) goto L17;
    L19:
        Long r104 = r111.due_time;
        if (r104 == null) goto L26;
        if (r104.longValue() != 0) goto L26;
        return -1;
    L26:
        if (Intrinsics.areEqual(r110.is_all_day, r111.is_all_day) == false) goto L41;
        Long r113 = r110.due_time;
        if (r113 == null) goto L30;
        long r105 = r113.longValue();
    L31:
        Long r114 = r111.due_time;
        if (r114 == null) goto L34;
        long r115 = r114.longValue();
    L35:
        long r106 = r105 - r115;
        if (r106 <= 0) goto L38;
    L37:
        r101 = 1;
    L69:
        if (r112 == false) goto L71;
        return r101;
    L71:
        return r101 * (-1);
    L38:
        if (r106 == 0) goto L69;
    L40:
        r101 = -1;
        goto L69
    L34:
        r115 = 0;
        goto L35
    L30:
        r105 = 0;
        goto L31
    L41:
        Long r107 = r110.due_time;
        if (r107 == null) goto L44;
        long r108 = r107.longValue();
    L45:
        Long r109 = r111.due_time;
        if (r109 == null) goto L48;
        r102 = r109.longValue();
    L48:
        String r116 = r110.due_timezone;
        String r117 = "";
        if (r116 != null) goto L51;
        r116 = "";
    L51:
        TimeZone r118 = TimeZone.getTimeZone(r116);
        String r119 = r111.due_timezone;
        if (r119 == null) goto L55;
        r117 = r119;
    L55:
        TimeZone r120 = TimeZone.getTimeZone(r117);
        int r121 = com.ss.android.lark.todo.impl.utils.c.f444278a;
        long r122 = 1000;
        Intrinsics.checkNotNull(r118);
        int r123 = com.ss.android.lark.todo.impl.utils.c.c(r108 * r122, r118);
        Intrinsics.checkNotNull(r120);
        int r124 = r123 - com.ss.android.lark.todo.impl.utils.c.c(r102 * r122, r120);
        if (r124 > 0) goto L37;
        if (r124 != 0) goto L40;
        if (r110.is_all_day.booleanValue() == false) goto L65;
        if (r111.is_all_day.booleanValue() == false) goto L37;
    L65:
        if (r110.is_all_day.booleanValue() == true) goto L69;
        if (r111.is_all_day.booleanValue() == false) goto L69;
    L44:
        r108 = 0;
        goto L45
    L17:
        if (r103.longValue() != 0) goto L19;
        return 1;
    L6:
        if (r100.longValue() != 0) goto L13;
        Long r125 = r111.due_time;
        if (r125 == null) goto L13;
        if (r125.longValue() != 0) goto L13;
        return 0;
    }

    public static final int d(Todo r110, Todo r111, boolean r112) {
        Long r100 = r110.start_milli_time;
        int r101 = 0;
        long r102 = 0;
        if (r100 != null) goto L6;
    L13:
        Long r103 = r110.start_milli_time;
        if (r103 != null) goto L17;
    L19:
        Long r104 = r111.start_milli_time;
        if (r104 == null) goto L26;
        if (r104.longValue() != 0) goto L26;
        return -1;
    L26:
        if (Intrinsics.areEqual(r110.is_all_day, r111.is_all_day) == false) goto L41;
        Long r113 = r110.start_milli_time;
        if (r113 == null) goto L30;
        long r105 = r113.longValue();
    L31:
        Long r114 = r111.start_milli_time;
        if (r114 == null) goto L34;
        long r115 = r114.longValue();
    L35:
        long r106 = r105 - r115;
        if (r106 <= 0) goto L38;
    L37:
        r101 = 1;
    L69:
        if (r112 == false) goto L71;
        return r101;
    L71:
        return r101 * (-1);
    L38:
        if (r106 == 0) goto L69;
    L40:
        r101 = -1;
        goto L69
    L34:
        r115 = 0;
        goto L35
    L30:
        r105 = 0;
        goto L31
    L41:
        Long r107 = r110.start_milli_time;
        if (r107 == null) goto L44;
        long r108 = r107.longValue();
    L45:
        Long r109 = r111.start_milli_time;
        if (r109 == null) goto L48;
        r102 = r109.longValue();
    L48:
        String r116 = r110.due_timezone;
        String r117 = "";
        if (r116 != null) goto L51;
        r116 = "";
    L51:
        TimeZone r118 = TimeZone.getTimeZone(r116);
        String r119 = r111.due_timezone;
        if (r119 == null) goto L55;
        r117 = r119;
    L55:
        TimeZone r120 = TimeZone.getTimeZone(r117);
        int r121 = com.ss.android.lark.todo.impl.utils.c.f444278a;
        Intrinsics.checkNotNull(r118);
        int r122 = com.ss.android.lark.todo.impl.utils.c.c(r108, r118);
        Intrinsics.checkNotNull(r120);
        int r123 = r122 - com.ss.android.lark.todo.impl.utils.c.c(r102, r120);
        if (r123 > 0) goto L37;
        if (r123 != 0) goto L40;
        if (r110.is_all_day.booleanValue() == false) goto L65;
        if (r111.is_all_day.booleanValue() == false) goto L37;
    L65:
        if (r110.is_all_day.booleanValue() == true) goto L69;
        if (r111.is_all_day.booleanValue() == false) goto L69;
    L44:
        r108 = 0;
        goto L45
    L17:
        if (r103.longValue() != 0) goto L19;
        return 1;
    L6:
        if (r100.longValue() != 0) goto L13;
        Long r124 = r111.start_milli_time;
        if (r124 == null) goto L13;
        if (r124.longValue() != 0) goto L13;
        return 0;
    }

    public static final int f(Todo r100, Todo r101, boolean r102) {
        Long r103 = r100.update_milli_time;
        if (r103 != null) goto L6;
    L8:
        Long r104 = r100.update_milli_time;
    L9:
        Long r105 = r101.update_milli_time;
        if (r105 != null) goto L13;
    L15:
        Long r106 = r101.update_milli_time;
    L17:
        if (r104.longValue() <= r106.longValue()) goto L20;
        int r107 = 1;
    L23:
        if (r102 == false) goto L25;
        return r107;
    L25:
        return r107 * (-1);
    L20:
        if (r104.longValue() >= r106.longValue()) goto L22;
        r107 = -1;
        goto L23
    L22:
        r107 = 0;
        goto L23
    L13:
        if (r105.longValue() != 0) goto L15;
        r106 = r101.create_milli_time;
        goto L17
    L6:
        if (r103.longValue() != 0) goto L8;
        r104 = r100.create_milli_time;
        goto L9
    }

    public static int g(Todo r100, Todo r101, boolean r102) {
        if (r100.create_milli_time.longValue() <= r101.create_milli_time.longValue()) goto L6;
        int r103 = 1;
    L9:
        if (r102 == false) goto L11;
        return r103;
    L11:
        return r103 * (-1);
    L6:
        if (r100.create_milli_time.longValue() >= r101.create_milli_time.longValue()) goto L8;
        r103 = -1;
        goto L9
    L8:
        r103 = 0;
        goto L9
    }

    public static Comparator h(TaskFieldType r100, Map r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "sortFieldType");
        Intrinsics.checkNotNullParameter(r101, "taskRank");
        switch(a.f441598a[r100.ordinal()]) {
            case 1: goto L21;
            case 2: goto L18;
            case 3: goto L15;
            case 4: goto L12;
            case 5: goto L9;
            case 6: goto L5;
            default: goto L25;
        };
    L5:
        Intrinsics.checkNotNullParameter(r101, "rankMap");
        if (r102 == false) goto L27;
        return new com.ss.android.lark.todo.impl.features.center.v3.g(r101);
    L27:
        return new com.ss.android.lark.todo.impl.features.center.v3.h(r101);
    L9:
        if (r102 == false) goto L29;
        return f441584d;
    L29:
        return f441585e;
    L12:
        if (r102 == false) goto L31;
        return f441582b;
    L31:
        return f441583c;
    L15:
        if (r102 == false) goto L33;
        return f441586f;
    L33:
        return f441587g;
    L18:
        if (r102 == false) goto L35;
        return f441588h;
    L35:
        return f441589i;
    L21:
        if (r102 == false) goto L24;
        return f441590j;
    L24:
        return f441591k;
    L25:
        return f441581a;
    }
}
