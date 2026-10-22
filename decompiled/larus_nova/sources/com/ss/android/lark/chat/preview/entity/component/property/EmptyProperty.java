package com.ss.android.lark.chat.preview.entity.component.property;

import com.bytedance.lark.pb.basic.v1.ComponentAttribute;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.PreviewData;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UrlPreviewPropertyData;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/EmptyProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "type", "Lcom/ss/android/lark/export/entity/preview/Type;", "actionId", "", "<init>", "(Lcom/ss/android/lark/export/entity/preview/Type;Ljava/lang/String;)V", "getType", "()Lcom/ss/android/lark/export/entity/preview/Type;", "getActionId", "()Ljava/lang/String;", "setActionId", "(Ljava/lang/String;)V", "patchData", "", "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EmptyProperty extends BaseProperty {
    private String actionId;
    private final Type type;

    public static /* synthetic */ EmptyProperty copy$default(EmptyProperty r100, Type r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.actionId;
    L9:
        return r100.copy(r101, r102);
    }

    public final Type component1() {
        return this.type;
    }

    public final String component2() {
        return this.actionId;
    }

    public final EmptyProperty copy(Type r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return new EmptyProperty(r100, r101);
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof EmptyProperty) == true) goto L8;
        return false;
    L8:
        EmptyProperty r101 = (EmptyProperty) r100;
        if (this.type == r101.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.actionId, r101.actionId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public int hashCode() {
        int r100 = this.type.hashCode() * 31;
        String r101 = this.actionId;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "EmptyProperty(type=" + this.type + ", actionId=" + this.actionId + ')';
    }

    public final String getActionId() {
        return this.actionId;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public Type getType() {
        return this.type;
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
        if (r102.getKey().intValue() != ComponentAttribute.action_id.getValue()) goto L6;
        PreviewData r103 = r102.getValue();
        if (r103 == null) goto L12;
        String r104 = r103.getString();
    L13:
        this.actionId = r104;
        goto L6
    L12:
        r104 = null;
        goto L13
    }

    public final void setActionId(String r100) {
        this.actionId = r100;
    }

    public EmptyProperty(Type r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        super(r100);
        this.type = r100;
        this.actionId = r101;
    }

    public /* synthetic */ EmptyProperty(Type r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
