package com.ss.bytertc.engine;

import android.app.Application;
import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;

/* JADX INFO: loaded from: classes40.dex */
public class AudioFocusManager {
    private boolean isAudioFocusLoss;
    private Application.ActivityLifecycleCallbacks mActivityLifecycleCallback;
    private AudioManager mAudioManager;
    private Callback mCallback;
    private Context mContext;
    private AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener;

    public interface Callback {
        void higherVolume();

        void lowerVolume();

        void startMicrophone();

        void startSpeakerphone();

        void stopMicrophone();

        void stopSpeakerphone();
    }

    public void releaseAudioFocus() {
        releaseAudioFocus(false);
    }

    private AudioManager getAudioManager() {
        if (this.mAudioManager != null) goto L6;
        this.mAudioManager = (AudioManager) this.mContext.getApplicationContext().getSystemService("audio");
    L6:
        return this.mAudioManager;
    }

    public void release() {
        Context r100 = this.mContext;
        if ((r100 instanceof Application) == false) goto L5;
        ((Application) r100).unregisterActivityLifecycleCallbacks(this.mActivityLifecycleCallback);
    L5:
        releaseAudioFocus();
    }

    public void requestAudioFocus() {
        AudioManager r100 = getAudioManager();
        if (r100 != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 26) goto L7;
        r100.requestAudioFocus(this.onAudioFocusChangeListener, 3, 1);
    L8:
        this.isAudioFocusLoss = false;
        return;
    L7:
        r100.requestAudioFocus(new AudioFocusRequest.Builder(1).setOnAudioFocusChangeListener(this.onAudioFocusChangeListener).build());
        goto L8
    }

    public static /* synthetic */ Callback access$000(AudioFocusManager r100) {
        return r100.mCallback;
    }

    public static /* synthetic */ AudioManager access$200(AudioFocusManager r100) {
        return r100.getAudioManager();
    }

    public static /* synthetic */ boolean access$300(AudioFocusManager r100) {
        return r100.isAudioFocusLoss;
    }

    public static /* synthetic */ AudioManager.OnAudioFocusChangeListener access$400(AudioFocusManager r100) {
        return r100.onAudioFocusChangeListener;
    }

    private void releaseAudioFocus(boolean r100) {
        AudioManager r101 = getAudioManager();
        if (r101 != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 26) goto L7;
        r101.abandonAudioFocus(this.onAudioFocusChangeListener);
    L8:
        this.isAudioFocusLoss = r100;
        return;
    L7:
        r101.abandonAudioFocusRequest(new AudioFocusRequest.Builder(1).setOnAudioFocusChangeListener(this.onAudioFocusChangeListener).build());
        goto L8
    }

    public AudioFocusManager(final Context r100, Callback r101) {
        this.isAudioFocusLoss = false;
        this.mActivityLifecycleCallback = new AnonymousClass2(this);
        this.mContext = r100;
        this.mCallback = r101;
        this.onAudioFocusChangeListener = new AnonymousClass1(this, r100);
        Context r102 = this.mContext;
        if ((r102 instanceof Application) == false) goto L6;
        ((Application) r102).registerActivityLifecycleCallbacks(this.mActivityLifecycleCallback);
        return;
    }

    public static /* synthetic */ void access$100(AudioFocusManager r100, boolean r101) {
        r100.releaseAudioFocus(r101);
    }

    public static /* synthetic */ boolean access$302(AudioFocusManager r100, boolean r101) {
        r100.isAudioFocusLoss = r101;
        return r101;
    }
}
