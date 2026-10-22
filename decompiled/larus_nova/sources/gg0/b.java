package gg0;

import android.os.Bundle;
import com.bytedance.android.live.liveinteract.linkbase.api.SeatItemId;
import com.bytedance.android.live.liveinteract.utils.t0;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import tf0.e;

/* JADX INFO: loaded from: classes46.dex */
public abstract class b<T extends tf0.e> {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    public abstract boolean b(T r100, T r101);

    public boolean a(T r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "oldItem");
        Intrinsics.checkNotNullParameter(r101, "newItem");
        if (c(SeatItemId.USER_INFO, r100, r101) == true) goto L5;
    L17:
        return false;
    L5:
        if (c(SeatItemId.GIFT_ICON, r100, r101) == false) goto L17;
        if (c(SeatItemId.TAG_LABEL_INFO, r100, r101) == false) goto L17;
        if (c(SeatItemId.EMPTY_INFO, r100, r101) == false) goto L17;
        if (c(SeatItemId.SEAT_WIDGET, r100, r101) == false) goto L17;
        if (c(SeatItemId.RANDOM_EMOJI, r100, r101) == false) goto L17;
        if (r100.f545694j != r101.f545694j) goto L17;
        return true;
    }

    public static boolean c(SeatItemId r100, tf0.e r101, tf0.e r102) {
        HashMap<String, tf0.d> r103 = r101.f545693i;
        HashMap<String, tf0.d> r104 = r102.f545693i;
        tf0.d r105 = r103.get(r100.name());
        tf0.d r106 = r104.get(r100.name());
        if (r105 != null) goto L7;
        if (r106 != null) goto L7;
        return true;
    L7:
        if (vm2.d.N0() == false) goto L15;
        if (r105 != null) goto L10;
    L12:
        return false;
    L10:
        if (r105.e(r106) != true) goto L12;
        return true;
    L15:
        return Intrinsics.areEqual(r105, r106);
    }

    public Bundle d(T r100, T r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "oldItem");
        Intrinsics.checkNotNullParameter(r101, "newItem");
        Bundle r104 = new Bundle();
        if (c(SeatItemId.USER_INFO, r100, r101) == true) goto L6;
        r104.putBoolean("payload_key_dynamic_data_update_for_user_info", true);
    L6:
        if (c(SeatItemId.GIFT_ICON, r100, r101) == true) goto L9;
        r104.putBoolean("payload_key_dynamic_data_update_for_gift_icon_info", true);
    L9:
        if (c(SeatItemId.TAG_LABEL_INFO, r100, r101) == true) goto L12;
        r104.putBoolean("payload_key_dynamic_data_update_for_tag_label_info", true);
    L12:
        if (c(SeatItemId.EMPTY_INFO, r100, r101) == true) goto L15;
        r104.putBoolean("payload_key_dynamic_data_update_for_empty_info", true);
    L15:
        if (c(SeatItemId.SEAT_WIDGET, r100, r101) == true) goto L18;
        r104.putBoolean("payload_key_dynamic_data_update_for_seat_widget_info", true);
    L18:
        if (c(SeatItemId.RANDOM_EMOJI, r100, r101) == true) goto L20;
        r104.putBoolean("payload_key_dynamic_data_update_for_seat_random_emoji_info", true);
    L20:
        boolean r105 = r100.f545694j;
        boolean r106 = r101.f545694j;
        if (r105 == r106) goto L24;
        r104.putBoolean("payload_key_is_visible", r106);
    L24:
        if (r100.f545688d == r101.f545688d) goto L26;
        int r107 = t0.f78832a;
        t0.a("ItemDiffer", "show_from update, old=" + r100.f545688d + ", new=" + r101.f545688d);
        r104.putBoolean("payload_key_update_for_show_from", true);
    L26:
        return r104;
    }
}
