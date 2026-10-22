package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.KMutableProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(k = 3, mv = {1, 5, 1})
final /* synthetic */ class KtvOpusSingerInfoView$onAttach$1 extends MutablePropertyReference1Impl {
    public static final KMutableProperty1 INSTANCE = null;

    static {
        INSTANCE = new KtvOpusSingerInfoView$onAttach$1();
    }

    public KtvOpusSingerInfoView$onAttach$1() {
        super(oe2.f.class, "singerName", "getSingerName()Ljava/lang/String;", 0);
    }

    public Object get(Object r1) {
        return ((oe2.f) r1).a;
    }

    public void set(Object r1, Object r2) {
        String r3 = (String) r2;
        ((oe2.f) r1).a = r3;
    }
}
