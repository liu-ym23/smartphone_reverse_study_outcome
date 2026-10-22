package com.larus.login.impl.utils;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.larus.account.base.model.PhoneOneKeyPlatform;
import com.larus.network.HttpConst;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class n extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ URLSpan f358332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Fragment f358333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PhoneOneKeyPlatform f358334c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f358335d;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        String r101 = this.f358332a.getURL();
        if (r101 != null) goto L5;
        return;
    L5:
        switch(r101.hashCode()) {
            case 3598498: goto L26;
            case 3598499: goto L20;
            case 3598500: goto L14;
            case 3598501: goto L8;
            default: goto L40;
        };
    L40:
        return;
    L8:
        if (r101.equals("url4") == false) goto L41;
        int r102 = m.f358328b;
        if (m.a() == true) goto L33;
        m.b(this.f358333b, this.f358334c);
        return;
    L33:
        return;
    L41:
        return;
    L14:
        if (r101.equals("url3") == false) goto L42;
        int r103 = m.f358328b;
        if (m.a() == true) goto L35;
        Fragment r104 = this.f358333b;
        HttpConst.f359979a.getClass();
        m.c(r104, HttpConst.N);
        return;
    L35:
        return;
    L42:
        return;
    L20:
        if (r101.equals("url2") == false) goto L43;
        int r105 = m.f358328b;
        if (m.a() == true) goto L37;
        Fragment r106 = this.f358333b;
        HttpConst.f359979a.getClass();
        m.c(r106, HttpConst.M);
        return;
    L37:
        return;
    L43:
        return;
    L26:
        if (r101.equals("url1") == false) goto L44;
        int r107 = m.f358328b;
        if (m.a() == true) goto L39;
        Fragment r108 = this.f358333b;
        HttpConst.f359979a.getClass();
        m.c(r108, HttpConst.L);
        return;
    L39:
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        super.updateDrawState(r100);
        r100.setUnderlineText(false);
        r100.setColor(this.f358335d);
    }

    public n(URLSpan r100, Fragment r101, PhoneOneKeyPlatform r102, int r103) {
        this.f358332a = r100;
        this.f358333b = r101;
        this.f358334c = r102;
        this.f358335d = r103;
    }
}
