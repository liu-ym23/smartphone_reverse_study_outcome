package lb1;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f508314a;

    public c(a r100) {
        this.f508314a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f508314a.f508310g = null;
        SoloKtvContext.Companion.getClass();
        SoloKtvContext r101 = SoloKtvContext.a.a();
        r101.setPreComposeVideoFile((String) r100);
    }
}
