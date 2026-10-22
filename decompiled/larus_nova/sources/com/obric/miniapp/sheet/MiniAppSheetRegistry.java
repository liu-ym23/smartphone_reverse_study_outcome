package com.obric.miniapp.sheet;

import android.app.Activity;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007J\u0010\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\u000f\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0014\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/miniapp/sheet/MiniAppSheetRegistry;", "", "<init>", "()V", "hosts", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/obric/miniapp/sheet/MiniAppSheetHost;", "order", "", MiPushClient.COMMAND_REGISTER, "", "host", MiPushClient.COMMAND_UNREGISTER, "viewId", "dismiss", "", "activity", "Landroid/app/Activity;", "dismissWithViewId", "dismissLatest", "dismissLatestWithViewId", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniAppSheetRegistry {
    public static final MiniAppSheetRegistry INSTANCE = null;
    private static final ConcurrentHashMap<String, MiniAppSheetHost> hosts = null;
    private static final List<String> order = null;

    private MiniAppSheetRegistry() {
    }

    static {
        INSTANCE = new MiniAppSheetRegistry();
        hosts = new ConcurrentHashMap();
        order = new ArrayList();
    }

    public final boolean dismissLatest(Activity r100) {
        if (dismissLatestWithViewId(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final String dismissLatestWithViewId(Activity r100) {
        monitor-enter(this);
        int r101 = order.size();     // Catch: Throwable -> L18
    L4:
        r101 = r101 - 1;     // Catch: Throwable -> L18
        if ((-1) >= r101) goto L12;
        MiniAppSheetHost r102 = hosts.get(order.get(r101));     // Catch: Throwable -> L18
        if (r102 == null) goto L4;
        if (r102.activityMatches(r100) == false) goto L4;
    L13:
        monitor-exit(this);
        if (r102 != null) goto L16;
        return null;
    L16:
        String r103 = r102.viewId();
        r102.dismiss();
        return r103;
    L12:
        r102 = null;
    L18:
        th = move-exception;
        throw th;
    }

    public final void register(MiniAppSheetHost r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        String r101 = r100.viewId();
        if (r101 != null) goto L5;
        return;
    L5:
        monitor-enter(this);
        hosts.put(r101, r100);     // Catch: Throwable -> L9
        List<String> r102 = order;     // Catch: Throwable -> L9
        r102.remove(r101);     // Catch: Throwable -> L9
        r102.add(r101);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void unregister(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        monitor-enter(this);
        hosts.remove(r100);     // Catch: Throwable -> L8
        order.remove(r100);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final boolean dismiss(String r100, Activity r101) {
        if (dismissWithViewId(r100, r101) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final String dismissWithViewId(String r100, Activity r101) {
        monitor-enter(this);
        if (r100 != null) goto L19;
    L13:
        MiniAppSheetHost r102 = null;
    L14:
        monitor-exit(this);
        if (r102 != null) goto L17;
        return null;
    L17:
        String r103 = r102.viewId();
        r102.dismiss();
        return r103;
    L19:
        r102 = hosts.get(r100);     // Catch: Throwable -> L10
        if (r102 == null) goto L13;
        if (r102.activityMatches(r101) == false) goto L13;
    L10:
        th = move-exception;
        throw th;
    }
}
