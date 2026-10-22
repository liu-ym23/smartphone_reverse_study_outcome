package com.ss.android.lark.todo.impl.features.detail.customfields;

import android.app.Application;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class CustomFieldsTagColorHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f443038a = null;

    public CustomFieldsTagColorHelper() {
    }

    static {
        f443038a = LazyKt.lazy(CustomFieldsTagColorHelper$colorList$2.INSTANCE);
    }

    public static c b(int r100) {
        if (r100 >= 0) goto L4;
    L6:
        boolean r101 = false;
    L7:
        if (r101 == false) goto L9;
        Object r102 = ListProtector.get((ArrayList) f443038a.getValue(), r100);
        Intrinsics.checkNotNull(r102);
        return (c) r102;
    L9:
        UDTagsDrawable.TagColorSet r103 = UDTagsDrawable.TagColorSet.BLUE;
        return new c(r103.getBackgroundColorRes(), r103.getTextColorRes());
    L4:
        if (r100 >= ((ArrayList) f443038a.getValue()).size()) goto L6;
        r101 = true;
        goto L7
    }

    public static final int a(String r100, int r101) {
        Application r102 = com.larksuite.framework.utils.b.f285948a;
        Intrinsics.checkNotNull(r102);
        int r103 = UDColorUtils.getColorIdByToken(r102, "ud_" + r100);
        if (r103 > 0) goto L9;
        int r104 = UDColorUtils.getColorIdByToken(r102, r100);
        if (r104 > 0) goto L8;
        return r101;
    L8:
        return r104;
    L9:
        return r103;
    }
}
