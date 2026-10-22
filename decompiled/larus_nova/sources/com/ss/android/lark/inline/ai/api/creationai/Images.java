package com.ss.android.lark.inline.ai.api.creationai;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001d\u001a\u00020\u001aH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR.\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R.\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/creationai/Images;", "Ljava/io/Serializable;", "<init>", "()V", "show", "", "getShow", "()Z", "setShow", "(Z)V", "status", "", "getStatus", "()Ljava/lang/Integer;", "setStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "data", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/inline/ai/api/creationai/ImageData;", "Lkotlin/collections/ArrayList;", "getData", "()Ljava/util/ArrayList;", "setData", "(Ljava/util/ArrayList;)V", "checkList", "", "getCheckList", "setCheckList", "toString", "Status", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Images implements Serializable {
    private ArrayList<String> checkList;
    private ArrayList<ImageData> data;
    private boolean show;
    private Integer status;

    public Images() {
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

    public final Integer getStatus() {
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

    public final void setStatus(Integer r100) {
        this.status = r100;
    }
}
