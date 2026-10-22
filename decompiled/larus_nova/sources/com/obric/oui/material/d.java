package com.obric.oui.material;

import android.graphics.Color;
import com.obric.oui.color.i0;
import com.obric.oui.graphic.BlendMode;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f401462a = 0;

    static {
    }

    public static c[] a(c[] r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "baseConfigs");
        int r100 = Color.alpha(r111);
        float[] r101 = new float[3];
        Color.colorToHSV(r111, r101);
        r101[1] = Math.max(0.0f, r101[1] - 0.1f);
        int r102 = (r100 << 24) | (Color.HSVToColor(r101) & 16777215);
        int r103 = Color.argb(102, Color.red(r102), Color.green(r102), Color.blue(r102));
        ArrayList r104 = new ArrayList(r110.length);
        int r105 = r110.length;
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L9;
        c r107 = r110[r106];
        c r108 = r107.a();
        r108.f401454c = new com.obric.oui.color.a[]{new com.obric.oui.color.a(-2130706433, BlendMode.SRC_OVER), new com.obric.oui.color.a(FakePickerAvatarCreator.LTGRAY, BlendMode.OVERLAY), new com.obric.oui.color.a(r102, BlendMode.PLUS_DARKER)};
        i0 r109 = r107.f401456e;
        if (r109 != null) goto L7;
        i0 r112 = null;
    L8:
        r108.f401456e = r112;
        r104.add(r108);
        r106 = r106 + 1;
        goto L3
    L7:
        r112 = new i0(r109.f399493a, r103, r109.f399495c);
        goto L8
    L9:
        Object[] r113 = r104.toArray(new c[0]);
        if (r113 == null) goto L14;
        return (c[]) r113;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }
}
