package zf1;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class p implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b0 f571668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f571669b;

    public /* synthetic */ p(b0 r100, List r101) {
        this.f571668a = r100;
        this.f571669b = r101;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter r100) {
        b0 r101 = this.f571668a;
        List r102 = this.f571669b;
        r101.getClass();
        b r103 = new b(r102, new e0(r101, r100));
        if (r103.f571624a == true) goto L7;
        r103.f571624a = true;
        r103.a();
        return;
    }
}
