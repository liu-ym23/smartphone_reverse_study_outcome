package com.ss.android.lark.export.entity.preview;

import com.facebook.keyframes.model.KFAnimation;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u001b\u001a\u00020\u0000J\u0013\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0096\u0002J\b\u0010\u001f\u001a\u00020 H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u000b\u0010\u0013R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006!"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/UrlPreviewComponent;", "Ljava/io/Serializable;", "type", "Lcom/ss/android/lark/export/entity/preview/Type;", "canSkipWhenUnknown", "", "style", "Lcom/ss/android/lark/export/entity/preview/Style;", "childIds", "", "", "isFontZoomable", KFAnimation.PROPERTY_TYPE_JSON_FIELD, "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "<init>", "(Lcom/ss/android/lark/export/entity/preview/Type;Ljava/lang/Boolean;Lcom/ss/android/lark/export/entity/preview/Style;Ljava/util/List;Ljava/lang/Boolean;Lcom/ss/android/lark/export/entity/preview/BaseProperty;)V", "getType", "()Lcom/ss/android/lark/export/entity/preview/Type;", "getCanSkipWhenUnknown", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getStyle", "()Lcom/ss/android/lark/export/entity/preview/Style;", "getChildIds", "()Ljava/util/List;", "getProperty", "()Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "clone", "equals", "other", "", "hashCode", "", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrlPreviewComponent implements Serializable {
    private final Boolean canSkipWhenUnknown;
    private final List<String> childIds;
    private final Boolean isFontZoomable;
    private final BaseProperty property;
    private final Style style;
    private final Type type;

    public final UrlPreviewComponent clone() {
        Type r100 = this.type;
        Boolean r101 = this.canSkipWhenUnknown;
        Style r102 = this.style;
        if (r102 == null) goto L5;
        Style r103 = r102.clone();
    L7:
        return new UrlPreviewComponent(r100, r101, r103, this.childIds, this.isFontZoomable, this.property);
    L5:
        r103 = null;
        goto L7
    }

    public int hashCode() {
        int r100 = this.type.hashCode() * 31;
        Boolean r101 = this.canSkipWhenUnknown;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        Style r105 = this.style;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        List<String> r108 = this.childIds;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        Boolean r111 = this.isFontZoomable;
        if (r111 == null) goto L18;
        r102 = r111.hashCode();
    L18:
        return ((r110 + r102) * 31) + this.property.hashCode();
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

    public final Boolean getCanSkipWhenUnknown() {
        return this.canSkipWhenUnknown;
    }

    public final List<String> getChildIds() {
        return this.childIds;
    }

    public final BaseProperty getProperty() {
        return this.property;
    }

    public final Style getStyle() {
        return this.style;
    }

    public final Type getType() {
        return this.type;
    }

    public final Boolean isFontZoomable() {
        return this.isFontZoomable;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(UrlPreviewComponent.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.UrlPreviewComponent");
        UrlPreviewComponent r102 = (UrlPreviewComponent) r100;
        if (this.type == r102.type) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.canSkipWhenUnknown, r102.canSkipWhenUnknown) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.style, r102.style) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.childIds, r102.childIds) == true) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.isFontZoomable, r102.isFontZoomable) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.property, r102.property) == true) goto L30;
        return false;
    L30:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public UrlPreviewComponent(Type r100, Boolean r101, Style r102, List<String> r103, Boolean r104, BaseProperty r105) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r105, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        this.type = r100;
        this.canSkipWhenUnknown = r101;
        this.style = r102;
        this.childIds = r103;
        this.isFontZoomable = r104;
        this.property = r105;
    }

    public /* synthetic */ UrlPreviewComponent(Type r100, Boolean r101, Style r110, List r111, Boolean r112, BaseProperty r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 2) == 0) goto L5;
        r101 = Boolean.TRUE;
    L5:
        Boolean r102 = r101;
        if ((r114 & 16) == 0) goto L8;
        r112 = Boolean.TRUE;
    L8:
        this(r100, r102, r110, r111, r112, r113);
    }
}
