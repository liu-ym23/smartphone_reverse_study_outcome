package tl5;

import com.bytedance.ee.bear.contract.n;
import io.reactivex.functions.Consumer;
import java.util.Iterator;

/* JADX INFO: loaded from: classes18.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f546632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f546633b;

    public i(h r100, String r101) {
        this.f546632a = r100;
        this.f546633b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        Iterator<n.d> r102 = this.f546632a.f546631a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().a(this.f546633b);
        goto L4
    }
}
