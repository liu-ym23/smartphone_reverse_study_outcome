package com.bytedance.ies.xbridge.model.params;

import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.s;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ies/xbridge/model/params/XUploadImageMethodParamModel;", "Lcom/bytedance/ies/xbridge/model/params/a;", "", "url", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "filePath", "getFilePath", "Lcom/bytedance/ies/xbridge/XReadableMap;", "params", "Lcom/bytedance/ies/xbridge/XReadableMap;", "getParams", "()Lcom/bytedance/ies/xbridge/XReadableMap;", "setParams", "(Lcom/bytedance/ies/xbridge/XReadableMap;)V", "header", "getHeader", "setHeader", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "anniex-deprecated_release"}, k = 1, mv = {1, 4, 3})
public final class XUploadImageMethodParamModel extends com.bytedance.ies.xbridge.model.params.a {
    public static final a Companion = null;
    private final String filePath;
    private XReadableMap header;
    private XReadableMap params;
    private final String url;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final XReadableMap getHeader() {
        return this.header;
    }

    public final XReadableMap getParams() {
        return this.params;
    }

    public final String getUrl() {
        return this.url;
    }

    @JvmStatic
    public static final XUploadImageMethodParamModel convert(XReadableMap r100) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, "source");
        String r101 = s.f(r100, "url", "");
        boolean r102 = true;
        if (r101.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L13;
        String r104 = s.f(r100, "filePath", "");
        if (r104.length() == 0) goto L12;
        r102 = false;
    L12:
        if (r102 == true) goto L13;
        XReadableMap r105 = s.e(r100, "params");
        XReadableMap r106 = s.e(r100, "header");
        XUploadImageMethodParamModel r107 = new XUploadImageMethodParamModel(r101, r104);
        if (r105 == null) goto L17;
        r107.setParams(r105);
    L17:
        if (r106 == null) goto L20;
        r107.setHeader(r106);
    L20:
        return r107;
    L13:
        return null;
    L5:
        r103 = false;
        goto L6
    }

    public final void setHeader(XReadableMap r100) {
        this.header = r100;
    }

    public final void setParams(XReadableMap r100) {
        this.params = r100;
    }

    public XUploadImageMethodParamModel(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "filePath");
        this.url = r100;
        this.filePath = r101;
    }
}
