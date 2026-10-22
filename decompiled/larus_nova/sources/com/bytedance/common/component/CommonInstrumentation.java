package com.bytedance.common.component;

import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.push.utils.f;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Objects;
import u67.a;
import u67.b;

/* JADX INFO: loaded from: classes15.dex */
public class CommonInstrumentation extends Instrumentation {
    public static final String KEY_INSTRUMENTATION_TYPE = "instrumentation_type";
    public static final String KEY_INSTRUMENTATION_TYPE_ALLIANCE = "instrumentation_type_alliance";
    public static final String KEY_INSTRUMENTATION_TYPE_KA = "instrumentation_type_ka";
    private final String TAG;
    private Bundle mArguments;

    public CommonInstrumentation() {
        this.TAG = "BaseInstrumentation";
    }

    private void cleanInstrumentationForSafety(Instrumentation r100) {
        cleanOneField("mWatcher", r100);
        cleanOneField("mUiAutomationConnection", r100);
    }

    @Override // android.app.Instrumentation
    public void callApplicationOnCreate(Application r100) {
        super.callApplicationOnCreate(r100);
        Bundle r101 = this.mArguments;
        if (r101 != null) goto L6;
        f.e("BaseInstrumentation", "arguments is null");
        return;
    L6:
        String r102 = r101.getString(KEY_INSTRUMENTATION_TYPE);
        if (TextUtils.isEmpty(r102) == false) goto L9;
        return;
    L9:
        if (b.f548941b == null) goto L11;
    L20:
        a r103 = (a) ((HashMap) b.f548941b.f548942a).get(r102);
        Objects.toString(r103);
        if (r103 == null) goto L27;
        getContext();
        r103.a();
        return;
    L27:
        return;
    L11:
        monitor-enter(b.class);
    L17:
        th = move-exception;
        throw th;
    L13:
        if (b.f548941b != null) goto L15;
        b.f548941b = new b();     // Catch: Throwable -> L17
    L15:
        monitor-exit(b.class);     // Catch: Throwable -> L17
        goto L20
    }

    @Override // android.app.Instrumentation
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.mArguments = r100;
        Objects.toString(r100);
    }

    private void cleanOneField(String r100, Instrumentation r101) {
        Field r102 = com.bytedance.push.utils.b.e(Instrumentation.class, r100);     // Catch: Throwable -> L8
        r102.setAccessible(true);     // Catch: Throwable -> L8
        if (r102.get(r101) == null) goto L6;
        f.e("BaseInstrumentation", "Field " + r100 + " was set, do clean!");     // Catch: Throwable -> L8
        r102.set(this, null);     // Catch: Throwable -> L8
    L6:
        f.g("BaseInstrumentation", "Clean field=" + r100);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        f.f("BaseInstrumentation", "Failed to get object of " + r100, th);
    }

    @Override // android.app.Instrumentation
    public Application newApplication(ClassLoader r100, String r101, Context r102) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        cleanInstrumentationForSafety(this);
        return super.newApplication(r100, r101, r102);
    }
}
