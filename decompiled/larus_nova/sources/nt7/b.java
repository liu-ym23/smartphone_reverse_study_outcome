package nt7;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f520525a = 0;

    public static final class a extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f520526b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f520527c;

        @Override // nt7.b
        public final byte[] a() {
            return this.f520526b;
        }

        @Override // nt7.b
        public final String b() {
            return this.f520527c;
        }

        public a(byte[] r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, HTTP.CONTENT_RANGE_BYTES);
            this.f520526b = r100;
            this.f520527c = r101;
        }
    }

    /* JADX INFO: renamed from: nt7.b$b, reason: collision with other inner class name */
    public static final class C6974b {
    }

    static {
    }

    public b() {
    }

    public abstract byte[] a();

    public abstract String b();
}
