package jic;

import android.graphics.Rect;
import android.view.Surface;
import com.ss.android.vesdk.VEConfigCenter;
import com.ss.android.vesdk.VEGetFrameSettings;
import com.ss.android.vesdk.constants.VERotation;

/* JADX INFO: loaded from: classes40.dex */
public final class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f499261f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Surface f499262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f499263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Surface f499264c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f499265d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public VERotation f499266e;

    static {
        f499261f = VEConfigCenter.getInstance().getValue("ve_enable_rec_pixel_copy_strategy", 0);
    }

    public static void a(VEGetFrameSettings r100, Rect r101) {
        float r102 = (r101.width() * 1.0f) / r101.height();
        float r103 = (r100.getTargetResolution().width * 1.0f) / r100.getTargetResolution().height;
        if (r102 <= r103) goto L5;
        int r104 = (int) (r101.height() * r103);
        int r105 = r101.left + ((r101.width() - r104) / 2);
        r101.left = r105;
        r101.right = r105 + r104;
        return;
    L5:
        int r106 = (int) (r101.width() / r103);
        int r107 = r101.top + ((r101.height() - r106) / 2);
        r101.top = r107;
        r101.bottom = r107 + r106;
    }

    public b(Surface r100, Rect r101, Surface r102, Rect r103) {
        this.f499266e = VERotation.Rotation_0;
        this.f499262a = r100;
        this.f499263b = r101;
        this.f499264c = r102;
        this.f499265d = r103;
    }
}
