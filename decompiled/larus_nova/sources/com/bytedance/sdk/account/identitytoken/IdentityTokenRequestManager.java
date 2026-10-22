package com.bytedance.sdk.account.identitytoken;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes22.dex */
public final class IdentityTokenRequestManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f268910a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f268911b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile long f268912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final IdentityTokenRequestManager f268913d = null;

    static {
        f268910a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(IdentityTokenRequestManager.class), "degradeRequestCooldownMs", "getDegradeRequestCooldownMs()J"))};
        f268913d = new IdentityTokenRequestManager();
        f268911b = LazyKt.lazy(IdentityTokenRequestManager$degradeRequestCooldownMs$2.INSTANCE);
    }

    public IdentityTokenRequestManager() {
    }
}
