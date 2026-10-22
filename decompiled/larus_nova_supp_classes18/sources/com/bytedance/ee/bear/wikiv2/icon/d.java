package com.bytedance.ee.bear.wikiv2.icon;

import android.widget.ImageView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikItemLeafView;
import com.bytedance.ee.util.ui.n;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.larkicon.IconScene;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public final a a;

    public d() {
        this.a = new a();
    }

    public final void a(j r7, WikItemLeafView r8, c r9, ce5.a r10) {
        Intrinsics.checkNotNullParameter(r7, "node");
        Intrinsics.checkNotNullParameter(r8, "leafView");
        Intrinsics.checkNotNullParameter(r9, "config");
        r8.setIconVisible(r9.b);
        if (r9.b == true) goto L6;
        return;
    L6:
        if (r7.h != (-7)) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L20;
        if (r9.e == true) goto L13;
        r8.getItemIcon().setImageResource(kac.a.b(2131256223));
        return;
    L13:
        if (r9.c == false) goto L15;
        int r11 = n.d(20);
    L16:
        a r1 = this.a;
        String r2 = r7.a;
        String r3 = r7.e;
        String r12 = r7.v;
        b r4 = new b(r8.getItemIcon(), 2131256223, r11, r11);
        r1.getClass();
        a.a(r2, r3, r12, r4, r10);
        return;
    L15:
        r11 = n.d(14);
        goto L16
    L20:
        if (r9.d == false) goto L22;
    L25:
        IconShape r13 = IconShape.SQUARE;
    L26:
        IconShape r5 = r13;
        ImageView r6 = r8.getItemIcon();
        String r14 = r7.c;
        int r15 = r7.d;
        String r16 = r7.v;
        UserSession r17 = null;
        obb.a r18 = new obb.a(Boolean.valueOf(r7.e()), Boolean.FALSE, null);
        r18.b(IconScene.WIKI);
        if (r10 == null) goto L29;
        r17 = r10.b;
    L29:
        r18.g = r17;
        Unit r19 = Unit.INSTANCE;
        mbb.c.d(r6, r14, r15, r16, r5, r18);
        return;
    L22:
        if (r9.a == true) goto L25;
        r13 = IconShape.SQUARE_OUTLINE;
        goto L26
    L8:
        r0 = false;
        goto L9
    }
}
