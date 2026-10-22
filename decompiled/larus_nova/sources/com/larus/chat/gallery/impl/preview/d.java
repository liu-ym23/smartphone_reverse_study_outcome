package com.larus.chat.gallery.impl.preview;

/* JADX INFO: loaded from: classes26.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f324228a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f324229a = null;

        static {
            int[] r100 = new int[PreviewChromeKind.values().length];
            r100[PreviewChromeKind.LEGACY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[PreviewChromeKind.MEDIA_SOURCE_V4.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f324229a = r100;
        }
    }

    static {
    }
}
