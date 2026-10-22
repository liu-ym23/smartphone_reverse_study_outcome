package es2;

import com.bytedance.android.livesdk.message.model.ek;
import com.bytedance.android.livesdk.vs.f;
import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f473695a = null;

    public static final class a implements es2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f473696a;

        public a(f r100) {
            Intrinsics.checkNotNullParameter(r100, "original");
            this.f473696a = r100;
        }

        @Override // es2.a
        public final void a(Map r100, Object... r101) {
            Intrinsics.checkNotNullParameter(ek.GIFT_SCENE, "eventName");
            Intrinsics.checkNotNullParameter(r100, "extraParams");
            Intrinsics.checkNotNullParameter(r101, "args");
            this.f473696a.c(ek.GIFT_SCENE, r100, Arrays.copyOf(r101, r101.length));
        }

        @Override // es2.a
        public final void sendLog(String r100, Map<String, String> r101) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            Intrinsics.checkNotNullParameter(r101, "extra");
            this.f473696a.c(r100, r101, new Object[0]);
        }
    }

    public b() {
    }

    static {
        f473695a = new b();
    }
}
