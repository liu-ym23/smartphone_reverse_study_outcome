package kotlin;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0004\n\u0002\b\u0005\n\u0002\u0010&\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a:\u0010\u0013\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u0014\"\u0004\b\u0001\u0010\u0015*\u001e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u00150\u0016j\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0015`\u0017H\u0087\n¢\u0006\u0002\u0010\u0018\u001a:\u0010\u0019\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u0014\"\u0004\b\u0001\u0010\u0015*\u001e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u00150\u0016j\u000e\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0015`\u0017H\u0087\n¢\u0006\u0002\u0010\u0018\"#\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00020\u00038Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"#\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00020\b8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\t\u001a\u0004\b\u0006\u0010\n\"#\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00020\u000b8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\f\u001a\u0004\b\u0006\u0010\r\"#\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u0006\u0010\u000f\"#\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00020\u00108Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0006\u0010\u0012¨\u0006\u001a"}, d2 = {"ul", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "", "getUl$annotations", "(D)V", "getUl", "(D)J", "", "(F)V", "(F)J", "", "(I)V", "(I)J", "(J)V", "(J)J", "", "(Ljava/lang/Number;)V", "(Ljava/lang/Number;)J", "component1", "K", "V", "", "Lcom/bytedance/revenue/platform/api/core/Entry;", "(Ljava/util/Map$Entry;)Ljava/lang/Object;", "component2", "lib-kmp-core_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class HacksKt {
    private static final long getUl(double r100) {
        return (long) r100;
    }

    private static final long getUl(float r100) {
        return (long) r100;
    }

    private static final long getUl(int r100) {
        return r100;
    }

    private static final long getUl(long r100) {
        return r100;
    }

    public static /* synthetic */ void getUl$annotations(double r100) {
    }

    public static /* synthetic */ void getUl$annotations(float r100) {
    }

    public static /* synthetic */ void getUl$annotations(int r100) {
    }

    public static /* synthetic */ void getUl$annotations(long r100) {
    }

    public static /* synthetic */ void getUl$annotations(Number r100) {
    }

    private static final <K, V> K component1(Map.Entry<? extends K, ? extends V> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.getKey();
    }

    private static final <K, V> V component2(Map.Entry<? extends K, ? extends V> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.getValue();
    }

    private static final long getUl(Number r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.longValue();
    }
}
