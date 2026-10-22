package j62;

import com.bytedance.android.livesdk.interactivity.common.utils.LimitQueue;
import com.bytedance.android.livesdk.interactivity.service.messagelist.c;
import com.bytedance.android.livesdk.interactivity.service.messagelist.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LimitQueue f497491a;

    public b() {
        this.f497491a = new LimitQueue(512);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.d
    public final boolean a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        long r101 = r100.getId();
        if (r101 != (-1)) goto L6;
        return false;
    L6:
        boolean r102 = this.f497491a.contains(Long.valueOf(r101));
        if (r102 == false) goto L10;
        return true;
    L10:
        this.f497491a.add(Long.valueOf(r101));
        return r102;
    }
}
