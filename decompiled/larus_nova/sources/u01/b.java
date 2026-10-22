package u01;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.platformplayer.layout.p1;
import com.bytedance.android.livesdkapi.service.IFeedRevenueContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements kc0.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediatorLiveData f548125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IFeedRevenueContext f548126b;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediatorLiveData f548127a;

        public a(MediatorLiveData r100) {
            this.f548127a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            com.bytedance.android.live.platformplayer.layout.e r111 = (com.bytedance.android.live.platformplayer.layout.e) r110;
            if ((r111 instanceof p1) == true) goto L5;
            r111 = null;
        L5:
            p1 r112 = (p1) r111;
            if (r112 == null) goto L10;
            this.f548127a.setValue(new rc0.c(r112.f85694a, r112.f85695b, r112.f85696c, r112.f85697d, r112.f85698e, r112.f85699f));
            return;
        }
    }

    @Override // kc0.d
    public final boolean getInnerMovePlayer() {
        return this.f548126b.getInnerMovePlayer();
    }

    @Override // kc0.d
    public final MediatorLiveData getPlayerEvent() {
        return this.f548125a;
    }

    public b(IFeedRevenueContext r100) {
        Intrinsics.checkNotNullParameter(r100, "base");
        this.f548126b = r100;
        LiveData<com.bytedance.android.live.platformplayer.layout.e> r101 = r100.getPlayerEvent();
        if (r101 == null) goto L5;
        MediatorLiveData r102 = new MediatorLiveData();
        r102.addSource(r101, new a(r102));
    L6:
        this.f548125a = r102;
        return;
    L5:
        r102 = null;
        goto L6
    }
}
