package com.bytedance.android.livesdk.link.model;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k1 {
    public static final /* synthetic */ KProperty[] a = null;
    public static final vh7.i b = null;

    static {
        KCallable[] r0 = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(k1.class, "_matchText", "get_matchText(Lcom/bytedance/android/livesdk/link/model/IBattleGetPanelAutoMatchInfo;)Lcom/bytedance/android/live/base/model/message/IText;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(k1.class, "_newAnchorMatchText", "get_newAnchorMatchText(Lcom/bytedance/android/livesdk/link/model/IBattleGetPanelAutoMatchInfo;)Lcom/bytedance/android/live/base/model/message/IText;", 1))};
        a = r0;
        int r1 = vh7.a.a;
        b = new vh7.i(new vh7.a.b(r0[0].getName()));
        Intrinsics.checkNotNullParameter(new vh7.a.b(r0[1].getName()), "keyImpl");
    }
}
