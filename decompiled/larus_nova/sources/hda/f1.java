package hda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class f1 {

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            e1 r102 = (e1) r101;
            JSONObject r103 = f1.c(r102);
            if (r103 == null) goto L5;
            int r104 = r103.optInt("snapshotVersion", r102.f484671q + 1);
        L6:
            Integer r105 = Integer.valueOf(r104);
            e1 r106 = (e1) r100;
            JSONObject r107 = f1.c(r106);
            if (r107 == null) goto L9;
            int r108 = r107.optInt("snapshotVersion", r106.f484671q + 1);
        L11:
            return ComparisonsKt.compareValues(r105, Integer.valueOf(r108));
        L9:
            r108 = r106.f484671q + 1;
            goto L11
        L5:
            r104 = r102.f484671q + 1;
            goto L6
        }
    }

    public static final class b<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f484676a;

        public b(a r100) {
            this.f484676a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            int r102 = this.f484676a.compare(r100, r101);
            if (r102 != 0) goto L14;
            JSONObject r103 = f1.c((e1) r101);
            long r104 = 0;
            if (r103 == null) goto L8;
            long r105 = r103.optLong("snapshotTime", 0);
        L9:
            Long r106 = Long.valueOf(r105);
            JSONObject r107 = f1.c((e1) r100);
            if (r107 == null) goto L13;
            r104 = r107.optLong("snapshotTime", 0);
        L13:
            return ComparisonsKt.compareValues(r106, Long.valueOf(r104));
        L8:
            r105 = 0;
            goto L9
        L14:
            return r102;
        }
    }

    public static final class c<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f484677a;

        public c(b r100) {
            this.f484677a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            int r102 = this.f484677a.compare(r100, r101);
            if (r102 != 0) goto L15;
            long r103 = StringsKt.toLongOrNull(((e1) r101).f484655a);
            if (r103 != null) goto L9;
            r103 = 0L;
        L9:
            long r104 = StringsKt.toLongOrNull(((e1) r100).f484655a);
            if (r104 != null) goto L14;
            r104 = 0L;
        L14:
            return ComparisonsKt.compareValues(r103, r104);
        L15:
            return r102;
        }
    }

    public static final JSONObject c(e1 r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl(new JSONObject(r100.f484673s));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r102) == false) goto L10;
        r102 = null;
    L10:
        return (JSONObject) r102;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static final List<e1> d(List<e1> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (((ArrayList) r100).size() > 1) goto L6;
        return r100;
    L6:
        return CollectionsKt.sortedWith(r100, new c(new b(new a())));
    }

    public static final String a(JSONObject r100, String... r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "keys");
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        String r104 = p0.b(r100, r101[r103]);
        if (r104 != null) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static final void b(JSONArray r100, Function1<? super JSONObject, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "block");
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        JSONObject r104 = r100.optJSONObject(r103);
        if (r104 == null) goto L7;
        r101.invoke(r104);
    L7:
        r103 = r103 + 1;
        goto L3
    }
}
