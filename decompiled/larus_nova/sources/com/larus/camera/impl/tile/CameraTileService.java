package com.larus.camera.impl.tile;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.platform.service.i3;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002¨\u0006\r"}, d2 = {"Lcom/larus/camera/impl/tile/CameraTileService;", "Landroid/service/quicksettings/TileService;", "<init>", "()V", "onTileAdded", "", "onTileRemoved", "onStartListening", "onStopListening", SendEventContainerMethodParamModel.EventKinds.onClick, "updateState", "handleClick", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraTileService extends TileService {

    public static final class a {
    }

    static {
    }

    @Override // android.service.quicksettings.TileService
    public final void onClick() {
        super.onClick();
        AppHost.Companion r100 = AppHost.f326268a;     // Catch: Exception -> L11
        Intent r101 = r100.getApplication().getPackageManager().getLaunchIntentForPackage(r100.getApplication().getPackageName());     // Catch: Exception -> L11
        if (r101 != null) goto L6;
        FLogger.f375446a.e("CameraTileService", "handleClick error, intent is null");     // Catch: Exception -> L11
    L14:
        return;
    L6:
        r101.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);     // Catch: Exception -> L11
        r101.setData(UriProtector.parse("sslocal://flow/chat?is_from_outer=true&auto_open_plus_camera=1&open_method=shortcuts&enter_method=shortcuts"));     // Catch: Exception -> L11
        r101.setFlags(268468224);     // Catch: Exception -> L11
        i3 r102 = i3.f365750a;     // Catch: Exception -> L11
        r101.putExtra("is_tourist_mode", r102.f());     // Catch: Exception -> L11
        r101.putExtra("show_tourist_mode_toast", r102.f());     // Catch: Exception -> L11
        if (Build.VERSION.SDK_INT < 34) goto L9;
        startActivityAndCollapse(PendingIntent.getActivity(this, 0, r101, 67108864));     // Catch: Exception -> L11
        goto L14
    L9:
        startActivityAndCollapse(r101);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        FLogger.f375446a.e("CameraTileService", "handleClick error", e);
    }

    @Override // android.service.quicksettings.TileService
    public final void onStartListening() {
        super.onStartListening();
        Tile r100 = getQsTile();
        if (r100 != null) goto L6;
        return;
    L6:
        if (AppHost.f326268a.isOversea() == false) goto L8;
        String r101 = getString(R.string.system_controlCenter_camera_global);
    L9:
        r100.setLabel(r101);
        r100.updateTile();
        return;
    L8:
        r101 = getString(R.string.larus_system_controlCenter_camera_cn);
        goto L9
    }

    public CameraTileService() {
    }

    @Override // android.service.quicksettings.TileService
    public final void onStopListening() {
        super.onStopListening();
    }

    @Override // android.service.quicksettings.TileService
    public final void onTileAdded() {
        super.onTileAdded();
    }

    @Override // android.service.quicksettings.TileService
    public final void onTileRemoved() {
        super.onTileRemoved();
    }
}
