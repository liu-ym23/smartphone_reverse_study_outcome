package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.common.wschannel.utils.WsAsyncIOTaskManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class FrontierMessageManager {
    private static final String TAG = null;
    private static Context sContext;
    private static volatile FrontierPersistentBuffer sFrontierPersistentBuffer;
    private static final AtomicBoolean sLazyInitFinished = null;
    private static CountDownLatch sQoSInitFinishedCountDown;
    private static volatile boolean sQos2Enabled;
    private static Object sTTNetInitInstance;

    public FrontierMessageManager() {
    }

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        sLazyInitFinished = new AtomicBoolean(false);
        sQoSInitFinishedCountDown = new CountDownLatch(1);
        TAG = "FrontierMessageManager";
    }

    private static void initTTNetInitInstance() {
        if (sTTNetInitInstance == null) goto L12;
        return;
    L12:
        sTTNetInitInstance = INVOKESTATIC_com_bytedance_common_wschannel_server_FrontierMessageManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.ttnet.TTNetInit").newInstance();     // Catch: Throwable -> L9
        if (Logger.debug() == false) goto L14;
        Logger.d(TAG, "Get TTNetInit instance success.");     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L9:
        th = move-exception;
        Logger.e(TAG, "Get TTNetInit instance failed.");
        th.printStackTrace();
    }

    public static void setPersistentBufferInitFinished() {
        sLazyInitFinished.set(true);
        sQoSInitFinishedCountDown.countDown();
    }

    private static void tryWaitPersistentBufferInit() {
        if (sLazyInitFinished.get() == true) goto L11;
        sQoSInitFinishedCountDown.await(3000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L8
        if (sQoSInitFinishedCountDown.getCount() != 1) goto L12;
        sQoSInitFinishedCountDown.countDown();     // Catch: Exception -> L8
        return;
    L12:
        return;
    L13:
        return;
    }

    public static /* synthetic */ FrontierPersistentBuffer access$000() {
        return sFrontierPersistentBuffer;
    }

    public static /* synthetic */ Context access$100() {
        return sContext;
    }

    public static boolean isQos2Enabled() {
        return sQos2Enabled;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_common_wschannel_server_FrontierMessageManager_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$001(r100);     // Catch: Throwable -> L8
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
        Class r104 = access$001(r100);     // Catch: Throwable -> L17
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

    public static /* synthetic */ FrontierPersistentBuffer access$002(FrontierPersistentBuffer r100) {
        sFrontierPersistentBuffer = r100;
        return r100;
    }

    private static Map<String, String> covertMsgHeadersToMap(List<WsChannelMsg.MsgHeader> r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.isEmpty() == true) goto L24;
        HashMap r101 = new HashMap();
        Iterator<WsChannelMsg.MsgHeader> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L14;
        WsChannelMsg.MsgHeader r103 = r102.next();
        if (TextUtils.isEmpty(r103.getKey()) == true) goto L8;
        if (TextUtils.isEmpty(r103.getValue()) == true) goto L8;
        r101.put(r103.getKey(), r103.getValue());
        goto L8
    L14:
        return r101;
    L24:
        return null;
    }

    private static String[] getAckMsgIdFromCurrentMessage(Map<String, String> r100) {
        if (r100.containsKey("x_frontier_is_ack") == true) goto L5;
    L15:
        return null;
    L5:
        if (r100.containsKey("x_frontier_ack_msgid") == false) goto L15;
        if (r100.get("x_frontier_is_ack").equals("1") == true) goto L11;
        return null;
    L11:
        if (TextUtils.isEmpty(r100.get("x_frontier_ack_msgid")) == false) goto L14;
        return null;
    L14:
        return r100.get("x_frontier_ack_msgid").split(",");
    }

    private static boolean isFrontierMsgHeader(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if (r100.equals("x_frontier_qos") == false) goto L8;
    L15:
        return true;
    L8:
        if (r100.equals(WsConstants.KEY_FRONTIER_MSGID) == true) goto L15;
        if (r100.equals("x_frontier_ttl") == true) goto L15;
        if (r100.equals("x_frontier_ack_msgid") == true) goto L15;
        if (r100.equals("x_frontier_is_ack") == true) goto L15;
        return false;
    }

    private static boolean isValidAckMsgHeader(Map<String, String> r100) {
        if (r100.containsKey("x_frontier_qos") == true) goto L5;
    L31:
        return false;
    L5:
        if (r100.containsKey("x_frontier_qos_ack") == false) goto L31;
        if (r100.containsKey("x_frontier_is_ack") == false) goto L31;
        if (r100.containsKey("x_frontier_ack_msgid") == false) goto L31;
        if (r100.get("x_frontier_qos") == null) goto L31;
        if (r100.get("x_frontier_qos").equals("2") == false) goto L31;
        if (r100.get("x_frontier_qos_ack") == null) goto L31;
        if (r100.get("x_frontier_qos_ack").equals("1") == false) goto L31;
        if (r100.get("x_frontier_is_ack") == null) goto L31;
        if (r100.get("x_frontier_is_ack").equals("1") == false) goto L31;
        if (TextUtils.isEmpty(r100.get("x_frontier_ack_msgid")) == false) goto L29;
        return false;
    L29:
        return true;
    }

    private static boolean isValidMsgHeader(Map<String, String> r100) {
        if (r100.containsKey("x_frontier_qos") == true) goto L5;
    L26:
        return false;
    L5:
        if (r100.containsKey(WsConstants.KEY_FRONTIER_MSGID) == false) goto L26;
        if (r100.containsKey("x_frontier_ttl") == false) goto L26;
        if (r100.get("x_frontier_qos") == null) goto L26;
        if (r100.get("x_frontier_qos").equals("2") == false) goto L26;
        String r101 = r100.get(WsConstants.KEY_FRONTIER_MSGID);
        if (TextUtils.isEmpty(r101) == true) goto L26;
        if (r101.getBytes("UTF-8").length != 32) goto L26;
        if (CastLongProtector.valueOf(r100.get("x_frontier_ttl")).longValue() > 0) goto L24;
        return false;
    L24:
        return true;
    }

    private static void removeFrontierHeaderForWsMsg(WsChannelMsg r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getMsgHeaders() == null) goto L20;
        Iterator<WsChannelMsg.MsgHeader> r101 = r100.getMsgHeaders().iterator();
        if (r101 != null) goto L10;
        return;
    L10:
        if (r101.hasNext() == false) goto L21;
        if (isFrontierMsgHeader(r101.next().getKey()) == false) goto L10;
        r101.remove();
        goto L10
    L21:
        return;
    }

    public static void reportFrontierMessageLog(JSONObject r100) {
        Object r101 = sTTNetInitInstance;     // Catch: Throwable -> L6
        if (r101 == null) goto L9;
        Reflect.on(r101).call("monitorLogSend", new Class[]{String.class, JSONObject.class}, new Object[]{"frontier_qos2", r100});     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public static boolean shouldDropMessageByFilter(WsChannelMsg r100) {
        if (sQos2Enabled == true) goto L35;
        return false;
    L35:
        Map<String, String> r101 = covertMsgHeadersToMap(r100.getMsgHeaders());     // Catch: Throwable -> L32
        if (r101 != null) goto L8;
    L31:
        return false;
    L8:
        if (r101.isEmpty() == true) goto L31;
        boolean r102 = isValidAckMsgHeader(r101);     // Catch: Throwable -> L32
        boolean r103 = isValidMsgHeader(r101);     // Catch: Throwable -> L32
        if (r102 == true) goto L14;
        if (r103 == true) goto L14;
        return false;
    L14:
        AtomicBoolean r104 = sLazyInitFinished;     // Catch: Throwable -> L32
        if (r104.get() == true) goto L18;
        initTTNetInitInstance();     // Catch: Throwable -> L32
        WsAsyncIOTaskManager.getInstance().postTask(new AnonymousClass1());     // Catch: Throwable -> L32
        tryWaitPersistentBufferInit();     // Catch: Throwable -> L32
    L18:
        if (r104.get() == true) goto L21;
        return false;
    L21:
        if (sFrontierPersistentBuffer != null) goto L24;
        return false;
    L24:
        if (Logger.debug() == false) goto L26;
        Logger.d(TAG, "origin wschannel msg:" + r100.toString());     // Catch: Throwable -> L32
    L26:
        if (r102 == false) goto L29;
        sFrontierPersistentBuffer.ackMessage(r101.get("x_frontier_ack_msgid").split(","));     // Catch: Throwable -> L32
        return true;
    L29:
        sFrontierPersistentBuffer.ackMessage(getAckMsgIdFromCurrentMessage(r101));     // Catch: Throwable -> L32
        removeFrontierHeaderForWsMsg(r100);     // Catch: Throwable -> L32
        return sFrontierPersistentBuffer.shouldDropMessageAndUpdateFile(r101.get(WsConstants.KEY_FRONTIER_MSGID), CastLongProtector.valueOf(r101.get("x_frontier_ttl")).longValue());
    L32:
        th = move-exception;
        th.printStackTrace();
        return false;
    }
}
