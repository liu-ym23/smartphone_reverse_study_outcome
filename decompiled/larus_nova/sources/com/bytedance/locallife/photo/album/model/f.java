package com.bytedance.locallife.photo.album.model;

import com.bytedance.locallife.model.album.AlbumPageInfo;
import com.bytedance.locallife.model.album.PhotoData;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f261985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AlbumPageModel f261986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AlbumPageInfo f261987c;

    public f(String r100, AlbumPageModel r101, AlbumPageInfo r102) {
        this.f261985a = r100;
        this.f261986b = r101;
        this.f261987c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tv6.a r101 = (tv6.a) r100;
        GsonProtectorUtils.toJson(com.bytedance.locallife.common.utils.d.b(), r101);
        AlbumPageInfo r102 = r101.a();
        if (r102 == null) goto L21;
        AlbumPageInfo r103 = this.f261987c;
        String r104 = this.f261985a;
        List<PhotoData> r105 = r102.getPhotoData();
        if (r105 == null) goto L12;
        Iterator<T> r106 = r105.iterator();
    L8:
        if (r106.hasNext() == false) goto L12;
        PhotoData r107 = (PhotoData) r106.next();
        List<PhotoData> r108 = r103.getPhotoData();
        if (r108 == null) goto L8;
        r108.add(r107);
    L12:
        List<String> r109 = r102.getPhotoDataForLynx();
        if (r109 == null) goto L20;
        Iterator<T> r110 = r109.iterator();
    L16:
        if (r110.hasNext() == false) goto L20;
        String r111 = (String) r110.next();
        List<String> r112 = r103.getPhotoDataForLynx();
        if (r112 == null) goto L16;
        r112.add(r111);
    L20:
        r103.setHasMore(r102.getHasMore());
        r103.setNextOffset(r102.getNextOffset());
        vn6.b.a(new a(r104, RequestStatus.SUCCESS));
    L21:
        this.f261986b.f261964a = false;
    }
}
