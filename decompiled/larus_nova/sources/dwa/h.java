package dwa;

import com.ss.android.lark.log.Log;
import java.util.Iterator;

/* JADX INFO: loaded from: classes34.dex */
public final /* synthetic */ class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f470375a;

    public /* synthetic */ h(j r100) {
        this.f470375a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j r100 = this.f470375a;
        if (r100.f470387g == null) goto L9;
        Log.d("PreLoadAsyncInflater", "completeCache mViewPools");
        Iterator<l> r101 = r100.f470387g.values().iterator();
        if (r101.hasNext() == false) goto L10;
        r101.next().getClass();
        throw null;
    L10:
        return;
    }
}
