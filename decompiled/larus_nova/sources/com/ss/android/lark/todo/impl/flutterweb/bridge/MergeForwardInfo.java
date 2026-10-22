package com.ss.android.lark.todo.impl.flutterweb.bridge;

import com.ss.android.lark.diskmanage.NonProguard;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0011\u001a\u00020\u0003H\u0016J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/todo/impl/flutterweb/bridge/MergeForwardInfo;", "Lcom/ss/android/lark/diskmanage/NonProguard;", "title", "", "content", "refResourceId", "originMessageResource", "", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getTitle", "()Ljava/lang/String;", "getContent", "getRefResourceId", "getOriginMessageResource", "()Ljava/util/List;", "toString", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MergeForwardInfo implements NonProguard {
    private final String content;
    private final List<Integer> originMessageResource;
    private final String refResourceId;
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MergeForwardInfo copy$default(MergeForwardInfo r100, String r101, String r102, String r103, List r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.title;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.content;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.refResourceId;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.originMessageResource;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.content;
    }

    public final String component3() {
        return this.refResourceId;
    }

    public final List<Integer> component4() {
        return this.originMessageResource;
    }

    public final MergeForwardInfo copy(String r100, String r101, String r102, List<Integer> r103) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r102, "refResourceId");
        Intrinsics.checkNotNullParameter(r103, "originMessageResource");
        return new MergeForwardInfo(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MergeForwardInfo) == true) goto L8;
        return false;
    L8:
        MergeForwardInfo r101 = (MergeForwardInfo) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.refResourceId, r101.refResourceId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.originMessageResource, r101.originMessageResource) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + this.content.hashCode()) * 31) + this.refResourceId.hashCode()) * 31) + this.originMessageResource.hashCode();
    }

    public String toString() {
        return "MergeForwardInfo(title='" + this.title + "', content='" + this.content + "', refResourceId='" + this.refResourceId + "', originMessageResource=" + this.originMessageResource + ')';
    }

    public final String getContent() {
        return this.content;
    }

    public final List<Integer> getOriginMessageResource() {
        return this.originMessageResource;
    }

    public final String getRefResourceId() {
        return this.refResourceId;
    }

    public final String getTitle() {
        return this.title;
    }

    public MergeForwardInfo(String r100, String r101, String r102, List<Integer> r103) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r102, "refResourceId");
        Intrinsics.checkNotNullParameter(r103, "originMessageResource");
        this.title = r100;
        this.content = r101;
        this.refResourceId = r102;
        this.originMessageResource = r103;
    }
}
