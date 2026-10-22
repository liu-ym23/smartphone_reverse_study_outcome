package com.ss.android.lark.forwardv3.configuration.targetconfig;

import com.obric.miniapp.alarm.AccountType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$ThreadType;", "Ljava/io/Serializable;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", AccountType.ALL, "NORMAL_THREAD", "MSG_THREAD", "toString", "", "Companion", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Condition$ThreadType extends Enum<Condition$ThreadType> implements Serializable {
    public static final Condition$ThreadType ALL = null;
    public static final a Companion = null;
    public static final Condition$ThreadType MSG_THREAD = null;
    public static final Condition$ThreadType NORMAL_THREAD = null;
    public static final int OFFSET = 10;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Condition$ThreadType[] f425230a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f425231b = null;
    private final int value;

    public static EnumEntries<Condition$ThreadType> getEntries() {
        return f425231b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$ThreadType$a] */
    static {
        Condition$ThreadType r100 = new Condition$ThreadType(AccountType.ALL, 0, 0);
        ALL = r100;
        Condition$ThreadType r101 = new Condition$ThreadType("NORMAL_THREAD", 1, 1);
        NORMAL_THREAD = r101;
        Condition$ThreadType r102 = new Condition$ThreadType("MSG_THREAD", 2, 2);
        MSG_THREAD = r102;
        Condition$ThreadType[] r103 = {r100, r101, r102};
        f425230a = r103;
        f425231b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static Condition$ThreadType[] values() {
        return (Condition$ThreadType[]) f425230a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = this.value;
        if (r100 != 0) goto L5;
        return AccountType.ALL;
    L5:
        if (r100 != 1) goto L7;
        return "NORMAL_THREAD";
    L7:
        if (r100 == 2) goto L9;
        return "null";
    L9:
        return "MSG_THREAD";
    }

    public final int getValue() {
        return this.value;
    }

    public static Condition$ThreadType valueOf(String r100) {
        return (Condition$ThreadType) r27.a.a(Condition$ThreadType.class, r100);
    }

    public Condition$ThreadType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
