package com.bytedance.ies.bullet.forest;

import com.bytedance.forest.model.ResourceFrom2;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.ies.bullet.service.base.ResourceFrom;
import com.bytedance.ies.bullet.service.base.ResourceType;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f246738a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f246739b = null;

        static {
            int[] r100 = new int[ResourceFrom2.values().length];
            r100[ResourceFrom2.BUILTIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L55:
            r100[ResourceFrom2.MEMORY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L6:
            f246738a = r100;
            int[] r101 = new int[Scene.values().length];
            r101[Scene.LYNX_TEMPLATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L47:
            r101[Scene.LYNX_EXTERNAL_JS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L57:
            r101[Scene.LYNX_COMPONENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
        L59:
            r101[Scene.LYNX_CHILD_RESOURCE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L26
        L35:
            r101[Scene.LYNX_FONT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L27
        L41:
            r101[Scene.LYNX_I18N.ordinal()] = 6;     // Catch: NoSuchFieldError -> L28
        L53:
            r101[Scene.LYNX_IMAGE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L29
        L37:
            r101[Scene.LYNX_LOTTIE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L30
        L49:
            r101[Scene.LYNX_VIDEO.ordinal()] = 9;     // Catch: NoSuchFieldError -> L31
        L51:
            r101[Scene.LYNX_SVG.ordinal()] = 10;     // Catch: NoSuchFieldError -> L32
        L61:
            r101[Scene.LYNX_CORE_JS.ordinal()] = 11;     // Catch: NoSuchFieldError -> L33
        L45:
            r101[Scene.LYNX_THEME.ordinal()] = 12;     // Catch: NoSuchFieldError -> L34
        L19:
            f246739b = r101;
        }
    }

    public static final ResourceFrom a(ResourceFrom2 r100) {
        if (r100 == ResourceFrom2.GECKO) goto L20;
        if (r100 == ResourceFrom2.GECKO_UPDATE) goto L20;
        if (r100 == ResourceFrom2.CDN) goto L23;
        if (r100 == ResourceFrom2.CDN_CACHE) goto L23;
        if (r100 == ResourceFrom2.GECKO_OFFLINE_CDN) goto L23;
        if (r100 == ResourceFrom2.BUILTIN) goto L21;
        return null;
    L21:
        return ResourceFrom.BUILTIN;
    L23:
        return ResourceFrom.CDN;
    L20:
        return ResourceFrom.GECKO;
    }

    public static final ResourceFrom b(ResourceFrom2 r100, Response r101) {
        if (r101.f244309k == true) goto L15;
        if (r101.f244310l == true) goto L15;
        if (r100 != ResourceFrom2.MEMORY) goto L18;
        ResourceFrom2 r102 = r101.f244322x;
        if (r102 != null) goto L16;
        return null;
    L16:
        return b(r102, r101);
    L18:
        return a(r100);
    L15:
        return ResourceFrom.PRELOAD;
    }

    public static final ResourceType c(ResourceFrom2 r100, Response r101) {
        int r102 = a.f246738a[r100.ordinal()];
        if (r102 == 1) goto L13;
        if (r102 != 2) goto L14;
        ResourceFrom2 r103 = r101.f244322x;
        if (r103 == null) goto L16;
        ResourceType r104 = c(r103, r101);
        if (r104 == null) goto L16;
        return r104;
    L16:
        return ResourceType.DISK;
    L14:
        return ResourceType.DISK;
    L13:
        return ResourceType.ASSET;
    }
}
