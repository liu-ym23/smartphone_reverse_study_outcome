package com.larus.im.bean.conversation;

import java.lang.annotation.Annotation;
import juc.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import nuc.i0;
import wc9.p;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u0000 \n2\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/im/bean/conversation/MessageReplaceStrategy;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "MIGRATE", "DELETE", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final enum MessageReplaceStrategy extends Enum<MessageReplaceStrategy> implements java.io.Serializable {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ MessageReplaceStrategy[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;
    public static final a Companion = null;

    @SerialName("1")
    public static final MessageReplaceStrategy DELETE = null;

    @SerialName("0")
    public static final MessageReplaceStrategy MIGRATE = null;
    public final int value;

    private static final /* synthetic */ MessageReplaceStrategy[] $values() {
        return new MessageReplaceStrategy[]{MIGRATE, DELETE};
    }

    public static /* synthetic */ d a() {
        return _init_$_anonymous_();
    }

    public static EnumEntries<MessageReplaceStrategy> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.im.bean.conversation.MessageReplaceStrategy$a] */
    static {
        MIGRATE = new MessageReplaceStrategy("MIGRATE", 0, 0);
        DELETE = new MessageReplaceStrategy("DELETE", 1, 1);
        MessageReplaceStrategy[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new p());
    }

    public static MessageReplaceStrategy[] values() {
        return (MessageReplaceStrategy[]) $VALUES.clone();
    }

    private static final /* synthetic */ d _init_$_anonymous_() {
        return i0.a("com.larus.im.bean.conversation.MessageReplaceStrategy", values(), new String[]{"0", "1"}, new Annotation[][]{null, null});
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public static MessageReplaceStrategy valueOf(String r100) {
        return (MessageReplaceStrategy) r27.a.a(MessageReplaceStrategy.class, r100);
    }

    private MessageReplaceStrategy(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
