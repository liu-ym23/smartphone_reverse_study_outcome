package com.larus.bmhome.chat.interceptor;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/interceptor/MessageRenderState;", "", "state", "", "<init>", "(Ljava/lang/String;II)V", "getState", "()I", "NON", GXAnimation.STATE_START, "RUNNING", "FINISH", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MessageRenderState extends Enum<MessageRenderState> {
    public static final MessageRenderState FINISH = null;
    public static final MessageRenderState NON = null;
    public static final MessageRenderState RUNNING = null;
    public static final MessageRenderState START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MessageRenderState[] f303339a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f303340b = null;
    private final int state;

    public static EnumEntries<MessageRenderState> getEntries() {
        return f303340b;
    }

    static {
        MessageRenderState r100 = new MessageRenderState("NON", 0, -1);
        NON = r100;
        MessageRenderState r101 = new MessageRenderState(GXAnimation.STATE_START, 1, 1);
        START = r101;
        MessageRenderState r102 = new MessageRenderState("RUNNING", 2, 2);
        RUNNING = r102;
        MessageRenderState r103 = new MessageRenderState("FINISH", 3, 3);
        FINISH = r103;
        MessageRenderState[] r104 = {r100, r101, r102, r103};
        f303339a = r104;
        f303340b = EnumEntriesKt.enumEntries(r104);
    }

    public static MessageRenderState[] values() {
        return (MessageRenderState[]) f303339a.clone();
    }

    public final int getState() {
        return this.state;
    }

    public static MessageRenderState valueOf(String r100) {
        return (MessageRenderState) a.a(MessageRenderState.class, r100);
    }

    public MessageRenderState(String r100, int r101, int r102) {
        super(r100, r101);
        this.state = r102;
    }
}
