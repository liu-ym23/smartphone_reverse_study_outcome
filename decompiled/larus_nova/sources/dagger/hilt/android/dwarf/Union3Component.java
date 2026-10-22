package dagger.hilt.android.dwarf;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes41.dex */
public class Union3Component<A, B, C> {

    /* JADX INFO: renamed from: component, reason: collision with root package name */
    private final Object f467779component;

    @Nonnull
    public Object getComponent() throws RuntimeException {
        return this.f467779component;
    }

    public Union3Component(@Nullable A r100, @Nullable B r101, @Nullable C r102) {
        if (r100 == null) goto L5;
        this.f467779component = r100;
        return;
    L5:
        if (r101 == null) goto L7;
        this.f467779component = r101;
        return;
    L7:
        if (r102 == null) goto L11;
        this.f467779component = r102;
        return;
    L11:
        throw new IllegalArgumentException("3 arguments can't be all null");
    }
}
