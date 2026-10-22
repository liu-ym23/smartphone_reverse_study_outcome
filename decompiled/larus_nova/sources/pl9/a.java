package pl9;

import com.larus.music.qq.data.QQMusicAlbum;
import com.tencent.qqmusic.third.api.contract.Data;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {
    public static final QQMusicAlbum a(Data.Album r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = String.valueOf(r100.getId());     // Catch: Exception -> L5
    L7:
        return new QQMusicAlbum(r100.getCoverUri(), r101, r100.getMid(), r100.getTitle());
    L5:
        r101 = "";
        goto L7
    }
}
