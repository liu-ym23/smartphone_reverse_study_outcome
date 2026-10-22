package com.bytedance.ee.bear.wikiv2.icon;

import android.widget.ImageView;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.larkicon.IconScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import pbb.f;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.wikiv2.icon.a$a, reason: collision with other inner class name */
    public static final class C0204a {
    }

    static {
    }

    public a() {
    }

    public static void a(String r11, String r12, String r13, b r14, ce5.a r15) {
        Intrinsics.checkNotNullParameter(r14, "config");
        boolean r0 = true;
        int r1 = 0;
        if (r13 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        UserSession r4 = null;
        if (r2 == false) goto L74;
    L16:
        Integer r3 = null;
    L17:
        tt5.a.h("WikiSpaceIconFactory", "tryToFindIconType, tryToFindIconType=" + r3 + ", spaceId=" + r11 + ", spaceName=" + r12);
        int r5 = f.b;
        if (r3 != null) goto L21;
    L22:
        if (r3 != null) goto L25;
    L26:
        if (r3 != null) goto L29;
    L31:
        boolean r6 = false;
    L33:
        if (r6 == false) goto L38;
        ImageView r7 = r14.a;
        int r8 = e.n.b;
        IconShape r9 = IconShape.SQUARE;
        Boolean r16 = Boolean.FALSE;
        obb.a r10 = new obb.a(r16, r16, Integer.valueOf(r14.b));
        r10.b(IconScene.WIKI);
        if (r15 == null) goto L37;
        r4 = r15.b;
    L37:
        r10.g = r4;
        Unit r17 = Unit.INSTANCE;
        mbb.c.d(r7, "", r8, r13, r9, r10);
        return;
    L38:
        int r18 = obb.c.p;
        if (r12 != null) goto L70;
    L45:
        String r19 = null;
    L46:
        if (r19 != null) goto L48;
        r19 = "";
    L48:
        obb.c.a r110 = obb.c.b.a(3, r19);
        IconShape r111 = IconShape.SQUARE;
        Intrinsics.checkNotNullParameter(r111, "iconShape");
        r110.k = r111;
        Boolean r20 = Boolean.FALSE;
        obb.a r112 = new obb.a(r20, r20, Integer.valueOf(r14.b));
        if (r15 == null) goto L51;
        r4 = r15.b;
    L51:
        r112.g = r4;
        r110.l = r112;
        Integer[] r113 = sbb.d.a;
        if (r11 != null) goto L54;
    L57:
        Integer[] r114 = sbb.d.a;
        if (r0 == false) goto L60;
    L67:
        Log.i("DOCS_ICON_DocsIconHelper", "calcSpaceLiteralIconColorRes result index= 0");
        int r115 = r114[0].intValue();
    L68:
        r110.h = Integer.valueOf(r115);
        r110.g = Integer.valueOf(r14.a.getContext().getResources().getColor(2131100557));
        IconScene r116 = IconScene.WIKI;
        Intrinsics.checkNotNullParameter(r116, "scene");
        r110.m = r116;
        mbb.c.h(r14.a, new obb.c(r110));
        return;
    L60:
        if (r11.length() <= 4) goto L67;
        r1 = (CastIntegerProtector.parseInt(r11.subSequence(r11.length() - 4, r11.length()).toString()) & 4095) % 10;     // Catch: Exception -> L64
    L66:
        Log.i("DOCS_ICON_DocsIconHelper", "calcSpaceLiteralIconColorRes result index= " + r1);
        r115 = r114[r1].intValue();
    L64:
        e = move-exception;
        Log.e("DOCS_ICON_DocsIconHelper", "calcSpaceLiteralIconThemeIdx fail: " + e);
        goto L66
    L54:
        if (r11.length() == 0) goto L57;
        r0 = false;
        goto L57
    L70:
        r19 = yu5.c.k(StringsKt.trim(r12).toString(), 1);     // Catch: Exception -> L43
    L43:
        e = move-exception;
        tt5.a.d("WikiSpaceIconFactory", "calcSpaceFirstChar fail: " + e);
        goto L45
    L29:
        if (r3.intValue() != 2) goto L31;
    L32:
        r6 = true;
        goto L33
    L25:
        if (r3.intValue() == 1) goto L32;
    L21:
        if (r3.intValue() == 0) goto L32;
    L74:
        r3 = Integer.valueOf(JSONObjectProtectorUtils.getInt(new JSONObject(r13), ResourceData.KEY_TYPE));     // Catch: Exception -> L14
    L14:
        e = move-exception;
        tt5.a.d("WikiSpaceIconFactory", "tryToFindIconType fail: " + e);
        goto L16
    L5:
        if (r13.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
