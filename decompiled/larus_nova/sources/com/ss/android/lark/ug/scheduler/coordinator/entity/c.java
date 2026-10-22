package com.ss.android.lark.ug.scheduler.coordinator.entity;

import com.bytedance.lark.pb.ugreach.v1.ReachPointConfig;
import com.bytedance.lark.pb.ugreach.v1.ReachPointEntity;
import com.bytedance.lark.pb.ugreach.v1.ReachPointRelation;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c extends DAGraph.b {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f444485r = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f444486e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReachPointEntity f444487f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f444488g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f444489h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f444490i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f444491j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f444492k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f444493l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public DefenseStrategy f444494m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Set<String> f444495n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f444496o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f444497p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f444498q;

    public static final class a {
        @JvmStatic
        public static c a(ReachPointEntity r100, List r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "reachPointEntity");
            Intrinsics.checkNotNullParameter(r101, "shareScenarioIds");
            c r103 = new c(r100.reach_point_id);
            r103.f444487f = r100;
            String r104 = r100.scenario_id;
            Intrinsics.checkNotNullParameter(r104, "<set-?>");
            r103.f444488g = r104;
            r103.f444491j = r102;
            r103.f444495n.addAll(r101);
            ReachPointConfig r105 = r100.config;
            boolean r106 = false;
            if (r105 == null) goto L9;
            ReachPointRelation r107 = r105.relation;
            if (r107 == null) goto L9;
            Integer r108 = r107.ttl;
            if (r108 == null) goto L9;
            int r109 = r108.intValue();
        L10:
            r103.f444489h = r109;
            ReachPointConfig r110 = r100.config;
            if (r110 == null) goto L17;
            ReachPointRelation r111 = r110.relation;
            if (r111 == null) goto L17;
            Boolean r112 = r111.is_conflict;
            if (r112 == null) goto L17;
            boolean r113 = r112.booleanValue();
        L18:
            r103.f444490i = r113;
            ReachPointConfig r114 = r100.config;
            if (r114 == null) goto L25;
            ReachPointRelation r115 = r114.relation;
            if (r115 == null) goto L25;
            Integer r116 = r115.priority;
            if (r116 == null) goto L25;
            int r117 = r116.intValue();
        L26:
            r103.f444492k = r117;
            ReachPointConfig r118 = r100.config;
            if (r118 == null) goto L33;
            ReachPointRelation r119 = r118.relation;
            if (r119 == null) goto L33;
            Boolean r120 = r119.need_grab;
            if (r120 == null) goto L33;
            boolean r121 = r120.booleanValue();
        L34:
            r103.f444493l = r121;
            DefenseStrategy.a r122 = DefenseStrategy.Companion;
            ReachPointConfig r123 = r100.config;
            String r124 = null;
            if (r123 == null) goto L39;
            ReachPointRelation r125 = r123.relation;
            if (r125 == null) goto L39;
            ReachPointRelation.DefenseStrategy r126 = r125.defense_strategy;
        L40:
            r122.getClass();
            if (r126 != null) goto L43;
            DefenseStrategy r127 = DefenseStrategy.UNKNOWN;
        L50:
            Intrinsics.checkNotNullParameter(r127, "<set-?>");
            r103.f444494m = r127;
            ReachPointConfig r128 = r100.config;
            if (r128 == null) goto L55;
            ReachPointRelation r129 = r128.relation;
            if (r129 == null) goto L55;
            r124 = r129.parent_id;
        L55:
            r103.f444498q = r124;
            if (r124 != null) goto L58;
        L59:
            r106 = true;
        L60:
            if (r106 == true) goto L62;
            Set<String> r130 = r103.f444474b;
            String r131 = r103.f444498q;
            Intrinsics.checkNotNull(r131);
            r130.add(r131);
        L62:
            ReachPointConfig r132 = r100.config;
            if (r132 == null) goto L69;
            ReachPointRelation r133 = r132.relation;
            if (r133 == null) goto L69;
            List<String> r134 = r133.child_ids;
            if (r134 == null) goto L69;
            r103.f444475c.addAll(r134);
        L69:
            return r103;
        L58:
            if (r124.length() != 0) goto L60;
        L43:
            int r135 = DefenseStrategy.a.C5365a.f444479a[r126.ordinal()];
            if (r135 != 1) goto L46;
            r127 = DefenseStrategy.GIVE_UP;
            goto L50
        L46:
            if (r135 == 2) goto L48;
            r127 = DefenseStrategy.UNKNOWN;
            goto L50
        L48:
            r127 = DefenseStrategy.ROUND_ABORT;
        L39:
            r126 = null;
        L33:
            r121 = false;
        L25:
            r117 = 0;
        L17:
            r113 = false;
        L9:
            r109 = 0;
            goto L10
        }
    }

    static {
    }

    public final c a() {
        c r100 = new c(this.f444486e);
        r100.f444487f = this.f444487f;
        r100.f444488g = this.f444488g;
        r100.f444491j = this.f444491j;
        r100.f444496o = this.f444496o;
        r100.f444489h = this.f444489h;
        r100.f444490i = this.f444490i;
        r100.f444492k = this.f444492k;
        r100.f444493l = this.f444493l;
        r100.f444494m = this.f444494m;
        r100.f444498q = this.f444498q;
        r100.f444474b.addAll(this.f444474b);
        r100.f444475c.addAll(this.f444475c);
        r100.f444495n.addAll(this.f444495n);
        return r100;
    }

    public c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reachPointId");
        super(r100);
        this.f444486e = r100;
        this.f444488g = "";
        this.f444494m = DefenseStrategy.GIVE_UP;
        this.f444495n = new LinkedHashSet();
        Set<String> r101 = this.f444474b;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        String r103 = null;
    L12:
        this.f444498q = r103;
        return;
    L11:
        r103 = (String) CollectionsKt.first(this.f444474b);
        goto L12
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }
}
