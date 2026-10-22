package com.ss.android.lark.mention.base.impl.atselector.doubaoview;

import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public interface b {

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f431750a = null;

        static {
            f431750a = new a();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.mention.base.impl.atselector.doubaoview.b$b, reason: collision with other inner class name */
    public static final class C5126b implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f431751a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f431752b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5126b) == true) goto L8;
            return false;
        L8:
            C5126b r101 = (C5126b) r100;
            if (Intrinsics.areEqual(this.f431751a, r101.f431751a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f431752b, r101.f431752b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f431751a.hashCode() * 31;
            Throwable r101 = this.f431752b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Error(message=" + this.f431751a + ", cause=" + this.f431752b + ')';
        }

        public C5126b(Throwable r100) {
            Intrinsics.checkNotNullParameter("", "message");
            this.f431751a = "";
            this.f431752b = r100;
        }
    }

    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f431753a = null;

        static {
            f431753a = new c();
        }

        public c() {
        }
    }

    public static final class d implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f431754a = null;

        static {
            f431754a = new d();
        }

        public d() {
        }
    }

    public static final class e implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<BaseAtBean> f431755a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f431755a, ((e) r100).f431755a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f431755a.hashCode();
        }

        public final String toString() {
            return "Success(items=" + this.f431755a + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public e(List<? extends BaseAtBean> r100) {
            Intrinsics.checkNotNullParameter(r100, "items");
            this.f431755a = r100;
        }
    }
}
