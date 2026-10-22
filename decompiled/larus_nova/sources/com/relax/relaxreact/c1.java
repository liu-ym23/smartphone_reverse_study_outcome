package com.relax.relaxreact;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.keyframes.model.KFFeature;
import java.util.ArrayList;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c1 {
    public static final void a(ArrayList<n> r100) {
        Intrinsics.checkNotNullParameter(r100, KFFeature.EFFECT_JSON_FIELD);
        int r101 = 0;
        int r102 = 0;
    L3:
        IntCompanionObject r103 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r104 = r100.size();
        Intrinsics.checkNotNullParameter(r103, "<this>");
        if (r102 >= r104) goto L6;
        ((n) ListProtector.get(r100, r102)).a();
        r102 = r102 + 1;
    L6:
        IntCompanionObject r105 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r106 = r100.size();
        Intrinsics.checkNotNullParameter(r105, "<this>");
        if (r101 >= r106) goto L9;
        ((n) ListProtector.get(r100, r101)).getClass();
        r101 = r101 + 1;
        goto L6
    }
}
