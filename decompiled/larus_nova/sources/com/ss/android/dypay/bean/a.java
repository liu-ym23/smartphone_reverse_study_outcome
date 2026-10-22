package com.ss.android.dypay.bean;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class a extends Lambda implements Function1<String, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f408455a;

    public a(JSONObject r100) {
        this.f408455a = r100;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public String invoke(String r100) {
        JSONObject r101 = this.f408455a;
        return r101.optString(r100);
    }
}
