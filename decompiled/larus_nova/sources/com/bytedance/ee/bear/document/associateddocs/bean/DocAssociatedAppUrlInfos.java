package com.bytedance.ee.bear.document.associateddocs.bean;

import com.bytedance.ee.util.io.NonProguard;
import com.larksuite.framework.utils.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0019\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J#\u0010\r\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/document/associateddocs/bean/DocAssociatedAppUrlInfos;", "Lcom/bytedance/ee/util/io/NonProguard;", "data", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/document/associateddocs/bean/DocAssociatedAppUrlInfo;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "getData", "()Ljava/util/ArrayList;", "toString", "", "component1", "copy", "equals", "", "other", "", "hashCode", "", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocAssociatedAppUrlInfos implements NonProguard {
    private final ArrayList<DocAssociatedAppUrlInfo> data;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DocAssociatedAppUrlInfos copy$default(DocAssociatedAppUrlInfos r100, ArrayList r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.data;
    L6:
        return r100.copy(r101);
    }

    public final ArrayList<DocAssociatedAppUrlInfo> component1() {
        return this.data;
    }

    public final DocAssociatedAppUrlInfos copy(ArrayList<DocAssociatedAppUrlInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return new DocAssociatedAppUrlInfos(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DocAssociatedAppUrlInfos) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.data, ((DocAssociatedAppUrlInfos) r100).data) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public String toString() {
        Iterator<DocAssociatedAppUrlInfo> r100 = this.data.iterator();
        String r101 = "DocAssociatedAppUrlInfos[";
    L4:
        if (r100.hasNext() == false) goto L7;
        DocAssociatedAppUrlInfo r102 = r100.next();
        StringBuilder r103 = new StringBuilder();
        r103.append(r101);
        r103.append("(url=");
        Pattern r104 = g.f285989a;
        r103.append(g.a(r102.getUrl()));
        r103.append(',');
        r101 = r103.toString() + "previe_token=" + r102.getPrevieToken() + "),";
        goto L4
    L7:
        return r101 + ']';
    }

    public final ArrayList<DocAssociatedAppUrlInfo> getData() {
        return this.data;
    }

    public DocAssociatedAppUrlInfos(ArrayList<DocAssociatedAppUrlInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.data = r100;
    }
}
