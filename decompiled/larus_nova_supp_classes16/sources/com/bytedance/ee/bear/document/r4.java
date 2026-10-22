package com.bytedance.ee.bear.document;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.domain.BearUrl;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface r4 extends com.bytedance.ee.bear.browser.plugin.i {

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.r4$a$a, reason: collision with other inner class name */
        public static final class C0096a extends a {
            public final int a;
            public final Throwable b;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof C0096a) == true) goto L8;
                return false;
            L8:
                C0096a r6 = (C0096a) r5;
                if (this.a == r6.a) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                int r0 = this.a * 31;
                Throwable r1 = this.b;
                if (r1 != null) goto L5;
                int r2 = 0;
            L7:
                return r0 + r2;
            L5:
                r2 = r1.hashCode();
                goto L7
            }

            public final String toString() {
                return "LoadFail(code=" + this.a + ", e=" + this.b + ')';
            }

            public C0096a(int r1, Throwable r2) {
                this.a = r1;
                this.b = r2;
            }
        }

        public static final class b extends a {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        public static final class c extends a {
            public static final c a = null;

            static {
                a = new c();
            }

            public c() {
            }
        }

        public a() {
        }
    }

    BearUrl getBearUrl();

    String getContainerUrl();

    Fragment getFragment();

    LiveData<a> getLoadState();

    BearUrl getOriginBearUrl();

    String getOriginUrl();

    HashMap<String, Object> getReportCommonParams();

    void startBrowserView();
}
