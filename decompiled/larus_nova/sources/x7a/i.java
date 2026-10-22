package x7a;

import android.util.LruCache;
import com.lynx.tasm.LynxView;

/* JADX INFO: loaded from: classes32.dex */
public final class i extends LruCache<h, LynxView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f562870a;

    public interface a {
    }

    @Override // android.util.LruCache
    public final /* bridge */ /* synthetic */ LynxView create(h r100) {
        return null;
    }

    public i(int r100, a r101) {
        super(r100);
        this.f562870a = r101;
    }

    @Override // android.util.LruCache
    public final void entryRemoved(boolean r100, h r101, LynxView r102, LynxView r103) {
        LynxView r104 = r102;
        if (r100 == false) goto L11;
        a r105 = this.f562870a;
        if (r105 == null) goto L12;
        f r106 = ((d) r105).b();
        if (r106 == null) goto L9;
        r106.d(r104);
    L9:
        r104.destroy();
        return;
    L12:
        return;
    }
}
