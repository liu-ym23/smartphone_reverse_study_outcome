package je2;

import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.musicreportinfo.KtvComponentMusicReportInfoManager;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ KtvComponentMusicReportInfoManager a;

    public a(KtvComponentMusicReportInfoManager r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        if ((this.a.g.getValue() instanceof f.b) == false) goto L6;
        this.a.f(f.a.a);
        return;
    }
}
