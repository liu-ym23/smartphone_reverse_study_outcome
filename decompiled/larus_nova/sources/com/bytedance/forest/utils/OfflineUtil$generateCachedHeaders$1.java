package com.bytedance.forest.utils;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "headerKey", "headers", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class OfflineUtil$generateCachedHeaders$1 extends Lambda implements Function2<String, Map<String, ? extends String>, String> {
    public static final OfflineUtil$generateCachedHeaders$1 INSTANCE = null;

    static {
        INSTANCE = new OfflineUtil$generateCachedHeaders$1();
    }

    public OfflineUtil$generateCachedHeaders$1() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(String r100, Map<String, String> r101) {
        if (r101 == null) goto L6;
        String r102 = r101.get(r100);
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ String invoke(String r100, Map<String, ? extends String> r101) {
        return invoke2(r100, r101);
    }
}
