package je2;

import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.musicreportinfo.KtvComponentMusicReportInfoManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvComponentMusicReportInfoManager f498801a;

    public c(KtvComponentMusicReportInfoManager r100) {
        this.f498801a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        if ((this.f498801a.f144301g.getValue() instanceof f.d) == false) goto L6;
        this.f498801a.f(f.a.f498810a);
        return;
    }
}
