package com.ss.android.lark.officesdk.minutes.service.foundation.network.mock;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.squareup.wire.Message;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003j\u0002`\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "Lcom/squareup/wire/Message;", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/core/internal/MmPBMessage;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/squareup/wire/Message;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class MmRecordingNetworkMockScenarioBuilder$onServerPb$1 extends Lambda implements Function1<Message<?, ?>, Boolean> {
    public static final MmRecordingNetworkMockScenarioBuilder$onServerPb$1 INSTANCE = null;

    static {
        INSTANCE = new MmRecordingNetworkMockScenarioBuilder$onServerPb$1();
    }

    public MmRecordingNetworkMockScenarioBuilder$onServerPb$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(Message<?, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return Boolean.TRUE;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Message<?, ?> r100) {
        return invoke2(r100);
    }
}
