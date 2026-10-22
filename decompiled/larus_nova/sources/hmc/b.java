package hmc;

import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWCustomData;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWDownlinkPacket;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWEventData;
import com.ss.ugc.live.sdk.msg.utils.c;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tlc.f;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f486058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f486059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UMGWDownlinkPacket f486060c;

    public final String a() {
        UMGWDownlinkPacket r100 = this.f486060c;
        int r101 = c.f458473a;
        if (r100 == null) goto L22;
        UMGWEventData r102 = r100.event_data;
        if (r102 == null) goto L23;
        List<UMGWCustomData> r103 = r102.params;
        if (r103 == null) goto L24;
        Iterator<T> r104 = r103.iterator();
    L10:
        if (r104.hasNext() == false) goto L14;
        Object r105 = r104.next();
        if (StringsKt.equals("biz_log_id", ((UMGWCustomData) r105).key, true) == false) goto L10;
    L15:
        UMGWCustomData r106 = (UMGWCustomData) r105;
        if (r106 != null) goto L18;
        return null;
    L18:
        return r106.value;
    L14:
        r105 = null;
        goto L15
    L24:
        return null;
    L23:
        return null;
    L22:
        return null;
    }

    public b(Object r100, UMGWDownlinkPacket r101) {
        Intrinsics.checkNotNullParameter(r101, "downlinkPacket");
        this.f486059b = r100;
        this.f486060c = r101;
    }
}
