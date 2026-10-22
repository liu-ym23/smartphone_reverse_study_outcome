package com.ss.android.ugc.aweme.search.vision.result.panel.widget;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/ss/android/ugc/aweme/search/vision/result/panel/widget/PhotoSearchAppBarStateChangeListener$State", "", "Lcom/ss/android/ugc/aweme/search/vision/result/panel/widget/PhotoSearchAppBarStateChangeListener$State;", "EXPANDED", "COLLAPSED", "IDLE", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PhotoSearchAppBarStateChangeListener$State extends Enum<PhotoSearchAppBarStateChangeListener$State> {
    public static final PhotoSearchAppBarStateChangeListener$State COLLAPSED = null;
    public static final PhotoSearchAppBarStateChangeListener$State EXPANDED = null;
    public static final PhotoSearchAppBarStateChangeListener$State IDLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PhotoSearchAppBarStateChangeListener$State[] f453725a = null;

    static {
        PhotoSearchAppBarStateChangeListener$State r100 = new PhotoSearchAppBarStateChangeListener$State("EXPANDED", 0);
        EXPANDED = r100;
        PhotoSearchAppBarStateChangeListener$State r101 = new PhotoSearchAppBarStateChangeListener$State("COLLAPSED", 1);
        COLLAPSED = r101;
        PhotoSearchAppBarStateChangeListener$State r102 = new PhotoSearchAppBarStateChangeListener$State("IDLE", 2);
        IDLE = r102;
        f453725a = new PhotoSearchAppBarStateChangeListener$State[]{r100, r101, r102};
    }

    public static PhotoSearchAppBarStateChangeListener$State valueOf(String r100) {
        return (PhotoSearchAppBarStateChangeListener$State) a.a(PhotoSearchAppBarStateChangeListener$State.class, r100);
    }

    public static PhotoSearchAppBarStateChangeListener$State[] values() {
        return (PhotoSearchAppBarStateChangeListener$State[]) f453725a.clone();
    }

    public PhotoSearchAppBarStateChangeListener$State(String r100, int r101) {
        super(r100, r101);
    }
}
