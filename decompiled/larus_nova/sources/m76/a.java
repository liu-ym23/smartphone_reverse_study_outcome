package m76;

import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.f;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import o76.k;

/* JADX INFO: loaded from: classes19.dex */
public class a implements n76.a<f, k> {
    public a() {
    }

    @Override // n76.a
    public final void a(f r100, Function1<? super k, Unit> r101) {
        f r102 = r100;
        if (r102 != null) goto L5;
        k r103 = null;
    L6:
        r101.invoke(r103);
        return;
    L5:
        r103 = new k(r102.getPlayUrl(), r102.getLocalPath(), r102.getPlayModel(), 12);
        goto L6
    }
}
