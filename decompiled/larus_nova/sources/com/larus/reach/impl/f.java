package com.larus.reach.impl;

import com.larus.platform.api.ExternalRouteLaunchMode;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReachInappPushPuller f367200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f367201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap<String, b> f367202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashSet<String> f367203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f367204e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f367205f;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes31.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f367206a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ReachInappPushBizScenePage f367207b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f367208c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f367206a, r101.f367206a) == true) goto L12;
            return false;
        L12:
            if (this.f367207b == r101.f367207b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f367208c, r101.f367208c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f367206a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = ((r102 * 31) + this.f367207b.hashCode()) * 31;
            String r104 = this.f367208c;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "PendingPull(sessionId=" + this.f367206a + ", scene=" + this.f367207b + ", schema=" + this.f367208c + ')';
        }

        public b(String r100, ReachInappPushBizScenePage r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "scene");
            this.f367206a = r100;
            this.f367207b = r101;
            this.f367208c = r102;
        }
    }

    /* JADX INFO: loaded from: classes31.dex */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f367209a = null;

        static {
            int[] r100 = new int[ExternalRouteLaunchMode.values().length];
            r100[ExternalRouteLaunchMode.COLD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[ExternalRouteLaunchMode.HOT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[ExternalRouteLaunchMode.WARM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[ExternalRouteLaunchMode.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f367209a = r100;
        }
    }

    static {
    }

    public f(ReachInappPushPuller r100) {
        Intrinsics.checkNotNullParameter(r100, "puller");
        this.f367200a = r100;
        this.f367201b = new Object();
        this.f367202c = new LinkedHashMap();
        this.f367203d = new LinkedHashSet();
    }

    public final void b(String r100) {
        this.f367203d.add(r100);
    L4:
        if (this.f367203d.size() <= 32) goto L9;
        String r101 = (String) CollectionsKt.firstOrNull(this.f367203d);
        if (r101 == null) goto L7;
        this.f367203d.remove(r101);
        goto L4
    L7:
        return;
    }

    public final void a(String r100, b r101) {
        this.f367202c.put(r100, r101);
    L4:
        if (this.f367202c.size() <= 4) goto L21;
        Iterator<T> r102 = this.f367202c.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L14;
        Object r103 = r102.next();
        if (((b) ((Map.Entry) r103).getValue()).f367207b != ReachInappPushBizScenePage.HOT_START) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L7;
    L15:
        Map.Entry r105 = (Map.Entry) r103;
        if (r105 != null) goto L20;
        r105 = (Map.Entry) CollectionsKt.firstOrNull(this.f367202c.entrySet());
        if (r105 != null) goto L20;
        return;
    L20:
        this.f367202c.remove(r105.getKey());
        b((String) r105.getKey());
        FLogger.f375446a.w("ReachInappPushLaunch", "drop pending external launch, reason=queue_overflow");
        goto L4
    L11:
        r104 = false;
        goto L12
    L14:
        r103 = null;
        goto L15
    }
}
