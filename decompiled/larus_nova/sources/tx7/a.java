package tx7;

import android.app.Application;
import android.content.Context;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class a implements IHostContextDepend {
    public a() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final String getCurrentTelcomCarrier() {
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final String getSkinType() {
        return "";
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final boolean isBaseMode() {
        return true;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final boolean isTeenMode() {
        return false;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final int getAppId() {
        String r100 = mx7.c.f516265a;
        return mx7.c.f516267c;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final String getAppName() {
        String r100 = mx7.c.f516265a;
        return mx7.c.f516266b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final String getBoeChannel() {
        String r100 = mx7.c.f516265a;
        return mx7.c.f516281q;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final String getChannel() {
        String r100 = mx7.c.f516265a;
        return mx7.c.f516272h;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final String getDeviceId() {
        String r100 = mx7.c.f516265a;
        return mx7.c.f516274j;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final String getPPEChannel() {
        String r100 = mx7.c.f516265a;
        return mx7.c.f516279o;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final String getPackageName() {
        String r100 = mx7.c.f516265a;
        return mx7.c.f516282r;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final String getUpdateVersion() {
        String r100 = mx7.c.f516265a;
        return mx7.c.f516270f;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final long getVersionCode() {
        String r100 = mx7.c.f516265a;
        return CastLongProtector.parseLong(mx7.c.f516268d);
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final String getVersionName() {
        String r100 = mx7.c.f516265a;
        return mx7.c.f516268d;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final boolean isBoeEnable() {
        String r100 = mx7.c.f516265a;
        return mx7.c.f516280p;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final boolean isDebuggable() {
        String r100 = mx7.c.f516265a;
        return mx7.c.f516275k;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final boolean isPPEEnable() {
        String r100 = mx7.c.f516265a;
        return mx7.c.f516278n;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final Application getApplication() {
        return mx7.c.b();
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final Context getApplicationContext() {
        return getApplication().getApplicationContext();
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final String getSkinName() {
        return mx7.c.a();
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend
    public final List<re7.b> getSettings(List<re7.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "settingKeys");
        String r101 = mx7.c.f516265a;
        qx7.a r102 = mx7.c.f516288x;
        if (r102 == null) goto L13;
        List<Object> r103 = r102.getSettings(r100);
        if (r103 == null) goto L13;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r103.iterator();
    L8:
        if (r105.hasNext() == false) goto L19;
        Object r106 = r105.next();
        if ((r106 instanceof re7.b) == false) goto L8;
        r104.add(r106);
        goto L8
    L19:
        return r104;
    L13:
        return CollectionsKt.emptyList();
    }
}
