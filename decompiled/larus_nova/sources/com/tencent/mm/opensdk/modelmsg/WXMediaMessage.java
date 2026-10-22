package com.tencent.mm.opensdk.modelmsg;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import el9.a;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public final class WXMediaMessage {
    public static final String ACTION_WXAPPMESSAGE = "com.tencent.mm.sdk.openapi.Intent.ACTION_WXAPPMESSAGE";
    public static final int DESCRIPTION_LENGTH_LIMIT = 1024;
    public static final int MEDIA_TAG_NAME_LENGTH_LIMIT = 64;
    public static final int MESSAGE_ACTION_LENGTH_LIMIT = 2048;
    public static final int MESSAGE_EXT_LENGTH_LIMIT = 2048;
    public static final int MINI_PROGRAM__THUMB_LENGHT = 131072;
    private static final String TAG = "MicroMsg.SDK.WXMediaMessage";
    public static final int THUMB_LENGTH_LIMIT = 65536;
    public static final int TITLE_LENGTH_LIMIT = 512;
    public String description;
    public IMediaObject mediaObject;
    public String mediaTagName;
    public String messageAction;
    public String messageExt;
    public String msgSignature;
    public int sdkVer;
    public byte[] thumbData;
    public String thumbDataHash;
    public String title;

    public static class Builder {
        public static final String KEY_IDENTIFIER = "_wxobject_identifier_";

        public Builder() {
        }

        public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
            return Class.forName(r100);
        }

        public static WXMediaMessage fromBundle(Bundle r100) {
            WXMediaMessage r101 = new WXMediaMessage();
            r101.sdkVer = r100.getInt("_wxobject_sdkVer");
            r101.title = r100.getString("_wxobject_title");
            r101.description = r100.getString("_wxobject_description");
            r101.thumbData = r100.getByteArray("_wxobject_thumbdata");
            r101.mediaTagName = r100.getString("_wxobject_mediatagname");
            r101.messageAction = r100.getString("_wxobject_message_action");
            r101.messageExt = r100.getString("_wxobject_message_ext");
            r101.msgSignature = r100.getString("_wxobject_msgsignature");
            r101.thumbDataHash = r100.getString("_wxobject_thumbdatadash");
            String r102 = pathOldToNew(r100.getString(KEY_IDENTIFIER));
            if (r102 != null) goto L5;
        L11:
            return r101;
        L5:
            if (r102.length() <= 0) goto L11;
            IMediaObject r103 = (IMediaObject) INVOKESTATIC_com_tencent_mm_opensdk_modelmsg_WXMediaMessage$Builder_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r102).newInstance();     // Catch: Exception -> L9
            r101.mediaObject = r103;     // Catch: Exception -> L9
            r103.unserialize(r100);     // Catch: Exception -> L9
            return r101;
        L9:
            e = move-exception;
            Log.e(WXMediaMessage.TAG, "get media object from bundle failed: unknown ident " + r102 + ", ex = " + e.getMessage());
            goto L11
        }

        private static String pathNewToOld(String r100) {
            if (r100 != null) goto L4;
        L8:
            Log.e(WXMediaMessage.TAG, "pathNewToOld fail, newPath is null");
            return r100;
        L4:
            if (r100.length() == 0) goto L8;
            return r100.replace("com.tencent.mm.opensdk.modelmsg", "com.tencent.mm.sdk.openapi");
        }

        private static String pathOldToNew(String r100) {
            Log.i(WXMediaMessage.TAG, "pathOldToNew, oldPath = " + r100);
            if (r100 != null) goto L5;
        L13:
            Log.e(WXMediaMessage.TAG, "pathOldToNew fail, oldPath is null");
            return r100;
        L5:
            if (r100.length() == 0) goto L13;
            int r101 = r100.lastIndexOf(46);
            if (r101 != (-1)) goto L12;
            Log.e(WXMediaMessage.TAG, "pathOldToNew fail, invalid pos, oldPath = ".concat(r100));
            return r100;
        L12:
            return "com.tencent.mm.opensdk.modelmsg" + r100.substring(r101);
        }

        public static Bundle toBundle(WXMediaMessage r100) {
            Bundle r101 = new Bundle();
            r101.putInt("_wxobject_sdkVer", r100.sdkVer);
            r101.putString("_wxobject_title", r100.title);
            r101.putString("_wxobject_description", r100.description);
            r101.putByteArray("_wxobject_thumbdata", r100.thumbData);
            IMediaObject r102 = r100.mediaObject;
            if (r102 == null) goto L5;
            r101.putString(KEY_IDENTIFIER, pathNewToOld(r102.getClass().getName()));
            r100.mediaObject.serialize(r101);
        L5:
            r101.putString("_wxobject_mediatagname", r100.mediaTagName);
            r101.putString("_wxobject_message_action", r100.messageAction);
            r101.putString("_wxobject_message_ext", r100.messageExt);
            r101.putString("_wxobject_msgsignature", r100.msgSignature);
            r101.putString("_wxobject_thumbdatadash", r100.thumbDataHash);
            return r101;
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_com_tencent_mm_opensdk_modelmsg_WXMediaMessage$Builder_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public interface IMediaObject {
        public static final int TYPE_APPBRAND = 33;
        public static final int TYPE_APPDATA = 7;
        public static final int TYPE_BUSINESS_CARD = 45;
        public static final int TYPE_CARD_SHARE = 16;
        public static final int TYPE_DESIGNER_SHARED = 25;
        public static final int TYPE_DEVICE_ACCESS = 12;
        public static final int TYPE_EMOJI = 8;
        public static final int TYPE_EMOJILIST_SHARED = 27;
        public static final int TYPE_EMOTICON_GIFT = 11;
        public static final int TYPE_EMOTICON_SHARED = 15;
        public static final int TYPE_EMOTIONLIST_SHARED = 26;
        public static final int TYPE_FILE = 6;
        public static final int TYPE_GAME_LIVE = 70;
        public static final int TYPE_GAME_VIDEO_FILE = 39;
        public static final int TYPE_GIFTCARD = 34;
        public static final int TYPE_IMAGE = 2;
        public static final int TYPE_LOCATION = 30;
        public static final int TYPE_LOCATION_SHARE = 17;
        public static final int TYPE_MALL_PRODUCT = 13;
        public static final int TYPE_MUSIC = 3;
        public static final int TYPE_MUSIC_VIDEO = 76;
        public static final int TYPE_NOTE = 24;
        public static final int TYPE_OLD_TV = 14;
        public static final int TYPE_OPENSDK_APPBRAND = 36;
        public static final int TYPE_OPENSDK_APPBRAND_WEISHIVIDEO = 46;
        public static final int TYPE_OPENSDK_LITEAPP = 68;
        public static final int TYPE_OPENSDK_WEWORK_OBJECT = 49;
        public static final int TYPE_PRODUCT = 10;
        public static final int TYPE_RECORD = 19;
        public static final int TYPE_TEXT = 1;
        public static final int TYPE_TV = 20;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_URL = 5;
        public static final int TYPE_VIDEO = 4;
        public static final int TYPE_VIDEO_FILE = 38;

        boolean checkArgs();

        void serialize(Bundle r100);

        int type();

        void unserialize(Bundle r100);
    }

    public WXMediaMessage() {
        this(null);
    }

    public WXMediaMessage(IMediaObject r100) {
        this.mediaObject = r100;
    }

    public boolean checkArgs() {
        if (getType() != 8) goto L12;
        byte[] r100 = this.thumbData;
        if (r100 != null) goto L7;
    L8:
        String r101 = "checkArgs fail, thumbData should not be null when send emoji";
    L9:
        Log.e(TAG, r101);
        return false;
    L7:
        if (r100.length == 0) goto L8;
    L12:
        if (getType() != 76) goto L17;
        if (b.b(this.title) == false) goto L17;
        r101 = "checkArgs fail, Type = Music Video, but title == null";
    L17:
        if (b.a(getType()) == false) goto L24;
        byte[] r102 = this.thumbData;
        if (r102 != null) goto L21;
    L22:
        r101 = "checkArgs fail, thumbData should not be null or exceed 128kb";
        goto L9
    L21:
        if (r102.length > 131072) goto L22;
    L24:
        if (b.a(getType()) == true) goto L30;
        byte[] r103 = this.thumbData;
        if (r103 == null) goto L30;
        if (r103.length <= 65536) goto L30;
        r101 = "checkArgs fail, thumbData is invalid";
    L30:
        String r104 = this.title;
        if (r104 != null) goto L33;
    L35:
        String r105 = this.description;
        if (r105 == null) goto L41;
        if (r105.length() <= 1024) goto L41;
        r101 = "checkArgs fail, description is invalid";
    L41:
        if (this.mediaObject != null) goto L43;
        r101 = "checkArgs fail, mediaObject is null";
        goto L9
    L43:
        String r106 = this.mediaTagName;
        if (r106 != null) goto L46;
    L48:
        String r107 = this.messageAction;
        if (r107 != null) goto L51;
    L53:
        String r108 = this.messageExt;
        if (r108 == null) goto L59;
        if (r108.length() <= 2048) goto L59;
        r101 = "checkArgs fail, messageExt is too long";
    L59:
        return this.mediaObject.checkArgs();
    L51:
        if (r107.length() <= 2048) goto L53;
        r101 = "checkArgs fail, messageAction is too long";
        goto L9
    L46:
        if (r106.length() <= 64) goto L48;
        r101 = "checkArgs fail, mediaTagName is too long";
        goto L9
    L33:
        if (r104.length() <= 512) goto L35;
        r101 = "checkArgs fail, title is invalid";
        goto L9
    }

    public int getType() {
        IMediaObject r100 = this.mediaObject;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.type();
    }

    public void setThumbImage(Bitmap r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();     // Catch: Exception -> L4
        r100.compress(Bitmap.CompressFormat.JPEG, 85, r101);     // Catch: Exception -> L4
        this.thumbData = r101.toByteArray();     // Catch: Exception -> L4
        r101.close();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e(TAG, "setThumbImage exception:" + e.getMessage());
    }
}
