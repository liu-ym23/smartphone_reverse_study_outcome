package us4;

import com.bytedance.ee.bear.bitable.common.BTJson;
import com.bytedance.ee.bear.bitable.homepage.preview.BoostViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BitableNativeViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery.GallerySetting;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.gallery.GalleryViewData;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class j {
    public static final void a(BitableNativeViewData r100) {
        Intrinsics.checkNotNullParameter(r100, "nativeViewData");
        BaseViewData<?, ?> r101 = r100.getData();
        if ((r101 instanceof GalleryViewData) == false) goto L5;
        GalleryViewData r102 = (GalleryViewData) r101;
    L6:
        if (r102 == null) goto L11;
        GallerySetting r103 = r102.getSetting();
        if (r103 == null) goto L12;
        r103.setRecordCardMode(false);
        int r104 = a.f551480c;
        r103.setBackground("#00000000");
        r103.setHomepageBoost(true);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public static final void b(BoostViewData r100) {
        if (r100 == null) goto L4;
        String r101 = GsonProtectorUtils.toJson(BTJson.f209798c.f209799a, r100);
    L5:
        com.ss.android.lark.storage.kv.repo.a r102 = ay4.b.d(DocumentType.BITABLE_NAME, 6);
        int r103 = a.f551480c;
        r102.putString("homepage_native_view_preview", r101);
        return;
    L4:
        r101 = null;
        goto L5
    }
}
