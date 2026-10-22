package pj5;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.more.fresh.DocDynamicChampionFragment;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ DocDynamicChampionFragment a;

    public f(DocDynamicChampionFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        Context r4 = this.a.getContext();
        if (r4 != null) goto L5;
        r4 = eu5.b.a;
    L5:
        Toast.showFailureText(r4, 2131888832);
    }
}
