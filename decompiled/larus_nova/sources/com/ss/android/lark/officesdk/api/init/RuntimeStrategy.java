package com.ss.android.lark.officesdk.api.init;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/officesdk/api/init/RuntimeStrategy;", "", "<init>", "(Ljava/lang/String;I)V", AccountType.MAIN, "ASYNC_HIGH", "ASYNC_NORMAL", "isAsync", "", "officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RuntimeStrategy extends Enum<RuntimeStrategy> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ RuntimeStrategy[] $VALUES = null;
    public static final RuntimeStrategy ASYNC_HIGH = null;
    public static final RuntimeStrategy ASYNC_NORMAL = null;
    public static final RuntimeStrategy MAIN = null;

    private static final /* synthetic */ RuntimeStrategy[] $values() {
        return new RuntimeStrategy[]{MAIN, ASYNC_HIGH, ASYNC_NORMAL};
    }

    public static EnumEntries<RuntimeStrategy> getEntries() {
        return $ENTRIES;
    }

    static {
        MAIN = new RuntimeStrategy(AccountType.MAIN, 0);
        ASYNC_HIGH = new RuntimeStrategy("ASYNC_HIGH", 1);
        ASYNC_NORMAL = new RuntimeStrategy("ASYNC_NORMAL", 2);
        RuntimeStrategy[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static RuntimeStrategy[] values() {
        return (RuntimeStrategy[]) $VALUES.clone();
    }

    public final boolean isAsync() {
        if (this == MAIN) goto L5;
        return true;
    L5:
        return false;
    }

    public static RuntimeStrategy valueOf(String r100) {
        return (RuntimeStrategy) a.a(RuntimeStrategy.class, r100);
    }

    private RuntimeStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
