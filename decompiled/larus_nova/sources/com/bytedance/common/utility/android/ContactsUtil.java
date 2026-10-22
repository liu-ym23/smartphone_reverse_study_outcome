package com.bytedance.common.utility.android;

import android.util.Pair;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes15.dex */
public final class ContactsUtil {
    private static final Pattern S_TRIM_PATTERN = null;
    private static final String TAG = "ContactsUtil";

    static {
        S_TRIM_PATTERN = PatternProtector.compile("[^+0-9]");
    }

    private ContactsUtil() {
    }

    private static String filterPhoneNumber(String r100, List<Pair<Pattern, String>> r101) {
        if (r101 != null) goto L5;
    L16:
        return null;
    L5:
        if (r101.size() == 0) goto L16;
        if (StringUtils.isEmpty(r100) == true) goto L16;
        String r102 = S_TRIM_PATTERN.matcher(r100).replaceAll("");
        Iterator<Pair<Pattern, String>> r103 = r101.iterator();
    L11:
        if (r103.hasNext() == false) goto L16;
        Pair<Pattern, String> r104 = r103.next();
        Matcher r105 = ((Pattern) r104.first).matcher(r102);
        if (r105.matches() == false) goto L11;
        return r105.replaceAll((String) r104.second);
    }
}
