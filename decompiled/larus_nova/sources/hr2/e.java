package hr2;

import com.bytedance.android.livesdk.revenue.service.livecore.main.IRTCStreamIndexEnumParam;
import com.bytedance.live.kmp.core.KmpEnv;
import fr2.g0;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes11.dex */
public interface e extends xh6.c, xh6.b {

    /* JADX INFO: renamed from: d2, reason: collision with root package name */
    public static final a f486852d2 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f486853a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a f486854b = null;

        public a() {
        }

        static {
            f486854b = new a();
            IRTCStreamIndexEnumParam r100 = IRTCStreamIndexEnumParam.STREAM_INDEX_MAIN;
            xh6.b r101 = ((g0) vh6.c.b(g0.class)).o6().b(Reflection.getOrCreateKotlinClass(e.class), r100);
            if ((r101 instanceof e) == true) goto L5;
            r101 = null;
        L5:
            KmpEnv r102 = KmpEnv.f255139a;
            com.bytedance.live.kmp.core.b.a();
            f486853a = (e) r101;
        }
    }

    static {
        f486852d2 = a.f486854b;
    }
}
