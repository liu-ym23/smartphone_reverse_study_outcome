package cp1;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.h;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements g.b<e> {
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2
    public final String debugName() {
        return "DynamicController";
    }

    public a(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g.b
    public final boolean a(a2 r100) {
        e r101 = (e) r100;
        Intrinsics.checkNotNullParameter(r101, "button");
        h r102 = r101.f115918j;
        if (r102 != null) goto L5;
    L7:
        return false;
    L5:
        if (r102.f115930a != 2) goto L7;
        return true;
    }
}
