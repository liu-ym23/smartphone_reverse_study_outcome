package com.larus.music;

import com.larus.music.qq.data.QQMusicAlbum;
import com.larus.music.qq.data.QQPlayStatus;
import com.larus.platform.api.MusicOperateResult;
import com.larus.platform.api.QQMusicFolder;
import com.larus.platform.api.QQMusicSinger;
import com.larus.platform.api.QQMusicSong;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes30.dex */
public final class j {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f359476a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f359477b = null;

        static {
            int[] r100 = new int[CommonOperateResult.values().length];
            r100[CommonOperateResult.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L20:
            r100[CommonOperateResult.REJECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L26:
            r100[CommonOperateResult.CANCEL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            f359476a = r100;
            int[] r101 = new int[QQPlayStatus.values().length];
            r101[QQPlayStatus.PLAYING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L22:
            r101[QQPlayStatus.PAUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L28:
            r101[QQPlayStatus.STOPPED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L12:
            f359477b = r101;
        }
    }

    public static final MusicOperateResult a(CommonOperateResult r100) {
        int r101 = a.f359476a[r100.ordinal()];
        if (r101 == 1) goto L13;
        if (r101 == 2) goto L15;
        if (r101 != 3) goto L10;
        return MusicOperateResult.CANCEL;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return MusicOperateResult.REJECT;
    L13:
        return MusicOperateResult.SUCCESS;
    }

    public static final QQMusicFolder b(com.larus.music.qq.data.QQMusicFolder r100) {
        return new QQMusicFolder(r100.getType(), r100.getId(), r100.getMainTitle(), r100.getSubTitle(), r100.getPicUrl(), r100.isSongFolder());
    }

    public static final QQMusicSong c(com.larus.music.qq.data.QQMusicSong r110) {
        QQMusicAlbum r100 = r110.getAlbum();
        QQMusicSinger r101 = null;
        if (r100 == null) goto L5;
        com.larus.platform.api.QQMusicAlbum r102 = new com.larus.platform.api.QQMusicAlbum(r100.getCoverUri(), r100.getId(), r100.getMid(), r100.getTitle());
    L6:
        Integer r103 = r110.getDuration();
        String r104 = r110.getGenre();
        String r105 = r110.getId();
        List<Integer> r106 = r110.getLabelIdList();
        String r107 = r110.getMid();
        com.larus.music.qq.data.QQMusicSinger r108 = r110.getSinger();
        if (r108 == null) goto L10;
        r101 = new QQMusicSinger(r108.getId(), r108.getMid(), r108.getTitle());
    L10:
        return new QQMusicSong(r102, r103, r104, r105, r106, r107, r101, r110.getTitle(), r110.getType(), r110.isAudition(), r110.isOrigin(), r110.getVipState(), r110.getHasCopyRight());
    L5:
        r102 = null;
        goto L6
    }
}
