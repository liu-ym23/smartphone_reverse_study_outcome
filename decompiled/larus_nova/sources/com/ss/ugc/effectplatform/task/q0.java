package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.listener.IDownloadProviderEffectListListener;
import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.ProviderEffect;
import com.ss.ugc.effectplatform.model.net.GifProviderEffectListResponse;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public final class q0 implements hlc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ProviderEffect> f457902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<ProviderEffect> f457903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f457904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ r0 f457905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ GifProviderEffectListResponse f457906e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ List f457907f;

    @Override // hlc.b
    public final void onProgress(ProviderEffect r100, int r101, long r102) {
    }

    public final void a() {
        if (((ArrayList) this.f457903b).size() <= 0) goto L11;
        r0 r100 = this.f457905d;
        GifProviderEffectListResponse r101 = this.f457906e;
        List<ProviderEffect> r102 = this.f457902a;
        List<ProviderEffect> r103 = this.f457903b;
        ExceptionResult r104 = new ExceptionResult(1);
        IEffectPlatformBaseListener r105 = r100.f457922n.N.a(r100.f457923o);
        if ((r105 instanceof IDownloadProviderEffectListListener) == false) goto L7;
        ((IDownloadProviderEffectListListener) r105).onDownloadFailed(r102, r103, r104);
    L9:
        r100.f457922n.N.c(r100.f457923o);
        return;
    L7:
        if (r105 == null) goto L9;
        r105.onFail(r101, r104);
        goto L9
    L11:
        r0 r106 = this.f457905d;
        GifProviderEffectListResponse r107 = this.f457906e;
        List<? extends ProviderEffect> r108 = this.f457907f;
        IEffectPlatformBaseListener r109 = r106.f457922n.N.a(r106.f457923o);
        if ((r109 instanceof IDownloadProviderEffectListListener) == false) goto L14;
        ((IDownloadProviderEffectListListener) r109).onDownloadSuccess(r108);
    L16:
        r106.f457922n.N.c(r106.f457923o);
        return;
    L14:
        if (r109 == null) goto L16;
        r109.onSuccess(r107);
        goto L16
    }

    @Override // com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener
    public final void onSuccess(ProviderEffect r100) {
        ArrayList r101 = (ArrayList) this.f457902a;
        r101.add(r100);
        if ((((ArrayList) this.f457902a).size() + ((ArrayList) this.f457903b).size()) != this.f457904c) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        a();
        return;
    L9:
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener
    public final void onFail(ProviderEffect r100, ExceptionResult r101) {
        ArrayList r102 = (ArrayList) this.f457903b;
        r102.add(r100);
        if ((((ArrayList) this.f457902a).size() + ((ArrayList) this.f457903b).size()) != this.f457904c) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L9;
        a();
        return;
    L9:
        return;
    L5:
        r103 = false;
        goto L6
    }

    public q0(r0 r100, GifProviderEffectListResponse r101, List r102) {
        this.f457905d = r100;
        this.f457906e = r101;
        this.f457907f = r102;
        this.f457902a = new ArrayList();
        this.f457903b = new ArrayList();
        this.f457904c = r102.size();
    }
}
