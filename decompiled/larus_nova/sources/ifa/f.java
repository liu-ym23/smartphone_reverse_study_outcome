package ifa;

import com.larus.im.bean.message.block.Block;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f489684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Block f489685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f489686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f489687d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f489688e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f489689f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f489690g;

    public static final class a {
    }

    public static final class b extends f {
        public b(Block r100) {
            Intrinsics.checkNotNullParameter(r100, "block");
            super(2, r100, 124);
        }
    }

    public static final class c extends f {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final List<String> f489691h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f489692i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final List<ifa.a> f489693j;

        public c(Block r100, List<String> r101, boolean r102, List<ifa.a> r103) {
            Intrinsics.checkNotNullParameter(r100, "block");
            Intrinsics.checkNotNullParameter(r101, "additionTips");
            Intrinsics.checkNotNullParameter(r103, "attachments");
            super(0, r100, 124);
            this.f489691h = r101;
            this.f489692i = r102;
            this.f489693j = r103;
        }
    }

    public static final class d extends f {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final ifa.b f489694h;

        public d(Block r100, ifa.b r101) {
            Intrinsics.checkNotNullParameter(r100, "block");
            Intrinsics.checkNotNullParameter(r101, "fileResult");
            super(6, r100, 120);
            this.f489694h = r101;
        }
    }

    public static final class e extends f {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final List<ifa.c> f489695h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final List<ifa.c> f489696i;

        /* JADX WARN: Multi-variable type inference failed */
        public e(Block r100, List<? extends ifa.c> r101, List<? extends ifa.c> r102) {
            Intrinsics.checkNotNullParameter(r100, "block");
            Intrinsics.checkNotNullParameter(r101, "mediaItems");
            Intrinsics.checkNotNullParameter(r102, "previewMediaItems");
            super(7, r100, 120);
            this.f489695h = r101;
            this.f489696i = r102;
        }
    }

    /* JADX INFO: renamed from: ifa.f$f, reason: collision with other inner class name */
    public static final class C6260f extends f {
        public C6260f(Block r100) {
            Intrinsics.checkNotNullParameter(r100, "block");
            super(4, r100, 124);
        }
    }

    public static final class g extends f {
        public g(Block r100) {
            Intrinsics.checkNotNullParameter(r100, "block");
            super(8, r100, 124);
        }
    }

    public static final class h extends f {
        public h(Block r100) {
            Intrinsics.checkNotNullParameter(r100, "block");
            super(3, r100, 124);
        }
    }

    public static final class i extends f {
        public i(Block r100) {
            Intrinsics.checkNotNullParameter(r100, "block");
            super(5, r100, 124);
        }
    }

    public static final class j extends f {
        public j(Block r100) {
            Intrinsics.checkNotNullParameter(r100, "block");
            super(1, r100, 124);
        }
    }

    static {
    }

    public f(int r100, Block r101, int r102) {
        if ((r102 & 4) == 0) goto L5;
        boolean r103 = true;
    L6:
        this.f489684a = r100;
        this.f489685b = r101;
        this.f489686c = r103;
        this.f489687d = false;
        this.f489688e = false;
        this.f489689f = false;
        this.f489690g = 0;
        return;
    L5:
        r103 = false;
        goto L6
    }
}
