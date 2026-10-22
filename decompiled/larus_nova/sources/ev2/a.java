package ev2;

import com.bytedance.android.live.room.api.screenrotation.rotate.RotateInnerRequest;
import com.bytedance.android.live.room.api.screenrotation.rotate.d;
import com.bytedance.android.livesdk.vscore_impl.paidlive.scene.BasePaidScene;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements c81.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BasePaidScene f474231a;

    @Override // c81.a
    public final String getTag() {
        return "paid_live";
    }

    public a(BasePaidScene r100) {
        Intrinsics.checkNotNullParameter(r100, "roomScene");
        this.f474231a = r100;
    }

    @Override // c81.a
    public final boolean a(d r100, RotateInnerRequest r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "request");
        if (this.f474231a.o2().a() == true) goto L6;
        return true;
    L6:
        return false;
    }
}
