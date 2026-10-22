package com.bytedance.ee.bear.drive.loader.download.platform.adjuster;

import android.util.SparseArray;
import com.bytedance.common.utility.Lists;
import g85.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import w75.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ServerSupportPriorityAdjuster implements IPriorityAdjuster {
    private static final String TAG = "DrivePlatform_ServerSupportAdjuster";
    private static SelfAdaptionPriorityComparator sPriorityComparator;
    private List<Integer> mServerList;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.loader.download.platform.adjuster.ServerSupportPriorityAdjuster$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class SelfAdaptionPriorityComparator implements Comparator<Integer> {
        private SelfAdaptionPriorityComparator() {
        }

        public /* synthetic */ SelfAdaptionPriorityComparator(AnonymousClass1 r1) {
            this();
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(Integer r4, Integer r5) {
            if (r4.intValue() != 3) goto L5;
            return -1;
        L5:
            if (r4.intValue() != 9) goto L7;
            return -1;
        L7:
            if (r4.intValue() != 11) goto L10;
            return -1;
        L10:
            if (r5.intValue() != 3) goto L12;
            return 1;
        L12:
            if (r5.intValue() != 9) goto L14;
            return 1;
        L14:
            if (r5.intValue() == 11) goto L23;
            return 0;
        L23:
            return 1;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Integer r1, Integer r2) {
            return compare2(r1, r2);
        }
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster
    public String getName() {
        return "ServerSupportPriorityAdjuster";
    }

    static {
        sPriorityComparator = new SelfAdaptionPriorityComparator(null);
    }

    public ServerSupportPriorityAdjuster(List<Integer> r2) {
        if (r2 == null) goto L5;
        this.mServerList = new ArrayList(r2);
        return;
    L5:
        this.mServerList = new ArrayList(1);
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster
    public List<Integer> adjust(c r5, List<Integer> r6) {
        SparseArray<String> r7 = g.a;
        if (Lists.deepEquals(Collections.singletonList(-1), r6) == true) goto L5;
        ArrayList r8 = new ArrayList(3);
        r8.add(-3);
        r8.retainAll(r6);
        r6.retainAll(this.mServerList);
        this.mServerList.removeAll(r6);
        List<Integer> r1 = this.mServerList;
        ArrayList r2 = new ArrayList();
        r2.add(1);
        r2.add(2);
        r2.add(7);
        r2.add(8);
        r2.add(3);
        r2.add(9);
        r1.retainAll(r2);
        r6.addAll(this.mServerList);
        r6.addAll(r8);
        return r6;
    L5:
        if (this.mServerList.contains(-2) == false) goto L7;
        this.mServerList.remove(-2);
    L7:
        Collections.sort(this.mServerList, sPriorityComparator);
        this.mServerList.addAll(r6);
        return this.mServerList;
    }
}
