package com.bytedance.awemeopen.apps.framework.base.view;

import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.qqmusic.third.api.contract.CommonCmd;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class i extends LinkMovementMethod {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f193246b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ProfileSignatureView.c f193247a;

    public static final class a {
    }

    static {
        f193246b = new i();
    }

    public i() {
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public final boolean onTouchEvent(TextView r100, Spannable r110, MotionEvent r111) {
        if (r111 == null) goto L65;
        if (r100 == null) goto L65;
        if (r110 == null) goto L65;
        Intrinsics.checkNotNullParameter(r100, CommonCmd.AIDL_PLATFORM_TYPE_TV);
        Intrinsics.checkNotNullParameter(r111, "event");
        Intrinsics.checkNotNullParameter(ProfileSignatureView.c.class, "clazz");
        CharSequence r101 = r100.getText();
        if ((r101 instanceof Spanned) == false) goto L35;
        float r102 = (r111.getX() - r100.getTotalPaddingLeft()) + r100.getScrollX();
        float r103 = (r111.getY() - r100.getTotalPaddingTop()) + r100.getScrollY();
        Layout r104 = r100.getLayout();
        int r105 = r104.getLineForVertical((int) r103);     // Catch: Exception -> L66
        if (r105 == (r104.getLineCount() - 1)) goto L13;
    L15:
        int r106 = r104.getOffsetForHorizontal(r105, r102);     // Catch: Exception -> L66
        Spanned r107 = (Spanned) r101;
        ClickableSpan[] r108 = (ClickableSpan[]) r107.getSpans(r106, r106, ProfileSignatureView.c.class);
        if (r108 != null) goto L19;
    L25:
        boolean r109 = false;
    L26:
        if (r109 == false) goto L35;
        ClickableSpan r112 = r108[0];
        if (r106 >= r107.getSpanStart(r112)) goto L30;
    L32:
        boolean r113 = false;
    L33:
        if (r113 == false) goto L35;
        ClickableSpan r114 = r108[0];
    L36:
        ProfileSignatureView.c r115 = (ProfileSignatureView.c) r114;
        if (r115 == null) goto L39;
        int r116 = r111.getAction();
        if (r116 == 0) goto L62;
        if (r116 == 1) goto L57;
        if (r116 == 2) goto L53;
        if (r116 != 3) goto L61;
        if (this.f193247a == null) goto L61;
        this.f193247a = null;
        return true;
    L61:
        return super.onTouchEvent(r100, r110, r111);
    L53:
        if (Intrinsics.areEqual(this.f193247a, r115) == true) goto L55;
        this.f193247a = null;
    L55:
        return true;
    L57:
        if (Intrinsics.areEqual(r115, this.f193247a) == false) goto L61;
        r115.onClick(r100);
        this.f193247a = null;
        return true;
    L62:
        this.f193247a = r115;
        return true;
    L39:
        return super.onTouchEvent(r100, r110, r111);
    L30:
        if (r106 > r107.getSpanEnd(r112)) goto L32;
        r113 = true;
        goto L33
    L19:
        if (r108.length != 0) goto L21;
        boolean r117 = true;
    L23:
        if ((!r117) != true) goto L25;
        r109 = true;
        goto L26
    L21:
        r117 = false;
        goto L23
    L13:
        if (r104.getLineWidth(r105) >= r102) goto L15;
    L35:
        r114 = null;
    L65:
        return super.onTouchEvent(r100, r110, r111);
    }
}
