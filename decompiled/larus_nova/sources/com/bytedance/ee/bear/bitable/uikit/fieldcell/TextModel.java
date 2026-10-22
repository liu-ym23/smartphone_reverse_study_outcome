package com.bytedance.ee.bear.bitable.uikit.fieldcell;

import com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.SegmentModel;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u001d\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\u001c\b\u0002\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R%\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/TextModel;", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/IFiledUIkitModel;", "Lcom/bytedance/ee/util/io/NonProguard;", DBDefinition.SEGMENT_TABLE_NAME, "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/cellvalue/SegmentModel;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "getSegments", "()Ljava/util/ArrayList;", "isEmptyValue", "", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextModel implements h0, NonProguard {
    private final ArrayList<SegmentModel> segments;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TextModel copy$default(TextModel r100, ArrayList r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.segments;
    L6:
        return r100.copy(r101);
    }

    public final ArrayList<SegmentModel> component1() {
        return this.segments;
    }

    public final TextModel copy(ArrayList<SegmentModel> r100) {
        return new TextModel(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TextModel) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.segments, ((TextModel) r100).segments) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        ArrayList<SegmentModel> r100 = this.segments;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "TextModel(segments=" + this.segments + ')';
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.h0
    public boolean isEmptyValue() {
        ArrayList<SegmentModel> r100 = this.segments;
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.isEmpty();
    }

    public final ArrayList<SegmentModel> getSegments() {
        return this.segments;
    }

    public TextModel(ArrayList<SegmentModel> r100) {
        this.segments = r100;
    }
}
