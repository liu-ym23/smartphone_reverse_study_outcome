package t3;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class h<T> implements Comparator {
    public h() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        com.bytedance.ai.bridge.method.device.a.C0687a r102 = (com.bytedance.ai.bridge.method.device.a.C0687a) r100;
        com.bytedance.ai.bridge.method.device.a.C0687a r103 = (com.bytedance.ai.bridge.method.device.a.C0687a) r101;
        return ComparisonsKt.compareValues(r102.f35442a + '-' + r102.f35443b + '-' + r102.f35444c, r103.f35442a + '-' + r103.f35443b + '-' + r103.f35444c);
    }
}
