package com.ss.android.lark.export.entity;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.lark.pb.basic.v1.EngineEntity;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007\u0012&\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u0001`\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J)\u0010\u0017\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u0001`\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u000bHÆ\u0003Ju\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032(\b\u0002\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072(\b\u0002\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u0001`\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR1\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R1\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/ss/android/lark/export/entity/RenderRouterEntity;", "Ljava/io/Serializable;", "rootId", "", SlcElement.KEY_ELEMENTS, "Ljava/util/HashMap;", "Lcom/ss/android/lark/export/entity/CardComponent;", "Lkotlin/collections/HashMap;", "pbEngineEntityMap", "Lcom/bytedance/lark/pb/basic/v1/EngineEntity;", "widthMode", "Lcom/ss/android/lark/export/entity/WidthMode;", "<init>", "(Ljava/lang/String;Ljava/util/HashMap;Ljava/util/HashMap;Lcom/ss/android/lark/export/entity/WidthMode;)V", "getRootId", "()Ljava/lang/String;", "getElements", "()Ljava/util/HashMap;", "getPbEngineEntityMap", "getWidthMode", "()Lcom/ss/android/lark/export/entity/WidthMode;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RenderRouterEntity implements Serializable {
    private final HashMap<String, CardComponent> elements;
    private final HashMap<String, EngineEntity> pbEngineEntityMap;
    private final String rootId;
    private final WidthMode widthMode;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RenderRouterEntity copy$default(RenderRouterEntity r100, String r101, HashMap r102, HashMap r103, WidthMode r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.rootId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.elements;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.pbEngineEntityMap;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.widthMode;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.rootId;
    }

    public final HashMap<String, CardComponent> component2() {
        return this.elements;
    }

    public final HashMap<String, EngineEntity> component3() {
        return this.pbEngineEntityMap;
    }

    public final WidthMode component4() {
        return this.widthMode;
    }

    public final RenderRouterEntity copy(String r100, HashMap<String, CardComponent> r101, HashMap<String, EngineEntity> r102, WidthMode r103) {
        return new RenderRouterEntity(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RenderRouterEntity) == true) goto L8;
        return false;
    L8:
        RenderRouterEntity r101 = (RenderRouterEntity) r100;
        if (Intrinsics.areEqual(this.rootId, r101.rootId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.elements, r101.elements) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.pbEngineEntityMap, r101.pbEngineEntityMap) == true) goto L18;
        return false;
    L18:
        if (this.widthMode == r101.widthMode) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.rootId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        HashMap<String, CardComponent> r104 = this.elements;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        HashMap<String, EngineEntity> r107 = this.pbEngineEntityMap;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        WidthMode r110 = this.widthMode;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "RenderRouterEntity(rootId=" + this.rootId + ", elements=" + this.elements + ", pbEngineEntityMap=" + this.pbEngineEntityMap + ", widthMode=" + this.widthMode + ')';
    }

    public final HashMap<String, CardComponent> getElements() {
        return this.elements;
    }

    public final HashMap<String, EngineEntity> getPbEngineEntityMap() {
        return this.pbEngineEntityMap;
    }

    public final String getRootId() {
        return this.rootId;
    }

    public final WidthMode getWidthMode() {
        return this.widthMode;
    }

    public RenderRouterEntity(String r100, HashMap<String, CardComponent> r101, HashMap<String, EngineEntity> r102, WidthMode r103) {
        this.rootId = r100;
        this.elements = r101;
        this.pbEngineEntityMap = r102;
        this.widthMode = r103;
    }

    public /* synthetic */ RenderRouterEntity(String r100, HashMap r101, HashMap r102, WidthMode r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 8) == 0) goto L5;
        r103 = null;
    L5:
        this(r100, r101, r102, r103);
    }
}
