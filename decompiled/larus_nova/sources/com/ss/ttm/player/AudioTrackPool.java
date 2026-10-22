package com.ss.ttm.player;

import android.media.AudioTrack;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.ss.ttm.utils.AVLogger;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes40.dex */
public final class AudioTrackPool {
    private static final int S_FAIL = -1;
    private static final int S_OK = 0;
    private static final String TAG = "AudioTrackPool";
    private static volatile AudioTrackPool instance;
    private int mCheckIntervalMs;
    private boolean mEnableFrameSamplesCheck;
    private int mMaxUsedCount;
    private Queue<AudioTrackBuffer> trackPool;
    private AtomicInteger trackPoolSizeLimit;

    public static /* synthetic */ void a(AudioTrackPool r100) {
        r100.checkExpireThreadPeriod();
    }

    public synchronized int getAudioTrackPoolSize() {
        monitor-enter(this);
        int r100 = this.trackPool.size();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    private void checkExpireThreadPeriod() {
        LinkedBlockingQueue r100 = new LinkedBlockingQueue();
        long r101 = System.currentTimeMillis();
        monitor-enter(AudioTrackPool.class);
    L20:
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.trackPool.isEmpty() == true) goto L9;
        if ((r101 - this.trackPool.peek().mFreeTimePoint) <= this.mCheckIntervalMs) goto L9;
        r100.offer(this.trackPool.peek());     // Catch: Throwable -> L17
        this.trackPool.poll();     // Catch: Throwable -> L17
    L9:
        monitor-exit(AudioTrackPool.class);     // Catch: Throwable -> L17
        AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: exist audioTrack after check expire:" + this.trackPool.size() + ", clean size:" + r100.size());
    L12:
        if (r100.isEmpty() == true) goto L16;
        AudioTrack r102 = ((AudioTrackBuffer) r100.poll()).AudioTrack;
        if (r102 == null) goto L12;
        releaseAudioTrack(r102);
        goto L12
    }

