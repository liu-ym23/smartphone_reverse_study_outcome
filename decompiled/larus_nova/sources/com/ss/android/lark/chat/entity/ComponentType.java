package com.ss.android.lark.chat.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chat/entity/ComponentType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "CHAT", "REPLY_IN_THREAD", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ComponentType extends Enum<ComponentType> {
    public static final ComponentType CHAT = null;
    public static final a Companion = null;
    public static final ComponentType REPLY_IN_THREAD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ComponentType[] f415092a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f415093b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<ComponentType> getEntries() {
        return f415093b;
    }

    static {
        ComponentType r100 = new ComponentType("CHAT", 0, 0);
        CHAT = r100;
        ComponentType r101 = new ComponentType("REPLY_IN_THREAD", 1, 1);
        REPLY_IN_THREAD = r101;
        ComponentType[] r102 = {r100, r101};
        f415092a = r102;
        f415093b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static ComponentType[] values() {
        return (ComponentType[]) f415092a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final ComponentType fromValue(int r100) {
        Companion.getClass();
        ComponentType r101 = CHAT;
        if (r100 == r101.getValue()) goto L10;
        ComponentType r102 = REPLY_IN_THREAD;
        if (r100 == r102.getValue()) goto L8;
        return r101;
    L8:
        return r102;
    L10:
        return r101;
    }

    @JvmStatic
    public static final boolean isChat(ComponentType r100) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100 != CHAT) goto L5;
        return true;
    L5:
        return false;
    }

    @JvmStatic
    public static final boolean isReplyInThread(ComponentType r100) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100 != REPLY_IN_THREAD) goto L5;
        return true;
    L5:
        return false;
    }

    public static ComponentType valueOf(String r100) {
        return (ComponentType) r27.a.a(ComponentType.class, r100);
    }

    public ComponentType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
