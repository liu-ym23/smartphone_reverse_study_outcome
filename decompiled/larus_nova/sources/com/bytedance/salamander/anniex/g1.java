package com.bytedance.salamander.anniex;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.sdk.xbridge.cn.runtime.model.SettingValueType;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class g1 {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f268078a = null;

        static {
            int[] r100 = new int[AnnieXSLAppSettingsType.values().length];
            r100[AnnieXSLAppSettingsType.STRING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[AnnieXSLAppSettingsType.INT32.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[AnnieXSLAppSettingsType.BOOL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[AnnieXSLAppSettingsType.FLOAT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[AnnieXSLAppSettingsType.DOUBLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[AnnieXSLAppSettingsType.LONG.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f268078a = r100;
        }
    }

    public g1() {
    }

    public final Object a(String r100, AnnieXSLAppSettingsType r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "type");
        ArrayList r102 = new ArrayList();
        switch(a.f268078a[r101.ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        re7.a r103 = new re7.a(r100, SettingValueType.LONG);
    L12:
        r102.add(r103);
        XBaseRuntime.f270095a.getClass();
        IHostContextDepend r104 = XBaseRuntime.f270100f;
        if (r104 == null) goto L15;
        List<re7.b> r105 = r104.getSettings(r102);
    L16:
        if (r105 != null) goto L18;
    L21:
        return null;
    L18:
        if (r105.size() <= 0) goto L21;
        return ((re7.b) ListProtector.get(r105, 0)).f537436b;
    L15:
        r105 = null;
        goto L16
    L7:
        r103 = new re7.a(r100, SettingValueType.DOUBLE);
        goto L12
    L8:
        r103 = new re7.a(r100, SettingValueType.FLOAT);
        goto L12
    L9:
        r103 = new re7.a(r100, SettingValueType.BOOL);
        goto L12
    L10:
        r103 = new re7.a(r100, SettingValueType.INT32);
        goto L12
    L11:
        r103 = new re7.a(r100, SettingValueType.STRING);
        goto L12
    L5:
        throw new NoWhenBranchMatchedException();
    }
}
