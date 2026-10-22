package uk1;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakReference<View> f550483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f550484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Bitmap f550485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f550486d;

    public static Bitmap a() {
        if (f550484b != 0) goto L5;
        return null;
    L5:
        Bitmap r100 = f550485c;
        if (r100 == null) goto L8;
        return r100;
    L8:
        WeakReference<View> r101 = f550483a;
        if (r101 == null) goto L31;
        View r102 = r101.get();
        if (r102 == null) goto L31;
        int r103 = ColorProtector.parseColor("#161823");
        Bitmap r104 = Bitmap.createBitmap(r102.getWidth(), r102.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas r105 = new Canvas(r104);
        r105.drawColor(r103);
        r102.draw(r105);
        int r106 = 0;
        if (f550484b > 0) goto L16;
    L18:
        Bitmap r107 = null;
    L19:
        f550485c = r107;
        if (r107 == null) goto L23;
        r106 = r107.getPixel(r102.getWidth() / 2, s1.f(43.5f) / 2);
    L23:
        if (Color.red(r106) != 0) goto L30;
        if (Color.green(r106) != 0) goto L30;
        if (Color.blue(r106) != 0) goto L30;
        f550485c = null;
    L30:
        return f550485c;
    L16:
        if (((s1.f(43.5f) + f550484b) + s1.f(8.0f)) > r104.getHeight()) goto L18;
        r107 = Bitmap.createBitmap(r104, 0, f550484b + s1.f(8.0f), r102.getWidth(), s1.f(43.5f));
    L31:
        return null;
    }

    static {
    }

    public static void b(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        ReplayDataContext.Companion.getClass();
        ReplayDataContext r101 = ReplayDataContext.a.b(r100);
        if (r101 == null) goto L8;
        m<Boolean> r102 = r101.getVideoBackgroundReady();
        if (r102 == null) goto L9;
        r102.setValue(Boolean.TRUE);
        return;
    L9:
        return;
    }
}
