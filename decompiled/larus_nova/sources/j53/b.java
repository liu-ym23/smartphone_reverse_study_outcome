package j53;

import com.bytedance.android.ec.model.response.anchorv3.AuctionUserOrderInfoStruct;
import com.bytedance.android.shopping.anchorv3.auction.data.remote.RecordList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b {
    public static final a a(AuctionUserOrderInfoStruct r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toAuctionOfferRecordItem");
        String r101 = r100.getUserName();
        if (r101 != null) goto L5;
        String r102 = "";
    L6:
        String r103 = r100.getUserAvatar();
        if (r103 != null) goto L9;
        String r104 = "";
    L10:
        String r105 = r102;
        String r106 = r104;
        return new a(r105, r106, r100.getPrice(), r100.getRecordTime(), r100.getTextStatus());
    L9:
        r104 = r103;
        goto L10
    L5:
        r102 = r101;
        goto L6
    }

    public static final a b(RecordList r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toAuctionOfferRecordItem");
        String r101 = r100.getUserName();
        if (r101 != null) goto L5;
        String r102 = "";
    L6:
        String r103 = r100.getUserAvatar();
        if (r103 != null) goto L9;
        String r104 = "";
    L10:
        long r105 = r100.getPrice();
        String r106 = r100.getRecordTime();
        if (r106 != null) goto L13;
        String r107 = "";
    L14:
        String r108 = r100.getTextStatus();
        if (r108 != null) goto L18;
        r108 = "";
    L18:
        return new a(r102, r104, r105, r107, r108);
    L13:
        r107 = r106;
        goto L14
    L9:
        r104 = r103;
        goto L10
    L5:
        r102 = r101;
        goto L6
    }
}
