package androidx.camera.core.processing;

import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class TargetUtils {
    public static int getNumberOfTargets(int r2) {
        int r0 = 0;
    L3:
        if (r2 == 0) goto L5;
        r0 = r0 + (r2 & 1);
        r2 = r2 >> 1;
        goto L3
    L5:
        return r0;
    }

    public static boolean isSuperset(int r0, int r1) {
        if ((r0 & r1) != r1) goto L5;
        return true;
    L5:
        return false;
    }

    private TargetUtils() {
    }

    public static String getHumanReadableName(int r2) {
        ArrayList r0 = new ArrayList();
        if ((r2 & 4) == 0) goto L6;
        r0.add("IMAGE_CAPTURE");
    L6:
        if ((r2 & 1) == 0) goto L9;
        r0.add("PREVIEW");
    L9:
        if ((r2 & 2) == 0) goto L11;
        r0.add("VIDEO_CAPTURE");
    L11:
        StringBuilder r3 = new StringBuilder();
        Iterator r1 = r0.iterator();
        if (r1.hasNext() == false) goto L17;
    L13:
        r3.append((CharSequence) r1.next());
        if (r1.hasNext() == false) goto L17;
        r3.append("|");
    L17:
        return r3.toString();
    }

    private static String getHumanReadableNames(Collection<Integer> r3) {
        ArrayList r0 = new ArrayList();
        Iterator<Integer> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r0.add(getHumanReadableName(r4.next().intValue()));
        goto L4
    L6:
        StringBuilder r5 = new StringBuilder("[");
        StringBuilder r1 = new StringBuilder();
        Iterator r2 = r0.iterator();
        if (r2.hasNext() == false) goto L11;
    L8:
        r1.append((CharSequence) r2.next());
        if (r2.hasNext() == false) goto L11;
        r1.append(", ");
    L11:
        r5.append(r1.toString());
        r5.append("]");
        return r5.toString();
    }

    public static void checkSupportedTargets(Collection<Integer> r4, int r5) {
        Preconditions.checkArgument(r4.contains(Integer.valueOf(r5)), String.format(Locale.US, "Effects target %s is not in the supported list %s.", new Object[]{getHumanReadableName(r5), getHumanReadableNames(r4)}));
    }
}
