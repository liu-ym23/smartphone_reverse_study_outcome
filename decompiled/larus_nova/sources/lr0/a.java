package lr0;

import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import com.bytedance.android.livehostapi.business.depend.openplatform.IEventListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class a implements IEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MiniGameContext f510385a;

    public a(MiniGameContext r100) {
        Intrinsics.checkNotNullParameter(r100, "appContext");
        this.f510385a = r100;
    }
}
