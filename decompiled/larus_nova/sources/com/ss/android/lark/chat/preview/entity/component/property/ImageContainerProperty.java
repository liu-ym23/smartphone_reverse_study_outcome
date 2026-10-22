package com.ss.android.lark.chat.preview.entity.component.property;

import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.ImageSet;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UrlPreviewPropertyData;
import com.ss.android.lark.tangram.base.props.Props;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001'B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0096\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0000H\u0016J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003J-\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\t\u0010&\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006("}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/ImageContainerProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "", "background", "Lcom/ss/android/lark/export/entity/preview/ImageSet;", "actionId", "", "contentMode", "Lcom/ss/android/lark/chat/preview/entity/component/property/ImageContainerProperty$ContentMode;", "<init>", "(Lcom/ss/android/lark/export/entity/preview/ImageSet;Ljava/lang/String;Lcom/ss/android/lark/chat/preview/entity/component/property/ImageContainerProperty$ContentMode;)V", "getBackground", "()Lcom/ss/android/lark/export/entity/preview/ImageSet;", "setBackground", "(Lcom/ss/android/lark/export/entity/preview/ImageSet;)V", "getActionId", "()Ljava/lang/String;", "setActionId", "(Ljava/lang/String;)V", "getContentMode", "()Lcom/ss/android/lark/chat/preview/entity/component/property/ImageContainerProperty$ContentMode;", "setContentMode", "(Lcom/ss/android/lark/chat/preview/entity/component/property/ImageContainerProperty$ContentMode;)V", "patchData", "", "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "equals", "", "other", "", "hashCode", "", "clone", "component1", "component2", "component3", "copy", "toString", "ContentMode", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageContainerProperty extends BaseProperty implements Cloneable {
    private String actionId;
    private ImageSet background;
    private ContentMode contentMode;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/ImageContainerProperty$ContentMode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SCALE_TO_FILL", "SCALE_ASPECT_FIT", "SCALE_ASPECT_FILL", "CENTER", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ContentMode extends Enum<ContentMode> {
        public static final ContentMode CENTER = null;
        public static final ContentMode SCALE_ASPECT_FILL = null;
        public static final ContentMode SCALE_ASPECT_FIT = null;
        public static final ContentMode SCALE_TO_FILL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ContentMode[] f416253a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f416254b = null;
        private final int value;

        public static EnumEntries<ContentMode> getEntries() {
            return f416254b;
        }

        static {
            ContentMode r100 = new ContentMode("SCALE_TO_FILL", 0, 0);
            SCALE_TO_FILL = r100;
            ContentMode r101 = new ContentMode("SCALE_ASPECT_FIT", 1, 1);
            SCALE_ASPECT_FIT = r101;
            ContentMode r102 = new ContentMode("SCALE_ASPECT_FILL", 2, 2);
            SCALE_ASPECT_FILL = r102;
            ContentMode r103 = new ContentMode("CENTER", 3, 3);
            CENTER = r103;
            ContentMode[] r104 = {r100, r101, r102, r103};
            f416253a = r104;
            f416254b = EnumEntriesKt.enumEntries(r104);
        }

        public static ContentMode[] values() {
            return (ContentMode[]) f416253a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ContentMode valueOf(String r100) {
            return (ContentMode) a.a(ContentMode.class, r100);
        }

        public ContentMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static /* synthetic */ ImageContainerProperty copy$default(ImageContainerProperty r100, ImageSet r101, String r102, ContentMode r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.background;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.actionId;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.contentMode;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final ImageSet component1() {
        return this.background;
    }

    public final String component2() {
        return this.actionId;
    }

    public final ContentMode component3() {
        return this.contentMode;
    }

    public final ImageContainerProperty copy(ImageSet r100, String r101, ContentMode r102) {
        return new ImageContainerProperty(r100, r101, r102);
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public void patchData(UrlPreviewPropertyData r100) {
    }

    public String toString() {
        return "ImageContainerProperty(background=" + this.background + ", actionId=" + this.actionId + ", contentMode=" + this.contentMode + ')';
    }

    @Override // com.ss.android.lark.tangram.base.props.Props
    public ImageContainerProperty clone() {
        return new ImageContainerProperty(this.background, this.actionId, this.contentMode);
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public int hashCode() {
        int r100 = super.hashCode() * 31;
        ImageSet r101 = this.background;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.actionId;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        ContentMode r108 = this.contentMode;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        return r107 + r102;
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

    public final ImageSet getBackground() {
        return this.background;
    }

    public final ContentMode getContentMode() {
        return this.contentMode;
    }

    @Override // com.ss.android.lark.tangram.base.props.Props
    public /* bridge */ /* synthetic */ Props clone() {
        return clone();
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8616clone() {
        return clone();
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public boolean equals(Object r100) {
        if (super.equals(r100) == true) goto L5;
    L13:
        return false;
    L5:
        if ((r100 instanceof ImageContainerProperty) == false) goto L13;
        ImageContainerProperty r101 = (ImageContainerProperty) r100;
        if (Intrinsics.areEqual(this.background, r101.background) == false) goto L13;
        if (Intrinsics.areEqual(this.actionId, r101.actionId) == false) goto L13;
        if (this.contentMode != r101.contentMode) goto L13;
        return true;
    }

    public final void setActionId(String r100) {
        this.actionId = r100;
    }

    public final void setBackground(ImageSet r100) {
        this.background = r100;
    }

    public final void setContentMode(ContentMode r100) {
        this.contentMode = r100;
    }

    public ImageContainerProperty(ImageSet r100, String r101, ContentMode r102) {
        super(Type.IMAGE_CONTAINER);
        this.background = r100;
        this.actionId = r101;
        this.contentMode = r102;
    }
}
