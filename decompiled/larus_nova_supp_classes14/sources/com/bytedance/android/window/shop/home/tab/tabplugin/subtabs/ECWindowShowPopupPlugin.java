package com.bytedance.android.window.shop.home.tab.tabplugin.subtabs;

import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin;
import com.bytedance.android.window.shop.home.tab.tabplugin.c;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowShowPopupPlugin extends ECWindowJsbPlugin {
    public final ViewGroup b;
    public final String c;
    public final ViewGroup d;
    public final LifecycleOwner e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin
    public final List<c> c() {
        return CollectionsKt.listOf(new c("ecom.window.popup", new ECWindowShowPopupPlugin$createJsbActions$1(this)));
    }

    public ECWindowShowPopupPlugin(String r2, ViewGroup r3, LifecycleOwner r4) {
        Intrinsics.checkNotNullParameter(r2, "secAuthorId");
        Intrinsics.checkNotNullParameter(r3, "rootView");
        Intrinsics.checkNotNullParameter(r4, "lifecycleOwner");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        ViewParent r5 = r3.getParent();
    L4:
        if ((r5 instanceof ViewGroup) == false) goto L12;
        r3 = (ViewGroup) r5;
        ViewParent r6 = r3.getParent();
        if ((r6 instanceof ViewGroup) == true) goto L8;
        r6 = null;
    L8:
        r5 = (ViewGroup) r6;
        if (r5 == null) goto L12;
        if ((!Intrinsics.areEqual(r5, r3)) == true) goto L4;
    L12:
        this.b = r3;
    }
}
