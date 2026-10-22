package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\u000e\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\bH\u0002\u001a\f\u0010\t\u001a\u00020\u0001*\u00020\bH\u0002\u001a\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b*\u00020\bH\u0001¢\u0006\u0002\u0010\r\u001a\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\bH\u0001¢\u0006\u0002\b\u0010\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"COROUTINES_DEBUG_METADATA_VERSION", "", "checkDebugMetadataVersion", "", "expected", "actual", "getDebugMetadataAnnotation", "Lkotlin/coroutines/jvm/internal/DebugMetadata;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getLabel", "getSpilledVariableFieldMapping", "", "", "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)[Ljava/lang/String;", "getStackTraceElementImpl", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class DebugMetadataKt {
    private static final int COROUTINES_DEBUG_METADATA_VERSION = 1;

    private static final DebugMetadata getDebugMetadataAnnotation(BaseContinuationImpl r100) {
        return (DebugMetadata) r100.getClass().getAnnotation(DebugMetadata.class);
    }

    private static final int getLabel(BaseContinuationImpl r100) {
        Field r101 = r100.getClass().getDeclaredField("label");     // Catch: Exception -> L11
        r101.setAccessible(true);     // Catch: Exception -> L11
        Object r102 = r101.get(r100);     // Catch: Exception -> L11
        if ((r102 instanceof Integer) == false) goto L5;
        Integer r103 = (Integer) r102;     // Catch: Exception -> L11
    L6:
        if (r103 == null) goto L9;
        int r104 = r103.intValue();     // Catch: Exception -> L11
    L15:
        return r104 - 1;
    L9:
        r104 = 0;
        goto L15
    L5:
        r103 = null;
    L11:
        return -1;
    }

    public static final String[] getSpilledVariableFieldMapping(BaseContinuationImpl r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        DebugMetadata r101 = getDebugMetadataAnnotation(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        checkDebugMetadataVersion(1, r101.v());
        ArrayList r102 = new ArrayList();
        int r103 = getLabel(r100);
        int[] r104 = r101.i();
        int r105 = r104.length;
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L13;
        if (r104[r106] != r103) goto L11;
        r102.add(r101.s()[r106]);
        r102.add(r101.n()[r106]);
    L11:
        r106 = r106 + 1;
        goto L7
    L13:
        return (String[]) r102.toArray(new String[0]);
    }

    public static final StackTraceElement getStackTraceElement(BaseContinuationImpl r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        DebugMetadata r101 = getDebugMetadataAnnotation(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        checkDebugMetadataVersion(1, r101.v());
        int r102 = getLabel(r100);
        if (r102 >= 0) goto L9;
        int r103 = -1;
    L10:
        String r104 = ModuleNameRetriever.INSTANCE.getModuleName(r100);
        if (r104 != null) goto L13;
        String r105 = r101.c();
    L15:
        return new StackTraceElement(r105, r101.m(), r101.f(), r103);
    L13:
        r105 = r104 + '/' + r101.c();
        goto L15
    L9:
        r103 = r101.l()[r102];
        goto L10
    }

    private static final void checkDebugMetadataVersion(int r100, int r101) {
        if (r101 > r100) goto L5;
        return;
    L5:
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + r100 + ", got " + r101 + ". Please update the Kotlin standard library.").toString());
    }
}
