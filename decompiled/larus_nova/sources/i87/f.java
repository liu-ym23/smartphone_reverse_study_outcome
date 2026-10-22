package i87;

import android.content.Context;
import com.bytedance.push.settings.AliveOnlineSettings;
import com.bytedance.push.settings.LocalSettings;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.settings.StatisticsSettings;
import com.larus.apm.impl.protector.RunnableProtector;
import j77.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f488674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f488675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g f488676c;

    public final void a() {
        ((AliveOnlineSettings) i.a(this.f488674a, AliveOnlineSettings.class)).updateSettings(this.f488674a, this.f488675b);
        PushOnlineSettings r100 = (PushOnlineSettings) i.a(this.f488674a, PushOnlineSettings.class);
        if (this.f488675b.has("pull_api_strategy") == false) goto L5;
        int r101 = this.f488675b.optInt("pull_api_strategy");
        ((LocalSettings) i.a(this.f488674a, LocalSettings.class)).B(r101);
        this.f488675b.remove("pull_api_strategy");
    L5:
        r100.updateSettings(this.f488674a, this.f488675b);
        ((StatisticsSettings) i.a(this.f488674a, StatisticsSettings.class)).updateSettings(this.f488674a, this.f488675b);
        g r102 = this.f488676c;
        Context r103 = this.f488674a;
        JSONObject r104 = this.f488675b;
        r102.getClass();
        com.bytedance.push.third.g.g().e(r103, r104);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public f(g r100, Context r101, JSONObject r102) {
        this.f488676c = r100;
        this.f488674a = r101;
        this.f488675b = r102;
    }
}
