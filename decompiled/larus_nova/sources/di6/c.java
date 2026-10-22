package di6;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.bytedance.live.layout.AdjustBase;
import com.bytedance.live.layout.LayoutContext;
import com.bytedance.live.layout.LayoutScale;
import com.bytedance.live.layout.SDKAlign;
import com.bytedance.live.layout.d;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ci6.a f468747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ci6.b f468748b;

    public c() {
        this.f468747a = new ci6.a();
        this.f468748b = new ci6.b();
    }

    @Override // di6.a
    public final d a(LayoutContext r100) {
        Intrinsics.checkNotNullParameter(r100, "layoutContext");
        this.f468747a.getClass();
        Intrinsics.checkNotNullParameter(r100, "layoutContext");
        int r101 = LayoutContext.a.f255192b[r100.f255175b.ordinal()];
        if (r101 != 1) goto L5;
    L23:
        LayoutScale r102 = r100.f255175b;
    L24:
        RectF r103 = (RectF) r100.f255187n.getValue();
        float r104 = ((Number) r100.f255190q.getValue()).floatValue();
        if (r102 != LayoutScale.FIT_WIDTH) goto L27;
        Pair r105 = new Pair(Float.valueOf(com.bytedance.live.layout.a.b(r103)), Float.valueOf(com.bytedance.live.layout.a.b(r103) / r104));
    L28:
        float r106 = ((Number) r105.component1()).floatValue();
        float r107 = ((Number) r105.component2()).floatValue();
        switch(LayoutContext.a.f255191a[r100.f255176c.ordinal()]) {
            case 1: goto L41;
            case 2: goto L40;
            case 3: goto L39;
            case 4: goto L38;
            case 5: goto L37;
            case 6: goto L36;
            case 7: goto L35;
            case 8: goto L34;
            case 9: goto L33;
            case 10: goto L32;
            default: goto L31;
        };
    L32:
        SDKAlign r108 = SDKAlign.CENTER;
        Pair r109 = new Pair(r108, r108);
    L42:
        SDKAlign r110 = (SDKAlign) r109.component1();
        SDKAlign r111 = (SDKAlign) r109.component2();
        float r112 = ci6.a.a(com.bytedance.live.layout.a.b(r103), r106, r110, r100.f255186m);
        float r113 = ci6.a.a(com.bytedance.live.layout.a.a(r103), r107, r111, r100.f255185l);
        float r114 = r103.left + r112;
        float r115 = r103.top + r113;
        float r116 = r100.f255183j;
        RectF r117 = new RectF(r114, r115 + r116, r106 + r114, (r115 + r107) + r116);
        this.f468748b.getClass();
        Intrinsics.checkNotNullParameter(r100, "layoutContext");
        Intrinsics.checkNotNullParameter(r117, "visibleArea");
        if (r100.f255174a != AdjustBase.CANVAS) goto L45;
        RectF r118 = new RectF(r117);
    L46:
        RectF r119 = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
        Matrix r120 = new Matrix();
        r120.postTranslate(r118.left - r119.left, r118.top - r119.top);
        r120.postScale(r118.width() / r119.width(), r118.height() / r119.height(), r118.left, r118.top);
        if (r100.f255174a == AdjustBase.CONTENT) goto L51;
        r117 = new RectF(r118.left + (r100.f255180g.left * com.bytedance.live.layout.a.b(r118)), r118.top + (r100.f255180g.top * com.bytedance.live.layout.a.a(r118)), r118.left + (com.bytedance.live.layout.a.b(r100.f255180g) * com.bytedance.live.layout.a.b(r118)), r118.top + (com.bytedance.live.layout.a.b(r100.f255180g) * com.bytedance.live.layout.a.a(r118)));
    L51:
        return new d(r117, r118, r120);
    L45:
        RectF r121 = r100.f255180g;
        float r122 = com.bytedance.live.layout.a.b(r117) / com.bytedance.live.layout.a.b(r121);
        float r123 = com.bytedance.live.layout.a.a(r117) / com.bytedance.live.layout.a.a(r121);
        float r124 = r117.left - (r121.left * r122);
        float r125 = r117.top - (r121.top * r123);
        r118 = new RectF(r124, r125, r122 + r124, r123 + r125);
        goto L46
    L33:
        r109 = new Pair(SDKAlign.END, SDKAlign.START);
        goto L42
    L34:
        r109 = new Pair(SDKAlign.CENTER, SDKAlign.START);
        goto L42
    L35:
        SDKAlign r126 = SDKAlign.START;
        r109 = new Pair(r126, r126);
        goto L42
    L36:
        r109 = new Pair(SDKAlign.END, SDKAlign.CENTER);
        goto L42
    L37:
        SDKAlign r127 = SDKAlign.CENTER;
        r109 = new Pair(r127, r127);
        goto L42
    L38:
        r109 = new Pair(SDKAlign.START, SDKAlign.CENTER);
        goto L42
    L39:
        SDKAlign r128 = SDKAlign.END;
        r109 = new Pair(r128, r128);
        goto L42
    L40:
        r109 = new Pair(SDKAlign.CENTER, SDKAlign.END);
        goto L42
    L41:
        r109 = new Pair(SDKAlign.START, SDKAlign.END);
        goto L42
    L31:
        throw new NoWhenBranchMatchedException();
    L27:
        r105 = new Pair(Float.valueOf(com.bytedance.live.layout.a.a(r103) * r104), Float.valueOf(com.bytedance.live.layout.a.a(r103)));
        goto L28
    L5:
        if (r101 == 2) goto L23;
        if (r101 == 3) goto L20;
        if (r101 == 4) goto L16;
        if (r101 != 5) goto L14;
        r102 = LayoutScale.FIT_WIDTH;
        goto L24
    L14:
        throw new NoWhenBranchMatchedException();
    L16:
        if (((Number) r100.f255190q.getValue()).floatValue() <= ((Number) r100.f255188o.getValue()).floatValue()) goto L18;
        r102 = LayoutScale.FIT_WIDTH;
        goto L24
    L18:
        r102 = LayoutScale.FIT_HEIGHT;
        goto L24
    L20:
        if (((Number) r100.f255190q.getValue()).floatValue() <= ((Number) r100.f255188o.getValue()).floatValue()) goto L22;
        r102 = LayoutScale.FIT_HEIGHT;
        goto L24
    L22:
        r102 = LayoutScale.FIT_WIDTH;
        goto L24
    }
}
