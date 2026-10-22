package com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class AsyncFetchResult<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f209050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EResultState f209051b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/viewmodel/fetch/async/AsyncFetchResult$EResultState;", "", "<init>", "(Ljava/lang/String;I)V", "LOADED", "LOADING", "TIMEOUT", "CANCEL", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum EResultState extends Enum<EResultState> {
        public static final EResultState CANCEL = null;
        public static final EResultState LOADED = null;
        public static final EResultState LOADING = null;
        public static final EResultState TIMEOUT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EResultState[] f209052a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f209053b = null;

        public static EnumEntries<EResultState> getEntries() {
            return f209053b;
        }

        static {
            EResultState r100 = new EResultState("LOADED", 0);
            LOADED = r100;
            EResultState r101 = new EResultState("LOADING", 1);
            LOADING = r101;
            EResultState r102 = new EResultState("TIMEOUT", 2);
            TIMEOUT = r102;
            EResultState r103 = new EResultState("CANCEL", 3);
            CANCEL = r103;
            EResultState[] r104 = {r100, r101, r102, r103};
            f209052a = r104;
            f209053b = EnumEntriesKt.enumEntries(r104);
        }

        public static EResultState[] values() {
            return (EResultState[]) f209052a.clone();
        }

        public static EResultState valueOf(String r100) {
            return (EResultState) r27.a.a(EResultState.class, r100);
        }

        public EResultState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AsyncFetchResult) == true) goto L8;
        return false;
    L8:
        AsyncFetchResult r101 = (AsyncFetchResult) r100;
        if (Intrinsics.areEqual(this.f209050a, r101.f209050a) == true) goto L12;
        return false;
    L12:
        if (this.f209051b == r101.f209051b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        T r100 = this.f209050a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.f209051b.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "AsyncFetchResult(data=" + this.f209050a + ", state=" + this.f209051b + ')';
    }

    public final boolean a() {
        if (this.f209051b != EResultState.LOADED) goto L5;
        return true;
    L5:
        return false;
    }

    public AsyncFetchResult(T r100, EResultState r101) {
        Intrinsics.checkNotNullParameter(r101, "state");
        this.f209050a = r100;
        this.f209051b = r101;
    }
}
