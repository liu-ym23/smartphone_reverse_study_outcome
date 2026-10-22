package com.relax.relaxreact.shared;

import com.bytedance.rts.kmp.foundation.r;
import java.util.ArrayList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f405582a = 0;

    public static final class a {
        public static void a(String... r110) {
            Intrinsics.checkNotNullParameter(r110, "content");
            ArrayList r100 = new ArrayList(ArraysKt.toList(r110));
            int r111 = r.f267614a;
            int r101 = b.f405582a;
            StringBuilder r102 = new StringBuilder("[Relax] ");
            Intrinsics.checkNotNullParameter(r100, "<this>");
            Intrinsics.checkNotNullParameter(" ", "separator");
            r102.append(CollectionsKt.joinToString$default(r100, " ", null, null, 0, null, null, 62, null));
            r.a.a(new Object[]{r102.toString()});
        }
    }

    static {
    }
}
