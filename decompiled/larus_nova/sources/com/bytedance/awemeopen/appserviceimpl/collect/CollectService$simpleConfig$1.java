package com.bytedance.awemeopen.appserviceimpl.collect;

import com.bytedance.awemeopen.bizmodels.user.c;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import d14.a;
import k34.b;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class CollectService$simpleConfig$1 extends Lambda implements Function0<String> {
    public static final CollectService$simpleConfig$1 INSTANCE = null;

    static {
        INSTANCE = new CollectService$simpleConfig$1();
    }

    public CollectService$simpleConfig$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        a r100 = a.f466374a;
        c r101 = ((b) a.a(b.class)).getAccessToken();
        if (r101 == null) goto L5;
        String r102 = r101.f198218b;
    L6:
        if (r102 != null) goto L9;
        return "";
    L9:
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }
}
