package je2;

import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.musicreportinfo.KtvComponentMusicReportInfoManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvComponentMusicReportInfoManager f498800a;

    public b(KtvComponentMusicReportInfoManager r100) {
        this.f498800a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        if ((this.f498800a.f144301g.getValue() instanceof f.c) == false) goto L6;
        this.f498800a.f(f.a.f498810a);
        return;
    }
}
