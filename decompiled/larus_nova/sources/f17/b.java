package f17;

import com.bytedance.lynx.webview.internal.EventType;
import com.bytedance.lynx.webview.internal.LibraryLoader;
import com.bytedance.lynx.webview.internal.LoadEventType;
import com.bytedance.lynx.webview.internal.r;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import l17.m;

/* JADX INFO: loaded from: classes21.dex */
public class b implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f475074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f475075b;

    public final boolean a() {
        return new PolarisFileWrapper(m.g(this.f475075b)).exists();
    }

    public final boolean b() {
        return new PolarisFileWrapper(m.c(this.f475075b)).exists();
    }

    public final int d() {
        return CastIntegerProtector.parseInt(this.f475074a.substring(0, 3));
    }

    public final boolean e() {
        if (this.f475074a.equals("0620010001") == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f475075b.equals("") == false) goto L7;
        return true;
    }

    public String toString() {
        return "VersionPair{mCoreVersion='" + this.f475074a + "', mCoreMd5='" + this.f475075b + "'}";
    }

    public b() {
        this.f475074a = "0620010001";
        this.f475075b = "";
    }

    public Object clone() throws CloneNotSupportedException {
        return (b) super.clone();
    }

    public final boolean c(LibraryLoader.e r100) {
        if (e() == true) goto L16;
        r100.f265155a = LoadEventType.CheckSoVersion_has_cachesoVersionCode;
        if (this.f475074a.length() < 10) goto L17;
        r100.f265155a = LoadEventType.CheckSoVersion_not_old_soVersion;
        if (this.f475074a.compareToIgnoreCase("0621130004009") < 0) goto L17;
        if (this.f475074a.length() != k17.a.f501382c.length()) goto L17;
        if (this.f475074a.substring(3, 6).compareToIgnoreCase("113") >= 0) goto L16;
    L17:
        boolean r101 = false;
    L18:
        if (r101 == true) goto L20;
        r.d("[Load] checkNewSdkSoVersion failed." + this.f475074a);
        com.bytedance.lynx.webview.a.d(EventType.LOAD_SDK_SO_MISMATCH);
    L20:
        return r101;
    L16:
        r101 = true;
        goto L18
    }

    public b(String r100, String r101) {
        this.f475074a = r100;
        this.f475075b = r101;
    }
}
