package com.ss.android.ugc.aweme.search.utils;

import androidx.viewpager.widget.ViewPager;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes40.dex */
public class ECSearchViewPagerUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Field f453411a = null;

    static {
        Field r100 = ViewPager.LayoutParams.class.getDeclaredField("position");     // Catch: NoSuchFieldException -> L4
        f453411a = r100;     // Catch: NoSuchFieldException -> L4
        r100.setAccessible(true);     // Catch: NoSuchFieldException -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
