package mr2;

import com.bytedance.android.live.profit.player.n;
import com.bytedance.android.livesdk.message.model.gb;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements gb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f514975a;

    public a(n r100) {
        this.f514975a = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.gb.a
    public final void a(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        this.f514975a.f88343c.invoke(r100);
    }
}
