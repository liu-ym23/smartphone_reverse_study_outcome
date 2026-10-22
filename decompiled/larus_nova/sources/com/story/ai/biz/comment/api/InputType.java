package com.story.ai.biz.comment.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/story/ai/biz/comment/api/InputType;", "", "<init>", "(Ljava/lang/String;I)V", "AUTO", "CLICK", "REPLY", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InputType extends Enum<InputType> {
    public static final InputType AUTO = null;
    public static final InputType CLICK = null;
    public static final InputType REPLY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InputType[] f459848a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f459849b = null;

    public static EnumEntries<InputType> getEntries() {
        return f459849b;
    }

    static {
        InputType r100 = new InputType("AUTO", 0);
        AUTO = r100;
        InputType r101 = new InputType("CLICK", 1);
        CLICK = r101;
        InputType r102 = new InputType("REPLY", 2);
        REPLY = r102;
        InputType[] r103 = {r100, r101, r102};
        f459848a = r103;
        f459849b = EnumEntriesKt.enumEntries(r103);
    }

    public static InputType[] values() {
        return (InputType[]) f459848a.clone();
    }

    public static InputType valueOf(String r100) {
        return (InputType) a.a(InputType.class, r100);
    }

    public InputType(String r100, int r101) {
        super(r100, r101);
    }
}
