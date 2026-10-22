package com.bytedance.ee.bear.bitable.uikit.fieldcell;

import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.IChatterEntity;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001b\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0016J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J!\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/IconCapsuleModel;", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/IFiledUIkitModel;", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/IChatterEntity;", "Lcom/bytedance/ee/util/io/NonProguard;", "text", "", CustomHeaderConfig.Menu.Style.ICON_STYLE, "Lcom/bytedance/ee/bear/bitable/panel/Icon;", "<init>", "(Ljava/lang/String;Lcom/bytedance/ee/bear/bitable/panel/Icon;)V", "getText", "()Ljava/lang/String;", "getIcon", "()Lcom/bytedance/ee/bear/bitable/panel/Icon;", "isEmptyValue", "", "getId", "getLocalName", "localLang", "getAvatarUrl", "getSubType", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/IChatterEntity$ChatterSubType;", "getDescription", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IconCapsuleModel implements h0, IChatterEntity, NonProguard {
    private final Icon icon;
    private final String text;

    public static /* synthetic */ IconCapsuleModel copy$default(IconCapsuleModel r0, String r1, Icon r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.text;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.icon;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.text;
    }

    public final Icon component2() {
        return this.icon;
    }

    public final IconCapsuleModel copy(String r2, Icon r3) {
        return new IconCapsuleModel(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IconCapsuleModel) == true) goto L8;
        return false;
    L8:
        IconCapsuleModel r6 = (IconCapsuleModel) r5;
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.icon, r6.icon) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public /* bridge */ /* synthetic */ String getAvatarKey() {
        return null;
    }

    public String getDescription() {
        return null;
    }

    public String getId() {
        return null;
    }

    public int hashCode() {
        String r0 = this.text;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Icon r4 = this.icon;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public /* bridge */ /* synthetic */ boolean isCurrentUser() {
        return false;
    }

    public String toString() {
        return "IconCapsuleModel(text=" + this.text + ", icon=" + this.icon + ')';
    }

    public String getAvatarUrl() {
        Icon r0 = this.icon;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getUrl();
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

    public String getLocalName(String r1) {
        return this.text;
    }

    public IconCapsuleModel(String r1, Icon r2) {
        this.text = r1;
        this.icon = r2;
    }
}
