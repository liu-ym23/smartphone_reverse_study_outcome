package com.ss.android.lark.chat.utils;

import android.text.TextUtils;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class a0 {
    static {
    }

    @JvmStatic
    public static final String b(HashMap<String, String> r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        Locale r101 = ChatCoreModule.a().getLanguageDependency().getCacheLanguageSetting();
        String r102 = StringsKt.replace$default(new Locale(r101.getLanguage(), r101.getCountry()).toLanguageTag(), "-", "_", false, 4, null).toLowerCase(Locale.getDefault());
        if (TextUtils.isEmpty(a(r100, r102)) == true) goto L9;
        return a(r100, r102);
    L9:
        return a(r100, "en_us");
    }

    public static String a(HashMap r100, String r101) {
        Iterator r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Map.Entry r103 = (Map.Entry) r102.next();
        if (Intrinsics.areEqual(((String) r103.getKey()).toLowerCase(Locale.getDefault()), r101) == false) goto L4;
        return (String) r103.getValue();
    L9:
        return "";
    }
}
