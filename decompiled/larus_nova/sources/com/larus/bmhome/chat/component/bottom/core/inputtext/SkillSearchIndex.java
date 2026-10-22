package com.larus.bmhome.chat.component.bottom.core.inputtext;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: classes25.dex */
public final class SkillSearchIndex {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f298680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap<c, b> f298681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f298682c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f298683d;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p1 f298684a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final p1 f298685b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f298684a, r101.f298684a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f298685b, r101.f298685b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f298684a.hashCode() * 31) + this.f298685b.hashCode();
        }

        public final String toString() {
            return "Entry(title=" + this.f298684a + ", description=" + this.f298685b + ')';
        }

        public b(p1 r100, p1 r101) {
            Intrinsics.checkNotNullParameter(r100, "title");
            Intrinsics.checkNotNullParameter(r101, "description");
            this.f298684a = r100;
            this.f298685b = r101;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f298686a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f298687b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f298688c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f298686a, r101.f298686a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f298687b, r101.f298687b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f298688c, r101.f298688c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f298686a.hashCode() * 31) + this.f298687b.hashCode()) * 31) + this.f298688c.hashCode();
        }

        public final String toString() {
            return "Key(skillId=" + this.f298686a + ", name=" + this.f298687b + ", description=" + this.f298688c + ')';
        }

        public c(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "skillId");
            Intrinsics.checkNotNullParameter(r101, "name");
            Intrinsics.checkNotNullParameter(r102, "description");
            this.f298686a = r100;
            this.f298687b = r101;
            this.f298688c = r102;
        }
    }

    static {
    }

    public final void a() {
        Object r100 = this.f298680a;
        monitor-enter(r100);
        this.f298681b.clear();     // Catch: Throwable -> L7
        this.f298682c = null;     // Catch: Throwable -> L7
        this.f298683d++;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public SkillSearchIndex() {
        this.f298680a = new Object();
        this.f298681b = new LinkedHashMap(16, 0.75f, true);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x011d -> B:66:0x01ad). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x016a -> B:53:0x016f). Please report as a decompilation issue!!! */
    public final Object b(String r110, List<be8.b> r210, String r211, Continuation<? super List<t1>> r212) {
        if ((r212 instanceof SkillSearchIndex$search$1) == false) goto L7;
        SkillSearchIndex$search$1 r100 = (SkillSearchIndex$search$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        long r105 = r100.J$0;
        p1 r106 = (p1) r100.L$7;
        c r107 = (c) r100.L$6;
        be8.b r111 = (be8.b) r100.L$5;
        Iterator<be8.b> r112 = (Iterator) r100.L$4;
        List r113 = (List) r100.L$3;
        List r114 = (List) r100.L$2;
        String r115 = (String) r100.L$1;
        CoroutineContext r116 = (CoroutineContext) r100.L$0;
        ResultKt.throwOnFailure(r102);
        Object r108 = r102;
        SkillSearchIndex r109 = this;
    L53:
        b r117 = new b(r106, (p1) r108);
        Object r118 = r109.f298680a;
        monitor-enter(r118);
        if (r109.f298683d != r105) goto L60;
        r109.f298681b.put(r107, r117);     // Catch: Throwable -> L63
        if (r109.f298681b.size() <= 1000) goto L60;
        Iterator<Map.Entry<c, b>> r119 = r109.f298681b.entrySet().iterator();     // Catch: Throwable -> L63
        r119.next();     // Catch: Throwable -> L63
        r119.remove();     // Catch: Throwable -> L63
    L60:
        Unit r120 = Unit.INSTANCE;     // Catch: Throwable -> L63
        monitor-exit(r118);
        List r121 = r114;
        String r122 = r115;
        be8.b r123 = r111;
        long r124 = r105;
        List r125 = r113;
        SkillSearchIndex r126 = r109;
        CoroutineContext r127 = r116;
        b r128 = r117;
    L66:
        int r129 = u1.f299238a;
        List r130 = u1.c(r128.f298684a, r122);
        List r131 = u1.c(r128.f298685b, r122);
        if ((!r130.isEmpty()) == false) goto L69;
    L70:
        r125.add(new t1(r123, r130, r131));
    L25:
        if (r112.hasNext() == false) goto L76;
        r123 = r112.next();
        JobKt.ensureActive(r127);
        if (r122.length() != 0) goto L29;
        boolean r132 = true;
    L30:
        if (r132 == false) goto L32;
        r125.add(new t1(r123, CollectionsKt.emptyList(), CollectionsKt.emptyList()));
        goto L25
    L32:
        c r133 = new c(r123.f18744a, r123.f18745b, r123.f18747d);
        Object r134 = r126.f298680a;
        monitor-enter(r134);
        b r135 = r126.f298681b.get(r133);     // Catch: Throwable -> L72
        b r136 = r135;     // Catch: Throwable -> L72
        if (r126.f298683d != r124) goto L37;
        boolean r137 = true;
    L39:
        if (r137 == false) goto L41;
        b r138 = r135;
    L42:
        r128 = r138;     // Catch: Throwable -> L72
        monitor-exit(r134);
        if (r128 != null) goto L66;
        int r139 = p1.f299015f;
        String r140 = r123.f18745b;
        r100.L$0 = r127;
        r100.L$1 = r122;
        r100.L$2 = r121;
        r100.L$3 = r125;
        r100.L$4 = r112;
        r100.L$5 = r123;
        r100.L$6 = r133;
        r100.L$7 = null;
        r100.J$0 = r124;
        r100.label = 1;
        p1 r141 = p1.a.a(r140, r100);
        if (r141 != r103) goto L48;
        return r103;
    L48:
        r115 = r122;
        r116 = r127;
        r102 = r141;
        SkillSearchIndex r142 = r126;
        r113 = r125;
        r105 = r124;
        r111 = r123;
        r114 = r121;
        r107 = r133;
    L49:
        p1 r143 = (p1) r102;
        int r144 = p1.f299015f;
        String r145 = r111.f18747d;
        r100.L$0 = r116;
        r100.L$1 = r115;
        r100.L$2 = r114;
        r100.L$3 = r113;
        r100.L$4 = r112;
        r100.L$5 = r111;
        r100.L$6 = r107;
        r100.L$7 = r143;
        r100.J$0 = r105;
        r100.label = 2;
        r108 = p1.a.a(r145, r100);
        if (r108 != r103) goto L52;
        return r103;
    L52:
        r109 = r142;
        r106 = r143;
        goto L53
    L41:
        r138 = null;
        goto L42
    L37:
        r137 = false;
    L72:
        th = move-exception;
        throw th;
    L29:
        r132 = false;
        goto L30
    L76:
        return CollectionsKt.build(r121);
    L69:
        if ((!r131.isEmpty()) == false) goto L25;
    L63:
        th = move-exception;
        throw th;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r105 = r100.J$0;
        c r146 = (c) r100.L$6;
        be8.b r147 = (be8.b) r100.L$5;
        Iterator<be8.b> r148 = (Iterator) r100.L$4;
        List r149 = (List) r100.L$3;
        List r150 = (List) r100.L$2;
        String r151 = (String) r100.L$1;
        CoroutineContext r152 = (CoroutineContext) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r116 = r152;
        r115 = r151;
        r114 = r150;
        r113 = r149;
        r112 = r148;
        r111 = r147;
        r107 = r146;
        r142 = this;
        goto L49
    L16:
        ResultKt.throwOnFailure(r102);
        r127 = r100.getContext();
        JobKt.ensureActive(r127);
        Object r153 = this.f298680a;
        monitor-enter(r153);
    L77:
        th = move-exception;
        throw th;
    L19:
        if (Intrinsics.areEqual(this.f298682c, r110) == true) goto L21;
        this.f298681b.clear();     // Catch: Throwable -> L77
        this.f298682c = r110;     // Catch: Throwable -> L77
        this.f298683d++;     // Catch: Throwable -> L77
    L21:
        long r154 = this.f298683d;     // Catch: Throwable -> L77
        monitor-exit(r153);
        r122 = StringsKt.trim(r211).toString();
        r121 = CollectionsKt.createListBuilder();
        r126 = this;
        r112 = r210.iterator();
        r124 = r154;
        r125 = r121;
    L7:
        r100 = new SkillSearchIndex$search$1(this, r212);
        goto L8
    }
}
