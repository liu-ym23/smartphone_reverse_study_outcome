package pl9;

import com.larus.music.qq.data.QQMusicAlbum;
import com.larus.music.qq.data.QQMusicSinger;
import com.larus.music.qq.data.QQMusicSong;
import com.tencent.qqmusic.third.api.contract.Data;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c {
    public static final QQMusicSong a(Data.Song r110) {
        String r100 = "";
        Intrinsics.checkNotNullParameter(r110, "<this>");
        String r101 = r110.getId().toString();     // Catch: Exception -> L5
    L6:
        Data.Singer r102 = r110.getSinger();
        Intrinsics.checkNotNullParameter(r102, "<this>");
        r100 = String.valueOf(r102.getId());     // Catch: Exception -> L14
    L8:
        QQMusicSinger r111 = new QQMusicSinger(r100, r102.getMid(), r102.getTitle());
        QQMusicAlbum r103 = a.a(r110.getAlbum());
        int r104 = (int) r110.getDuration();
    L13:
        return new QQMusicSong(r103, Integer.valueOf(r104), r110.getGenre(), r101, r110.getLabelIdList(), r110.getMid(), r111, r110.getTitle(), Integer.valueOf(r110.getType()), Boolean.valueOf(r110.isAudition()), Boolean.valueOf(r110.isOrigin()), Integer.valueOf(r110.getVipState()), Boolean.valueOf(r110.hasCopyRight()));
    L11:
        r104 = 0;
    L5:
        r101 = "";
        goto L6
    }
}
