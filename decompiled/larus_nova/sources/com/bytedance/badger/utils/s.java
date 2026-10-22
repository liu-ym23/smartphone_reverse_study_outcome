package com.bytedance.badger.utils;

import android.content.ServiceConnection;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
final class s extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ t f199283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ServiceConnection f199284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ServiceConnection f199285c;

    public s(t r100, ServiceConnection r101, ServiceConnection r102) {
        this.f199283a = r100;
        this.f199284b = r101;
        this.f199285c = r102;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        this.f199283a.f199289d.a(this.f199284b, this.f199285c);
        return Unit.INSTANCE;
    }
}
