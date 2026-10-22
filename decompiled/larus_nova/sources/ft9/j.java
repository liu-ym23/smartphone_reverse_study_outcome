package ft9;

import com.bytedance.news.common.settings.SettingsUpdateListener;
import com.bytedance.news.common.settings.api.SettingsData;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class j implements SettingsUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f478803a;

    public /* synthetic */ j(Function1 r100) {
        this.f478803a = r100;
    }

    @Override // com.bytedance.news.common.settings.SettingsUpdateListener
    public final void onSettingsUpdate(SettingsData r100) {
        Function1 r101 = this.f478803a;
        if (r100 == null) goto L5;
        JSONObject r102 = r100.getAppSettings();
    L6:
        r101.invoke(r102);
        return;
    L5:
        r102 = null;
        goto L6
    }
}
