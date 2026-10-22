package com.lynx.clay.embedding.engine.plugins.externalview;

import android.graphics.SurfaceTexture;
import com.lynx.clay.embedding.engine.plugins.ClayPluginContext;
import k5a.a;
import m5a.d;
import m5a.h;
import m5a.p;
import m5a.q;

/* JADX INFO: loaded from: classes32.dex */
public class ExternalViewPlugin {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ClayPluginContext f380825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f380826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f380827c;

    public static native void nativeOnSurfaceTextureDestroyed(long r100, SurfaceTexture r101);

    public static native void nativeOnSurfaceTextureReady(long r100, SurfaceTexture r101, int r102, int r103);

    public static native void nativeOnSurfaceTextureSizeChanged(long r100, SurfaceTexture r101, int r102, int r103);

    public void onAttachToTree() {
        d r100 = this.f380826b;
        if (r100 == null) goto L6;
        a r101 = r100.f512167e;
        return;
    }

    public void onDetachToTree() {
        d r100 = this.f380826b;
        if (r100 == null) goto L9;
        a r101 = r100.f512167e;
        if (r101 == null) goto L7;
        ((p) r101).f512190a.setVisible(false);
    L7:
        this.f380826b = null;
        return;
    }

    public void onViewDestroy() {
        d r100 = this.f380826b;
        if (r100 == null) goto L19;
        a r101 = r100.f512167e;
        if (r101 == null) goto L15;
        q r102 = ((p) r101).f512190a;
        r102.f512203m = true;
        h r103 = h.f512176e;
        int r104 = r102.f512213w;
        if (r103.f512178b.get(Integer.valueOf(r104)) != r102) goto L10;
        r103.f512178b.remove(Integer.valueOf(r104));
    L10:
        if (r102.f512196f.isShowing() == true) goto L17;
        r102.g();
        goto L15
    L17:
        q.b(r102.f512196f);     // Catch: RuntimeException -> L13
    L13:
        r102.g();
    L15:
        this.f380826b = null;
        return;
    }

    private void changeVisibility(boolean r100) {
        d r101 = this.f380826b;
        if (r101 == null) goto L6;
        r101.setVisible(r100);
        return;
    }

    public ExternalViewPlugin(ClayPluginContext r100, long r101) {
        this.f380827c = 0;
        this.f380825a = r100;
        this.f380827c = r101;
    }

    private static ExternalViewPlugin createPlugin(ClayPluginContext r100, long r101) {
        return new ExternalViewPlugin(r100, r101);
    }

    public boolean onCreateView(int r100, String r101) {
        if (this.f380825a.f380756a == null) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        return false;
    L8:
        d r103 = new d(this.f380825a.f380756a.getContext());
        this.f380826b = r103;
        r103.setExternalViewPlugin(this);
        return true;
    L5:
        r102 = false;
        goto L6
    }
}
