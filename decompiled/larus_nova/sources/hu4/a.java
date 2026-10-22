package hu4;

import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.bytedance.ee.bear.bitable.load.cache.CacheType;
import com.bytedance.ee.bear.bitable.preload.bean.BitableOfflineResultModel;
import com.bytedance.ee.bear.bitable.preload.bean.BitableOfflineTransferModel;
import com.bytedance.ee.bear.bitable.preload.util.BitablePreloadBridgeUtil;
import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public final class a<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableOfflineTransferModel f487241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f487242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ m f487243c;

    public a(BitableOfflineTransferModel r100, d r101, m r102) {
        this.f487241a = r100;
        this.f487242b = r101;
        this.f487243c = r102;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Intrinsics.checkNotNullParameter((BitableOfflineTransferModel) r100, "it");
        BitableOfflineTransferModel r101 = this.f487241a;
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getBitableToken();
    L6:
        BitableOfflineTransferModel r104 = this.f487241a;
        if (r104 == null) goto L9;
        String r105 = r104.getBlockId();
    L10:
        BitableOfflineTransferModel r106 = this.f487241a;
        if (r106 == null) goto L13;
        String r107 = r106.getResKey();
    L14:
        BitableOfflineTransferModel r108 = this.f487241a;
        if (r108 == null) goto L17;
        String r109 = r108.getObjToken();
    L18:
        CacheType r110 = CacheType.DB;
        Intrinsics.checkNotNullParameter(r110, "cacheType");
        com.bytedance.ee.bear.bitable.load.cache.a r111 = com.bytedance.ee.bear.bitable.core.usercomponent.b.b(r110);     // Catch: Throwable -> L30
        if (r103 != null) goto L22;
        r103 = "";
    L22:
        if (r105 != null) goto L24;
        r105 = "";
    L24:
        if (r107 != null) goto L26;
        r107 = "";
    L26:
        if (r109 != null) goto L28;
        r109 = "";
    L28:
        BitableResourceData r112 = r111.a(r103, r105, r107, r109);     // Catch: Throwable -> L30
    L32:
        tt5.a.h(this.f487242b.f487247a, "get data: " + r112);
        if (r112 == null) goto L35;
        String r113 = r112.getResKey();
    L37:
        if (TextUtils.isEmpty(r113) == true) goto L46;
        if (r112 == null) goto L40;
        String r114 = r112.getResValue();
    L42:
        if (TextUtils.isEmpty(r114) == true) goto L46;
        if (r112 == null) goto L45;
        r102 = r112.getResValue();
    L45:
        m r115 = this.f487243c;
        int r116 = BitablePreloadBridgeUtil.f215016a;
        tt5.a.b("BitablePreloadBridgeUtil", "onJsSuccessCallback()...");
        BitablePreloadBridgeUtil.a(new BitableOfflineResultModel(true, "", r102), r115);
    L50:
        return Unit.INSTANCE;
    L40:
        r114 = null;
    L46:
        if (r112 == null) goto L48;
        r102 = r112.getResValue();
    L48:
        BitablePreloadBridgeUtil.b("", r102, this.f487243c);
        goto L50
    L35:
        r113 = null;
    L30:
        th = move-exception;
        tt5.a.k("BitablePreloadDBUtil", "getResourceToDB Failed:" + th);
        r112 = null;
        goto L32
    L17:
        r109 = null;
        goto L18
    L13:
        r107 = null;
        goto L14
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }
}
