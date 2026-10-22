package np1;

import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C6956a f520005a = null;

    /* JADX INFO: renamed from: np1.a$a, reason: collision with other inner class name */
    public static final class C6956a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C6956a f520006a = null;

        public C6956a() {
        }

        static {
            f520006a = new C6956a();
        }

        public static a a(Function0 r100, Function1 r101) {
            Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
            a r102 = (a) r100.invoke();
            if (r101 == null) goto L5;
            Unit r103 = (Unit) r101.invoke(r102);
        L5:
            return r102;
        }
    }

    static {
        f520005a = C6956a.f520006a;
    }

    d<? extends a> a();

    c c();

    int getType();
}
