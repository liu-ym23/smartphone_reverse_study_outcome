package rc6;

import com.bytedance.android.livesdk.gift.model.l2;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f537154a;

    public d(f r100) {
        this.f537154a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        BehaviorSubject<List<l2>> r101 = this.f537154a.f537156a;
        r101.onNext((List) r100);
    }
}
