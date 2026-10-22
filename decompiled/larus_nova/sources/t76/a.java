package t76;

import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.f;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.h;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f544898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<f> f544899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f544900c;

    @Override // com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.h
    public final List<f> b() {
        return this.f544899b;
    }

    @Override // com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.h
    public final int getCurrentIndex() {
        return this.f544900c;
    }

    @Override // com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.h
    public final String getId() {
        return this.f544898a;
    }

    @Override // com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.h
    public final void a(int r100) {
        this.f544900c = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r100, List<? extends f> r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "dataSet");
        this.f544898a = r100;
        this.f544899b = r101;
        this.f544900c = r102;
    }
}
