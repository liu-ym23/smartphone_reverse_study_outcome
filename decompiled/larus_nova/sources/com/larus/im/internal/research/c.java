package com.larus.im.internal.research;

import com.larus.im.bean.message.block.Block;
import com.larus.im.internal.AbsProcessor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c extends AbsProcessor<mf9.c> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f349802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final mf9.a<mf9.c> f349803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f349804d;

    public c(String r100, mf9.a<mf9.c> r101) {
        Intrinsics.checkNotNullParameter(r100, "resourceId");
        super(r101);
        this.f349802b = r100;
        this.f349803c = r101;
        this.f349804d = "GetResourceProcessor";
        kuc.a.b(Block.Companion.serializer());
    }
}
