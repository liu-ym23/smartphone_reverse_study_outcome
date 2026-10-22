package gg0;

import android.os.Bundle;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.audio.viewbinder.MultiLinkPreOnlineViewBinder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class i extends b<MultiLinkPreOnlineViewBinder.a> {

    public static final class a {
    }

    static {
    }

    public i() {
    }

    @Override // gg0.b
    public final boolean a(tf0.e r100, tf0.e r101) {
        MultiLinkPreOnlineViewBinder.a r102 = (MultiLinkPreOnlineViewBinder.a) r100;
        MultiLinkPreOnlineViewBinder.a r103 = (MultiLinkPreOnlineViewBinder.a) r101;
        Intrinsics.checkNotNullParameter(r102, "oldItem");
        Intrinsics.checkNotNullParameter(r103, "newItem");
        LinkmicPositionItem r104 = r102.f75585n;
        LinkmicPositionItem r105 = r103.f75585n;
        if (Intrinsics.areEqual(r104, r105) == false) goto L5;
        boolean r106 = true;
    L10:
        if (super.a(r102, r103) == false) goto L18;
        if (r106 == true) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(r102.f75582k.getIdString(), r103.f75582k.getIdString()) == true) goto L15;
        return false;
    L15:
        if (r102.f75583l != r103.f75583l) goto L21;
        return true;
    L21:
        return false;
    L18:
        return false;
    L5:
        if (r104 == null) goto L8;
        if (r105 == null) goto L8;
        r106 = r104.equals(r105);
    L8:
        r106 = false;
        goto L10
    }

    @Override // gg0.b
    public final boolean b(tf0.e r100, tf0.e r101) {
        MultiLinkPreOnlineViewBinder.a r102 = (MultiLinkPreOnlineViewBinder.a) r100;
        MultiLinkPreOnlineViewBinder.a r103 = (MultiLinkPreOnlineViewBinder.a) r101;
        Intrinsics.checkNotNullParameter(r102, "oldItem");
        Intrinsics.checkNotNullParameter(r103, "newItem");
        if (r102.f75584m != r103.f75584m) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // gg0.b
    public final Bundle d(tf0.e r100, tf0.e r101, int r102, int r103) {
        MultiLinkPreOnlineViewBinder.a r104 = (MultiLinkPreOnlineViewBinder.a) r100;
        MultiLinkPreOnlineViewBinder.a r105 = (MultiLinkPreOnlineViewBinder.a) r101;
        Intrinsics.checkNotNullParameter(r104, "oldItem");
        Intrinsics.checkNotNullParameter(r105, "newItem");
        Bundle r106 = super.d(r104, r105, r102, r103);
        LinkmicPositionItem r107 = r104.f75585n;
        LinkmicPositionItem r108 = r105.f75585n;
        if (Intrinsics.areEqual(r107, r108) == false) goto L5;
        boolean r109 = true;
    L9:
        if (r109 == true) goto L12;
        r106.putBoolean("payload_key_pre_online_position_item_update", true);
    L12:
        if ((!Intrinsics.areEqual(r104.f75582k.getIdString(), r105.f75582k.getIdString())) == false) goto L15;
        r106.putBoolean("payload_key_pre_online_user_update", true);
    L15:
        if (r104.f75583l == r105.f75583l) goto L17;
        r106.putBoolean("payload_key_pre_online_link_player_status_update", true);
    L17:
        return r106;
    L5:
        if (r107 == null) goto L8;
        if (r108 == null) goto L8;
        r109 = r107.equals(r108);
    L8:
        r109 = false;
        goto L9
    }
}
