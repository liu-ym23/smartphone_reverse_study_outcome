package com.larus.im.observer;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/larus/im/observer/MessageListState;", "", OnekeyLoginConstants.CU_KEY_OPERATOR, "", "<init>", "(Ljava/lang/String;II)V", "getOperator", "()I", "UPDATE", "DELETE", "REFRESH_ALL", "INSERT", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MessageListState extends Enum<MessageListState> {
    public static final a Companion = null;
    public static final MessageListState DELETE = null;
    public static final MessageListState INSERT = null;
    public static final MessageListState REFRESH_ALL = null;
    public static final MessageListState UPDATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MessageListState[] f350607a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350608b = null;
    private final int operator;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<MessageListState> getEntries() {
        return f350608b;
    }

    static {
        MessageListState r100 = new MessageListState("UPDATE", 0, 1);
        UPDATE = r100;
        MessageListState r101 = new MessageListState("DELETE", 1, 2);
        DELETE = r101;
        MessageListState r102 = new MessageListState("REFRESH_ALL", 2, 3);
        REFRESH_ALL = r102;
        MessageListState r103 = new MessageListState("INSERT", 3, 4);
        INSERT = r103;
        MessageListState[] r104 = {r100, r101, r102, r103};
        f350607a = r104;
        f350608b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static MessageListState[] values() {
        return (MessageListState[]) f350607a.clone();
    }

    public final int getOperator() {
        return this.operator;
    }

    public static MessageListState valueOf(String r100) {
        return (MessageListState) r27.a.a(MessageListState.class, r100);
    }

    public MessageListState(String r100, int r101, int r102) {
        super(r100, r101);
        this.operator = r102;
    }
}
