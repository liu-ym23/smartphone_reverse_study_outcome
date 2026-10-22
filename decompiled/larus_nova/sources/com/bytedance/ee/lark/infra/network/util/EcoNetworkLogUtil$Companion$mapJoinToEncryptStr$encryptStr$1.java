package com.bytedance.ee.lark.infra.network.util;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "entry", "", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class EcoNetworkLogUtil$Companion$mapJoinToEncryptStr$encryptStr$1 extends Lambda implements Function1<Map.Entry<? extends String, ? extends String>, CharSequence> {
    public static final EcoNetworkLogUtil$Companion$mapJoinToEncryptStr$encryptStr$1 INSTANCE = null;

    static {
        INSTANCE = new EcoNetworkLogUtil$Companion$mapJoinToEncryptStr$encryptStr$1();
    }

    public EcoNetworkLogUtil$Companion$mapJoinToEncryptStr$encryptStr$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(Map.Entry<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "entry");
        String r101 = r100.getKey();
        String r102 = null;
        if (r101 == null) goto L5;
        Set<String> r103 = a.f242810a;
        String r104 = a.C3479a.a(r101);
    L6:
        String r105 = r100.getValue();
        if (r105 == null) goto L10;
        Set<String> r106 = a.f242810a;
        r102 = a.C3479a.a(r105);
    L10:
        return r104 + " = " + r102;
    L5:
        r104 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(Map.Entry<? extends String, ? extends String> r100) {
        return invoke2(r100);
    }
}
