package dagger.internal;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes41.dex */
public final class SetBuilder<T> {
    private static final String SET_CONTRIBUTIONS_CANNOT_BE_NULL = "Set contributions cannot be null";
    private final List<T> contributions;

    public Set<T> build() {
        if (this.contributions.isEmpty() == false) goto L7;
        return Collections.emptySet();
    L7:
        if (this.contributions.size() != 1) goto L11;
        return Collections.singleton(ListProtector.get(this.contributions, 0));
    L11:
        return Collections.unmodifiableSet(new HashSet(this.contributions));
    }

    private SetBuilder(int r100) {
        this.contributions = new ArrayList(r100);
    }

    public static <T> SetBuilder<T> newSetBuilder(int r100) {
        return new SetBuilder(r100);
    }

    public SetBuilder<T> add(T r100) {
        this.contributions.add((T) Preconditions.checkNotNull(r100, SET_CONTRIBUTIONS_CANNOT_BE_NULL));
        return this;
    }

    public SetBuilder<T> addAll(Collection<? extends T> r100) {
        Iterator<? extends T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Preconditions.checkNotNull(r101.next(), SET_CONTRIBUTIONS_CANNOT_BE_NULL);
        goto L4
    L6:
        this.contributions.addAll(r100);
        return this;
    }
}
