package l02;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetDownloadPriority;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.j;
import com.bytedance.android.scope.o;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements o, dy0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Long, Integer> f506851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f506852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f506853c;

    public static final class a implements IAssetsManager.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f506854a;

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager.b
        public final void a() {
        }

        public a(b r100) {
            this.f506854a = r100;
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager.b
        public final void b(List<? extends com.bytedance.android.live.core.resources.e> r100) {
            Intrinsics.checkNotNullParameter(r100, "assetsModels");
            if (this.f506854a.f506851a.isEmpty() == false) goto L5;
            return;
        L5:
            Iterator<T> r101 = r100.iterator();
        L7:
            if (r101.hasNext() == false) goto L19;
            long r102 = ((com.bytedance.android.live.core.resources.e) r101.next()).getId();
            if (((LinkedHashMap) this.f506854a.f506851a).keySet().contains(Long.valueOf(r102)) == false) goto L7;
            b r103 = this.f506854a;
            Map<Long, Integer> r104 = r103.f506851a;
            LinkedHashMap r105 = (LinkedHashMap) r104;
            Integer r106 = (Integer) r105.get(Long.valueOf(r102));
            if (r106 == null) goto L13;
            int r107 = r106.intValue();
        L14:
            Intrinsics.checkNotNullParameter("JSB", "source");
            if (r107 != 1008) goto L17;
            AssetDownloadPriority r108 = AssetDownloadPriority.NORMAL;
        L18:
            AssetDownloadPriority r109 = r108;
            r103.f506853c.r0(r102, new l02.a(r103), r107, r109);
            goto L7
        L17:
            r108 = AssetDownloadPriority.JSB_PLAY;
            goto L18
        L13:
            r107 = 1008;
            goto L14
        }
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f506853c.l0(this.f506852b);
        ((LinkedHashMap) this.f506851a).clear();
    }

    public b(j r100) {
        Intrinsics.checkNotNullParameter(r100, "assetsManager");
        this.f506853c = r100;
        this.f506851a = new LinkedHashMap();
        this.f506852b = new a(this);
    }
}
