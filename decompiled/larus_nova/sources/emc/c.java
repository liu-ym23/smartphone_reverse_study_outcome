package emc;

import com.ss.ugc.live.sdk.message.stream.IStreamMessage;
import com.ss.ugc.live.sdk.msg.utils.f;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements Delayed {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IStreamMessage f473124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f473125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile long f473126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile long f473127d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f473128e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final vlc.c f473129f;

    @Override // java.lang.Comparable
    public final int compareTo(Delayed r100) {
        return Long.compare(this.f473125b, ((c) r100).f473125b);
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit r100) {
        if (this.f473124a.getDelayMode() != IStreamMessage.DelayMode.SEI_DIFF) goto L5;
        long r101 = r100.convert(this.f473124a.getTargetSei() - this.f473127d, TimeUnit.MILLISECONDS);
    L6:
        this.f473129f.log("StreamMessageDelayWrap", String.format("getDelay for %s[%d] = %d", new Object[]{this.f473124a.getMessageMethod(), Long.valueOf(this.f473124a.getMessageId()), Long.valueOf(r101)}));
        return r101;
    L5:
        r101 = r100.convert(((this.f473125b + this.f473126c) - this.f473128e) - f.a(), TimeUnit.MILLISECONDS);
        goto L6
    }

    public c(IStreamMessage r100, long r101, vlc.c r110) {
        this(r100, r101, f.a(), r110);
    }

    public c(IStreamMessage r100, long r101, long r102, vlc.c r103) {
        this.f473127d = 0;
        this.f473124a = r100;
        this.f473126c = r101;
        this.f473125b = r102;
        this.f473128e = r100.getServerDelay();
        this.f473129f = r103;
    }
}
