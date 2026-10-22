package y82;

import androidx.camera.video.AudioStats;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdk.interactivity.medialink.ui.MediaMultiAnchorWindowV2;
import com.bytedance.android.livesdkapi.model.CropSeiData;
import com.bytedance.android.livesdkapi.model.SeiRegion;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import zg1.u1;

/* JADX INFO: loaded from: classes9.dex */
public final class m implements b, k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f566870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z82.d f566871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c92.a f566872c;

    @Override // y82.b
    public final u1 c(a r110) {
        Intrinsics.checkNotNullParameter(r110, "windowFrame");
        z82.d r100 = this.f566871b;
        if (r100 != null) goto L5;
        return null;
    L5:
        r110.isPortrait();
        r110.m();
        int r101 = r100.f570899c;
        int r102 = r100.f570898b;
        Intrinsics.checkNotNullParameter(r110, "windowFrame");
        Integer r103 = c.a(r101, r102, r110.n());
        if (r103 == null) goto L29;
        int r104 = r103.intValue();
        r110.isPortrait();
        r110.m();
        int r105 = r100.f570899c;
        int r106 = r100.f570898b;
        Intrinsics.checkNotNullParameter(r110, "windowFrame");
        List<MediaMultiAnchorWindowV2> r107 = r110.n();
        Intrinsics.checkNotNullParameter(r107, "windows");
        ArrayList r108 = new ArrayList();
        Iterator<T> r109 = r107.iterator();
    L9:
        if (r109.hasNext() == false) goto L22;
        SeiRegion r111 = ((com.bytedance.android.livesdk.interactivity.medialink.ui.a) r109.next()).getMSeiRegion();
        if (r111 != null) goto L14;
    L19:
        Double r112 = null;
    L20:
        if (r112 == null) goto L9;
        r108.add(r112);
        goto L9
    L14:
        if (r111.getWidth() == AudioStats.AUDIO_AMPLITUDE_NONE) goto L19;
        if (r111.getHeight() == AudioStats.AUDIO_AMPLITUDE_NONE) goto L19;
        r112 = Double.valueOf(r111.getY() + r111.getHeight());
        goto L20
    L22:
        Double r113 = (Double) CollectionsKt.lastOrNull(CollectionsKt.sorted(r108));
        if (r113 == null) goto L25;
        Integer r114 = Integer.valueOf((int) ((r113.doubleValue() * ((double) r106)) + ((double) r105)));
    L26:
        if (r114 == null) goto L29;
        int r115 = r114.intValue();
        u1 r116 = new u1();
        r116.f571954i = r110.h();
        r116.f571951f = 1;
        r116.f571953h = r104;
        r116.f571952g = r115;
        return r116;
    L25:
        r114 = null;
    L29:
        return null;
    }

    public m(DataCenter r100, c92.a r101) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, "transfer");
        this.f566872c = r101;
        this.f566870a = new g(this);
    }

    @Override // y82.b
    public final void b(a r210, String r211) {
        Intrinsics.checkNotNullParameter(r210, "windowFrame");
        Intrinsics.checkNotNullParameter(r211, "sei");
        Intrinsics.checkNotNullParameter(r211, "sei");
        JSONArray r100 = z82.f.b(r211);
        if (r100 == null) goto L5;
        int r101 = r100.length();
    L7:
        if (r101 >= 2) goto L9;
        return;
    L9:
        z82.b r102 = this.f566872c.a(new a92.a(s1.y(), s1.w(), r211, new z82.g(((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getMultiAnchorServiceExternal().c().a(r210.isPortrait(), r210.m(), true), s1.A()), new z82.a(new z82.c(0))));
        if (r102 != null) goto L12;
        return;
    L12:
        Intrinsics.checkNotNullParameter(r211, "sei");
        z82.e.a r103 = z82.e.f570902g;
        int r104 = r102.f570891a;
        int r105 = r102.f570892b;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r211, "sei");
        CropSeiData r106 = z82.f.a(r211);
        JSONArray r107 = z82.f.b(r211);
        if (r107 != null) goto L16;
    L14:
        String r212 = "windowFrame";
    L40:
        z82.e r108 = null;
    L41:
        if (r108 != null) goto L43;
        z82.d r109 = null;
    L44:
        if (r109 == null) goto L68;
        CropSeiData r110 = z82.f.a(r211);
        if (r110 != null) goto L48;
        z82.d r111 = r109;
    L49:
        g r112 = this.f566870a;
        l r113 = new l(r210, r111.f570899c, (s1.y() - r111.f570897a) / 2, r111.f570897a, r111.f570898b);
        r112.getClass();
        Intrinsics.checkNotNullParameter(r113, "params");
        com.bytedance.android.livesdk.interactivity.medialink.ui.o r114 = r113.f566865a.f();
        if (r114 != null) goto L52;
        String r115 = r212;
    L58:
        a r116 = r113.f566865a;
        Intrinsics.checkNotNullParameter(r116, r115);
        Iterator r117 = r116.n().iterator();
    L60:
        if (r117.hasNext() == false) goto L65;
        com.bytedance.android.livesdk.interactivity.medialink.ui.a r118 = (com.bytedance.android.livesdk.interactivity.medialink.ui.a) r117.next();
        SeiRegion r119 = r118.getMSeiRegion();
        if (r119 == null) goto L60;
        double r120 = ((double) r113.f566868d) * r119.getWidth();
        double r121 = ((double) r113.f566869e) * r119.getHeight();
        double r122 = (((double) r113.f566868d) * r119.getX()) + ((double) r113.f566867c);
        r112.f566861a.a(r113.f566865a, r118, new d((int) r120, (int) r121, (int) ((((double) r113.f566869e) * r119.getY()) + ((double) r113.f566866b)), (int) r122, 51));
        r117 = r117;
        r111 = r111;
        goto L60
    L65:
        this.f566871b = r111;
        return;
    L52:
        r113.f566865a.isPortrait();
        r113.f566865a.m();
        int r123 = r113.f566866b;
        int r124 = r113.f566869e;
        a r125 = r113.f566865a;
        r115 = r212;
        Intrinsics.checkNotNullParameter(r125, r115);
        Integer r126 = c.a(r123, r124, r125.n());
        if (r126 == null) goto L58;
        int r127 = r126.intValue();
        if (r114.f138315a == false) goto L57;
        r112.f566861a.d(r113.f566865a, new d(-2, -2, r127 + r114.f138316b, 0, 1));
        goto L58
    L57:
        r112.f566861a.d(r113.f566865a, new d(-2, -2, r127, 0, 1));
        goto L58
    L48:
        float r128 = r109.f570897a;
        float r129 = r110.cropW * r128;
        float r130 = r110.strideW;
        float r131 = r109.f570898b;
        float r132 = r110.cropH * r131;
        float r133 = r110.strideH;
        r111 = new z82.d((int) (r129 / r130), (int) (r132 / r133), ((int) ((r131 * r110.cropY) / r133)) + r109.f570899c, ((int) ((r128 * r110.cropX) / r130)) + r109.f570900d);
        goto L49
    L68:
        return;
    L43:
        r109 = new z82.d(r108.f570903a, r108.f570904b, r102.f570893c - r108.f570906d, r102.f570894d - r108.f570905c);
        goto L44
    L16:
        if (r106 != null) goto L29;
        double r134 = z82.f.f(r107);
        double r135 = z82.f.c(r107);
        if (r134 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L14;
        if (r135 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L14;
        int r136 = (int) (((double) r104) / r134);
        int r137 = (int) (((double) r105) / r135);
        double r138 = z82.f.f(r107);
        double r139 = z82.f.c(r107);
        if (r138 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L14;
        if (r139 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L14;
        double r140 = r136;
        double r141 = r137;
        r212 = "windowFrame";
        r108 = new z82.e(r136, r137, (int) (z82.f.d(r107) * r140), (int) (z82.f.e(r107) * r141), (int) (r140 * r138), (int) (r141 * r139));
        goto L41
    L29:
        r212 = "windowFrame";
        double r142 = z82.f.f(r107);
        double r143 = z82.f.c(r107);
        if (r142 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L40;
        if (r143 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L40;
        double r144 = ((((double) r104) / r142) * ((double) r106.strideW)) / ((double) r106.cropW);
        int r145 = (int) r144;
        int r146 = (int) (((((double) r105) / r143) * ((double) r106.strideH)) / ((double) r106.cropH));
        double r147 = z82.f.f(r107);
        double r148 = z82.f.c(r107);
        if (r147 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L40;
        if (r148 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L40;
        float r149 = r145;
        float r150 = r106.cropW * r149;
        float r151 = r106.strideW;
        int r152 = (int) (r150 / r151);
        float r153 = r146;
        float r154 = r106.cropH * r153;
        float r155 = r106.strideH;
        int r156 = (int) ((r149 * r106.cropX) / r151);
        int r157 = (int) ((r153 * r106.cropY) / r155);
        double r158 = r156;
        double r159 = r152;
        int r160 = (int) (r158 + (z82.f.d(r107) * r159));
        double r161 = r157;
        double r162 = (int) (r154 / r155);
        r108 = new z82.e(r145, r146, r160, (int) (r161 + (z82.f.e(r107) * r162)), (int) (r159 * r147), (int) (r162 * r148));
        goto L41
    L5:
        r101 = 0;
        goto L7
    }

    @Override // y82.k
    public final void d(a r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "windowFrame");
        Intrinsics.checkNotNullParameter(r101, "layoutData");
        com.bytedance.android.livesdk.interactivity.medialink.ui.o r102 = r100.f();
        Integer r103 = null;
        if (r102 == null) goto L5;
        Integer r104 = r102.f138317c;
    L6:
        if (r102 == null) goto L8;
        Integer r105 = r102.f138318d;
    L9:
        if (r102 == null) goto L11;
        r103 = r102.f138319e;
    L11:
        r100.k(r101, r104, r105, r103);
        return;
    L8:
        r105 = null;
        goto L9
    L5:
        r104 = null;
        goto L6
    }

    @Override // y82.k
    public final void a(a r100, com.bytedance.android.livesdk.interactivity.medialink.ui.a r101, d r102) {
        Intrinsics.checkNotNullParameter(r100, "windowFrame");
        Intrinsics.checkNotNullParameter(r101, LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNullParameter(r102, "layoutData");
        c.b(r101.getView(), r102);
        Integer r103 = r101.getMPosition();
        if (r103 == null) goto L6;
        int r104 = r103.intValue();
        r101.a(r100.isPortrait(), r104, r100.h());
        return;
    }
}
