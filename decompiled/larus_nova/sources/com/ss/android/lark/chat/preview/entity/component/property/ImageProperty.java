package com.ss.android.lark.chat.preview.entity.component.property;

import com.bytedance.lark.pb.basic.v1.ComponentAttribute;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.ImageSet;
import com.ss.android.lark.export.entity.preview.PreviewData;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UDIcon;
import com.ss.android.lark.export.entity.preview.UrlPreviewPropertyData;
import com.ss.android.lark.tangram.base.props.Props;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001BK\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u0000H\u0016J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0096\u0002J\b\u0010(\u001a\u00020)H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014¨\u0006*"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/ImageProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "image", "Lcom/ss/android/lark/export/entity/preview/ImageSet;", "alt", "", "udIcon", "Lcom/ss/android/lark/export/entity/preview/UDIcon;", "imageUrl", "dmImage", "dmImageUrl", "<init>", "(Lcom/ss/android/lark/export/entity/preview/ImageSet;Ljava/lang/String;Lcom/ss/android/lark/export/entity/preview/UDIcon;Ljava/lang/String;Lcom/ss/android/lark/export/entity/preview/ImageSet;Ljava/lang/String;)V", "getImage", "()Lcom/ss/android/lark/export/entity/preview/ImageSet;", "setImage", "(Lcom/ss/android/lark/export/entity/preview/ImageSet;)V", "getAlt", "()Ljava/lang/String;", "setAlt", "(Ljava/lang/String;)V", "getUdIcon", "()Lcom/ss/android/lark/export/entity/preview/UDIcon;", "setUdIcon", "(Lcom/ss/android/lark/export/entity/preview/UDIcon;)V", "getImageUrl", "setImageUrl", "getDmImage", "setDmImage", "getDmImageUrl", "setDmImageUrl", "patchData", "", "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "clone", "equals", "", "other", "", "hashCode", "", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageProperty extends BaseProperty {
    private String alt;
    private ImageSet dmImage;
    private String dmImageUrl;
    private ImageSet image;
    private String imageUrl;
    private UDIcon udIcon;

    @Override // com.ss.android.lark.tangram.base.props.Props
    public ImageProperty clone() {
        ImageSet r100 = this.image;
        String r101 = this.alt;
        UDIcon r102 = this.udIcon;
        if (r102 == null) goto L5;
        UDIcon r103 = r102.clone();
    L6:
        ImageProperty r104 = new ImageProperty(r100, r101, r103, this.imageUrl, this.dmImage, this.dmImageUrl);
        r104.setMarginLeft(getMarginLeft());
        r104.setMarginRight(getMarginRight());
        r104.setMarginTop(getMarginTop());
        r104.setMarginBottom(getMarginBottom());
        return r104;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public int hashCode() {
        int r100 = super.hashCode() * 31;
        ImageSet r101 = this.image;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.alt;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        UDIcon r108 = this.udIcon;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.imageUrl;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        ImageSet r114 = this.dmImage;
        if (r114 == null) goto L21;
        int r115 = r114.hashCode();
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.dmImageUrl;
        if (r117 == null) goto L26;
        r102 = r117.hashCode();
    L26:
        return r116 + r102;
    L21:
        r115 = 0;
        goto L22
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String getAlt() {
        return this.alt;
    }

    public final ImageSet getDmImage() {
        return this.dmImage;
    }

    public final String getDmImageUrl() {
        return this.dmImageUrl;
    }

    public final ImageSet getImage() {
        return this.image;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final UDIcon getUdIcon() {
        return this.udIcon;
    }

    @Override // com.ss.android.lark.tangram.base.props.Props
    public /* bridge */ /* synthetic */ Props clone() {
        return clone();
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ImageProperty) == true) goto L9;
        return false;
    L9:
        if (super.equals(r100) == true) goto L11;
        return false;
    L11:
        ImageProperty r101 = (ImageProperty) r100;
        if (Intrinsics.areEqual(this.image, r101.image) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.alt, r101.alt) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.udIcon, r101.udIcon) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.imageUrl, r101.imageUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.dmImage, r101.dmImage) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.dmImageUrl, r101.dmImageUrl) == true) goto L29;
        return false;
    L29:
        return true;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public void patchData(UrlPreviewPropertyData r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<Integer, PreviewData>> r101 = r100.getPreviewPropertyData().entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L36;
        Map.Entry<Integer, PreviewData> r102 = r101.next();
        int r103 = r102.getKey().intValue();
        ImageSet r104 = null;
        String r105 = null;
        UDIcon r106 = null;
        String r107 = null;
        if (r103 == ComponentAttribute.image.getValue()) goto L9;
        if (r103 == ComponentAttribute.alt.getValue()) goto L15;
        if (r103 == ComponentAttribute.ud_icon_key.getValue()) goto L32;
        if (r103 == ComponentAttribute.ud_icon_theme_color.getValue()) goto L32;
        if (r103 == ComponentAttribute.unicode.getValue()) goto L32;
        if (r103 != ComponentAttribute.image_url.getValue()) goto L6;
        PreviewData r108 = r102.getValue();
        if (r108 == null) goto L31;
        r105 = r108.getString();
    L31:
        this.imageUrl = r105;
    L32:
        UDIcon r109 = this.udIcon;
        if (r109 == null) goto L35;
        r106 = r109.patchData(r102.getKey().intValue(), r102.getValue(), this.udIcon);
    L35:
        this.udIcon = r106;
        goto L6
    L15:
        PreviewData r110 = r102.getValue();
        if (r110 == null) goto L18;
        r107 = r110.getString();
    L18:
        this.alt = r107;
        goto L6
    L9:
        PreviewData r111 = r102.getValue();
        if (r111 == null) goto L12;
        r104 = r111.getImageSet();
    L12:
        this.image = r104;
        goto L6
    }

    public final void setAlt(String r100) {
        this.alt = r100;
    }

    public final void setDmImage(ImageSet r100) {
        this.dmImage = r100;
    }

    public final void setDmImageUrl(String r100) {
        this.dmImageUrl = r100;
    }

    public final void setImage(ImageSet r100) {
        this.image = r100;
    }

    public final void setImageUrl(String r100) {
        this.imageUrl = r100;
    }

    public final void setUdIcon(UDIcon r100) {
        this.udIcon = r100;
    }

    public ImageProperty(ImageSet r100, String r101, UDIcon r102, String r103, ImageSet r104, String r105) {
        super(Type.IMAGE);
        this.image = r100;
        this.alt = r101;
        this.udIcon = r102;
        this.imageUrl = r103;
        this.dmImage = r104;
        this.dmImageUrl = r105;
    }

    public /* synthetic */ ImageProperty(ImageSet r110, String r111, UDIcon r112, String r113, ImageSet r114, String r115, int r116, DefaultConstructorMarker r117) {
        if ((r116 & 4) == 0) goto L5;
        UDIcon r100 = null;
    L7:
        if ((r116 & 8) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r116 & 16) == 0) goto L13;
        ImageSet r102 = null;
    L15:
        if ((r116 & 32) == 0) goto L17;
        String r103 = null;
    L18:
        this(r110, r111, r100, r101, r102, r103);
        return;
    L17:
        r103 = r115;
        goto L18
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
