package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

/* JADX INFO: loaded from: classes40.dex */
public class WXEmojiObject implements WXMediaMessage.IMediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 10485760;
    private static final String TAG = "MicroMsg.SDK.WXEmojiObject";
    public byte[] emojiData;
    public String emojiPath;

    public WXEmojiObject() {
        this.emojiData = null;
        this.emojiPath = null;
    }

    public WXEmojiObject(String r100) {
        this.emojiPath = r100;
    }

    public WXEmojiObject(byte[] r100) {
        this.emojiData = r100;
    }

    private int getFileSize(String r100) {
        return b.a(r100);
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        byte[] r100 = this.emojiData;
        if (r100 != null) goto L5;
    L6:
        String r101 = this.emojiPath;
        if (r101 != null) goto L9;
    L25:
        String r102 = "checkArgs fail, both arguments is null";
    L16:
        Log.e(TAG, r102);
        return false;
    L9:
        if (r101.length() == 0) goto L25;
    L11:
        byte[] r103 = this.emojiData;
        if (r103 != null) goto L14;
    L18:
        String r104 = this.emojiPath;
        if (r104 != null) goto L21;
        return true;
    L21:
        if (getFileSize(r104) <= 10485760) goto L26;
        r102 = "checkArgs fail, emojiSize is too large";
        goto L16
    L26:
        return true;
    L14:
        if (r103.length <= 10485760) goto L18;
        r102 = "checkArgs fail, emojiData is too large";
        goto L16
    L5:
        if (r100.length != 0) goto L11;
        goto L6
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle r100) {
        r100.putByteArray("_wxemojiobject_emojiData", this.emojiData);
        r100.putString("_wxemojiobject_emojiPath", this.emojiPath);
    }

    public void setEmojiData(byte[] r100) {
        this.emojiData = r100;
    }

    public void setEmojiPath(String r100) {
        this.emojiPath = r100;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 8;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle r100) {
        this.emojiData = r100.getByteArray("_wxemojiobject_emojiData");
        this.emojiPath = r100.getString("_wxemojiobject_emojiPath");
    }
}
