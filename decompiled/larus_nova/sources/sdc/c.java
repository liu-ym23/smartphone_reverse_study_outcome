package sdc;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.photo.preview.PhotoPagerInitData;
import com.ss.android.lark.widget.photo.preview.adapter.PhotoPagerAdapter;
import com.ss.android.lark.widget.photo.preview.image.LargeImageFragment;
import com.ss.android.lark.widget.photo.preview.image.j;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.photopicker.statistics.PerfPhotoViewMonitor;
import com.ss.android.lark.widget.photopickerimpl.bean.Photo;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import rdc.t;

/* JADX INFO: loaded from: classes38.dex */
public final class c extends com.ss.android.lark.widget.photopickerimpl.view.large.e<t> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f541519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PhotoPagerAdapter.b f541520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LargeImageFragment f541521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public t f541522d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f541523e;

    @Override // com.ss.android.lark.widget.photopickerimpl.view.large.e
    public final Fragment b() {
        int r100 = LargeImageFragment.A;
        PhotoItem r101 = d(this.f541522d);
        PhotoPagerInitData.a r102 = new PhotoPagerInitData.a();
        r102.f446570t = this.f541519a;
        r102.f446571u = true;
        LargeImageFragment r103 = LargeImageFragment.a.a(r101, new PhotoPagerInitData(r102, null), this.f541520b, null);
        this.f541521c = r103;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        return r103;
    }

    public c(boolean r100) {
        this.f541519a = r100;
        this.f541520b = null;
        this.f541523e = "";
    }

    @Override // com.ss.android.lark.widget.photopickerimpl.view.large.e
    public final void a(Photo r100) {
        t r101 = (t) r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f541522d = r101;
        this.f541523e = r101.f447737b;
    }

    @Override // com.ss.android.lark.widget.photopickerimpl.view.large.e
    public final void c(Photo r100) {
        t r101 = (t) r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        if (TextUtils.equals(r101.f447737b, this.f541523e) == true) goto L9;
        LargeImageFragment r102 = this.f541521c;
        if (r102 == null) goto L9;
        PhotoItem r103 = d(r101);
        Log.i("LargeImageFragment", "onRefreshCurrentPage, loadModel:" + r103.getLoadModel());
        Context r104 = r102.T90().getContext();
        if (r104 == null) goto L9;
        r102.f446627d = r103;
        PerfPhotoViewMonitor.f447616a.getClass();
        PerfPhotoViewMonitor.f(2);
        PerfPhotoViewMonitor.f(3);
        UICallbackExecutor.post(new j(r104, r102));
    L9:
        this.f541523e = r101.f447737b;
    }

    public final PhotoItem d(t r100) {
        PhotoItem r101 = new PhotoItem();
        if (r100 == null) goto L6;
        String r102 = r100.f447737b;
        if (r102 == null) goto L6;
    L7:
        com.ss.android.lark.widget.photopicker.entity.Photo r103 = new com.ss.android.lark.widget.photopicker.entity.Photo();
        r101.setLoadModel(r102);
        r103.setPath(r102);
        int r104 = 0;
        if (r100 == null) goto L12;
        Integer r105 = r100.f447736a;
        if (r105 == null) goto L12;
        int r106 = r105.intValue();
    L13:
        r103.setId(r106);
        r101.setPhoto(r103);
        r101.setPaths(CollectionsKt.listOf(r102));
        if (r100 == null) goto L16;
        int r107 = r100.f447740e;
    L17:
        r101.setWidth(r107);
        if (r100 == null) goto L20;
        r104 = r100.f447741f;
    L20:
        r101.setHeight(r104);
        return r101;
    L16:
        r107 = 0;
    L12:
        r106 = 0;
    L6:
        r102 = "";
        goto L7
    }
}
