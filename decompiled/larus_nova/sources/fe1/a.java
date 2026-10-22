package fe1;

import android.text.TextUtils;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static String a(String r100) {
        if (TextUtils.equals("1", r100) == false) goto L7;
        return "com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.LiveToolbarWidget";
    L7:
        if (TextUtils.equals("2", r100) == false) goto L11;
        return "com.bytedance.android.livesdk.interactivity.PublicScreenBottomPlaceHolder";
    L11:
        if (TextUtils.equals("3", r100) == false) goto L15;
        return "com.bytedance.android.livesdk.room.placeholder.widget.RightCardPlaceHolder";
    L15:
        if (TextUtils.equals("4", r100) == false) goto L19;
        return "com.bytedance.android.livesdk.room.placeholder.widget.TopRightRow4thPlaceHolder";
    L19:
        if (TextUtils.equals("5", r100) == false) goto L23;
        return "com.bytedance.android.livesdk.room.placeholder.widget.SingleViewPlaceHolder attachEcomRightTopWidget";
    L23:
        if (TextUtils.equals("6", r100) == false) goto L27;
        return "com.bytedance.android.livesdk.room.placeholder.widget.SingleViewPlaceHolder attachShoppingShortcut";
    L27:
        if (TextUtils.equals("7", r100) == false) goto L31;
        return "com.bytedance.android.live.revlink.impl.pk.widget.link.LinkCrossRoomAudienceWidget";
    L31:
        if (TextUtils.equals("8", r100) == false) goto L35;
        return "com.bytedance.android.live.revlink.impl.multianchor.widget.MultiLinkAudienceWidget";
    L35:
        if (TextUtils.equals(Constants.VIA_SHARE_TYPE_MINI_PROGRAM, r100) == false) goto L38;
        return "com.bytedance.android.livesdk.room.placeholder.widget.BottomCardPlaceHolderWidget";
    L38:
        return null;
    }
}
