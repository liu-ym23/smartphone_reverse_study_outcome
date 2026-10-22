package com.obric.memorydata.recommend.tile;

import android.service.quicksettings.TileService;
import com.volcengine.zeus.Zeus;
import java.util.ArrayList;
import java.util.List;
import oka.b;
import oka.c;
import oka.d;
import oka.e;
import oka.f;
import oka.g;
import oka.h;
import oka.i;

/* JADX INFO: loaded from: classes33.dex */
public class ScreenObservationTileService extends TileService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f397050a = 0;

    public interface a {
        void a(IScreenObservationTileDelegate r100);
    }

    @Override // android.service.quicksettings.TileService
    public final void onClick() {
        super.onClick();
        a(new f());
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        a(new c(this));
    }

    @Override // android.service.quicksettings.TileService, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        IScreenObservationTileDelegate r100 = ScreenObservationTileRegistry.getDelegate();
        if (r100 == null) goto L6;
        r100.onDestroy();
        return;
    }

    @Override // android.service.quicksettings.TileService
    public final void onStartListening() {
        super.onStartListening();
        a(new g());
    }

    @Override // android.service.quicksettings.TileService
    public final void onStopListening() {
        super.onStopListening();
        a(new e());
    }

    @Override // android.service.quicksettings.TileService
    public final void onTileAdded() {
        super.onTileAdded();
        a(new d());
    }

    @Override // android.service.quicksettings.TileService
    public final void onTileRemoved() {
        super.onTileRemoved();
        a(new h());
    }

    public ScreenObservationTileService() {
    }

    public static void a(final a r100) {
        Runnable r101 = new i(r100);
        List<Runnable> r102 = b.f523742a;
        if (Zeus.isPluginLoaded("com.obric.memorydata.plugin") == false) goto L5;
        r101.run();
        return;
    L5:
        ((ArrayList) b.f523742a).add(r101);
        if (b.f523744c == true) goto L11;
        b.f523744c = true;
        Zeus.registerPluginStateListener(new oka.a());
        return;
    }
}
