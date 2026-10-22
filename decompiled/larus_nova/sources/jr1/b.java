package jr1;

import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import d90.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b {
    public static final boolean a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isAnchor");
        DataCenter r101 = r100.f467480h;
        if (r101 == null) goto L7;
        Boolean r102 = (Boolean) r101.get("data_is_anchor", Boolean.FALSE);
        if (r102 == null) goto L7;
        return r102.booleanValue();
    L7:
        return false;
    }

    public static final boolean b(d r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isAudienceMediaRoom");
        DataCenter r101 = r100.f467480h;
        if (r101 == null) goto L11;
        IRoom r102 = a0.n(r101);
        if (r102 == null) goto L11;
        if (r102.isMediaRoom() != true) goto L11;
        if (a(r100) == true) goto L11;
        return true;
    L11:
        return false;
    }

    public static final boolean c(d r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isVSRoom");
        Intrinsics.checkNotNullParameter(r100, "$this$vsRoom");
        DataCenter r101 = r100.f467480h;
        IRoom r102 = null;
        if (r101 == null) goto L5;
        IRoom r103 = (IRoom) r101.get("data_room");
    L6:
        DataCenter r104 = r100.f467480h;
        if (r104 == null) goto L10;
        r102 = (IRoom) r104.get("data_prepare_room");
    L10:
        if (r103 == null) goto L12;
        long r105 = r103.getId();
    L14:
        if (r105 > 0) goto L17;
        r103 = r102;
    L17:
        if (r103 != null) goto L21;
        return false;
    L21:
        return r103.isMergeVSRoom();
    L12:
        r105 = 0;
        goto L14
    L5:
        r103 = null;
        goto L6
    }
}
