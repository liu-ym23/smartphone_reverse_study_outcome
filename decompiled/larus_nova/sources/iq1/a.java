package iq1;

import com.bytedance.android.livesdk.chatroom.vs_base.log.d;
import com.bytedance.android.livesdk.chatroom.vs_base.util.h;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashSet;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet<String> f495330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataCenter f495331b;

    public a(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f495331b = r100;
        this.f495330a = new HashSet();
    }

    public final void a(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        if (h.d(this.f495331b, true) == false) goto L5;
        String r102 = "portrait";
    L6:
        String r103 = r100 + '_' + r102;
        if (this.f495330a.contains(r103) == true) goto L10;
        this.f495330a.add(r103);
        d.a(this.f495331b).d(r100, r101, new Object[0]);
        return;
    L10:
        return;
    L5:
        r102 = "landscape";
        goto L6
    }
}
