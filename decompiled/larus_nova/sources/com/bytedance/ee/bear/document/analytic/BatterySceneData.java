package com.bytedance.ee.bear.document.analytic;

import com.bytedance.ee.util.io.NonProguard;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tRB\u0010\r\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u000ej\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u0001`\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/document/analytic/BatterySceneData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "scene", "", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "opt", "getOpt", "setOpt", "extra", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getExtra", "()Ljava/util/HashMap;", "setExtra", "(Ljava/util/HashMap;)V", "toString", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BatterySceneData implements NonProguard {
    public static final a Companion = null;
    public static final String OPT_END = "end";
    public static final String OPT_START = "start";
    private HashMap<String, String> extra;
    private String opt;
    private String scene;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public BatterySceneData() {
    }

    public String toString() {
        return "BatterySceneData(scene=" + this.scene + ", opt=" + this.opt + ')';
    }

    public final HashMap<String, String> getExtra() {
        return this.extra;
    }

    public final String getOpt() {
        return this.opt;
    }

    public final String getScene() {
        return this.scene;
    }

    public final void setExtra(HashMap<String, String> r100) {
        this.extra = r100;
    }

    public final void setOpt(String r100) {
        this.opt = r100;
    }

    public final void setScene(String r100) {
        this.scene = r100;
    }
}
