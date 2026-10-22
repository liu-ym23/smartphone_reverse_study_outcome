package h87;

import android.content.Context;
import com.bytedance.common.wschannel.app.OnMessageReceiveListener;
import com.bytedance.common.wschannel.event.ConnectEvent;
import com.bytedance.common.wschannel.event.ConnectionState;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sync.SyncSDK;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;
import yf7.j;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements OnMessageReceiveListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static b f484227d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f484228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f484229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile AtomicBoolean f484230c;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.sync.SyncSDK");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.sync.SyncSDK");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.sync.SyncSDK");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.sync.SyncSDK");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.sync.SyncSDK");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.sync.SyncSDK");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.sync.SyncSDK");
    }

    public b(Context r100) {
        this.f484230c = new AtomicBoolean(false);
        new AtomicBoolean(false);
        this.f484229b = r100;
    }

    public static b b(Context r100) {
        if (f484227d != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f484227d != null) goto L9;
        f484227d = new b(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f484227d;
    }

    @Override // com.bytedance.common.wschannel.app.OnMessageReceiveListener
    public final void onReceiveMsg(WsChannelMsg r100) {
        SyncSDK.onReceiveWsEvent(r100);
    }

    @Override // com.bytedance.common.wschannel.app.OnMessageReceiveListener
    public final void onReceiveConnectEvent(ConnectEvent r100, JSONObject r101) {
        AtomicBoolean r102 = this.f484230c;
        if (r100.connectionState != ConnectionState.CONNECTED) goto L5;
        boolean r103 = true;
    L6:
        r102.set(r103);
        throw null;
    L5:
        r103 = false;
        goto L6
    }
}
