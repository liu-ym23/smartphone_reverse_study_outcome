package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;

/* JADX INFO: loaded from: classes40.dex */
public class WXMusicObject implements WXMediaMessage.IMediaObject {
    private static final int LENGTH_LIMIT = 10240;
    private static final int LYRIC_LENGTH_LIMIT = 32768;
    private static final String TAG = "MicroMsg.SDK.WXMusicObject";
    public String musicDataUrl;
    public String musicLowBandDataUrl;
    public String musicLowBandUrl;
    public String musicUrl;
    public String songAlbumUrl;
    public String songLyric;

    public WXMusicObject() {
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        String r100 = this.musicUrl;
        if (r100 != null) goto L5;
    L6:
        String r101 = this.musicLowBandUrl;
        if (r101 != null) goto L9;
    L35:
        String r102 = "both arguments are null";
    L16:
        Log.e(TAG, r102);
        return false;
    L9:
        if (r101.length() == 0) goto L35;
    L11:
        String r103 = this.musicUrl;
        if (r103 != null) goto L14;
    L18:
        String r104 = this.musicLowBandUrl;
        if (r104 != null) goto L21;
    L23:
        String r105 = this.songAlbumUrl;
        if (r105 != null) goto L26;
    L28:
        String r106 = this.songLyric;
        if (r106 != null) goto L31;
        return true;
    L31:
        if (r106.length() <= 32768) goto L36;
        r102 = "checkArgs fail, songLyric is too long";
        goto L16
    L36:
        return true;
    L26:
        if (r105.length() <= 10240) goto L28;
        r102 = "checkArgs fail, songAlbumUrl is too long";
        goto L16
    L21:
        if (r104.length() <= 10240) goto L23;
        r102 = "checkArgs fail, musicLowBandUrl is too long";
        goto L16
    L14:
        if (r103.length() <= 10240) goto L18;
        r102 = "checkArgs fail, musicUrl is too long";
        goto L16
    L5:
        if (r100.length() != 0) goto L11;
        goto L6
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle r100) {
        r100.putString("_wxmusicobject_musicUrl", this.musicUrl);
        r100.putString("_wxmusicobject_musicLowBandUrl", this.musicLowBandUrl);
        r100.putString("_wxmusicobject_musicDataUrl", this.musicDataUrl);
        r100.putString("_wxmusicobject_musicLowBandDataUrl", this.musicLowBandDataUrl);
        r100.putString("_wxmusicobject_musicAlbumUrl", this.songAlbumUrl);
        r100.putString("_wxmusicobject_musicLyric", this.songLyric);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 3;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle r100) {
        this.musicUrl = r100.getString("_wxmusicobject_musicUrl");
        this.musicLowBandUrl = r100.getString("_wxmusicobject_musicLowBandUrl");
        this.musicDataUrl = r100.getString("_wxmusicobject_musicDataUrl");
        this.musicLowBandDataUrl = r100.getString("_wxmusicobject_musicLowBandDataUrl");
        this.songAlbumUrl = r100.getString("_wxmusicobject_musicAlbumUrl");
        this.songLyric = r100.getString("_wxmusicobject_musicLyric");
    }
}
