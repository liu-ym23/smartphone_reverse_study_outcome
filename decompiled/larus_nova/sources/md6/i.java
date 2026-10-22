package md6;

import androidx.camera.video.AudioStats;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes19.dex */
public final class i {
    public static final long a(List r100, Function1 r101) {
        if (((ArrayList) r100).isEmpty() == true) goto L29;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator r103 = r100.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        r102.add(r101.invoke(r103.next()));
        goto L7
    L9:
        ArrayList r104 = new ArrayList();
        Iterator r105 = r102.iterator();
    L10:
        boolean r106 = true;
        if (r105.hasNext() == false) goto L19;
        Object r107 = r105.next();
        if (((Number) r107).longValue() > 0) goto L16;
        r106 = false;
    L16:
        if (r106 == false) goto L10;
        r104.add(r107);
        goto L10
    L19:
        if ((!r104.isEmpty()) == true) goto L21;
        return 0;
    L21:
        return (long) CollectionsKt.averageOfLong(r104);
    L29:
        return 0;
    }

    public static final double b(List r100, Function1 r101) {
        if (((ArrayList) r100).isEmpty() == true) goto L29;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator r103 = r100.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        r102.add(r101.invoke(r103.next()));
        goto L7
    L9:
        ArrayList r104 = new ArrayList();
        Iterator r105 = r102.iterator();
    L10:
        boolean r106 = true;
        if (r105.hasNext() == false) goto L19;
        Object r107 = r105.next();
        if (((Number) r107).doubleValue() > AudioStats.AUDIO_AMPLITUDE_NONE) goto L16;
        r106 = false;
    L16:
        if (r106 == false) goto L10;
        r104.add(r107);
        goto L10
    L19:
        if ((!r104.isEmpty()) == true) goto L21;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L21:
        return CollectionsKt.averageOfDouble(r104);
    L29:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }
}
