package com.ivy.ivykit.api.plugin;

import android.app.Application;
import android.content.Context;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/ivy/ivykit/api/plugin/IIvyAIPackageResourceService;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Companion", "b", "ivy_api_release"}, k = 1, mv = {1, 7, 1})
public interface IIvyAIPackageResourceService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f278317a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ivy/ivykit/api/plugin/IIvyAIPackageResourceService$Companion;", "Lcom/ivy/ivykit/api/plugin/IIvyAIPackageResourceService;", "<init>", "()V", "ivy_api_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion implements IIvyAIPackageResourceService {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f278318b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<IIvyAIPackageResourceService> f278319c = null;

        private Companion() {
        }

        static {
            f278318b = new Companion();
            f278319c = LazyKt.lazy(IIvyAIPackageResourceService$Companion$impl$2.INSTANCE);
        }

        public static IIvyAIPackageResourceService f() {
            return f278319c.getValue();
        }

        @Override // com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService
        public final String getBid() {
            IIvyAIPackageResourceService r100 = f();
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.getBid();
        }

        @Override // com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService
        public final String b(String r100) {
            IIvyAIPackageResourceService r101 = f();
            if (r101 == null) goto L6;
            String r102 = r101.b(r100);
            if (r102 == null) goto L6;
            return r102;
        L6:
            return "";
        }

        @Override // com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService
        public final void e(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            IIvyAIPackageResourceService r101 = f();
            if (r101 == null) goto L6;
            r101.e(r100);
            return;
        }

        @Override // com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService
        public final void h(String r100) {
            Intrinsics.checkNotNullParameter(r100, "sessionId");
            IIvyAIPackageResourceService r101 = f();
            if (r101 == null) goto L6;
            r101.h(r100);
            return;
        }

        @Override // com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService
        public final String d(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r102, "bid");
            IIvyAIPackageResourceService r103 = f();
            if (r103 != null) goto L7;
            return null;
        L7:
            return r103.d(r100, r101, r102);
        }

        @Override // com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService
        public final void a(Application r100, String r101, String r110, c r111, b r112) {
            Intrinsics.checkNotNullParameter(r100, "application");
            Intrinsics.checkNotNullParameter(r101, "bid");
            Intrinsics.checkNotNullParameter(r111, "pluginConfig");
            Intrinsics.checkNotNullParameter(r112, "containerConfig");
            IIvyAIPackageResourceService r102 = f();
            if (r102 == null) goto L6;
            r102.a(r100, r101, r110, r111, r112);
            return;
        }

        @Override // com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService
        public final void c(String r100, String r101, Function1<? super a, Unit> r110, Function1<? super Throwable, Unit> r111, boolean r112) {
            Intrinsics.checkNotNullParameter(r101, "url");
            Intrinsics.checkNotNullParameter(r110, JSEventListener.ACTION_RESOLVE);
            Intrinsics.checkNotNullParameter(r111, "reject");
            IIvyAIPackageResourceService r102 = f();
            if (r102 == null) goto L6;
            r102.c(r100, r101, r110, r111, r112);
            return;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f278320a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f278321b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f278322c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f278323d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final C3878a f278324e;

        /* JADX INFO: renamed from: com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService$a$a, reason: collision with other inner class name */
        public static final class C3878a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final byte[] f278325a;

            public final String toString() {
                return "ComparableByteArray(templateJS=" + Arrays.toString(this.f278325a) + ")";
            }

            public final int hashCode() {
                return Arrays.hashCode(this.f278325a);
            }

            public C3878a(byte[] r100) {
                Intrinsics.checkNotNullParameter(r100, "templateJS");
                this.f278325a = r100;
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if (r100 == null) goto L8;
                Class<?> r101 = r100.getClass();
            L10:
                if (Intrinsics.areEqual(C3878a.class, r101) == true) goto L13;
                return false;
            L13:
                Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService.AppletResponse.ComparableByteArray");
                return Arrays.equals(this.f278325a, ((C3878a) r100).f278325a);
            L8:
                r101 = null;
                goto L10
            }
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f278320a, r101.f278320a) == true) goto L12;
            return false;
        L12:
            if (this.f278321b == r101.f278321b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f278322c, r101.f278322c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f278323d, r101.f278323d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f278324e, r101.f278324e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f278320a.hashCode() * 31;
            long r101 = this.f278321b;
            int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f278322c.hashCode()) * 31;
            String r103 = this.f278323d;
            int r104 = 0;
            if (r103 != null) goto L5;
            int r105 = 0;
        L6:
            int r106 = (r102 + r105) * 31;
            C3878a r107 = this.f278324e;
            if (r107 == null) goto L11;
            r104 = r107.hashCode();
        L11:
            return r106 + r104;
        L5:
            r105 = r103.hashCode();
            goto L6
        }

        public final String toString() {
            return "AppletResponse(response=" + this.f278320a + ", version=" + this.f278321b + ", resFrom=" + this.f278322c + ", filePath=" + this.f278323d + ", byteArray=" + this.f278324e + ")";
        }

        public a(String r100, long r101, String r102, String r103, C3878a r104) {
            Intrinsics.checkNotNullParameter(r100, "response");
            Intrinsics.checkNotNullParameter(r102, "resFrom");
            this.f278320a = r100;
            this.f278321b = r101;
            this.f278322c = r102;
            this.f278323d = r103;
            this.f278324e = r104;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<String> f278326a;

        public b() {
        }
    }

    static {
        f278317a = Companion.f278318b;
    }

    void a(Application r100, String r101, String r102, c r103, b r104);

    String b(String r100);

    void c(String r100, String r101, Function1<? super a, Unit> r102, Function1<? super Throwable, Unit> r103, boolean r104);

    String d(String r100, String r101, String r102);

    void e(Context r100);

    String getBid();

    void h(String r100);
}
