package com.bytedance.ee.bear.middleground.comment.audio.voiceinput;

import android.content.DialogInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes18.dex */
public final class l implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f230432a;

    /* JADX WARN: Multi-variable type inference failed */
    public l(Function1<? super Boolean, Unit> r100) {
        this.f230432a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).j0();
        jg5.k.a.f499019a.a();
        this.f230432a.invoke(Boolean.FALSE);
    }
}
