package za8;

import com.larus.bmhome.auth.feature_config.model.FeatureConfig;
import com.larus.bmhome.auth.feature_config.model.FeatureDetail;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class i implements Function0 {
    public /* synthetic */ i() {
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        FeatureConfig r100 = p0.a();
        boolean r101 = false;
        if (r100 == null) goto L9;
        FeatureDetail r102 = r100.D();
        if (r102 == null) goto L9;
        if (r102.b() != true) goto L9;
        boolean r103 = true;
    L10:
        FeatureConfig r104 = p0.a();
        if (r104 == null) goto L18;
        FeatureDetail r105 = r104.D();
        if (r105 == null) goto L18;
        if (r105.a() != true) goto L18;
        r101 = true;
    L18:
        return new FeatureDetail(r103, r101);
    L9:
        r103 = false;
        goto L10
    }
}
