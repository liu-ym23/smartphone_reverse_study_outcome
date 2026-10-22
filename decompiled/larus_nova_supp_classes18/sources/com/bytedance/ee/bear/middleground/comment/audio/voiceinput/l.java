package com.bytedance.ee.bear.middleground.comment.audio.voiceinput;

import android.content.DialogInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l implements DialogInterface.OnClickListener {
    public final /* synthetic */ Function1<Boolean, Unit> a;

    /* JADX WARN: Multi-variable type inference failed */
    public l(Function1<? super Boolean, Unit> r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).j0();
        jg5.k.a.a.a();
        this.a.invoke(Boolean.FALSE);
    }
}
