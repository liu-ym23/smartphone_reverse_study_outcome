package com.bytedance.lynx.webview.adblock;

import android.content.Context;
import com.bytedance.lynx.webview.internal.TTWebContext;
import l17.k;

/* JADX INFO: loaded from: classes21.dex */
public final class TTAdblockEngineFactory {

    public static final enum ResourceType extends Enum<ResourceType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ResourceType[] f265051a = null;
        public static final ResourceType kCspReport = null;
        public static final ResourceType kFavicon = null;
        public static final ResourceType kFontResource = null;
        public static final ResourceType kImage = null;
        public static final ResourceType kMainFrame = null;
        public static final ResourceType kMedia = null;
        public static final ResourceType kNavigationPreload = null;
        public static final ResourceType kObject = null;
        public static final ResourceType kPing = null;
        public static final ResourceType kPluginResource = null;
        public static final ResourceType kPrefetch = null;
        public static final ResourceType kScript = null;
        public static final ResourceType kServiceWorker = null;
        public static final ResourceType kSharedWorker = null;
        public static final ResourceType kStylesheet = null;
        public static final ResourceType kSubFrame = null;
        public static final ResourceType kSubResource = null;
        public static final ResourceType kWorker = null;
        public static final ResourceType kXhr = null;
        private final int val;

        static {
            ResourceType r100 = new ResourceType("kMainFrame", 0, 0);
            kMainFrame = r100;
            ResourceType r101 = new ResourceType("kSubFrame", 1, 1);
            kSubFrame = r101;
            ResourceType r102 = new ResourceType("kStylesheet", 2, 2);
            kStylesheet = r102;
            ResourceType r103 = new ResourceType("kScript", 3, 3);
            kScript = r103;
            ResourceType r104 = new ResourceType("kImage", 4, 4);
            kImage = r104;
            ResourceType r105 = new ResourceType("kFontResource", 5, 5);
            kFontResource = r105;
            ResourceType r110 = new ResourceType("kSubResource", 6, 6);
            kSubResource = r110;
            ResourceType r111 = new ResourceType("kObject", 7, 7);
            kObject = r111;
            ResourceType r112 = new ResourceType("kMedia", 8, 8);
            kMedia = r112;
            ResourceType r113 = new ResourceType("kWorker", 9, 9);
            kWorker = r113;
            ResourceType r114 = new ResourceType("kSharedWorker", 10, 10);
            kSharedWorker = r114;
            ResourceType r115 = new ResourceType("kPrefetch", 11, 11);
            kPrefetch = r115;
            ResourceType r106 = new ResourceType("kFavicon", 12, 12);
            kFavicon = r106;
            ResourceType r107 = new ResourceType("kXhr", 13, 13);
            kXhr = r107;
            ResourceType r108 = new ResourceType("kPing", 14, 14);
            kPing = r108;
            ResourceType r109 = new ResourceType("kServiceWorker", 15, 15);
            kServiceWorker = r109;
            ResourceType r116 = new ResourceType("kCspReport", 16, 16);
            kCspReport = r116;
            ResourceType r117 = new ResourceType("kPluginResource", 17, 17);
            kPluginResource = r117;
            ResourceType r118 = new ResourceType("kNavigationPreload", 18, 18);
            kNavigationPreload = r118;
            f265051a = new ResourceType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118};
        }

        public static ResourceType[] values() {
            return (ResourceType[]) f265051a.clone();
        }

        public int getValue() {
            return this.val;
        }

        public static ResourceType getType(int r100) {
            ResourceType[] r101 = values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L9;
            ResourceType r104 = r101[r103];
            if (r104.getValue() == r100) goto L6;
            r103 = r103 + 1;
            goto L3
        L6:
            return r104;
        L9:
            return kMainFrame;
        }

        public static ResourceType valueOf(String r100) {
            return (ResourceType) r27.a.a(ResourceType.class, r100);
        }

        public ResourceType(String r100, int r101, int r102) {
            super(r100, r101);
            this.val = r102;
        }
    }

    public static b a(String r100, String r101) {
        Context r102 = TTWebContext.h().getContext();
        b r103 = new b(r102, r100);
        Object r104 = r103.f265057b;
        monitor-enter(r104);
        TTWebViewAdblockWrapper r105 = r103.f265056a;     // Catch: Throwable -> L9
        if (r105 == null) goto L12;
        e r106 = r105.f265053b;     // Catch: Throwable -> L9
        if (r106 == null) goto L11;
        r105.f265052a = 0;     // Catch: Throwable -> L9
        r106.a(2);     // Catch: Throwable -> L9
        r105.f265053b = null;     // Catch: Throwable -> L9
    L11:
        r103.f265056a = null;     // Catch: Throwable -> L9
    L12:
        TTWebViewAdblockWrapper r107 = new TTWebViewAdblockWrapper(r102.getCacheDir().getAbsolutePath(), r100);     // Catch: Throwable -> L9
        if (r107.c(r101) == false) goto L17;
        r103.f265056a = r107;     // Catch: Throwable -> L9
        monitor-exit(r104);     // Catch: Throwable -> L9
        boolean r108 = true;
    L19:
        if (r108 == false) goto L21;
        k.d(new String[]{"TTAdblockEngine " + r100 + " parse success"});
    L22:
        if (r108 == false) goto L25;
        return r103;
    L25:
        return null;
    L21:
        k.d(new String[]{"TTAdblockEngine " + r100 + " parse fail"});
        goto L22
    L17:
        monitor-exit(r104);     // Catch: Throwable -> L9
        r108 = false;
    L9:
        th = move-exception;
        throw th;
    }
}
