package com.bytedance.ee.drive.preview;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012$\b\u0002\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\nj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\u000b¢\u0006\u0004\b\f\u0010\rJ\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J%\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\nj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\u000bHÆ\u0003J_\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2$\b\u0002\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\nj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0005j\b\u0012\u0004\u0012\u00020\u0003`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R-\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\nj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006%"}, d2 = {"Lcom/bytedance/ee/drive/preview/DrivePreviewOpenRequest;", "Ljava/io/Serializable;", "current", "Lcom/bytedance/ee/drive/preview/DrivePreviewOpenItem;", "fileList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "source", "", "extra", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "<init>", "(Lcom/bytedance/ee/drive/preview/DrivePreviewOpenItem;Ljava/util/ArrayList;Ljava/lang/String;Ljava/util/HashMap;)V", "getCurrent", "()Lcom/bytedance/ee/drive/preview/DrivePreviewOpenItem;", "getFileList", "()Ljava/util/ArrayList;", "getSource", "()Ljava/lang/String;", "getExtra", "()Ljava/util/HashMap;", "normalizedFileList", "", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "contentmanager-drive-export-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DrivePreviewOpenRequest implements Serializable {
    public static final a Companion = null;
    public static final String EXTRA_KEY = "drive_preview_open_request";
    private final DrivePreviewOpenItem current;
    private final HashMap<String, String> extra;
    private final ArrayList<DrivePreviewOpenItem> fileList;
    private final String source;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DrivePreviewOpenRequest copy$default(DrivePreviewOpenRequest r100, DrivePreviewOpenItem r101, ArrayList r102, String r103, HashMap r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.current;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.fileList;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.source;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.extra;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final DrivePreviewOpenItem component1() {
        return this.current;
    }

    public final ArrayList<DrivePreviewOpenItem> component2() {
        return this.fileList;
    }

    public final String component3() {
        return this.source;
    }

    public final HashMap<String, String> component4() {
        return this.extra;
    }

    public final DrivePreviewOpenRequest copy(DrivePreviewOpenItem r100, ArrayList<DrivePreviewOpenItem> r101, String r102, HashMap<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, "current");
        Intrinsics.checkNotNullParameter(r101, "fileList");
        Intrinsics.checkNotNullParameter(r103, "extra");
        return new DrivePreviewOpenRequest(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DrivePreviewOpenRequest) == true) goto L8;
        return false;
    L8:
        DrivePreviewOpenRequest r101 = (DrivePreviewOpenRequest) r100;
        if (Intrinsics.areEqual(this.current, r101.current) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fileList, r101.fileList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.source, r101.source) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.current.hashCode() * 31) + this.fileList.hashCode()) * 31;
        String r101 = this.source;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.extra.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "DrivePreviewOpenRequest(current=" + this.current + ", fileList=" + this.fileList + ", source=" + this.source + ", extra=" + this.extra + ')';
    }

    public final List<DrivePreviewOpenItem> normalizedFileList() {
        ArrayList<DrivePreviewOpenItem> r100 = this.fileList;
        boolean r101 = false;
        if ((r100 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r102 = r100.iterator();
    L9:
        if (r102.hasNext() == false) goto L13;
        if (Intrinsics.areEqual(((DrivePreviewOpenItem) r102.next()).getToken(), this.current.getToken()) == false) goto L9;
        r101 = true;
    L13:
        if (r101 == false) goto L17;
        return this.fileList;
    L17:
        return CollectionsKt.plus(CollectionsKt.listOf(this.current), this.fileList);
    L5:
        if (r100.isEmpty() == false) goto L7;
        goto L7
    }

    public final DrivePreviewOpenItem getCurrent() {
        return this.current;
    }

    public final HashMap<String, String> getExtra() {
        return this.extra;
    }

    public final ArrayList<DrivePreviewOpenItem> getFileList() {
        return this.fileList;
    }

    public final String getSource() {
        return this.source;
    }

    public DrivePreviewOpenRequest(DrivePreviewOpenItem r100, ArrayList<DrivePreviewOpenItem> r101, String r102, HashMap<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, "current");
        Intrinsics.checkNotNullParameter(r101, "fileList");
        Intrinsics.checkNotNullParameter(r103, "extra");
        this.current = r100;
        this.fileList = r101;
        this.source = r102;
        this.extra = r103;
    }

    public /* synthetic */ DrivePreviewOpenRequest(DrivePreviewOpenItem r100, ArrayList r101, String r102, HashMap r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = new ArrayList();
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = new HashMap();
    L11:
        this(r100, r101, r102, r103);
    }
}
