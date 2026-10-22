package jt6;

import android.os.Bundle;
import com.bytedance.ies.bullet.prefetchv2.i;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public abstract class b implements jt6.a {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // jt6.a
    public final void c() {
    }

    @Override // jt6.a
    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "finalLogExtra");
    }

    @Override // jt6.a
    public abstract void log(String r100, String r101);

    @Override // jt6.a
    public final void b(String r100, String r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "label");
        Intrinsics.checkNotNullParameter(r102, "params");
        if (Intrinsics.areEqual(r101, "live_life_icon_click") == false) goto L6;
        String r103 = "action_icon_click";
    L9:
        MapsKt.emptyMap();
        log(r100, r103);
        return;
    L6:
        if (Intrinsics.areEqual(r101, "othershow") == false) goto L8;
        r103 = "action_icon_show";
        goto L9
    L8:
        r103 = "";
        goto L9
    }

    @Override // jt6.a
    public final void e(String r100, String r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "label");
        Intrinsics.checkNotNullParameter("card_new", "refer");
        int r103 = r101.hashCode();
        if (r103 == (-1944956403)) goto L18;
        if (r103 == 94756344) goto L14;
        if (r103 == 1334474601) goto L10;
    L19:
        String r104 = "";
    L21:
        if (r102 == null) goto L23;
        i.b(r102);
    L23:
        log(r100, r104);
        return;
    L10:
        if (r101.equals("live_life_card_click") == false) goto L19;
        r104 = "action_card_click";
        goto L21
    L14:
        if (r101.equals("close") == false) goto L19;
        r104 = "action_card_close";
        goto L21
    L18:
        if (r101.equals("othershow") == false) goto L19;
        r104 = "action_card_show";
        goto L21
    }

    @Override // jt6.a
    public final void d(String r100, String r101, String r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "label");
        Intrinsics.checkNotNullParameter(r102, "refer");
        if (Intrinsics.areEqual(r101, "live_shelf_show") == false) goto L6;
        String r104 = "action_shelf_show";
    L9:
        if (r103 == null) goto L11;
        i.b(r103);
    L11:
        log(r100, r104);
        return;
    L6:
        if (Intrinsics.areEqual(r101, "live_life_project_card_show") == false) goto L8;
        r104 = "action_shelf_card_show";
        goto L9
    L8:
        r104 = "";
        goto L9
    }
}
