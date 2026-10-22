package com.bytedance.forest.postprocessor;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.utils.ThreadUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\n\b'\u0018\u0000 3*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u00014B\u0011\u0012\b\b\u0002\u0010/\u001a\u00020\u000b¢\u0006\u0004\b1\u00102J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0010¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0011\u001a\u00020\u000bH\u0010¢\u0006\u0004\b\u000f\u0010\u0010J2\u0010\u0018\u001a\u00020\u00052!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u0012H\u0000¢\u0006\u0004\b\u0016\u0010\u0017J1\u0010\u001d\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0018\u0010\u001a\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0019\u0012\u0004\u0012\u00020\u00050\u0012H\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u00192\u0006\u0010\u001f\u001a\u00020\u001eH$J\u0017\u0010#\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001eH\u0010¢\u0006\u0004\b!\u0010\"R\"\u0010\u0004\u001a\u00020\u00038\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b\u0004\u0010$\u001a\u0004\b%\u0010&\"\u0004\b\b\u0010\u0007R^\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00122#\u0010'\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00128\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b)\u0010*R\u001a\u0010\u0014\u001a\u00020+8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010,\u001a\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00065"}, d2 = {"Lcom/bytedance/forest/postprocessor/ForestPostProcessor;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/forest/utils/e;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "setContext$forest_release", "(Lcom/bytedance/forest/utils/e;)V", "setContext", "Lcom/bytedance/forest/model/Response;", "response", "", "executable$forest_release", "(Lcom/bytedance/forest/model/Response;)Z", "executable", "shortCircuit$forest_release", "()Z", "shortCircuit", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "continuation", "inverseControl$forest_release", "(Lkotlin/jvm/functions/Function1;)V", "inverseControl", "Lcom/bytedance/forest/postprocessor/ProcessedData;", "callback", "process$forest_release", "(Lcom/bytedance/forest/model/Response;Lkotlin/jvm/functions/Function1;)V", "process", "Lcom/bytedance/forest/postprocessor/ProcessableData;", "data", "onProcess", "onPostProcess$forest_release", "(Lcom/bytedance/forest/postprocessor/ProcessableData;)V", "onPostProcess", "Lcom/bytedance/forest/utils/e;", "getContext", "()Lcom/bytedance/forest/utils/e;", "<set-?>", "Lkotlin/jvm/functions/Function1;", "getContinuation", "()Lkotlin/jvm/functions/Function1;", "", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "allowOnMainThread", "Z", "<init>", "(Z)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "forest_release"}, k = 1, mv = {1, 4, 0})
public abstract class ForestPostProcessor<T> {
    public static final a Companion = null;
    private static final String TAG = "PostProcessor";
    private final boolean allowOnMainThread;
    protected com.bytedance.forest.utils.e context;
    private Function1<? super Response, Unit> continuation;
    private final String name;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ForestPostProcessor f244427a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ProcessableData f244428b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function1 f244429c;

        public b(ForestPostProcessor r100, ProcessableData r101, Function1 r102) {
            this.f244427a = r100;
            this.f244428b = r101;
            this.f244429c = r102;
        }

        public final void a() {
            ProcessedData<T> r100 = this.f244427a.onProcess(this.f244428b);     // Catch: Throwable -> L5
            r100.setContext$forest_release(this.f244427a.getContext());     // Catch: Throwable -> L5
            this.f244427a.onPostProcess$forest_release(this.f244428b);
            this.f244429c.invoke(r100);
            return;
        L5:
            th = move-exception;
            throw th;     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            this.f244427a.onPostProcess$forest_release(this.f244428b);
            throw th;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        Companion = new a();
    }

    public ForestPostProcessor() {
        boolean r100 = false;
        this(r100, 1, null);
    }

    public abstract ProcessedData<T> onProcess(ProcessableData r100);

    public boolean shortCircuit$forest_release() {
        return false;
    }

    public final com.bytedance.forest.utils.e getContext() {
        com.bytedance.forest.utils.e r100 = this.context;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
    L5:
        return r100;
    }

    public final Function1<Response, Unit> getContinuation() {
        return this.continuation;
    }

    public String getName() {
        return this.name;
    }

    public ForestPostProcessor(boolean r100) {
        this.allowOnMainThread = r100;
        String r101 = Reflection.getOrCreateKotlinClass(getClass()).getQualifiedName();
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        this.name = r101;
    }

    public boolean executable$forest_release(Response r100) {
        return r100.f244316r;
    }

    public final void inverseControl$forest_release(Function1<? super Response, Unit> r110) {
        com.bytedance.forest.utils.e r100 = this.context;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
    L5:
        com.bytedance.forest.utils.c.a(r100.f244543g, 4, TAG, "inverse control right from chain to processor: " + getName(), false, null, null, 56);
        this.continuation = r110;
    }

    public void onPostProcess$forest_release(final ProcessableData r110) {
        if (r110.f244441l == false) goto L17;
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L6
        ((InputStream) r110.f244442m.getValue()).close();     // Catch: Throwable -> L6
        Object r101 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L8:
        final Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
        if (r102 == null) goto L18;
        com.bytedance.forest.utils.e r103 = this.context;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
    L13:
        com.bytedance.forest.utils.c.c(r103.f244543g, 6, TAG, true, null, null, new ForestPostProcessor$onPostProcess$$inlined$onFailure$lambda$1(r102, this, r110), 24);
        return;
    L18:
        return;
    L6:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final void setContext(com.bytedance.forest.utils.e r100) {
        this.context = r100;
    }

    public final void setContext$forest_release(com.bytedance.forest.utils.e r100) {
        this.context = r100;
    }

    public final void process$forest_release(Response r100, Function1<? super ProcessedData<T>, Unit> r101) {
        b r102 = new b(this, new ProcessableData(r100), r101);
        if (this.allowOnMainThread == true) goto L5;
        ThreadUtils.b(r102);
        return;
    L5:
        r102.run();
    }

    public /* synthetic */ ForestPostProcessor(boolean r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = true;
    L5:
        this(r100);
    }
}
