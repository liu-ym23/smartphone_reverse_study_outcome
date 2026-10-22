package v85;

import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.document.comment.bean.ShowCardsJsData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class a {
    public final int a;
    public final int b;
    public final String c;
    public final String d;
    public final String e;
    public final DriveFilePath f;
    public final DriveFilePath g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final boolean o;
    public final boolean p;
    public final boolean q;
    public final int r;
    public final String s;
    public final String t;

    /* JADX INFO: renamed from: v85.a$a, reason: collision with other inner class name */
    public static class C0311a {
        public int a;
        public String b;
        public String c;
        public String d;
        public DriveFilePath e;
        public DriveFilePath f;
        public String g;
        public String h;
        public String i;
        public String j;
        public String k;
        public String l;
        public String m;
        public boolean n;
        public boolean o;
        public int p;
        public String q;
        public String r;

        public int a() {
            throw null;
        }

        public boolean b() {
            throw null;
        }

        public C0311a() {
            this.a = -1;
            DriveFilePath.Companion.getClass();
            this.e = DriveFilePath.a.a();
            this.f = DriveFilePath.a.a();
            this.m = ShowCardsJsData.ID_GLOBAL;
            this.q = "";
            this.r = "";
        }

        public final void c(DriveFilePath r2) {
            Intrinsics.checkNotNullParameter(r2, "filePath");
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.e = r2;
        }

        public final void d(DriveFilePath r2) {
            Intrinsics.checkNotNullParameter(r2, "tempFilePath");
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.f = r2;
        }
    }

    public static final class b {
    }

    static {
    }

    public a(C0311a r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        this.a = r2.a();
        this.b = r2.a;
        this.c = r2.b;
        this.d = r2.c;
        this.e = r2.d;
        this.f = r2.e;
        this.g = r2.f;
        this.h = r2.g;
        this.i = r2.h;
        this.j = r2.i;
        this.k = r2.j;
        this.l = r2.k;
        this.m = r2.l;
        this.n = r2.m;
        this.o = r2.n;
        this.p = r2.o;
        this.q = r2.b();
        this.s = r2.q;
        this.t = r2.r;
        this.r = r2.p;
    }
}
