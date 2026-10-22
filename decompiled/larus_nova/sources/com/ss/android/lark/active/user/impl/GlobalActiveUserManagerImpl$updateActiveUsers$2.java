package com.ss.android.lark.active.user.impl;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.active.user.api.IGlobalActiveUserManager;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/active/user/api/IGlobalActiveUserManager$ActiveUsers;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
public final class GlobalActiveUserManagerImpl$updateActiveUsers$2 extends Lambda implements Function0<IGlobalActiveUserManager.a> {
    final /* synthetic */ List<User> $backgroundList;
    final /* synthetic */ IGlobalActiveUserManager.b $scene;

    /* JADX WARN: Multi-variable type inference failed */
    public GlobalActiveUserManagerImpl$updateActiveUsers$2(IGlobalActiveUserManager.b r100, List<? extends User> r101) {
        this.$scene = r100;
        this.$backgroundList = r101;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final IGlobalActiveUserManager.a invoke() {
        ((IGlobalActiveUserManager.b.a) this.$scene).getClass();
        throw null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ IGlobalActiveUserManager.a invoke() {
        return invoke();
    }
}
