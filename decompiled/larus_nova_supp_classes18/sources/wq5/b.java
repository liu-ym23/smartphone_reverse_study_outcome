package wq5;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiAction;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q;
import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ Context a;

    public b(Context r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        wwc.c r3 = (wwc.c) r2;
        Context r4 = this.a;
        Map<String, Integer> r0 = q.a;
        Toast.updateLoading(r4, r4.getString(q.e(WikiAction.SHORTCUT)));
    }
}
