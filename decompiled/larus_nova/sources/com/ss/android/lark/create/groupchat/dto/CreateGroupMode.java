package com.ss.android.lark.create.groupchat.dto;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/create/groupchat/dto/CreateGroupMode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "CONVERSATION_MODE", "TOPIC_MODE", "SECRET_MODE", "create-group-chat-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CreateGroupMode extends Enum<CreateGroupMode> {
    public static final CreateGroupMode CONVERSATION_MODE = null;
    public static final CreateGroupMode SECRET_MODE = null;
    public static final CreateGroupMode TOPIC_MODE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CreateGroupMode[] f420174a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f420175b = null;
    private final int value;

    public static EnumEntries<CreateGroupMode> getEntries() {
        return f420175b;
    }

    static {
        CreateGroupMode r100 = new CreateGroupMode("CONVERSATION_MODE", 0, 1);
        CONVERSATION_MODE = r100;
        CreateGroupMode r101 = new CreateGroupMode("TOPIC_MODE", 1, 2);
        TOPIC_MODE = r101;
        CreateGroupMode r102 = new CreateGroupMode("SECRET_MODE", 2, 3);
        SECRET_MODE = r102;
        CreateGroupMode[] r103 = {r100, r101, r102};
        f420174a = r103;
        f420175b = EnumEntriesKt.enumEntries(r103);
    }

    public static CreateGroupMode[] values() {
        return (CreateGroupMode[]) f420174a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static CreateGroupMode valueOf(String r100) {
        return (CreateGroupMode) a.a(CreateGroupMode.class, r100);
    }

    public CreateGroupMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
