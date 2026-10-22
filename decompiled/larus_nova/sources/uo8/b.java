package uo8;

import android.net.Uri;
import com.larus.bmhome.common_ui.image.CustomPhotoTransitionPagerAdapter;

/* JADX INFO: loaded from: classes26.dex */
public final class b implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomPhotoTransitionPagerAdapter f550921a;

    public b(CustomPhotoTransitionPagerAdapter r100) {
        this.f550921a = r100;
    }

    @Override // uo8.j
    public final void a(int r100, Uri r101) {
        Integer r102 = Integer.valueOf(r100);
        this.f550921a.f310660j.put(r102, r101);
    }
}
