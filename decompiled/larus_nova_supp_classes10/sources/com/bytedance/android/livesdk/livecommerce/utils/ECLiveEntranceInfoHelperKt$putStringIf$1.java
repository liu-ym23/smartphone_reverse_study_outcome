package com.bytedance.android.livesdk.livecommerce.utils;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "old", "", "new", "invoke"}, k = 3, mv = {1, 4, 3})
final class ECLiveEntranceInfoHelperKt$putStringIf$1 extends Lambda implements Function2<Object, Object, Boolean> {
    final /* synthetic */ Function2 $condition;

    public ECLiveEntranceInfoHelperKt$putStringIf$1(Function2 r1) {
        this.$condition = r1;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return Boolean.valueOf(m1288invoke(r1, r2));
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final boolean m1288invoke(Object r4, Object r5) {
        if (r4 != null) goto L4;
    L5:
        if (r5 != null) goto L7;
    L11:
        Function2 r0 = this.$condition;
        if ((r4 instanceof String) == true) goto L14;
        r4 = null;
    L14:
        String r6 = (String) r4;
        if ((r5 instanceof String) == true) goto L18;
        r5 = null;
    L18:
        return ((Boolean) r0.invoke(r6, (String) r5)).booleanValue();
    L7:
        if ((r5 instanceof String) == true) goto L11;
        return false;
    L4:
        if ((r4 instanceof String) == true) goto L5;
        return false;
    }
}
