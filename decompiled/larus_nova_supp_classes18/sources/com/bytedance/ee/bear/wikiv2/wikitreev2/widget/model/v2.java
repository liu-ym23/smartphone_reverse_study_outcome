package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiTreeCtrlView;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v2 {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        @JvmStatic
        public static d3 a(WikiTreeModel r2) {
            Intrinsics.checkNotNullParameter(r2, "treeModel");
            WikiTreeCtrlView.c r0 = r2.getViewConfig();
            if (r0 == null) goto L7;
            boolean r1 = true;
            if (r0.s != true) goto L7;
        L8:
            if (r1 == true) goto L10;
            b r3 = new br5.b();
        L12:
            return r3.a(r2);
        L10:
            r3 = new br5.a();
        L7:
            r1 = false;
            goto L8
        }
    }

    public interface b {
        d3 a(WikiTreeModel r1);
    }

    static {
    }
}
