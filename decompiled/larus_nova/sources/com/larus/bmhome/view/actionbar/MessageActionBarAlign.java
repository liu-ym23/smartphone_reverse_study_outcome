package com.larus.bmhome.view.actionbar;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/view/actionbar/MessageActionBarAlign;", "", "<init>", "(Ljava/lang/String;I)V", GXAnimation.STATE_START, GXAnimation.STATE_END, "KEEP", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MessageActionBarAlign extends Enum<MessageActionBarAlign> {
    public static final MessageActionBarAlign END = null;
    public static final MessageActionBarAlign KEEP = null;
    public static final MessageActionBarAlign START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MessageActionBarAlign[] f315637a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f315638b = null;

    public static EnumEntries<MessageActionBarAlign> getEntries() {
        return f315638b;
    }

    static {
        MessageActionBarAlign r100 = new MessageActionBarAlign(GXAnimation.STATE_START, 0);
        START = r100;
        MessageActionBarAlign r101 = new MessageActionBarAlign(GXAnimation.STATE_END, 1);
        END = r101;
        MessageActionBarAlign r102 = new MessageActionBarAlign("KEEP", 2);
        KEEP = r102;
        MessageActionBarAlign[] r103 = {r100, r101, r102};
        f315637a = r103;
        f315638b = EnumEntriesKt.enumEntries(r103);
    }

    public static MessageActionBarAlign[] values() {
        return (MessageActionBarAlign[]) f315637a.clone();
    }

    public static MessageActionBarAlign valueOf(String r100) {
        return (MessageActionBarAlign) a.a(MessageActionBarAlign.class, r100);
    }

    public MessageActionBarAlign(String r100, int r101) {
        super(r100, r101);
    }
}
