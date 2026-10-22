package gw2;

import com.bytedance.android.livehostapi.business.depend.publish.MatchRecordStatus;

/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f483025a = null;

    static {
        int[] r100 = new int[MatchRecordStatus.values().length];
        f483025a = r100;
        r100[MatchRecordStatus.START.ordinal()] = 1;
        r100[MatchRecordStatus.FAIL.ordinal()] = 2;
        r100[MatchRecordStatus.CANCEL.ordinal()] = 3;
        r100[MatchRecordStatus.SUCCESS.ordinal()] = 4;
        r100[MatchRecordStatus.PROGRESS.ordinal()] = 5;
    }
}
