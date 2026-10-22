package com.bytedance.android.shopping.feed.resourcecard.frequency;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import sk.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "", "p1", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ResourceCardFreqController$canShow$2 extends FunctionReferenceImpl implements Function1<Integer, List<String>> {
    public ResourceCardFreqController$canShow$2(a r8) {
        super(1, r8, a.class, "getECInflowResourceCardClickRecord", "getECInflowResourceCardClickRecord(I)Ljava/util/List;", 0);
    }

    public final List<String> invoke(int r2) {
        ((a) ((CallableReference) this).receiver).getClass();
        return a.a(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke(((Number) r1).intValue());
    }
}
