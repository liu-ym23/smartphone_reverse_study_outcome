package com.bytedance.ee.bear.drive.biz.ai;

import com.ss.android.lark.inline.ai.api.InlineAIError;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import slb.h;
import slb.k;
import slb.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements k {
    public final /* synthetic */ Function0<Map<String, String>> a;
    public final /* synthetic */ Function0<List<h>> b;

    public final void onMessage(String r2) {
        Intrinsics.checkNotNullParameter(r2, "msg");
    }

    public final List<h> onFinish() {
        return (List) this.b.invoke();
    }

    public final l onStart() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll((Map) this.a.invoke());
        Unit r1 = Unit.INSTANCE;
        return new l(r0, 5);
    }

    public final void a(InlineAIError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        tt5.a.e("DriveInlineAICompat", "prompt execute error", r4, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function0<? extends Map<String, String>> r1, Function0<? extends List<? extends h>> r2) {
        this.a = r1;
        this.b = r2;
    }
}
