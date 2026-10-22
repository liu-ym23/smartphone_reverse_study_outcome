package com.bytedance.pia.nsr;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes21.dex */
public final class f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f266515e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f266516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f266517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f266518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f266519d;

    public static final class a {
        public static f a(String r100) {
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
            Object r102 = Result.m9449constructorimpl(UriProtector.parse(r100));     // Catch: Throwable -> L4
        L6:
            List r103 = null;
            if (Result.m9452exceptionOrNullimpl(r102) != null) goto L18;
            Uri r104 = (Uri) r102;
            StringBuffer r105 = new StringBuffer();
            r105.append(r104.getScheme());
            r105.append("://");
            r105.append(r104.getAuthority());
            r105.append(r104.getPath());
            String r106 = r105.toString();
            String r107 = r104.getQuery();
            if (r107 == null) goto L11;
            r103 = StringsKt.split$default(r107, new char[]{Typography.amp}, false, 0, 6, null);
        L11:
            if (r103 != null) goto L13;
            TreeSet r108 = new TreeSet();
        L15:
            return new f(r106, r108);
        L13:
            r108 = new TreeSet(r103);
            goto L15
        L18:
            return null;
        L4:
            th = move-exception;
            Result.Companion r109 = Result.Companion;
            r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L6
        }
    }

    static {
    }

    public final int hashCode() {
        if (this.f266518c != null) goto L9;
        StringBuilder r100 = new StringBuilder();
        r100.append(this.f266516a);
        CollectionsKt.toSortedSet(this.f266517b);
        Iterator<T> r101 = this.f266517b.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        r100.append((String) r101.next());
        goto L6
    L8:
        this.f266518c = Integer.valueOf(r100.toString().hashCode());
    L9:
        Integer r102 = this.f266518c;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Int");
        return r102.intValue();
    }

    public final String toString() {
        if (this.f266519d != null) goto L18;
        StringBuilder r100 = new StringBuilder();
        r100.append(this.f266516a);
        if ((!this.f266517b.isEmpty()) == false) goto L7;
        r100.append('?');
    L7:
        CollectionsKt.toSortedSet(this.f266517b);
        Iterator<T> r101 = this.f266517b.iterator();
        int r102 = 0;
    L9:
        if (r101.hasNext() == false) goto L17;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();
    L13:
        r100.append((String) r103);
        if (r102 >= (this.f266517b.size() - 1)) goto L16;
        r100.append(Typography.amp);
    L16:
        r102 = r104;
        goto L9
    L17:
        this.f266519d = r100.toString();
    L18:
        String r105 = this.f266519d;
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.String");
        return r105;
    }

    public final boolean a(f r100) {
        if (Intrinsics.areEqual(this.f266516a, r100.f266516a) == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.f266517b.containsAll(this.f266517b) == false) goto L7;
        return true;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof String) == false) goto L7;
        return equals(a.a((String) r100));
    L7:
        if ((r100 instanceof f) == true) goto L9;
    L11:
        return false;
    L9:
        if (hashCode() != r100.hashCode()) goto L11;
        return true;
    }

    public f(String r100, Set<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "fullPath");
        Intrinsics.checkNotNullParameter(r101, "queries");
        this.f266516a = r100;
        this.f266517b = r101;
    }
}
