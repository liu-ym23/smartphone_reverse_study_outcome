package com.bytedance.livesdk.preview;

import com.bytedance.android.livesdk.preview.s;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.HashMap;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000621\u0010\u0007\u001a-\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\bj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\t¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n¢\u0006\u0002\b\u000b"}, d2 = {"<anonymous>", "", "p1", "", "Lkotlin/ParameterName;", "name", "actionName", "p2", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "mobExtra", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class AbsPreviewDelegateViewHolder$4 extends FunctionReferenceImpl implements Function2<String, HashMap<String, String>, Unit> {
    public AbsPreviewDelegateViewHolder$4(a r100) {
        super(2, r100, a.class, "mobFunction", "mobFunction(Ljava/lang/String;Ljava/util/HashMap;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100, HashMap<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        Intrinsics.checkNotNullParameter(r101, "p2");
        ((a) this.receiver).getClass();
        Intrinsics.checkNotNullParameter(r100, "actionName");
        Intrinsics.checkNotNullParameter(r101, "mobExtra");
        s r102 = (s) k.n(s.class);
        throw null;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String r100, HashMap<String, String> r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
