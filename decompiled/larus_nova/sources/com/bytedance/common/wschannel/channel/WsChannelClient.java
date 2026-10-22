package com.bytedance.common.wschannel.channel;

import android.content.Context;
import android.os.Handler;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.impl.ok.OkChannelImpl;
import com.bytedance.common.wschannel.model.ServiceConnectEvent;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class WsChannelClient implements IWsChannelClient {
    private static String sMyselfChannelImplClass = "";
    private final int mChannelId;
    private final Handler mHandler;
    private IMessageHandler mMessageHandler;
    private List<String> mUrls;
    private boolean mUseCronetPlugin;
    private IWsChannelClient mWsChannelImpl;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void destroy() {
        monitor-enter(this);
        IWsChannelClient r100 = this.mWsChannelImpl;     // Catch: Throwable -> L19
        if (r100 == null) goto L17;
        r100.destroy();     // Catch: Throwable -> L19
        if ((this.mWsChannelImpl instanceof OkChannelImpl) == true) goto L17;
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L19
        List<String> r102 = this.mUrls;     // Catch: Throwable -> L19
        if (r102 != null) goto L10;
    L12:
        String r103 = "";
    L22:
        r101.put("type", 0);     // Catch: Exception -> L15 Throwable -> L19
        r101.put("state", 3);     // Catch: Exception -> L15 Throwable -> L19
        r101.put("url", r103);     // Catch: Exception -> L15 Throwable -> L19
        r101.put(WsConstants.KEY_CHANNEL_TYPE, 1);     // Catch: Exception -> L15 Throwable -> L19
        onConnectionInternal(r101);     // Catch: Exception -> L15 Throwable -> L19
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L19
        goto L17
    L10:
        if (r102.size() < 1) goto L12;
        r103 = this.mUrls.get(0);     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    }

    private void tryResolveMySelfChannelImpl() throws Exception {
        if (this.mWsChannelImpl == null) goto L5;
        return;
    L5:
        if (StringUtils.isEmpty(sMyselfChannelImplClass) == true) goto L7;
        Class<?> r100 = checkClass(sMyselfChannelImplClass);
    L8:
        if (r100 != null) goto L10;
        r100 = checkClass("org.chromium.wschannel.MySelfChannelImpl");
        this.mUseCronetPlugin = true;
    L10:
        if (r100 != null) goto L12;
        r100 = checkClass("com.b.c.ws.MySelfChannelImpl");
        this.mUseCronetPlugin = false;
    L12:
        if (r100 == null) goto L17;
        Object r101 = r100.newInstance();
        if ((r101 instanceof IWsChannelClient) == false) goto L19;
        this.mWsChannelImpl = (IWsChannelClient) r101;
        return;
    L19:
        return;
    L17:
        throw new ClassNotFoundException("plugin class not found");
    L7:
        r100 = null;
        goto L8
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean isConnected() {
        IWsChannelClient r100 = this.mWsChannelImpl;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.isConnected();
    }

    public boolean isOkChannelImpl() {
        return this.mWsChannelImpl instanceof OkChannelImpl;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean privateProtocolEnabled() {
        IWsChannelClient r100 = this.mWsChannelImpl;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.privateProtocolEnabled();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean privateProtocolProxyEnabled() {
        IWsChannelClient r100 = this.mWsChannelImpl;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.privateProtocolProxyEnabled();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void stopConnection() {
        IWsChannelClient r100 = this.mWsChannelImpl;
        if (r100 == null) goto L6;
        r100.stopConnection();
        return;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_common_wschannel_channel_WsChannelClient_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    private Class<?> checkClass(String r100) {
        return INVOKESTATIC_com_bytedance_common_wschannel_channel_WsChannelClient_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100);
    L4:
        return null;
    }

    private void onConnectionInternal(JSONObject r100) {
        IMessageHandler r101 = this.mMessageHandler;
        if (r101 == null) goto L6;
        r101.onConnection(this, this.mChannelId, r100);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onAppStateChanged(int r100) {
        IWsChannelClient r101 = this.mWsChannelImpl;
        if (r101 == null) goto L6;
        r101.onAppStateChanged(r100);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onConnection(JSONObject r100) {
        monitor-enter(this);
        onConnectionInternal(r100);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onMessage(WsChannelMsg r100) {
        IMessageHandler r101 = this.mMessageHandler;
        if (r101 == null) goto L6;
        r101.onMessage(this.mChannelId, r100);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onNetworkStateChanged(int r100) {
        IWsChannelClient r101 = this.mWsChannelImpl;
        if (r101 == null) goto L6;
        r101.onNetworkStateChanged(r100);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void registerService(int r100) {
        IWsChannelClient r101 = this.mWsChannelImpl;
        if (r101 == null) goto L6;
        r101.registerService(r100);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean sendMessage(WsChannelMsg r100) {
        IWsChannelClient r101 = this.mWsChannelImpl;
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.sendMessage(r100);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void unregisterService(int r100) {
        IWsChannelClient r101 = this.mWsChannelImpl;
        if (r101 == null) goto L6;
        r101.unregisterService(r100);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onMessage(byte[] r100) {
        IMessageHandler r101 = this.mMessageHandler;
        if (r101 == null) goto L6;
        r101.onMessage(this.mChannelId, r100);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean sendMessage(byte[] r100) {
        IWsChannelClient r101 = this.mWsChannelImpl;
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.sendMessage(r100);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void init(Context r100, IWsChannelClient r101) {
        IWsChannelClient r102 = this.mWsChannelImpl;
        if (r102 != null) goto L12;
        return;
    L12:
        r102.init(r100, r101);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        if ((this.mWsChannelImpl instanceof OkChannelImpl) == true) goto L10;
        th.printStackTrace();
        Logger.d("WsChannelClient", "cronet socket init failed，use okhttp to connect");
        OkChannelImpl r103 = new OkChannelImpl(this.mChannelId, this.mHandler);
        this.mWsChannelImpl = r103;
        r103.init(r100, r101);
        return;
    L10:
        throw th;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onParameterChange(Map<String, Object> r100, List<String> r101) {
        IWsChannelClient r102 = this.mWsChannelImpl;
        if (r102 == null) goto L5;
        r102.onParameterChange(r100, r101);
    L5:
        this.mUrls = r101;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void openConnection(Map<String, Object> r100, List<String> r101) {
        IWsChannelClient r102 = this.mWsChannelImpl;
        if (r102 == null) goto L5;
        r102.openConnection(r100, r101);
    L5:
        this.mUrls = r101;
    }

    private WsChannelClient(int r100, IMessageHandler r101, Handler r102) {
        this.mUseCronetPlugin = true;
        this.mChannelId = r100;
        this.mMessageHandler = r101;
        this.mHandler = r102;
        tryResolveMySelfChannelImpl();     // Catch: Throwable -> L8 ClassNotFoundException -> L10
        if (this.mUseCronetPlugin == false) goto L6;
        Logger.d("WsChannelClient", "use cronet to connect");     // Catch: Throwable -> L8 ClassNotFoundException -> L10
    L15:
    L12:
        if (this.mWsChannelImpl != null) goto L18;
        Logger.d("WsChannelClient", "use okhttp to connect");
        this.mWsChannelImpl = new OkChannelImpl(r100, r102);
        return;
    L18:
        return;
    L6:
        Logger.d("WsChannelClient", "use PushManager to connect");     // Catch: Throwable -> L8 ClassNotFoundException -> L10
    L10:
        Logger.d("WsChannelClient", "don't find plugin or plugin download failed");
    L8:
        th = move-exception;
        th.printStackTrace();
        Logger.d("WsChannelClient", "don't find plugin");
        goto L12
    }

    public static WsChannelClient newInstance(int r100, IMessageHandler r101, Handler r102) {
        return new WsChannelClient(r100, r101, r102);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onServiceConnectEvent(int r100, boolean r101, String r102) {
        IMessageHandler r103 = this.mMessageHandler;
        if (r103 == null) goto L6;
        r103.onServiceConnectEvent(new ServiceConnectEvent(this.mChannelId, r100, r101, r102));
        return;
    }
}
