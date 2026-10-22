package com.obric.assistant.omnidetailpage.localmedia;

import android.content.Context;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes33.dex */
public final class f implements Function1<String, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<String> f390831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f390832b;

    public f(kotlinx.coroutines.j r100, Context r101) {
        this.f390831a = r100;
        this.f390832b = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(String r100) {
        String r101 = r100;
        if (this.f390831a.isActive() == false) goto L10;
        kotlinx.coroutines.i<String> r102 = this.f390831a;
        if (r101 == null) goto L7;
        Context r103 = this.f390832b;
        LocalMediaShareHelper.f390800a.getClass();
        String r104 = LocalMediaShareHelper.a(r103, r101, true);
    L8:
        r102.resumeWith(Result.m9449constructorimpl(r104));
        goto L10
    L7:
        r104 = null;
    L10:
        return Unit.INSTANCE;
    }
}
