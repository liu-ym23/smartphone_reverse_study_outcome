package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.tencent.mm.opensdk.utils.Log;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public class WXStateSceneDataObject implements SendMessageToWX.IWXSceneDataObject {
    private static final int LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXStateSceneDataObject";
    private static final String WX_STATE_JUMP_INFO_KEY_IDENTIFIER = "_wxapi_scene_data_state_jump_info_identifier";
    public String stateId;
    public IWXStateJumpInfo stateJumpInfo;
    public String stateTitle;
    public String token;

    public interface IWXStateJumpInfo {
        public static final int WX_STATE_JUMP_TYPE_CHANNEL_PROFILE = 3;
        public static final int WX_STATE_JUMP_TYPE_MINI_PROGRAM = 2;
        public static final int WX_STATE_JUMP_TYPE_UNKNOWN = 0;
        public static final int WX_STATE_JUMP_TYPE_URL = 1;

        boolean checkArgs();

        void serialize(Bundle r100);

        int type();

        void unserialize(Bundle r100);
    }

    public WXStateSceneDataObject() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.SendMessageToWX.IWXSceneDataObject
    public boolean checkArgs() {
        String r100 = this.stateId;
        if (r100 != null) goto L5;
    L8:
        String r101 = this.stateTitle;
        if (r101 != null) goto L11;
    L14:
        String r102 = this.token;
        if (r102 != null) goto L17;
    L20:
        IWXStateJumpInfo r103 = this.stateJumpInfo;
        if (r103 != null) goto L25;
        Log.e(TAG, "checkArgs fail, statsJumpInfo is null");
        return false;
    L25:
        return r103.checkArgs();
    L17:
        if (r102.length() <= 10240) goto L20;
        Log.e(TAG, "checkArgs fail, stateId is invalid");
        return false;
    L11:
        if (r101.length() <= 10240) goto L14;
        Log.e(TAG, "checkArgs fail, stateId is invalid");
        return false;
    L5:
        if (r100.length() <= 10240) goto L8;
        Log.e(TAG, "checkArgs fail, stateId is invalid");
        return false;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.SendMessageToWX.IWXSceneDataObject
    public int getJumpType() {
        IWXStateJumpInfo r100 = this.stateJumpInfo;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.type();
    }

    @Override // com.tencent.mm.opensdk.modelmsg.SendMessageToWX.IWXSceneDataObject
    public void serialize(Bundle r100) {
        r100.putString("_wxapi_scene_data_state_id", this.stateId);
        r100.putString("_wxapi_scene_data_state_title", this.stateTitle);
        r100.putString("_wxapi_scene_data_state_token", this.token);
        IWXStateJumpInfo r101 = this.stateJumpInfo;
        if (r101 == null) goto L6;
        r100.putString(WX_STATE_JUMP_INFO_KEY_IDENTIFIER, r101.getClass().getName());
        this.stateJumpInfo.serialize(r100);
        return;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.SendMessageToWX.IWXSceneDataObject
    public void unserialize(Bundle r100) {
        this.stateId = r100.getString("_wxapi_scene_data_state_id");
        this.stateTitle = r100.getString("_wxapi_scene_data_state_title");
        this.token = r100.getString("_wxapi_scene_data_state_token");
        String r101 = r100.getString(WX_STATE_JUMP_INFO_KEY_IDENTIFIER);
        if (r101 == null) goto L11;
        IWXStateJumpInfo r102 = (IWXStateJumpInfo) INVOKESTATIC_com_tencent_mm_opensdk_modelmsg_WXStateSceneDataObject_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r101).newInstance();     // Catch: Exception -> L6
        this.stateJumpInfo = r102;     // Catch: Exception -> L6
        r102.unserialize(r100);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        Log.e(TAG, "get WXSceneDataObject from bundle failed: unknown ident " + r101 + ", ex = " + e.getMessage());
        return;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_tencent_mm_opensdk_modelmsg_WXStateSceneDataObject_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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
}
