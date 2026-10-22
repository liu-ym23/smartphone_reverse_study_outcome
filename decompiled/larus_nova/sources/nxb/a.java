package nxb;

import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officewebview.base.g;
import java.util.HashSet;
import wwb.c;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet<String> f521098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet<String> f521099b;

    public a(c r100) {
        this.f521098a = new HashSet();
        this.f521099b = new HashSet();
    }

    public final void a(g r100, String r101) {
        if (r100.f437462e == false) goto L7;
        r100.setOpenFromMultiWindow(false);
        j.e("SecurityLinkChecker", "shouldInterceptUrlLoading is openFromMulti so return false");
        return;
    L7:
        if (r100.getHitTestResult() != null) goto L9;
    L13:
        this.f521099b.add(r101);
        j.e("SecurityLinkChecker", "shouldInterceptUrlLoading hitTestResult = null || unknown so return false");
        return;
    L9:
        if (r100.getHitTestResult().getType() == 0) goto L13;
        j.e("SecurityLinkChecker", "shouldInterceptUrlLoading default return false");
    }
}
