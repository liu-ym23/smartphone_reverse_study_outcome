package kotlinx.datetime.internal.format.parser;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public interface f {

    public static final class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f505317a;

        @Override // kotlinx.datetime.internal.format.parser.f
        public final String a() {
            return "attempted to overwrite the existing value '" + this.f505317a + '\'';
        }

        public a(Object r100) {
            Intrinsics.checkNotNullParameter(r100, "conflicting");
            this.f505317a = r100;
        }
    }

    public static final class b implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f505318a = null;

        static {
            f505318a = new b();
        }

        public b() {
        }

        @Override // kotlinx.datetime.internal.format.parser.f
        public final String a() {
            return "expected an Int value";
        }
    }

    public static final class c implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f505319a;

        @Override // kotlinx.datetime.internal.format.parser.f
        public final String a() {
            return "expected at least " + this.f505319a + " digits";
        }

        public c(int r100) {
            this.f505319a = r100;
        }
    }

    public static final class d implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f505320a;

        @Override // kotlinx.datetime.internal.format.parser.f
        public final String a() {
            return "expected at most " + this.f505320a + " digits";
        }

        public d(int r100) {
            this.f505320a = r100;
        }
    }

    public static final class e implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f505321a;

        @Override // kotlinx.datetime.internal.format.parser.f
        public final String a() {
            return "expected '" + this.f505321a + '\'';
        }

        public e(String r100) {
            Intrinsics.checkNotNullParameter(r100, "expected");
            this.f505321a = r100;
        }
    }

    String a();
}
