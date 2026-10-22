package ow1;

import com.bytedance.android.livesdkapi.feed.constant.CardStyle;
import com.bytedance.android.livesdkapi.feed.constant.FeedType;

/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f527022a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f527023b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f527024c = null;

    static {
        int[] r100 = new int[FeedType.values().length];
        f527022a = r100;
        r100[FeedType.FOLLOW_FEED.ordinal()] = 1;
        r100[FeedType.COMMON_FEED.ordinal()] = 2;
        int[] r101 = new int[CardStyle.values().length];
        f527023b = r101;
        CardStyle r102 = CardStyle.PREVIEW_CARD_H;
        r101[r102.ordinal()] = 1;
        r101[CardStyle.SMALL_CARD_D.ordinal()] = 2;
        int[] r103 = new int[CardStyle.values().length];
        f527024c = r103;
        r103[r102.ordinal()] = 1;
    }
}
