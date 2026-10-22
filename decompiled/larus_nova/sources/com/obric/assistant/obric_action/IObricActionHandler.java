package com.obric.assistant.obric_action;

import android.content.Context;
import android.content.Intent;
import com.google.gson.Gson;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u0016*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0001\u0016J\u001f\u0010\f\u001a\u0004\u0018\u00018\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0011J&\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u00132\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00018\u0000H§@¢\u0006\u0002\u0010\u0015R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/obric/assistant/obric_action/IObricActionHandler;", "P", "R", "", "obricAction", "Lcom/obric/assistant/obric_action/ObricAction;", "getObricAction", "()Lcom/obric/assistant/obric_action/ObricAction;", "paramsType", "Ljava/lang/Class;", "getParamsType", "()Ljava/lang/Class;", "parseData", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "data", "", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Object;", "execute", "Lcom/obric/assistant/obric_action/ObricActionResult;", "params", "(Landroid/content/Context;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricActionHandler<P, R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f390395a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f390396a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Lazy<List<IObricActionHandler<?, ?>>> f390397b = null;

        public a() {
        }

        static {
            f390396a = new a();
            f390397b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new com.obric.assistant.obric_action.a());
        }
    }

    public static final class b {
        public static <P, R> P a(IObricActionHandler<P, R> r100, Context r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r102, "data");
            f r103 = f.f390441a;
            Class<P> r104 = r100.b();
            r103.getClass();
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r102, "data");
            Intrinsics.checkNotNullParameter(r104, "paramsType");
            Object r105 = null;
            if (Intrinsics.areEqual(r104, Intent.class) == false) goto L14;
            Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L6
            Intent r107 = Intent.parseUri(r102, 1);     // Catch: Throwable -> L6
            r107.setPackage(r101.getPackageName());     // Catch: Throwable -> L6
            Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L6
        L9:
            if (Result.m9455isFailureimpl(r108) == true) goto L30;
            r105 = r108;
        L30:
            return r104.cast((Intent) r105);
        L6:
            th = move-exception;
            Result.Companion r109 = Result.Companion;
            r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L9
        L14:
            if (Intrinsics.areEqual(r104, String.class) == true) goto L31;
            Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L18
            Object r111 = Result.m9449constructorimpl(((Gson) f.f390442b.getValue()).fromJson(r102, r104));     // Catch: Throwable -> L18
        L21:
            if (Result.m9455isFailureimpl(r111) == true) goto L25;
            r105 = r111;
        L25:
            return (P) r105;
        L18:
            th = move-exception;
            Result.Companion r112 = Result.Companion;
            r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L21
        L31:
            return r104.cast(r102);
        }
    }

    static {
        f390395a = a.f390396a;
    }

    P a(Context r100, String r101);

    Class<P> b();

    d c();

    Object d(Context r100, P r101, Continuation<? super h<? extends R>> r102);
}
