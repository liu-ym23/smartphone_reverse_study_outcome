package com.bytedance.android.shopping.verify;

import android.text.TextUtils;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.ec.sdk.helper.r;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lh3.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00050\u0001¨\u0006\u0006"}, d2 = {"com/bytedance/android/shopping/verify/g$a", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<HashMap<String, Boolean>> {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00050\u0001¨\u0006\u0006"}, d2 = {"com/bytedance/android/shopping/verify/g$b", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b extends TypeToken<HashMap<String, Boolean>> {
        public b() {
        }
    }

    public static HashMap a() {
        int r0 = pi3.a.a;     // Catch: Exception -> L6
        HashMap r1 = (HashMap) new Gson().fromJson(q.a.getString("law_remote_authorized_map", ""), new a().getType());     // Catch: Exception -> L6
        if (r1 != null) goto L11;
        return new HashMap();
    L11:
        return r1;
    L6:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return new HashMap();
    }

    public static HashMap c() {
        int r0 = pi3.a.a;     // Catch: Exception -> L6
        HashMap r1 = (HashMap) new Gson().fromJson(q.a.getString("law_hint_map", ""), new b().getType());     // Catch: Exception -> L6
        if (r1 != null) goto L11;
        return new HashMap();
    L11:
        return r1;
    L6:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return new HashMap();
    }

    static {
    }

    public static String b(long r2) {
        String r0 = r.a.getCurrentUserId();
        SourceType.Companion.getClass();
        if (SourceType.a.c(r2) == true) goto L16;
        if (SourceType.a.b(r2) == true) goto L16;
        lh3.g r3 = h.a(r2);
        if (r3 == null) goto L10;
        String r4 = r3.a();
    L12:
        if (TextUtils.isEmpty(r4) == false) goto L18;
        return "unknown_type";
    L18:
        return Intrinsics.stringPlus(r4, r0);
    L10:
        r4 = null;
    L16:
        return "xiaodian" + r0;
    }
}
