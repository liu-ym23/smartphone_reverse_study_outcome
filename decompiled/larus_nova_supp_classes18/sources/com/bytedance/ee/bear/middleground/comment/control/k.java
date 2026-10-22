package com.bytedance.ee.bear.middleground.comment.control;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.middleground.comment.reaction.ReactionDataEntity;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k<T, R> implements Function {
    public static final k<T, R> a = null;

    static {
        a = new k();
    }

    public k() {
    }

    public final Object apply(Object r2) {
        String r3 = (String) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        ReactionDataEntity.Entity r0 = ((ReactionDataEntity) JSON.parseObject(r3, ReactionDataEntity.class)).getData();
        if (r0 == null) goto L13;
        ReactionDataEntity.Entity.BodyEntity r1 = r0.getBody();
        if (r1 == null) goto L13;
        Integer r4 = r1.getCode();
        if (r4 == null) goto L13;
        if (r4.intValue() != 0) goto L13;
        return "success";
    L13:
        throw new RuntimeException(r3);
    }
}
