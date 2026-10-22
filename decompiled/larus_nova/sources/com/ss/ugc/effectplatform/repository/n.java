package com.ss.ugc.effectplatform.repository;

import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import java.util.HashMap;

/* JADX INFO: loaded from: classes36.dex */
public final class n implements IEffectPlatformBaseListener<HashMap<String, String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f457519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f457520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f457521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f457522d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ hlc.f f457523e;

    /* JADX WARN: Type inference failed for: r1v2, types: [V, z.b] */
    @Override // com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener
    public final void onSuccess(HashMap<String, String> r100) {
        HashMap<String, String> r101 = r100;
        a0.b<z.b<String, String>> r102 = this.f457519a.f457512a;
        if (r102.f1239a != null) goto L5;
        r102.f1239a = new z.b(true);
    L5:
        z.b<String, String> r103 = this.f457519a.f457512a.f1239a;
        if (r103 == null) goto L8;
        r103.putAll(r101);
    L8:
        this.f457519a.b(this.f457520b, this.f457521c, this.f457522d, this.f457523e);
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [V, z.b] */
    @Override // com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener
    public final void onFail(HashMap<String, String> r100, ExceptionResult r101) {
        a0.b<z.b<String, String>> r102 = this.f457519a.f457512a;
        if (r102.f1239a != null) goto L6;
        r102.f1239a = new z.b(true);
        return;
    }

    public n(l r100, String r101, String r102, String r103, hlc.f r104) {
        this.f457519a = r100;
        this.f457520b = r101;
        this.f457521c = r102;
        this.f457522d = r103;
        this.f457523e = r104;
    }
}
