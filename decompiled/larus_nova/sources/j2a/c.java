package j2a;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.camera.ve.Ratio;
import com.larus.platform.service.z2;
import com.larus.settings.value.e10;
import com.larus.settings.value.tb;
import com.larus.utils.l0;
import com.larus.utils.m0;
import com.ss.android.vesdk.VEPreviewSettings;
import com.ss.android.vesdk.VESize;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import pq9.k;

/* JADX INFO: loaded from: classes31.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Ratio f497046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f497047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f497048c;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f497049a = null;

        static {
            int[] r100 = new int[Ratio.values().length];
            r100[Ratio.RATIO_3_4.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[Ratio.RATIO_9_16.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[Ratio.RATIO_FULL_SCREEN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f497049a = r100;
        }
    }

    public int c() {
        throw null;
    }

    public final Pair<Integer, Integer> b() {
        int r100 = a.f497049a[this.f497046a.ordinal()];
        if (r100 != 1) goto L5;
        int r101 = (c() * 4) / 3;
    L12:
        return new Pair(Integer.valueOf(c()), Integer.valueOf(r101));
    L5:
        if (r100 == 2) goto L9;
        if (r100 == 3) goto L8;
        r101 = (c() * 16) / 9;
        goto L12
    L8:
        int r102 = m0.f375450a;
        AppHost.Companion r103 = AppHost.f326268a;
        r101 = (int) (c() * (m0.a(r103.getApplication()) / m0.b(r103.getApplication())));
        goto L12
    L9:
        r101 = (c() * 16) / 9;
        goto L12
    }

    public final VEPreviewSettings a() {
        Pair<Integer, Integer> r100 = b();
        return new VEPreviewSettings.Builder().setRenderSize(new VESize(r100.getFirst().intValue(), r100.getSecond().intValue())).setAsyncDetection(true).build();
    }

    public c(Ratio r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_RATION);
        this.f497046a = r100;
        z2 r101 = z2.f365865a;
        if (r101.getCameraSettings().getSupport1080p() != 1) goto L8;
        e10 r102 = e10.f368561a;
        int r103 = l0.f375430a;
        Integer r104 = ((oq9.b) l0.a(new oq9.b(0), new tb())).a();
        if (r104 == null) goto L7;
        int r105 = r104.intValue();
    L9:
        this.f497047b = r105;
        if (r101.getCameraSettings().getSupport1080p() != 1) goto L15;
        int r106 = c();
        k.f530291a.getClass();
        Pair<Integer, Integer> r107 = k.f530292b;
        if (r106 < r107.getFirst().intValue()) goto L14;
        int r108 = r107.getSecond().intValue();
    L16:
        this.f497048c = r108;
        return;
    L14:
        r108 = k.f530293c.getSecond().intValue();
        goto L16
    L15:
        k.f530291a.getClass();
        r108 = k.f530294d.getSecond().intValue();
        goto L16
    L7:
        k.f530291a.getClass();
        r105 = k.f530293c.getFirst().intValue();
        goto L9
    L8:
        k.f530291a.getClass();
        r105 = k.f530294d.getFirst().intValue();
        goto L9
    }
}
