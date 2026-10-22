package com.ss.android.lark.chat.entity.wallpaper;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u001b\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J%\u0010#\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tHÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\fHÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003Jg\u0010(\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032$\b\u0002\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u0007HÆ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R-\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016¨\u0006)"}, d2 = {"Lcom/ss/android/lark/chat/entity/wallpaper/ChatThemeListInfo;", "Ljava/io/Serializable;", "themeItems", "Ljava/util/LinkedList;", "Lcom/ss/android/lark/chat/entity/wallpaper/ThemeListItem;", "chatThemes", "Ljava/util/HashMap;", "", "Lokio/ByteString;", "Lkotlin/collections/HashMap;", "nextPos", "hasMore", "", "userUsedThemeId", "groupUsedThemeId", "<init>", "(Ljava/util/LinkedList;Ljava/util/HashMap;JZJJ)V", "getThemeItems", "()Ljava/util/LinkedList;", "getChatThemes", "()Ljava/util/HashMap;", "getNextPos", "()J", "getHasMore", "()Z", "getUserUsedThemeId", "getGroupUsedThemeId", "equals", "other", "", "hashCode", "", "toString", "", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatThemeListInfo implements Serializable {
    private final HashMap<Long, ByteString> chatThemes;
    private final long groupUsedThemeId;
    private final boolean hasMore;
    private final long nextPos;
    private final LinkedList<ThemeListItem> themeItems;
    private final long userUsedThemeId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChatThemeListInfo copy$default(ChatThemeListInfo r110, LinkedList r111, HashMap r112, long r113, boolean r114, long r115, long r116, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        LinkedList r100 = r110.themeItems;
    L7:
        if ((r210 & 2) == 0) goto L9;
        HashMap r101 = r110.chatThemes;
    L11:
        if ((r210 & 4) == 0) goto L13;
        long r102 = r110.nextPos;
    L15:
        if ((r210 & 8) == 0) goto L17;
        boolean r103 = r110.hasMore;
    L19:
        if ((r210 & 16) == 0) goto L21;
        long r104 = r110.userUsedThemeId;
    L23:
        if ((r210 & 32) == 0) goto L25;
        long r105 = r110.groupUsedThemeId;
    L27:
        return r110.copy(r100, r101, r102, r103, r104, r105);
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final LinkedList<ThemeListItem> component1() {
        return this.themeItems;
    }

    public final HashMap<Long, ByteString> component2() {
        return this.chatThemes;
    }

    public final long component3() {
        return this.nextPos;
    }

    public final boolean component4() {
        return this.hasMore;
    }

    public final long component5() {
        return this.userUsedThemeId;
    }

    public final long component6() {
        return this.groupUsedThemeId;
    }

    public final ChatThemeListInfo copy(LinkedList<ThemeListItem> r110, HashMap<Long, ByteString> r111, long r112, boolean r113, long r114, long r115) {
        Intrinsics.checkNotNullParameter(r110, "themeItems");
        Intrinsics.checkNotNullParameter(r111, "chatThemes");
        return new ChatThemeListInfo(r110, r111, r112, r113, r114, r115);
    }

    public int hashCode() {
        int r100 = ((this.themeItems.hashCode() * 31) + this.chatThemes.hashCode()) * 31;
        long r101 = this.nextPos;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        if (this.hasMore == false) goto L5;
        int r103 = 1231;
    L6:
        int r104 = (r102 + r103) * 31;
        long r105 = this.userUsedThemeId;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.groupUsedThemeId;
        return r106 + ((int) (r107 ^ (r107 >>> 32)));
    L5:
        r103 = 1237;
        goto L6
    }

    public String toString() {
        return "ChatThemeListInfo(themeItems=" + this.themeItems + ", chatThemes=" + this.chatThemes + ", nextPos=" + this.nextPos + ", hasMore=" + this.hasMore + ", userUsedThemeId=" + this.userUsedThemeId + ", groupUsedThemeId=" + this.groupUsedThemeId + ')';
    }

    public final HashMap<Long, ByteString> getChatThemes() {
        return this.chatThemes;
    }

    public final long getGroupUsedThemeId() {
        return this.groupUsedThemeId;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final long getNextPos() {
        return this.nextPos;
    }

    public final LinkedList<ThemeListItem> getThemeItems() {
        return this.themeItems;
    }

    public final long getUserUsedThemeId() {
        return this.userUsedThemeId;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(ChatThemeListInfo.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.wallpaper.ChatThemeListInfo");
        ChatThemeListInfo r102 = (ChatThemeListInfo) r100;
        if (Intrinsics.areEqual(this.themeItems, r102.themeItems) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.chatThemes, r102.chatThemes) == true) goto L19;
        return false;
    L19:
        if (this.nextPos == r102.nextPos) goto L22;
        return false;
    L22:
        if (this.hasMore == r102.hasMore) goto L25;
        return false;
    L25:
        if (this.userUsedThemeId == r102.userUsedThemeId) goto L28;
        return false;
    L28:
        if (this.groupUsedThemeId == r102.groupUsedThemeId) goto L30;
        return false;
    L30:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public ChatThemeListInfo(LinkedList<ThemeListItem> r100, HashMap<Long, ByteString> r101, long r102, boolean r103, long r104, long r105) {
        Intrinsics.checkNotNullParameter(r100, "themeItems");
        Intrinsics.checkNotNullParameter(r101, "chatThemes");
        this.themeItems = r100;
        this.chatThemes = r101;
        this.nextPos = r102;
        this.hasMore = r103;
        this.userUsedThemeId = r104;
        this.groupUsedThemeId = r105;
    }
}
