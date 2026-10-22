package pk5;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.jsapi.common.LocationHelper;
import com.bytedance.ee.bear.bitable.jsapi.common.o;
import com.bytedance.ee.bear.lark.dependency.r;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.supervisor.token.Token;
import kotlin.jvm.internal.Intrinsics;
import na8.p;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements gk5.c {

    /* JADX INFO: renamed from: pk5.a$a, reason: collision with other inner class name */
    public static final class C0290a {
    }

    static {
    }

    public a() {
    }

    @Override // gk5.c
    public final void a(FragmentActivity r4, JSONObject r5, p r6) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intrinsics.checkNotNullParameter(r5, WikiFolderPushPlugin.DATA);
        Intrinsics.checkNotNullParameter(r6, "callback");
        Token r7 = LocationHelper.a;     // Catch: Throwable -> L5
        b r8 = new b(this, r4, r6);     // Catch: Throwable -> L5
        Intrinsics.checkNotNullParameter(r4, "activity");     // Catch: Throwable -> L5
        ((r) org.koin.java.a.c(r.class, null, null, 6)).f(r4, LocationHelper.a, new o(r8));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        nk5.b.c(r6, th);
    }
}
