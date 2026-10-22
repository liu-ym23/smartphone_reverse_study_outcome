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
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\b\u0010\u001b\u001a\u00020\u0005H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/TextViewProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "text", "", "numberOfLines", "", "actionId", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getNumberOfLines", "()I", "setNumberOfLines", "(I)V", "getActionId", "setActionId", "patchData", "", "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "equals", "", "other", "", "hashCode", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextViewProperty extends BaseProperty {
    private String actionId;
    private int numberOfLines;
    private String text;

    public TextViewProperty() {
        this(null, 0, null, 7, null);
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public int hashCode() {
        return (((super.hashCode() * 31) + this.text.hashCode()) * 31) + this.text.hashCode();
    }

    public final String getActionId() {
        return this.actionId;
    }

    public final int getNumberOfLines() {
        return this.numberOfLines;
    }

    public final String getText() {
        return this.text;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TextViewProperty) == true) goto L9;
        return false;
    L9:
        if (super.equals(r100) == true) goto L11;
        return false;
    L11:
        TextViewProperty r101 = (TextViewProperty) r100;
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L15;
        return false;
    L15:
        if (this.numberOfLines == r101.numberOfLines) goto L17;
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
        if (r101.hasNext() == false) goto L31;
        Map.Entry<Integer, PreviewData> r102 = r101.next();
        int r103 = r102.getKey().intValue();
        if (r103 == ComponentAttribute.text.getValue()) goto L9;
        if (r103 == ComponentAttribute.number_of_lines.getValue()) goto L17;
        if (r103 != ComponentAttribute.action_id.getValue()) goto L6;
        PreviewData r104 = r102.getValue();
        if (r104 == null) goto L29;
        String r105 = r104.getString();
    L30:
        this.actionId = r105;
        goto L6
    L29:
        r105 = null;
        goto L30
    L17:
        PreviewData r106 = r102.getValue();
        if (r106 == null) goto L22;
        Integer r107 = r106.getInt();
        if (r107 == null) goto L22;
        int r108 = r107.intValue();
    L23:
        this.numberOfLines = r108;
    L22:
        r108 = 0;
        goto L23
    L9:
        PreviewData r109 = r102.getValue();
        if (r109 == null) goto L13;
        String r110 = r109.getString();
        if (r110 == null) goto L13;
    L14:
        this.text = r110;
    L13:
        r110 = "";
        goto L14
    }

    public final void setActionId(String r100) {
        this.actionId = r100;
    }

    public final void setNumberOfLines(int r100) {
        this.numberOfLines = r100;
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.text = r100;
    }

    public TextViewProperty(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "text");
        super(Type.TEXT);
        this.text = r100;
        this.numberOfLines = r101;
        this.actionId = r102;
    }

    public /* synthetic */ TextViewProperty(String r100, int r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
