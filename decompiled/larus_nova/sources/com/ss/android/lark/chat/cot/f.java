package com.ss.android.lark.chat.cot;

import com.ss.android.lark.chat.entity.message.CotContent;
import com.ss.android.lark.log.Log;
import kotlin.collections.CollectionsKt;
import kotlin.collections.GroupingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class f {
    static {
    }

    @JvmStatic
    public static final String d(CotContent r110) {
        StringBuilder r100 = new StringBuilder("cotId=");
        r100.append(r110.getCotId());
        r100.append(", status=");
        r100.append(r110.getStatus());
        r100.append(", events=");
        r100.append(r110.getEvents().size());
        r100.append(", incomplete=");
        r100.append(r110.getCotEventsIncomplete());
        r100.append(", types=");
        if (r110.getEvents().isEmpty() == false) goto L5;
        String r111 = "empty";
    L6:
        r100.append(r111);
        return r100.toString();
    L5:
        r111 = CollectionsKt.joinToString$default(CollectionsKt.sortedWith(GroupingKt.eachCount(new d(r110.getEvents())).entrySet(), new e()), ",", null, null, 8, "...", CotLog$eventTypeSummary$3.INSTANCE, 6, null);
        goto L6
    }

    @JvmStatic
    public static final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "stage");
        Intrinsics.checkNotNullParameter(r101, "message");
        Log.d("CotChain", "[" + r100 + "] " + r101);
    }

    @JvmStatic
    public static final void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "stage");
        Intrinsics.checkNotNullParameter(r101, "message");
        Log.i("CotChain", "[" + r100 + "] " + r101);
    }

    @JvmStatic
    public static final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "stage");
        Intrinsics.checkNotNullParameter(r101, "message");
        Log.w("CotChain", "[" + r100 + "] " + r101);
    }

    @JvmStatic
    public static final void b(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "stage");
        Intrinsics.checkNotNullParameter(r101, "message");
        Log.e("CotChain", "[" + r100 + "] " + r101, r102);
    }
}
