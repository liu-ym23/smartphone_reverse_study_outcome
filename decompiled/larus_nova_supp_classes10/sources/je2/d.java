package je2;

import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.musicreportinfo.KtvComponentMusicReportInfoManager;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ KtvComponentMusicReportInfoManager a;
    public final /* synthetic */ Function0 b;

    public d(KtvComponentMusicReportInfoManager r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        if ((this.a.g.getValue() instanceof f.g) == false) goto L5;
        this.a.f(f.a.a);
    L5:
        Function0 r4 = this.b;
        if (r4 == null) goto L9;
        Unit r5 = (Unit) r4.invoke();
        return;
    }
}
