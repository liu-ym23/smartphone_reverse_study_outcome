package com.bytedance.lynx.media.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.lynx.tasm.base.LLog;
import com.ss.ttm.player.PlaybackParams;
import com.ss.ttvideoengine.DataSource;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.VideoEngineCallback;
import com.ss.ttvideoengine.VideoEngineInfoListener;
import com.ss.ttvideoengine.model.VideoRef;
import f07.c;
import g07.b;
import i07.a;

/* JADX INFO: loaded from: classes21.dex */
public class BaseMediaView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f264836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f264837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public VideoEngineCallback f264838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public VideoEngineInfoListener f264839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f264840e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public DataSource f264841f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Boolean f264842g;

    public final boolean d() {
        if (this.f264836a != null) goto L5;
    L9:
        LLog.e("BaseMediaView", "setUpController first before any action");
        return false;
    L5:
        if (this.f264837b == null) goto L9;
        return true;
    }

    public final boolean e() {
        if (this.f264842g.booleanValue() == false) goto L5;
        return true;
    L5:
        c r100 = this.f264837b;
        if (r100 != null) goto L8;
    L10:
        return false;
    L8:
        if (r100.f474996m == false) goto L10;
        return true;
    }

    public final void f() {
        if (d() == true) goto L5;
        return;
    L5:
        c r100 = this.f264837b;
        if (r100.f474984a == null) goto L9;
        r100.f474984a.pause();
        return;
    }

    public int getDuration() {
        if (d() == true) goto L6;
        return -1;
    L6:
        c r100 = this.f264837b;
        if (r100.f474984a != null) goto L11;
        return 0;
    L11:
        return r100.f474984a.getDuration();
    }

    public BaseMediaView(Context r100) {
        this(r100, null);
    }

    public void setDataSource(DataSource r100) {
        this.f264841f = r100;
    }

    public void setLoop(boolean r100) {
        if (d() == true) goto L5;
        return;
    L5:
        c r101 = this.f264837b;
        if (r101.f474984a == null) goto L9;
        r101.f474984a.setLooping(r100);
        return;
    }

    public void setMediaVideoEngineCallback(a r100) {
        this.f264840e = r100;
    }

    public void setMute(boolean r100) {
        if (d() == true) goto L5;
        return;
    L5:
        c r101 = this.f264837b;
        if (r101.f474984a == null) goto L9;
        r101.f474984a.setIsMute(r100);
        return;
    }

    public void setResolution(String r100) {
        if (d() == true) goto L5;
        return;
    L5:
        c r101 = this.f264837b;
        Resolution[] r102 = Resolution.values();
        int r103 = r102.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L11;
        Resolution r105 = r102[r104];
        if (TextUtils.equals(r100, r105.toString(VideoRef.TYPE_VIDEO)) == true) goto L13;
        r104 = r104 + 1;
    L13:
        if (r101.f474984a == null) goto L18;
        Resolution r106 = Resolution.Undefine;
        r101.f474984a.configResolution(r105);
        return;
    L18:
        return;
    L11:
        r105 = Resolution.Standard;
        goto L13
    }

    public void setSpeed(float r100) {
        if (d() == true) goto L5;
        return;
    L5:
        c r101 = this.f264837b;
        if (r101.f474984a != null) goto L8;
        return;
    L8:
        if (r101.f474992i.getSpeed() != (-1.0f)) goto L10;
        r101.f474992i.setSpeed(1.0f);
    L10:
        PlaybackParams r102 = r101.f474992i;
        r102.setSpeed(r100);
        r101.f474984a.setPlaybackParams(r102);
    }

    public void setVideoEngineCallback(VideoEngineCallback r100) {
        this.f264838c = r100;
        c r101 = this.f264837b;
        if (r101 == null) goto L6;
        r101.f474988e = r100;
        return;
    }

    public void setVideoEngineInfoListener(VideoEngineInfoListener r100) {
        this.f264839d = r100;
        c r101 = this.f264837b;
        if (r101 == null) goto L6;
        r101.f474989f = r100;
        return;
    }

    public void setVolume(float r100) {
        if (d() == true) goto L6;
        return;
    L6:
        if (r100 >= 0.0f) goto L8;
        return;
    L8:
        if (r100 > 1.0f) goto L16;
        c r101 = this.f264837b;
        if (r101.f474984a == null) goto L17;
        if (r100 < 0.0f) goto L18;
        if (r100 > 1.0f) goto L19;
        r101.f474984a.setIntOption(415, 1);
        r101.f474984a.setVolume(r100, r100);
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    public BaseMediaView(Context r100, AttributeSet r101) {
        super(r100, r101, 0);
        this.f264836a = null;
        this.f264837b = null;
        this.f264842g = Boolean.FALSE;
    }

    public void g(b r100, f07.a r101) {
        if (this.f264836a != r100) goto L5;
        return;
    L5:
        c r102 = new c(getContext(), r100);
        this.f264837b = r102;
        r102.f474991h = r101;
        VideoEngineCallback r103 = this.f264838c;
        if (r103 == null) goto L8;
        r102.f474988e = r103;
    L8:
        VideoEngineInfoListener r104 = this.f264839d;
        if (r104 == null) goto L11;
        r102.f474989f = r104;
    L11:
        DataSource r105 = this.f264841f;
        if (r105 == null) goto L14;
        r102.f474990g = r105;
    L14:
        this.f264836a = r100;
    }
}
