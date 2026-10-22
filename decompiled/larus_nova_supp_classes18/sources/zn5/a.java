package zn5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.templates.data.TemplateGroupTab;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class a implements NetService.c<TemplateGroupTab> {
    public final int a;
    public final boolean b;
    public final String c;

    public abstract TemplateGroupTab c(JSONObject r1);

    public TemplateGroupTab a() {
        return new TemplateGroupTab(this.a, new ArrayList(), false, false, null, new Throwable("json is null"), null, 0, false, 468, null);
    }

    public TemplateGroupTab b(Throwable r14) {
        Intrinsics.checkNotNullParameter(r14, "err");
        return new TemplateGroupTab(this.a, null, false, false, null, r14, null, 0, false, 470, null);
    }

    public final Result parse(String r5) {
        if (r5 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return a();
    L12:
        if (this.b == false) goto L19;
        ((aw4.a) org.koin.java.a.c(aw4.a.class, null, null, 6)).a(this.c, r5);
    L19:
        return c(new JSONObject(r5).optJSONObject(WikiFolderPushPlugin.DATA));
    L16:
        th = move-exception;
        tt5.a.e("BaseTemplateParser", "parse()...err", th, false);
        return b(th);
    L5:
        if (StringsKt.isBlank(r5) == true) goto L8;
        r1 = false;
        goto L9
    }

    public a(int r2, boolean r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "cacheKey");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
