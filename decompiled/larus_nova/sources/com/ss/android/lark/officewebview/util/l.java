package com.ss.android.lark.officewebview.util;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.android.lark.officesdk.utils.di.TTWebViewUtil;
import com.ss.android.lark.officesdk.utils.di.r;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import otb.n;
import swb.p;

/* JADX INFO: loaded from: classes37.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f437552a;

    public l() {
    }

    public final void c(WebView r110) {
        int r100 = com.ss.android.lark.officesdk.utils.di.g.f437223a;
        if (com.ss.android.lark.officesdk.utils.di.g.a.a("openplatform.disable.chromium.debugger.view") == false) goto L6;
        com.ss.android.lark.officesdk.utils.di.j.e("WebViewChromiumDebuggerUtils", "disable chromium debugger view,return");
        return;
    L6:
        if (r110 != null) goto L8;
    L46:
        com.ss.android.lark.officesdk.utils.di.j.e("WebViewChromiumDebuggerUtils", "no parent，return");
        return;
    L8:
        if (r110.getParent() == null) goto L46;
        Context r101 = r110.getContext();
        int r102 = com.ss.android.lark.officesdk.utils.di.e.f437221a;
        if (com.ss.android.lark.officesdk.utils.di.e.a.b(r101) == true) goto L13;
        return;
    L13:
        int r103 = r.f437233a;
        Intrinsics.checkNotNullParameter("open_platform", "domain");
        Intrinsics.checkNotNullParameter("web_chromium_debugger_type", "key");
        if (r.a.a().e() == true) goto L17;
        com.ss.android.lark.officesdk.utils.di.j.e("WebViewChromiumDebuggerUtils", "user closed");
        return;
    L17:
        com.ss.android.lark.officesdk.utils.di.j.e("WebViewChromiumDebuggerUtils", "try add chromiumDebug View");
        if (this.f437552a != null) goto L37;
        TextView r104 = new TextView(r110.getContext());
        Lazy<n> r105 = TTWebViewUtil.f437209a;
        TTWebViewUtil.a.d(r110);
        String r106 = r110.getSettings().getUserAgentString();
        String r107 = "system chromium---";
        if (TextUtils.isEmpty(r106) == true) goto L27;
        String[] r108 = r106.split(" ");
        int r109 = r108.length;
        int r111 = 0;
    L22:
        if (r111 >= r109) goto L27;
        String r112 = r108[r111];
        if (r112.startsWith("Chrome/") == true) goto L25;
        r111 = r111 + 1;
        goto L22
    L25:
        r107 = "system chromium---" + r112.split(HTTP.URL_DEFAULT)[1];
    L27:
        String r113 = "current chromium is : " + r107;
        int r114 = r.f437233a;
        Intrinsics.checkNotNullParameter("open_platform", "domain");
        Intrinsics.checkNotNullParameter("cachedChromium", "key");
        String r115 = "";
        Intrinsics.checkNotNullParameter("", "defaultValue");
        String r116 = r.a.a().getString();
        if (TextUtils.isEmpty(r116) == true) goto L31;
        r115 = "\nLast launch is : " + r116;
    L31:
        if (TextUtils.isEmpty(r107) == false) goto L33;
    L35:
        r104.setText("This will not be shown in the online app,you can close in debugger:\n" + r113 + r115);
        r104.setTextSize(10.0f);
        r104.setTextColor(-16777216);
        GradientDrawable r117 = new GradientDrawable();
        r117.setColor(FakePickerAvatarCreator.GREEN);
        r104.setBackground(r117);
        r104.setAlpha(0.75f);
        r104.setVisibility(0);
        this.f437552a = r104;
        goto L37
    L33:
        if (TextUtils.equals(r107, r116) == true) goto L35;
        Intrinsics.checkNotNullParameter("open_platform", "domain");
        Intrinsics.checkNotNullParameter("cachedChromium", "key");
        Intrinsics.checkNotNullParameter(r107, "value");
        r.a.a().b(r107);
    L37:
        if ((r110.getParent() instanceof FrameLayout) == false) goto L40;
        a(true, (FrameLayout) r110.getParent());
        return;
    L40:
        if ((r110.getParent().getParent() instanceof ConstraintLayout) == false) goto L43;
        b(true, (ConstraintLayout) r110.getParent().getParent());
        return;
    L43:
        if ((r110.getParent().getParent() instanceof FrameLayout) == false) goto L52;
        a(true, (FrameLayout) r110.getParent().getParent());
        return;
    }

    public final void a(boolean r100, FrameLayout r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if ((r101 instanceof ScrollView) == false) goto L7;
        return;
    L7:
        if (r101.indexOfChild(this.f437552a) < 0) goto L11;
        if (r100 == true) goto L17;
        r101.removeView(this.f437552a);
        return;
    L17:
        return;
    L11:
        if (r100 == true) goto L13;
        return;
    L13:
        if (this.f437552a.getParent() == null) goto L15;
        ((FrameLayout) this.f437552a.getParent()).removeView(this.f437552a);
    L15:
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(-1, -2, 83);
        r101.addView(this.f437552a, r102);
    }

    public final void b(boolean r100, ConstraintLayout r101) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.indexOfChild(this.f437552a) < 0) goto L9;
        if (r100 == true) goto L15;
        r101.removeView(this.f437552a);
        return;
    L15:
        return;
    L9:
        if (r100 == true) goto L11;
        return;
    L11:
        if (this.f437552a.getParent() == null) goto L13;
        ((FrameLayout) this.f437552a.getParent()).removeView(this.f437552a);
    L13:
        ConstraintLayout.LayoutParams r102 = new ConstraintLayout.LayoutParams(-1, -2);
        r102.bottomToBottom = 0;
        r102.setMargins(0, 0, 0, p.a(r101.getContext(), 40.0f));
        r101.addView(this.f437552a, r102);
    }
}
