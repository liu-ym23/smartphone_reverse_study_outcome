package q69;

import com.airbnb.lottie.LottieAnimationView;
import com.lynx.lottieadapter.LottieAdapterView;
import kotlin.jvm.internal.Intrinsics;
import v19.h;

/* JADX INFO: loaded from: classes27.dex */
public final class d {
    public static final void a(LottieAnimationView r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.cancelAnimation();
        if (r102 == false) goto L5;
        String r103 = "charging";
    L6:
        r100.setContentDescription(r103);
        boolean r104 = h.f552477a;
        if (h.a(null) == false) goto L11;
        if (r102 == false) goto L10;
        String r105 = "charging_dark";
    L14:
        r100.setAnimation(r105.concat("/data.json"));
        r100.setImageAssetsFolder(r105.concat("/images/"));
        float r106 = r101 / 100.0f;
        r100.setMinAndMaxProgress(r106, r106);
        r100.playAnimation();
        return;
    L10:
        r105 = "default_dark";
        goto L14
    L11:
        if (r102 == false) goto L13;
        r105 = "charging_light";
        goto L14
    L13:
        r105 = "default_light";
        goto L14
    L5:
        r103 = "not charging";
        goto L6
    }

    public static final void b(LottieAdapterView r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.cancelAnimation();
        if (r102 == false) goto L5;
        String r103 = "charging";
    L6:
        r100.setContentDescription(r103);
        boolean r104 = h.f552477a;
        if (h.a(null) == false) goto L11;
        if (r102 == false) goto L10;
        String r105 = "charging_dark";
    L14:
        r100.setAnimation(r105.concat("/data.json"));
        r100.setImageAssetsFolder(r105.concat("/images/"));
        float r106 = r101 / 100.0f;
        r100.setMinAndMaxProgress(r106, r106);
        r100.playAnimation();
        return;
    L10:
        r105 = "default_dark";
        goto L14
    L11:
        if (r102 == false) goto L13;
        r105 = "charging_light";
        goto L14
    L13:
        r105 = "default_light";
        goto L14
    L5:
        r103 = "not charging";
        goto L6
    }
}
