package e00;

import com.bytedance.android.live.core.privacy.av.api.AudioAndVideoException;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements com.bytedance.android.live.core.privacy.av.api.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function2 f470633b;

    @Override // com.bytedance.android.live.core.privacy.av.api.b
    public final void b(String r100, String r101, String r102, Map<String, String> r103, com.bytedance.android.live.core.privacy.av.api.a r104) {
        Intrinsics.checkNotNullParameter(r100, "biz");
        Intrinsics.checkNotNullParameter(r101, "sense");
        Intrinsics.checkNotNullParameter(r102, "type");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r104, "config");
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.b
    public final void c(String r100, String r101, String r102, Map<String, String> r103, com.bytedance.android.live.core.privacy.av.api.a r104) {
        Intrinsics.checkNotNullParameter(r100, "biz");
        Intrinsics.checkNotNullParameter(r101, "sense");
        Intrinsics.checkNotNullParameter(r102, "type");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r104, "config");
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.b
    public final void d(String r100, String r101, String r102, Map<String, String> r103, com.bytedance.android.live.core.privacy.av.api.a r104) {
        Intrinsics.checkNotNullParameter(r100, "biz");
        Intrinsics.checkNotNullParameter(r101, "sense");
        Intrinsics.checkNotNullParameter(r102, "type");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r104, "config");
    }

    public a(Function2 r100) {
        this.f470633b = r100;
    }

    @Override // com.bytedance.android.live.core.privacy.av.api.b
    public final void a(String r100, String r101, String r102, Map r103, com.bytedance.android.live.core.privacy.av.api.a r104, AudioAndVideoException r105) {
        Intrinsics.checkNotNullParameter(r100, "biz");
        Intrinsics.checkNotNullParameter(r101, "sense");
        Intrinsics.checkNotNullParameter(r102, "type");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r104, "config");
        Intrinsics.checkNotNullParameter(r105, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        Function2 r106 = this.f470633b;
        if (r106 == null) goto L6;
        Unit r107 = (Unit) r106.invoke(r102, r105);
        return;
    }
}
