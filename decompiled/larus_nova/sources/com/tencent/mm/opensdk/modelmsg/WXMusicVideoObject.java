package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public class WXMusicVideoObject implements WXMediaMessage.IMediaObject {
    private static final int HD_ALBUM_FILE_LENGTH = 10485760;
    private static final int LYRIC_LENGTH_LIMIT = 32768;
    private static final int STRING_LIMIT = 1024;
    private static final String TAG = "MicroMsg.SDK.WXMusicVideoObject";
    private static final int URL_LENGTH_LIMIT = 10240;
    public String albumName;
    public int duration;
    public String hdAlbumThumbFileHash;
    public String hdAlbumThumbFilePath;
    public String identification;
    public long issueDate;
    public String musicDataUrl;
    public String musicGenre;
    public String musicOperationUrl;
    public String musicUrl;
    public WXMusicVipInfo musicVipInfo;
    public String singerName;
    public String songLyric;

    public WXMusicVideoObject() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private int getFileSize(String r100) {
        return b.a(r100);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        if (b.b(this.musicUrl) == false) goto L5;
    L53:
        String r100 = "musicUrl.length exceeds the limit";
    L22:
        Log.e(TAG, r100);
        return false;
    L5:
        if (this.musicUrl.length() > 10240) goto L53;
        if (b.b(this.musicDataUrl) == false) goto L10;
    L52:
        r100 = "musicDataUrl.length exceeds the limit";
        goto L22
    L10:
        if (this.musicDataUrl.length() > 10240) goto L52;
        if (b.b(this.singerName) == false) goto L15;
    L51:
        r100 = "singerName.length exceeds the limit";
        goto L22
    L15:
        if (this.singerName.length() > 1024) goto L51;
        if (b.b(this.songLyric) == true) goto L25;
        if (this.songLyric.length() <= 32768) goto L25;
        r100 = "songLyric.length exceeds the limit";
    L25:
        if (b.b(this.hdAlbumThumbFilePath) == true) goto L30;
        if (this.hdAlbumThumbFilePath.length() <= 1024) goto L30;
        r100 = "hdAlbumThumbFilePath.length exceeds the limit";
    L30:
        if (b.b(this.hdAlbumThumbFilePath) == true) goto L35;
        if (getFileSize(this.hdAlbumThumbFilePath) <= 10485760) goto L35;
        r100 = "hdAlbumThumbFilePath file length exceeds the limit";
    L35:
        if (b.b(this.musicGenre) == true) goto L40;
        if (this.musicGenre.length() <= 1024) goto L40;
        r100 = "musicGenre.length exceeds the limit";
    L40:
        if (b.b(this.identification) == true) goto L45;
        if (this.identification.length() <= 1024) goto L45;
        r100 = "identification.length exceeds the limit";
    L45:
        if (b.b(this.musicOperationUrl) == false) goto L47;
        return true;
    L47:
        if (this.musicOperationUrl.length() <= 10240) goto L54;
        r100 = "musicOperationUrl.length exceeds the limit";
        goto L22
    L54:
        return true;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle r100) {
        r100.putString("_wxmusicvideoobject_musicUrl", this.musicUrl);
        r100.putString("_wxmusicvideoobject_musicDataUrl", this.musicDataUrl);
        r100.putString("_wxmusicvideoobject_singerName", this.singerName);
        r100.putString("_wxmusicvideoobject_songLyric", this.songLyric);
        r100.putString("_wxmusicvideoobject_hdAlbumThumbFilePath", this.hdAlbumThumbFilePath);
        r100.putString("_wxmusicvideoobject_albumName", this.albumName);
        r100.putString("_wxmusicvideoobject_musicGenre", this.musicGenre);
        r100.putLong("_wxmusicvideoobject_issueDate", this.issueDate);
        r100.putString("_wxmusicvideoobject_identification", this.identification);
        r100.putInt("_wxmusicvideoobject_duration", this.duration);
        r100.putString("_wxmusicvideoobject_musicOperationUrl", this.musicOperationUrl);
        WXMusicVipInfo r101 = this.musicVipInfo;
        if (r101 == null) goto L5;
        r100.putString("_wxmusicvideoobject_musicVipInfo", r101.getClass().getName());
        this.musicVipInfo.serialize(r100);
    L5:
        r100.putString("_wxmusicvideoobject_hdAlbumThumbFileHash", this.hdAlbumThumbFileHash);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 76;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle r100) {
        this.musicUrl = r100.getString("_wxmusicvideoobject_musicUrl");
        this.musicDataUrl = r100.getString("_wxmusicvideoobject_musicDataUrl");
        this.singerName = r100.getString("_wxmusicvideoobject_singerName");
        this.songLyric = r100.getString("_wxmusicvideoobject_songLyric");
        this.hdAlbumThumbFilePath = r100.getString("_wxmusicvideoobject_hdAlbumThumbFilePath");
        this.albumName = r100.getString("_wxmusicvideoobject_albumName");
        this.musicGenre = r100.getString("_wxmusicvideoobject_musicGenre");
        this.issueDate = r100.getLong("_wxmusicvideoobject_issueDate", 0);
        this.identification = r100.getString("_wxmusicvideoobject_identification");
        this.duration = r100.getInt("_wxmusicvideoobject_duration", 0);
        this.musicOperationUrl = r100.getString("_wxmusicvideoobject_musicOperationUrl");
        String r101 = r100.getString("_wxmusicvideoobject_musicVipInfo");
        if (r101 != null) goto L10;
    L8:
        this.hdAlbumThumbFileHash = r100.getString("_wxmusicvideoobject_hdAlbumThumbFileHash");
        return;
    L10:
        WXMusicVipInfo r102 = (WXMusicVipInfo) INVOKESTATIC_com_tencent_mm_opensdk_modelmsg_WXMusicVideoObject_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r101).newInstance();     // Catch: Exception -> L6
        this.musicVipInfo = r102;     // Catch: Exception -> L6
        r102.unserialize(r100);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        Log.e(TAG, "get WXSceneDataObject from bundle failed: unknown vipInfoObjectStr " + r101 + ", ex = " + e.getMessage());
        goto L8
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_tencent_mm_opensdk_modelmsg_WXMusicVideoObject_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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
