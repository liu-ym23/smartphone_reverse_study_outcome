package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.animation;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f430258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<Integer, b> f430259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConstraintSet f430260c;

    public d() {
        throw null;
    }

    public d(ConstraintLayout r100) {
        HashMap<Integer, b> r101 = new HashMap();
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "elementsStateMap");
        this.f430258a = r100;
        this.f430259b = r101;
        ConstraintSet r102 = new ConstraintSet();
        r102.clone(r100);
        this.f430260c = r102;
    }

    public static void b(d r110) {
        Iterator<Map.Entry<Integer, b>> r100 = r110.f430259b.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L89;
        Map.Entry<Integer, b> r101 = r100.next();
        int r102 = r101.getKey().intValue();
        b r103 = r101.getValue();
        Integer r104 = r103.f430252c.get(0);
        if (r104 == null) goto L8;
        int r105 = r104.intValue();
        r110.f430260c.connect(r102, 6, r105, 6);
    L8:
        Integer r106 = r103.f430252c.get(1);
        if (r106 == null) goto L14;
        int r107 = r106.intValue();
        if (r107 != (-1)) goto L13;
        r110.f430260c.clear(r102, 6);
        goto L14
    L13:
        r110.f430260c.connect(r102, 6, r107, 7);
    L14:
        Integer r108 = r103.f430252c.get(2);
        if (r108 == null) goto L20;
        int r109 = r108.intValue();
        if (r109 != (-1)) goto L19;
        r110.f430260c.clear(r102, 7);
        goto L20
    L19:
        r110.f430260c.connect(r102, 7, r109, 7);
    L20:
        Integer r111 = r103.f430252c.get(3);
        if (r111 == null) goto L23;
        int r112 = r111.intValue();
        r110.f430260c.connect(r102, 7, r112, 6);
    L23:
        Integer r113 = r103.f430252c.get(4);
        if (r113 == null) goto L29;
        int r114 = r113.intValue();
        if (r114 != (-1)) goto L28;
        r110.f430260c.clear(r102, 1);
        goto L29
    L28:
        r110.f430260c.connect(r102, 1, r114, 1);
    L29:
        Integer r115 = r103.f430252c.get(5);
        if (r115 == null) goto L32;
        int r116 = r115.intValue();
        r110.f430260c.connect(r102, 1, r116, 2);
    L32:
        Integer r117 = r103.f430252c.get(6);
        if (r117 == null) goto L38;
        int r118 = r117.intValue();
        if (r118 != (-1)) goto L37;
        r110.f430260c.clear(r102, 2);
        goto L38
    L37:
        r110.f430260c.connect(r102, 2, r118, 2);
    L38:
        Integer r119 = r103.f430252c.get(7);
        if (r119 == null) goto L41;
        int r120 = r119.intValue();
        r110.f430260c.connect(r102, 2, r120, 1);
    L41:
        Integer r121 = r103.f430252c.get(8);
        if (r121 == null) goto L47;
        int r122 = r121.intValue();
        if (r122 != (-1)) goto L46;
        r110.f430260c.clear(r102, 3);
        goto L47
    L46:
        r110.f430260c.connect(r102, 3, r122, 3);
    L47:
        Integer r123 = r103.f430252c.get(9);
        if (r123 == null) goto L50;
        int r124 = r123.intValue();
        r110.f430260c.connect(r102, 3, r124, 4);
    L50:
        Integer r125 = r103.f430252c.get(10);
        if (r125 == null) goto L56;
        int r126 = r125.intValue();
        if (r126 != (-1)) goto L55;
        r110.f430260c.clear(r102, 4);
        goto L56
    L55:
        r110.f430260c.connect(r102, 4, r126, 4);
    L56:
        Integer r127 = r103.f430252c.get(11);
        if (r127 == null) goto L59;
        int r128 = r127.intValue();
        r110.f430260c.connect(r102, 4, r128, 3);
    L59:
        Integer r129 = r103.f430252c.get(12);
        if (r129 == null) goto L62;
        int r130 = r129.intValue();
        r110.f430260c.setMargin(r102, 1, r130);
    L62:
        Integer r131 = r103.f430252c.get(13);
        if (r131 == null) goto L65;
        int r132 = r131.intValue();
        r110.f430260c.setMargin(r102, 2, r132);
    L65:
        Integer r133 = r103.f430252c.get(14);
        if (r133 == null) goto L68;
        int r134 = r133.intValue();
        r110.f430260c.setMargin(r102, 3, r134);
    L68:
        Integer r135 = r103.f430252c.get(15);
        if (r135 == null) goto L71;
        int r136 = r135.intValue();
        r110.f430260c.setMargin(r102, 4, r136);
    L71:
        Integer r137 = r103.f430252c.get(16);
        if (r137 == null) goto L74;
        int r138 = r137.intValue();
        r110.f430260c.setMargin(r102, 6, r138);
    L74:
        Integer r139 = r103.f430252c.get(17);
        if (r139 == null) goto L77;
        int r140 = r139.intValue();
        r110.f430260c.setMargin(r102, 7, r140);
    L77:
        Integer r141 = r103.f430252c.get(30);
        if (r141 == null) goto L80;
        int r142 = r141.intValue();
        r110.f430260c.constrainWidth(r102, r142);
    L80:
        Integer r143 = r103.f430252c.get(31);
        if (r143 == null) goto L83;
        int r144 = r143.intValue();
        r110.f430260c.constrainHeight(r102, r144);
    L83:
        r110.f430260c.setVisibility(r102, r103.f430253d);
        Integer r145 = r103.f430252c.get(100);
        if (r145 == null) goto L86;
        r145.intValue();
        r110.f430260c.setHorizontalBias(r102, r103.f430254e);
    L86:
        Integer r146 = r103.f430252c.get(101);
        if (r146 == null) goto L4;
        int r147 = r146.intValue();
        r110.f430260c.setHorizontalChainStyle(r102, r147);
        goto L4
    }

    public final void a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "motionConstraint");
        this.f430259b.put(Integer.valueOf(r100.f430250a), r100);
    }
}
