package com.bytedance.awemeopen.appserviceimpl.collect;

import com.bytedance.awemeopen.domain.base.repo.e;
import com.bytedance.awemeopen.domain.collect.c;
import com.bytedance.awemeopen.domain.collect.d;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public /* synthetic */ class CollectService$config$4 extends FunctionReferenceImpl implements Function4<String, Integer, String, Boolean, e<d>> {
    public CollectService$config$4(Object r100) {
        super(4, r100, c.class, "feedCollectOrUnCollect", "feedCollectOrUnCollect(Ljava/lang/String;ILjava/lang/String;Z)Lcom/bytedance/awemeopen/domain/base/repo/RepoResult;", 0);
    }

    public final e<d> invoke(String r100, int r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        Intrinsics.checkNotNullParameter(r102, "p2");
        ((c) this.receiver).getClass();
        return c.a(r100, r101, r102, r103);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ e<d> invoke(String r100, Integer r101, String r102, Boolean r103) {
        return invoke(r100, r101.intValue(), r102, r103.booleanValue());
    }
}
