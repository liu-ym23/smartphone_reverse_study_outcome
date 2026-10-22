package kotlin.time;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086\u0002¢\u0006\u0004\b\f\u0010\nJ\b\u0010\r\u001a\u00020\u0004H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "()V", "reading", "", "overflow", "", "duration", "Lkotlin/time/Duration;", "overflow-LRDsOJo", "(J)V", "plusAssign", "plusAssign-LRDsOJo", "read", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TestTimeSource extends AbstractLongTimeSource {
    private long reading;

    public TestTimeSource() {
        super(DurationUnit.NANOSECONDS);
        markNow();
    }

    @Override // kotlin.time.AbstractLongTimeSource
    public long read() {
        return this.reading;
    }

    /* JADX INFO: renamed from: overflow-LRDsOJo, reason: not valid java name */
    private final void m10928overflowLRDsOJo(long r100) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.reading + DurationUnitKt__DurationUnitKt.shortName(getUnit()) + " is advanced by " + Duration.m10842toStringimpl(r100) + '.');
    }

    /* JADX INFO: renamed from: plusAssign-LRDsOJo, reason: not valid java name */
    public final void m10929plusAssignLRDsOJo(long r110) {
        long r100 = Duration.m10839toLongimpl(r110, getUnit());
        boolean r101 = true;
        if (((r100 - 1) | 1) != Long.MAX_VALUE) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L13;
        long r103 = this.reading;
        long r104 = r103 + r100;
        if ((r100 ^ r103) >= 0) goto L10;
    L12:
        this.reading = r104;
        return;
    L10:
        if ((r103 ^ r104) >= 0) goto L12;
        m10928overflowLRDsOJo(r110);
        goto L12
    L13:
        long r105 = Duration.m10796divUwyO8pc(r110, 2);
        if ((1 | (Duration.m10839toLongimpl(r105, getUnit()) - 1)) == Long.MAX_VALUE) goto L17;
        r101 = false;
    L17:
        if (r101 == true) goto L24;
        long r106 = this.reading;
        m10929plusAssignLRDsOJo(r105);     // Catch: IllegalStateException -> L21
        m10929plusAssignLRDsOJo(Duration.m10828minusLRDsOJo(r110, r105));     // Catch: IllegalStateException -> L21
        return;
    L21:
        e = move-exception;
        this.reading = r106;
        throw e;
    L24:
        m10928overflowLRDsOJo(r110);
        return;
    L5:
        r102 = false;
        goto L6
    }
}
