package oo2;

import com.bytedance.android.livesdk.player.api.ITTLivePlayer;
import com.bytedance.android.livesdkapi.roomplayer.AudioProcessorWrapper;
import com.bytedance.android.livesdkapi.roomplayer.IAudioControl;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements IAudioControl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, AudioProcessorWrapper> f524562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<AudioProcessorWrapper> f524563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedList<AudioProcessorWrapper> f524564c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final oo2.a f524565d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f524566e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f524567f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f524568g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ITTLivePlayer f524569h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f524570i;

    public static final class a extends AudioProcessorWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f524571a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f524572b;

        @Override // com.bytedance.android.livesdkapi.roomplayer.AudioProcessorWrapper
        public final void audioClose() {
            Object r100 = this.f524572b.f524567f;
            monitor-enter(r100);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (this.f524572b.f524562a.size() <= 0) goto L10;
            Iterator<Map.Entry<Integer, AudioProcessorWrapper>> r101 = this.f524572b.f524562a.entrySet().iterator();     // Catch: Throwable -> L14
        L8:
            if (r101.hasNext() == false) goto L11;
            r101.next().getValue().audioClose();     // Catch: Throwable -> L14
        L11:
            com.bytedance.android.live.player.utils.b.b("realAudioProcessor::audioClose");     // Catch: Throwable -> L14
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L14
            monitor-exit(r100);
            return;
        L10:
            b.a(this.f524572b);     // Catch: Throwable -> L14
            goto L11
        }

        @Override // com.bytedance.android.livesdkapi.roomplayer.AudioProcessorWrapper
        public final void audioUnbind() {
            Object r100 = this.f524572b.f524567f;
            monitor-enter(r100);
            com.bytedance.android.live.player.utils.b.b("realAudioProcessor::audioUnbind");     // Catch: Throwable -> L11
            Iterator<T> r101 = this.f524572b.f524563b.iterator();     // Catch: Throwable -> L11
        L6:
            if (r101.hasNext() == false) goto L8;
            ((AudioProcessorWrapper) r101.next()).audioUnbind();     // Catch: Throwable -> L11
            goto L6
        L8:
            b.a(this.f524572b);     // Catch: Throwable -> L11
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L11
            monitor-exit(r100);
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public a(b r100) {
            this.f524572b = r100;
            this.f524571a = "AudioProcessorProxy$realAudioProcessor#";
        }

        @Override // com.bytedance.android.livesdkapi.roomplayer.AudioProcessorWrapper
        public final void audioRelease(int r100) {
            Object r101 = this.f524572b.f524567f;
            monitor-enter(r101);
            com.bytedance.android.live.player.utils.b.b("realAudioProcessor::audioRelease");     // Catch: Throwable -> L11
            Iterator<T> r102 = this.f524572b.f524563b.iterator();     // Catch: Throwable -> L11
        L6:
            if (r102.hasNext() == false) goto L8;
            ((AudioProcessorWrapper) r102.next()).audioRelease(r100);     // Catch: Throwable -> L11
            goto L6
        L8:
            b.a(this.f524572b);     // Catch: Throwable -> L11
            Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L11
            monitor-exit(r101);
            return;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.android.livesdkapi.roomplayer.AudioProcessorWrapper
        public final void audioProcess(ByteBuffer[] r110, int r111, long r112) {
            Object r100 = this.f524572b.f524568g;
            monitor-enter(r100);
            com.bytedance.android.live.player.utils.b.b(this.f524571a + " audioProcess: samples: " + r111 + ", timestamp: " + r112);     // Catch: Throwable -> L21
            Iterator<Map.Entry<Integer, AudioProcessorWrapper>> r101 = this.f524572b.f524562a.entrySet().iterator();     // Catch: Throwable -> L21
        L6:
            if (r101.hasNext() == false) goto L18;
            Map.Entry<Integer, AudioProcessorWrapper> r102 = r101.next();     // Catch: Throwable -> L21
            ByteBuffer[] r103 = null;
            if (r110 == null) goto L17;
            int r104 = r110.length;     // Catch: Throwable -> L21
            ByteBuffer[] r105 = new ByteBuffer[r104];     // Catch: Throwable -> L21
            int r106 = 0;
        L10:
            if (r106 >= r104) goto L16;
            b r107 = this.f524572b;     // Catch: Throwable -> L21
            ByteBuffer r108 = r110[r106];     // Catch: Throwable -> L21
            r107.getClass();     // Catch: Throwable -> L21
            if (r108 != null) goto L14;
            ByteBuffer r109 = null;
        L15:
            r105[r106] = r109;     // Catch: Throwable -> L21
            r106 = r106 + 1;     // Catch: Throwable -> L21
            goto L10
        L14:
            r109 = ByteBuffer.allocate(r108.capacity());     // Catch: Throwable -> L21
            r108.rewind();     // Catch: Throwable -> L21
            r109.put(r108);     // Catch: Throwable -> L21
            r108.rewind();     // Catch: Throwable -> L21
            r109.flip();     // Catch: Throwable -> L21
            goto L15
        L16:
            r103 = r105;
        L17:
            r102.getValue().audioProcess(r103, r111, r112);     // Catch: Throwable -> L21
            goto L6
        L18:
            com.bytedance.android.live.player.utils.b.b("realAudioProcessor::audioProcess");     // Catch: Throwable -> L21
            Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L21
            monitor-exit(r100);
            return;
        L21:
            th = move-exception;
            throw th;
        }

        @Override // com.bytedance.android.livesdkapi.roomplayer.AudioProcessorWrapper
        public final void audioOpen(int r100, int r101, int r102, int r103) {
            Object r104 = this.f524572b.f524567f;
            monitor-enter(r104);
            com.bytedance.android.live.player.utils.b.b(this.f524571a + " audioOpen: samplerate: " + r100 + ", channels: " + r101 + ", duration: " + r102 + ", format: " + r103);     // Catch: Throwable -> L19
            b r105 = this.f524572b;     // Catch: Throwable -> L19
            oo2.a r106 = r105.f524565d;     // Catch: Throwable -> L19
            r106.f524557a = r100;     // Catch: Throwable -> L19
            r106.f524558b = r101;     // Catch: Throwable -> L19
            r106.f524559c = r102;     // Catch: Throwable -> L19
            r106.f524560d = r103;     // Catch: Throwable -> L19
            r106.f524561e = true;     // Catch: Throwable -> L19
            int r107 = r105.f524566e + 1;     // Catch: Throwable -> L19
            r105.f524566e = r107;     // Catch: Throwable -> L19
            if (r107 == 0) goto L7;
            if (r107 <= 0) goto L16;
            Iterator<Map.Entry<Integer, AudioProcessorWrapper>> r108 = r105.f524562a.entrySet().iterator();     // Catch: Throwable -> L19
        L14:
            if (r108.hasNext() == false) goto L16;
            r108.next().getValue().audioOpen(r100, r101, r102, r103);     // Catch: Throwable -> L19
        L16:
            com.bytedance.android.live.player.utils.b.b("realAudioProcessor::audioOpen: audioOpenVersion: " + this.f524572b.f524566e);     // Catch: Throwable -> L19
            Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L19
            monitor-exit(r104);
            return;
        L7:
            if (this.f524572b.f524564c.size() <= 0) goto L16;
            AudioProcessorWrapper r110 = this.f524572b.f524564c.poll();     // Catch: Throwable -> L19
            if (r110 == null) goto L7;
            r110.audioOpen(r100, r101, r102, r103);     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            throw th;
        }
    }

    public b() {
        this.f524562a = new ConcurrentHashMap();
        this.f524563b = new ArrayList();
        this.f524564c = new LinkedList();
        this.f524565d = new oo2.a();
        this.f524566e = -1;
        this.f524567f = new Object();
        this.f524568g = new Object();
        this.f524570i = new a(this);
    }

    public static final void a(b r100) {
        ((ArrayList) r100.f524563b).clear();
        r100.f524562a.clear();
        r100.f524564c.clear();
        oo2.a r101 = r100.f524565d;
        r101.f524557a = -1;
        r101.f524558b = -1;
        r101.f524559c = -1;
        r101.f524560d = -1;
        r101.f524561e = false;
        r100.f524566e = -1;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IAudioControl
    public final void setAudioProcessor(AudioProcessorWrapper r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "audioProcessorWrapper");
        if (this.f524569h != null) goto L5;
        return;
    L5:
        this.f524562a.put(Integer.valueOf(r100.hashCode()), r100);
        ((ArrayList) this.f524563b).add(r100);
        if (this.f524562a.size() != 1) goto L11;
        ITTLivePlayer r102 = this.f524569h;
        if (r102 == null) goto L16;
        r102.g0(this.f524570i, r101);
    L16:
        oo2.a r103 = this.f524565d;
        if (r103.f524561e == false) goto L19;
        r100.audioOpen(r103.f524557a, r103.f524558b, r103.f524559c, r103.f524560d);
    L20:
        com.bytedance.android.live.player.utils.b.b("AudioProcessorProxy::setAudioProcessor: activeProcessorMap.size: " + this.f524562a.size() + "audioOpenInfo.isInit: " + this.f524565d.f524561e);
        return;
    L19:
        this.f524564c.offer(r100);
        goto L20
    L11:
        if (this.f524562a.size() <= 1) goto L16;
        if (r101 == false) goto L16;
        ITTLivePlayer r104 = this.f524569h;
        if (r104 == null) goto L16;
        r104.G0();
        goto L16
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IAudioControl
    public final void unbindAudioProcessor(AudioProcessorWrapper r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "audioProcessorWrapper");
        if (this.f524569h != null) goto L5;
        return;
    L5:
        StringBuilder r102 = new StringBuilder("AudioProcessorProxy::unbindAudioProcessor: activeProcessorMap.size: ");
        r102.append(this.f524562a.size());
        r102.append("processorIsValid: ");
        if (this.f524562a.get(Integer.valueOf(r100.hashCode())) == null) goto L8;
        boolean r103 = true;
    L9:
        r102.append(r103);
        com.bytedance.android.live.player.utils.b.b(r102.toString());
        if (this.f524562a.size() != 0) goto L12;
        return;
    L12:
        if (this.f524562a.get(Integer.valueOf(r100.hashCode())) == null) goto L32;
        r100.audioClose();
        this.f524562a.remove(Integer.valueOf(r100.hashCode()));
        if (this.f524562a.size() != 0) goto L20;
        ITTLivePlayer r104 = this.f524569h;
        if (r104 == null) goto L27;
        r104.unbindAudioProcessor();
        return;
    L27:
        return;
    L20:
        if (this.f524562a.size() <= 0) goto L29;
        if (r101 == false) goto L30;
        ITTLivePlayer r105 = this.f524569h;
        if (r105 == null) goto L31;
        r105.q0();
        return;
    L31:
        return;
    L30:
        return;
    L29:
        return;
    L32:
        return;
    L8:
        r103 = false;
        goto L9
    }
}
