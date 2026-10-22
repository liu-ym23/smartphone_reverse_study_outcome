package qq1;

import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import vr1.e;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f534465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<qq1.a> f534466b;

    public static final class a {
    }

    static {
    }

    public b(ViewGroup r100) {
        e r101 = r.a().f(r100);
        if (r101 != null) goto L5;
        r101 = new d();
    L5:
        this.f534465a = r101;
    }

    public final void a(qq1.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (this.f534466b != null) goto L5;
        this.f534466b = new ArrayList();
    L5:
        List<qq1.a> r101 = this.f534466b;
        if (r101 == null) goto L9;
        r101.add(r100);
        return;
    }

    public final void b(qq1.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        List<qq1.a> r101 = this.f534466b;
        if (r101 == null) goto L6;
        ((ArrayList) r101).remove(r100);
        return;
    }

    public final void c(boolean r100, int r101) {
        List<qq1.a> r102 = this.f534466b;
        if (r102 == null) goto L8;
        Iterator r103 = ((ArrayList) r102).iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        qq1.a r104 = (qq1.a) r103.next();
        ALogger.i("ReplayKeyboardObservable", "visiable:" + r100 + "keyboardHeight:" + r101);
        r104.X6(r100, r101);
        goto L6
    L10:
        return;
    }
}
