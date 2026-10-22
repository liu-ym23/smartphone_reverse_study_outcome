package com.bytedance.ee.bear.tts.impl.model;

import com.bytedance.ee.bear.tts.meta.TtsMetaBean;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class TtsMetaModel {
    public final String a;
    public final int b;
    public TtsMetaBean c;
    public boolean d;
    public Throwable e;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "TtsMetaModel@" + hashCode() + "{metaBean: " + this.c + ", isLoaded: " + this.d + '}';
    }

    public TtsMetaModel(TtsMetaBean r2) {
        Intrinsics.checkNotNullParameter(r2, "metaBean");
        this.a = r2.getObjToken();
        this.b = r2.getObjType();
        this.c = r2;
    }

    public final Object a(Continuation<? super TtsMetaBean> r4) {
        return BuildersKt.withContext(Dispatchers.getIO(), new TtsMetaModel$reload$2(this, null), r4);
    }

    public TtsMetaModel(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "docToken");
        this.a = r2;
        this.b = r3;
        this.c = null;
    }
}
