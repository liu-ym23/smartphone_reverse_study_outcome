package com.larus.chat.gallery.impl.preview.toolbar;

import com.larus.chat.gallery.impl.preview.data.SourceType;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sq9.a0;

/* JADX INFO: loaded from: classes26.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f324793a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f324794a = 0;

        static {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f324795a = 0;

        static {
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f324796a = null;

        static {
            int[] r100 = new int[SourceType.values().length];
            r100[SourceType.ALBUM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[SourceType.ATTACHMENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r100[SourceType.CAMERA_RESULT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[SourceType.CLOUD_DRIVE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r100[SourceType.USER_SEND.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r100[SourceType.BOT_RESP.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r100[SourceType.CREATION_CARD.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[SourceType.CREATION_RECORD.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f324796a = r100;
        }
    }

    static {
    }

    public static e a(xy8.d r100, a0 r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        List r103 = null;
        if (r102 == false) goto L5;
    L22:
        int r104 = b.f324795a;
        if (r101 == null) goto L27;
        List<String> r105 = r101.c();
        if (r105 == null) goto L27;
        List r106 = CollectionsKt.filterNotNull(r105);
    L28:
        if (r106 != null) goto L30;
        r106 = CollectionsKt.emptyList();
    L30:
        if (r101 == null) goto L34;
        List<String> r107 = r101.b();
        if (r107 == null) goto L34;
        List r108 = CollectionsKt.filterNotNull(r107);
    L35:
        if (r108 != null) goto L37;
        r108 = CollectionsKt.emptyList();
    L37:
        if (r101 == null) goto L41;
        List<String> r109 = r101.a();
        if (r109 == null) goto L41;
        r103 = CollectionsKt.filterNotNull(r109);
    L41:
        if (r103 != null) goto L43;
        r103 = CollectionsKt.emptyList();
    L43:
        e r110 = new e(r106, r108, r103);
    L44:
        return r110;
    L34:
        r108 = null;
    L27:
        r106 = null;
        goto L28
    L5:
        if (r100.f565441p == null) goto L22;
        switch(c.f324796a[r100.f565426a.ordinal()]) {
            case 1: goto L11;
            case 2: goto L11;
            case 3: goto L11;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L10;
            case 7: goto L10;
            case 8: goto L10;
            default: goto L9;
        };
    L10:
        boolean r111 = false;
    L12:
        if (r111 == true) goto L22;
        int r112 = a.f324794a;
        List r113 = CollectionsKt.listOf(ToolbarButtonType.SHARE.getKey());
        List r114 = CollectionsKt.emptyList();
        if (r101 == null) goto L19;
        List<String> r115 = r101.a();
        if (r115 == null) goto L19;
        r103 = CollectionsKt.filterNotNull(r115);
    L19:
        if (r103 != null) goto L21;
        r103 = CollectionsKt.emptyList();
    L21:
        r110 = new e(r113, r114, r103);
        goto L44
    L11:
        r111 = true;
        goto L12
    L9:
        throw new NoWhenBranchMatchedException();
    }
}
