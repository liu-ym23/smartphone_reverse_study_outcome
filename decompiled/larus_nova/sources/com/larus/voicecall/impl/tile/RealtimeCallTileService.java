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
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0002¨\u0006\r"}, d2 = {"Lcom/larus/voicecall/impl/tile/RealtimeCallTileService;", "Landroid/service/quicksettings/TileService;", "<init>", "()V", "onTileAdded", "", "onTileRemoved", "onStartListening", SendEventContainerMethodParamModel.EventKinds.onClick, "handleClick", "onStopListening", "updateState", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallTileService extends TileService {

    public static final class a {
    }

    static {
    }

    @Override // android.service.quicksettings.TileService
    public final void onClick() {
        FLogger r100 = FLogger.f375446a;
        r100.i("RealtimeCallTileService", SendEventContainerMethodParamModel.EventKinds.onClick);
        super.onClick();
        e r101 = AuthModelDelegate.f297134b.y().getValue();     // Catch: Exception -> L18
        if (r101 == null) goto L6;
        String r102 = r101.f559198a;     // Catch: Exception -> L18
    L7:
        Uri r103 = UriProtector.parse("sslocal://flow/realtime_chat?is_from_outer=true&bot_id=7234781073513644036&open_method=shortcuts&sec_scene=shortcuts_call&enter_method=shortcuts");     // Catch: Exception -> L18
        if (o0.d(r102) == false) goto L10;
        r103 = y0.b(r103, "conversation_id", r102);     // Catch: Exception -> L18
    L10:
        AppHost.Companion r104 = AppHost.f326268a;     // Catch: Exception -> L18
        Intent r105 = r104.getApplication().getPackageManager().getLaunchIntentForPackage(r104.getApplication().getPackageName());     // Catch: Exception -> L18
        if (r105 != null) goto L13;
        r100.e("RealtimeCallTileService", "handleClick error, intent is null");     // Catch: Exception -> L18
    L20:
        int r106 = z3a.a.f569878a;
        Intrinsics.checkNotNullParameter("audio", "modalType");
        o r107 = o.f365780a;
        JSONObject r108 = new JSONObject();
        r108.put("modal_type", "audio");
        Unit r109 = Unit.INSTANCE;
        r107.reportEvent("flow_rd_tile_click", r108);
        return;
    L13:
        r105.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);     // Catch: Exception -> L18
        r105.setData(r103);     // Catch: Exception -> L18
        r105.setFlags(268468224);     // Catch: Exception -> L18
        i3 r110 = i3.f365750a;     // Catch: Exception -> L18
        r105.putExtra("is_tourist_mode", r110.f());     // Catch: Exception -> L18
        r105.putExtra("show_tourist_mode_toast", r110.f());     // Catch: Exception -> L18
        if (Build.VERSION.SDK_INT < 34) goto L16;
        startActivityAndCollapse(PendingIntent.getActivity(this, 0, r105, 67108864));     // Catch: Exception -> L18
        goto L20
    L16:
        startActivityAndCollapse(r105);     // Catch: Exception -> L18
        goto L20
    L6:
        r102 = null;
    L18:
        e = move-exception;
        FLogger.f375446a.e("RealtimeCallTileService", "handleClick error", e);
        goto L20
    }

    @Override // android.service.quicksettings.TileService
    public final void onStartListening() {
        super.onStartListening();
        FLogger.f375446a.i("RealtimeCallTileService", "onStartListening");
        Tile r100 = getQsTile();
        if (r100 != null) goto L6;
        return;
    L6:
        if (AppHost.f326268a.isOversea() == false) goto L8;
        String r101 = getString(R.string.system_controlCenter_call_global);
    L9:
        r100.setLabel(r101);
        r100.updateTile();
        return;
    L8:
        r101 = getString(R.string.larus_system_controlCenter_call_cn);
        goto L9
    }

    @Override // android.service.quicksettings.TileService
    public final void onStopListening() {
        super.onStopListening();
        FLogger.f375446a.i("RealtimeCallTileService", "onStopListening");
    }

    @Override // android.service.quicksettings.TileService
    public final void onTileAdded() {
        super.onTileAdded();
        FLogger.f375446a.i("RealtimeCallTileService", "onTileAdded");
        int r100 = z3a.a.f569878a;
        Intrinsics.checkNotNullParameter("audio", "modalType");
        o r101 = o.f365780a;
        JSONObject r102 = new JSONObject();
        r102.put("modal_type", "audio");
        Unit r103 = Unit.INSTANCE;
        r101.reportEvent("flow_rd_tile_add", r102);
    }

    @Override // android.service.quicksettings.TileService
    public final void onTileRemoved() {
        super.onTileRemoved();
        FLogger.f375446a.i("RealtimeCallTileService", "onTileRemoved");
        int r100 = z3a.a.f569878a;
        Intrinsics.checkNotNullParameter("audio", "modalType");
        o r101 = o.f365780a;
        JSONObject r102 = new JSONObject();
        r102.put("modal_type", "audio");
        Unit r103 = Unit.INSTANCE;
        r101.reportEvent("flow_rd_tile_remove", r102);
    }

    public RealtimeCallTileService() {
    }
}
