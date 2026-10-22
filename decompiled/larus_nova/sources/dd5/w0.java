package dd5;

import android.app.Activity;
import android.content.Context;
import com.ss.ttvideoengine.model.VideoRef;

/* JADX INFO: loaded from: classes18.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f468013a = 0;

    static {
    }

    public static int a(Activity r100) {
        int r101 = 2;
        if (r100 != null) goto L5;
    L19:
        return 2;
    L5:
        if (ku5.c.k(r100) == false) goto L19;
        if (com.bytedance.ee.util.ui.n.D(r100) == false) goto L10;
        int r102 = com.bytedance.ee.util.ui.n.a(com.bytedance.ee.util.ui.n.getResources(r100)).widthPixels;
    L11:
        int r103 = r102 - com.bytedance.ee.util.ui.n.d(32);
        int r104 = (r103 - com.bytedance.ee.util.ui.n.d(12)) / 2;
        int r105 = com.bytedance.ee.util.ui.n.d(VideoRef.VALUE_VIDEO_REF_CATEGORY);
        int r106 = com.bytedance.ee.util.ui.n.d(138);
        if (r104 >= r106) goto L14;
        return 2;
    L14:
        if (r104 < r106) goto L18;
        if (r104 > r105) goto L18;
        return r101;
    L18:
        r101 = r101 + 1;
        r104 = r103 / r101;
        goto L14
    L10:
        r102 = com.bytedance.ee.util.ui.n.v();
        goto L11
    }

    public static int b(Context r100) {
        int r101 = 2;
        if (r100 != null) goto L5;
    L15:
        return 2;
    L5:
        if (ku5.c.k(r100) == false) goto L15;
        int r102 = com.bytedance.ee.util.ui.n.a(com.bytedance.ee.util.ui.n.getResources(r100)).widthPixels - com.bytedance.ee.util.ui.n.d(16);
        int r103 = com.bytedance.ee.util.ui.n.d(16);
        int r104 = (r102 - (r103 * 2)) / 2;
        int r105 = com.bytedance.ee.util.ui.n.d(VideoRef.VALUE_VIDEO_REF_CATEGORY);
        int r106 = com.bytedance.ee.util.ui.n.d(138);
        if (r104 >= r106) goto L10;
        return 2;
    L10:
        if (r104 < r106) goto L14;
        if (r104 > r105) goto L14;
        return r101;
    L14:
        r101 = r101 + 1;
        r104 = (r102 - (r103 * r101)) / r101;
        goto L10
    }
}
