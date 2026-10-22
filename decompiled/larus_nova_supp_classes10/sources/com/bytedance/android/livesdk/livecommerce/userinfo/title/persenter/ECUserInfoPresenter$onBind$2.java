package com.bytedance.android.livesdk.livecommerce.userinfo.title.persenter;

import com.bytedance.android.livesdk.livecommerce.userinfo.title.state.ECUserInfoState;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECUserInfoPresenter$onBind$2 extends PropertyReference1Impl {
    public static final KProperty1 INSTANCE = null;

    static {
        INSTANCE = new ECUserInfoPresenter$onBind$2();
    }

    public ECUserInfoPresenter$onBind$2() {
        super(ECUserInfoState.class, "hasInit", "getHasInit()Z", 0);
    }

    public Object get(Object r1) {
        return Boolean.valueOf(((ECUserInfoState) r1).f);
    }
}
