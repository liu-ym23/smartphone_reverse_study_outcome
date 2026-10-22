package com.ss.android.lark.todo.impl.features.detail.sections;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.FieldNamingStrategy;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class v1 implements FieldNamingStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v1 f443457a = null;

    static {
        f443457a = new v1();
    }

    public v1() {
    }

    @Override // com.google.gson.FieldNamingStrategy
    public final String translateName(Field r100) {
        int r101 = com.ss.android.lark.todo.impl.utils.f.f444288a;
        String r102 = r100.getName();
        Intrinsics.checkNotNullParameter(r102, "underscore");
        List r103 = StringsKt.split$default(r102, new String[]{"_"}, false, 0, 6, null);
        if (r103.size() == 1) goto L20;
        StringBuilder r104 = new StringBuilder();
        r104.append((String) ListProtector.get(r103, 0));
        int r105 = r103.size();
        int r106 = 1;
    L6:
        if (r106 >= r105) goto L16;
        String r107 = ((String) ListProtector.get(r103, r106)).toLowerCase(Locale.ROOT);
        char[] r108 = r107.toCharArray();
        if (r108.length != 0) goto L10;
        boolean r109 = true;
    L11:
        if (r109 == true) goto L14;
        r108[0] = (char) (r108[0] - ' ');
        r107 = new String(r108);
    L14:
        r104.append(r107);
        r106 = r106 + 1;
        goto L6
    L10:
        r109 = false;
        goto L11
    L16:
        return r104.toString();
    L20:
        return r102;
    }
}
