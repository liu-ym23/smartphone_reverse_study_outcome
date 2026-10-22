package com.ss.android.lark.audio.opus;

import android.media.AudioManager;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes34.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f409062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AudioManager f409063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f409064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f409065d;

    public interface a {
    }

    public abstract boolean b(String r100, int r101);

    public abstract boolean c();

    public abstract boolean d();

    public abstract boolean e();

    public abstract boolean g();

    public abstract boolean h();

    public abstract boolean i(float r100);

    public abstract boolean k();

    public abstract boolean l();

    public abstract void m();

    public final boolean f() {
        AudioManager r100 = this.f409063b;
        if (r100 != null) goto L6;
        Log.w("Player", "isWiredHeadsetOn audioManager == null ");
        return false;
    L6:
        boolean r101 = r100.isWiredHeadsetOn();
        Log.w("Player", "isWiredHeadsetOn isWiredHeadsetOn:" + r101);
        return r101;
    }

    public l(AudioManager r100) {
        this.f409064c = 0.0f;
        this.f409063b = r100;
    }

    public void a(int r100) {
        this.f409062a = r100;
    }

    public void j(int r100) {
        if (r100 != 2) goto L5;
        this.f409063b.setSpeakerphoneOn(false);
        this.f409063b.setMode(3);
        return;
    L5:
        this.f409063b.setSpeakerphoneOn(true);
        this.f409063b.setMode(0);
    }
}
