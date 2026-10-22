package o12;

import ca0.e;
import com.bytedance.android.scope.o;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements e, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.lynx.tasm.behavior.a> f521696a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public a() {
        this.f521696a = new ArrayList();
    }

    @Override // ca0.e
    public final List<com.lynx.tasm.behavior.a> getBehaviorList() {
        return this.f521696a;
    }
}
