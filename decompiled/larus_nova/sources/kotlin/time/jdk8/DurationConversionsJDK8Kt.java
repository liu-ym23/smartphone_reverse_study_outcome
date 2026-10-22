package kotlin.time.jdk8;

import java.time.Duration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0002*\u00020\u0001H\u0087\b¢\u0006\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0007"}, d2 = {"toJavaDuration", "Ljava/time/Duration;", "Lkotlin/time/Duration;", "toJavaDuration-LRDsOJo", "(J)Ljava/time/Duration;", "toKotlinDuration", "(Ljava/time/Duration;)J", "kotlin-stdlib-jdk8"}, k = 2, mv = {1, 9, 0}, pn = "kotlin.time", xi = 48)
public final class DurationConversionsJDK8Kt {
    /* JADX INFO: renamed from: toJavaDuration-LRDsOJo, reason: not valid java name */
    private static final Duration m10955toJavaDurationLRDsOJo(long r100) {
        return Duration.ofSeconds(kotlin.time.Duration.m10814getInWholeSecondsimpl(r100), kotlin.time.Duration.m10816getNanosecondsComponentimpl(r100));
    }

    private static final long toKotlinDuration(Duration r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return kotlin.time.Duration.m10829plusLRDsOJo(DurationKt.toDuration(r100.getSeconds(), DurationUnit.SECONDS), DurationKt.toDuration(r100.getNano(), DurationUnit.NANOSECONDS));
    }
}
