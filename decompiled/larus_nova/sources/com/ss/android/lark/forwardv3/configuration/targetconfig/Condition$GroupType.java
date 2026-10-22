package com.ss.android.lark.forwardv3.configuration.targetconfig;

import com.obric.miniapp.alarm.AccountType;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$GroupType;", "Ljava/io/Serializable;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", AccountType.ALL, EffectConstants.NORMAL, "THREAD", "toString", "", "Companion", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Condition$GroupType extends Enum<Condition$GroupType> implements Serializable {
    public static final Condition$GroupType ALL = null;
    public static final a Companion = null;
    public static final Condition$GroupType NORMAL = null;
    public static final int OFFSET = 4;
    public static final Condition$GroupType THREAD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Condition$GroupType[] f425222a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f425223b = null;
    private final int value;

    public static EnumEntries<Condition$GroupType> getEntries() {
        return f425223b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$GroupType$a] */
    static {
        Condition$GroupType r100 = new Condition$GroupType(AccountType.ALL, 0, 0);
        ALL = r100;
        Condition$GroupType r101 = new Condition$GroupType(EffectConstants.NORMAL, 1, 1);
        NORMAL = r101;
        Condition$GroupType r102 = new Condition$GroupType("THREAD", 2, 2);
        THREAD = r102;
        Condition$GroupType[] r103 = {r100, r101, r102};
        f425222a = r103;
        f425223b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static Condition$GroupType[] values() {
        return (Condition$GroupType[]) f425222a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = this.value;
        if (r100 != 0) goto L5;
        return AccountType.ALL;
    L5:
        if (r100 != 1) goto L7;
        return EffectConstants.NORMAL;
    L7:
        if (r100 == 2) goto L9;
        return "null";
    L9:
        return "THREAD";
    }

    public final int getValue() {
        return this.value;
    }

    public static Condition$GroupType valueOf(String r100) {
        return (Condition$GroupType) r27.a.a(Condition$GroupType.class, r100);
    }

    public Condition$GroupType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
