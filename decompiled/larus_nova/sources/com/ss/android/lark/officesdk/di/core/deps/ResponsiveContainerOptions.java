package com.ss.android.lark.officesdk.di.core.deps;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class ResponsiveContainerOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f433180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f433181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BackgroundStrategy f433182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f433183d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/di/core/deps/ResponsiveContainerOptions$BackgroundStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "FORCE_HIDE", "FORCE_SHOW", "di-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum BackgroundStrategy extends Enum<BackgroundStrategy> {
        public static final BackgroundStrategy DEFAULT = null;
        public static final BackgroundStrategy FORCE_HIDE = null;
        public static final BackgroundStrategy FORCE_SHOW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BackgroundStrategy[] f433184a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f433185b = null;

        public static EnumEntries<BackgroundStrategy> getEntries() {
            return f433185b;
        }

        static {
            BackgroundStrategy r100 = new BackgroundStrategy("DEFAULT", 0);
            DEFAULT = r100;
            BackgroundStrategy r101 = new BackgroundStrategy("FORCE_HIDE", 1);
            FORCE_HIDE = r101;
            BackgroundStrategy r102 = new BackgroundStrategy("FORCE_SHOW", 2);
            FORCE_SHOW = r102;
            BackgroundStrategy[] r103 = {r100, r101, r102};
            f433184a = r103;
            f433185b = EnumEntriesKt.enumEntries(r103);
        }

        public static BackgroundStrategy[] values() {
            return (BackgroundStrategy[]) f433184a.clone();
        }

        public static BackgroundStrategy valueOf(String r100) {
            return (BackgroundStrategy) r27.a.a(BackgroundStrategy.class, r100);
        }

        public BackgroundStrategy(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BackgroundStrategy f433186a;

        public a() {
            this.f433186a = BackgroundStrategy.DEFAULT;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ResponsiveContainerOptions) == true) goto L8;
        return false;
    L8:
        ResponsiveContainerOptions r101 = (ResponsiveContainerOptions) r100;
        if (this.f433180a == r101.f433180a) goto L12;
        return false;
    L12:
        if (this.f433181b == r101.f433181b) goto L15;
        return false;
    L15:
        if (this.f433182c == r101.f433182c) goto L18;
        return false;
    L18:
        if (this.f433183d == r101.f433183d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f433180a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f433181b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (((r102 + r103) * 31) + this.f433182c.hashCode()) * 31;
        if (this.f433183d == true) goto L15;
        r100 = 1237;
    L15:
        return r104 + r100;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ResponsiveContainerOptions(insetsCompat=" + this.f433180a + ", swipeToDismissEnabled=" + this.f433181b + ", backgroundStrategy=" + this.f433182c + ", enableDynamicBackground=" + this.f433183d + ')';
    }

    public ResponsiveContainerOptions() {
        this(false, true, BackgroundStrategy.DEFAULT, false);
    }

    public ResponsiveContainerOptions(boolean r100, boolean r101, BackgroundStrategy r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r102, "backgroundStrategy");
        this.f433180a = r100;
        this.f433181b = r101;
        this.f433182c = r102;
        this.f433183d = r103;
    }
}
