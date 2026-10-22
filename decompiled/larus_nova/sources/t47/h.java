package t47;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.pia.core.api.PiaAppInfo;
import com.bytedance.pia.core.utils.ThreadUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class h implements k47.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f544588a = null;

    static {
        f544588a = new h();
    }

    public h() {
    }

    @Override // k47.f
    public final void a(PiaAppInfo r100) {
        com.bytedance.pia.core.setting.g.f266303a.getClass();
        Intrinsics.checkNotNullParameter(r100, "appInfo");
        Intrinsics.checkNotNullParameter("abtest-ch.snssdk.com", "apiHost");
        if (com.bytedance.pia.core.setting.g.f266304b != null) goto L37;
        com.bytedance.pia.core.setting.g.f266305c = r100;
        com.bytedance.pia.core.setting.g.f266306d = "abtest-ch.snssdk.com";
        com.bytedance.pia.core.setting.g.f266304b = Keva.getRepo("pia_settings");
        PiaAppInfo r101 = com.bytedance.pia.core.setting.g.f266305c;
        if (r101 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("appInfo");
        r101 = null;
    L9:
        if (r101.f266145j == false) goto L28;
        PiaAppInfo r102 = com.bytedance.pia.core.setting.g.f266305c;
        if (r102 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("appInfo");
        r102 = null;
    L13:
        List<String> r103 = r102.f266146k;
        if (r103 == null) goto L27;
        Iterator<T> r104 = r103.iterator();
    L17:
        if (r104.hasNext() == false) goto L27;
        String r105 = (String) r104.next();
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L25
        String r107 = com.bytedance.pia.core.utils.j.g(UriProtector.parse(r105), null);     // Catch: Throwable -> L25
        if (r107 == null) goto L22;
        Boolean r108 = Boolean.valueOf(com.bytedance.pia.core.setting.g.f266314l.add(r107));     // Catch: Throwable -> L25
    L23:
        Result.m9449constructorimpl(r108);     // Catch: Throwable -> L25
        goto L17
    L22:
        r108 = null;
    L25:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L27:
        com.bytedance.pia.core.utils.d.b("[PIASettings] init whiteList: " + com.bytedance.pia.core.setting.g.f266314l, null, 14);
    L28:
        com.bytedance.pia.core.setting.g.e();
        com.bytedance.pia.core.setting.c r110 = com.bytedance.pia.core.setting.c.f266298a;
        Lazy r111 = ThreadUtil.f266378a;
        Intrinsics.checkNotNullParameter(r110, "runnable");
        ThreadUtil.a().postDelayed(r110, 15000);
        return;
    }
}
