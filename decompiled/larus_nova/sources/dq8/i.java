package dq8;

import cq8.z0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f469697a;

    public static final class a extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f469698b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.larus.bmhome.actionbar.model.c f469699c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f469698b, r101.f469698b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f469699c, r101.f469699c) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f469698b.hashCode() * 31) + this.f469699c.hashCode();
        }

        public final String toString() {
            return "GaokaoPreference(widgetId=" + this.f469698b + ", commandOption=" + this.f469699c + ')';
        }

        public a(String r100, com.larus.bmhome.actionbar.model.c r101) {
            Intrinsics.checkNotNullParameter(r100, "widgetId");
            Intrinsics.checkNotNullParameter(r101, "commandOption");
            super("GaokaoPreference");
            this.f469698b = r100;
            this.f469699c = r101;
        }
    }

    public static final class b extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f469700b = null;

        static {
            f469700b = new b();
        }

        public b() {
            super("PasteUrl");
        }
    }

    public static final class c extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.larus.bmhome.actionbar.model.c f469701b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f469701b, ((c) r100).f469701b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f469701b.hashCode();
        }

        public final String toString() {
            return "SendUserMessage(commandOption=" + this.f469701b + ')';
        }

        public c(com.larus.bmhome.actionbar.model.c r100) {
            Intrinsics.checkNotNullParameter(r100, "commandOption");
            super("SendUserMessage");
            this.f469701b = r100;
        }
    }

    public static final class d extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.larus.bmhome.actionbar.model.c f469702b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f469702b, ((d) r100).f469702b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f469702b.hashCode();
        }

        public final String toString() {
            return "SingleFile(commandOption=" + this.f469702b + ')';
        }

        public d(com.larus.bmhome.actionbar.model.c r100) {
            Intrinsics.checkNotNullParameter(r100, "commandOption");
            super("SingleFile");
            this.f469702b = r100;
        }
    }

    public static final class e extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f469703b = null;

        static {
            f469703b = new e();
        }

        public e() {
            super("SyncCalendar");
        }
    }

    public static final class f extends i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f469704b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.larus.bmhome.actionbar.model.c f469705c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final z0 f469706d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L8;
            return false;
        L8:
            f r101 = (f) r100;
            if (Intrinsics.areEqual(this.f469704b, r101.f469704b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f469705c, r101.f469705c) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f469706d, r101.f469706d) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f469704b.hashCode() * 31) + this.f469705c.hashCode()) * 31) + this.f469706d.hashCode();
        }

        public final String toString() {
            return "UniversalCamera(widgetId=" + this.f469704b + ", commandOption=" + this.f469705c + ", trackingContext=" + this.f469706d + ')';
        }

        public f(String r100, com.larus.bmhome.actionbar.model.c r101, z0 r102) {
            Intrinsics.checkNotNullParameter(r100, "widgetId");
            Intrinsics.checkNotNullParameter(r101, "commandOption");
            Intrinsics.checkNotNullParameter(r102, "trackingContext");
            super("UniversalCamera");
            this.f469704b = r100;
            this.f469705c = r101;
            this.f469706d = r102;
        }
    }

    public i(String r100) {
        this.f469697a = r100;
    }
}
