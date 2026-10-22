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

/* JADX INFO: loaded from: classes16.dex */
public final class a implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Map<String, String>> f222589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0<List<h>> f222590b;

    @Override // slb.k
    public final void onMessage(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
    }

    @Override // slb.k
    public final List<h> onFinish() {
        return this.f222590b.invoke();
    }

    @Override // slb.k
    public final l onStart() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.putAll(this.f222589a.invoke());
        Unit r101 = Unit.INSTANCE;
        return new l(r100, 5);
    }

    @Override // slb.k
    public final void a(InlineAIError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        tt5.a.e("DriveInlineAICompat", "prompt execute error", r100, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function0<? extends Map<String, String>> r100, Function0<? extends List<? extends h>> r101) {
        this.f222589a = r100;
        this.f222590b = r101;
    }
}
