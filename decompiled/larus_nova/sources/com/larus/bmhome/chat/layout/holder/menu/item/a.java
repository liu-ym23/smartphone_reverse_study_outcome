package com.larus.bmhome.chat.layout.holder.menu.item;

import android.view.View;
import com.baidu.platform.comapi.map.MapController;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f303978a;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.layout.holder.menu.item.a$a, reason: collision with other inner class name */
    public static final class C4056a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y f303979a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a f303980b;

        public C4056a() {
            y r100 = new y();
            this.f303979a = r100;
            this.f303980b = r100;
        }

        public final void a(a r100) {
            Intrinsics.checkNotNullParameter(r100, "handler");
            this.f303980b.f303978a = r100;
            this.f303980b = r100;
        }
    }

    public a() {
    }

    public boolean a(int r100) {
        return false;
    }

    public abstract boolean c(ot8.a r100, View r101, ef8.b r102);

    public static void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "who");
        String r102 = r101.concat(" in MenuContext is null, check!");
        FLogger.f375446a.e("MenuActionHandler_".concat(r100), r102);
        if (AppHost.f326268a.isDebug() == true) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(r100 + ", " + r102);
    }

    public final boolean b(ot8.a r100, View r101, ef8.b r102) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "menuContext");
        if (a(r100.getId()) == true) goto L5;
    L8:
        a r103 = this.f303978a;
        if (r103 != null) goto L11;
        return false;
    L11:
        return r103.b(r100, r101, r102);
    L5:
        if (c(r100, r101, r102) == false) goto L8;
        return true;
    }
}
