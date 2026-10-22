package xs0;

import am2.l;
import com.bytedance.android.live.revenue.core.util.h;
import com.bytedance.android.live.revlink.api.ILinkService;
import p11.j;

/* JADX INFO: loaded from: classes47.dex */
public final class a {
    public static final l a() {
        boolean r100 = h.f91037a;
        j r101 = ((ILinkService) h.d(ILinkService.class)).getRevenueLinkDataHolder();
        l r102 = new l();
        r102.f4293a = r101.getChannelId();
        r102.f4294b = r101.a();
        r102.f4295c = (int) r101.getDuration();
        r102.f4296d = r101.A();
        r102.f4297e = r101.getPkId();
        r102.f4300h = r101.B();
        r102.f4301i = r101.getRequestId();
        r102.a(Boolean.valueOf(r101.isOnceMore()));
        r102.f4298f = r101.getTheme();
        return r102;
    }
}
