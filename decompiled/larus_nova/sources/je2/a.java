package je2;

import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.musicreportinfo.KtvComponentMusicReportInfoManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvComponentMusicReportInfoManager f498799a;

    public a(KtvComponentMusicReportInfoManager r100) {
        this.f498799a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        if ((this.f498799a.f144301g.getValue() instanceof f.b) == false) goto L6;
        this.f498799a.f(f.a.f498810a);
        return;
    }
}
