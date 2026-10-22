package o1b;

import com.bytedance.lark.pb.openplatform.v1.PushAppsNeedUpdateRequest;
import com.ss.android.lark.chameleonv2.lkapi.transport.command.MyPushAppsNeedUpdateRequest;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d {
    public static final MyPushAppsNeedUpdateRequest a(PushAppsNeedUpdateRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        return new MyPushAppsNeedUpdateRequest(r100.timestamp);
    }
}
