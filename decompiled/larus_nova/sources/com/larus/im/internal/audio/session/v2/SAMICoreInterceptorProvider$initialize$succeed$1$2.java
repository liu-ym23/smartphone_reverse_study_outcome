package com.larus.im.internal.audio.session.v2;

import com.mammon.speechaudiosdk.session.task.SpeechRealtimeCallTask;
import com.mammon.speechlinklayersdk.SpeechLinkLayer;
import com.mammon.speechlinklayersdk.param.SpeechLinkLayerCreateParam;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class SAMICoreInterceptorProvider$initialize$succeed$1$2 extends FunctionReferenceImpl implements Function0<Boolean> {
    public SAMICoreInterceptorProvider$initialize$succeed$1$2(Object r100) {
        super(0, r100, r0.class, "createAndSetSpeechLinkLayer", "createAndSetSpeechLinkLayer()Z", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        r0 r100 = (r0) this.receiver;
        int r101 = r0.f347452l;
        r100.getClass();
        SpeechLinkLayerCreateParam r102 = new SpeechLinkLayerCreateParam();
        r102.linkLayerCallback = r100.f347462j;
        r102.transportType = 2;
        SpeechLinkLayer r103 = new SpeechLinkLayer(r102);
        r100.e(r103);
        boolean r104 = false;
        if (r103.init() == 0) goto L5;
        r100.f347455c.b("SAMICoreInterceptorProvider", "[createAndSetSpeechLinkLayer] Speech link layer initialize failed.");
    L13:
        return Boolean.valueOf(r104);
    L5:
        SpeechRealtimeCallTask r105 = r100.f347459g;
        if (r105 != null) goto L8;
    L10:
        if (r104 == true) goto L13;
        r100.f347455c.b("SAMICoreInterceptorProvider", "[createAndSetSpeechLinkLayer] Task set link layer failed.");
        goto L13
    L8:
        if (r105.setSpeechLinkLayer(r103) != 0) goto L10;
        r104 = true;
        goto L10
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return invoke();
    }
}
