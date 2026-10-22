package io.ktor.http;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes41.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f491860a = null;

    static {
        f491860a = CollectionsKt.listOf(new String[]{"***, dd MMM YYYY hh:mm:ss zzz", "****, dd-MMM-YYYY hh:mm:ss zzz", "*** MMM d hh:mm:ss YYYY", "***, dd-MMM-YYYY hh:mm:ss zzz", "***, dd-MMM-YYYY hh-mm-ss zzz", "***, dd MMM YYYY hh:mm:ss zzz", "*** dd-MMM-YYYY hh:mm:ss zzz", "*** dd MMM YYYY hh:mm:ss zzz", "*** dd-MMM-YYYY hh-mm-ss zzz", "***,dd-MMM-YYYY hh:mm:ss zzz", "*** MMM d YYYY hh:mm:ss zzz"});
    }

    public static final hsc.a a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = StringsKt.trim(r100).toString();
        Iterator<String> r102 = f491860a.iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        return new io.ktor.util.date.b(r102.next()).b(r100);
    L10:
        throw new IllegalStateException(("Failed to parse date: " + r101).toString());
    }
}
