package com.larus.avlink.gallery.processor;

import com.larus.common.apphost.AppHost;
import com.larus.mirabridge.api.pluginservice.IDoraPluginService;
import com.larus.mirabridge.api.pluginservice.VideoStabilizeParams;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class m implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IDoraPluginService f292696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VideoStabilizeParams f292697b;

    public /* synthetic */ m(IDoraPluginService r100, VideoStabilizeParams r101) {
        this.f292696a = r100;
        this.f292697b = r101;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        IDoraPluginService r100 = this.f292696a;
        VideoStabilizeParams r101 = this.f292697b;
        return r100.stabilizeVideoPack(AppHost.f326268a.getApplication(), r101);
    }
}
