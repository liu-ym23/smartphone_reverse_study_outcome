package com.bytedance.ee.bear.document;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.domain.BearUrl;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public interface r4 extends com.bytedance.ee.bear.browser.plugin.i {

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.r4$a$a, reason: collision with other inner class name */
        public static final class C3152a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f221256a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Throwable f221257b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C3152a) == true) goto L8;
                return false;
            L8:
                C3152a r101 = (C3152a) r100;
                if (this.f221256a == r101.f221256a) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f221257b, r101.f221257b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                int r100 = this.f221256a * 31;
                Throwable r101 = this.f221257b;
                if (r101 != null) goto L5;
                int r102 = 0;
            L7:
                return r100 + r102;
            L5:
                r102 = r101.hashCode();
                goto L7
            }

            public final String toString() {
                return "LoadFail(code=" + this.f221256a + ", e=" + this.f221257b + ')';
            }

            public C3152a(int r100, Throwable r101) {
                this.f221256a = r100;
                this.f221257b = r101;
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f221258a = null;

            static {
                f221258a = new b();
            }

            public b() {
            }
        }

        public static final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f221259a = null;

            static {
                f221259a = new c();
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
