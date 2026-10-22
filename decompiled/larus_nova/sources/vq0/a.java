package vq0;

import com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext;
import com.bytedance.android.livehostapi.business.depend.openplatform.IEventListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class a implements IEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MiniAppContext f556755a;

    public a(MiniAppContext r100) {
        Intrinsics.checkNotNullParameter(r100, "miniAppContext");
        this.f556755a = r100;
    }
}
