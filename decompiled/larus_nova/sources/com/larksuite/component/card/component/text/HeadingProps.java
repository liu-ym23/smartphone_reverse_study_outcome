package com.larksuite.component.card.component.text;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/larksuite/component/card/component/text/HeadingProps;", "", SlcElement.KEY_ELEMENTS, "", "Lcom/larksuite/component/card/component/text/ContentProps;", "<init>", "(Ljava/util/List;)V", "getElements", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HeadingProps {
    private final List<ContentProps> elements;

    /* JADX WARN: Multi-variable type inference failed */
    public HeadingProps() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HeadingProps copy$default(HeadingProps r100, List r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.elements;
    L6:
        return r100.copy(r101);
    }

    public final List<ContentProps> component1() {
        return this.elements;
    }

    public final HeadingProps copy(List<ContentProps> r100) {
        return new HeadingProps(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof HeadingProps) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.elements, ((HeadingProps) r100).elements) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List<ContentProps> r100 = this.elements;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "HeadingProps(elements=" + this.elements + ')';
    }

    public final List<ContentProps> getElements() {
        return this.elements;
    }

    public HeadingProps(List<ContentProps> r100) {
        this.elements = r100;
    }

    public /* synthetic */ HeadingProps(List r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
