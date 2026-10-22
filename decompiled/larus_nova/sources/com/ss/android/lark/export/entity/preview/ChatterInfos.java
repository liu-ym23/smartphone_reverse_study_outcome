package com.ss.android.lark.export.entity.preview;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J'\u0010\u000b\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/ChatterInfos;", "Ljava/io/Serializable;", "chatterInfos", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/export/entity/preview/ChatterPreviewChatterInfo;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "getChatterInfos", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatterInfos implements Serializable {
    private final ArrayList<ChatterPreviewChatterInfo> chatterInfos;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChatterInfos copy$default(ChatterInfos r100, ArrayList r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.chatterInfos;
    L6:
        return r100.copy(r101);
    }

    public final ArrayList<ChatterPreviewChatterInfo> component1() {
        return this.chatterInfos;
    }

    public final ChatterInfos copy(ArrayList<ChatterPreviewChatterInfo> r100) {
        return new ChatterInfos(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChatterInfos) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.chatterInfos, ((ChatterInfos) r100).chatterInfos) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        ArrayList<ChatterPreviewChatterInfo> r100 = this.chatterInfos;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "ChatterInfos(chatterInfos=" + this.chatterInfos + ')';
    }

    public final ArrayList<ChatterPreviewChatterInfo> getChatterInfos() {
        return this.chatterInfos;
    }

    public ChatterInfos(ArrayList<ChatterPreviewChatterInfo> r100) {
        this.chatterInfos = r100;
    }
}
