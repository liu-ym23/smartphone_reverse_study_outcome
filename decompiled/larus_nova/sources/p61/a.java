package p61;

import com.bytedance.android.live.room.api.experience.service.ILiveExpOptService;
import jc1.k;
import kotlin.jvm.JvmStatic;
import l61.c;
import l61.d;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f527865a;

    @JvmStatic
    public static final boolean a() {
        if (f527865a == false) goto L5;
        return false;
    L5:
        ILiveExpOptService r100 = (ILiveExpOptService) k.f(ILiveExpOptService.class);
        if (r100 == null) goto L13;
        c r101 = r100.getSceneState(null, d.a.a1.f507599e);
        if (r101 != null) goto L10;
        return false;
    L10:
        if (r101.a() != true) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    }

    static {
    }
}
