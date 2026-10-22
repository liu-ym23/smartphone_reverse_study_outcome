package com.ss.android.lark.todo.impl.utils;

import android.app.Application;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.larus.nova.R;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f444291a = null;

    static {
        f444291a = new i();
    }

    public i() {
    }

    private final Resources getResources() {
        Application r100 = LarkContext.getApplication();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getResources();
    }

    public final ColorStateList b() {
        Resources r100 = getResources();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getColorStateList(R.color.todo_container_item_text_color);
    }

    public final int a(int r100) {
        Resources r101 = getResources();
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.getColor(r100);
    }

    public final Drawable c(int r100) {
        Resources r101 = getResources();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getDrawable(r100);
    }

    public final String g(int r100) {
        Resources r101 = getResources();
        if (r101 == null) goto L6;
        String r102 = r101.getString(r100);
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    public static String e(int r100, Map r101) {
        Intrinsics.checkNotNullParameter(r101, "dataMap");
        String r102 = UIHelper.mustacheFormat(r100, r101);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r102);     // Catch: Exception -> L5
        return r102;
    L5:
        return "";
    }

    public final String f(int r100, int r101) {
        Resources r102 = getResources();
        if (r102 == null) goto L6;
        String r103 = r102.getQuantityString(r100, r101, new Object[]{Integer.valueOf(r101)});
        if (r103 == null) goto L6;
        return r103;
    L6:
        return "";
    }

    public static String d(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        String r103 = UIHelper.mustacheFormat(r100, r101, r102);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r103);     // Catch: Exception -> L5
        return r103;
    L5:
        return "";
    }
}
