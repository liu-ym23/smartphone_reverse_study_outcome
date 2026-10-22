package com.bytedance.ies.bullet.service.base;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f247895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f247896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f247897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f247898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function2<? super String, ? super JSONObject, Unit> f247899e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f247900f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f247901g;

    public static final class a {
    }

    static {
    }

    public /* synthetic */ q0() {
        this("AnnieX");
    }

    public q0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "containerName");
        this.f247895a = r100;
        this.f247896b = true;
        this.f247897c = "bullet_custom_bid";
        this.f247901g = true;
    }
}
