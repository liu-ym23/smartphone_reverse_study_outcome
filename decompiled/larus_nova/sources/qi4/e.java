package qi4;

import android.content.Context;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.creativex.mediaimport.repository.api.BuiltInMaterialType;
import com.bytedance.creativex.mediaimport.repository.api.IMediaItem;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Comparator;
import java.util.List;
import ki4.e0;
import ki4.i;
import ki4.r;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class e implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<e0> f533144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ki4.a f533145b;

    @Override // ki4.k
    public final Comparator<ki4.a> getComparator() {
        return null;
    }

    @Override // ki4.i
    public final List<e0> a() {
        return this.f533144a;
    }

    @Override // ki4.k
    public final List<ki4.a> e(r r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        if ((r100 instanceof IMediaItem) == false) goto L5;
        IMediaItem r101 = (IMediaItem) r100;
    L6:
        if (r101 == null) goto L8;
        ki4.a r102 = new ki4.a(com.bytedance.creativex.mediaimport.repository.api.a.b(r101), com.bytedance.creativex.mediaimport.repository.api.a.b(r101));
    L10:
        return CollectionsKt.listOf(new ki4.a[]{this.f533145b, r102});
    L8:
        r102 = new ki4.a(r100.getPath(), r100.getPath());
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(Context r100, List<? extends e0> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "sourceTypesInFolder");
        this.f533144a = r101;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "sourceTypesInFolder");
        if (r101.contains(BuiltInMaterialType.ALL) == false) goto L6;
    L9:
        this.f533145b = new ki4.a(r100.getResources().getString(R.string.larus_album_all_photos_btn), "creativex:DEFAULT_ENTIRE_FOLDER");
        return;
    L6:
        if (r101.contains(BuiltInMaterialType.IMAGE) == true) goto L9;
        r101.contains(BuiltInMaterialType.VIDEO);
        goto L9
    }
}
