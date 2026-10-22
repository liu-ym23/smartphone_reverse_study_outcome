package zmc;

import android.content.Context;
import android.media.AudioManager;
import com.ss.ttm.player.MediaPlayer;
import com.ss.videoarch.liveplayer.utils.AudioUtils;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f572886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MediaPlayer f572887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f572888c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f572889d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f572890e;

    public float getMaxVolume() {
        Context r100 = this.f572886a;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        if (this.f572890e == true) goto L9;
        AudioManager r101 = (AudioManager) r100.getSystemService("audio");
        int r102 = 0;
        if (r101 != null) goto L22;
    L16:
        int r103 = 0;
    L17:
        if (r103 < 0) goto L21;
        r102 = r103;
    L21:
        return r102;
    L22:
        r103 = r101.getStreamMaxVolume(3);     // Catch: Exception -> L15
    L9:
        return AudioUtils.getMusicMaxVolume(r100);
    }

    public float getVolume() {
        Context r100 = this.f572886a;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        if (this.f572890e == true) goto L9;
        int r101 = 0;
        AudioManager r102 = (AudioManager) r100.getSystemService("audio");     // Catch: Exception -> L15
        if (r102 == null) goto L17;
        int r103 = r102.getStreamVolume(3);     // Catch: Exception -> L15
    L18:
        if (r103 < 0) goto L22;
        r101 = r103;
    L22:
        return r101;
    L17:
        r103 = 0;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    L9:
        return (float) AudioUtils.getVolume(r100);
    }

    public boolean isMute() {
        MediaPlayer r100 = this.f572887b;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.isOSPlayer() == false) goto L11;
        if (getVolume() >= 0.001f) goto L12;
        return true;
    L12:
        return false;
    L11:
        return this.f572887b.isMute();
    }

    public float getPlayerVolume() {
        return this.f572889d;
    }

    public void setEnableVolumeOptimization(boolean r100) {
        this.f572890e = r100;
        if (r100 == false) goto L5;
        AudioUtils.registerVolumeChangedListener(this.f572886a);
        return;
    L5:
        AudioUtils.unregisterVolumeChangedListener(this.f572886a);
    }

    public void setMute(boolean r100) {
        MediaPlayer r101 = this.f572887b;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.isOSPlayer() == false) goto L13;
        float r102 = getMaxVolume();
        if (r102 <= 0.0f) goto L10;
        this.f572888c = getVolume() / r102;
    L10:
        if (r100 == false) goto L12;
        this.f572887b.setVolume(0.0f, 0.0f);
        return;
    L12:
        MediaPlayer r103 = this.f572887b;
        float r104 = this.f572888c;
        r103.setVolume(r104, r104);
        return;
    L13:
        this.f572887b.setIsMute(r100);
    }

    public void setPlayer(MediaPlayer r100) {
        this.f572887b = r100;
    }

    public void setPlayerVolume(float r100) {
        MediaPlayer r101 = this.f572887b;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r100 >= 0.0f) goto L9;
        r100 = 0.0f;
    L11:
        this.f572889d = r100;
        r101.setVolume(r100, r100);
        return;
    L9:
        if (r100 <= 1.0f) goto L11;
        r100 = 1.0f;
        goto L11
    }

    public void setVolume(float r100) {
        if (this.f572887b != null) goto L6;
        return;
    L6:
        if (this.f572890e == false) goto L9;
        AudioUtils.setMusicVolume(this.f572886a, (int) r100, 0);
        return;
    L9:
        AudioManager r101 = (AudioManager) this.f572886a.getSystemService("audio");
        if (r101 == null) goto L13;
        r101.setStreamVolume(3, (int) r100, 0);
        return;
    }

    public b(Context r100, MediaPlayer r101) {
        this.f572889d = 1.0f;
        this.f572890e = false;
        this.f572887b = r101;
        this.f572886a = r100;
    }
}
