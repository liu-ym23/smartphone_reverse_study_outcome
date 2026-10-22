package com.ss.android.lark.tab.service;

import com.amap.api.services.cloud.CloudSearch;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@UserScope
public final class ChatTabExtraService implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f441124a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/tab/service/ChatTabExtraService$LoadStrategy;", "", "<init>", "(Ljava/lang/String;I)V", CloudSearch.SearchBound.LOCAL_SHAPE, "TryLocal", "ForceServer", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LoadStrategy extends Enum<LoadStrategy> {
        public static final LoadStrategy ForceServer = null;
        public static final LoadStrategy Local = null;
        public static final LoadStrategy TryLocal = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LoadStrategy[] f441125a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f441126b = null;

        public static EnumEntries<LoadStrategy> getEntries() {
            return f441126b;
        }

        static {
            LoadStrategy r100 = new LoadStrategy(CloudSearch.SearchBound.LOCAL_SHAPE, 0);
            Local = r100;
            LoadStrategy r101 = new LoadStrategy("TryLocal", 1);
            TryLocal = r101;
            LoadStrategy r102 = new LoadStrategy("ForceServer", 2);
            ForceServer = r102;
            LoadStrategy[] r103 = {r100, r101, r102};
            f441125a = r103;
            f441126b = EnumEntriesKt.enumEntries(r103);
        }

        public static LoadStrategy[] values() {
            return (LoadStrategy[]) f441125a.clone();
        }

        public static LoadStrategy valueOf(String r100) {
            return (LoadStrategy) r27.a.a(LoadStrategy.class, r100);
        }

        public LoadStrategy(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    @Inject
    public ChatTabExtraService(k r100) {
        Intrinsics.checkNotNullParameter(r100, "repo");
        this.f441124a = r100;
    }
}
