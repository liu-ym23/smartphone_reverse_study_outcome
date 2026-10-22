package com.ss.android.lark.inline.ai.api.ui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001&BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t\u0012\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\t¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u001c\u001a\u00020\u000bH\u0016J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tHÆ\u0003J\u001d\u0010 \u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\tHÆ\u0003JY\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t2\u001c\b\u0002\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\tHÆ\u0001J\u0013\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R.\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019¨\u0006'"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/ui/Images;", "Ljava/io/Serializable;", "show", "", "status", "", "data", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/inline/ai/api/ui/ImageData;", "Lkotlin/collections/ArrayList;", "checkList", "", "<init>", "(ZILjava/util/ArrayList;Ljava/util/ArrayList;)V", "getShow", "()Z", "setShow", "(Z)V", "getStatus", "()I", "setStatus", "(I)V", "getData", "()Ljava/util/ArrayList;", "setData", "(Ljava/util/ArrayList;)V", "getCheckList", "setCheckList", "toString", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "Status", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Images implements Serializable {
    private ArrayList<String> checkList;
    private ArrayList<ImageData> data;
    private boolean show;
    private int status;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Images copy$default(Images r100, boolean r101, int r102, ArrayList r103, ArrayList r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.show;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.status;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.data;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.checkList;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final boolean component1() {
        return this.show;
    }

    public final int component2() {
        return this.status;
    }

    public final ArrayList<ImageData> component3() {
        return this.data;
    }

    public final ArrayList<String> component4() {
        return this.checkList;
    }

    public final Images copy(boolean r100, int r101, ArrayList<ImageData> r102, ArrayList<String> r103) {
        return new Images(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Images) == true) goto L8;
        return false;
    L8:
        Images r101 = (Images) r100;
        if (this.show == r101.show) goto L12;
        return false;
    L12:
        if (this.status == r101.status) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.checkList, r101.checkList) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        if (this.show == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.status) * 31;
        ArrayList<ImageData> r102 = this.data;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        ArrayList<String> r106 = this.checkList;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("Images(show=");
        r100.append(this.show);
        r100.append(", status=");
        r100.append(this.status);
        r100.append(", data=");
        r100.append(this.data);
        r100.append(", checkList=");
        ArrayList<String> r101 = this.checkList;
        if (r101 == null) goto L8;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L9;
        r102.add(Integer.valueOf(((String) r103.next()).hashCode()));
    L9:
        r100.append(r102);
        r100.append(')');
        return r100.toString();
    L8:
        r102 = null;
        goto L9
    }

    public final ArrayList<String> getCheckList() {
        return this.checkList;
    }

    public final ArrayList<ImageData> getData() {
        return this.data;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setCheckList(ArrayList<String> r100) {
        this.checkList = r100;
    }

    public final void setData(ArrayList<ImageData> r100) {
        this.data = r100;
    }

    public final void setShow(boolean r100) {
        this.show = r100;
    }

    public final void setStatus(int r100) {
        this.status = r100;
    }

    public Images(boolean r100, int r101, ArrayList<ImageData> r102, ArrayList<String> r103) {
        this.show = r100;
        this.status = r101;
        this.data = r102;
        this.checkList = r103;
    }
}
