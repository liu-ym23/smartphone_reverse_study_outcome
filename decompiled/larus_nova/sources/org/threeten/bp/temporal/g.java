package org.threeten.bp.temporal;

import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;

/* JADX INFO: loaded from: classes41.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f526468a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f526469b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f526470c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f526471d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f526472e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f526473f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C7101g f526474g = null;

    public static class a implements h<ZoneId> {
        public a() {
        }

        @Override // org.threeten.bp.temporal.h
        public final ZoneId a(org.threeten.bp.temporal.b r100) {
            return (ZoneId) r100.query(this);
        }
    }

    public static class b implements h<org.threeten.bp.chrono.e> {
        public b() {
        }

        @Override // org.threeten.bp.temporal.h
        public final org.threeten.bp.chrono.e a(org.threeten.bp.temporal.b r100) {
            return (org.threeten.bp.chrono.e) r100.query(this);
        }
    }

    public static class c implements h<i> {
        public c() {
        }

        @Override // org.threeten.bp.temporal.h
        public final i a(org.threeten.bp.temporal.b r100) {
            return (i) r100.query(this);
        }
    }

    public static class d implements h<ZoneId> {
        public d() {
        }

        @Override // org.threeten.bp.temporal.h
        public final ZoneId a(org.threeten.bp.temporal.b r100) {
            ZoneId r101 = (ZoneId) r100.query(g.f526468a);
            if (r101 == null) goto L6;
            return r101;
        L6:
            return (ZoneId) r100.query(g.f526472e);
        }
    }

    public static class e implements h<ZoneOffset> {
        public e() {
        }

        @Override // org.threeten.bp.temporal.h
        public final ZoneOffset a(org.threeten.bp.temporal.b r100) {
            ChronoField r101 = ChronoField.OFFSET_SECONDS;
            if (r100.isSupported(r101) == true) goto L7;
            return null;
        L7:
            return ZoneOffset.ofTotalSeconds(r100.get(r101));
        }
    }

    public static class f implements h<LocalDate> {
        public f() {
        }

        @Override // org.threeten.bp.temporal.h
        public final LocalDate a(org.threeten.bp.temporal.b r100) {
            ChronoField r101 = ChronoField.EPOCH_DAY;
            if (r100.isSupported(r101) == true) goto L7;
            return null;
        L7:
            return LocalDate.ofEpochDay(r100.getLong(r101));
        }
    }

    /* JADX INFO: renamed from: org.threeten.bp.temporal.g$g, reason: collision with other inner class name */
    public static class C7101g implements h<LocalTime> {
        public C7101g() {
        }

        @Override // org.threeten.bp.temporal.h
        public final LocalTime a(org.threeten.bp.temporal.b r100) {
            ChronoField r101 = ChronoField.NANO_OF_DAY;
            if (r100.isSupported(r101) == true) goto L7;
            return null;
        L7:
            return LocalTime.ofNanoOfDay(r100.getLong(r101));
        }
    }

    static {
        f526468a = new a();
        f526469b = new b();
        f526470c = new c();
        f526471d = new d();
        f526472e = new e();
        f526473f = new f();
        f526474g = new C7101g();
    }
}
