package com.larus.audioplayer.api.stream;

import c88.a;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.applet.utils.b;
import com.larus.doc.impl.DocFragment;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0001J\u0011\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0017\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0010H\u0096\u0001J\u0011\u0010\u0011\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0001J\u0019\u0010\u0014\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\u0017\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0096\u0001Je\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0015\u001a\u00020\nH\u0096\u0001J\u001b\u0010%\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0015\u001a\u00020\nH\u0096\u0001¨\u0006&"}, d2 = {"Lcom/larus/audioplayer/api/stream/AudioStreamPlayerDelegate;", "Lcom/larus/audioplayer/api/stream/IAudioSteamPlayerService;", "<init>", "()V", "addInterceptor", "", "interceptor", "Lcom/larus/audioplayer/api/stream/IStreamPlayerInterceptor;", "changePlaySpeed", ST.UUID_DEVICE, "", "newPlaySpeed", "", "getCurPlayTime", "", "getCurPlaying", "Lkotlin/Pair;", "getCurPlayingStatus", "getCurrentAudioSteamData", "Lcom/larus/audioplayer/api/stream/AudioSteamData;", "pause", "reason", "removeInterceptor", "resume", "start", IFlowAppIntentIDL.PARAM_APPLET_ID, "title", "artist", "coverUrl", "url", "listener", "Lcom/larus/audioplayer/api/IOnStreamPlayerStatesChangeListener;", "inputTimeOff", "", "scene", "extra", "Lorg/json/JSONObject;", "stop", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioStreamPlayerDelegate implements IAudioSteamPlayerService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AudioStreamPlayerDelegate f290191b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAudioSteamPlayerService f290192a;

    static {
        f290191b = new AudioStreamPlayerDelegate();
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        this.f290192a.a(r100, r101);
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final long b(String r100) {
        Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
        return this.f290192a.b(r100);
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final String d(String r100) {
        Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
        return this.f290192a.d(r100);
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
        Intrinsics.checkNotNullParameter(r101, "reason");
        this.f290192a.e(r100, r101);
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final a f() {
        return this.f290192a.f();
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final void g(DocFragment.d r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        this.f290192a.g(r100);
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final Pair<String, String> h() {
        return this.f290192a.h();
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final void i(DocFragment.d r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        this.f290192a.i(r100);
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final void j(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
        Intrinsics.checkNotNullParameter(r101, "reason");
        this.f290192a.j(r100, r101);
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final void k(String r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
        this.f290192a.k(r100, r101);
    }

    private AudioStreamPlayerDelegate() {
        IAudioSteamPlayerService r100 = (IAudioSteamPlayerService) ServiceManager.get().getService(IAudioSteamPlayerService.class);
        if (r100 != null) goto L5;
        r100 = AudioStreamPlayerEmptyService.f290193a;
    L5:
        this.f290192a = r100;
    }

    @Override // com.larus.audioplayer.api.stream.IAudioSteamPlayerService
    public final void c(String r110, String r111, String r112, String r113, String r114, String r115, int r116, String r117, JSONObject r210) {
        b r100 = b.f192281a;
        Intrinsics.checkNotNullParameter(r110, IFlowAppIntentIDL.PARAM_APPLET_ID);
        Intrinsics.checkNotNullParameter(r111, "title");
        Intrinsics.checkNotNullParameter(r112, "artist");
        Intrinsics.checkNotNullParameter(r114, "url");
        Intrinsics.checkNotNullParameter(r115, ST.UUID_DEVICE);
        Intrinsics.checkNotNullParameter(r117, "scene");
        Intrinsics.checkNotNullParameter(r210, "extra");
        Intrinsics.checkNotNullParameter("bridge_call", "reason");
        this.f290192a.c(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }
}
