package zf1;

import com.bytedance.android.livehostapi.platform.IHostAction;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class y implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b0 f571686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String[] f571687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f571688c;

    public /* synthetic */ y(b0 r100, String[] r101, String r102) {
        this.f571686a = r100;
        this.f571687b = r101;
        this.f571688c = r102;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter r100) {
        b0 r101 = this.f571686a;
        String[] r102 = this.f571687b;
        String r103 = this.f571688c;
        r101.getClass();
        int r104 = ((IHostAction) jc1.k.f(IHostAction.class)).concatVideo(r102, r103);     // Catch: Exception -> L8
        if (r104 != 0) goto L6;
        r100.onNext(95);     // Catch: Exception -> L8
        r100.onComplete();     // Catch: Exception -> L8
    L11:
        return;
    L6:
        r100.onError(new RuntimeException("concat failed with result " + r104 + "."));     // Catch: Exception -> L8
    L8:
        e = move-exception;
        r100.onError(e);
    }
}
