package com.ss.android.lark.chat.api.service.impl.usergroup;

import com.bytedance.lark.pb.im.v1.PushUserGroupEntitiesRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class UserGroupPush$startPush$1$1 extends FunctionReferenceImpl implements Function1<PushUserGroupEntitiesRequest, Unit> {
    public UserGroupPush$startPush$1$1(Object r100) {
        super(1, r100, UserGroupPush.class, "onPush", "onPush(Lcom/bytedance/lark/pb/im/v1/PushUserGroupEntitiesRequest;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PushUserGroupEntitiesRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        UserGroupPush r101 = (UserGroupPush) this.receiver;
        r101.f411667c.execute(new d(r101, r100));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PushUserGroupEntitiesRequest r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
