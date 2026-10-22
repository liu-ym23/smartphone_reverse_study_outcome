package np1;

import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f520007a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f520008a = null;

        public a() {
        }

        static {
            f520008a = new a();
        }

        public static b a(Function0 r100, Function1 r101) {
            Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
            b r102 = (b) r100.invoke();
            if (r101 == null) goto L5;
            Unit r103 = (Unit) r101.invoke(r102);
        L5:
            return r102;
        }
    }

    static {
        f520007a = a.f520008a;
    }

    int getType();
}
