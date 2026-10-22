package qk5;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.jsapi.common.PhoneHelper;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;
import na8.p;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements gk5.c {

    /* JADX INFO: renamed from: qk5.a$a, reason: collision with other inner class name */
    public static final class C0297a {
    }

    static {
    }

    public a() {
    }

    @Override // gk5.c
    public final void a(FragmentActivity r2, JSONObject r3, p r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, WikiFolderPushPlugin.DATA);
        Intrinsics.checkNotNullParameter(r4, "callback");
        PhoneHelper.a(r2, new b(r4));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        nk5.b.c(r4, th);
    }
}
