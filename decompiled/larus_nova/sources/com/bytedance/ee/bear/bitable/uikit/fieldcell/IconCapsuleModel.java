package com.bytedance.ee.bear.bitable.uikit.fieldcell;

import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001b\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0016J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J!\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/IconCapsuleModel;", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/IFiledUIkitModel;", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/IChatterEntity;", "Lcom/bytedance/ee/util/io/NonProguard;", "text", "", "icon", "Lcom/bytedance/ee/bear/bitable/panel/Icon;", "<init>", "(Ljava/lang/String;Lcom/bytedance/ee/bear/bitable/panel/Icon;)V", "getText", "()Ljava/lang/String;", "getIcon", "()Lcom/bytedance/ee/bear/bitable/panel/Icon;", "isEmptyValue", "", "getId", "getLocalName", "localLang", "getAvatarUrl", "getSubType", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/IChatterEntity$ChatterSubType;", "getDescription", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IconCapsuleModel implements h0, IChatterEntity, NonProguard {
    private final Icon icon;
    private final String text;

    public static /* synthetic */ IconCapsuleModel copy$default(IconCapsuleModel r100, String r101, Icon r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.text;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.icon;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.text;
    }

    public final Icon component2() {
        return this.icon;
    }

    public final IconCapsuleModel copy(String r100, Icon r101) {
        return new IconCapsuleModel(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IconCapsuleModel) == true) goto L8;
        return false;
    L8:
        IconCapsuleModel r101 = (IconCapsuleModel) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity
    public /* bridge */ /* synthetic */ String getAvatarKey() {
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity
    public String getDescription() {
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity
    public String getId() {
        return null;
    }

    public int hashCode() {
        String r100 = this.text;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Icon r104 = this.icon;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity
    public /* bridge */ /* synthetic */ boolean isCurrentUser() {
        return false;
    }

    public String toString() {
        return "IconCapsuleModel(text=" + this.text + ", icon=" + this.icon + ')';
    }

    @Override // com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity
    public String getAvatarUrl() {
        Icon r100 = this.icon;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getUrl();
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.h0
    public boolean isEmptyValue() {
        return TextUtils.isEmpty(this.text);
    }

    public final Icon getIcon() {
        return this.icon;
    }

    public IChatterEntity.ChatterSubType getSubType() {
        return IChatterEntity.ChatterSubType.USER;
    }

    public final String getText() {
        return this.text;
    }

    @Override // com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity
    public String getLocalName(String r100) {
        return this.text;
    }

    public IconCapsuleModel(String r100, Icon r101) {
        this.text = r100;
        this.icon = r101;
    }
}
