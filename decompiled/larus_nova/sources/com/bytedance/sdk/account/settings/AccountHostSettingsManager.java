package com.bytedance.sdk.account.settings;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class AccountHostSettingsManager extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f269316a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f269317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f269318c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AccountHostSettingsManager f269319d = null;

    public static final class a extends c {
        public a() {
        }
    }

    static {
        f269316a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AccountHostSettingsManager.class), "tokenInitDecisionCache", "getTokenInitDecisionCache()I"))};
        f269319d = new AccountHostSettingsManager();
        f269317b = new a();
        f269318c = LazyKt.lazy(AccountHostSettingsManager$tokenInitDecisionCache$2.INSTANCE);
    }

    public final int a() {
        Lazy r100 = f269318c;
        KProperty r101 = f269316a[0];
        return ((Number) r100.getValue()).intValue();
    }

    public AccountHostSettingsManager() {
    }
}
