package com.ss.android.lark.blueprint;

import com.bytedance.bdlocation.annotation.LocationAnnotation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public interface i<Data, PatchData> {

    public static final class a {
        public static void a(m r100, q r101) {
            Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
            Intrinsics.checkNotNullParameter(r101, "layout");
        }

        public static <Data, PatchData> void b(i<Data, PatchData> r100, m<Data> r101, q<Data> r102, Data r103, PatchData r104) {
            Intrinsics.checkNotNullParameter(r101, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
            Intrinsics.checkNotNullParameter(r102, "layout");
            Intrinsics.checkNotNullParameter(r103, "data");
            Intrinsics.checkNotNullParameter(r104, "patch");
            r100.update(r101, r102, r103);
        }
    }

    void a(m<Data> r100, q<Data> r101);

    Class<PatchData> b();

    void c(BlueprintCell r100, q r101, Object r102, Object r103);

    j getKey();

    void update(m<Data> r100, q<Data> r101, Data r102);
}
