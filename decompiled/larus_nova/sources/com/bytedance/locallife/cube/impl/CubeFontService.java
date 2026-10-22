package com.bytedance.locallife.cube.impl;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import com.lynx.tasm.behavior.shadow.text.g;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J*\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0016J(\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0016J \u0010\u0012\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\tH\u0016R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00160\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/locallife/cube/impl/CubeFontService;", "Lep6/b;", "Lep6/a;", "cubeLazyProvider", "", "addLazyProviderWrapper", "removeLazyProviderWrapper", "Landroid/content/res/AssetManager;", "assetManager", "", "fontFamilyName", "", "style", "path", "Landroid/graphics/Typeface;", "getTypefaceFromAssets", "cacheTypefaceFromAssets", "typeface", "cacheTypeface", "", "containsTypeface", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/lynx/tasm/behavior/shadow/text/g$b;", "lazyProviderMap", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "cube-saas_release"}, k = 1, mv = {1, 4, 3})
public final class CubeFontService implements ep6.b {
    private final ConcurrentHashMap<ep6.a, g.b> lazyProviderMap;

    public static final class a implements g.b {
        public a() {
        }

        @Override // com.lynx.tasm.behavior.shadow.text.g.b
        public final Typeface a(String r100, int r101) {
            throw null;
        }
    }

    public CubeFontService() {
        this.lazyProviderMap = new ConcurrentHashMap();
    }

    public void addLazyProviderWrapper(ep6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "cubeLazyProvider");
        a r101 = new a();
        g.a(r101);
        this.lazyProviderMap.put(r100, r101);
    }

    @Override // ep6.b
    public boolean containsTypeface(String r100) {
        Intrinsics.checkNotNullParameter(r100, "fontFamilyName");
        Map<String, Typeface[]> r101 = g.f382310a;
        monitor-enter(g.class);
        boolean r102 = ((HashMap) g.f382310a).containsKey(r100);     // Catch: Throwable -> L7
        monitor-exit(g.class);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeLazyProviderWrapper(ep6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "cubeLazyProvider");
        if (this.lazyProviderMap.containsKey(r100) == false) goto L6;
        this.lazyProviderMap.remove(r100);
        return;
    }

    @Override // ep6.b
    public void cacheTypeface(String r100, int r101, Typeface r102) {
        Intrinsics.checkNotNullParameter(r100, "fontFamilyName");
        Intrinsics.checkNotNullParameter(r102, "typeface");
        g.b(r100, r101, r102);
    }

    public void cacheTypefaceFromAssets(AssetManager r100, String r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "assetManager");
        Intrinsics.checkNotNullParameter(r101, "fontFamilyName");
        Intrinsics.checkNotNullParameter(r103, "path");
        Typeface r104 = g.e(r100, r101, r102, r103);
        if (r104 == null) goto L6;
        g.b(r101, r102, r104);
        return;
    }

    public Typeface getTypefaceFromAssets(AssetManager r100, String r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "assetManager");
        Intrinsics.checkNotNullParameter(r101, "fontFamilyName");
        Intrinsics.checkNotNullParameter(r103, "path");
        return g.e(r100, r101, r102, r103);
    }
}
