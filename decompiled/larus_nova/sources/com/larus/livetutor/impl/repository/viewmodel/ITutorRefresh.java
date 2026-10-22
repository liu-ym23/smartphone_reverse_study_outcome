package com.larus.livetutor.impl.repository.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes30.dex */
public interface ITutorRefresh<T> {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/livetutor/impl/repository/viewmodel/ITutorRefresh$RefreshStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "ACTIVE_REFRESH", "PASSIVE_REFRESH", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum RefreshStrategy extends Enum<RefreshStrategy> {
        public static final RefreshStrategy ACTIVE_REFRESH = null;
        public static final RefreshStrategy PASSIVE_REFRESH = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RefreshStrategy[] f356190a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f356191b = null;

        public static EnumEntries<RefreshStrategy> getEntries() {
            return f356191b;
        }

        static {
            RefreshStrategy r100 = new RefreshStrategy("ACTIVE_REFRESH", 0);
            ACTIVE_REFRESH = r100;
            RefreshStrategy r101 = new RefreshStrategy("PASSIVE_REFRESH", 1);
            PASSIVE_REFRESH = r101;
            RefreshStrategy[] r102 = {r100, r101};
            f356190a = r102;
            f356191b = EnumEntriesKt.enumEntries(r102);
        }

        public static RefreshStrategy[] values() {
            return (RefreshStrategy[]) f356190a.clone();
        }

        public static RefreshStrategy valueOf(String r100) {
            return (RefreshStrategy) r27.a.a(RefreshStrategy.class, r100);
        }

        public RefreshStrategy(String r100, int r101) {
            super(r100, r101);
        }
    }

    void refreshData(RefreshStrategy r100, T r101);

    void refreshData(RefreshStrategy r100, T r101, Function0<? extends LifecycleOwner> r102);
}
