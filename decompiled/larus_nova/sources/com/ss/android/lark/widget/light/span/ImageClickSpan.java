package com.ss.android.lark.widget.light.span;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.auditsdk.v2.AuthorizationServiceV2;
import com.ss.android.lark.security.compliance.api.model.filepolicy.ValidateResult;
import com.ss.android.lark.widget.light.LKUILightTextView;
import com.ss.android.lark.widget.span.ImageInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class ImageClickSpan extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageInfo f446197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pwa.a f446198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f446199c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.ss.android.lark.widget.span.m f446200d;

    public final int hashCode() {
        return this.f446197a.hashCode();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ImageClickSpan) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f446197a, ((ImageClickSpan) r100).f446197a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        if ((r100 instanceof mcc.m) == true) goto L6;
        return;
    L6:
        if (((e) this.f446199c.getValue()).a() == true) goto L8;
        return;
    L8:
        Drawable r101 = null;
        if (r100.getTag(R.id.tag_long_press) == null) goto L11;
        r100.setTag(R.id.tag_long_press, null);
        return;
    L11:
        AuthorizationServiceV2 r102 = owa.a.c();
        pwa.a r103 = this.f446198b;
        if (r103 == null) goto L14;
        ValidateResult r104 = r103.f530855a;
    L15:
        r102.a(r104, AuthorizationServiceV2.AuthorizationType.RECEIVE_AUTHORIZATION);
        AuthorizationServiceV2 r105 = owa.a.c();
        pwa.a r106 = this.f446198b;
        if (r106 == null) goto L18;
        ValidateResult r107 = r106.f530856b;
    L19:
        r105.a(r107, AuthorizationServiceV2.AuthorizationType.PREVIEW_AUTHORIZATION);
        mcc.g r108 = (mcc.g) r100;
        mcc.p r109 = new mcc.p();
        ImageInfo r110 = this.f446197a;
        String r111 = r110.key;
        r109.f513256b = r110.url;
        r109.f513257c = r110.token;
        int r112 = r110.viewWidth;
        if (r112 != 0) goto L23;
        r112 = r110.width;
    L23:
        r109.f513258d = r112;
        int r113 = r110.viewHeight;
        if (r113 != 0) goto L27;
        r113 = r110.height;
    L27:
        r109.f513259e = r113;
        if ((r100 instanceof LKUILightTextView) == false) goto L48;
        Layout r114 = ((LKUILightTextView) r100).getLayout();
        if (r114 == null) goto L33;
        CharSequence r115 = r114.getText();
    L35:
        if ((r115 instanceof Spannable) == false) goto L48;
        if (((Spannable) r115).getSpanStart(this) < 0) goto L48;
        com.ss.android.lark.widget.span.m r116 = this.f446200d;
        if (r116 == null) goto L43;
        Rect r117 = r116.a(r100);
    L44:
        r109.f513260f = r117.left;
        r109.f513261g = r117.top;
        com.ss.android.lark.widget.span.m r118 = this.f446200d;
        if (r118 == null) goto L47;
        r101 = r118.b();
    L47:
        r109.f513262h = r101;
        r109.f513255a.putAll(this.f446197a.extras);
        goto L48
    L43:
        r117 = new Rect();
        goto L44
    L33:
        r115 = null;
    L48:
        r108.j(r100, r109);
        return;
    L18:
        r107 = null;
        goto L19
    L14:
        r104 = null;
        goto L15
    }

    public ImageClickSpan(ImageInfo r100, pwa.a r101) {
        Intrinsics.checkNotNullParameter(r100, "mImageInfo");
        this.f446197a = r100;
        this.f446198b = r101;
        this.f446199c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ImageClickSpan$clickThrottle$2.INSTANCE);
    }
}
