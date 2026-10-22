package com.larus.kmp.voice_setting.voice.feature;

import com.larus.im.bean.bot.SpeakerVoice;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantLock f353307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<SpeakerVoice> f353308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<SpeakerVoice> f353309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CacheStatus f353310d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f353311e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f353312f;

    public final int a() {
        ReentrantLock r100 = this.f353307a;
        r100.lock();
        int r101 = this.f353310d.ordinal();     // Catch: Throwable -> L6
        r100.unlock();
        return r101;
    L6:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    public h() {
        this.f353307a = new ReentrantLock();
        this.f353308b = CollectionsKt.emptyList();
        this.f353309c = CollectionsKt.emptyList();
        this.f353310d = CacheStatus.EMPTY;
        this.f353312f = 1;
    }

    public final boolean b(b r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        ReentrantLock r101 = this.f353307a;
        r101.lock();
        boolean r102 = Intrinsics.areEqual(this.f353311e, r100);     // Catch: Throwable -> L6
        r101.unlock();
        return r102;
    L6:
        th = move-exception;
        r101.unlock();
        throw th;
    }
}
