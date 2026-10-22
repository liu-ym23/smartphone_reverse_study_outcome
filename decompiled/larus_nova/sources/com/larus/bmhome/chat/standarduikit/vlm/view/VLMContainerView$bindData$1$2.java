package com.larus.bmhome.chat.standarduikit.vlm.view;

import android.os.Handler;
import com.larus.utils.y;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class VLMContainerView$bindData$1$2 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    public VLMContainerView$bindData$1$2(Object r100) {
        super(1, r100, VLMContainerView.class, "onUserScrollImage", "onUserScrollImage(I)V", 0);
    }

    public final void invoke(int r100) {
        final VLMContainerView r101 = (VLMContainerView) this.receiver;
        int r102 = VLMContainerView.f309880k;
        Map<Integer, Integer> r103 = r101.y();
        LinkedHashMap r104 = (LinkedHashMap) r103;
        final Integer r105 = (Integer) r104.get(Integer.valueOf(r100));
        if (r105 == null) goto L6;
        r105.intValue();
        SoftReference<Handler> r106 = y.f375498a;
        Runnable r107 = new f(r101, r105);
        Intrinsics.checkNotNullParameter(r107, "action");
        y.d(r107, 200);
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100) {
        invoke(r100.intValue());
        return Unit.INSTANCE;
    }
}
