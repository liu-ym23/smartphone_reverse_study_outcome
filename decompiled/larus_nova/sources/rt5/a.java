package rt5;

import com.bytedance.ee.larkwebview.base.g;
import com.ss.android.lark.log.Log;
import java.util.HashSet;
import ys5.c;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet<String> f539197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet<String> f539198b;

    public a(c r100) {
        this.f539197a = new HashSet();
        this.f539198b = new HashSet();
    }

    public final void a(g r100, String r101) {
        if (r100.f242884e == false) goto L7;
        r100.setOpenFromMultiWindow(false);
        Log.i("SecurityLinkChecker", "shouldInterceptUrlLoading is openFromMulti so return false");
        return;
    L7:
        if (r100.getHitTestResult() != null) goto L9;
    L13:
        this.f539198b.add(r101);
        Log.i("SecurityLinkChecker", "shouldInterceptUrlLoading hitTestResult = null || unknown so return false");
        return;
    L9:
        if (r100.getHitTestResult().getType() == 0) goto L13;
        Log.i("SecurityLinkChecker", "shouldInterceptUrlLoading default return false");
    }
}
