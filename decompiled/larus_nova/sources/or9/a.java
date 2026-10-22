package or9;

import com.larus.platform.model.video.business.EnterVideoMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a {
    public static final EnterVideoMethod a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        EnterVideoMethod r101 = EnterVideoMethod.MAIN_DOUBLE_TAG;
        if (Intrinsics.areEqual(r100, r101.getValue()) == true) goto L37;
        EnterVideoMethod r102 = EnterVideoMethod.INDEPENDENT_DOU_YIN_BOT;
        if (Intrinsics.areEqual(r100, r102.getValue()) == true) goto L38;
        EnterVideoMethod r103 = EnterVideoMethod.BOTTOM_TAB;
        if (Intrinsics.areEqual(r100, r103.getValue()) == true) goto L39;
        EnterVideoMethod r104 = EnterVideoMethod.OUTER_PUSH;
        if (Intrinsics.areEqual(r100, r104.getValue()) == true) goto L40;
        EnterVideoMethod r105 = EnterVideoMethod.SEARCH_VIDEO_PAGE;
        if (Intrinsics.areEqual(r100, r105.getValue()) == true) goto L41;
        EnterVideoMethod r106 = EnterVideoMethod.WELCOME_BACK_AWEME_VIDEO_CARD_LIST;
        if (Intrinsics.areEqual(r100, r106.getValue()) == true) goto L42;
        EnterVideoMethod r107 = EnterVideoMethod.CLICK_NOTIFY_BANNER;
        if (Intrinsics.areEqual(r100, r107.getValue()) == true) goto L43;
        EnterVideoMethod r108 = EnterVideoMethod.COLLECTION_VIDEO_PAGE;
        if (Intrinsics.areEqual(r100, r108.getValue()) == true) goto L44;
        EnterVideoMethod r109 = EnterVideoMethod.CLICK_MUSIC_FLOAT_WINDOW;
        if (Intrinsics.areEqual(r100, r109.getValue()) == true) goto L45;
        EnterVideoMethod r110 = EnterVideoMethod.FLOW_CLICK_RECOMMEND_VIDEO_CARD;
        if (Intrinsics.areEqual(r100, r110.getValue()) == true) goto L46;
        EnterVideoMethod r111 = EnterVideoMethod.POI_VIDEO_PAGE;
        if (Intrinsics.areEqual(r100, r111.getValue()) == false) goto L36;
        return r111;
    L36:
        return EnterVideoMethod.NONE;
    L46:
        return r110;
    L45:
        return r109;
    L44:
        return r108;
    L43:
        return r107;
    L42:
        return r106;
    L41:
        return r105;
    L40:
        return r104;
    L39:
        return r103;
    L38:
        return r102;
    L37:
        return r101;
    }
}
