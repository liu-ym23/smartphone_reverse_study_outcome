package com.ss.android.lark.chat.entity.wallpaper;

import com.ss.android.lark.chat.entity.chat.Chat;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\"\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0003j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J%\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006HÆ\u0003J%\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0003j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\u0006HÆ\u0003JU\u0010\u0018\u001a\u00020\u00002$\b\u0002\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u00062$\b\u0002\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0003j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\u0006HÆ\u0001R-\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR-\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0003j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/chat/entity/wallpaper/SetChatThemeInfo;", "Ljava/io/Serializable;", "chat", "Ljava/util/HashMap;", "", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "Lkotlin/collections/HashMap;", "chatThemes", "", "Lokio/ByteString;", "<init>", "(Ljava/util/HashMap;Ljava/util/HashMap;)V", "getChat", "()Ljava/util/HashMap;", "getChatThemes", "equals", "", "other", "", "hashCode", "", "toString", "component1", "component2", "copy", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SetChatThemeInfo implements Serializable {
    private final HashMap<String, Chat> chat;
    private final HashMap<Long, ByteString> chatThemes;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SetChatThemeInfo copy$default(SetChatThemeInfo r100, HashMap r101, HashMap r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.chat;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.chatThemes;
    L9:
        return r100.copy(r101, r102);
    }

    public final HashMap<String, Chat> component1() {
        return this.chat;
    }

    public final HashMap<Long, ByteString> component2() {
        return this.chatThemes;
    }

    public final SetChatThemeInfo copy(HashMap<String, Chat> r100, HashMap<Long, ByteString> r101) {
        Intrinsics.checkNotNullParameter(r100, "chat");
        Intrinsics.checkNotNullParameter(r101, "chatThemes");
        return new SetChatThemeInfo(r100, r101);
    }

    public int hashCode() {
        return (this.chat.hashCode() * 31) + this.chatThemes.hashCode();
    }

    public String toString() {
        return "SetChatThemeInfo(chat=" + this.chat + ", chatThemes=" + this.chatThemes + ')';
    }

    public final HashMap<String, Chat> getChat() {
        return this.chat;
    }

    public final HashMap<Long, ByteString> getChatThemes() {
        return this.chatThemes;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(SetChatThemeInfo.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.wallpaper.SetChatThemeInfo");
        SetChatThemeInfo r102 = (SetChatThemeInfo) r100;
        if (Intrinsics.areEqual(this.chat, r102.chat) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.chatThemes, r102.chatThemes) == true) goto L18;
        return false;
    L18:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public SetChatThemeInfo(HashMap<String, Chat> r100, HashMap<Long, ByteString> r101) {
        Intrinsics.checkNotNullParameter(r100, "chat");
        Intrinsics.checkNotNullParameter(r101, "chatThemes");
        this.chat = r100;
        this.chatThemes = r101;
    }
}
