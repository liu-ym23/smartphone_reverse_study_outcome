package j92;

import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes9.dex */
public final class a {
    public static boolean a(DataCenter r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if (((Boolean) r100.get("data_live_new_feed_style", Boolean.FALSE)).booleanValue() == false) goto L8;
        if (((Boolean) r100.get("data_is_portrait", Boolean.TRUE)).booleanValue() == false) goto L8;
        return true;
    }
}
