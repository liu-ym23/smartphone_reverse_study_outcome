package com.larus.dora.impl.network;

import com.larus.platform.api.p2;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes4.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f336164a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static p2 f336165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CopyOnWriteArraySet<a> f336166c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CopyOnWriteArraySet<b> f336167d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f336168e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final j f336169f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final k f336170g = null;

    public interface a {
        void a(DoraMessage r100);
    }

    public interface b {
        void onStatusChanged(int r100, int r101);
    }

    public l() {
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.dora.impl.network.j] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.dora.impl.network.k] */
    static {
        f336164a = new l();
        f336166c = new CopyOnWriteArraySet();
        f336167d = new CopyOnWriteArraySet();
        f336169f = new j();
        f336170g = new k();
    }
}
