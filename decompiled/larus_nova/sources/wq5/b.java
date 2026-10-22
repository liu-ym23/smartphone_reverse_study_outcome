package wq5;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiAction;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.q;
import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: classes18.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f560717a;

    public b(Context r100) {
        this.f560717a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        wwc.c r101 = (wwc.c) r100;
        Context r102 = this.f560717a;
        Map<String, Integer> r103 = q.f242003a;
        Toast.updateLoading(r102, r102.getString(q.e(WikiAction.SHORTCUT)));
    }
}
