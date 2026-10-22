package q00;

import com.bytedance.android.live.broadcast.LiveBroadcastBaseClientCopy;
import com.bytedance.android.live.broadcast.api.model.q0;
import com.bytedance.android.live.broadcast.commerce.LiveBroadcastEffectApi;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.utils.LiveEffectMonitor;
import com.bytedance.android.livesdk.config.dt;
import com.bytedance.android.livesdk.config.ul;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements q00.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f531158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f531159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f531160c;

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // q00.a
    public final boolean a() {
        if (Intrinsics.areEqual(ul.f121383a.getValue().b(), Boolean.TRUE) == true) goto L5;
        return false;
    L5:
        return m90.b.D.c(LiveEffectContextFactoryDelegate$Type.DEFAULT).booleanValue();
    }

    @Override // q00.a
    public final boolean c() {
        if (dt.f120062a.getValue().booleanValue() == true) goto L5;
        return false;
    L5:
        List<String> r100 = LiveEffectContext.f66734h;
        LiveEffectContext r101 = LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT);
        boolean r102 = !r101.a().o(d0.f66751a).isEmpty();
        boolean r103 = !r101.a().o(d0.f66753c).isEmpty();
        ILiveEffectComposerManager r104 = r101.a();
        String r105 = d0.f66761k;
        boolean r106 = !r104.o(r105).isEmpty();
        if (r106 == false) goto L17;
        Iterator<T> r107 = r101.a().o(r105).iterator();
        boolean r108 = false;
    L9:
        if (r107.hasNext() == false) goto L16;
        Sticker r109 = (Sticker) r107.next();
        Iterator<T> r110 = r109.getUpdateKeys().iterator();
    L12:
        if (r110.hasNext() == false) goto L9;
        if ((!Intrinsics.areEqual(r101.a().G(r109.getEffectId(), (String) r110.next()), 0.0f)) == false) goto L12;
        r108 = true;
        goto L9
    L16:
        r106 = r108;
    L17:
        Iterator<T> r111 = r101.a().o("beauty").iterator();
        boolean r112 = false;
    L19:
        if (r111.hasNext() == false) goto L26;
        Sticker r113 = (Sticker) r111.next();
        Iterator<T> r114 = r113.getUpdateKeys().iterator();
    L22:
        if (r114.hasNext() == false) goto L19;
        if ((!Intrinsics.areEqual(r101.a().G(r113.getEffectId(), (String) r114.next()), 0.0f)) == false) goto L22;
        r112 = true;
        goto L19
    L26:
        Iterator<T> r115 = r101.a().o(d0.f66759i).iterator();
        boolean r116 = false;
    L28:
        if (r115.hasNext() == false) goto L36;
        Sticker r117 = (Sticker) r115.next();
        Iterator<T> r118 = r117.getUpdateKeys().iterator();
    L31:
        if (r118.hasNext() == false) goto L28;
        if ((!Intrinsics.areEqual(r101.a().G(r117.getEffectId(), (String) r118.next()), 0.0f)) == false) goto L31;
        r116 = true;
        goto L28
    L36:
        if (m90.b.f512543a.c(r101.f66741g).booleanValue() == true) goto L38;
        r116 = false;
    L38:
        Iterator<T> r119 = r101.a().o("livebody").iterator();
        boolean r120 = false;
    L40:
        if (r119.hasNext() == false) goto L48;
        Sticker r121 = (Sticker) r119.next();
        Iterator<T> r122 = r121.getUpdateKeys().iterator();
    L43:
        if (r122.hasNext() == false) goto L40;
        if ((!Intrinsics.areEqual(r101.a().G(r121.getEffectId(), (String) r122.next()), 0.0f)) == false) goto L43;
        r120 = true;
        goto L40
    L48:
        if (m90.b.f512552j.c(r101.f66741g).booleanValue() == true) goto L50;
        r120 = false;
    L50:
        xs2.b r123 = xs2.b.a();
        if (r102 == true) goto L58;
        if (r112 == true) goto L58;
        if (r116 == true) goto L58;
        if (r106 == true) goto L58;
        if (r120 == true) goto L58;
        boolean r124 = false;
    L59:
        r123.post(new n90.a(r124));
        if (r102 == true) goto L68;
        if (r103 == true) goto L68;
        if (r112 == true) goto L68;
        if (r116 == true) goto L68;
        if (r106 == true) goto L68;
        if (r120 == true) goto L68;
        boolean r125 = false;
    L69:
        if (r125 == false) goto L71;
    L73:
        if (r125 == true) goto L75;
    L77:
        r101.f66736b = r125;
        return !r125;
    L75:
        if (r101.f66736b == true) goto L77;
        PthreadHandlerThreadV2 r126 = LiveEffectMonitor.f68860a;
        LiveEffectMonitor.k(false);
        goto L77
    L71:
        if (r101.f66736b == false) goto L73;
        PthreadHandlerThreadV2 r127 = LiveEffectMonitor.f68860a;
        LiveEffectMonitor.k(true);
    L68:
        r125 = true;
    L58:
        r124 = true;
        goto L59
    }

    @Override // q00.a
    public final void d(boolean r110) {
        Boolean r100 = this.f531159b;
        if (r100 != null) goto L5;
        this.f531159b = Boolean.valueOf(c());
        boolean r101 = true;
    L6:
        if (r101 == true) goto L13;
        Boolean r102 = this.f531160c;
        if (r102 != null) goto L10;
        this.f531160c = Boolean.valueOf(a());
        boolean r103 = true;
    L11:
        if (r103 == true) goto L13;
        if (r110 == true) goto L13;
        return;
    L10:
        r103 = !Intrinsics.areEqual(r102, Boolean.valueOf(a()));
    L13:
        this.f531159b = Boolean.valueOf(c());
        this.f531160c = Boolean.valueOf(a());
        List<String> r111 = LiveEffectContext.f66734h;
        Sticker r112 = (Sticker) CollectionsKt.firstOrNull(LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a().o(d0.f66751a));
        if (r112 == null) goto L17;
        String r113 = r112.getName();
        if (r113 == null) goto L17;
    L18:
        ALogger.d("COMMODITY_NO_FILTER", "update commerce effect status, commerceEffectStatus: " + this.f531159b + ", commerceNoFilterStatus: " + this.f531160c);
        LiveBroadcastEffectApi r104 = (LiveBroadcastEffectApi) LiveBroadcastBaseClientCopy.a(LiveBroadcastEffectApi.class);
        Boolean r105 = this.f531159b;
        if (r105 == null) goto L21;
        boolean r106 = r105.booleanValue();
    L22:
        Boolean r107 = this.f531160c;
        if (r107 == null) goto L25;
        boolean r108 = r107.booleanValue();
    L26:
        this.f531158a = r104.uploadBeautyParams(0, r113, -1, -1, -1, -1, r106, r108).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(c.f531161a, d.f531162a);
        xs2.b r114 = xs2.b.a();
        Boolean r109 = this.f531159b;
        if (r109 == null) goto L29;
        r109.booleanValue();
    L29:
        Boolean r115 = this.f531160c;
        if (r115 == null) goto L32;
        r115.booleanValue();
    L32:
        r114.post(new q0());
        return;
    L25:
        r108 = true;
        goto L26
    L21:
        r106 = true;
    L17:
        r113 = "";
        goto L18
    L5:
        r101 = !Intrinsics.areEqual(r100, Boolean.valueOf(c()));
        goto L6
    }
}
