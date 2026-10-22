package com.ss.android.lark.search.dto.lynx;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/search/dto/lynx/LynxData;", "Ljava/io/Serializable;", "channel", "", "templateName", "renderContent", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChannel", "()Ljava/lang/String;", "getTemplateName", "getRenderContent", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxData implements Serializable {
    private final String channel;
    private final String renderContent;
    private final String templateName;

    public static /* synthetic */ LynxData copy$default(LynxData r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.channel;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.templateName;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.renderContent;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.channel;
    }

    public final String component2() {
        return this.templateName;
    }

    public final String component3() {
        return this.renderContent;
    }

    public final LynxData copy(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        Intrinsics.checkNotNullParameter(r101, "templateName");
        Intrinsics.checkNotNullParameter(r102, "renderContent");
        return new LynxData(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LynxData) == true) goto L8;
        return false;
    L8:
        LynxData r101 = (LynxData) r100;
        if (Intrinsics.areEqual(this.channel, r101.channel) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.templateName, r101.templateName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.renderContent, r101.renderContent) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.channel.hashCode() * 31) + this.templateName.hashCode()) * 31) + this.renderContent.hashCode();
    }

    public String toString() {
        return "LynxData(channel=" + this.channel + ", templateName=" + this.templateName + ", renderContent=" + this.renderContent + ')';
    }

    public final String getChannel() {
        return this.channel;
    }

    public final String getRenderContent() {
        return this.renderContent;
    }

    public final String getTemplateName() {
        return this.templateName;
    }

    public LynxData(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        Intrinsics.checkNotNullParameter(r101, "templateName");
        Intrinsics.checkNotNullParameter(r102, "renderContent");
        this.channel = r100;
        this.templateName = r101;
        this.renderContent = r102;
    }
}
