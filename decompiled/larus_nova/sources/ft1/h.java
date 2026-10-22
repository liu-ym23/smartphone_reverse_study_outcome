package ft1;

import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f478763a;

    public h(e r100) {
        this.f478763a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.livesdk.chatroom.viewmodel.i r101 = (com.bytedance.android.livesdk.chatroom.viewmodel.i) r100;
        if (r101 == null) goto L5;
        int r102 = r101.f114792a;
    L6:
        if (r102 <= 0) goto L9;
        Map<String, String> r103 = d.f478752a;
        d.b(String.valueOf(r101.f114792a), this.f478763a.hashCode());
        return;
    L9:
        return;
    L5:
        r102 = 0;
        goto L6
    }
}
