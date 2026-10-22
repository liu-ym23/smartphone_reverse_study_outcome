package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public class WXChannelShareVideo {

    public static class Req extends BaseReq {
        private static final int LENGTH_LIMIT = 1024;
        private static final String TAG = "MicroMsg.SDK.WXChannelShareVideo.Req";
        private static final String WX_CHANNEL_SHARE_VIDEO_JUMP_INFO_KEY_IDENTIFIER = "_wxapi_channel_share_video_jump_info_identifier";
        public String extData;
        public IWXChannelJumpInfo jumpInfo;
        public String videoPath;

        public Req() {
        }

        public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
            return Class.forName(r100);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            if (b.b(this.videoPath) == false) goto L7;
            String r100 = "videoPath is null";
        L5:
            Log.e(TAG, r100);
            return false;
        L7:
            IWXChannelJumpInfo r101 = this.jumpInfo;
            if (r101 != null) goto L10;
            return true;
        L10:
            if (r101.checkArgs() == true) goto L14;
            r100 = "checkArgs fail, jumpInfo is invalid";
            goto L5
        L14:
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle r100) {
            super.fromBundle(r100);
            this.videoPath = r100.getString("_wxapi_finder_share_video_path");
            this.extData = r100.getString("_wxapi_finder_share_video_extData");
            String r101 = r100.getString(WX_CHANNEL_SHARE_VIDEO_JUMP_INFO_KEY_IDENTIFIER);
            if (r101 == null) goto L11;
            IWXChannelJumpInfo r102 = (IWXChannelJumpInfo) INVOKESTATIC_com_tencent_mm_opensdk_modelbiz_WXChannelShareVideo$Req_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r101).newInstance();     // Catch: Exception -> L6
            this.jumpInfo = r102;     // Catch: Exception -> L6
            r102.unserialize(r100);     // Catch: Exception -> L6
            return;
        L6:
            e = move-exception;
            Log.e(TAG, "get WXChannelJumpInfo from bundle failed: unknown ident " + r101 + ", ex = " + e.getMessage());
            return;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 33;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            r100.putString("_wxapi_finder_share_video_path", this.videoPath);
            r100.putString("_wxapi_finder_share_video_extData", this.extData);
            IWXChannelJumpInfo r101 = this.jumpInfo;
            if (r101 == null) goto L6;
            r100.putString(WX_CHANNEL_SHARE_VIDEO_JUMP_INFO_KEY_IDENTIFIER, r101.getClass().getName());
            this.jumpInfo.serialize(r100);
            return;
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_com_tencent_mm_opensdk_modelbiz_WXChannelShareVideo$Req_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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
        public String extMsg;

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
            this.extMsg = r100.getString("_wxapi_finder_extMsg");
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 33;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle r100) {
            super.toBundle(r100);
            r100.putString("_wxapi_finder_extMsg", this.extMsg);
        }
    }

    public WXChannelShareVideo() {
    }
}
