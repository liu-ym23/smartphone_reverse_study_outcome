package com.bytedance.android.shopping.mall.homepage;

import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/android/shopping/api/mall/model/HomePageDTO;", "p2", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ECMallFragment$firstScreenFetch$2 extends FunctionReferenceImpl implements Function2<HomePageDTO, Boolean, Unit> {
    public ECMallFragment$firstScreenFetch$2(ECMallFragment r8) {
        super(2, r8, ECMallFragment.class, "checkHeaderCardType", "checkHeaderCardType(Lcom/bytedance/android/shopping/api/mall/model/HomePageDTO;Z)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((HomePageDTO) r1, ((Boolean) r2).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(HomePageDTO r3, boolean r4) {
        ECMallFragment r0 = (ECMallFragment) ((CallableReference) this).receiver;
        int r1 = ECMallFragment.h4;
        r0.Y90(r3, r4);
    }
}
