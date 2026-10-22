package com.larus.voicecall.impl.tile;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.platform.service.i3;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.y0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import wc9.e;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002¨\u0006\r"}, d2 = {"Lcom/larus/voicecall/impl/tile/RealtimeVideoTileService;", "Landroid/service/quicksettings/TileService;", "<init>", "()V", "onTileAdded", "", "onTileRemoved", "onStartListening", "onStopListening", SendEventContainerMethodParamModel.EventKinds.onClick, "handleClick", "updateState", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeVideoTileService extends TileService {

    public static final class a {
    }

    static {
    }

    @Override // android.service.quicksettings.TileService
    public final void onClick() {
        super.onClick();
        e r100 = AuthModelDelegate.f297134b.y().getValue();     // Catch: Exception -> L18
        if (r100 == null) goto L6;
        String r101 = r100.f559198a;     // Catch: Exception -> L18
    L7:
        Uri r102 = UriProtector.parse("sslocal://flow/realtime_chat?is_from_outer=true&bot_id=7234781073513644036&open_method=shortcuts&open_vlm=1&sec_scene=shortcuts_video_call&enter_method=shortcuts");     // Catch: Exception -> L18
        if (o0.d(r101) == false) goto L10;
        r102 = y0.b(r102, "conversation_id", r101);     // Catch: Exception -> L18
    L10:
        AppHost.Companion r103 = AppHost.f326268a;     // Catch: Exception -> L18
        Intent r104 = r103.getApplication().getPackageManager().getLaunchIntentForPackage(r103.getApplication().getPackageName());     // Catch: Exception -> L18
        if (r104 != null) goto L13;
        FLogger.f375446a.e("RealtimeVideoTileService", "handleClick error, intent is null");     // Catch: Exception -> L18
    L20:
        int r105 = z3a.a.f569878a;
        Intrinsics.checkNotNullParameter("video_call", "modalType");
        o r106 = o.f365780a;
        JSONObject r107 = new JSONObject();
        r107.put("modal_type", "video_call");
        Unit r108 = Unit.INSTANCE;
        r106.reportEvent("flow_rd_tile_click", r107);
        return;
    L13:
        r104.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);     // Catch: Exception -> L18
        r104.setData(r102);     // Catch: Exception -> L18
        r104.setFlags(268468224);     // Catch: Exception -> L18
        i3 r109 = i3.f365750a;     // Catch: Exception -> L18
        r104.putExtra("is_tourist_mode", r109.f());     // Catch: Exception -> L18
        r104.putExtra("show_tourist_mode_toast", r109.f());     // Catch: Exception -> L18
        if (Build.VERSION.SDK_INT < 34) goto L16;
        startActivityAndCollapse(PendingIntent.getActivity(this, 0, r104, 67108864));     // Catch: Exception -> L18
        goto L20
    L16:
        startActivityAndCollapse(r104);     // Catch: Exception -> L18
        goto L20
    L6:
        r101 = null;
    L18:
        e = move-exception;
        FLogger.f375446a.e("RealtimeVideoTileService", "handleClick error", e);
        goto L20
    }

    @Override // android.service.quicksettings.TileService
    public final void onStartListening() {
        super.onStartListening();
        FLogger.f375446a.i("RealtimeVideoTileService", "onStartListening");
        Tile r100 = getQsTile();
        if (r100 == null) goto L7;
        r100.setLabel(getString(R.string.larus_system_controlCenter_videoCall_cn));
        r100.updateTile();
        return;
    }

    @Override // android.service.quicksettings.TileService
    public final void onStopListening() {
        super.onStopListening();
        FLogger.f375446a.i("RealtimeVideoTileService", "onStopListening");
    }

    @Override // android.service.quicksettings.TileService
    public final void onTileAdded() {
        super.onTileAdded();
        FLogger.f375446a.i("RealtimeVideoTileService", "onTileAdded");
        int r100 = z3a.a.f569878a;
        Intrinsics.checkNotNullParameter("video_call", "modalType");
        o r101 = o.f365780a;
        JSONObject r102 = new JSONObject();
        r102.put("modal_type", "video_call");
        Unit r103 = Unit.INSTANCE;
        r101.reportEvent("flow_rd_tile_add", r102);
    }

    @Override // android.service.quicksettings.TileService
    public final void onTileRemoved() {
        super.onTileRemoved();
        FLogger.f375446a.i("RealtimeVideoTileService", "onTileRemoved");
        int r100 = z3a.a.f569878a;
        Intrinsics.checkNotNullParameter("video_call", "modalType");
        o r101 = o.f365780a;
        JSONObject r102 = new JSONObject();
        r102.put("modal_type", "video_call");
        Unit r103 = Unit.INSTANCE;
        r101.reportEvent("flow_rd_tile_remove", r102);
    }

    public RealtimeVideoTileService() {
    }
}
