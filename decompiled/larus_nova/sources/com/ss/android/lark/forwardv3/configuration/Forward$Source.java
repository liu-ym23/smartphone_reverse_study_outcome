package com.ss.android.lark.forwardv3.configuration;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/forwardv3/configuration/Forward$Source;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "MESSAGE", "GROUP_CHAT", "MY_AI", "KNOWLEDGE_AI", "DOUBAO", "Companion", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Forward$Source extends Enum<Forward$Source> {
    public static final a Companion = null;
    public static final Forward$Source DOUBAO = null;
    public static final Forward$Source GROUP_CHAT = null;
    public static final Forward$Source KNOWLEDGE_AI = null;
    public static final Forward$Source MESSAGE = null;
    public static final Forward$Source MY_AI = null;
    public static final Forward$Source UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Forward$Source[] f425150a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f425151b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<Forward$Source> getEntries() {
        return f425151b;
    }

    static {
        Forward$Source r100 = new Forward$Source("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        Forward$Source r101 = new Forward$Source("MESSAGE", 1, 1);
        MESSAGE = r101;
        Forward$Source r102 = new Forward$Source("GROUP_CHAT", 2, 2);
        GROUP_CHAT = r102;
        Forward$Source r103 = new Forward$Source("MY_AI", 3, 10);
        MY_AI = r103;
        Forward$Source r104 = new Forward$Source("KNOWLEDGE_AI", 4, 11);
        KNOWLEDGE_AI = r104;
        Forward$Source r105 = new Forward$Source("DOUBAO", 5, 12);
        DOUBAO = r105;
        Forward$Source[] r110 = {r100, r101, r102, r103, r104, r105};
        f425150a = r110;
        f425151b = EnumEntriesKt.enumEntries(r110);
        Companion = new a();
    }

    public static Forward$Source[] values() {
        return (Forward$Source[]) f425150a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static Forward$Source valueOf(String r100) {
        return (Forward$Source) r27.a.a(Forward$Source.class, r100);
    }

    public Forward$Source(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
