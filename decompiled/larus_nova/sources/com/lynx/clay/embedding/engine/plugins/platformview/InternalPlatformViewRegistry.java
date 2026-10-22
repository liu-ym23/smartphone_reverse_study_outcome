package com.lynx.clay.embedding.engine.plugins.platformview;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import n5a.c;
import n5a.d;
import n5a.e;
import n5a.f;

/* JADX INFO: loaded from: classes32.dex */
public final class InternalPlatformViewRegistry {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final InternalPlatformViewRegistry f380842e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, c> f380843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, c> f380844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<String> f380845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<String> f380846d;

    public static final enum ViewDrawType extends Enum<ViewDrawType> {
        public static final ViewDrawType DRAWABLE = null;
        public static final ViewDrawType LOGICAL_ONLY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ViewDrawType[] f380847a = null;

        static {
            ViewDrawType r100 = new ViewDrawType("DRAWABLE", 0);
            DRAWABLE = r100;
            ViewDrawType r101 = new ViewDrawType("LOGICAL_ONLY", 1);
            LOGICAL_ONLY = r101;
            f380847a = new ViewDrawType[]{r100, r101};
        }

        public static ViewDrawType[] values() {
            return (ViewDrawType[]) f380847a.clone();
        }

        public static ViewDrawType valueOf(String r100) {
            return (ViewDrawType) r27.a.a(ViewDrawType.class, r100);
        }

        public ViewDrawType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final synchronized void a() {
        monitor-enter(this);
        monitor-exit(this);
    }

    static {
        f380842e = new InternalPlatformViewRegistry();
    }

    public InternalPlatformViewRegistry() {
        this.f380843a = new LinkedHashMap();
        this.f380844b = new LinkedHashMap();
        new LinkedHashMap();
        new LinkedHashMap();
        this.f380845c = new LinkedHashSet();
        this.f380846d = new LinkedHashSet();
        b("input-view", new d());
        b("textarea-view", new e());
        b("x-input", new d());
        b("x-textarea", new e());
        b("x-map-marker-ng", new f());
    }

    public final synchronized void b(String r100, c r101) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (r100.isEmpty() == true) goto L8;
        this.f380843a.put(r100, r101);     // Catch: Throwable -> L10
        this.f380845c.add(r100);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L8:
        monitor-exit(this);
    }
}
