package ar3;

import com.bytedance.android.window.shop.repository.dto.WindowHybridTabDataListResponseDTO;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ h a;

    public f(h r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Function1<WindowHybridTabDataListResponseDTO, Unit> r0 = this.a.b;
        r0.invoke((WindowHybridTabDataListResponseDTO) r2);
    }
}
