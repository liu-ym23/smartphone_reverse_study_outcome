package com.ss.android.lark.chat.utils;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.File;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import java.util.List;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes35.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f416662a = 0;

    static {
    }

    @JvmStatic
    public static final boolean b(List<File> r100, List<File> r101) {
        List<File> r102 = r100;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if ((!r103) == true) goto L20;
        List<File> r104 = r101;
        if (r104 != null) goto L14;
    L17:
        boolean r105 = true;
    L19:
        if ((!r105) == true) goto L20;
        return false;
    L14:
        if (r104.isEmpty() == true) goto L17;
        r105 = false;
    L20:
        return true;
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
        goto L10
    }

    @JvmStatic
    public static final CharSequence a(CharSequence r100, List<File> r101, List<File> r102) {
        if (b(r101, r102) == true) goto L8;
        if (r100 != null) goto L12;
        return "";
    L12:
        return r100;
    L8:
        if (TextUtils.isEmpty(r100) == false) goto L11;
        return UIHelper.getString(R.string.Lark_IM_Attach_Preview_Text);
    L11:
        return new SpannableStringBuilder(r100).append(UIHelper.getString(R.string.Lark_IM_Attach_Preview_Text));
    }
}
