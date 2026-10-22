package kh0;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.api.IMiddlewareEffectService;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryType;
import com.bytedance.android.live.effect.api.h0;
import com.bytedance.android.live.effect.api.o;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.EffectManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Boolean> f503411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f503412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f503413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f503414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f503415e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final InterfaceC6552a f503416f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f503417g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f503418h;

    /* JADX INFO: renamed from: kh0.a$a, reason: collision with other inner class name */
    public interface InterfaceC6552a {
        boolean a();
    }

    public static final class b {
    }

    public interface c {
        boolean a();

        boolean b();
    }

    public static final class d implements o.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f503419a;

        public d(a r100) {
            this.f503419a = r100;
        }

        @Override // com.bytedance.android.live.effect.api.o.a
        public final void a(String r100, Sticker r101) {
            ALogger.w("CommonLokiEffectManager", "beforeAdd : panel " + r100 + " sticker " + r101);
        }

        @Override // com.bytedance.android.live.effect.api.o.a
        public final void b(boolean r100, String r101, Sticker r102) {
            ALogger.w("CommonLokiEffectManager", "onChange : isAdd " + r100 + " panel " + r101 + " sticker " + r102 + ' ');
            if ((!Intrinsics.areEqual(r101, this.f503419a.f503417g)) == false) goto L5;
            return;
        L5:
            if (r102 == null) goto L18;
            String r103 = r102.getEffectId();
            if (r103 == null) goto L18;
            Iterator r104 = MapsKt.asSequence(kh0.c.f503421a).iterator();
        L10:
            if (r104.hasNext() == false) goto L14;
            Object r105 = r104.next();
            if (Intrinsics.areEqual(((Sticker) ((Map.Entry) r105).getValue()).getEffectId(), r103) == false) goto L10;
        L15:
            Map.Entry r106 = (Map.Entry) r105;
            if (r106 == null) goto L18;
            this.f503419a.f503411a.put((String) r106.getKey(), Boolean.valueOf(r100));
            goto L18
        L14:
            r105 = null;
        L18:
            ALogger.w("CommonLokiEffectManager", "update lokiLoadMap : " + this.f503419a.f503411a);
        }
    }

    public static final class e implements kh0.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f503420a;

        public e(a r100) {
            this.f503420a = r100;
        }

        @Override // kh0.c.a
        public final void a(Sticker r100) {
            Intrinsics.checkNotNullParameter(r100, "sticker");
            this.f503420a.a();
            ALogger.w("CommonLokiEffectManager", "sticker download success: " + r100.getId() + ", " + r100.getEffectId());
        }

        @Override // kh0.c.a
        public final void onError(Exception r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            ALogger.w("CommonLokiEffectManager", "sticker download error: " + r100);
        }
    }

    static {
    }

    public final void a() {
        String r100 = this.f503412b;
        if (r100 == null) goto L6;
        e(r100);
        return;
    }

    public final void b() {
        this.f503412b = "";
        e("");
        ((LinkedHashMap) this.f503411a).clear();
        o r100 = kh0.b.a(this.f503415e);
        if (r100 == null) goto L5;
        r100.f(this.f503413c);
    L5:
        ALogger.i("CommonLokiEffectManager", "[unregistEffectListener]");
    }

    public final void d() {
        o r100 = kh0.b.a(this.f503415e);
        if (r100 == null) goto L5;
        r100.f(this.f503413c);
    L5:
        o r101 = kh0.b.a(this.f503415e);
        if (r101 == null) goto L8;
        r101.d(this.f503413c);
    L8:
        ALogger.i("CommonLokiEffectManager", "[registEffectListener]");
    }

    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "effectName");
        c r101 = this.f503418h;
        if (r101 == null) goto L8;
        if (r101.a() == true) goto L10;
        return;
    L10:
        if (r100 == null) goto L12;
        this.f503412b = r100;
        e(r100);
    L12:
        ALogger.i("CommonLokiEffectManager", "[handleRankLokiEffect] select effectName: " + r100);
        return;
    L8:
        if (je0.d.O() == true) goto L10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(String r100) {
        o r101 = kh0.b.a(this.f503415e);
        if (r101 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual((Boolean) ((LinkedHashMap) this.f503411a).get(r100), Boolean.TRUE) == true) goto L47;
        Integer r102 = (Integer) hd0.c.f().f481009b;
        boolean r103 = true;
        if (r102 != null) goto L11;
    L12:
        c r104 = this.f503418h;
        if (r104 != null) goto L15;
    L17:
        r103 = false;
    L18:
        if (r103 == true) goto L20;
        return;
    L20:
        h0 r105 = (h0) r101;
        r105.b(this.f503417g, "CommonLokiEffectManager_setLokiEffect");
        if (TextUtils.isEmpty(r100) == false) goto L23;
        return;
    L23:
        InterfaceC6552a r106 = this.f503416f;
        if (r106 != null) goto L26;
    L29:
        LinkedHashMap r107 = (LinkedHashMap) kh0.c.f503421a;
        Sticker r108 = (Sticker) r107.get(r100);
        if (r108 == null) goto L32;
        ALogger.i("CommonLokiEffectManager", "use sticker catch:" + r108.getEffectId());
        r105.d(this.f503413c);
        r105.a(this.f503417g, r108, "CommonLokiEffectManager_setLokiEffect");
    L44:
        ALogger.w("CommonLokiEffectManager", "[setLokiEffect] effect: " + r100 + " done");
        return;
    L32:
        String r109 = this.f503417g;
        e r110 = this.f503414d;
        Intrinsics.checkNotNullParameter(r109, "panelId");
        Intrinsics.checkNotNullParameter(r100, "effectName");
        if (TextUtils.isEmpty(r100) == true) goto L44;
        ALogger.d("CommonStickerManager", "#RevenueStickerDebug# [downGuestBattleSticker] download effectName: " + r100);
        Sticker r111 = (Sticker) r107.get(r100);
        if (r111 == null) goto L40;
        if (r110 == null) goto L39;
        r110.a(r111);
    L39:
        ALogger.d("CommonStickerManager", "#RevenueStickerDebug# [downGuestBattleSticker] cached effectName: " + r100);
        goto L44
    L40:
        if (r110 == null) goto L42;
        WeakReference r112 = new WeakReference(r110);
    L43:
        kh0.d r113 = new kh0.d(r100, r112);
        LiveEffectContextFactoryType r114 = LiveEffectContextFactoryType.DEFAULT;
        Intrinsics.checkNotNullParameter(r114, "type");
        EffectManager r115 = ((IMiddlewareEffectService) k.n(IMiddlewareEffectService.class)).effectContext(r114).getEffectManager();
        Intrinsics.checkNotNullParameter(r114, "type");
        ((IMiddlewareEffectService) k.n(IMiddlewareEffectService.class)).effectContext(r114).c().a().a(r109, new f(r100, r109, r115, r113));
        goto L44
    L42:
        r112 = null;
        goto L43
    L26:
        if (r106.a() == true) goto L29;
        ALogger.w("CommonLokiEffectManager", "[setLokiEffect] battle is finish, but set " + r100);
        return;
    L15:
        if (r104.b() != true) goto L17;
    L11:
        if (r102.intValue() == 2) goto L18;
    }

    public a(boolean r100, InterfaceC6552a r101, String r102, c r103) {
        Intrinsics.checkNotNullParameter(r102, "panelId");
        this.f503415e = r100;
        this.f503416f = r101;
        this.f503417g = r102;
        this.f503418h = r103;
        this.f503411a = new LinkedHashMap();
        this.f503412b = "";
        this.f503413c = new d(this);
        this.f503414d = new e(this);
    }
}
