package com.ss.android.lark.inline.ai.api;

import com.bytedance.sdk.open.aweme.core.net.OpenNetMethod;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/LockType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", OpenNetMethod.LOCK, "UNLOCK", "DEFAULT", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LockType extends Enum<LockType> {
    public static final LockType DEFAULT = null;
    public static final LockType LOCK = null;
    public static final LockType UNLOCK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LockType[] f426803a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f426804b = null;
    private final String value;

    public static EnumEntries<LockType> getEntries() {
        return f426804b;
    }

    static {
        LockType r100 = new LockType(OpenNetMethod.LOCK, 0, "lock");
        LOCK = r100;
        LockType r101 = new LockType("UNLOCK", 1, "unLock");
        UNLOCK = r101;
        LockType r102 = new LockType("DEFAULT", 2, "default");
        DEFAULT = r102;
        LockType[] r103 = {r100, r101, r102};
        f426803a = r103;
        f426804b = EnumEntriesKt.enumEntries(r103);
    }

    public static LockType[] values() {
        return (LockType[]) f426803a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static LockType valueOf(String r100) {
        return (LockType) a.a(LockType.class, r100);
    }

    public LockType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
