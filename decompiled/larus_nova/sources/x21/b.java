package x21;

import com.bytedance.android.livesdk.link.model.c3;
import com.bytedance.android.livesdk.link.model.c5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f562203a;

    public static final class a extends b {
        public a() {
            super("ShowLink");
        }
    }

    /* JADX INFO: renamed from: x21.b$b, reason: collision with other inner class name */
    public static final class C8187b extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c3 f562204b;

        public C8187b(c3 r100) {
            Intrinsics.checkNotNullParameter(r100, "meta");
            super("ShowPenal");
            this.f562204b = r100;
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c5 f562205b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c3 f562206c;

        public c() {
            this(null, null, 3);
        }

        public c(c5 r100, c3 r101, int r102) {
            if ((r102 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            super("ShowPk");
            this.f562205b = r100;
            this.f562206c = r101;
        }
    }

    public b(String r100) {
        this.f562203a = r100;
    }
}
