package com.bytedance.android.livesdk.ktvimpl.base.sei;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\"R \u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u001a\u0010\u001b\u001a\u00020\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001eR\u001a\u0010!\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0013\u001a\u0004\b\"\u0010\u0015¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/sei/q;", "", "", "userId", "J", "getUserId", "()J", "getUserId$annotations", "()V", "anchorId", "getAnchorId", "getAnchorId$annotations", "Lpy/k;", "avatarThumb", "Lpy/k;", "b", "()Lpy/k;", "", "nickname", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "songTitle", "g", "highScoreSongCount", "c", "", "ktvComponentLyricTextSecondLine", "I", "d", "()I", "ktvLyricText", "e", "author", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class q {
    public String a;

    @SerializedName("anchor_id")
    private final long anchorId;

    @SerializedName("author")
    private final String author;

    @SerializedName("avatar_thumb")
    private final py.k avatarThumb;

    @SerializedName("h_song_count")
    private final String highScoreSongCount;

    @SerializedName("ksong_lyric")
    private final int ktvComponentLyricTextSecondLine;

    @SerializedName("ktv_lyric")
    private final int ktvLyricText;

    @SerializedName("nickname")
    private final String nickname;

    @SerializedName("song_title")
    private final String songTitle;

    @SerializedName("user_id")
    private final long userId;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof q) == false) goto L24;
        q r7 = (q) r6;
        if (this.userId == r7.userId) goto L8;
        return false;
    L8:
        if (this.anchorId == r7.anchorId) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.avatarThumb, r7.avatarThumb) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.nickname, r7.nickname) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.songTitle, r7.songTitle) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.highScoreSongCount, r7.highScoreSongCount) == true) goto L18;
        return false;
    L18:
        if (this.ktvComponentLyricTextSecondLine == r7.ktvComponentLyricTextSecondLine) goto L20;
        return false;
    L20:
        if (this.ktvLyricText == r7.ktvLyricText) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.author, r7.author) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        long r0 = this.userId;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.anchorId;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        py.k r4 = this.avatarThumb;
        int r5 = 0;
        if (r4 == null) goto L5;
        int r6 = r4.hashCode();
    L6:
        int r7 = (r2 + r6) * 31;
        String r8 = this.nickname;
        if (r8 == null) goto L9;
        int r9 = r8.hashCode();
    L10:
        int r10 = (r7 + r9) * 31;
        String r11 = this.songTitle;
        if (r11 == null) goto L13;
        int r12 = r11.hashCode();
    L14:
        int r13 = (r10 + r12) * 31;
        String r14 = this.highScoreSongCount;
        if (r14 == null) goto L17;
        int r15 = r14.hashCode();
    L18:
        int r16 = (((((r13 + r15) * 31) + this.ktvComponentLyricTextSecondLine) * 31) + this.ktvLyricText) * 31;
        String r17 = this.author;
        if (r17 == null) goto L22;
        r5 = r17.hashCode();
    L22:
        return r16 + r5;
    L17:
        r15 = 0;
        goto L18
    L13:
        r12 = 0;
        goto L14
    L9:
        r9 = 0;
        goto L10
    L5:
        r6 = 0;
        goto L6
    }

    public final String toString() {
        return "OrderSongSeiModel(userId=" + this.userId + ", anchorId=" + this.anchorId + ", avatarThumb=" + this.avatarThumb + ", nickname=" + this.nickname + ", songTitle=" + this.songTitle + ", highScoreSongCount=" + this.highScoreSongCount + ", ktvComponentLyricTextSecondLine=" + this.ktvComponentLyricTextSecondLine + ", ktvLyricText=" + this.ktvLyricText + ", author=" + this.author + ")";
    }

    public q() {
        Intrinsics.checkNotNullParameter("", "author");
        this.userId = 0;
        this.anchorId = 0;
        this.avatarThumb = null;
        this.nickname = null;
        this.songTitle = null;
        this.highScoreSongCount = null;
        this.ktvComponentLyricTextSecondLine = 0;
        this.ktvLyricText = 0;
        this.author = "";
        this.a = "";
    }

    public final String h() {
        if (TextUtils.isEmpty(this.a) == false) goto L6;
        this.a = t.k(this.userId);
    L6:
        return this.a;
    }

    public final String a() {
        return this.author;
    }

    public final py.k b() {
        return this.avatarThumb;
    }

    public final String c() {
        return this.highScoreSongCount;
    }

    public final int d() {
        return this.ktvComponentLyricTextSecondLine;
    }

    public final int e() {
        return this.ktvLyricText;
    }

    public final String f() {
        return this.nickname;
    }

    public final String g() {
        return this.songTitle;
    }
}
