package ar3;

import com.bytedance.android.window.shop.repository.dto.WindowHybridTabDataListResponseDTO;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e<T> implements ObservableOnSubscribe {
    public final /* synthetic */ WindowHybridTabDataListResponseDTO a;

    public e(WindowHybridTabDataListResponseDTO r1) {
        this.a = r1;
    }

    public final void subscribe(ObservableEmitter<WindowHybridTabDataListResponseDTO> r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        r2.onNext(this.a);
        r2.onComplete();
    }
}
