package ws0;

import android.content.Context;
import com.bytedance.android.livesdkapi.jsb.IJsMethodsProvideService;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import n56.c;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements IJsMethodsProvideService.IFactory {
    public b() {
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IJsMethodsProvideService.IFactory
    public final Map<String, c> buildMethods(WeakReference<Context> r100, n56.a r101) {
        return MapsKt.mapOf(TuplesKt.to("crossplatformOpenLiveProfile", new a(r100)));
    }
}
