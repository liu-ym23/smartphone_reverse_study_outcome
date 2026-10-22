package ht2;

import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.livesdk.skin.SkinApi;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.request.ImageRequest;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import io.reactivex.schedulers.Schedulers;
import j40.v2;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f487116a = 0;

    static {
    }

    @JvmStatic
    public static final void a(boolean r100) {
        if (v2.f497312a.getValue().intValue() == 0) goto L9;
        com.bytedance.android.livesdk.sharedpref.e<Long> r101 = b6.f65244l;
        Long r102 = r101.getValue();
        long r103 = System.currentTimeMillis();
        if (r100 == false) goto L8;
    L10:
        com.bytedance.android.livesdk.sharedpref.f.d(r101, Long.valueOf(r103));
        boolean r104 = true;
    L11:
        if (r104 == true) goto L13;
        return;
    L13:
        ((SkinApi) com.bytedance.android.live.network.c.b().e(SkinApi.class)).fetchSkinList((String) BDNetworkTagManager.getInstance().buildBDNetworkTag(new h()).second).subscribeOn(Schedulers.io()).subscribe(i.f487114a, j.f487115a);
        return;
    L8:
        if ((r103 - r102.longValue()) >= BaseConstants.Time.HOUR) goto L10;
    L9:
        r104 = false;
        goto L11
    }

    @JvmStatic
    public static final boolean b(Collection<py.k> r100) {
        Intrinsics.checkNotNullParameter(r100, "images");
        Iterator<T> r101 = r100.iterator();
    L3:
        boolean r102 = true;
        if (r101.hasNext() == false) goto L15;
        py.k r103 = (py.k) r101.next();
        Intrinsics.checkNotNullParameter(r103, "imageModel");
        if (r103.getUrls() != null) goto L8;
    L12:
        r102 = false;
    L13:
        if (r102 == true) goto L3;
        return false;
    L8:
        if (r103.getUrls().isEmpty() == true) goto L12;
        if (Fresco.getImagePipeline().isInDiskCacheSync(UriProtector.parse((String) ListProtector.get(r103.getUrls(), 0))) == true) goto L13;
    L15:
        return true;
    }

    @JvmStatic
    public static final void c(Collection<py.k> r100) {
        Intrinsics.checkNotNullParameter(r100, "images");
        ImagePipeline r101 = Fresco.getImagePipeline();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.fetchDecodedImage(ImageRequest.fromUri((String) ListProtector.get(((py.k) r102.next()).getUrls(), 0)), null);
        goto L4
    }
}
