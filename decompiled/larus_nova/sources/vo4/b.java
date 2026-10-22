package vo4;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.document.x2;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements x2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<x2.b> f556505a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.document.x2
    public final void load() {
        Iterator<x2.b> r100 = this.f556505a.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        x2.b r101 = r100.next();
        if (r101 == null) goto L4;
        r101.onLoadStart();
        goto L4
    L8:
        tt5.a.b("BaseAddDocumentLoader", "load");
    }

    @Override // com.bytedance.ee.bear.document.x2
    public final void onDestroy() {
        tt5.a.b("BaseAddDocumentLoader", LiveCommonConstants.REASON_ON_DEDTROY);
    }

    @Override // com.bytedance.ee.bear.document.x2
    public final void onPause() {
        tt5.a.b("BaseAddDocumentLoader", "onPause");
    }

    public b() {
        this.f556505a = new CopyOnWriteArrayList();
    }

    @Override // com.bytedance.ee.bear.document.x2
    public final void S(x2.b r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f556505a.remove(r100);
        tt5.a.b("BaseAddDocumentLoader", "removeLoadingCallback callback=" + r100);
    }

    @Override // com.bytedance.ee.bear.document.x2
    public final void S3(x2.b r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        if (this.f556505a.contains(r100) == true) goto L5;
        this.f556505a.add(r100);
    L5:
        tt5.a.b("BaseAddDocumentLoader", "addLoadingCallback callback=" + r100);
    }

    @Override // com.bytedance.ee.bear.document.x2
    public final void bi(boolean r100) {
        tt5.a.b("BaseAddDocumentLoader", "cancelLoad cancelByUser=" + r100);
    }
}
