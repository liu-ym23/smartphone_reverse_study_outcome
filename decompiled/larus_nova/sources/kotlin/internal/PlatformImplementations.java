package kotlin.internal;

import com.bytedance.android.ec.core.event.a;
import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.MatchResult;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.FallbackThreadLocalRandom;
import kotlin.random.Random;
import kotlin.text.MatchGroup;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u0013"}, d2 = {"Lkotlin/internal/PlatformImplementations;", "", "()V", "addSuppressed", "", "cause", "", a.KEY_EXCEPTION, "defaultPlatformRandom", "Lkotlin/random/Random;", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", "", "getSuppressed", "", "ReflectThrowable", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class PlatformImplementations {

    /* JADX INFO: loaded from: classes6.dex */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlin/internal/PlatformImplementations$ReflectThrowable;", "", "()V", "addSuppressed", "Ljava/lang/reflect/Method;", "getSuppressed", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ReflectThrowable {
        public static final ReflectThrowable INSTANCE = null;
        public static final Method addSuppressed = null;
        public static final Method getSuppressed = null;

        private ReflectThrowable() {
        }

        static {
            INSTANCE = new ReflectThrowable();
            Method[] r100 = Throwable.class.getMethods();
            Intrinsics.checkNotNull(r100);
            int r101 = r100.length;
            int r102 = 0;
            int r103 = 0;
        L3:
            Method r104 = null;
            if (r103 >= r101) goto L14;
            Method r105 = r100[r103];
            if (Intrinsics.areEqual(r105.getName(), "addSuppressed") == true) goto L8;
        L10:
            boolean r106 = false;
        L11:
            if (r106 == true) goto L15;
            r103 = r103 + 1;
        L15:
            addSuppressed = r105;
            int r107 = r100.length;
        L16:
            if (r102 >= r107) goto L21;
            Method r108 = r100[r102];
            if (Intrinsics.areEqual(r108.getName(), "getSuppressed") == true) goto L19;
            r102 = r102 + 1;
            goto L16
        L19:
            r104 = r108;
        L21:
            getSuppressed = r104;
            return;
        L8:
            if (Intrinsics.areEqual(ArraysKt.singleOrNull(r105.getParameterTypes()), Throwable.class) == false) goto L10;
            r106 = true;
            goto L11
        L14:
            r105 = null;
            goto L15
        }
    }

    public PlatformImplementations() {
    }

    public Random defaultPlatformRandom() {
        return new FallbackThreadLocalRandom();
    }

    public List<Throwable> getSuppressed(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, a.KEY_EXCEPTION);
        Method r101 = ReflectThrowable.getSuppressed;
        if (r101 == null) goto L9;
        Object r102 = r101.invoke(r100, new Object[0]);
        if (r102 == null) goto L9;
        List<Throwable> r103 = ArraysKt.asList((Throwable[]) r102);
        if (r103 == null) goto L9;
        return r103;
    L9:
        return CollectionsKt.emptyList();
    }

    public void addSuppressed(Throwable r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "cause");
        Intrinsics.checkNotNullParameter(r101, a.KEY_EXCEPTION);
        Method r102 = ReflectThrowable.addSuppressed;
        if (r102 == null) goto L6;
        r102.invoke(r100, new Object[]{r101});
        return;
    }

    public MatchGroup getMatchResultNamedGroup(MatchResult r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "matchResult");
        Intrinsics.checkNotNullParameter(r101, "name");
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }
}
