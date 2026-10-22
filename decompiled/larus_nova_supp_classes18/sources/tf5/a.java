package tf5;

import com.bytedance.ee.bear.middleground.drive.export.DriveFile;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public final String a;
    public final DriveFile.Status b;
    public final long c;
    public final long d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;

    /* JADX INFO: renamed from: tf5.a$a, reason: collision with other inner class name */
    public static final class C0308a {
        public String a;
        public DriveFile.Status b;
        public long c;
        public long d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;

        public C0308a() {
        }
    }

    public a(C0308a r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        this.a = r3.a;
        this.b = r3.b;
        this.c = r3.c;
        this.d = r3.d;
        this.e = r3.e;
        this.f = r3.f;
        this.g = r3.g;
        this.h = r3.h;
        this.i = r3.i;
    }
}
