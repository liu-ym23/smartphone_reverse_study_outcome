package com.larus.im.internal.jni.dependency;

import com.larus.im.internal.delegate.c1;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0010\u0006\n\u0002\u0010\u000b\n\u0002\b\n\b\u0001\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0007J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0007J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0007J\u001e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007J\u001e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007J\u001e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007J\u001e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007J\u001e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007J\u001e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007J\u001e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007J\u0018\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\u0018"}, d2 = {"Lcom/larus/im/internal/jni/dependency/OmniKevaCallByNative;", "", "<init>", "()V", "set", "", "key", "", "scope", "", "value", "repo", "", "", "", "getString", "getInt", "getLong", "getDouble", "getBoolean", "contains", "erase", "scopedKey", "Companion", "omnisdk-foundation_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniKevaCallByNative {
    private static final Companion Companion = null;
    public static final int USER_SCOPE = 1;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/larus/im/internal/jni/dependency/OmniKevaCallByNative$Companion;", "", "<init>", "()V", "USER_SCOPE", "", "omnisdk-foundation_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OmniKevaCallByNative() {
    }

    private final String scopedKey(String r100, int r101) {
        if (r101 != 1) goto L5;
        com.larus.im.internal.delegate.b r102 = com.larus.im.internal.delegate.b.f348193b;
        String r103 = r102.getUserId();
        String r104 = r102.j();
        boolean r105 = r102.a();
        boolean r106 = r102.e();
        com.larus.im.internal.delegate.a.f348188b.i("OmniKevaCallByNative", "userId:" + r103 + ",secId:" + r104 + ",isInMinorMode:" + r105 + ",isTouristMode:" + r106);
    L5:
        return r100;
    }

    public final boolean contains(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, "repo");
        return c1.f348202a.c(scopedKey(r100, r101), r102);
    }

    public final void erase(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, "repo");
        c1.f348202a.d(scopedKey(r100, r101), r102);
    }

    public final boolean getBoolean(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, "repo");
        return c1.f348202a.h(scopedKey(r100, r101), r102);
    }

    public final double getDouble(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, "repo");
        return c1.f348202a.g(scopedKey(r100, r101), r102);
    }

    public final int getInt(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, "repo");
        return c1.f348202a.f(scopedKey(r100, r101), 0, r102);
    }

    public final long getLong(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, "repo");
        return c1.f348202a.l(scopedKey(r100, r101), r102);
    }

    public final String getString(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, "repo");
        return c1.f348202a.a(scopedKey(r100, r101), "", r102);
    }

    public final void set(String r100, int r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        Intrinsics.checkNotNullParameter(r103, "repo");
        c1.f348202a.k(scopedKey(r100, r101), r102, r103);
    }

    public final void set(String r100, int r101, double r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r103, "repo");
        c1.f348202a.e(scopedKey(r100, r101), r102, r103);
    }

    public final void set(String r100, int r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r103, "repo");
        c1.f348202a.j(scopedKey(r100, r101), r102, r103);
    }

    public final void set(String r100, int r101, long r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r103, "repo");
        c1.f348202a.b(scopedKey(r100, r101), r102, r103);
    }

    public final void set(String r100, int r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r103, "repo");
        c1.f348202a.i(scopedKey(r100, r101), r102, r103);
    }
}
