package com.lynx.tasm.behavior.ui.swiper;

import androidx.camera.video.AudioStats;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.behavior.LynxGeneratorName;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxShadowNode;
import com.lynx.tasm.behavior.shadow.CustomLayoutShadowNode;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.shadow.NativeLayoutNodeRef;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.utils.n;
import y6a.g;
import y6a.j;
import y6a.k;

/* JADX INFO: loaded from: classes32.dex */
@LynxShadowNode(tagName = "swiper")
@LynxGeneratorName(packageName = "com.lynx.tasm.behavior.ui.swiper")
public class SwiperShadowNode extends CustomLayoutShadowNode implements y6a.e {
    public float A;
    public boolean B;
    public String C;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f382990w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f382991x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f382992y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f382993z;

    @Override // com.lynx.tasm.behavior.shadow.LayoutNode
    public final void e() {
        if (this.f382201v == false) goto L5;
        h(this);
    L5:
        super.e();
    }

    public SwiperShadowNode() {
        this.f382990w = -1;
        this.f382991x = -1;
        this.f382992y = -1;
        this.f382993z = 1.0f;
        this.A = 1.0f;
        this.B = false;
        this.C = "normal";
    }

    @LynxProp(name = "max-x-scale")
    public void setMaxXScale(double r100) {
        if (r100 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L6;
        this.f382993z = (float) r100;
    L6:
        if (this.f382201v == false) goto L9;
        q();
        return;
    }

    @LynxProp(name = "max-y-scale")
    public void setMaxYScale(double r100) {
        if (r100 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L6;
        this.A = (float) r100;
    L6:
        if (this.f382201v == false) goto L9;
        q();
        return;
    }

    @LynxProp(name = "mode")
    public void setMode(String r100) {
        this.C = r100;
        if (this.f382201v == false) goto L6;
        q();
        return;
    }

    @LynxProp(name = "next-margin")
    public void setNextMargin(f6a.a r100) {
        if (r100.getType() == ReadableType.String) goto L5;
        return;
    L5:
        String r101 = r100.asString();
        if (r101.endsWith(GXTemplateKey.GAIAX_PX) == false) goto L8;
    L9:
        int r102 = (int) n.d(r101, 0.0f, -1.0f, this.f382220m.getScreenMetrics());
        if (r102 >= 0) goto L13;
        r102 = -1;
    L13:
        this.f382991x = r102;
    L15:
        if (this.f382201v == false) goto L18;
        q();
        return;
    L18:
        return;
    L8:
        if (r101.endsWith("rpx") == false) goto L15;
        goto L9
    }

    @LynxProp(name = "page-margin")
    public void setPageMargin(f6a.a r100) {
        if (r100.getType() != ReadableType.String) goto L17;
        String r101 = r100.asString();
        if (r101.endsWith(GXTemplateKey.GAIAX_PX) == false) goto L7;
    L8:
        int r102 = (int) n.d(r101, 0.0f, 0.0f, this.f382220m.getScreenMetrics());
        if (r102 > 0) goto L12;
        r102 = 0;
    L12:
        this.f382992y = r102;
    L14:
        if (this.f382201v == false) goto L18;
        q();
        return;
    L18:
        return;
    L7:
        if (r101.endsWith("rpx") == false) goto L14;
    }

    @LynxProp(name = "previous-margin")
    public void setPreviousMargin(f6a.a r100) {
        if (r100.getType() == ReadableType.String) goto L5;
        return;
    L5:
        String r101 = r100.asString();
        if (r101.endsWith(GXTemplateKey.GAIAX_PX) == false) goto L8;
    L9:
        int r102 = (int) n.d(r101, 0.0f, -1.0f, this.f382220m.getScreenMetrics());
        if (r102 >= 0) goto L13;
        r102 = -1;
    L13:
        this.f382990w = r102;
    L15:
        if (this.f382201v == false) goto L18;
        q();
        return;
    L18:
        return;
    L8:
        if (r101.endsWith("rpx") == false) goto L15;
        goto L9
    }

    @LynxProp(defaultBoolean = false, name = "vertical")
    public void setVertical(boolean r100) {
        this.B = r100;
        if (this.f382201v == false) goto L6;
        q();
        return;
    }

    @Override // y6a.e
    public final k b(j r110, g r111) {
        j r100 = null;
        int r101 = 0;
    L4:
        if (r101 >= l()) goto L44;
        ShadowNode r102 = k(r101);
        if ((r102 instanceof NativeLayoutNodeRef) == false) goto L42;
        NativeLayoutNodeRef r103 = (NativeLayoutNodeRef) r102;
        if (r100 == null) goto L10;
        r103.D(r111, r100);
        goto L42
    L10:
        r100 = new j();
        float r104 = 0.0f;
        if (this.C.equals("coverflow") == false) goto L13;
    L33:
        float r105 = (this.f382990w + this.f382991x) + (this.f382992y * 2);
        float r106 = r110.f566410a;
        boolean r107 = this.B;
        if (r107 == false) goto L36;
        float r108 = 0.0f;
    L37:
        float r109 = r106 - r108;
        MeasureMode r112 = r110.f566411b;
        float r113 = r110.f566412c;
        if (r107 == false) goto L40;
        r104 = r105;
    L40:
        MeasureMode r114 = r110.f566413d;
        r100.f566410a = r109;
        r100.f566411b = r112;
        r100.f566412c = r113 - r104;
        r100.f566413d = r114;
    L41:
        r103.D(r111, r100);
        goto L42
    L36:
        r108 = r105;
        goto L37
    L13:
        if (this.C.equals("flat-coverflow") == true) goto L33;
        if (this.C.equals("carousel") == false) goto L23;
        if (this.B == false) goto L20;
        float r115 = (float) (((double) r110.f566412c) * 0.8d);
        float r116 = r110.f566410a;
    L21:
        MeasureMode r117 = r110.f566411b;
        MeasureMode r118 = r110.f566413d;
        r100.f566410a = r116;
        r100.f566411b = r117;
        r100.f566412c = r115;
        r100.f566413d = r118;
        goto L41
    L20:
        r115 = r110.f566412c;
        r116 = (float) (((double) r110.f566410a) * 0.8d);
        goto L21
    L23:
        if (this.C.equals("carry") == false) goto L32;
        float r119 = (this.f382990w + this.f382991x) + (this.f382992y * 2);
        float r120 = r110.f566410a;
        boolean r121 = this.B;
        if (r121 == false) goto L27;
        float r122 = 0.0f;
    L28:
        float r123 = (r120 - r122) * this.f382993z;
        MeasureMode r124 = r110.f566411b;
        float r125 = r110.f566412c;
        if (r121 == false) goto L31;
        r104 = r119;
    L31:
        float r126 = (r125 - r104) * this.A;
        MeasureMode r127 = r110.f566413d;
        r100.f566410a = r123;
        r100.f566411b = r124;
        r100.f566412c = r126;
        r100.f566413d = r127;
        goto L41
    L27:
        r122 = r119;
        goto L28
    L32:
        float r128 = r110.f566410a;
        MeasureMode r129 = r110.f566411b;
        float r130 = r110.f566412c;
        MeasureMode r131 = r110.f566413d;
        r100.f566410a = r128;
        r100.f566411b = r129;
        r100.f566412c = r130;
        r100.f566413d = r131;
    L42:
        r101 = r101 + 1;
        goto L4
    L44:
        return new k(r110.f566410a, r110.f566412c);
    }

    @Override // y6a.e
    public final void d(y6a.b r100, y6a.a r101) {
        int r102 = 0;
    L4:
        if (r102 >= l()) goto L9;
        ShadowNode r103 = k(r102);
        if ((r103 instanceof NativeLayoutNodeRef) == false) goto L8;
        NativeLayoutNodeRef r104 = (NativeLayoutNodeRef) r103;
        r104.C(new y6a.b());
    L8:
        r102 = r102 + 1;
        goto L4
    }
}
