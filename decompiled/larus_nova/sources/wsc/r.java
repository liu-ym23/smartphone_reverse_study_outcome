package wsc;

import android.content.res.Resources;
import android.graphics.Rect;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f561177a = 0;

    static {
    }

    public static int c(o.a r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "dimension");
        if (Intrinsics.areEqual("em", r100.f561176b) == false) goto L6;
        float r102 = r100.f561175a * r101;
    L10:
        return (int) r102;
    L6:
        if (Intrinsics.areEqual("dp", r100.f561176b) == false) goto L8;
        float r103 = Integer.valueOf((int) r100.f561175a).floatValue();
        Resources r104 = Resources.getSystem();
        r102 = (r103 * WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).density) + 0.5f;
        goto L10
    L8:
        r102 = r100.f561175a;
        goto L10
    }

    public static Rect a(Rect r100, int r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, "imageBounds");
        int r102 = r100.width();
        int r103 = r100.height();
        if (r102 <= r101) goto L7;
        if (r102 <= r103) goto L7;
        Rect r104 = new Rect(0, 0, r101, (int) Math.min(r101, Math.max((int) ((r100.height() / (r102 / r101)) + 0.5f), r110)));
    L16:
        return r104;
    L7:
        if (r103 <= r101) goto L10;
        if (r103 <= r102) goto L10;
        r104 = new Rect(0, 0, (int) Math.min(r101, Math.max((int) ((r100.width() / (r103 / r101)) + 0.5f), r110)), r101);
    L10:
        if (r102 >= r110) goto L13;
        if (r102 >= r103) goto L13;
        r104 = new Rect(0, 0, r110, (int) Math.min(r101, Math.max((int) ((r100.height() / (r102 / r110)) + 0.5f), r110)));
    L13:
        if (r103 >= r110) goto L17;
        if (r103 >= r102) goto L18;
        r104 = new Rect(0, 0, (int) Math.min(r101, Math.max((int) ((r100.width() / (r103 / r110)) + 0.5f), r110)), r110);
        goto L16
    L18:
        return r100;
    L17:
        return r100;
    }

    public static Rect b(o r100, Rect r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "imageSize");
        Intrinsics.checkNotNullParameter(r101, "imageBounds");
        o.a r103 = r100.f561173a;
        o.a r104 = r100.f561174b;
        float r105 = r101.width() / r101.height();
        if (r103 != null) goto L5;
        if (r104 != null) goto L17;
        return r101;
    L17:
        if (Intrinsics.areEqual(GXTemplateKey.GAIAX_PE, r104.f561176b) == true) goto L22;
        int r106 = c(r104, 0.0f);
        Rect r107 = new Rect(0, 0, (int) ((r106 * r105) + 0.5f), r106);
    L20:
        return r107;
    L22:
        return r101;
    L5:
        if (Intrinsics.areEqual(GXTemplateKey.GAIAX_PE, r103.f561176b) == false) goto L7;
        int r108 = (int) (r102 * (r103.f561175a / 100.0f));
    L8:
        if (r104 != null) goto L10;
    L13:
        int r109 = (int) ((r108 / r105) + 0.5f);
    L14:
        r107 = new Rect(0, 0, r108, r109);
        goto L20
    L10:
        if (Intrinsics.areEqual(GXTemplateKey.GAIAX_PE, r104.f561176b) == true) goto L13;
        r109 = c(r104, 0.0f);
        goto L14
    L7:
        r108 = c(r103, 0.0f);
        goto L8
    }
}
