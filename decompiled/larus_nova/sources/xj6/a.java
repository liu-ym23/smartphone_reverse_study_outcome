package xj6;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.live.photoviewer.game.PhotoViewerDialogActivity;
import com.bytedance.live.photoviewer.photoviewer.PVMediaModel;
import com.bytedance.live.photoviewer.photoviewer.PhotoViewerAdapter;
import com.bytedance.live.photoviewer.photoviewer.PhotoViewerListener;
import com.bytedance.live.photoviewer.transition.PhotoViewerDialog;
import com.bytedance.live.photoviewer.transition.TransitionPagerAdapter;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import vj6.c;
import zj6.d;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f564102a = 0;

    public a() {
    }

    static {
    }

    public static void a(Context r100, ArrayList r101, int r102, View r103, String r104, PhotoViewerListener r110, int r111) {
        if ((r111 & 8) == 0) goto L6;
        r103 = null;
    L6:
        if ((r111 & 16) == 0) goto L9;
        r104 = "";
    L9:
        if ((r111 & 32) == 0) goto L11;
        boolean r105 = false;
    L13:
        if ((r111 & 64) == 0) goto L16;
        r110 = null;
    L16:
        if ((r111 & 128) == 0) goto L18;
        boolean r112 = true;
    L20:
        if (r105 == true) goto L37;
        PhotoViewerDialog r106 = new PhotoViewerDialog(r100);
        PhotoViewerAdapter r113 = new PhotoViewerAdapter(r100, r101, null);
        r106.f255690c = r113;
        r106.f255688a.setAdapter(r113);
        TransitionPagerAdapter<?> r107 = r106.f255690c;
        if (r107 == null) goto L24;
        r107.f255717d = new zj6.a(r106);
    L24:
        if (r103 == null) goto L26;
        boolean r108 = true;
    L27:
        r106.f255691d = r108;
        Iterator r109 = r101.iterator();
        int r114 = 0;
    L29:
        if (r109.hasNext() == false) goto L33;
        if (((PVMediaModel) r109.next()).getType() != 2) goto L29;
        r114 = r114 + 1;
        goto L29
    L33:
        r106.f255688a.setItemViewCacheSize(r114);
        if (r103 == null) goto L36;
        r106.a(r102, d.a(r103, new int[]{r103.getHeight(), r103.getWidth()}));
        return;
    L36:
        r106.a(r102, null);
        return;
    L26:
        r108 = false;
        goto L27
    L37:
        Intent r115 = new Intent(r100, PhotoViewerDialogActivity.class);
        r115.putExtra("position", r102);
        r115.putExtra("total", r101.size());
        r115.putExtra("title", r104);
        r115.putParcelableArrayListExtra("model_list", r101);
        r115.putExtra(AppConstants.BUNDLE_SHOW_BACK, r112);
        SoftReference<PhotoViewerListener> r116 = c.f555419a;
        if (r110 == null) goto L40;
        c.f555419a = new SoftReference(r110);
    L40:
        if (r103 == null) goto L42;
        r115.putExtra("start_rect", d.a(r103, new int[]{r103.getHeight(), r103.getWidth()}));
    L42:
        r100.startActivity(r115);
        return;
    L18:
        r112 = false;
        goto L20
    L11:
        r105 = true;
        goto L13
    }
}
