package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.KMutableProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class KtvOpusSingerInfoView$onAttach$6 extends MutablePropertyReference1Impl {
    public static final KMutableProperty1 INSTANCE = null;

    static {
        INSTANCE = new KtvOpusSingerInfoView$onAttach$6();
    }

    public KtvOpusSingerInfoView$onAttach$6() {
        super(oe2.f.class, "avatarAnimShow", "getAvatarAnimShow()Z", 0);
    }

    public Object get(Object r1) {
        return Boolean.valueOf(((oe2.f) r1).d);
    }

    public void set(Object r1, Object r2) {
        boolean r3 = ((Boolean) r2).booleanValue();
        ((oe2.f) r1).d = r3;
    }
}
