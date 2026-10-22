package com.bytedance.locallife.poi.dito.util;

import android.graphics.Color;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f262546a = 0;

    static {
        new Regex("rgb\\((\\d{1,3}),\\s*(\\d{1,3}),\\s*(\\d{1,3})\\)");
        new Regex("rgba\\((\\d{1,3}),\\s*(\\d{1,3}),\\s*(\\d{1,3}),\\s*((0|1)(\\.\\d+)?)\\)");
    }

    public static int a(String r100) {
        if (r100 != null) goto L8;
        return 0;
    L8:
        return Color.parseColor(r100);
    L10:
        return 0;
    }
}
