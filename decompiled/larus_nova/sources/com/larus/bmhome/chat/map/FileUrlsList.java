package com.larus.bmhome.chat.map;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\n\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/chat/map/FileUrlsList;", "", "fileUrls", "", "Lcom/larus/bmhome/chat/map/FileUrlsBean;", "<init>", "(Ljava/util/List;)V", "getFileUrls", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileUrlsList {

    @SerializedName("file_urls")
    private final List<FileUrlsBean> fileUrls;

    /* JADX WARN: Multi-variable type inference failed */
    public FileUrlsList() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FileUrlsList copy$default(FileUrlsList r100, List r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.fileUrls;
    L6:
        return r100.copy(r101);
    }

    public final List<FileUrlsBean> component1() {
        return this.fileUrls;
    }

    public final FileUrlsList copy(List<FileUrlsBean> r100) {
        return new FileUrlsList(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FileUrlsList) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.fileUrls, ((FileUrlsList) r100).fileUrls) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List<FileUrlsBean> r100 = this.fileUrls;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "FileUrlsList(fileUrls=" + this.fileUrls + ')';
    }

    public final List<FileUrlsBean> getFileUrls() {
        return this.fileUrls;
    }

    public FileUrlsList(List<FileUrlsBean> r100) {
        this.fileUrls = r100;
    }

    public /* synthetic */ FileUrlsList(List r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = CollectionsKt.emptyList();
    L5:
        this(r100);
    }
}
