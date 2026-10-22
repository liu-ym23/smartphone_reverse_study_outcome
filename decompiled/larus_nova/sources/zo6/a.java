package zo6;

import com.bytedance.locallife.common.utils.c;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f573132a;

    @Override // com.bytedance.locallife.common.utils.c.a
    public final void onFinish() {
    }

    @Override // com.bytedance.locallife.common.utils.c.a
    public final void onStart() {
    }

    @Override // com.bytedance.locallife.common.utils.c.a
    public final void onTick() {
        this.f573132a.invoke();
    }

    public a(Function0<Unit> r100) {
        this.f573132a = r100;
    }
}
