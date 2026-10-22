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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
    public static /* synthetic */ DrivePreviewOpenRequest copy$default(DrivePreviewOpenRequest r0, DrivePreviewOpenItem r1, ArrayList r2, String r3, HashMap r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.current;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.fileList;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.source;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.extra;
    L15:
        return r0.copy(r1, r2, r3, r4);
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

    public final DrivePreviewOpenRequest copy(DrivePreviewOpenItem r2, ArrayList<DrivePreviewOpenItem> r3, String r4, HashMap<String, String> r5) {
        Intrinsics.checkNotNullParameter(r2, "current");
        Intrinsics.checkNotNullParameter(r3, "fileList");
        Intrinsics.checkNotNullParameter(r5, "extra");
        return new DrivePreviewOpenRequest(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DrivePreviewOpenRequest) == true) goto L8;
        return false;
    L8:
        DrivePreviewOpenRequest r6 = (DrivePreviewOpenRequest) r5;
        if (Intrinsics.areEqual(this.current, r6.current) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fileList, r6.fileList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.source, r6.source) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.extra, r6.extra) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.current.hashCode() * 31) + this.fileList.hashCode()) * 31;
        String r1 = this.source;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.extra.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "DrivePreviewOpenRequest(current=" + this.current + ", fileList=" + this.fileList + ", source=" + this.source + ", extra=" + this.extra + ')';
    }

    public final List<DrivePreviewOpenItem> normalizedFileList() {
        ArrayList<DrivePreviewOpenItem> r0 = this.fileList;
        boolean r2 = false;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        if (Intrinsics.areEqual(((DrivePreviewOpenItem) r1.next()).getToken(), this.current.getToken()) == false) goto L9;
        r2 = true;
    L13:
        if (r2 == false) goto L17;
        return this.fileList;
    L17:
        return CollectionsKt.plus(CollectionsKt.listOf(this.current), this.fileList);
    L5:
        if (r0.isEmpty() == false) goto L7;
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

    public DrivePreviewOpenRequest(DrivePreviewOpenItem r2, ArrayList<DrivePreviewOpenItem> r3, String r4, HashMap<String, String> r5) {
        Intrinsics.checkNotNullParameter(r2, "current");
        Intrinsics.checkNotNullParameter(r3, "fileList");
        Intrinsics.checkNotNullParameter(r5, "extra");
        this.current = r2;
        this.fileList = r3;
        this.source = r4;
        this.extra = r5;
    }

    public /* synthetic */ DrivePreviewOpenRequest(DrivePreviewOpenItem r1, ArrayList r2, String r3, HashMap r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = new ArrayList();
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 8) == 0) goto L11;
        r4 = new HashMap();
    L11:
        this(r1, r2, r3, r4);
    }
}
