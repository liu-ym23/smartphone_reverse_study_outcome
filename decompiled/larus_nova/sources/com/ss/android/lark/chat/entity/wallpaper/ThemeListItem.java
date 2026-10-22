package com.ss.android.lark.chat.entity.wallpaper;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/chat/entity/wallpaper/ThemeListItem;", "Ljava/io/Serializable;", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "", "themeId", "themeName", "", "<init>", "(JJLjava/lang/String;)V", "getPos", "()J", "setPos", "(J)V", "getThemeId", "setThemeId", "getThemeName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "component1", "component2", "component3", "copy", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ThemeListItem implements Serializable {
    private long pos;
    private long themeId;
    private final String themeName;

    public static /* synthetic */ ThemeListItem copy$default(ThemeListItem r100, long r101, long r102, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L5;
        r101 = r100.pos;
    L5:
        long r103 = r101;
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.themeId;
    L8:
        long r104 = r102;
        if ((r111 & 4) == 0) goto L12;
        r110 = r100.themeName;
    L12:
        return r100.copy(r103, r104, r110);
    }

    public final long component1() {
        return this.pos;
    }

    public final long component2() {
        return this.themeId;
    }

    public final String component3() {
        return this.themeName;
    }

    public final ThemeListItem copy(long r100, long r110, String r111) {
        return new ThemeListItem(r100, r110, r111);
    }

    public int hashCode() {
        long r100 = this.pos;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.themeId;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        String r104 = this.themeName;
        if (r104 == null) goto L5;
        int r105 = r104.hashCode();
    L7:
        return r103 + r105;
    L5:
        r105 = 0;
        goto L7
    }

    public String toString() {
        return "ThemeListItem(pos=" + this.pos + ", themeId=" + this.themeId + ", themeName='" + this.themeName + "')";
    }

    public final long getPos() {
        return this.pos;
    }

    public final long getThemeId() {
        return this.themeId;
    }

    public final String getThemeName() {
        return this.themeName;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(ThemeListItem.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.wallpaper.ThemeListItem");
        ThemeListItem r102 = (ThemeListItem) r100;
        if (this.pos == r102.pos) goto L16;
        return false;
    L16:
        if (this.themeId == r102.themeId) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.themeName, r102.themeName) == true) goto L21;
        return false;
    L21:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public final void setPos(long r100) {
        this.pos = r100;
    }

    public final void setThemeId(long r100) {
        this.themeId = r100;
    }

    public ThemeListItem(long r100, long r101, String r102) {
        this.pos = r100;
        this.themeId = r101;
        this.themeName = r102;
    }

    public /* synthetic */ ThemeListItem(long r100, long r101, String r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 4) == 0) goto L5;
        r110 = null;
    L5:
        this(r100, r101, r110);
    }
}
