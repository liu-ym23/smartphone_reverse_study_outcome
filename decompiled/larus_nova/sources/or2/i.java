package or2;

import com.bytedance.android.livesdkapi.model.PlayerFirstFrameInfo;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerClientContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LivePlayerClientContext f524925a;

    public final k a() {
        PlayerFirstFrameInfo r100 = this.f524925a.getFirstFrameInfo();
        if (r100 == null) goto L6;
        k r101 = new k();
        r101.f524929a = String.valueOf(r100.getTs());
        r101.f524930b = r100.getSei();
        return r101;
    L6:
        return null;
    }

    public i(LivePlayerClientContext r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f524925a = r100;
    }
}
