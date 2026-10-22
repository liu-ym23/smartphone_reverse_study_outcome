package com.larus.platform.model.chat;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/platform/model/chat/MessageModifyStyle;", "", "styleValue", "", "<init>", "(Ljava/lang/String;II)V", "getStyleValue", "()I", "SMALL_BOX", "FULL_BOX", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MessageModifyStyle extends Enum<MessageModifyStyle> {
    public static final a Companion = null;
    public static final MessageModifyStyle FULL_BOX = null;
    public static final MessageModifyStyle SMALL_BOX = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MessageModifyStyle[] f365563a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365564b = null;
    private final int styleValue;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<MessageModifyStyle> getEntries() {
        return f365564b;
    }

    static {
        MessageModifyStyle r100 = new MessageModifyStyle("SMALL_BOX", 0, 0);
        SMALL_BOX = r100;
        MessageModifyStyle r101 = new MessageModifyStyle("FULL_BOX", 1, 1);
        FULL_BOX = r101;
        MessageModifyStyle[] r102 = {r100, r101};
        f365563a = r102;
        f365564b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static MessageModifyStyle[] values() {
        return (MessageModifyStyle[]) f365563a.clone();
    }

    public final int getStyleValue() {
        return this.styleValue;
    }

    public static MessageModifyStyle valueOf(String r100) {
        return (MessageModifyStyle) r27.a.a(MessageModifyStyle.class, r100);
    }

    public MessageModifyStyle(String r100, int r101, int r102) {
        super(r100, r101);
        this.styleValue = r102;
    }
}
