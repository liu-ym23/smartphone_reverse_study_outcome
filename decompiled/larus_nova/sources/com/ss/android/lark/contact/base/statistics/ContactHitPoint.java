package com.ss.android.lark.contact.base.statistics;

import com.ss.android.lark.contact.base.dependency.ContactBaseModuleDependency;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.statistics.Statistics;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public final class ContactHitPoint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f418947a = null;

    static {
        f418947a = LazyKt.lazy(ContactHitPoint$contactMainClickTargetMap$2.INSTANCE);
    }

    public static String a() {
        ContactBaseModuleDependency r100 = ContactBaseModuleDependency.f418857b;
        if (r100.isSimpleTenant() == true) goto L5;
        return "member";
    L5:
        if (r100.isSmallB() == false) goto L7;
        return "simple_user";
    L7:
        return "c_user";
    }

    @JvmStatic
    public static final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        JSONObject r101 = new JSONObject();
        r101.put("click", r100);
        r101.put(PickerReporterConstants.KEY.TARGET, ((Map) f418947a.getValue()).get(r100));
        Statistics.sendEvent("contact_external_click", r101);
    }

    @JvmStatic
    public static final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        JSONObject r101 = new JSONObject();
        r101.put("click", r100);
        r101.put(PickerReporterConstants.KEY.TARGET, ((Map) f418947a.getValue()).get(r100));
        Statistics.sendEvent("contact_group_click", r101);
    }

    @JvmStatic
    public static final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        JSONObject r101 = new JSONObject();
        r101.put("click", r100);
        r101.put(PickerReporterConstants.KEY.TARGET, ((Map) f418947a.getValue()).get(r100));
        Statistics.sendEvent("contact_new_click", r101);
    }
}
