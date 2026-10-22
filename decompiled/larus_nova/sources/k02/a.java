package k02;

import com.bytedance.android.live.gift.GiftType;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import fr2.p;
import fr2.w1;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p f501246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f501247b;

    /* JADX INFO: renamed from: k02.a$a, reason: collision with other inner class name */
    public static final class C6494a {
    }

    static {
    }

    public a() {
    }

    public static ca0.b a() {
        return com.bytedance.android.livesdk.gift.platform.core.manager.a.b().a(GiftType.STICKER_GIFT);
    }

    public final boolean b(boolean r100) {
        LivePluginSPIManager.f85856e.getClass();
        if (LivePluginSPIManager.c() == false) goto L20;
        p r101 = this.f501246a;
        if (r101 == null) goto L11;
        w1 r102 = r101.E();
        if (r102 == null) goto L11;
        int r103 = r102.b();
        int r104 = f.f501251e;
        if (r103 != 1) goto L11;
        boolean r105 = true;
    L12:
        String.valueOf(r105);
        p r106 = this.f501246a;
        if (r106 == null) goto L23;
        w1 r107 = r106.E();
        if (r107 == null) goto L24;
        int r108 = r107.b();
        int r109 = f.f501251e;
        if (r108 != 1) goto L25;
        return true;
    L25:
        return false;
    L24:
        return false;
    L23:
        return false;
    L11:
        r105 = false;
        goto L12
    L20:
        if (r100 == false) goto L22;
        LivePluginSPIManager.a().requireByUser("GiftLiveCoreRenderFilter");
    L22:
        return false;
    }
}
