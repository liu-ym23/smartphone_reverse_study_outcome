package com.lynx.clay.embedding.engine.plugins.overlay;

import com.lynx.clay.embedding.engine.plugins.ClayPluginContext;
import com.lynx.clay.embedding.engine.plugins.externalview.ExternalViewPlugin;
import m5a.h;
import m5a.q;

/* JADX INFO: loaded from: classes32.dex */
public class OverlayPlatformPluginAndroid {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f380837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f380838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public q f380839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ClayPluginContext f380840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f380841e;

    public static native void nativeOnDialogBackPressed(long r100);

    public static native void nativeUpdateRootPosOffset(long r100, int r101, int r102);

    private void changeVisibility(boolean r100) {
        q r101 = this.f380839c;
        if (r101 == null) goto L6;
        r101.setVisible(r100);
        return;
    }

    public void setAndroidFullScreen(boolean r100) {
        q r101 = this.f380839c;
        if (r101 == null) goto L6;
        r101.setFullScreen(r100);
        return;
    }

    public void setAndroidNativeEventPass(boolean r100) {
        q r101 = this.f380839c;
        if (r101 == null) goto L6;
        r101.setNativeEventPass(r100);
        return;
    }

    public void setAndroidSoftInputMode(String r100) {
        q r101 = this.f380839c;
        if (r101 == null) goto L6;
        r101.setAndroidSetSoftInputMode(r100);
        return;
    }

    public void setCutOutMode(boolean r100) {
        q r101 = this.f380839c;
        if (r101 == null) goto L6;
        r101.setCutOutMode(r100);
        return;
    }

    public void setLevel(int r100) {
        q r101 = this.f380839c;
        if (r101 == null) goto L6;
        r101.setLevel(r100);
        return;
    }

    public void setStatusBarTranslucent(boolean r100) {
        q r101 = this.f380839c;
        if (r101 == null) goto L6;
        r101.setStatusBarTranslucent(r100);
        return;
    }

    public void setStatusBarTranslucentStyle(String r100) {
        q r101 = this.f380839c;
        if (r101 == null) goto L6;
        r101.setStatusBarTranslucentStyle(r100);
        return;
    }

    public OverlayPlatformPluginAndroid(ClayPluginContext r100, long r101) {
        this.f380837a = 0;
        this.f380838b = "";
        this.f380839c = null;
        this.f380841e = 0;
        this.f380840d = r100;
        this.f380841e = r101;
    }

    private static OverlayPlatformPluginAndroid createPlugin(ClayPluginContext r100, long r101) {
        return new OverlayPlatformPluginAndroid(r100, r101);
    }

    public void onCreateNode(int r100, String r101, ExternalViewPlugin r102) {
        this.f380837a = r100;
        this.f380838b = r101;
        q r103 = new q(this.f380840d.f380756a.getContext(), this.f380837a, this.f380838b, this.f380840d.f380756a, r102);
        this.f380839c = r103;
        h.f512176e.f512178b.put(Integer.valueOf(r100), r103);
        this.f380839c.setOverlayPlatformPluginAndroid(this);
    }
}
