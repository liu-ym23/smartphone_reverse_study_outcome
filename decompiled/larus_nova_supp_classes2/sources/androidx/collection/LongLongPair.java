package androidx.collection;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003H\u0086\nJ\t\u0010\u000b\u001a\u00020\u0003H\u0086\nJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Landroidx/collection/LongLongPair;", "", "first", "", "second", "<init>", "(JJ)V", "getFirst", "()J", "getSecond", "component1", "component2", "equals", "", "other", "hashCode", "", "toString", "", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LongLongPair {
    private final long first;
    private final long second;

    public int hashCode() {
        long r0 = this.first;
        int r1 = (int) (r0 ^ (r0 >>> 32));
        long r3 = this.second;
        return ((int) (r3 ^ (r3 >>> 32))) ^ r1;
    }

    public String toString() {
        return "(" + this.first + ", " + this.second + ')';
    }

    public final long component1() {
        return getFirst();
    }

    public final long component2() {
        return getSecond();
    }

    public final long getFirst() {
        return this.first;
    }

    public final long getSecond() {
        return this.second;
    }

    public boolean equals(Object r7) {
        if ((r7 instanceof LongLongPair) == true) goto L5;
        return false;
    L5:
        LongLongPair r8 = (LongLongPair) r7;
        if (r8.first == this.first) goto L8;
        return false;
    L8:
        if (r8.second != this.second) goto L12;
        return true;
    L12:
        return false;
    }

    public LongLongPair(long r1, long r3) {
        this.first = r1;
        this.second = r3;
    }
}
