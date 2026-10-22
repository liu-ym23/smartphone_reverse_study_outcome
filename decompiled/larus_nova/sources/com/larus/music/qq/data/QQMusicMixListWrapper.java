package com.larus.music.qq.data;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.qqmusic.third.api.contract.Data;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/larus/music/qq/data/QQMusicMixListWrapper;", "", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "Lcom/tencent/qqmusic/third/api/contract/Data$Album;", "getA", "()Ljava/util/List;", "b", "Lcom/tencent/qqmusic/third/api/contract/Data$FolderInfo;", "getB", "c", "Lcom/tencent/qqmusic/third/api/contract/Data$Song;", "getC", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QQMusicMixListWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<Data.Album> f359526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<Data.FolderInfo> f359527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<Data.Song> f359528c;

    public QQMusicMixListWrapper() {
    }

    public final List<Data.Album> getA() {
        return this.f359526a;
    }

    public final List<Data.FolderInfo> getB() {
        return this.f359527b;
    }

    public final List<Data.Song> getC() {
        return this.f359528c;
    }
}
