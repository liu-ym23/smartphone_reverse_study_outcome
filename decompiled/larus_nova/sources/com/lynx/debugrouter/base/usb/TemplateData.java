package com.lynx.debugrouter.base.usb;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0000H\u0096\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/lynx/debugrouter/base/usb/TemplateData;", "", "seqId", "", "data", "", "(ILjava/lang/String;)V", "getData", "()Ljava/lang/String;", "setData", "(Ljava/lang/String;)V", "getSeqId", "()I", "setSeqId", "(I)V", "compareTo", "other", "DebugRouter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TemplateData implements Comparable<TemplateData> {
    private String data;
    private int seqId;

    public final String getData() {
        return this.data;
    }

    public final int getSeqId() {
        return this.seqId;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(TemplateData r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        int r101 = this.seqId;
        int r102 = r100.seqId;
        if (r101 >= r102) goto L5;
        return -1;
    L5:
        if (r101 <= r102) goto L7;
        return 1;
    L7:
        return 0;
    }

    public final void setData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.data = r100;
    }

    public final void setSeqId(int r100) {
        this.seqId = r100;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(TemplateData r100) {
        return compareTo2(r100);
    }

    public TemplateData(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "data");
        this.seqId = r100;
        this.data = r101;
    }
}
