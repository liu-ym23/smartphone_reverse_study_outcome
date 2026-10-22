package je2;

import com.bytedance.android.livesdk.ktvimpl.base.sei.h;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public abstract class f {

    public static final class a extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f498810a = null;

        static {
            f498810a = new a();
        }

        public a() {
        }
    }

    public static final class b extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f498811a;

        public b(boolean r100) {
            this.f498811a = r100;
        }
    }

    public static final class c extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f498812a;

        public c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "text");
            this.f498812a = r100;
        }
    }

    public static final class d extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h f498813a;

        public d(h r100) {
            Intrinsics.checkNotNullParameter(r100, "seiModel");
            this.f498813a = r100;
        }
    }

    public static final class e extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Long f498814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f498815b;

        public e() {
            this(null, null);
        }

        public e(Long r100, String r101) {
            this.f498814a = r100;
            this.f498815b = r101;
        }
    }

    /* JADX INFO: renamed from: je2.f$f, reason: collision with other inner class name */
    public static final class C6423f extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final KtvMusic f498816a;

        public C6423f(KtvMusic r100) {
            this.f498816a = r100;
        }
    }

    public static final class g extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final KtvMusic f498817a;

        public g(KtvMusic r100) {
            this.f498817a = r100;
        }
    }

    public f() {
    }
}
