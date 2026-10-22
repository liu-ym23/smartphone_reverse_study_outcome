package com.ss.android.lark.chat.preview.entity.component.property;

import com.bytedance.lark.pb.basic.v1.ComponentAttribute;
import com.ss.android.lark.chat.preview.entity.component.Direction;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.ImageSet;
import com.ss.android.lark.export.entity.preview.Item;
import com.ss.android.lark.export.entity.preview.Items;
import com.ss.android.lark.export.entity.preview.PreviewData;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UrlPreviewPropertyData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0096\u0002J\b\u0010&\u001a\u00020'H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006("}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/SpinButtonProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "icon", "Lcom/ss/android/lark/export/entity/preview/ImageSet;", "items", "", "Lcom/ss/android/lark/export/entity/preview/Item;", "selectedIndex", "", "direction", "Lcom/ss/android/lark/chat/preview/entity/component/Direction;", "<init>", "(Lcom/ss/android/lark/export/entity/preview/ImageSet;Ljava/util/List;Ljava/lang/Long;Lcom/ss/android/lark/chat/preview/entity/component/Direction;)V", "getIcon", "()Lcom/ss/android/lark/export/entity/preview/ImageSet;", "setIcon", "(Lcom/ss/android/lark/export/entity/preview/ImageSet;)V", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "getSelectedIndex", "()Ljava/lang/Long;", "setSelectedIndex", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getDirection", "()Lcom/ss/android/lark/chat/preview/entity/component/Direction;", "setDirection", "(Lcom/ss/android/lark/chat/preview/entity/component/Direction;)V", "patchData", "", "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "equals", "", "other", "", "hashCode", "", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpinButtonProperty extends BaseProperty {
    private Direction direction;
    private ImageSet icon;
    private List<Item> items;
    private Long selectedIndex;

    public SpinButtonProperty() {
        this(null, null, null, null, 15, null);
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public int hashCode() {
        int r100 = super.hashCode() * 31;
        ImageSet r101 = this.icon;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        List<Item> r105 = this.items;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        Long r108 = this.selectedIndex;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        Direction r111 = this.direction;
        if (r111 == null) goto L18;
        r102 = r111.hashCode();
    L18:
        return r110 + r102;
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

    public final Direction getDirection() {
        return this.direction;
    }

    public final ImageSet getIcon() {
        return this.icon;
    }

    public final List<Item> getItems() {
        return this.items;
    }

    public final Long getSelectedIndex() {
        return this.selectedIndex;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SpinButtonProperty) == true) goto L9;
        return false;
    L9:
        if (super.equals(r100) == true) goto L11;
        return false;
    L11:
        SpinButtonProperty r101 = (SpinButtonProperty) r100;
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.items, r101.items) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.selectedIndex, r101.selectedIndex) == true) goto L21;
        return false;
    L21:
        if (this.direction == r101.direction) goto L23;
        return false;
    L23:
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
        Long r105 = null;
        ArrayList<Item> r106 = null;
        r106 = null;
        if (r103 == ComponentAttribute.icon.getValue()) goto L9;
        if (r103 == ComponentAttribute.items.getValue()) goto L15;
        if (r103 == ComponentAttribute.selected_index.getValue()) goto L23;
        if (r103 != ComponentAttribute.direction.getValue()) goto L6;
        Direction.a r107 = Direction.Companion;
        PreviewData r108 = r102.getValue();
        if (r108 == null) goto L34;
        Integer r109 = r108.getInt();
        if (r109 == null) goto L34;
        int r110 = r109.intValue();
    L35:
        r107.getClass();
        this.direction = Direction.a.a(r110);
    L34:
        r110 = 0;
        goto L35
    L23:
        PreviewData r111 = r102.getValue();
        if (r111 == null) goto L26;
        r105 = r111.getLong();
    L26:
        this.selectedIndex = r105;
        goto L6
    L15:
        PreviewData r112 = r102.getValue();
        if (r112 == null) goto L20;
        Items r113 = r112.getItems();
        if (r113 == null) goto L20;
        r106 = r113.getItems();
    L20:
        this.items = r106;
        goto L6
    L9:
        PreviewData r114 = r102.getValue();
        if (r114 == null) goto L12;
        r104 = r114.getImageSet();
    L12:
        this.icon = r104;
        goto L6
    }

    public final void setDirection(Direction r100) {
        this.direction = r100;
    }

    public final void setIcon(ImageSet r100) {
        this.icon = r100;
    }

    public final void setItems(List<Item> r100) {
        this.items = r100;
    }

    public final void setSelectedIndex(Long r100) {
        this.selectedIndex = r100;
    }

    public SpinButtonProperty(ImageSet r100, List<Item> r101, Long r102, Direction r103) {
        super(Type.SPIN_BUTTON);
        this.icon = r100;
        this.items = r101;
        this.selectedIndex = r102;
        this.direction = r103;
    }

    public /* synthetic */ SpinButtonProperty(ImageSet r100, List r101, Long r102, Direction r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0L;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = Direction.LTR;
    L14:
        this(r100, r101, r102, r103);
    }
}
