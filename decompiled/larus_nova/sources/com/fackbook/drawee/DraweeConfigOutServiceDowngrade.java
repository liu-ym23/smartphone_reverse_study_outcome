package com.fackbook.drawee;

import com.facebook.common.internal.Supplier;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/fackbook/drawee/DraweeConfigOutServiceDowngrade;", "Lcom/fackbook/drawee/IDraweeConfigOutService;", "<init>", "()V", "drawee_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final class DraweeConfigOutServiceDowngrade implements IDraweeConfigOutService {
    public DraweeConfigOutServiceDowngrade() {
    }

    @Override // com.fackbook.drawee.IDraweeConfigOutService
    public final Supplier<? extends AbstractDraweeControllerBuilder<?, ?, ?, ?>> getDraweeControllerBuilder() {
        return null;
    }
}
