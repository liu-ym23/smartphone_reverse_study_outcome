package com.larus.community.impl.quickmenu;

import android.net.Uri;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import o29.i;
import o29.j;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f329733a = 0;

    /* JADX INFO: renamed from: com.larus.community.impl.quickmenu.a$a, reason: collision with other inner class name */
    public static final class C4196a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f329734a;

        public C4196a() {
            this.f329734a = new i();
        }

        public static void a(C4196a r110, String r111, String r112, String r113, Uri r114, Uri r115, boolean r116, boolean r210, int r211) {
            String r100 = null;
            if ((r211 & 4) == 0) goto L5;
            String r101 = null;
        L7:
            if ((r211 & 16) == 0) goto L9;
            Uri r102 = null;
        L11:
            if ((r211 & 32) != 0) goto L14;
            r100 = "creation_dosame_quick_menu";
        L14:
            String r103 = r100;
            boolean r104 = false;
            if ((r211 & 64) == 0) goto L17;
            boolean r105 = false;
        L19:
            if ((r211 & 128) != 0) goto L22;
            r104 = r210;
        L22:
            r110.getClass();
            Intrinsics.checkNotNullParameter(r111, "id");
            Intrinsics.checkNotNullParameter(r112, "title");
            Intrinsics.checkNotNullParameter(r114, "iconUri");
            i r117 = r110.f329734a;
            r117.getClass();
            Intrinsics.checkNotNullParameter(r111, "id");
            Intrinsics.checkNotNullParameter(r112, "title");
            Intrinsics.checkNotNullParameter(r114, "iconUri");
            ((ArrayList) r117.f521805a).add(new j(r111, r112, r101, r114, r102, r103, r105, r104, null));
            return;
        L17:
            r105 = r116;
            goto L19
        L9:
            r102 = r115;
            goto L11
        L5:
            r101 = r113;
            goto L7
        }
    }

    static {
    }
}
