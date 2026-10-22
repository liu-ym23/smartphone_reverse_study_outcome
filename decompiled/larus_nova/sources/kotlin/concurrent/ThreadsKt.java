package kotlin.concurrent;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aJ\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u001a3\u0010\u000e\u001a\u0002H\u000f\"\b\b\u0000\u0010\u000f*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u000f0\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000f0\fH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0014"}, d2 = {"thread", "Ljava/lang/Thread;", "start", "", "isDaemon", "contextClassLoader", "Ljava/lang/ClassLoader;", "name", "", "priority", "", "block", "Lkotlin/Function0;", "", "getOrSet", ExifInterface.GPS_DIRECTION_TRUE, "", "Ljava/lang/ThreadLocal;", "default", "(Ljava/lang/ThreadLocal;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ThreadsKt {
    private static final <T> T getOrSet(ThreadLocal<T> r100, Function0<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "default");
        T r102 = r100.get();
        if (r102 != null) goto L6;
        T r103 = r101.invoke();
        r100.set(r103);
        return r103;
    L6:
        return r102;
    }

    public static final Thread thread(boolean r100, boolean r101, ClassLoader r102, String r103, int r104, final Function0<Unit> r105) {
        Intrinsics.checkNotNullParameter(r105, "block");
        PthreadThreadV2 r106 = new ThreadsKt$thread$thread$1(r105);
        if (r101 == false) goto L5;
        r106.setDaemon(true);
    L5:
        if (r104 <= 0) goto L7;
        ThreadMethodProxy.setPriority(r106, r104);
    L7:
        if (r103 == null) goto L9;
        ThreadMethodProxy.setName(r106, r103);
    L9:
        if (r102 == null) goto L11;
        r106.setContextClassLoader(r102);
    L11:
        if (r100 == false) goto L13;
        ThreadMethodProxy.start(r106);
    L13:
        return r106;
    }

    public static /* synthetic */ Thread thread$default(boolean r100, boolean r101, ClassLoader r102, String r103, int r110, Function0 r111, int r112, Object r113) {
        if ((r112 & 1) == 0) goto L5;
        boolean r104 = true;
    L7:
        if ((r112 & 2) == 0) goto L9;
        boolean r105 = false;
    L11:
        if ((r112 & 4) == 0) goto L13;
        ClassLoader r106 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        String r107 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        int r108 = -1;
    L23:
        return thread(r104, r105, r106, r107, r108, r111);
    L21:
        r108 = r110;
        goto L23
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r104 = r100;
        goto L7
    }
}
