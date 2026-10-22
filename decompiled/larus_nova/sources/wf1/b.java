package wf1;

import android.os.Bundle;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.config.b8;
import com.bytedance.android.livesdk.config.zq;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements wf1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f559461a;

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // wf1.a
    public final int c() {
        return 1000;
    }

    @Override // wf1.a
    public final void reset() {
        this.f559461a = 0;
    }

    @Override // wf1.a
    public final boolean d() {
        if (this.f559461a < 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // wf1.a
    public final void b(int r100) {
        if (r100 != 1) goto L5;
        this.f559461a++;
        return;
    L5:
        if (r100 != 2) goto L11;
        this.f559461a++;
        return;
    }

    @Override // wf1.a
    public final boolean a(Bundle r100, boolean r101) {
        if (tb1.c.f545229a == true) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(zq.f121784a.getValue(), Boolean.TRUE) == false) goto L24;
        String r102 = ((IMiddlewareLiveService) k.n(IMiddlewareLiveService.class)).getLiveOntologyRecord().getEnterFromMerge();
        if (b8.f119847a.getValue().booleanValue() == false) goto L17;
        if (Intrinsics.areEqual(r102, "homepage_tablive") == false) goto L11;
    L14:
        return true;
    L11:
        if (Intrinsics.areEqual(r102, UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT) == true) goto L14;
        if (Intrinsics.areEqual(r102, "live_merge") == true) goto L14;
        return false;
    L17:
        if (Intrinsics.areEqual(r102, "live_merge") == false) goto L19;
    L20:
        return true;
    L19:
        if (Intrinsics.areEqual(r102, UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT) == true) goto L20;
        return false;
    L24:
        return false;
    }
}
