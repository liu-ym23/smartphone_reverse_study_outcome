package n20;

import com.bytedance.android.annie.service.appruntime.DegradeStatus;
import com.bytedance.android.livesdkapi.service.LevelAbility;
import com.facebook.keyframes.model.KFAnimation;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import y8.d;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements LevelAbility {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f516683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f516684b = null;

    public a() {
    }

    @Override // com.bytedance.android.livesdkapi.service.AtomicAbility
    public final void onPropertyChange(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
    }

    static {
        f516684b = new a();
    }

    @Override // com.bytedance.android.livesdkapi.service.LevelAbility
    public final boolean onLevelChange(int r100) {
        if (r100 >= 0) goto L5;
        f516683a = 1;
        int r101 = d.f566654a;
        d.a(DegradeStatus.liveDegrade, 1, 4);
    L6:
        return true;
    L5:
        f516683a = 0;
        int r102 = d.f566654a;
        d.b(DegradeStatus.liveDegrade);
        goto L6
    }
}
