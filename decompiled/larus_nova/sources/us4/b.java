package us4;

import com.bytedance.ee.bear.bitable.homepage.preview.BoostViewData;
import com.bytedance.ee.bear.bitable.homepage.preview.HomePageBoostData;
import com.bytedance.ee.bear.bitable.homepage.preview.NetError;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BitableNativeViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.SubViewType;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HomePageBoostData f551483a;

    public b(HomePageBoostData r100) {
        this.f551483a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        BitableNativeViewData r101 = (BitableNativeViewData) r100;
        Intrinsics.checkNotNullParameter(r101, "nativeViewData");
        if (r101.getSubViewType() != SubViewType.NativeGallery) goto L6;
        j.a(r101);
        HomePageBoostData r102 = this.f551483a;
        Intrinsics.checkNotNull(r102);
        return new BoostViewData(r102, r101);
    L6:
        int r103 = a.f551480c;
        throw new NetError(-5, "not gallery");
    }
}
