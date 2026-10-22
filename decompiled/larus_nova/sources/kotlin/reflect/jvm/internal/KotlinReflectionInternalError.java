package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00060\u0002j\u0002`\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/reflect/jvm/internal/KotlinReflectionInternalError;", "Lkotlin/Error;", "Ljava/lang/Error;", "message", "", "<init>", "(Ljava/lang/String;)V", "kotlin-reflection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class KotlinReflectionInternalError extends Error {
    public KotlinReflectionInternalError(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        super(r100);
    }
}
