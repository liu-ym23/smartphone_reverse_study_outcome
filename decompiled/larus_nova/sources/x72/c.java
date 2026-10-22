package x72;

import android.text.TextUtils;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.message.model.va;
import ec2.b1;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.List;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f562801e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<k32.a> f562802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f562803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f562804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u72.a f562805d;

    public static final class a {
    }

    static {
        Long r100 = b1.f472005a.getValue();
        if (r100 == null) goto L5;
        long r101 = r100.longValue();
    L6:
        f562801e = r101;
        return;
    L5:
        r101 = 3000;
        goto L6
    }

    public c(u72.a r100) {
        Intrinsics.checkNotNullParameter(r100, "controller");
        this.f562805d = r100;
        this.f562802a = new ArrayList();
        this.f562804c = new CompositeDisposable();
    }

    @Override // x72.b
    public final boolean a(x72.a r100, k32.a r101) {
        Intrinsics.checkNotNullParameter(r100, "chain");
        if (r101 == null) goto L32;
        boolean r102 = false;
        k32.a r103 = null;
        if (this.f562803b != 1) goto L26;
        va.a r104 = r101.f501694k;
        if (r104 != null) goto L9;
    L15:
        boolean r105 = false;
    L16:
        if (r105 == false) goto L26;
        String r106 = r101.f501684a;
        IMiddlewareUserService r107 = (IMiddlewareUserService) k.f(IMiddlewareUserService.class);
        if (r107 == null) goto L22;
        com.bytedance.android.livesdk.user.e r108 = r107.user();
        if (r108 == null) goto L22;
        String r109 = r108.n();
    L24:
        if (TextUtils.equals(r106, r109) == true) goto L26;
        r102 = true;
    L22:
        r109 = null;
        goto L24
    L9:
        if (r104.getType() != 8) goto L11;
    L14:
        r105 = true;
        goto L16
    L11:
        if (r104.getType() == 9) goto L14;
        if (r104.getType() != 3) goto L15;
    L26:
        if (r102 == false) goto L28;
        r103 = r101;
    L28:
        if (r103 == null) goto L32;
        ((ArrayList) this.f562802a).add(r101);
        return true;
    L32:
        return r100.a(r101);
    }
}
