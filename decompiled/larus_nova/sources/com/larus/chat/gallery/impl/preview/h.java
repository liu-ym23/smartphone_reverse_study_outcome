package com.larus.chat.gallery.impl.preview;

import com.larus.chat.gallery.api.PreviewScene;

/* JADX INFO: loaded from: classes26.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f324301a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f324302a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f324303b = null;

        static {
            int[] r100 = new int[PreviewChromeKind.values().length];
            r100[PreviewChromeKind.MEDIA_SOURCE_V4.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[PreviewChromeKind.LEGACY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L6:
            f324302a = r100;
            int[] r101 = new int[PreviewScene.values().length];
            r101[PreviewScene.ALBUM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L29:
            r101[PreviewScene.ATTACHMENT_PANEL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L23:
            r101[PreviewScene.CAMERA_RESULT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L25:
            r101[PreviewScene.CLOUD_DRIVE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L11:
            f324303b = r101;
        }
    }

    static {
    }
}
