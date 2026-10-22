package com.bytedance.ies.argus.api.params;

import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/argus/api/params/WebLoadVerifySource;", "", "", "strValue", "Ljava/lang/String;", "getStrValue", "()Ljava/lang/String;", "Inner", "Extern", "SecLink", "scc", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum WebLoadVerifySource extends Enum<WebLoadVerifySource> {
    public static final WebLoadVerifySource Extern = null;
    public static final WebLoadVerifySource Inner = null;
    public static final WebLoadVerifySource SecLink = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WebLoadVerifySource[] f245714a = null;

    /* JADX INFO: renamed from: scc, reason: collision with root package name */
    public static final WebLoadVerifySource f245715scc = null;
    private final String strValue;

    public static WebLoadVerifySource valueOf(String r100) {
        return (WebLoadVerifySource) r27.a.a(WebLoadVerifySource.class, r100);
    }

    public static WebLoadVerifySource[] values() {
        return (WebLoadVerifySource[]) f245714a.clone();
    }

    static {
        WebLoadVerifySource r100 = new WebLoadVerifySource("Inner", 0, RNParamRegisterEventHandler.SRC_INNER);
        Inner = r100;
        WebLoadVerifySource r101 = new WebLoadVerifySource("Extern", 1, "extern");
        Extern = r101;
        WebLoadVerifySource r102 = new WebLoadVerifySource("SecLink", 2, "seclink");
        SecLink = r102;
        WebLoadVerifySource r103 = new WebLoadVerifySource("scc", 3, "scc");
        f245715scc = r103;
        f245714a = new WebLoadVerifySource[]{r100, r101, r102, r103};
    }

    public final String getStrValue() {
        return this.strValue;
    }

    public WebLoadVerifySource(String r100, int r101, String r102) {
        super(r100, r101);
        this.strValue = r102;
    }
}
