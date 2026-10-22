package p4a;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import com.lynx.animax.audio.AudioPlayer;
import com.lynx.animax.util.AnimaXLog;
import java.nio.ByteBuffer;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes32.dex */
public final class d implements AudioTrack.OnPlaybackPositionUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f527724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f527725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ByteBuffer f527726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f527727d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f527728e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AudioTrack f527729f;

    @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
    public final void onMarkerReached(AudioTrack r100) {
    }

    public d(c r110) {
        this.f527728e = 0;
        int r100 = r110.f527720c;
        int r101 = r110.f527719b;
        int r102 = 4;
        if (r101 != 1) goto L5;
        int r103 = 4;
    L8:
        int r104 = r110.f527722e;
        if (r104 != 3) goto L11;
        r102 = 1;
    L14:
        int r105 = r101 * r102;
        this.f527725b = r105;
        int r111 = Math.min(((int) Math.ceil(((double) r100) / 30.0d)) * 2, (int) ((((long) r110.f527720c) * r110.f527721d) / 1000000.0d));
        int r106 = Math.max(r111, (AudioTrack.getMinBufferSize(r100, r103, r104) / r105) + 1) * r105;
        this.f527724a = r106;
        this.f527726c = ByteBuffer.allocate(r106);
        AudioTrack r107 = new AudioTrack(new AudioAttributes.Builder().setUsage(1).setContentType(2).build(), new AudioFormat.Builder().setEncoding(r104).setSampleRate(r100).setChannelMask(r103).build(), r106, 1, 0);
        this.f527729f = r107;
        if (r107.getState() == 0) goto L19;
        AnimaXLog.b("AudioRenderer", "AudioTrack initialization success. sampleRate=" + r100 + ", channelConfig=" + r103 + ", encoding=" + r104 + ", bufferSize=" + r106);
        r107.setPositionNotificationPeriod(r111 / 2);
        r107.setPlaybackPositionUpdateListener(this);
        return;
    L19:
        throw new IllegalStateException("AudioTrack initialization failed. sampleRate=" + r100 + ", channelConfig=" + r103 + ", encoding=" + r104 + ", bufferSize=" + r106);
    L11:
        if (r104 == 4) goto L14;
        r102 = 2;
        goto L14
    L5:
        if (r101 != 2) goto L7;
        r103 = 12;
        goto L8
    L7:
        r103 = 1;
        goto L8
    }

    @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
    public final void onPeriodicNotification(AudioTrack r110) {
        if (this.f527727d != null) goto L5;
        return;
    L5:
        long r100 = ((long) this.f527724a) - (((long) this.f527728e) - ((((long) this.f527729f.getPlaybackHeadPosition()) & BodyPartID.bodyIdMax) * ((long) this.f527725b)));
        int r111 = (int) r100;
        if (r100 != r111) goto L19;
        this.f527726c.clear();
        this.f527726c.limit(r111);
        e r101 = this.f527727d;
        long r102 = this.f527728e;
        ByteBuffer r103 = this.f527726c;
        AudioPlayer r104 = (AudioPlayer) r101;
        long r105 = ((long) r104.f380253e) + r102;
        int r106 = r104.f380252d;
        long r107 = r105 % ((long) r106);
        int r108 = (int) r107;
        if (r107 != r108) goto L17;
        int r109 = r111 + r108;
        int r112 = Math.min(r106, r109);
        r104.f380251c.position(r108);
        r104.f380251c.limit(r112);
        r103.put(r104.f380251c);
        int r113 = r104.f380252d;
        if (r113 >= r109) goto L12;
        r104.f380251c.position(0);
        r104.f380251c.limit(r109 % r113);
        r103.put(r104.f380251c);
    L12:
        r104.f380251c.position(0);
        r104.f380251c.limit(r104.f380252d);
        this.f527726c.flip();
        int r114 = this.f527729f.write(this.f527726c, r111, 1);
        if (r114 <= 0) goto L20;
        this.f527728e += r114;
        return;
    L20:
        return;
    L17:
        throw new ArithmeticException();
    L19:
        throw new ArithmeticException();
    }
}
