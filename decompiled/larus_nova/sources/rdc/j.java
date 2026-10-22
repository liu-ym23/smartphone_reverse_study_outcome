package rdc;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import com.ss.android.lark.widget.photopickernew.PhotoPickerFrameFragment2;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes38.dex */
public final class j implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f537358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.widget.photopickerimpl.model.c f537359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PhotoPickerFrameFragment2 f537360c;

    public final void b(t r100, boolean r101) {
        boolean r102 = true;
        this.f537358a.c(r100, true);
        s r103 = this.f537358a;
        if (r101 == false) goto L5;
    L8:
        r103.f537383e = r102;
        com.ss.android.lark.widget.photopickerimpl.model.c r104 = this.f537359b;
        r104.getClass();
        com.ss.android.lark.widget.photopickerimpl.model.i r105 = new com.ss.android.lark.widget.photopickerimpl.model.i(r104);
        com.ss.android.lark.widget.photopickerimpl.model.j r106 = new com.ss.android.lark.widget.photopickerimpl.model.j(r104);
        RxScheduledExecutor.Consumer r107 = com.ss.android.lark.widget.photopickerimpl.model.k.f447817a;
        ScheduledExecutorService r108 = com.ss.android.lark.widget.photopickerimpl.model.c.f447781m;
        if (r108 == null) goto L12;
        r108.execute(new com.ss.android.lark.widget.photopickerimpl.model.d(r105, r104, r106, r107));
        return;
    L12:
        return;
    L5:
        if (this.f537360c.f447877f.f447560e == true) goto L8;
        r102 = false;
        goto L8
    }

    public j(PhotoPickerFrameFragment2 r100, s r101, com.ss.android.lark.widget.photopickerimpl.model.c r102) {
        this.f537360c = r100;
        this.f537358a = r101;
        this.f537359b = r102;
    }

    public final void a(t r100, boolean r101, boolean r102) {
        if (r100 != null) goto L5;
        Log.e(PhotoPickerFrameFragment2.U90(this.f537360c), "onSelectedChanged, photo is null");
        return;
    L5:
        PhotoPickerFrameFragment2 r103 = this.f537360c;
        boolean r104 = this.f537358a.f537382d;
        int r105 = PhotoPickerFrameFragment2.f447874h;
        r103.getClass();
        com.ss.android.lark.widget.photopicker.f.d r106 = com.ss.android.lark.widget.photopicker.f.a();
        PhotoPickerFrameFragment2.Y90(r100);
        boolean r107 = r103.f447877f.f447580y;
        r106.I();
        this.f537358a.c(r100, r101);
        if (r101 == false) goto L15;
        s r108 = this.f537358a;
        if (r102 == false) goto L10;
    L13:
        boolean r109 = true;
    L14:
        r108.f537383e = r109;
        goto L15
    L10:
        if (this.f537360c.f447877f.f447560e == true) goto L13;
        r109 = false;
    L15:
        com.ss.android.lark.widget.photopickerimpl.model.c r110 = this.f537359b;
        r110.getClass();
        com.ss.android.lark.widget.photopickerimpl.model.i r111 = new com.ss.android.lark.widget.photopickerimpl.model.i(r110);
        com.ss.android.lark.widget.photopickerimpl.model.j r112 = new com.ss.android.lark.widget.photopickerimpl.model.j(r110);
        RxScheduledExecutor.Consumer r113 = com.ss.android.lark.widget.photopickerimpl.model.k.f447817a;
        ScheduledExecutorService r114 = com.ss.android.lark.widget.photopickerimpl.model.c.f447781m;
        if (r114 == null) goto L19;
        r114.execute(new com.ss.android.lark.widget.photopickerimpl.model.d(r111, r110, r112, r113));
        return;
    }
}
