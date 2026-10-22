package com.larus.bmhome.music.protocol;

import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.block.MusicCreationContent;

/* JADX INFO: loaded from: classes26.dex */
public final class f extends MusicCreationContent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient String f313055a;

    public f() {
        this.f313055a = "";
    }

    public f(String r100, String r101, String r102, Image r103, String r104, String r105, String r106, String r107, String r110) {
        this.f313055a = "";
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        setVideoModel(r100);
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        setTitle(r101);
        if (r102 != null) goto L11;
        r102 = "";
    L11:
        setLyrics(r102);
        setCover(r103);
        if (r104 != null) goto L14;
        r104 = "";
    L14:
        setShareInfo(r104);
        if (r105 != null) goto L17;
        r105 = "";
    L17:
        setCoverMainColor(r105);
        if (r106 != null) goto L20;
        r106 = "";
    L20:
        setVid(r106);
        if (r107 != null) goto L23;
        r107 = "";
    L23:
        setLyricsSeekContent(r107);
        setContentType(2);
        this.f313055a = r110;
    }
}
