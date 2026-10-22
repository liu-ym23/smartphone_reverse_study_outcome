package com.bytedance.ee.bear.document.imageviewer.diagram;

import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/document/imageviewer/diagram/DiagramData$SVGData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", TipCallBackData.RESULT, "", "getResult$annotations", "getResult", "()Ljava/lang/String;", "setResult", "(Ljava/lang/String;)V", "svgString", "getSvgString", "setSvgString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DiagramData$SVGData implements NonProguard {
    private String result;
    private String svgString;

    public DiagramData$SVGData() {
    }

    public static /* synthetic */ void getResult$annotations() {
    }

    public final String getResult() {
        return this.result;
    }

    public final String getSvgString() {
        return this.svgString;
    }

    public final void setResult(String r1) {
        this.result = r1;
    }

    public final void setSvgString(String r1) {
        this.svgString = r1;
    }
}
