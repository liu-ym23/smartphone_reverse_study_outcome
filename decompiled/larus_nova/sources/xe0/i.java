package xe0;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import java.util.Iterator;

/* JADX INFO: loaded from: classes46.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f563342a;

    public i(h r100) {
        this.f563342a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        h r102 = this.f563342a;
        if (r102.f563338a == 0) goto L16;
        long r103 = r102.f563339b;
        if (r103 > 0) goto L8;
        ALogger.e("ttlive_link_paid", "selfRemainingTime=" + r102.f563339b + " invalid");
        return;
    L8:
        r102.f563339b = r103 - 1000;
        Iterator<h.a> r104 = r102.f563341d.iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        r104.next().B0(r102.f563339b);
        goto L10
    L12:
        r102.a(true, null);
        return;
    }
}
