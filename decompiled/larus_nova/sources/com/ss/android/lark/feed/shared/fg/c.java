package com.ss.android.lark.feed.shared.fg;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.api.bean.ForsetiMode;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final peb.b.f f421187a = null;

    static {
        f421187a = heb.a.f484903a.getFeatureGatingDependency();
    }

    @JvmStatic
    public static final boolean a() {
        if (f421187a.isCurrentEnable("im.feed.priority_message") == false) goto L7;
        int r100 = neb.c.f518914a;
        if (((neb.a) k.a(LarkContext.getApplication(), neb.a.class)).e1() == false) goto L7;
        return true;
    L7:
        return false;
    }

    @JvmStatic
    public static final boolean c() {
        return f421187a.isEnable("lark.feed.feed_click_hint");
    }

    @JvmStatic
    public static final boolean b(FragmentActivity r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (ForsetiConfig.a(r100) == true) goto L8;
        return false;
    L8:
        if (c() == false) goto L18;
        tua.b r101 = ((sua.a) ApiUtils.getApi(sua.a.class)).tryGetChainManager(r100);
        if (r101 == null) goto L12;
        ForsetiMode r102 = r101.T();
    L14:
        if (r102 != ForsetiMode.Regular) goto L19;
        return true;
    L19:
        return false;
    L12:
        r102 = null;
        goto L14
    L18:
        return false;
    }
}
