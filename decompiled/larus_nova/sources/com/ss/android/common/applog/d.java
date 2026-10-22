package com.ss.android.common.applog;

import java.util.LinkedList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile d f408083b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<a> f408084a;

    /* JADX INFO: loaded from: classes34.dex */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f408085a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f408086b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f408087c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f408088d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f408089e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f408090f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final JSONObject f408091g;

        public a(String r100, String r101, String r102, long r103, long r104, boolean r105, JSONObject r106) {
            this.f408085a = r100;
            this.f408086b = r101;
            this.f408087c = r102;
            this.f408088d = r103;
            this.f408089e = r104;
            this.f408090f = r105;
            this.f408091g = r106;
        }
    }

    public static d a() {
        if (f408083b != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f408083b != null) goto L9;
        f408083b = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f408083b;
    }

    public d() {
        this.f408084a = new LinkedList();
    }
}