    public static AudioTrackPool getInstance() {
        if (instance != null) goto L15;
        monitor-enter(AudioTrackPool.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new AudioTrackPool();     // Catch: Throwable -> L11
    L9:
        monitor-exit(AudioTrackPool.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    public void preBuild() {
        AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: start pre build audioTrack");
        AudioTrack r100 = new AudioTrack(3, 44100, 12, 2, AudioTrack.getMinBufferSize(44100, 12, 2), 1);
        if (r100.getState() != 1) goto L6;
        pushAudioTrackBack(new AudioTrackBuffer(r100, 3, 44100, 12, 2, 2048, 0), 1.0f);
        return;
    }

    public void resetQueue() {
        AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: reset queue, size:" + this.trackPool.size());
        if (this.trackPool.isEmpty() == false) goto L5;
        return;
    L5:
        monitor-enter(this);
        this.trackPool.size();     // Catch: Throwable -> L14
    L8:
        if (this.trackPool.isEmpty() == true) goto L12;
        AudioTrack r100 = this.trackPool.poll().AudioTrack;     // Catch: Throwable -> L14
        if (r100 == null) goto L8;
        releaseAudioTrack(r100);     // Catch: Throwable -> L14
        goto L8
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private AudioTrackPool() {
        this.mCheckIntervalMs = 30000;
        this.trackPoolSizeLimit = new AtomicInteger(3);
        this.trackPool = new LinkedBlockingQueue();
        this.mMaxUsedCount = TTPlayerConfiger.getValue(50, 20);
        boolean r100 = false;
        if (TTPlayerConfiger.getValue(51, 0) == 0) goto L5;
        boolean r101 = true;
    L6:
        this.mEnableFrameSamplesCheck = r101;
        setAudioTrackPoolSize(TTPlayerConfiger.getValue(47, 3));
        if (TTPlayerConfiger.getValue(81, 0) == 0) goto L9;
        r100 = true;
    L9:
        int r102 = TTPlayerConfiger.getValue(82, 30000);
        this.mCheckIntervalMs = r102;
        if (r100 == false) goto L13;
        if (r102 <= 0) goto L13;
        ScheduledExecutorService r103 = PThreadExecutorsUtils.newScheduledThreadPool(1, new DefaultThreadFactory("udioTrackPool"));
        Runnable r104 = new b(this);
        int r105 = this.mCheckIntervalMs;
        r103.scheduleWithFixedDelay(r104, r105, r105, TimeUnit.MILLISECONDS);
    L13:
        this.trackPoolSizeLimit.get();
        return;
    L5:
        r101 = false;
        goto L6
    }

    public static void INVOKEVIRTUAL_com_ss_ttm_player_AudioTrackPool_com_obric_performance_power_monitor_audio_AudioTrackLancet_pause(AudioTrack r100) {
        if (fna.g.d() == true) goto L6;
        r100.pause();
        return;
    L6:
        r100.pause();
        gna.a.a(r100.hashCode());
    }

    public void releaseAudioTrack(final AudioTrack r100) {
        if (r100 == null) goto L11;
        AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: release AudioTrack task:" + r100);
        AVThreadPool.addTask(new AnonymousClass1(this, r100));     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: create close thread fail: " + th);
        r100.flush();
        r100.release();
        return;
    }

    public void setAudioTrackPoolSize(int r100) {
        AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: set audioTrack pool size:" + r100);
        this.trackPoolSizeLimit.set(r100);
    }

    public int pushAudioTrackBack(AudioTrackBuffer r100, float r101) {
        if (r100 == null) goto L52;
        AudioTrack r102 = r100.AudioTrack;
        if (r102 == null) goto L52;
        int r103 = r100.usedCount + 1;
        r100.usedCount = r103;
        if (r103 <= this.mMaxUsedCount) goto L12;
        AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: usedCount > maxUsedCount.");
        return -1;
    L12:
        if (r102.getPlayState() == 2) goto L14;
        INVOKEVIRTUAL_com_ss_ttm_player_AudioTrackPool_com_obric_performance_power_monitor_audio_AudioTrackLancet_pause(r100.AudioTrack);
    L14:
        r100.AudioTrack.flush();
        if (r101 == 1.0f) goto L17;
        AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: reset volume, before: " + r101);
        r100.AudioTrack.setVolume(1.0f);
    L17:
        setAudioTrackPoolSize(TTPlayerConfiger.getValue(47, 3));
        monitor-enter(this);
        Iterator<AudioTrackBuffer> r104 = this.trackPool.iterator();     // Catch: Throwable -> L49
    L21:
        if (r104.hasNext() == false) goto L36;
        AudioTrackBuffer r105 = r104.next();     // Catch: Throwable -> L49
        if (r105.streamType != r100.streamType) goto L21;
        if (r105.sampleRate != r100.sampleRate) goto L21;
        if (r105.channelsLayout != r100.channelsLayout) goto L21;
        if (r105.audioFormat != r100.audioFormat) goto L21;
        if (r105.frameSamples != r100.frameSamples) goto L21;
        AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: pool has similarity audioTrack.");     // Catch: Throwable -> L49
        monitor-exit(this);     // Catch: Throwable -> L49
        return -1;
    L36:
        if (this.trackPool.size() < this.trackPoolSizeLimit.get()) goto L38;
        AudioTrack r106 = this.trackPool.poll().AudioTrack;     // Catch: Throwable -> L49
        if (this.trackPool.offer(r100) == false) goto L44;
        r100.resetFreeTimePoint();     // Catch: Throwable -> L49
        AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: pushback AudioTrack success after poll! AudioTrack: " + r100.AudioTrack + ", poolSize: " + this.trackPool.size() + ", usedCount:" + r100.usedCount);     // Catch: Throwable -> L49
    L44:
        AudioTrack r107 = r106;
    L45:
        monitor-exit(this);     // Catch: Throwable -> L49
        if (r107 == null) goto L48;
        releaseAudioTrack(r107);
    L48:
        return 0;
    L38:
        if (this.trackPool.offer(r100) == false) goto L40;
        r100.resetFreeTimePoint();     // Catch: Throwable -> L49
        AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: pushback AudioTrack success! AudioTrack: " + r100.AudioTrack + ", poolSize: " + this.trackPool.size() + ", usedCount:" + r100.usedCount);     // Catch: Throwable -> L49
    L40:
        r107 = null;
    L49:
        th = move-exception;
        throw th;
    L52:
        AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: audioTrack is null!");
        return 0;
    }

    public AudioTrackBuffer getReuseAudioTrack(int r100, int r101, int r102, int r103, int r110) {
        if (this.trackPool.isEmpty() == false) goto L6;
        AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: trackPool is empty!");
        return null;
    L6:
        monitor-enter(this);
        Iterator<AudioTrackBuffer> r104 = this.trackPool.iterator();     // Catch: Throwable -> L35
        AudioTrackBuffer r105 = null;
    L9:
        if (r104.hasNext() == false) goto L22;
        AudioTrackBuffer r106 = r104.next();     // Catch: Throwable -> L35
        if (r106.streamType != r100) goto L9;
        if (r106.sampleRate != r101) goto L9;
        if (r106.channelsLayout != r102) goto L9;
        if (r106.audioFormat != r103) goto L9;
        if (r106.frameSamples == r110) goto L20;
        r105 = r106;
        goto L9
    L20:
        this.trackPool.remove(r106);     // Catch: Throwable -> L35
        AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: find best-matched AudioTrack:" + r106.AudioTrack);     // Catch: Throwable -> L35
    L23:
        if (r106 != null) goto L26;
        if (r105 == null) goto L26;
        this.trackPool.remove(r105);     // Catch: Throwable -> L35
        AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: find find sampleNumber-unmatched AudioTrack:" + r105.AudioTrack);     // Catch: Throwable -> L35
    L27:
        monitor-exit(this);     // Catch: Throwable -> L35
        if (r105 != null) goto L30;
    L33:
        AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: find best-matched AudioTrack fail");
        return null;
    L30:
        if (r105.AudioTrack.getPlayState() != 2) goto L32;
        return r105;
    L32:
        releaseAudioTrack(r105.AudioTrack);
    L26:
        r105 = r106;
        goto L27
    L22:
        r106 = null;
    L35:
        th = move-exception;
        throw th;
    }
}
