package com.larksuite.component.blockit.props;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.widget.codeblock.entity.LineContent;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes24.dex */
public final class c {
    public static CharSequence a(List<f> r100, Map<String, Object> r101) {
        SpannableStringBuilder r102 = new SpannableStringBuilder();
        if (CollectionUtils.isEmpty(r100) == true) goto L12;
        int r103 = 0;
    L6:
        if (r103 >= r100.size()) goto L12;
        String r104 = "#" + ((f) ListProtector.get(r100, r103)).f283114a;
        String r105 = ((f) ListProtector.get(r100, r103)).f283115b;
        String r106 = ((f) ListProtector.get(r100, r103)).f283116c;
        SpannableString r107 = new SpannableString(r104);
        r107.setSpan(new b(r105, r106, r101), 0, r104.length(), 33);
        r102.append(r107);
        if (r103 >= (r100.size() - 1)) goto L10;
        String r108 = LineContent.FOUR_SPACE;
    L11:
        r102.append(r108);
        r103 = r103 + 1;
        goto L6
    L10:
        r108 = " ";
    L12:
        return r102;
    }
}
