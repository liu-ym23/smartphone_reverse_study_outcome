package x62;

import android.widget.TextView;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import io.reactivex.Observable;
import io.reactivex.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c extends Observable<CharSequence> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f562597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Observer<? super CharSequence> f562598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f562599c;

    public c(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        this.f562599c = r100;
        a r101 = new a(r100);
        this.f562597a = r101;
        r100.addTextChangedListener(r101);
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super CharSequence> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f562598b = r100;
        a r101 = this.f562597a;
        r101.f562594b = r100;
        r100.onSubscribe(r101);
        MainThreadPostUtils.e(new b(this));
    }
}
