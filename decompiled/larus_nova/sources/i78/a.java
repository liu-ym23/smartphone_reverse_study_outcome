package i78;

import com.larus.audio.audiov3.config.audio.player.IAudioPlayerConfigFactory;
import com.larus.audio.flow.client.kmp_com.FlowTtsClientKmpManagerDelegate;
import com.larus.audio.ttsV2.h;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import rw5.g;

/* JADX INFO: loaded from: classes24.dex */
public final /* synthetic */ class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f488470a;

    public /* synthetic */ a(h r100) {
        this.f488470a = r100;
    }

    public final Object a(rw5.f r100, int r101) {
        Function2 r102 = this.f488470a;
        int r103 = FlowTtsClientKmpManagerDelegate.f289748d;
        Intrinsics.checkNotNullParameter(r100, "config");
        IAudioPlayerConfigFactory r104 = (IAudioPlayerConfigFactory) ServiceManager.get().getService(IAudioPlayerConfigFactory.class);
        if (r104 == null) goto L7;
        g78.a r105 = r104.a(r100.getSampleRate(), r100.getChannel(), r100.getFormat());
        if (r105 == null) goto L7;
        return r102.invoke(r105, Integer.valueOf(r101));
    L7:
        return null;
    }
}
