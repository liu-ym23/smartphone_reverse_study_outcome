package com.ss.android.lark.chat.preview.entity.component.property;

import com.bytedance.lark.pb.basic.v1.ComponentAttribute;
import com.ss.android.lark.chat.preview.entity.component.Direction;
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
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020*H\u0016J\u0013\u0010+\u001a\u00020\n2\b\u0010,\u001a\u0004\u0018\u00010-H\u0096\u0002J\b\u0010.\u001a\u00020/H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\t\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u00060"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/ButtonProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "iconKey", "Lcom/ss/android/lark/export/entity/preview/ImageSet;", "text", "", "direction", "Lcom/ss/android/lark/chat/preview/entity/component/Direction;", "actionId", "isDisable", "", "udIcon", "Lcom/ss/android/lark/export/entity/preview/UDIcon;", "<init>", "(Lcom/ss/android/lark/export/entity/preview/ImageSet;Ljava/lang/String;Lcom/ss/android/lark/chat/preview/entity/component/Direction;Ljava/lang/String;Ljava/lang/Boolean;Lcom/ss/android/lark/export/entity/preview/UDIcon;)V", "getIconKey", "()Lcom/ss/android/lark/export/entity/preview/ImageSet;", "setIconKey", "(Lcom/ss/android/lark/export/entity/preview/ImageSet;)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getDirection", "()Lcom/ss/android/lark/chat/preview/entity/component/Direction;", "setDirection", "(Lcom/ss/android/lark/chat/preview/entity/component/Direction;)V", "getActionId", "setActionId", "()Ljava/lang/Boolean;", "setDisable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getUdIcon", "()Lcom/ss/android/lark/export/entity/preview/UDIcon;", "setUdIcon", "(Lcom/ss/android/lark/export/entity/preview/UDIcon;)V", "patchData", "", "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "clone", "Lcom/ss/android/lark/tangram/base/props/Props;", "equals", "other", "", "hashCode", "", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ButtonProperty extends BaseProperty {
    private String actionId;
    private Direction direction;
    private ImageSet iconKey;
    private Boolean isDisable;
    private String text;
    private UDIcon udIcon;

    public ButtonProperty() {
        this(null, null, null, null, null, null, 63, null);
    }

    @Override // com.ss.android.lark.tangram.base.props.Props
    public Props clone() {
        ButtonProperty r100 = new ButtonProperty(this.iconKey, this.text, this.direction, this.actionId, this.isDisable, null, 32, null);
        r100.setMarginLeft(getMarginLeft());
        r100.setMarginRight(getMarginRight());
        r100.setMarginTop(getMarginTop());
        r100.setMarginBottom(getMarginBottom());
        return r100;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public int hashCode() {
        int r100 = super.hashCode() * 31;
        ImageSet r101 = this.iconKey;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.text;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        Direction r108 = this.direction;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.actionId;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        Boolean r114 = this.isDisable;
        if (r114 == null) goto L21;
        int r115 = r114.hashCode();
    L22:
        int r116 = (r113 + r115) * 31;
        UDIcon r117 = this.udIcon;
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

    public final String getActionId() {
        return this.actionId;
    }

    public final Direction getDirection() {
        return this.direction;
    }

    public final ImageSet getIconKey() {
        return this.iconKey;
    }

    public final String getText() {
        return this.text;
    }

    public final UDIcon getUdIcon() {
        return this.udIcon;
    }

    public final Boolean isDisable() {
        return this.isDisable;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ButtonProperty) == true) goto L9;
        return false;
    L9:
        if (super.equals(r100) == true) goto L11;
        return false;
    L11:
        ButtonProperty r101 = (ButtonProperty) r100;
        if (Intrinsics.areEqual(this.iconKey, r101.iconKey) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L18;
        return false;
    L18:
        if (this.direction == r101.direction) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.actionId, r101.actionId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.isDisable, r101.isDisable) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.udIcon, r101.udIcon) == true) goto L29;
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
        if (r101.hasNext() == false) goto L50;
        Map.Entry<Integer, PreviewData> r102 = r101.next();
        int r103 = r102.getKey().intValue();
        ImageSet r104 = null;
        UDIcon r105 = null;
        Boolean r106 = null;
        String r107 = null;
        String r108 = null;
        if (r103 == ComponentAttribute.icon.getValue()) goto L9;
        if (r103 == ComponentAttribute.text.getValue()) goto L15;
        if (r103 == ComponentAttribute.direction.getValue()) goto L21;
        if (r103 == ComponentAttribute.action_id.getValue()) goto L30;
        if (r103 == ComponentAttribute.is_disable.getValue()) goto L36;
        if (r103 == ComponentAttribute.ud_icon_key.getValue()) goto L46;
        if (r103 == ComponentAttribute.ud_icon_theme_color.getValue()) goto L46;
        if (r103 != ComponentAttribute.unicode.getValue()) goto L6;
    L46:
        UDIcon r109 = this.udIcon;
        if (r109 == null) goto L49;
        r105 = r109.patchData(r102.getKey().intValue(), r102.getValue(), this.udIcon);
    L49:
        this.udIcon = r105;
        goto L6
    L36:
        PreviewData r110 = r102.getValue();
        if (r110 == null) goto L39;
        r106 = r110.getBoolean();
    L39:
        this.isDisable = r106;
        goto L6
    L30:
        PreviewData r111 = r102.getValue();
        if (r111 == null) goto L33;
        r107 = r111.getString();
    L33:
        this.actionId = r107;
        goto L6
    L21:
        Direction.a r112 = Direction.Companion;
        PreviewData r113 = r102.getValue();
        if (r113 == null) goto L26;
        Integer r114 = r113.getInt();
        if (r114 == null) goto L26;
        int r115 = r114.intValue();
    L27:
        r112.getClass();
        this.direction = Direction.a.a(r115);
    L26:
        r115 = 0;
        goto L27
    L15:
        PreviewData r116 = r102.getValue();
        if (r116 == null) goto L18;
        r108 = r116.getString();
    L18:
        this.text = r108;
        goto L6
    L9:
        PreviewData r117 = r102.getValue();
        if (r117 == null) goto L12;
        r104 = r117.getImageSet();
    L12:
        this.iconKey = r104;
        goto L6
    }

    public final void setActionId(String r100) {
        this.actionId = r100;
    }

    public final void setDirection(Direction r100) {
        this.direction = r100;
    }

    public final void setDisable(Boolean r100) {
        this.isDisable = r100;
    }

    public final void setIconKey(ImageSet r100) {
        this.iconKey = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }

    public final void setUdIcon(UDIcon r100) {
        this.udIcon = r100;
    }

    public ButtonProperty(ImageSet r100, String r101, Direction r102, String r103, Boolean r104, UDIcon r105) {
        super(Type.BUTTON);
        this.iconKey = r100;
        this.text = r101;
        this.direction = r102;
        this.actionId = r103;
        this.isDisable = r104;
        this.udIcon = r105;
    }

    public /* synthetic */ ButtonProperty(ImageSet r100, String r101, Direction r102, String r103, Boolean r110, UDIcon r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        ImageSet r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        r102 = Direction.LTR;
    L13:
        Direction r105 = r102;
        if ((r112 & 8) == 0) goto L16;
        String r106 = null;
    L18:
        if ((r112 & 16) == 0) goto L20;
        Boolean r107 = null;
    L22:
        if ((r112 & 32) == 0) goto L24;
        UDIcon r115 = null;
    L25:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L24:
        r115 = r111;
        goto L25
    L20:
        r107 = r110;
        goto L22
    L16:
        r106 = r103;
        goto L18
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
