package com.ss.bytertc.audio.device.hwearback;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.Build;
import android.util.Log;
import com.bytedance.realx.base.RXLogging;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import fna.g;
import gna.a;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public class SlientPlayer {
    private static final String TAG = "SlientPlayer";
    private int mAudioFormat;
    private int mChannelConfig;
    private boolean mIsPlaying;
    private PlaybackThread mPlaybackThread;
    private boolean mRequireDeepBuffer;
    private int mSampleRate;
    private AudioTrack mTrack;
    private int mTrackBufSize;

    public class PlaybackThread extends PthreadThreadV2 {
        private boolean isStop;
        final /* synthetic */ SlientPlayer this$0;

        public synchronized void closeThread() {
            monitor-enter(this);
            notify();     // Catch: Throwable -> L5 Exception -> L7
            this.isStop = true;     // Catch: Throwable -> L5 Exception -> L7
            interrupt();     // Catch: Throwable -> L5 Exception -> L7
        L9:
            monitor-exit(this);
            return;
        L7:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L5
        L5:
            th = move-exception;
            throw th;
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public void run() {
            com_ss_bytertc_audio_device_hwearback_SlientPlayer$PlaybackThread_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_ss_bytertc_audio_device_hwearback_SlientPlayer$PlaybackThread__run$___twin___() {
            SlientPlayer.access$000(this.this$0);
            SlientPlayer.access$100(this.this$0);
            SlientPlayer.access$200(this.this$0);
            SlientPlayer.access$300(this.this$0);
            SlientPlayer.access$400(this.this$0);
        L19:
            e = move-exception;
            RXLogging.w(SlientPlayer.TAG, "SlientPlayer createAudioTrack has exception: " + Log.getStackTraceString(e));
            return;
        L4:
            if (SlientPlayer.access$400(this.this$0) == true) goto L6;
        L8:
            AudioTrack r100 = new AudioTrack(3, SlientPlayer.access$000(this.this$0), SlientPlayer.access$100(this.this$0), SlientPlayer.access$200(this.this$0), SlientPlayer.access$300(this.this$0), 1);     // Catch: Exception -> L19
        L9:
            INVOKEVIRTUAL_com_ss_bytertc_audio_device_hwearback_SlientPlayer$PlaybackThread_com_obric_performance_power_monitor_audio_AudioTrackLancet_play(r100);     // Catch: Exception -> L19
            int r101 = SlientPlayer.access$300(this.this$0);     // Catch: Exception -> L19
            byte[] r102 = new byte[r101];     // Catch: Exception -> L19
        L11:
            if (this.isStop == true) goto L17;
            if (isInterrupted() == true) goto L17;
            r100.write(r102, 0, r101);     // Catch: Exception -> L22
        L17:
            INVOKEVIRTUAL_com_ss_bytertc_audio_device_hwearback_SlientPlayer$PlaybackThread_com_obric_performance_power_monitor_audio_AudioTrackLancet_stop(r100);     // Catch: Exception -> L19
            r100.flush();     // Catch: Exception -> L19
            r100.release();     // Catch: Exception -> L19
            return;
        L6:
            if (Build.VERSION.SDK_INT < 26) goto L8;
            AudioFormat r103 = new AudioFormat.Builder().setSampleRate(SlientPlayer.access$000(this.this$0)).setChannelMask(SlientPlayer.access$100(this.this$0)).setEncoding(SlientPlayer.access$200(this.this$0)).build();     // Catch: Exception -> L19
            r100 = new AudioTrack.Builder().setAudioFormat(r103).setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(3).build()).setBufferSizeInBytes(SlientPlayer.access$300(this.this$0)).setPerformanceMode(2).build();     // Catch: Exception -> L19
            goto L9
        }

        public PlaybackThread(SlientPlayer r100) {
            this.this$0 = r100;
            super("SlientPlayer$PlaybackThread");
            this.isStop = false;
        }

        public static void INVOKEVIRTUAL_com_ss_bytertc_audio_device_hwearback_SlientPlayer$PlaybackThread_com_obric_performance_power_monitor_audio_AudioTrackLancet_play(AudioTrack r100) {
            if (g.d() == true) goto L6;
            r100.play();
            return;
        L6:
            r100.play();
            a.c(r100.hashCode());
        }

        public static void INVOKEVIRTUAL_com_ss_bytertc_audio_device_hwearback_SlientPlayer$PlaybackThread_com_obric_performance_power_monitor_audio_AudioTrackLancet_stop(AudioTrack r100) {
            if (g.d() == true) goto L6;
            r100.stop();
            return;
        L6:
            r100.stop();
            a.a(r100.hashCode());
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_ss_bytertc_audio_device_hwearback_SlientPlayer$PlaybackThread_com_larus_apm_impl_protector_RunnableLancet_run(PlaybackThread r100) {
            r100.com_ss_bytertc_audio_device_hwearback_SlientPlayer$PlaybackThread__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public void play() {
        if (this.mIsPlaying == false) goto L6;
        return;
    L6:
        if (this.mPlaybackThread != null) goto L9;
        this.mIsPlaying = true;
        PlaybackThread r100 = new PlaybackThread(this);
        this.mPlaybackThread = r100;
        ThreadMethodProxy.start(r100);
        return;
    }

    public void stop() {
        PlaybackThread r100 = this.mPlaybackThread;
        if (r100 == null) goto L6;
        this.mIsPlaying = false;
        r100.closeThread();
        this.mPlaybackThread = null;
        return;
    }

    public SlientPlayer() {
        this.mTrack = null;
        this.mSampleRate = 44100;
        this.mChannelConfig = 12;
        this.mAudioFormat = 2;
        this.mRequireDeepBuffer = false;
        this.mIsPlaying = false;
        this.mTrackBufSize = AudioTrack.getMinBufferSize(44100, 12, 2);
    }

    public boolean isPlaying() {
        return this.mIsPlaying;
    }

    public static /* synthetic */ int access$000(SlientPlayer r100) {
        return r100.mSampleRate;
    }

    public static /* synthetic */ int access$100(SlientPlayer r100) {
        return r100.mChannelConfig;
    }

    public static /* synthetic */ int access$200(SlientPlayer r100) {
        return r100.mAudioFormat;
    }

    public static /* synthetic */ int access$300(SlientPlayer r100) {
        return r100.mTrackBufSize;
    }

    public static /* synthetic */ boolean access$400(SlientPlayer r100) {
        return r100.mRequireDeepBuffer;
    }

    public void setRequireDeepBuffer(boolean r100) {
        this.mRequireDeepBuffer = r100;
    }

    public void setSampleRate(int r100) {
        this.mSampleRate = r100;
    }
}
