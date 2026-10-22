package com.bytedance.live.livelink.kmp.impl.core.user;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import yf2.e;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lyf2/e;", "Lcom/bytedance/live/livelink/kmp/api/base/rtc/UserInfo;", "kotlin.jvm.PlatformType", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lyf2/e;)Z", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class LinkUserManager$removeUsersInAllRooms$1 extends Lambda implements Function1<e, Boolean> {
    final /* synthetic */ String $rtcUserId;

    public LinkUserManager$removeUsersInAllRooms$1(String r100) {
        this.$rtcUserId = r100;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(e r100) {
        return Boolean.valueOf(invoke2(r100));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(e r100) {
        return Intrinsics.areEqual(r100.f567435a, this.$rtcUserId);
    }
}
