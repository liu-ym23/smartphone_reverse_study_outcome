package hv8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class c {

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f487354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f487355b;

        public a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "endpoint");
            this.f487354a = r100;
            this.f487355b = r101;
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f487356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f487357b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f487358c;

        public b(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "deviceId");
            this.f487356a = r100;
            this.f487357b = r101;
            this.f487358c = r102;
        }
    }

    public c() {
    }
}
