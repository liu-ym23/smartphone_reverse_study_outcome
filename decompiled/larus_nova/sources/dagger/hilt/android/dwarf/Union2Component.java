package dagger.hilt.android.dwarf;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes41.dex */
public class Union2Component<A, B> {

    /* JADX INFO: renamed from: component, reason: collision with root package name */
    private final Object f467778component;

    @Nonnull
    public Object getComponent() throws RuntimeException {
        return this.f467778component;
    }

    public Union2Component(@Nullable A r100, @Nullable B r101) throws IllegalArgumentException {
        if (r100 == null) goto L5;
        this.f467778component = r100;
        return;
    L5:
        if (r101 == null) goto L9;
        this.f467778component = r101;
        return;
    L9:
        throw new IllegalArgumentException("2 arguments can't be both null");
    }
}
