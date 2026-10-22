package ql4;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.dux.dialog.alert.d;
import com.bytedance.dux.dialog.base.AbstractDialog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements jm4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractDialog f533767a;

    public a(d r100) {
        this.f533767a = r100;
    }

    @Override // jm4.b
    public final void a(hm4.d r100) {
        Intrinsics.checkNotNullParameter(r100, "breakPointUpdate");
        AbstractDialog r101 = this.f533767a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "breakPointUpdate");
        if (r101.f204970i == false) goto L27;
        View r102 = r101.f204964c;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if (r103 == null) goto L26;
        FrameLayout.LayoutParams r104 = (FrameLayout.LayoutParams) r103;
        int r105 = im4.a.f490534a;
        Intrinsics.checkNotNullParameter(r100, "breakPointUpdate");
        hm4.b r106 = r100.f485934b;
        jm4.a.f499636a.getClass();
        if (Intrinsics.areEqual(r106, jm4.a.C6460a.f499638b) == false) goto L10;
        boolean r107 = true;
    L11:
        if (r107 == false) goto L13;
        boolean r108 = true;
    L14:
        if (r108 == false) goto L16;
        boolean r109 = true;
    L17:
        if (r109 == false) goto L19;
        boolean r110 = true;
    L20:
        if (r110 == false) goto L22;
        int r111 = r100.f485936d.f485916c;
    L23:
        r104.width = r111;
        r102.setLayoutParams(r104);
        return;
    L22:
        r111 = MathKt.roundToInt(TypedValue.applyDimension(1, 420, im4.a.a(Resources.getSystem())));
        goto L23
    L19:
        r110 = Intrinsics.areEqual(r106, hm4.b.f485921f);
        goto L20
    L16:
        r109 = Intrinsics.areEqual(r106, hm4.b.f485920e);
        goto L17
    L13:
        r108 = Intrinsics.areEqual(r106, hm4.b.f485919d);
        goto L14
    L10:
        r107 = Intrinsics.areEqual(r106, hm4.b.f485918c);
        goto L11
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }
}
