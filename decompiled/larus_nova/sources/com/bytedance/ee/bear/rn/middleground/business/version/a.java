package com.bytedance.ee.bear.rn.middleground.business.version;

import com.bytedance.ee.bear.rn.v;
import du5.b;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements v {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.rn.middleground.business.version.a$a, reason: collision with other inner class name */
    public static final class C3390a {
    }

    static {
    }

    public a(String r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "docToken");
        Intrinsics.checkNotNullParameter(r101, "documentType");
        new yl5.a("version:" + r100 + ':' + r101.f541317b + ':' + r101.getType());
        StringBuilder r102 = new StringBuilder();
        r102.append(this);
        r102.append(", ");
        r102.append("objToken = " + b.i(r100) + ", fileType = " + r101);
        tt5.a.h("VersionSDK", r102.toString());
    }
}
