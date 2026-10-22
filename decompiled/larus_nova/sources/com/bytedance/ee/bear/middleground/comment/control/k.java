package com.bytedance.ee.bear.middleground.comment.control;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.middleground.comment.reaction.ReactionDataEntity;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class k<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k<T, R> f231228a = null;

    static {
        f231228a = new k();
    }

    public k() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        String r101 = (String) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        ReactionDataEntity.Entity r102 = ((ReactionDataEntity) JSON.parseObject(r101, ReactionDataEntity.class)).getData();
        if (r102 == null) goto L13;
        ReactionDataEntity.Entity.BodyEntity r103 = r102.getBody();
        if (r103 == null) goto L13;
        Integer r104 = r103.getCode();
        if (r104 == null) goto L13;
        if (r104.intValue() != 0) goto L13;
        return "success";
    L13:
        throw new RuntimeException(r101);
    }
}
