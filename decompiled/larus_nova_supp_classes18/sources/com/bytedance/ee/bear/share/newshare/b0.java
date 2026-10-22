package com.bytedance.ee.bear.share.newshare;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class b0 {
    public final String a;

    public static final class a extends b0 {
        public static final a b = null;

        static {
            b = new a();
        }

        public a() {
            super("bitableProSetting");
        }
    }

    public static final class b extends b0 {
        public static final b b = null;

        static {
            b = new b();
        }

        public b() {
            super("collAvatar");
        }
    }

    public static final class c extends b0 {
        public c(String r2) {
            Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_ID);
            super(r2);
        }
    }

    public static final class d extends b0 {
        public static final d b = null;

        static {
            b = new d();
        }

        public d() {
            super("permissionSetting");
        }
    }

    public static final class e extends b0 {
        public static final e b = null;

        static {
            b = new e();
        }

        public e() {
            super("docLinkShare");
        }
    }

    public static final class f extends b0 {
        public static final /* synthetic */ int b = 0;

        static {
        }
    }

    public static final class g extends b0 {
        public static final g b = null;

        static {
            b = new g();
        }

        public g() {
            super("shareNotify");
        }
    }

    public static final class h extends b0 {
        public static final h b = null;

        static {
            b = new h();
        }

        public h() {
            super("thirdPartyExternal");
        }
    }

    public b0(String r1) {
        this.a = r1;
    }
}
