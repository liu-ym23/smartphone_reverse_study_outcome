package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public class SendMessageToWX {

    public interface IWXMusicVipObject {
        boolean checkArgs();

        void serialize(Bundle r100);

        void unserialize(Bundle r100);
    }

    public interface IWXSceneDataObject {
        boolean checkArgs();

        int getJumpType();

        void serialize(Bundle r100);

        void unserialize(Bundle r100);
    }

    public static class Req extends BaseReq {
        private static final int FAV_CONTENT_LENGTH_LIMIT = 26214400;
        private static final String SCENE_DATA_OBJECT_KEY_IDENTIFIER = "_scene_data_object_identifier";
        private static final String TAG = "MicroMsg.SDK.SendMessageToWX.Req";
        public static final int WXSceneFavorite = 2;
        public static final int WXSceneSession = 0;
        public static final int WXSceneSpecifiedContact = 3;
        public static final int WXSceneStatus = 4;
        public static final int WXSceneTimeline = 1;
        public WXMediaMessage message;
        public int scene;
        public IWXSceneDataObject sceneDataObject;
        public String userOpenId;

        public Req() {
        }

        public Req(Bundle r100) {
            fromBundle(r100);
        }

        public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
            return Class.forName(r100);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            WXMediaMessage r100 = this.message;
            if (r100 != null) goto L8;
            String r101 = "checkArgs fail ,message is null";
        L5:
            Log.e(TAG, r101);
            return false;
        L8:
            if (r100.mediaObject.type() == 6) goto L10;
        L12:
            int r102 = this.scene;
            if (r102 == 3) goto L15;
        L17:
            if (r102 != 3) goto L22;
            if (this.openId != null) goto L22;
            r101 = "Send specifiedContact openid can not be null.";
        L22:
            if (r102 != 4) goto L37;
            if (this.sceneDataObject != null) goto L27;
            r101 = "checkArgs fail, sceneDataObject is null";
            goto L5
        L27:
            if (this.message.getType() != 1) goto L31;
            return this.sceneDataObject.checkArgs();
        L31:
            if (this.message.checkArgs() == true) goto L33;
            return false;
        L33:
            if (this.sceneDataObject.checkArgs() == false) goto L39;
            return true;
        L39:
            return false;
        L37:
            return this.message.checkArgs();
        L15:
            if (this.userOpenId != null) goto L17;
            r101 = "Send specifiedContact userOpenId can not be null.";
            goto L5
        L10:
            if (this.scene != 2) goto L12;
            ((WXFileObject) this.message.mediaObject).setContentLengthLimit(FAV_CONTENT_LENGTH_LIMIT);
            goto L12
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle r100) {
            super.fromBundle(r100);
            this.message = WXMediaMessage.Builder.fromBundle(r100);
            this.scene = r100.getInt("_wxapi_sendmessagetowx_req_scene");
            this.userOpenId = r100.getString("_wxapi_sendmessagetowx_req_use_open_id");
            String r101 = r100.getString(SCENE_DATA_OBJECT_KEY_IDENTIFIER);
            if (r101 == null) goto L11;
            IWXSceneDataObject r102 = (IWXSceneDataObject) INVOKESTATIC_com_tencent_mm_opensdk_modelmsg_SendMessageToWX$Req_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r101).newInstance();     // Catch: Exception -> L6
            this.sceneDataObject = r102;     // Catch: Exception -> L6
            r102.unserialize(r100);     // Catch: Exception -> L6
            return;
        L6:
            e = move-exception;
            Log.e(TAG, "get WXSceneDataObject from bundle failed: unknown ident " + r101 + ", ex = " + e.getMessage());
            return;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 2;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            r100.putAll(WXMediaMessage.Builder.toBundle(this.message));
            r100.putInt("_wxapi_sendmessagetowx_req_scene", this.scene);
            r100.putInt("_wxapi_sendmessagetowx_req_media_type", this.message.getType());
            r100.putString("_wxapi_sendmessagetowx_req_use_open_id", this.userOpenId);
            IWXSceneDataObject r101 = this.sceneDataObject;
            if (r101 == null) goto L6;
            r100.putString(SCENE_DATA_OBJECT_KEY_IDENTIFIER, r101.getClass().getName());
            this.sceneDataObject.serialize(r100);
            return;
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_com_tencent_mm_opensdk_modelmsg_SendMessageToWX$Req_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static class Resp extends BaseResp {
        public Resp() {
        }

        public Resp(Bundle r100) {
            fromBundle(r100);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle r100) {
            super.fromBundle(r100);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 2;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
        }
    }

    private SendMessageToWX() {
    }
}
