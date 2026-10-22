package com.ss.android.lark.chat.preview.entity.component.property;

import com.bytedance.lark.pb.basic.v1.ComponentAttribute;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.PreviewData;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UrlPreviewPropertyData;
import com.ss.android.lark.tangram.base.props.Props;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/IGProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "type", "Lcom/ss/android/lark/export/entity/preview/Type;", "maskColor", "Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "<init>", "(Lcom/ss/android/lark/export/entity/preview/Type;Lcom/ss/android/lark/export/entity/preview/ThemeColor;)V", "getType", "()Lcom/ss/android/lark/export/entity/preview/Type;", "getMaskColor", "()Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "setMaskColor", "(Lcom/ss/android/lark/export/entity/preview/ThemeColor;)V", "patchData", "", "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "clone", "Lcom/ss/android/lark/tangram/base/props/Props;", "equals", "", "other", "", "hashCode", "", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IGProperty extends BaseProperty {
    private ThemeColor maskColor;
    private final Type type;

    @Override // com.ss.android.lark.tangram.base.props.Props
    public Props clone() {
        return new IGProperty(getType(), this.maskColor);
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public int hashCode() {
        int r100 = ((super.hashCode() * 31) + getType().hashCode()) * 31;
        ThemeColor r101 = this.maskColor;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final ThemeColor getMaskColor() {
        return this.maskColor;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public Type getType() {
        return this.type;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IGProperty) == true) goto L9;
        return false;
    L9:
        if (super.equals(r100) == true) goto L11;
        return false;
    L11:
        IGProperty r101 = (IGProperty) r100;
        if (getType() == r101.getType()) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.maskColor, r101.maskColor) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public void patchData(UrlPreviewPropertyData r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<Integer, PreviewData>> r101 = r100.getPreviewPropertyData().entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L14;
        Map.Entry<Integer, PreviewData> r102 = r101.next();
        if (r102.getKey().intValue() != ComponentAttribute.theme_color.getValue()) goto L6;
        PreviewData r103 = r102.getValue();
        if (r103 == null) goto L12;
        ThemeColor r104 = r103.getThemeColor();
    L13:
        this.maskColor = r104;
        goto L6
    L12:
        r104 = null;
        goto L13
    }

    public final void setMaskColor(ThemeColor r100) {
        this.maskColor = r100;
    }

    public IGProperty(Type r100, ThemeColor r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        super(r100);
        this.type = r100;
        this.maskColor = r101;
    }

    public /* synthetic */ IGProperty(Type r100, ThemeColor r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
