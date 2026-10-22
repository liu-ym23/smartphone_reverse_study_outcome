package com.ss.android.lark.chat.chatwindow.biz.component.banner;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.view.SizeDetectFrameLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f411970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f411971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Integer, wya.b<? extends wya.c>> f411972c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f411973d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f411974e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.ss.android.lark.chat.chatwindow.biz.component.banner.b f411975f;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.biz.component.banner.a$a, reason: collision with other inner class name */
    public static final class C4793a {
    }

    public interface b {
        void a();

        void b();

        void onShow();
    }

    static {
    }

    public final void a(int r100) {
        Log.d("BannerController", "hideBanner:" + r100);
        wya.b r101 = (wya.b) ((LinkedHashMap) this.f411972c).get(Integer.valueOf(r100));
        if (r101 == null) goto L5;
        r101.b(false);
        r101.getListener();
    L5:
        UICallbackExecutor.executeDelayed(this.f411975f, 0);
    }

    public a(SizeDetectFrameLayout r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, "mBannerContainer");
        Intrinsics.checkNotNullParameter(r101, "mVisibilityListener");
        this.f411970a = r100;
        this.f411971b = r101;
        this.f411972c = new LinkedHashMap();
        this.f411975f = new com.ss.android.lark.chat.chatwindow.biz.component.banner.b(this);
    }

    public final void b(int r100, wya.c r101) {
        Log.d("BannerController", "showBanner:" + r100);
        wya.b r102 = (wya.b) ((LinkedHashMap) this.f411972c).get(Integer.valueOf(r100));
        if (r102 != null) goto L6;
        return;
    L6:
        if (r102.getBanner() != null) goto L8;
        r102.c(LayoutInflater.from(this.f411970a.getContext()).inflate(r102.getLayoutId(), this.f411970a, false), r101);
    L9:
        r102.b(true);
        r102.getListener();
        UICallbackExecutor.executeDelayed(this.f411975f, 0);
        return;
    L8:
        r102.d(r101);
        goto L9
    }
}
