package pl9;

import com.larus.music.qq.data.QQMusicFolder;
import com.tencent.qqmusic.third.api.contract.Data;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {
    public static final QQMusicFolder a(Data.FolderInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new QQMusicFolder(r100.getType(), r100.getId(), r100.getMainTitle(), r100.getSubTitle(), r100.getPicUrl(), r100.isSongFolder());
    }
}
