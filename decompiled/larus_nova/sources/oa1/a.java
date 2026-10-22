package oa1;

import com.bytedance.android.live.room.api.screenrotation.rotate.RotateInnerRequest;
import com.bytedance.android.live.room.api.screenrotation.rotate.d;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.distribution.EXTERNAL_CONFIG_TYPE;
import com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger;
import com.bytedance.android.livesdkapi.distribution.config.OrientationAction;
import com.bytedance.live.datacontext.n;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements c81.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f522529a = null;

    public a() {
    }

    @Override // c81.a
    public final String getTag() {
        return "RoomRotateInterceptor";
    }

    static {
        f522529a = new a();
    }

    @Override // c81.a
    public final boolean a(d r100, RotateInnerRequest r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "request");
        RoomContext r102 = r100.a();
        if (r102 == null) goto L11;
        n<IExternalConfigJudger> r103 = r102.getExternalConfigJudger();
        if (r103 == null) goto L13;
        IExternalConfigJudger r104 = r103.getValue();
        if (r104 != null) goto L9;
        return false;
    L9:
        if (r104.disable(EXTERNAL_CONFIG_TYPE.OrientationChange, OrientationAction.orientationChange) != true) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    L11:
        return false;
    }
}
