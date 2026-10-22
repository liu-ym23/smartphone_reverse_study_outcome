package com.bytedance.ee.docsdk.impl.utils.keyboard.storage;

import android.app.Activity;
import android.content.SharedPreferences;
import com.ss.android.lark.chameleon.idependency.Env;
import com.ss.android.lark.chameleon.idependency.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/utils/keyboard/storage/KeyboardHeightSaver;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "realScreenHeight", "", "getKey", "", "orientation", "loadKeyboardHeight", "saveKeyboardHeight", "", "keyboardHeight", "setScreenHeight", "height", "Companion", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KeyboardHeightSaver {
    public static final Companion Companion = null;
    private static final String LANDSCAPE_KH_KEY = "landscape_kh";
    private static final String PORTRAIT_KH_KEY = "portrait_kh";
    private static final String TAG = "InsetsBaseKBH#Saver";
    private final Activity activity;
    private int realScreenHeight;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/utils/keyboard/storage/KeyboardHeightSaver$Companion;", "", "()V", "LANDSCAPE_KH_KEY", "", "PORTRAIT_KH_KEY", "TAG", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final String getKey(int r2) {
        if (r2 != 2) goto L5;
        return LANDSCAPE_KH_KEY;
    L5:
        return PORTRAIT_KH_KEY;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public KeyboardHeightSaver(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.activity = r2;
        this.realScreenHeight = 300;
    }

    public final int loadKeyboardHeight(int r10) {
        SharedPreferences r0 = Env.getApplication().getSharedPreferences("keyboard_height", 0);
        String r11 = getKey(r10);
        int r1 = r0.getInt(r11, 0);
        Log.i(TAG, "loadKeyboardHeight from sp (" + r11 + " : " + r1 + ')');
        int r2 = this.realScreenHeight;
        if (r1 >= ((int) (((double) r2) * 0.2d))) goto L6;
        int r3 = (int) (((double) r2) * 0.25d);
        Log.i(TAG, "loadKeyboardHeight from cal : (" + r11 + " : " + r3 + ')');
        return r3;
    L6:
        return r1;
    }

    public final void setScreenHeight(int r1) {
        this.realScreenHeight = r1;
    }

    public final void saveKeyboardHeight(int r4, int r5) {
        SharedPreferences.Editor r0 = Env.getApplication().getSharedPreferences("keyboard_height", 0).edit();
        String r6 = getKey(r5);
        Log.d(TAG, "saveKeyboardHeight to sp (" + r6 + " : " + r4 + ')');
        r0.putInt(r6, r4);
        r0.apply();
    }
}
