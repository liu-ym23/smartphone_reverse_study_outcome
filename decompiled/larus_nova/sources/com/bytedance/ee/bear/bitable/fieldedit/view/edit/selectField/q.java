package com.bytedance.ee.bear.bitable.fieldedit.view.edit.selectField;

import com.bytedance.ee.bear.bitable.common.model.field.OptionItem;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import io.reactivex.functions.BiFunction;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class q<T1, T2, R> implements BiFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q<T1, T2, R> f211634a = null;

    static {
        f211634a = new q();
    }

    public q() {
    }

    @Override // io.reactivex.functions.BiFunction
    public final Object apply(Object r100, Object r101) {
        List r102 = (List) r100;
        String r103 = (String) r101;
        Intrinsics.checkNotNullParameter(r102, "optionsList");
        Intrinsics.checkNotNullParameter(r103, "optionIdsResult");
        String[] r104 = (String[]) GsonProtectorUtils.fromJson(new Gson(), r103, String[].class);
        int r105 = r104.length;
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L5;
        ((OptionItem) ListProtector.get(r102, r106)).setId(r104[r106]);
        r106 = r106 + 1;
        goto L3
    L5:
        return r102;
    }
}
