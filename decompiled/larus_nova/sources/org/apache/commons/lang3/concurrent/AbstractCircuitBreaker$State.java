package org.apache.commons.lang3.concurrent;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public abstract enum AbstractCircuitBreaker$State extends Enum<AbstractCircuitBreaker$State> {
    private static final /* synthetic */ AbstractCircuitBreaker$State[] $VALUES = null;
    public static final AbstractCircuitBreaker$State CLOSED = null;
    public static final AbstractCircuitBreaker$State OPEN = null;

    public abstract AbstractCircuitBreaker$State oppositeState();

    static {
        final String r100 = ErrorCode.CLOSED;
        final int r101 = 0;
        AbstractCircuitBreaker$State r102 = new AnonymousClass1(r100, r101);
        CLOSED = r102;
        final String r103 = "OPEN";
        final int r104 = 1;
        AbstractCircuitBreaker$State r105 = new AnonymousClass2(r103, r104);
        OPEN = r105;
        $VALUES = new AbstractCircuitBreaker$State[]{r102, r105};
    }

    public static AbstractCircuitBreaker$State[] values() {
        return (AbstractCircuitBreaker$State[]) $VALUES.clone();
    }

    public static AbstractCircuitBreaker$State valueOf(String r100) {
        return (AbstractCircuitBreaker$State) a.a(AbstractCircuitBreaker$State.class, r100);
    }

    private AbstractCircuitBreaker$State(String r100, int r101) {
        super(r100, r101);
    }

    public /* synthetic */ AbstractCircuitBreaker$State(String r100, int r101, AbstractCircuitBreaker$1 r102) {
        this(r100, r101);
    }
}
