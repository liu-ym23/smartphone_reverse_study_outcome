package je2;

import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.musicreportinfo.KtvComponentMusicReportInfoManager;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes10.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvComponentMusicReportInfoManager f498802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f498803b;

    public d(KtvComponentMusicReportInfoManager r100, Function0 r101) {
        this.f498802a = r100;
        this.f498803b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        if ((this.f498802a.f144301g.getValue() instanceof f.g) == false) goto L5;
        this.f498802a.f(f.a.f498810a);
    L5:
        Function0 r102 = this.f498803b;
        if (r102 == null) goto L9;
        Unit r103 = (Unit) r102.invoke();
        return;
    }
}
