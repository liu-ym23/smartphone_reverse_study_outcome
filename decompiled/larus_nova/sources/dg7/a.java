package dg7;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xf7.m;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements yf7.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final yf7.b f468515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f468516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f468517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<rgc.c.d<Void>> f468518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<rgc.c.d<Void>> f468519e;

    /* JADX INFO: renamed from: dg7.a$a, reason: collision with other inner class name */
    public class C5666a implements rgc.c.d<tgc.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f468520a;

        public C5666a(a r100) {
            this.f468520a = r100;
        }

        @Override // rgc.c.d
        public final /* bridge */ /* synthetic */ void a(tgc.c r100) {
            onCall(r100);
        }

        public void onCall(tgc.c r100) {
            a.M(this.f468520a, true);
        }
    }

    public class b implements rgc.c.d<tgc.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f468521a;

        public b(a r100) {
            this.f468521a = r100;
        }

        @Override // rgc.c.d
        public final /* bridge */ /* synthetic */ void a(tgc.a r100) {
            onCall(r100);
        }

        public void onCall(tgc.a r100) {
            a.M(this.f468521a, true);
        }
    }

    public class c implements rgc.c.d<tgc.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f468522a;

        public c(a r100) {
            this.f468522a = r100;
        }

        @Override // rgc.c.d
        public final /* bridge */ /* synthetic */ void a(tgc.b r100) {
            onCall(r100);
        }

        public void onCall(tgc.b r100) {
            a.M(this.f468522a, false);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f468523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f468524b;

        public final int hashCode() {
            String r100 = this.f468523a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f468524b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L8;
        L25:
            return false;
        L8:
            if (d.class != r100.getClass()) goto L25;
            d r101 = (d) r100;
            String r102 = this.f468523a;
            if (r102 == null) goto L16;
            if (r102.equals(r101.f468523a) == false) goto L17;
        L18:
            String r103 = this.f468524b;
            String r104 = r101.f468524b;
            if (r103 != null) goto L26;
            if (r104 == null) goto L27;
            return false;
        L27:
            return true;
        L26:
            return r103.equals(r104);
        L17:
            return false;
        L16:
            if (r101.f468523a == null) goto L18;
            goto L17
        }

        public d(String r100, String r101) {
            this.f468523a = r100;
            this.f468524b = r101;
        }
    }

    @Override // yf7.c
    public final void E() {
        yf7.b r100 = this.f468515a;
        C5666a r101 = new C5666a(this);
        ((dg7.b) r100).getClass();
        rgc.c.b(null, r101);
        yf7.b r102 = this.f468515a;
        b r103 = new b(this);
        ((dg7.b) r102).getClass();
        rgc.c.b(null, r103);
        yf7.b r104 = this.f468515a;
        c r105 = new c(this);
        ((dg7.b) r104).getClass();
        rgc.c.b(null, r105);
    }

    @Override // yf7.c
    public final d getDeviceInfo() {
        String r100 = this.f468517c;
        String r101 = null;
        if (TextUtils.isEmpty(r100) == false) goto L8;
        SharedPreferences r102 = cg7.b.c(this.f468516b).f23677c.b(new Object[0]);
        if (r102 == null) goto L7;
        r100 = r102.getString("device_id", null);
        goto L8
    L7:
        r100 = null;
    L8:
        ((dg7.b) this.f468515a).getClass();
        sgc.a r103 = (sgc.a) rgc.b.a(sgc.a.class);
        if (r103 == null) goto L13;
        r101 = r103.getSecUid();
    L13:
        if (TextUtils.isEmpty(r101) == false) goto L16;
        r101 = "0";
    L16:
        return new d(r100, r101);
    }

    @Override // yf7.c
    public final void k0(String r100) {
        this.f468517c = r100;
        SharedPreferences r101 = cg7.b.c(this.f468516b).f23677c.b(new Object[0]);
        if (r101 == null) goto L5;
        r101.edit().putString("device_id", r100).apply();
    L6:
        monitor-enter(this);
        Iterator r102 = ((ArrayList) this.f468519e).iterator();     // Catch: Throwable -> L15
    L9:
        if (r102.hasNext() == false) goto L13;
        rgc.c.d r103 = (rgc.c.d) r102.next();     // Catch: Throwable -> L15
        if (r103 == null) goto L9;
        r103.a(null);     // Catch: Throwable -> L15
        goto L9
    L13:
        monitor-exit(this);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    L5:
        zf7.b.b("sp is null when save did " + r100);
        goto L6
    }

    @Override // yf7.c
    public final void x0(com.bytedance.sync.v2.d.a r100) {
        monitor-enter(this);
        ((ArrayList) this.f468518d).remove(r100);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // yf7.c
    public final void y(rgc.c.d<Void> r100) {
        monitor-enter(this);
        ((ArrayList) this.f468518d).add(r100);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public a(Context r100, yf7.b r101) {
        this.f468518d = new ArrayList();
        this.f468519e = new ArrayList();
        this.f468516b = r100;
        this.f468515a = r101;
    }

    public static void M(a r100, boolean r101) {
        monitor-enter(r100);
        Iterator r102 = ((ArrayList) r100.f468518d).iterator();     // Catch: Throwable -> L12
    L5:
        if (r102.hasNext() == false) goto L9;
        rgc.c.d r103 = (rgc.c.d) r102.next();     // Catch: Throwable -> L12
        if (r103 == null) goto L5;
        r103.a(null);     // Catch: Throwable -> L12
        goto L5
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L12
        m.c().a(r101);
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
