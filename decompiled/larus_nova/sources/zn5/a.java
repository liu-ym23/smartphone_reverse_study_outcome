package zn5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.templates.data.TemplateGroupTab;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public abstract class a implements NetService.c<TemplateGroupTab> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f572930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f572931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f572932c;

    public abstract TemplateGroupTab c(JSONObject r100);

    public TemplateGroupTab a() {
        return new TemplateGroupTab(this.f572930a, new ArrayList(), false, false, null, new Throwable("json is null"), null, 0, false, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RATE, null);
    }

    public TemplateGroupTab b(Throwable r110) {
        Intrinsics.checkNotNullParameter(r110, "err");
        return new TemplateGroupTab(this.f572930a, null, false, false, null, r110, null, 0, false, 470, null);
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result parse(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return a();
    L12:
        if (this.f572931b == false) goto L19;
        ((aw4.a) org.koin.java.a.c(aw4.a.class, null, null, 6)).a(this.f572932c, r100);
    L19:
        return c(new JSONObject(r100).optJSONObject("data"));
    L16:
        th = move-exception;
        tt5.a.e("BaseTemplateParser", "parse()...err", th, false);
        return b(th);
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L9
    }

    public a(int r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "cacheKey");
        this.f572930a = r100;
        this.f572931b = r101;
        this.f572932c = r102;
    }
}
