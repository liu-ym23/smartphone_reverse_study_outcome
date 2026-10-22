package l7a;

import com.lynx.tasm.base.LLog;
import com.lynx.tasm.core.resource.LynxResourceLoader;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes32.dex */
public final class a extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f507875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakReference<LynxResourceLoader> f507876d;

    public a(LynxResourceLoader r100, String r101, long r102) {
        super(r101);
        this.f507876d = new WeakReference(r100);
        this.f507875c = r102;
    }

    public final void b(boolean r100, byte[] r110, String r111) {
        if (a() == true) goto L5;
        return;
    L5:
        int r101 = 30301;
        if (r100 == false) goto L15;
        LLog.i("LynxResourceLoader", "loadExternalResourceAsync onSuccess.");
        if (r110 != null) goto L10;
    L13:
        String r102 = "get null data for provider.";
    L14:
        LynxResourceLoader.a(this.f507875c, r110, r101, r102);
        String r103 = r102;
        int r104 = r101;
        String r105 = null;
    L16:
        if (r104 == 0) goto L21;
        LynxResourceLoader r106 = this.f507876d.get();
        if (r106 == null) goto L22;
        UIThreadUtils.runOnUiThread(new d(r106, r104, "loadExternalResource", r103, r105, this.f507879b));
        return;
    L22:
        return;
    L21:
        return;
    L10:
        if (r110.length == 0) goto L13;
        r101 = 0;
        r102 = null;
        goto L14
    L15:
        LynxResourceLoader.a(this.f507875c, null, 30301, "Error when fetch script: " + r111);
        r103 = "Error when fetch script";
        r105 = r111;
        r104 = 30301;
        goto L16
    }
}
