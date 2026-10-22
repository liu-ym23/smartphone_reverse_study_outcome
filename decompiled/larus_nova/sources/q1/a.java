package q1;

import android.text.TextUtils;
import com.apm.lite.nativecrash.NativeImpl;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f531237a;

    public final boolean a() {
        Map<String, String> r100 = this.f531237a;
        if (r100 != null) goto L5;
    L30:
        return false;
    L5:
        if (((HashMap) r100).isEmpty() == true) goto L30;
        if (TextUtils.isEmpty((CharSequence) ((HashMap) this.f531237a).get("process_name")) == false) goto L11;
        return false;
    L11:
        if (TextUtils.isEmpty((CharSequence) ((HashMap) this.f531237a).get("crash_thread_name")) == false) goto L14;
        return false;
    L14:
        if (TextUtils.isEmpty((CharSequence) ((HashMap) this.f531237a).get("pid")) == false) goto L17;
        return false;
    L17:
        if (TextUtils.isEmpty((CharSequence) ((HashMap) this.f531237a).get("tid")) == false) goto L20;
        return false;
    L20:
        if (TextUtils.isEmpty((CharSequence) ((HashMap) this.f531237a).get(ILoadStallMonitor.START_TIME)) == false) goto L23;
        return false;
    L23:
        if (TextUtils.isEmpty((CharSequence) ((HashMap) this.f531237a).get("crash_time")) == false) goto L26;
        return false;
    L26:
        if (TextUtils.isEmpty((CharSequence) ((HashMap) this.f531237a).get("signal_line")) == false) goto L28;
        return false;
    L28:
        return true;
    }

    public a(File r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100, "header.bin");
        if (r101.exists() == true) goto L5;
        return;
    L5:
        if (r101.length() == 0) goto L20;
        String r102 = NativeImpl.getNativeCrashHeader(r101.getAbsolutePath());
        if (r102 != null) goto L10;
        return;
    L10:
        String[] r103 = r102.split("\n");
        this.f531237a = new HashMap();
        int r104 = r103.length;
        int r105 = 0;
    L11:
        if (r105 >= r104) goto L21;
        String[] r106 = r103[r105].split(ContainerUtils.KEY_VALUE_DELIMITER);
        if (r106.length != 2) goto L15;
        Map<String, String> r107 = this.f531237a;
        HashMap r108 = (HashMap) r107;
        r108.put(r106[0], r106[1]);
    L15:
        r105 = r105 + 1;
        goto L11
    L21:
        return;
    }
}
