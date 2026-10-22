package com.bytedance.android.shopping.deepfeed.slice.view.lottie;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010'\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\"\u0010\u0002\u001a\u001e\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 3})
final class DeepFeedLottieJsonModifier$buildModifyParamsSignature$stableString$1 extends Lambda implements Function1<Map.Entry<String, String>, CharSequence> {
    public static final DeepFeedLottieJsonModifier$buildModifyParamsSignature$stableString$1 INSTANCE = null;

    static {
        INSTANCE = new DeepFeedLottieJsonModifier$buildModifyParamsSignature$stableString$1();
    }

    public DeepFeedLottieJsonModifier$buildModifyParamsSignature$stableString$1() {
        super(1);
    }

    public final CharSequence invoke(Map.Entry<String, String> r7) {
        Intrinsics.checkNotNullParameter(r7, "<name for destructuring parameter 0>");
        String r0 = r7.getKey();
        String r8 = r7.getValue();
        StringBuilder r1 = new StringBuilder();
        int r2 = b.a;
        if (StringsKt.startsWith$default(r0, "placeholder_", false, 2, null) == true) goto L6;
        r0 = "placeholder_" + r0;
    L6:
        r1.append(r0);
        r1.append('=');
        r1.append(r8);
        return r1.toString();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Map.Entry) r1);
    }
}
