package ds1;

import com.bytedance.android.livesdk.chorusconcert.VSChorusConcertWidget;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VSChorusConcertWidget f469839a;

    public e(VSChorusConcertWidget r100) {
        this.f469839a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        int r102 = VSChorusConcertWidget.f119330l;
        this.f469839a.zq("initNessListener isLock:" + r101);
        if (r101.booleanValue() == false) goto L5;
        this.f469839a.yq();
        return;
    L5:
        this.f469839a.Cq();
    }
}
