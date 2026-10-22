package com.ss.android.lark.watermark.userscope;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class s {

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.watermark.v2.v f445501a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f445502b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.watermark.v2.q<T> f445503c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ T f445504d;

        /* JADX INFO: renamed from: com.ss.android.lark.watermark.userscope.s$a$a, reason: collision with other inner class name */
        public static final class RunnableC5389a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.ss.android.lark.watermark.v2.q<T> f445505a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.ss.android.lark.watermark.v2.u f445506b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ T f445507c;

            public RunnableC5389a(com.ss.android.lark.watermark.v2.q<T> r100, com.ss.android.lark.watermark.v2.u r101, T r102) {
                this.f445505a = r100;
                this.f445506b = r101;
                this.f445507c = r102;
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // java.lang.Runnable
            public final void run() {
                this.f445505a.b(this.f445506b, this.f445507c);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public a(com.ss.android.lark.watermark.v2.v r100, Context r101, com.ss.android.lark.watermark.v2.q<T> r102, T r103) {
            this.f445501a = r100;
            this.f445502b = r101;
            this.f445503c = r102;
            this.f445504d = r103;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.ss.android.lark.watermark.v2.v r100 = this.f445501a;     // Catch: Throwable -> L4
            Context r101 = this.f445502b;     // Catch: Throwable -> L4
            Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L4
            com.ss.android.lark.watermark.v2.u r102 = new com.ss.android.lark.watermark.v2.u(r100, r101);     // Catch: Throwable -> L4
            new Handler(Looper.getMainLooper()).post(new RunnableC5389a(this.f445503c, r102, this.f445504d));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void a(com.ss.android.lark.watermark.v2.v r100, T r101, com.ss.android.lark.watermark.v2.q<T> r102) {
        Intrinsics.checkNotNullParameter(r100, "t");
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r102, "binder");
        Log.i("watermarkV3", "onWatermarkStateChanged");
        boolean r103 = FeatureGatingModule.getFeatureGatingService().isEnable("lark.security.watermark_osdk_skip_empty_disabled.android");
        boolean r104 = StringsKt.isBlank(r100.f445556a);
        boolean r105 = false;
        if (r100.f445557b == null) goto L5;
        boolean r106 = true;
    L6:
        if (r103 == true) goto L10;
        if (r104 == false) goto L10;
        if (r106 == true) goto L10;
        r105 = true;
    L10:
        if (r105 == false) goto L14;
        Log.i("watermarkV3", "onWatermarkStateChanged: skip empty watermark in OfficeSDK, unbind target");
        r102.a(r101);
        return;
    L14:
        if ((r101 instanceof Activity) == false) goto L17;
        Context r107 = (Context) r101;
    L31:
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new a(r100, r107, r102, r101));
        return;
    L17:
        if ((r101 instanceof FrameLayout) == false) goto L20;
        r107 = ((View) r101).getContext();
        goto L31
    L20:
        if ((r101 instanceof View) == false) goto L23;
        r107 = ((View) r101).getContext();
        goto L31
    L23:
        if ((r101 instanceof Fragment) == false) goto L26;
        r107 = ((Fragment) r101).requireContext();
        goto L31
    L26:
        if ((r101 instanceof Application) == false) goto L29;
        r107 = (Context) r101;
        goto L31
    L29:
        if ((r101 instanceof Dialog) == false) goto L34;
        r107 = ((Dialog) r101).getContext();
        goto L31
    L34:
        throw new IllegalArgumentException("illegal target type");
    L5:
        r106 = false;
        goto L6
    }
}
