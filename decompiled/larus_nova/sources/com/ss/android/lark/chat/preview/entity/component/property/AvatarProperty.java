package com.ss.android.lark.chat.preview.entity.component.property;

import com.bytedance.lark.pb.basic.v1.ComponentAttribute;
import com.ss.android.lark.export.entity.preview.AvatarChatterInfo;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.PreviewData;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UrlPreviewPropertyData;
import com.ss.android.lark.tangram.base.props.Props;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u0000H\u0016J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/AvatarProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "chatterInfo", "Lcom/ss/android/lark/export/entity/preview/AvatarChatterInfo;", "<init>", "(Lcom/ss/android/lark/export/entity/preview/AvatarChatterInfo;)V", "getChatterInfo", "()Lcom/ss/android/lark/export/entity/preview/AvatarChatterInfo;", "setChatterInfo", "patchData", "", "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "clone", "equals", "", "other", "", "hashCode", "", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AvatarProperty extends BaseProperty {
    private AvatarChatterInfo chatterInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public AvatarProperty() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.ss.android.lark.tangram.base.props.Props
    public AvatarProperty clone() {
        AvatarChatterInfo r100 = this.chatterInfo;
        if (r100 == null) goto L5;
        AvatarChatterInfo r101 = r100.clone();
    L7:
        return new AvatarProperty(r101);
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public int hashCode() {
        int r100 = super.hashCode() * 31;
        AvatarChatterInfo r101 = this.chatterInfo;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final AvatarChatterInfo getChatterInfo() {
        return this.chatterInfo;
    }

    @Override // com.ss.android.lark.tangram.base.props.Props
    public /* bridge */ /* synthetic */ Props clone() {
        return clone();
    }

    public AvatarProperty(AvatarChatterInfo r100) {
        super(Type.AVATAR);
        this.chatterInfo = r100;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AvatarProperty) == true) goto L9;
        return false;
    L9:
        if (super.equals(r100) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.chatterInfo, ((AvatarProperty) r100).chatterInfo) == true) goto L14;
        return false;
    L14:
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
        if (r102.getKey().intValue() != ComponentAttribute.avatar_chatter_info.getValue()) goto L6;
        PreviewData r103 = r102.getValue();
        if (r103 == null) goto L12;
        AvatarChatterInfo r104 = r103.getChatterInfo();
    L13:
        this.chatterInfo = r104;
        goto L6
    L12:
        r104 = null;
        goto L13
    }

    public final void setChatterInfo(AvatarChatterInfo r100) {
        this.chatterInfo = r100;
    }

    public /* synthetic */ AvatarProperty(AvatarChatterInfo r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
