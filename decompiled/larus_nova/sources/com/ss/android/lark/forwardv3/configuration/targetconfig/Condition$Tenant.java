package com.ss.android.lark.forwardv3.configuration.targetconfig;

import com.obric.miniapp.alarm.AccountType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/forwardv3/configuration/targetconfig/Condition$Tenant;", "Ljava/io/Serializable;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", AccountType.ALL, "NOT_CROSS_TENANT", "CROSS_TENANT", "toString", "", "Companion", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Condition$Tenant extends Enum<Condition$Tenant> implements Serializable {
    public static final Condition$Tenant ALL = null;
    public static final Condition$Tenant CROSS_TENANT = null;
    public static final a Companion = null;
    public static final Condition$Tenant NOT_CROSS_TENANT = null;
    public static final int OFFSET = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Condition$Tenant[] f425228a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f425229b = null;
    private final int value;

    public static EnumEntries<Condition$Tenant> getEntries() {
        return f425229b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.forwardv3.configuration.targetconfig.Condition$Tenant$a] */
    static {
        Condition$Tenant r100 = new Condition$Tenant(AccountType.ALL, 0, 0);
        ALL = r100;
        Condition$Tenant r101 = new Condition$Tenant("NOT_CROSS_TENANT", 1, 1);
        NOT_CROSS_TENANT = r101;
        Condition$Tenant r102 = new Condition$Tenant("CROSS_TENANT", 2, 2);
        CROSS_TENANT = r102;
        Condition$Tenant[] r103 = {r100, r101, r102};
        f425228a = r103;
        f425229b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static Condition$Tenant[] values() {
        return (Condition$Tenant[]) f425228a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = this.value;
        if (r100 != 0) goto L5;
        return AccountType.ALL;
    L5:
        if (r100 != 1) goto L7;
        return "NOT_CROSS_TENANT";
    L7:
        if (r100 == 2) goto L9;
        return "null";
    L9:
        return "CROSS_TENANT";
    }

    public final int getValue() {
        return this.value;
    }

    public static Condition$Tenant valueOf(String r100) {
        return (Condition$Tenant) r27.a.a(Condition$Tenant.class, r100);
    }

    public Condition$Tenant(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
