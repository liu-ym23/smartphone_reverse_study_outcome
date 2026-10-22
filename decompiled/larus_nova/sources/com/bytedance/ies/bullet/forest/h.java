package com.bytedance.ies.bullet.forest;

import com.bytedance.forest.model.PreloadType;
import com.bytedance.forest.model.Scene;

/* JADX INFO: loaded from: classes19.dex */
public final class h {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f246745a = null;

        static {
            int[] r100 = new int[PreloadType.values().length];
            r100[PreloadType.WEB.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f246745a = r100;
        }
    }

    public static final Scene a(PreloadType r100) {
        if (a.f246745a[r100.ordinal()] != 1) goto L6;
        return Scene.WEB_MAIN_DOCUMENT;
    L6:
        return Scene.LYNX_TEMPLATE;
    }
}
