package sdc;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.photo.preview.video.local.VideoGalleryFragment;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.photopickerimpl.bean.Photo;
import kotlin.jvm.internal.Intrinsics;
import rdc.t;

/* JADX INFO: loaded from: classes38.dex */
public final class f extends com.ss.android.lark.widget.photopickerimpl.view.large.e<t> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f541533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t f541534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public VideoGalleryFragment f541535c;

    @Override // com.ss.android.lark.widget.photopickerimpl.view.large.e
    public final Fragment b() {
        IRequestCreator r100 = ImageLoader.with(this.f541533a);
        PhotoItem r101 = d(this.f541534b);
        VideoGalleryFragment r102 = new VideoGalleryFragment();
        r102.setArguments(new Bundle());
        r102.f447265d = r100;
        r102.f447266e = r101;
        this.f541535c = r102;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        return r102;
    }

    public f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f541533a = r100;
    }

    @Override // com.ss.android.lark.widget.photopickerimpl.view.large.e
    public final void a(Photo r100) {
        t r101 = (t) r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f541534b = r101;
    }

    @Override // com.ss.android.lark.widget.photopickerimpl.view.large.e
    public final void c(Photo r100) {
        t r101 = (t) r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        VideoGalleryFragment r102 = this.f541535c;
        Intrinsics.checkNotNull(r102);
        PhotoItem r103 = d(r101);
        r102.getClass();
        String r104 = null;
        if (r103.getPhoto() == null) goto L5;
        String r105 = r103.getPhoto().getPath();
    L6:
        PhotoItem r106 = r102.f447266e;
        if (r106 != null) goto L9;
    L11:
        if (r105 != null) goto L13;
    L15:
        boolean r107 = false;
    L16:
        if (r107 == true) goto L20;
        r102.f447266e = r103;
        r103.getPhoto().getPath();
        return;
    L20:
        return;
    L13:
        if (r105.equals(r104) == false) goto L15;
        r107 = true;
        goto L16
    L9:
        if (r106.getPhoto() == null) goto L11;
        r104 = r106.getPhoto().getPath();
        goto L11
    L5:
        r105 = null;
        goto L6
    }

    public final PhotoItem d(t r100) {
        PhotoItem r101 = new PhotoItem();
        com.ss.android.lark.widget.photopicker.entity.Photo r102 = new com.ss.android.lark.widget.photopicker.entity.Photo();
        Intrinsics.checkNotNull(r100);
        r102.setPath(r100.f447737b);
        Integer r103 = r100.f447736a;
        Intrinsics.checkNotNull(r103);
        r102.setId(r103.intValue());
        r101.setPhoto(r102);
        return r101;
    }
}
