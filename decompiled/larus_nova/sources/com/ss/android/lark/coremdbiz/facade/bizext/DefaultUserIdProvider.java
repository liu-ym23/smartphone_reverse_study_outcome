package com.ss.android.lark.coremdbiz.facade.bizext;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes35.dex */
public final class DefaultUserIdProvider implements Function0<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DefaultUserIdProvider f419977a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Function0<String> f419978b = null;

    public DefaultUserIdProvider() {
    }

    static {
        f419977a = new DefaultUserIdProvider();
        f419978b = DefaultUserIdProvider$delegate$1.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return f419978b.invoke();
    }
}
