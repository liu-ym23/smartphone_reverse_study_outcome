package com.ss.android.lark.conditional.access.nopermission.manager;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.FieldNamingStrategy;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Locale;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class l implements FieldNamingStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f418183a = null;

    static {
        f418183a = new l();
    }

    public l() {
    }

    @Override // com.google.gson.FieldNamingStrategy
    public final String translateName(Field r100) {
        List r101 = StringsKt.split$default(r100.getName(), new String[]{"_"}, false, 0, 6, null);
        StringBuilder r102 = new StringBuilder((String) ListProtector.get(r101, 0));
        if (r101.size() <= 1) goto L8;
        int r103 = r101.size();
        int r104 = 1;
    L5:
        if (r104 >= r103) goto L8;
        r102.append(((String) ListProtector.get(r101, r104)).substring(0, 1).toUpperCase(Locale.getDefault()));
        r102.append(((String) ListProtector.get(r101, r104)).substring(1));
        r104 = r104 + 1;
    L8:
        return r102.toString();
    }
}
