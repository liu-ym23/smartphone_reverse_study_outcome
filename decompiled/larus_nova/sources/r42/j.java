package r42;

import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.core.log.ALogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class j implements vlc.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f536046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h.a f536047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ vlc.d f536048c;

    @Override // vlc.i
    public final void a(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        h.a r101 = this.f536047b;
        aa2.e r102 = (aa2.e) r101;
        r102.a(new ArrayList());
        this.f536046a.f536044b = false;
        ALogger.e("HISTORY_COMMENT_TAG", "fetch history comment error");
    }

    @Override // vlc.i
    public final void b(List<? extends tlc.d> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "messages");
        if (r100.isEmpty() == false) goto L5;
        ((aa2.e) this.f536047b).a(new ArrayList());
    L18:
        this.f536046a.f536044b = r101;
        return;
    L5:
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        Object r104 = r103.next();
        int r105 = a.f536022a;
        if ((!a.a((tlc.d) r104, this.f536048c)) == false) goto L7;
        r102.add(r104);
        goto L7
    L11:
        List r106 = CollectionsKt.reversed(r102);
        ArrayList r107 = new ArrayList();
        Iterator r108 = r106.iterator();
    L13:
        if (r108.hasNext() == false) goto L17;
        Object r109 = r108.next();
        if ((r109 instanceof t) == false) goto L13;
        r107.add(r109);
        goto L13
    L17:
        ((aa2.e) this.f536047b).a(r107);
        ALogger.i("HISTORY_COMMENT_TAG", "fetch history comment " + r107.size() + ", hasMore:" + r101);
        goto L18
    }

    public j(k r100, aa2.e r101, vlc.d r102) {
        this.f536046a = r100;
        this.f536047b = r101;
        this.f536048c = r102;
    }
}
