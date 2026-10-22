package mra;

import com.bytedance.android.ad.client.components.settings.AbsAdSettingsManager;
import com.ss.android.ad.applinksdk.settings.AppLinkSettingsSelf;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static JSONObject f515036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f515037b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f515038c = null;

    static {
        f515037b = new ArrayList();
        f515038c = new ArrayList();
    }

    public static JSONObject a() {
        if (f515036a != null) goto L13;
        com.bytedance.android.ad.client.components.settings.a r100 = com.bytedance.android.ad.client.components.settings.a.f38321f;
        r100.a();
        JSONObject r101 = null;
        if (r100.f38316b.get() == false) goto L7;
        Lazy r102 = r100.f38317c;
        KProperty r103 = AbsAdSettingsManager.f38314e[0];
        g37.a r104 = (g37.a) r102.getValue();
    L8:
        if (r104 == null) goto L12;
        AppLinkSettingsSelf r105 = (AppLinkSettingsSelf) r104.b(AppLinkSettingsSelf.class);
        if (r105 == null) goto L12;
        r101 = r105.getABSettings();
    L12:
        f515036a = r101;
        goto L13
    L7:
        r104 = null;
    L13:
        JSONObject r106 = f515036a;
        if (r106 == null) goto L17;
        return r106;
    L17:
        return new JSONObject();
    }
}
