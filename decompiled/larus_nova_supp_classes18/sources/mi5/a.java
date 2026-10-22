package mi5;

import android.app.Application;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareDocInfo;
import com.bytedance.ee.bear.share.export.ShareParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends com.bytedance.ee.bear.share.newshare.extension.a<ShareDocInfo> {
    public final ShareParams c;
    public final ShareDocInfo d;

    /* JADX INFO: renamed from: mi5.a$a, reason: collision with other inner class name */
    public static final class C0266a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.share.newshare.extension.a
    public final void a() {
        tt5.a.h("DocShareInfoBehavior", "create");
        c(this.d);
    }

    public static void d(Throwable r1) {
        Intrinsics.checkNotNullParameter(r1, "throwable");
        if (ax4.d.b(r1, 1002) == false) goto L5;
    L8:
        Toast.showFailureText(eu5.b.a, 2131887321);
        return;
    L5:
        if (ax4.d.b(r1, 4) == true) goto L8;
        Application r2 = eu5.b.a;
        Toast.showFailureText(r2, r2.getString(2131888226));
    }

    public a(ShareParams r2, ShareDocInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "initState");
        this.c = r2;
        this.d = r3;
    }
}
