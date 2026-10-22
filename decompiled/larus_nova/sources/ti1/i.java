package ti1;

import android.os.Bundle;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.chatroom.m0;
import com.bytedance.android.livesdk.landscapeslide.LiveLandSlideContext;
import com.bytedance.android.livesdk.widget.LiveVerticalViewPager;
import com.bytedance.android.livesdkapi.feed.ILiveRoomList;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Pair;

/* JADX INFO: loaded from: classes7.dex */
public final class i implements ck1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CompositeDisposable f546034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ik1.b f546035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ls2.d f546036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ik1.d f546037d;

    @Override // com.bytedance.android.livesdk.ability.IAbility
    public final /* synthetic */ void onAbilityClear() {
        IAbility.CC.$default$onAbilityClear(this);
    }

    @Override // ck1.a
    public final void Al() {
        ILiveRoomList r100 = this.f546035b.f490186c;
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof com.bytedance.android.livesdk.landscapeslide.b) == false) goto L26;
        com.bytedance.android.livesdk.landscapeslide.b r101 = (com.bytedance.android.livesdk.landscapeslide.b) r100;
        Bundle r102 = this.f546036c.f510526o;
        String r103 = "";
        if (r102 == null) goto L13;
        Bundle r104 = m0.a(r102);
        if (r104 == null) goto L13;
        String r105 = r104.getString("enter_from_merge", "");
    L14:
        Bundle r106 = this.f546036c.f510526o;
        if (r106 == null) goto L21;
        Bundle r107 = m0.a(r106);
        if (r107 == null) goto L21;
        r103 = r107.getString("enter_method", "");
    L21:
        if (LiveLandSlideContext.checkEnv(r105, r103, null) == false) goto L25;
        Pair<LiveLandSlideContext, Disposable> r108 = LiveLandSlideContext.initAndLoad(r101, new h(this));
        ik1.d r109 = this.f546037d;
        r109.f490240p = r108.getFirst();
        Disposable r110 = this.f546037d.f490240p.isDataReady().a().subscribe(new g(this));
        r101.c(this.f546035b.f490188e.getCurrentItem(), this.f546037d.f490240p);
        LiveVerticalViewPager r111 = this.f546035b.f490188e;
        r111.setTouchInterceptListener(this.f546037d.f490240p.createScrollLimiter(r111));
        this.f546035b.f490188e.setIsLandSlideEnable(true);
        CompositeDisposable r112 = new CompositeDisposable();
        this.f546034a = r112;
        r112.add(r108.getSecond());
        this.f546034a.add(r110);
        return;
    L25:
        return;
    L13:
        r105 = "";
        goto L14
    }

    @Override // ck1.a
    public final void Im() {
        ILiveRoomList r100 = this.f546035b.f490186c;
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof com.bytedance.android.livesdk.landscapeslide.b) == false) goto L19;
        LiveLandSlideContext r101 = this.f546037d.f490240p;
        if (r101 == null) goto L20;
        com.bytedance.android.livesdk.landscapeslide.b r102 = (com.bytedance.android.livesdk.landscapeslide.b) r100;
        if (r101.getRelateRoomIndex() <= 0) goto L12;
        int r103 = 1;
    L13:
        int r104 = r102.e() + r103;
        r102.h();
        this.f546035b.f490188e.setTouchInterceptListener(null);
        this.f546035b.f490188e.setIsLandSlideEnable(false);
        this.f546036c.f510527p = r104;
        CompositeDisposable r105 = this.f546034a;
        if (r105 == null) goto L16;
        r105.dispose();
        this.f546034a = null;
    L16:
        this.f546037d.f490240p = null;
        return;
    L12:
        r103 = 0;
        goto L13
    L20:
        return;
    }

    public i(ik1.b r100, ls2.d r101, ik1.d r102) {
        this.f546034a = null;
        this.f546036c = r101;
        this.f546035b = r100;
        this.f546037d = r102;
    }
}
