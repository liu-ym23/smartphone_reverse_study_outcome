package com.lynx.tasm.behavior.ui.accessibility;

import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<JavaOnlyMap> f382446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f382447b;

    public static String b(int r100) {
        if (r100 != 0) goto L4;
        return "insert";
    L4:
        if (r100 != 1) goto L6;
        return "remove";
    L6:
        if (r100 != 2) goto L8;
        return "detach";
    L8:
        if (r100 != 3) goto L10;
        return "update";
    L10:
        if (r100 == 4) goto L13;
        return "";
    L13:
        return "style_update";
    }

    public a() {
        this.f382446a = new ArrayList();
        this.f382447b = new HashSet();
    }

    public final void a(int r100, LynxBaseUI r101, String r102) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (b(r100).isEmpty() == true) goto L14;
        JavaOnlyMap r103 = new JavaOnlyMap();
        r103.putInt(PickerReporterConstants.KEY.TARGET, r101.getSign());
        r103.putString("action", b(r100));
        r103.putString("a11y-id", r101.getAccessibilityId());
        if (r100 == 4) goto L8;
    L11:
        this.f382446a.add(r103);
        return;
    L8:
        if (((HashSet) this.f382447b).contains(r102) == true) goto L10;
        return;
    L10:
        r103.putString("style", r102);
        goto L11
    }
}
