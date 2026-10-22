package co5;

import android.content.Context;
import com.bytedance.ee.bear.templates.bean.SceneTemplateData;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public static final /* synthetic */ int e = 0;
    public final Context a;
    public SceneTemplateData b;
    public final String c;
    public final String d;

    public static final class a {
    }

    static {
    }

    public e(Context r2, SceneTemplateData r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, WikiFolderPushPlugin.DATA);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
