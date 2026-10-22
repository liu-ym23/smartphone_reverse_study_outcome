package l63;

import com.bytedance.android.shopping.anchorv3.guessulike.model.FeedbackItem;
import com.bytedance.android.shopping.anchorv3.guessulike.model.GULFeedbackResponseDTO;
import com.bytedance.android.shopping.anchorv3.guessulike.model.NegFeedbackStyle;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashSet<String> f507661a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f507662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static GULFeedbackResponseDTO f507663c;

    static {
        f507661a = new HashSet();
        f507662b = -1;
    }

    public static String a() {
        StringBuilder r100 = new StringBuilder();
        Iterator<String> r101 = f507661a.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L13;
        String r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r100.append(r103);
        if (r102 >= (f507661a.size() - 1)) goto L11;
        r100.append(",");
    L11:
        r102 = r104;
        goto L4
    L13:
        return r100.toString();
    }

    public static boolean b(Integer r100) {
        GULFeedbackResponseDTO r101 = f507663c;
        if (r101 == null) goto L7;
        Map<String, NegFeedbackStyle> r102 = r101.getNegFeedbackStyles();
        if (r102 == null) goto L7;
        NegFeedbackStyle r103 = r102.get(String.valueOf(r100));
    L9:
        if (r103 == null) goto L13;
        List<FeedbackItem> r104 = r103.getItems();
        if (r104 == null) goto L13;
        int r105 = r104.size();
    L14:
        if (r103 == null) goto L18;
        Integer r106 = r103.getFirstPageLimit();
        if (r106 == null) goto L18;
        int r107 = r106.intValue();
    L19:
        if (r105 <= r107) goto L22;
        return true;
    L22:
        return false;
    L18:
        r107 = 0;
    L13:
        r105 = 0;
    L7:
        r103 = null;
        goto L9
    }

    public static void c(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "productId");
        f507661a.add(r101 + "_2_" + r100);
    }
}
