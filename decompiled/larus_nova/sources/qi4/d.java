package qi4;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.creativex.mediaimport.repository.api.BuiltInMaterialType;
import com.bytedance.creativex.mediaimport.repository.api.MediaType;
import java.util.List;
import ki4.a0;
import ki4.e0;
import ki4.l;
import ki4.m;
import ki4.r;
import ki4.z;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements ki4.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<z> f533139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<BuiltInMaterialType> f533140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<BuiltInMaterialType> f533141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f533142d;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f533143a = null;

        static {
            int[] r100 = new int[MediaType.values().length];
            r100[MediaType.VIDEO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[MediaType.IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f533143a = r100;
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [qi4.c] */
    public d() {
        this.f533139a = CollectionsKt.listOf(new z[]{l.a(), l.c(), l.b()});
        BuiltInMaterialType r100 = BuiltInMaterialType.ALL;
        this.f533140b = CollectionsKt.listOf(new BuiltInMaterialType[]{r100, BuiltInMaterialType.VIDEO});
        this.f533141c = CollectionsKt.listOf(new BuiltInMaterialType[]{r100, BuiltInMaterialType.IMAGE});
        this.f533142d = new c();
    }

    @Override // ki4.d
    public final List<z> c() {
        return this.f533139a;
    }

    @Override // ki4.d
    public final Function1<a0, Class<? extends m>> d() {
        return this.f533142d;
    }

    @Override // ki4.k
    public final List<a0> e(r r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        e0 r101 = r100.getSourceType();
        BuiltInMaterialType r102 = BuiltInMaterialType.VIDEO;
        if (r101 == r102) goto L17;
        BuiltInMaterialType r103 = BuiltInMaterialType.IMAGE;
        if (r101 == r103) goto L18;
        MediaType r104 = r100.getType();
        int r105 = a.f533143a[r104.ordinal()];
        if (r105 == 1) goto L16;
        if (r105 != 2) goto L14;
        return CollectionsKt.listOf(r103);
    L14:
        throw new NoWhenBranchMatchedException();
    L16:
        return CollectionsKt.listOf(r102);
    L18:
        return this.f533141c;
    L17:
        return this.f533140b;
    }
}
