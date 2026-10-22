package h05;

import android.text.TextUtils;
import com.bytedance.ee.bear.more.protocol3.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements m {
    public final /* synthetic */ a a;

    public final boolean isVisible() {
        if (TextUtils.isEmpty(this.a.c.a().getAssociateAppUrl()) == false) goto L6;
        return false;
    L6:
        return true;
    }

    public c(a r1) {
        this.a = r1;
    }
}
