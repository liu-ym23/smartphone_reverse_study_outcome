package kotlinx.coroutines;

import android.util.EventsUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JY\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000b2'\u0010\f\u001a#\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r¢\u0006\u0002\b\u00102\u0006\u0010\u0011\u001a\u0002H\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000eH\u0087\u0002¢\u0006\u0002\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0007j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/CoroutineStart;", XmlPullParser.NO_NAMESPACE, "(Ljava/lang/String;I)V", "isLazy", XmlPullParser.NO_NAMESPACE, "isLazy$annotations", "()V", "()Z", "invoke", XmlPullParser.NO_NAMESPACE, "R", "T", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", XmlPullParser.NO_NAMESPACE, "Lkotlin/ExtensionFunctionType;", "receiver", "completion", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "DEFAULT", "LAZY", "ATOMIC", "UNDISPATCHED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final enum CoroutineStart extends Enum<CoroutineStart> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ CoroutineStart[] $VALUES = null;
    public static final CoroutineStart ATOMIC = null;
    public static final CoroutineStart DEFAULT = null;
    public static final CoroutineStart LAZY = null;
    public static final CoroutineStart UNDISPATCHED = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CoroutineStart.values().length];
            r0[CoroutineStart.DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[CoroutineStart.ATOMIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[CoroutineStart.UNDISPATCHED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[CoroutineStart.LAZY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    private static final /* synthetic */ CoroutineStart[] $values() {
        return new CoroutineStart[]{DEFAULT, LAZY, ATOMIC, UNDISPATCHED};
    }

    public static EnumEntries<CoroutineStart> getEntries() {
        return $ENTRIES;
    }

    public static /* synthetic */ void isLazy$annotations() {
    }

    public static CoroutineStart valueOf(String r1) {
        return (CoroutineStart) r27.a.a(CoroutineStart.class, r1);
    }

    public static CoroutineStart[] values() {
        return (CoroutineStart[]) $VALUES.clone();
    }

    static {
        DEFAULT = new CoroutineStart("DEFAULT", 0);
        LAZY = new CoroutineStart("LAZY", 1);
        ATOMIC = new CoroutineStart("ATOMIC", 2);
        UNDISPATCHED = new CoroutineStart("UNDISPATCHED", 3);
        CoroutineStart[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public final boolean isLazy() {
        if (this != LAZY) goto L5;
        return true;
    L5:
        return false;
    }

    private CoroutineStart(String r1, int r2) {
        super(r1, r2);
    }

    public final <R, T> void invoke(Function2<? super R, ? super Continuation<? super T>, ? extends Object> r5, R r6, Continuation<? super T> r7) {
        int r0 = a.a[ordinal()];
        if (r0 != 1) goto L5;
        cuc.a.b(r5, r6, r7);
        return;
    L5:
        if (r0 != 2) goto L7;
        ContinuationKt.startCoroutine(r5, r6, r7);
        return;
    L7:
        if (r0 != 3) goto L9;
        Continuation r1 = DebugProbesKt.probeCoroutineCreated(r7);
        CoroutineContext r8 = r7.getContext();     // Catch: Throwable -> L26
        Object r2 = ThreadContextKt.c(r8, null);     // Catch: Throwable -> L26
    L23:
        th = move-exception;
        ThreadContextKt.a(r8, r2);     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L16:
        if ((r5 instanceof BaseContinuationImpl) == true) goto L18;
        Object r9 = IntrinsicsKt.wrapWithContinuationImpl(r5, r6, r1);     // Catch: Throwable -> L23
    L19:
        ThreadContextKt.a(r8, r2);     // Catch: Throwable -> L26
        if (r9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L33;
        r1.resumeWith(Result.m49constructorimpl(r9));
        return;
    L33:
        return;
    L18:
        r9 = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r5, 2)).invoke(r6, r1);     // Catch: Throwable -> L23
    L26:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r1.resumeWith(Result.m49constructorimpl(ResultKt.createFailure(th)));
        return;
    L9:
        if (r0 != 4) goto L12;
        return;
    L12:
        throw new NoWhenBranchMatchedException();
    }
}
