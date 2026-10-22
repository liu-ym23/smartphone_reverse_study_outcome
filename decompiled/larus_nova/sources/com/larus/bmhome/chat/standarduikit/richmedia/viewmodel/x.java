package com.larus.bmhome.chat.standarduikit.richmedia.viewmodel;

import com.larus.bmhome.chat.standarduikit.richmedia.view.RichMediaItemAction;
import com.larus.bmhome.chat.standarduikit.richmedia.view.RichMediaKind;
import com.larus.bmhome.chat.standarduikit.richmedia.view.RichMediaOverlayAlignment;

/* JADX INFO: loaded from: classes26.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f309724a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f309725a = null;

        static {
            int[] r100 = new int[RichMediaKind.values().length];
            r100[RichMediaKind.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[RichMediaKind.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f309725a = r100;
        }
    }

    static {
    }

    public static fn8.a a(RichMediaItemAction r100, RichMediaOverlayAlignment r101, int r110, boolean r111) {
        return new fn8.a(r100, r101, Integer.valueOf(r110), null, r111, 8);
    }
}
