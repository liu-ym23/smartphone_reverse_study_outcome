package com.larus.uaigc.createpage.component.inspiration;

import com.larus.bmhome.instruction.repo.InspireScene;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0005\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u001d\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0005\u0018\u00010\bHÆ\u0003JJ\u0010\u0016\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0005\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\tHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R%\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0005\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/larus/uaigc/createpage/component/inspiration/ImageInspirationState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "scene", "", "inspirationList", "", "Lcom/larus/bmhome/instruction/repo/ImgInspirePrompt;", "inspirationMap", "", "", "<init>", "(Ljava/lang/Integer;Ljava/util/List;Ljava/util/Map;)V", "getScene", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getInspirationList", "()Ljava/util/List;", "getInspirationMap", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/util/List;Ljava/util/Map;)Lcom/larus/uaigc/createpage/component/inspiration/ImageInspirationState;", "equals", "", "other", "", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageInspirationState implements w1a.b {
    private final List<fq8.e> inspirationList;
    private final Map<Integer, List<String>> inspirationMap;
    private final Integer scene;

    public ImageInspirationState() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImageInspirationState copy$default(ImageInspirationState r100, Integer r101, List r102, Map r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.scene;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.inspirationList;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.inspirationMap;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Integer component1() {
        return this.scene;
    }

    public final List<fq8.e> component2() {
        return this.inspirationList;
    }

    public final Map<Integer, List<String>> component3() {
        return this.inspirationMap;
    }

    public final ImageInspirationState copy(@InspireScene Integer r100, List<fq8.e> r101, Map<Integer, ? extends List<String>> r102) {
        return new ImageInspirationState(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ImageInspirationState) == true) goto L8;
        return false;
    L8:
        ImageInspirationState r101 = (ImageInspirationState) r100;
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.inspirationList, r101.inspirationList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.inspirationMap, r101.inspirationMap) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.scene;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<fq8.e> r104 = this.inspirationList;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Map<Integer, List<String>> r107 = this.inspirationMap;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ImageInspirationState(scene=" + this.scene + ", inspirationList=" + this.inspirationList + ", inspirationMap=" + this.inspirationMap + ')';
    }

    public final List<fq8.e> getInspirationList() {
        return this.inspirationList;
    }

    public final Map<Integer, List<String>> getInspirationMap() {
        return this.inspirationMap;
    }

    public final Integer getScene() {
        return this.scene;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImageInspirationState(@InspireScene Integer r100, List<fq8.e> r101, Map<Integer, ? extends List<String>> r102) {
        this.scene = r100;
        this.inspirationList = r101;
        this.inspirationMap = r102;
    }

    public /* synthetic */ ImageInspirationState(Integer r100, List r101, Map r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
