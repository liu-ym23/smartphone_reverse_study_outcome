package com.ss.ugc.effectplatform.repository;

import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import java.util.HashMap;

/* JADX INFO: loaded from: classes36.dex */
public final class m implements IEffectPlatformBaseListener<HashMap<String, String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f457515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f457516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f457517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ IEffectPlatformBaseListener f457518d;

    /* JADX WARN: Type inference failed for: r1v2, types: [V, z.b] */
    @Override // com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener
    public final void onSuccess(HashMap<String, String> r100) {
        HashMap<String, String> r101 = r100;
        a0.b<z.b<String, String>> r102 = this.f457515a.f457512a;
        if (r102.f1239a != null) goto L5;
        r102.f1239a = new z.b(true);
    L5:
        z.b<String, String> r103 = this.f457515a.f457512a.f1239a;
        if (r103 == null) goto L8;
        r103.putAll(r101);
    L8:
        this.f457515a.a(this.f457516b, this.f457517c, this.f457518d);
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [V, z.b] */
    @Override // com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener
    public final void onFail(HashMap<String, String> r100, ExceptionResult r101) {
        a0.b<z.b<String, String>> r102 = this.f457515a.f457512a;
        if (r102.f1239a != null) goto L5;
        r102.f1239a = new z.b(true);
    L5:
        IEffectPlatformBaseListener r103 = this.f457518d;
        if (r103 == null) goto L9;
        r103.onSuccess(Boolean.TRUE);
        return;
    }

    public m(l r100, String r101, String r102, IEffectPlatformBaseListener r103) {
        this.f457515a = r100;
        this.f457516b = r101;
        this.f457517c = r102;
        this.f457518d = r103;
    }
}
