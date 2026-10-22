package com.bytedance.ee.docsdk.impl.utils.keyboard.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import com.ss.android.lark.chameleon.idependency.Log;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/utils/keyboard/utils/HardKeyboardUtils;", "", "()V", "hasHardKeyboard", "", "context", "Landroid/content/Context;", "isOverVersion", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class HardKeyboardUtils {
    public static final HardKeyboardUtils INSTANCE = null;

    static {
        INSTANCE = new HardKeyboardUtils();
    }

    private HardKeyboardUtils() {
    }

    @JvmStatic
    public static final boolean isOverVersion() {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        return true;
    L5:
        return false;
    }

    @JvmStatic
    public static final boolean hasHardKeyboard(Context r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        Configuration r5 = r4.getResources().getConfiguration();
        StringBuilder r1 = new StringBuilder(" hardKeyboardHidden=");
        Integer r2 = null;
        if (r5 == null) goto L8;
        Integer r3 = Integer.valueOf(r5.hardKeyboardHidden);
    L9:
        r1.append(r3);
        r1.append(" keyboard=");
        if (r5 == null) goto L12;
        r2 = Integer.valueOf(r5.keyboard);
    L12:
        r1.append(r2);
        Log.i("HardKeyboardUtils", r1.toString());
        if (r5 != null) goto L15;
    L17:
        boolean r6 = false;
    L18:
        if (r6 == false) goto L25;
        int r7 = r5.keyboard;
        if (r7 != 2) goto L22;
    L23:
        return true;
    L22:
        if (r7 == 3) goto L23;
        return false;
    L25:
        return false;
    L15:
        if (r5.hardKeyboardHidden != 1) goto L17;
        r6 = true;
        goto L18
    L8:
        r3 = null;
        goto L9
    }
}
