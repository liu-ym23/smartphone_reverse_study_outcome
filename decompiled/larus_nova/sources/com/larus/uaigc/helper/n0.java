package com.larus.uaigc.helper;

import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n0 f373045a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f373046b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Keva f373047c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f373048d = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f373049a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f373050b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f373049a, r101.f373049a) == true) goto L12;
            return false;
        L12:
            if (this.f373050b == r101.f373050b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f373049a.hashCode() * 31;
            long r101 = this.f373050b;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "DuplicateEntry(fileHash=" + this.f373049a + ", timestamp=" + this.f373050b + ')';
        }

        public a(String r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "fileHash");
            this.f373049a = r100;
            this.f373050b = r101;
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/uaigc/helper/UploadDuplicateStatStore$getEntriesInternal$1$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/larus/uaigc/helper/UploadDuplicateStatStore$DuplicateEntry;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b extends TypeToken<List<? extends a>> {
        public b() {
        }
    }

    public n0() {
    }

    static {
        f373045a = new n0();
        f373046b = LazyKt.lazy(new k0());
        f373047c = Keva.getRepo("upload_duplicate_stat_store", 0);
        f373048d = LazyKt.lazy(new l0());
    }

    public static List a() {
        String r100 = f373047c.getString("key_duplicate_entries", null);
        if (r100 == null) goto L5;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        Object r102 = Result.m9449constructorimpl((List) ((Gson) f373048d.getValue()).fromJson(r100, new b().getType()));     // Catch: Throwable -> L8
    L11:
        if (Result.m9452exceptionOrNullimpl(r102) == null) goto L15;
        r102 = CollectionsKt.emptyList();
    L15:
        return (List) r102;
    L8:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    L5:
        return CollectionsKt.emptyList();
    }
}
