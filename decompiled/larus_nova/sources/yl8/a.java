package yl8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.MusicCreationContentList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Message f568326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MusicCreationContentList f568327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f568328c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f568326a, r101.f568326a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f568327b, r101.f568327b) == true) goto L15;
        return false;
    L15:
        if (this.f568328c == r101.f568328c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Message r100 = this.f568326a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        MusicCreationContentList r104 = this.f568327b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (r103 + r101) * 31;
        if (this.f568328c == false) goto L13;
        int r106 = 1231;
    L15:
        return r105 + r106;
    L13:
        r106 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LyricsToSongModel(message=" + this.f568326a + ", musicContent=" + this.f568327b + ", isFinished=" + this.f568328c + ')';
    }

    public a(Message r100, MusicCreationContentList r101, boolean r102) {
        this.f568326a = r100;
        this.f568327b = r101;
        this.f568328c = r102;
    }
}
