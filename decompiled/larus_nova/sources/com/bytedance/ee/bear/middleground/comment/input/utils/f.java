package com.bytedance.ee.bear.middleground.comment.input.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f232009a = null;

    static {
        f232009a = CollectionsKt.listOf(new String[]{"http://", "https://"});
    }

    @JvmStatic
    public static final boolean a(CharSequence r110, List<e> r111) {
        Intrinsics.checkNotNullParameter(r110, "data");
        Intrinsics.checkNotNullParameter(r111, "urls");
        Intrinsics.checkNotNullParameter(r110, "data");
        Intrinsics.checkNotNullParameter(r111, "urls");
        Intrinsics.checkNotNullParameter("((?:https?://([\\-a-zA-Z0-9:%_+~#@]{1,256}\\.){1,50}[a-z\\-]{2,15})|(?:([\\-a-zA-Z0-9:%_+~#@]{1,256}\\.){1,50}(?:com|org|net|int|edu|gov|mil|ac|ad|ae|af|ag|ai|al|am|an|ao|aq|ar|as|at|au|aw|ax|az|ba|bb|bd|be|bf|bg|bh|bi|bj|bm|bn|bo|br|bs|bt|bv|bw|by|bz|ca|cc|cf|cg|ch|ci|ck|cl|cm|cn|co|cr|cu|cv|cw|cx|cy|cz|de|dj|dk|dm|do|dz|ec|ee|eg|eh|er|es|et|eu|fi|fj|fk|fm|fo|fr|ga|gb|gd|ge|gf|gh|gi|gl|gm|gn|gp|gr|gs|gt|gu|gw|gy|hk|hm|hn|hr|ht|hu|id|ie|il|im|in|io|iq|ir|is|it|jm|jo|jp|ke|kg|kh|ki|km|kn|kp|kr|kw|ky|kz|la|lb|lc|li|lk|lr|ls|lt|lu|lv|ly|ma|mc|md|me|mf|mg|mh|mk|ml|mm|mn|mo|mp|mq|mr|ms|mt|mu|mv|mw|mx|my|mz|na|nc|ne|nf|ng|ni|nl|no|np|nr|nu|nz|om|pa|pe|pf|pg|ph|pk|pl|pm|pn|pr|ps|pt|pw|py|qa|re|ro|rs|ru|rw|sa|sb|sc|sd|se|sg|sh|si|sj|sk|sl|sm|sn|so|sr|ss|st|su|sv|sx|sy|sz|tc|td|tf|tg|th|tj|tk|tl|tm|tn|to|tp|tr|tt|tv|tw|tz|ua|ug|uk|um|us|uy|uz|va|vc|ve|vg|vi|vn|vu|wf|ws|ye|yt|za|zm|zw|site|top|wtf|xxx|xyz|cloud|engineering|help|one)))(:[0-9]{2,5})?\\b([/?#][-a-zA-Z0-9@:%_+.~#?&/=;()$,!*\\[\\]{}^|<>]*)?", "regexString");
        Regex r100 = new Regex("((?:https?://([\\-a-zA-Z0-9:%_+~#@]{1,256}\\.){1,50}[a-z\\-]{2,15})|(?:([\\-a-zA-Z0-9:%_+~#@]{1,256}\\.){1,50}(?:com|org|net|int|edu|gov|mil|ac|ad|ae|af|ag|ai|al|am|an|ao|aq|ar|as|at|au|aw|ax|az|ba|bb|bd|be|bf|bg|bh|bi|bj|bm|bn|bo|br|bs|bt|bv|bw|by|bz|ca|cc|cf|cg|ch|ci|ck|cl|cm|cn|co|cr|cu|cv|cw|cx|cy|cz|de|dj|dk|dm|do|dz|ec|ee|eg|eh|er|es|et|eu|fi|fj|fk|fm|fo|fr|ga|gb|gd|ge|gf|gh|gi|gl|gm|gn|gp|gr|gs|gt|gu|gw|gy|hk|hm|hn|hr|ht|hu|id|ie|il|im|in|io|iq|ir|is|it|jm|jo|jp|ke|kg|kh|ki|km|kn|kp|kr|kw|ky|kz|la|lb|lc|li|lk|lr|ls|lt|lu|lv|ly|ma|mc|md|me|mf|mg|mh|mk|ml|mm|mn|mo|mp|mq|mr|ms|mt|mu|mv|mw|mx|my|mz|na|nc|ne|nf|ng|ni|nl|no|np|nr|nu|nz|om|pa|pe|pf|pg|ph|pk|pl|pm|pn|pr|ps|pt|pw|py|qa|re|ro|rs|ru|rw|sa|sb|sc|sd|se|sg|sh|si|sj|sk|sl|sm|sn|so|sr|ss|st|su|sv|sx|sy|sz|tc|td|tf|tg|th|tj|tk|tl|tm|tn|to|tp|tr|tt|tv|tw|tz|ua|ug|uk|um|us|uy|uz|va|vc|ve|vg|vi|vn|vu|wf|ws|ye|yt|za|zm|zw|site|top|wtf|xxx|xyz|cloud|engineering|help|one)))(:[0-9]{2,5})?\\b([/?#][-a-zA-Z0-9@:%_+.~#?&/=;()$,!*\\[\\]{}^|<>]*)?");
        LinkedList r101 = new LinkedList();
        int r102 = r110.length();
    L3:
        if (r102 < 0) goto L12;
        int r103 = StringsKt.lastIndexOfAny$default(r110, f232009a, r102 - 1, false, 4, null);
        if (r103 == (-1)) goto L11;
        MatchResult r104 = Regex.find$default(r100, r110.subSequence(r103, r102), 0, 2, null);
        if (r104 == null) goto L11;
        String r105 = r104.getValue();
        if (r105 == null) goto L11;
        r101.add(0, new e(r105));
    L11:
        r102 = r103;
        goto L3
    L12:
        tt5.a.h("UrlUtils", "findUrls: find " + r101.size() + " urls");
        ((ArrayList) r111).addAll(r101);
        return !r101.isEmpty();
    }
}
