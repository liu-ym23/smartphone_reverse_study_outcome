package ds1;

import com.bytedance.android.livesdk.chorusconcert.VSChorusConcertWidget;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VSChorusConcertWidget f469840a;

    public f(VSChorusConcertWidget r100) {
        this.f469840a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        int r102 = VSChorusConcertWidget.f119330l;
        this.f469840a.zq("showLatestEvent 是否不在直播位置" + r101);
        if (r101.booleanValue() == false) goto L5;
        this.f469840a.yq();
        return;
    L5:
        es1.a r103 = this.f469840a.xq(false);
        if (r103 != null) goto L8;
        return;
    L8:
        if (r103.f473682a != true) goto L13;
        this.f469840a.Cq();
        return;
    }
}
