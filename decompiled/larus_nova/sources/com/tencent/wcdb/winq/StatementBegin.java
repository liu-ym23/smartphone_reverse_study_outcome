package com.tencent.wcdb.winq;

/* JADX INFO: loaded from: classes41.dex */
public class StatementBegin extends Statement {

    public static class TransactionType {
        static final int Deferred = 0;
        static final int Exclusive = 2;
        static final int Immediate = 1;

        public TransactionType() {
        }
    }

    private static native long createCppObj(int r100);

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 35;
    }

    public static StatementBegin beginDeferred() {
        return new StatementBegin(0);
    }

    public static StatementBegin beginExclusive() {
        return new StatementBegin(2);
    }

    public static StatementBegin beginImmediate() {
        return new StatementBegin(1);
    }

    public StatementBegin() {
        this.cppObj = createCppObj(0);
    }

    public StatementBegin(int r100) {
        this.cppObj = createCppObj(r100);
    }
}
