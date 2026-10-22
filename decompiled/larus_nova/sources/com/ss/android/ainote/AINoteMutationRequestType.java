package com.ss.android.ainote;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/ainote/AINoteMutationRequestType;", "", "<init>", "(Ljava/lang/String;I)V", "CREATE", "UPDATE_TEXT", "UPDATE_STATE", "USE_AI", "REVERT_AI", "ACK_AI", "DELETE", "ai-note_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AINoteMutationRequestType extends Enum<AINoteMutationRequestType> {
    public static final AINoteMutationRequestType ACK_AI = null;
    public static final AINoteMutationRequestType CREATE = null;
    public static final AINoteMutationRequestType DELETE = null;
    public static final AINoteMutationRequestType REVERT_AI = null;
    public static final AINoteMutationRequestType UPDATE_STATE = null;
    public static final AINoteMutationRequestType UPDATE_TEXT = null;
    public static final AINoteMutationRequestType USE_AI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AINoteMutationRequestType[] f406525a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f406526b = null;

    public static EnumEntries<AINoteMutationRequestType> getEntries() {
        return f406526b;
    }

    static {
        AINoteMutationRequestType r100 = new AINoteMutationRequestType("CREATE", 0);
        CREATE = r100;
        AINoteMutationRequestType r101 = new AINoteMutationRequestType("UPDATE_TEXT", 1);
        UPDATE_TEXT = r101;
        AINoteMutationRequestType r102 = new AINoteMutationRequestType("UPDATE_STATE", 2);
        UPDATE_STATE = r102;
        AINoteMutationRequestType r103 = new AINoteMutationRequestType("USE_AI", 3);
        USE_AI = r103;
        AINoteMutationRequestType r104 = new AINoteMutationRequestType("REVERT_AI", 4);
        REVERT_AI = r104;
        AINoteMutationRequestType r105 = new AINoteMutationRequestType("ACK_AI", 5);
        ACK_AI = r105;
        AINoteMutationRequestType r110 = new AINoteMutationRequestType("DELETE", 6);
        DELETE = r110;
        AINoteMutationRequestType[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f406525a = r111;
        f406526b = EnumEntriesKt.enumEntries(r111);
    }

    public static AINoteMutationRequestType[] values() {
        return (AINoteMutationRequestType[]) f406525a.clone();
    }

    public static AINoteMutationRequestType valueOf(String r100) {
        return (AINoteMutationRequestType) r27.a.a(AINoteMutationRequestType.class, r100);
    }

    public AINoteMutationRequestType(String r100, int r101) {
        super(r100, r101);
    }
}
