package wc2;

import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.android.livesdkapi.jsb.ExternalJsBridgeMethodFactory;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends BaseJsBridgeMethodFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f559067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExternalJsBridgeMethodFactory f559068b;

    @Override // com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory
    public final Map<String, n56.c> provideLegacyMethods(IJsBridgeManager r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        if (this.f559068b.getPreventNamespace() == true) goto L12;
        Map<String, n56.c> r101 = this.f559068b.provideLegacyMethods();
        LinkedHashMap r102 = new LinkedHashMap(MapsKt.mapCapacity(r101.size()));
        Iterator<T> r103 = r101.entrySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L10;
        Map.Entry r104 = (Map.Entry) r103.next();
        r102.put("ext_" + this.f559067a + '_' + ((String) r104.getKey()), r104.getValue());
        goto L7
    L10:
        return r102;
    L12:
        return this.f559068b.provideLegacyMethods();
    }

    @Override // com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory
    public final Map<String, f.b> provideStatefulMethods(IJsBridgeManager r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        if (this.f559068b.getPreventNamespace() == true) goto L12;
        Map<String, f.b> r101 = this.f559068b.provideStatefulMethods();
        LinkedHashMap r102 = new LinkedHashMap(MapsKt.mapCapacity(r101.size()));
        Iterator<T> r103 = r101.entrySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L10;
        Map.Entry r104 = (Map.Entry) r103.next();
        r102.put("ext_" + this.f559067a + '_' + ((String) r104.getKey()), r104.getValue());
        goto L7
    L10:
        return r102;
    L12:
        return this.f559068b.provideStatefulMethods();
    }

    @Override // com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory
    public final Map<String, g<?, ?>> provideStatelessMethods(IJsBridgeManager r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        if (this.f559068b.getPreventNamespace() == true) goto L12;
        Map<String, g<?, ?>> r101 = this.f559068b.provideStatelessMethods();
        LinkedHashMap r102 = new LinkedHashMap(MapsKt.mapCapacity(r101.size()));
        Iterator<T> r103 = r101.entrySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L10;
        Map.Entry r104 = (Map.Entry) r103.next();
        r102.put("ext_" + this.f559067a + '_' + ((String) r104.getKey()), r104.getValue());
        goto L7
    L10:
        return r102;
    L12:
        return this.f559068b.provideStatelessMethods();
    }

    public a(String r100, ExternalJsBridgeMethodFactory r101) {
        Intrinsics.checkNotNullParameter(r100, "namespace");
        Intrinsics.checkNotNullParameter(r101, "factory");
        this.f559067a = r100;
        this.f559068b = r101;
    }
}
