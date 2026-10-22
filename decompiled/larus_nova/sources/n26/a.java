package n26;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public interface a {

    /* JADX INFO: renamed from: n26.a$a, reason: collision with other inner class name */
    public interface InterfaceC6883a {
        void onFail(int r100, String r101);

        void onSuccess(String r100);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f516742a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f516743b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Boolean f516744c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f516742a, r101.f516742a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f516743b, r101.f516743b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f516744c, r101.f516744c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f516742a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f516743b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            Boolean r107 = this.f516744c;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "RedirectInitInfo(appVersion=" + this.f516742a + ", cdnSourceUrl=" + this.f516743b + ", rtsNeedInit=" + this.f516744c + ')';
        }

        public b(String r100) {
            Boolean r101 = Boolean.TRUE;
            this.f516742a = r100;
            this.f516743b = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/cdn/api/saas_scheme_config_gfc/api.roma.config.json";
            this.f516744c = r101;
        }
    }

    boolean a(String r100, InterfaceC6883a r101);
}
