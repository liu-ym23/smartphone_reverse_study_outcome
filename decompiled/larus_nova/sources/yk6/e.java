package yk6;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;

/* JADX INFO: loaded from: classes20.dex */
public final class e implements com.bytedance.livesdk.ktvcommon.download.api.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f568228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f568229b;

    public e() {
        PThreadExecutorsUtils.newSingleThreadExecutor(c.a.f568226a);
        this.f568228a = new b();
        this.f568229b = new f();
    }

    @Override // com.bytedance.livesdk.ktvcommon.download.api.e
    public final f a() {
        return this.f568229b;
    }

    @Override // com.bytedance.livesdk.ktvcommon.download.api.e
    public final b getDownloader() {
        return this.f568228a;
    }
}
