package n11;

import androidx.camera.video.AudioStats;
import com.bytedance.android.livesdk.model.RevSeiRegion;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f516664a = 0;

    static {
    }

    public static double a(List r100) {
        Intrinsics.checkNotNullParameter(r100, "grids");
        if (r100.isEmpty() == false) goto L5;
    L28:
        double r101 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L30:
        return r101 - c(r100);
    L5:
        if (ListProtector.get(r100, 0) == null) goto L28;
        IntRange r102 = CollectionsKt.getIndices(r100);
        ArrayList r103 = new ArrayList();
        Iterator<Integer> r104 = r102.iterator();
    L9:
        if (r104.hasNext() == false) goto L22;
        RevSeiRegion r105 = (RevSeiRegion) ListProtector.get(r100, ((IntIterator) r104).nextInt());
        if (r105 == null) goto L19;
        float r106 = (float) r105.getWidth();
        float r107 = (float) r105.getHeight();
        double r108 = r105.getY();
        if (r106 <= 0.0f) goto L19;
        if (r107 <= 0.0f) goto L19;
        Double r109 = Double.valueOf(r108 + ((double) r107));
    L20:
        if (r109 == null) goto L9;
        r103.add(r109);
    L19:
        r109 = null;
        goto L20
    L22:
        List r110 = CollectionsKt.sorted(r103);
        if (r110.isEmpty() == true) goto L28;
        Double r111 = (Double) CollectionsKt.lastOrNull(r110);
        if (r111 == null) goto L28;
        r101 = r111.doubleValue();
        goto L30
    }

    public static double b(List r100) {
        Intrinsics.checkNotNullParameter(r100, "grids");
        if (r100.isEmpty() == false) goto L5;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L5:
        if (ListProtector.get(r100, 0) == null) goto L36;
        IntRange r101 = CollectionsKt.getIndices(r100);
        ArrayList r102 = new ArrayList();
        Iterator<Integer> r103 = r101.iterator();
    L9:
        if (r103.hasNext() == false) goto L22;
        RevSeiRegion r104 = (RevSeiRegion) ListProtector.get(r100, ((IntIterator) r103).nextInt());
        if (r104 == null) goto L19;
        float r105 = (float) r104.getWidth();
        float r106 = (float) r104.getHeight();
        double r107 = r104.getX();
        if (r105 <= 0.0f) goto L19;
        if (r106 <= 0.0f) goto L19;
        Double r108 = Double.valueOf(r107);
    L20:
        if (r108 == null) goto L9;
        r102.add(r108);
    L19:
        r108 = null;
        goto L20
    L22:
        List r109 = CollectionsKt.sorted(r102);
        if (r109.isEmpty() == false) goto L25;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L25:
        Double r110 = (Double) CollectionsKt.firstOrNull(r109);
        if (r110 != null) goto L28;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L28:
        return r110.doubleValue();
    L36:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public static double c(List r100) {
        Intrinsics.checkNotNullParameter(r100, "grids");
        if (r100.isEmpty() == false) goto L5;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L5:
        if (ListProtector.get(r100, 0) == null) goto L36;
        IntRange r101 = CollectionsKt.getIndices(r100);
        ArrayList r102 = new ArrayList();
        Iterator<Integer> r103 = r101.iterator();
    L9:
        if (r103.hasNext() == false) goto L22;
        RevSeiRegion r104 = (RevSeiRegion) ListProtector.get(r100, ((IntIterator) r103).nextInt());
        if (r104 == null) goto L19;
        float r105 = (float) r104.getWidth();
        float r106 = (float) r104.getHeight();
        double r107 = r104.getY();
        if (r105 <= 0.0f) goto L19;
        if (r106 <= 0.0f) goto L19;
        Double r108 = Double.valueOf(r107);
    L20:
        if (r108 == null) goto L9;
        r102.add(r108);
    L19:
        r108 = null;
        goto L20
    L22:
        List r109 = CollectionsKt.sorted(r102);
        if (r109.isEmpty() == false) goto L25;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L25:
        Double r110 = (Double) CollectionsKt.firstOrNull(r109);
        if (r110 != null) goto L28;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L28:
        return r110.doubleValue();
    L36:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public static double d(List r100) {
        Intrinsics.checkNotNullParameter(r100, "grids");
        if (r100.isEmpty() == false) goto L5;
    L28:
        double r101 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L30:
        return r101 - b(r100);
    L5:
        if (ListProtector.get(r100, 0) == null) goto L28;
        IntRange r102 = CollectionsKt.getIndices(r100);
        ArrayList r103 = new ArrayList();
        Iterator<Integer> r104 = r102.iterator();
    L9:
        if (r104.hasNext() == false) goto L22;
        RevSeiRegion r105 = (RevSeiRegion) ListProtector.get(r100, ((IntIterator) r104).nextInt());
        if (r105 == null) goto L19;
        float r106 = (float) r105.getWidth();
        float r107 = (float) r105.getHeight();
        double r108 = r105.getX();
        if (r106 <= 0.0f) goto L19;
        if (r107 <= 0.0f) goto L19;
        Double r109 = Double.valueOf(r108 + ((double) r106));
    L20:
        if (r109 == null) goto L9;
        r103.add(r109);
    L19:
        r109 = null;
        goto L20
    L22:
        List r110 = CollectionsKt.sorted(r103);
        if (r110.isEmpty() == true) goto L28;
        Double r111 = (Double) CollectionsKt.lastOrNull(r110);
        if (r111 == null) goto L28;
        r101 = r111.doubleValue();
        goto L30
    }
}
