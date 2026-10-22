package hvb;

import com.bytedance.lark.rustclient.api.p;
import com.bytedance.lark.rustclient.api.s;
import com.bytedance.lark.rustclient.api.x;
import com.larksuite.framework.callback.IGetDataCallback;
import io.reactivex.disposables.Disposable;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes37.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f487369a = 0;

    static {
    }

    public g() {
    }

    public static final void a(s r100, IGetDataCallback r101, Disposable r102) {
        if ((r100 instanceof x) == false) goto L8;
        r101.onSuccess(((x) r100).f253935c);
        if (r102 == null) goto L15;
        r102.dispose();
        return;
    L15:
        return;
    L8:
        if ((r100 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L14;
        r101.onError(p.a(((com.bytedance.lark.rustclient.api.c) r100).f253907c));
        if (r102 == null) goto L17;
        r102.dispose();
        return;
    L17:
        return;
    L14:
        throw new NoWhenBranchMatchedException();
    }
}
