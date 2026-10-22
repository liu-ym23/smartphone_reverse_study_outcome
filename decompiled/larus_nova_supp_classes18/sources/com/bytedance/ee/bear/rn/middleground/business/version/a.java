package com.bytedance.ee.bear.rn.middleground.business.version;

import com.bytedance.ee.bear.rn.v;
import du5.b;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements v {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.rn.middleground.business.version.a$a, reason: collision with other inner class name */
    public static final class C0143a {
    }

    static {
    }

    public a(String r5, e r6) {
        Intrinsics.checkNotNullParameter(r5, "docToken");
        Intrinsics.checkNotNullParameter(r6, "documentType");
        new yl5.a("version:" + r5 + ':' + r6.b + ':' + r6.getType());
        StringBuilder r0 = new StringBuilder();
        r0.append(this);
        r0.append(", ");
        r0.append("objToken = " + b.i(r5) + ", fileType = " + r6);
        tt5.a.h("VersionSDK", r0.toString());
    }
}
