package o1b;

import com.bytedance.lark.pb.openplatform.v1.CommonGadgetPushRequest;
import com.ss.android.lark.chameleonv2.lkapi.transport.command.MyCommonGadgetPushRequest;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {
    public static final MyCommonGadgetPushRequest a(CommonGadgetPushRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        return new MyCommonGadgetPushRequest(r100.is_online.booleanValue(), r100.biz, r100.timestamp, r100.data);
    }
}
