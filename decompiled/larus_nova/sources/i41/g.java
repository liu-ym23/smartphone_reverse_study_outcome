package i41;

import com.bytedance.android.live.revlink.impl.pk.utils.AutoMatchSource;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes47.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f488183a;

    public g(a r100) {
        this.f488183a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        a r102 = this.f488183a;
        if (r102.f488160f == false) goto L8;
        Iterator r103 = ((ArrayList) r102.f488155a).iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        ((p) r103.next()).qn(false, true, AutoMatchSource.MaxWaitTimeOut);
        goto L6
    L10:
        return;
    }
}
