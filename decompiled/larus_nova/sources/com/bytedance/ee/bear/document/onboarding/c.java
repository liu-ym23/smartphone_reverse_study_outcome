package com.bytedance.ee.bear.document.onboarding;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.TitleBar;

/* JADX INFO: loaded from: classes16.dex */
public class c extends vk5.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TitleBar f220705g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f220706h;

    @Override // vk5.a
    public boolean a() {
        if (this.f220706h != null) goto L5;
    L7:
        return false;
    L5:
        if (this.f220705g == null) goto L7;
        return true;
    }

    public c(tk5.b r100, FragmentActivity r101, TitleBar r102, View r103) {
        super(r101, r100);
        this.f220705g = r102;
        this.f220706h = r103;
    }
}
