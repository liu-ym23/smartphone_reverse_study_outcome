package com.ss.android.lark.chat.preview.entity.component.property;

import com.bytedance.lark.pb.basic.v1.URLPreviewComponent;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UrlPreviewPropertyData;
import com.ss.android.lark.widget.richtext.RichText;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u0005H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/RichTextProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "richText", "Lcom/ss/android/lark/widget/richtext/RichText;", "numberOfLines", "", "theme", "Lcom/bytedance/lark/pb/basic/v1/URLPreviewComponent$RichTextProperty$RichTextTheme;", "<init>", "(Lcom/ss/android/lark/widget/richtext/RichText;ILcom/bytedance/lark/pb/basic/v1/URLPreviewComponent$RichTextProperty$RichTextTheme;)V", "getRichText", "()Lcom/ss/android/lark/widget/richtext/RichText;", "setRichText", "(Lcom/ss/android/lark/widget/richtext/RichText;)V", "getNumberOfLines", "()I", "getTheme", "()Lcom/bytedance/lark/pb/basic/v1/URLPreviewComponent$RichTextProperty$RichTextTheme;", "patchData", "", "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "equals", "", "other", "", "hashCode", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RichTextProperty extends BaseProperty {
    public static final a Companion = null;
    public static final int UNLIMITED_NUMBER_OF_LINES = 0;
    private final int numberOfLines;
    private RichText richText;
    private final URLPreviewComponent.RichTextProperty.RichTextTheme theme;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public int hashCode() {
        int r100 = super.hashCode() * 31;
        RichText r101 = this.richText;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (((r100 + r103) * 31) + this.numberOfLines) * 31;
        URLPreviewComponent.RichTextProperty.RichTextTheme r105 = this.theme;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return r104 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public final int getNumberOfLines() {
        return this.numberOfLines;
    }

    public final RichText getRichText() {
        return this.richText;
    }

    public final URLPreviewComponent.RichTextProperty.RichTextTheme getTheme() {
        return this.theme;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RichTextProperty) == true) goto L9;
        return false;
    L9:
        if (super.equals(r100) == true) goto L11;
        return false;
    L11:
        RichTextProperty r101 = (RichTextProperty) r100;
        if (Intrinsics.areEqual(this.richText, r101.richText) == true) goto L14;
    L18:
        return false;
    L14:
        if (this.numberOfLines != r101.numberOfLines) goto L18;
        if (this.theme != r101.theme) goto L18;
        return true;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public void patchData(UrlPreviewPropertyData r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.richText = r100.getRichText();
    }

    public final void setRichText(RichText r100) {
        this.richText = r100;
    }

    public RichTextProperty(RichText r100, int r101, URLPreviewComponent.RichTextProperty.RichTextTheme r102) {
        super(Type.RICHTEXT);
        this.richText = r100;
        this.numberOfLines = r101;
        this.theme = r102;
    }

    public /* synthetic */ RichTextProperty(RichText r100, int r101, URLPreviewComponent.RichTextProperty.RichTextTheme r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        this(r100, r101, r102);
    }
}
