package q60;

import android.content.Context;
import com.bytedance.android.live.core.privacy.av.api.PrivacyConfig;
import com.bytedance.android.live.core.privacy.av.api.b;
import com.bytedance.android.live.core.privacy.av.api.e;
import com.bytedance.android.live.core.privacy.av.api.h;
import com.bytedance.android.live.core.privacy.av.impl.AudioAndVideoCallbackSystemImpl;
import com.bytedance.android.live.core.privacy.av.impl.c;
import com.bytedance.android.live.core.privacy.av.impl.d;
import com.bytedance.android.live.core.privacy.av.impl.g;
import com.bytedance.android.live.core.privacy.av.impl.i;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static e f531754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static h f531755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f531756c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f531757d = null;

    public a() {
    }

    static {
        f531757d = new a();
        f531754a = new d();
        f531755b = new com.bytedance.android.live.core.privacy.av.impl.h();
        f531756c = new AtomicBoolean(false);
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.e
    public final void g() {
        f531754a.g();
    }

    @JvmStatic
    public static final void a(Context r100, PrivacyConfig r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "config");
        if (f531756c.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (r101.e() == false) goto L7;
        g.f65187d = r101;
        f531755b = new i();
        com.bytedance.android.live.core.privacy.av.impl.e r102 = new com.bytedance.android.live.core.privacy.av.impl.e(new c(r100, r101, f531755b), new AudioAndVideoCallbackSystemImpl(r101, f531755b), r101);
        Intrinsics.checkNotNullParameter(r102, "outerCallback");
        g.f65186c = r102;
        e r103 = r102;
    L8:
        f531754a = r103;
        return;
    L7:
        r103 = new d();
        goto L8
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.e
    public final int c(String r100, String r101, Map<String, String> r110, b r111, com.bytedance.android.live.core.privacy.av.api.a r112) {
        Intrinsics.checkNotNullParameter(r100, "biz");
        Intrinsics.checkNotNullParameter(r101, "sense");
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r112, "config");
        return f531754a.c(r100, r101, r110, r111, r112);
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.e
    public final int d(String r100, String r101, Map<String, String> r110, b r111, com.bytedance.android.live.core.privacy.av.api.a r112) {
        Intrinsics.checkNotNullParameter(r100, "biz");
        Intrinsics.checkNotNullParameter(r101, "sense");
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r112, "config");
        return f531754a.d(r100, r101, r110, r111, r112);
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.e
    public final int e(String r100, String r101, Map<String, String> r110, b r111, com.bytedance.android.live.core.privacy.av.api.a r112) {
        Intrinsics.checkNotNullParameter(r100, "biz");
        Intrinsics.checkNotNullParameter(r101, "sense");
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r112, "config");
        return f531754a.e(r100, r101, r110, r111, r112);
    }
}
