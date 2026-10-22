package com.larus.apm.impl.protector;

import com.bytedance.services.apm.api.EnsureManager;
import com.larus.settings.protector.RunnableConfig;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.LynxError;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\r\u001a\u00020\u000e2\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0018\u00010\tJ\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J9\u0010\u0014\u001a\u00020\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/apm/impl/protector/RunnableProtector;", "", "<init>", "()V", "TAG", "", "MESSAGE", "MESSAGE_INNER", "runnableConfig", "Lkotlin/Pair;", "", "", "Lcom/larus/settings/protector/RunnableConfig;", "init", "", "config", "intercept", LynxError.LYNX_THROWABLE, "", "interceptInner", "match", "runnableList", "throwableClassName", "throwableMessage", "stackTraceElements", "", "Ljava/lang/StackTraceElement;", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/StackTraceElement;)Z", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RunnableProtector {
    public static final RunnableProtector INSTANCE = null;
    private static final String MESSAGE = "RunnableLancetProtector";
    private static final String MESSAGE_INNER = "RunnableProtectorInnerError";
    private static final String TAG = "RunnableProtector";
    private static volatile Pair<Boolean, ? extends List<RunnableConfig>> runnableConfig;

    static {
        INSTANCE = new RunnableProtector();
    }

    private RunnableProtector() {
    }

    @JvmStatic
    public static final boolean intercept(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        return INSTANCE.interceptInner(r100);
    L5:
        th = move-exception;
        FLogger.f375446a.e(TAG, "match err: " + th.getMessage());
        EnsureManager.ensureNotReachHere(new RunnableProtectorThrowable(MESSAGE_INNER, th), MESSAGE_INNER);
        return false;
    }

    private final boolean interceptInner(Throwable r100) {
        Pair<Boolean, ? extends List<RunnableConfig>> r101 = runnableConfig;
        if (r101 != null) goto L7;
        FLogger.f375446a.i(TAG, "skip, config: null");
        return false;
    L7:
        if (r101.getFirst().booleanValue() == true) goto L10;
        FLogger.f375446a.i(TAG, "skip, enable: false");
        return false;
    L10:
        List<RunnableConfig> r102 = r101.getSecond();
        if (r102.isEmpty() == false) goto L14;
        FLogger.f375446a.i(TAG, "skip, runnableList is null or empty");
        return false;
    L14:
        String r103 = r100.getClass().getName();
        boolean r104 = true;
        if (r103.length() != 0) goto L17;
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        FLogger.f375446a.i(TAG, "skip, throwableClassName is null or empty");
        return false;
    L21:
        String r106 = r100.getMessage();
        if (r106 != null) goto L24;
    L27:
        boolean r107 = true;
    L28:
        if (r107 == false) goto L31;
        FLogger.f375446a.i(TAG, "skip, throwableMessage is null or empty");
        return false;
    L31:
        StackTraceElement[] r108 = r100.getStackTrace();
        if (r108 != null) goto L34;
    L40:
        if (r104 == false) goto L43;
        FLogger.f375446a.i(TAG, "skip, stackTraceElements is null or empty");
        return false;
    L43:
        FLogger r109 = FLogger.f375446a;
        r109.i(TAG, "match start, throwableClassName: " + r103 + ", throwableMessage: " + r106 + ", runnableList: " + r102);
        boolean r110 = match(r102, r103, r106, r108);
        if (r110 == false) goto L46;
        EnsureManager.ensureNotReachHere(new RunnableProtectorThrowable(MESSAGE, r100), MESSAGE);
    L46:
        r109.i(TAG, "match end, result: " + r110);
        return r110;
    L34:
        if (r108.length != 0) goto L36;
        boolean r111 = true;
    L37:
        if (r111 == true) goto L40;
        r104 = false;
        goto L40
    L36:
        r111 = false;
        goto L37
    L24:
        if (r106.length() == 0) goto L27;
        r107 = false;
        goto L28
    L17:
        r105 = false;
        goto L18
    }

    public final void init(Pair<Boolean, ? extends List<RunnableConfig>> r100) {
        runnableConfig = r100;
        FLogger.f375446a.i(TAG, "init, runnable protector config: " + r100);
    }

    private final boolean match(List<RunnableConfig> r100, String r101, String r102, StackTraceElement[] r110) {
        Iterator<RunnableConfig> r103 = r100.iterator();
    L3:
        int r104 = 0;
        if (r103.hasNext() == false) goto L21;
        RunnableConfig r105 = r103.next();
        if (Intrinsics.areEqual(r105.getExceptionType(), r101) == false) goto L3;
        String r106 = r105.getExceptionMessage();
        Intrinsics.checkNotNull(r106);
        if (StringsKt.contains$default(r102, r106, false, 2, null) == false) goto L3;
        int r107 = r110.length;
    L12:
        if (r104 >= r107) goto L3;
        StackTraceElement r108 = r110[r104];
        if (Intrinsics.areEqual(r105.getStackClassName(), r108.getClassName()) == false) goto L18;
        if (Intrinsics.areEqual(r105.getStackMethodName(), r108.getMethodName()) == false) goto L18;
        return true;
    L18:
        r104 = r104 + 1;
        goto L12
    L21:
        return false;
    }
}
