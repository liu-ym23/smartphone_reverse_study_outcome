package jmb;

import android.app.Application;
import com.bytedance.ee.bear.basesdk.apisupport.l;
import com.bytedance.ee.bear.basesdk.apisupport.p;
import com.bytedance.ee.bear.contract.config.DocDynamicConfig;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f499714a;

    @Override // com.bytedance.ee.bear.basesdk.apisupport.l
    public final p dependency() {
        return new f();
    }

    @Override // com.bytedance.ee.bear.basesdk.apisupport.l
    public final on4.a docBaseConfig() {
        return new c();
    }

    public a() {
        this.f499714a = LarkContext.getApplication();
    }

    @Override // com.bytedance.ee.bear.basesdk.apisupport.l
    public final DocDynamicConfig docDynamicConfig() {
        return d.a();
    }

    @Override // com.bytedance.ee.bear.basesdk.apisupport.l
    public final Application application() {
        return this.f499714a;
    }
}
