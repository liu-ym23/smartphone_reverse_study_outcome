package mw1;

import com.bytedance.android.livesdkapi.feed.constant.CardStyle;
import com.bytedance.android.livesdkapi.feed.constant.FeedStyle;
import com.bytedance.android.livesdkapi.feed.constant.FeedType;

/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f515917a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f515918b = null;

    static {
        int[] r100 = new int[FeedType.values().length];
        r100[FeedType.FOLLOW_FEED.ordinal()] = 1;
        r100[FeedType.COMMON_FEED.ordinal()] = 2;
        int[] r101 = new int[FeedStyle.values().length];
        f515917a = r101;
        r101[FeedStyle.SINGLE_LIST_H.ordinal()] = 1;
        r101[FeedStyle.DOUBLE_LIST_D.ordinal()] = 2;
        r101[FeedStyle.SIMPLE_LIST.ordinal()] = 3;
        int[] r102 = new int[CardStyle.values().length];
        f515918b = r102;
        r102[CardStyle.PREVIEW_CARD_H.ordinal()] = 1;
    }
}
