package iwc;

import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.error.InstanceCreationException;
import org.koin.core.logger.Level;
import org.koin.core.scope.Scope;

/* JADX INFO: loaded from: classes42.dex */
public abstract class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.koin.core.a f496310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BeanDefinition<T> f496311b;

    public static final class a {
    }

    static {
    }

    public abstract void b();

    public abstract T c(b r100);

    public T a(b r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (this.f496310a.f526124c.c(Level.DEBUG) == false) goto L16;
        this.f496310a.f526124c.a(Intrinsics.stringPlus("| create instance for ", this.f496311b));
    L16:
        lwc.a r100 = r110.f496309c;     // Catch: Exception -> L8
        Scope r101 = r110.f496307a;     // Catch: Exception -> L8
        r101.getClass();     // Catch: Exception -> L8
        Intrinsics.checkNotNullParameter(r100, "parameters");     // Catch: Exception -> L8
        r101.f526152i = r100;     // Catch: Exception -> L8
        T r102 = this.f496311b.f526131d.invoke(r110.f496307a, r100);     // Catch: Exception -> L8
        r110.f496307a.f526152i = null;     // Catch: Exception -> L8
        return r102;
    L8:
        e = move-exception;
        StringBuilder r103 = new StringBuilder();
        r103.append(e);
        r103.append("\n\t");
        StackTraceElement[] r104 = e.getStackTrace();
        ArrayList r105 = new ArrayList();
        int r106 = r104.length;
        int r107 = 0;
    L10:
        if (r107 >= r106) goto L14;
        StackTraceElement r108 = r104[r107];
        if ((!StringsKt.contains$default(r108.getClassName(), "sun.reflect", false, 2, null)) == false) goto L14;
        r105.add(r108);
        r107 = r107 + 1;
    L14:
        r103.append(CollectionsKt.joinToString$default(r105, "\n\t", null, null, 0, null, null, 62, null));
        String r109 = r103.toString();
        jwc.a r111 = this.f496310a.f526124c;
        String r112 = "Instance creation error : could not create instance for " + this.f496311b + ": " + r109;
        r111.getClass();
        Intrinsics.checkNotNullParameter(r112, "msg");
        r111.b(Level.ERROR, r112);
        throw new InstanceCreationException(Intrinsics.stringPlus("Could not create instance for ", this.f496311b), e);
    }

    public c(org.koin.core.a r100, BeanDefinition<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "_koin");
        Intrinsics.checkNotNullParameter(r101, "beanDefinition");
        this.f496310a = r100;
        this.f496311b = r101;
    }
}
