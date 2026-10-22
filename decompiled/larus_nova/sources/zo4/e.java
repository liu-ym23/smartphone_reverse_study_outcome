package zo4;

import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f573118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f573119b;

    public e(b r100, long r101) {
        this.f573118a = r100;
        this.f573119b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        List r101 = (List) r100;
        ArrayList r102 = new ArrayList();
        int r103 = this.f573118a.f573107a.f().b();
        if (r101.size() < r103) goto L5;
        r102.addAll(r101.subList((r101.size() - r103) + 1, r101.size()));
    L6:
        r102.add(Long.valueOf(this.f573119b));
        this.f573118a.f573108b.putString("BASE_RECORD_SWITCH_PAGER_TIME", mu5.b.e(r102));
        ((ArrayList) this.f573118a.f573111e).clear();
        ((ArrayList) this.f573118a.f573111e).addAll(r102);
        return;
    L5:
        r102.addAll(r101);
        goto L6
    }
}
