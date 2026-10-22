package com.bytedance.locallife.pdp.container.view.lynx;

import com.bytedance.locallife.cube.api.i.IPoiLynxKitDelegate;
import com.bytedance.locallife.cube.api.model.CubeInternalSchemaModel;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f261335a = 0;

    public static final class a {
        public static void a(boolean r100, IPoiLynxKitDelegate r101, CubeInternalSchemaModel r110, Map r111, Map r112) {
            Intrinsics.checkNotNullParameter(r110, "schemaModel");
            Intrinsics.checkNotNullParameter(r111, "data");
            Intrinsics.checkNotNullParameter(r112, "globalProps");
            if (r100 == false) goto L6;
            if (r101 == null) goto L11;
            IPoiLynxKitDelegate.DefaultImpls.updateDataWithGlobalProps$default(r101, r110, r111, null, r112, 4, null);
            return;
        L11:
            return;
        L6:
            if (r101 == null) goto L8;
            r101.updateGlobalProps(r112, r110);
        L8:
            if (r101 == null) goto L13;
            IPoiLynxKitDelegate.DefaultImpls.updateData$default(r101, r110, r111, null, 4, null);
            return;
        }
    }

    static {
    }
}
