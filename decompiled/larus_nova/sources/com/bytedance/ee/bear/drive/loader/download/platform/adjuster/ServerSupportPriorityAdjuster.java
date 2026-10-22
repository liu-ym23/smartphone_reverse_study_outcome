package com.bytedance.ee.bear.drive.loader.download.platform.adjuster;

import android.util.SparseArray;
import com.bytedance.common.utility.Lists;
import g85.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import w75.c;

/* JADX INFO: loaded from: classes16.dex */
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

        public /* synthetic */ SelfAdaptionPriorityComparator(AnonymousClass1 r100) {
            this();
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(Integer r100, Integer r101) {
            if (r100.intValue() != 3) goto L5;
            return -1;
        L5:
            if (r100.intValue() != 9) goto L7;
            return -1;
        L7:
            if (r100.intValue() != 11) goto L10;
            return -1;
        L10:
            if (r101.intValue() != 3) goto L12;
            return 1;
        L12:
            if (r101.intValue() != 9) goto L14;
            return 1;
        L14:
            if (r101.intValue() == 11) goto L23;
            return 0;
        L23:
            return 1;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Integer r100, Integer r101) {
            return compare2(r100, r101);
        }
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster
    public String getName() {
        return "ServerSupportPriorityAdjuster";
    }

    static {
        sPriorityComparator = new SelfAdaptionPriorityComparator(null);
    }

    public ServerSupportPriorityAdjuster(List<Integer> r100) {
        if (r100 == null) goto L5;
        this.mServerList = new ArrayList(r100);
        return;
    L5:
        this.mServerList = new ArrayList(1);
    }

    @Override // com.bytedance.ee.bear.drive.loader.download.platform.adjuster.IPriorityAdjuster
    public List<Integer> adjust(c r100, List<Integer> r101) {
        SparseArray<String> r102 = g.f480400a;
        if (Lists.deepEquals(Collections.singletonList(-1), r101) == true) goto L5;
        ArrayList r103 = new ArrayList(3);
        r103.add(-3);
        r103.retainAll(r101);
        r101.retainAll(this.mServerList);
        this.mServerList.removeAll(r101);
        List<Integer> r104 = this.mServerList;
        ArrayList r105 = new ArrayList();
        r105.add(1);
        r105.add(2);
        r105.add(7);
        r105.add(8);
        r105.add(3);
        r105.add(9);
        r104.retainAll(r105);
        r101.addAll(this.mServerList);
        r101.addAll(r103);
        return r101;
    L5:
        if (this.mServerList.contains(-2) == false) goto L7;
        this.mServerList.remove(-2);
    L7:
        Collections.sort(this.mServerList, sPriorityComparator);
        this.mServerList.addAll(r101);
        return this.mServerList;
    }
}
