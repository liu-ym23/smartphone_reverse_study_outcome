package com.bytedance.ee.bear.document.onboarding;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.TitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class c extends vk5.a {
    public final TitleBar g;
    public final View h;

    public boolean a() {
        if (this.h != null) goto L5;
    L7:
        return false;
    L5:
        if (this.g == null) goto L7;
        return true;
    }

    public c(tk5.b r1, FragmentActivity r2, TitleBar r3, View r4) {
        super(r2, r1);
        this.g = r3;
        this.h = r4;
    }
}
