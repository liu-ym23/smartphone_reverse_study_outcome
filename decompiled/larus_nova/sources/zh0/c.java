package zh0;

import com.bytedance.android.live.core.setting.c4;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f572124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f572125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.live.pushstream.d f572126c;

    public static final class a {
    }

    static {
    }

    public final void a() {
        com.bytedance.android.live.pushstream.d r100 = this.f572126c;
        if (r100 == null) goto L5;
        r100.c1("radio_sei", null, 1, false, true);
    L5:
        Disposable r101 = this.f572125b;
        if (r101 == null) goto L8;
        r101.dispose();
    L8:
        this.f572125b = null;
    }

    public c(com.bytedance.android.live.pushstream.d r100) {
        this.f572126c = r100;
        this.f572124a = c4.f65272a.getValue().getSeiSendInterval();
    }
}
