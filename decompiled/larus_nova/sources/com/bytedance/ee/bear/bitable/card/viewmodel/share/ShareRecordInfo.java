package com.bytedance.ee.bear.bitable.card.viewmodel.share;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0002\u001a\u00020\u0003J\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u0005\u001a\u00020\u0003J\u0006\u0010\u0006\u001a\u00020\u0003J\u0006\u0010\u0007\u001a\u00020\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0003J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0003J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0003J\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/viewmodel/share/ShareRecordInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "hasUserField", "", "hasAttachmentField", "hasLookupField", "hasFormulaField", "hasLinkField", "<init>", "(ZZZZZ)V", "setHasLinkField", "", "setHasLookupField", "setHasFormulaField", "setHasUserField", "setHasAttachmentField", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareRecordInfo implements NonProguard {
    private boolean hasAttachmentField;
    private boolean hasFormulaField;
    private boolean hasLinkField;
    private boolean hasLookupField;
    private boolean hasUserField;

    public ShareRecordInfo() {
        this(false, false, false, false, false, 31, null);
    }

    public final boolean hasAttachmentField() {
        return this.hasAttachmentField;
    }

    public final boolean hasFormulaField() {
        return this.hasFormulaField;
    }

    public final boolean hasLinkField() {
        return this.hasLinkField;
    }

    public final boolean hasLookupField() {
        return this.hasLookupField;
    }

    public final boolean hasUserField() {
        return this.hasUserField;
    }

    public final void setHasAttachmentField(boolean r100) {
        this.hasAttachmentField = r100;
    }

    public final void setHasFormulaField(boolean r100) {
        this.hasFormulaField = r100;
    }

    public final void setHasLinkField(boolean r100) {
        this.hasLinkField = r100;
    }

    public final void setHasLookupField(boolean r100) {
        this.hasLookupField = r100;
    }

    public final void setHasUserField(boolean r100) {
        this.hasUserField = r100;
    }

    public ShareRecordInfo(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104) {
        this.hasUserField = r100;
        this.hasAttachmentField = r101;
        this.hasLookupField = r102;
        this.hasFormulaField = r103;
        this.hasLinkField = r104;
    }

    public /* synthetic */ ShareRecordInfo(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        boolean r112 = false;
    L7:
        if ((r110 & 2) == 0) goto L9;
        boolean r105 = false;
    L11:
        if ((r110 & 4) == 0) goto L13;
        boolean r106 = false;
    L15:
        if ((r110 & 8) == 0) goto L17;
        boolean r107 = false;
    L19:
        if ((r110 & 16) == 0) goto L21;
        boolean r113 = false;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
