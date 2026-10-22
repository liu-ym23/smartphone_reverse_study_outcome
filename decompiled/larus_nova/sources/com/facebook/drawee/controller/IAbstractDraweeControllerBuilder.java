package com.facebook.drawee.controller;

import com.facebook.common.internal.Supplier;
import com.facebook.drawee.interfaces.DraweePlaceHolderConfig;

/* JADX INFO: loaded from: classes3.dex */
public interface IAbstractDraweeControllerBuilder {
    Supplier<? extends AbstractDraweeControllerBuilder> getAbstractDraweeControllerBuilder();

    DraweePlaceHolderConfig getDraweePlaceHolderConfig();
}
