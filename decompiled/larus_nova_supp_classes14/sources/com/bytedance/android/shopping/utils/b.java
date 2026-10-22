package com.bytedance.android.shopping.utils;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.shopping.anchorv3.ExceptionFixer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static final /* synthetic */ int e = 0;
    public JSONObject a;
    public final JSONArray b;
    public final JSONArray c;
    public final JSONArray d;

    public static final class a {
        public a() {
        }

        public static void a(String r3) {
            int r0 = b.e;
            Intrinsics.checkNotNullParameter(r3, "message");
            if (PdpPerfOpt.e() == true) goto L7;
            xh.a r1 = xh.c.a("Detail");
            xh.b r2 = new xh.b();
            r2.c("AnchorV4CrashHelper");
            r2.b("Default");
            r2.a(r3);
            r1.f(4, r2);
            return;
        }
    }

    static {
        new a();
    }

    public final String toString() {
        JSONObject r0 = new JSONObject();
        r0.put("TAG", "AnchorV4CrashHelper");
        r0.put("recyclerViewInfo", this.a);
        JSONObject r1 = new JSONObject();
        r1.put("cvoRecords", this.b);
        r1.put("requestRecords", this.c);
        r1.put("gulRecords", this.d);
        Unit r2 = Unit.INSTANCE;
        r0.put("pdpInfo", r1);
        return r0.toString();
    }

    public b() {
        this.a = new JSONObject();
        this.b = new JSONArray();
        this.c = new JSONArray();
        this.d = new JSONArray();
    }

    public final void a(RecyclerView r19, StaggeredGridLayoutManager r20) {
        Intrinsics.checkNotNullParameter(r19, "recyclerView");
        Intrinsics.checkNotNullParameter(r20, "layoutManager");
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L18
        this.a = new JSONObject();     // Catch: Throwable -> L18
        Object r5 = ExceptionFixer.b(r20, "mLazySpanLookup", ExceptionFixer.a, null);     // Catch: Throwable -> L18
        Object r6 = ExceptionFixer.b(r5, "mData", ExceptionFixer.b, null);     // Catch: Throwable -> L18
        Object r7 = ExceptionFixer.b(r5, "mFullSpanItems", ExceptionFixer.c, null);     // Catch: Throwable -> L18
        if ((r6 instanceof int[]) == false) goto L7;
        this.a.put("mLazySpanLookup.mData.size", ((int[]) r6).length);     // Catch: Throwable -> L18
    L7:
        if ((r7 instanceof List) == true) goto L9;
        r7 = null;
    L9:
        List r8 = (List) r7;     // Catch: Throwable -> L18
        if (r8 == null) goto L16;
        JSONArray r9 = new JSONArray();     // Catch: Throwable -> L18
        Iterator r10 = r8.iterator();     // Catch: Throwable -> L18
    L13:
        if (r10.hasNext() == false) goto L15;
        r9.put(ExceptionFixer.b(r10.next(), "mPosition", ExceptionFixer.d, null));     // Catch: Throwable -> L18
        goto L13
    L15:
        this.a.put("mLazySpanLookup.mFullSpanItems", r9);     // Catch: Throwable -> L18
    L16:
        JSONObject r11 = this.a;     // Catch: Throwable -> L18
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L18
        r12.put("childCount", r19.getChildCount());     // Catch: Throwable -> L18
        int[] r3 = new int[r20.getSpanCount()];     // Catch: Throwable -> L18
        Arrays.fill(r3, -1);     // Catch: Throwable -> L18
        r20.findFirstVisibleItemPositions(r3);     // Catch: Throwable -> L18
        r12.put("firstVisiblePosition", CollectionsKt.joinToString$default(ArraysKt.toList(r3), null, null, null, 0, null, null, 63, null));     // Catch: Throwable -> L18
        Arrays.fill(r3, -1);     // Catch: Throwable -> L18
        r20.findLastVisibleItemPositions(r3);     // Catch: Throwable -> L18
        r12.put("lastVisiblePosition", CollectionsKt.joinToString$default(ArraysKt.toList(r3), null, null, null, 0, null, null, 63, null));     // Catch: Throwable -> L18
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L18
        Result.constructor-impl(r11.put("recyclerView", r12));     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
