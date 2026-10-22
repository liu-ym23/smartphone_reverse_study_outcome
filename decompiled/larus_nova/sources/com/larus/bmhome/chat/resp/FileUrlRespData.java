package com.larus.bmhome.chat.resp;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/chat/resp/FileUrlRespData;", "", "fileUrlList", "", "Lcom/larus/bmhome/chat/resp/FileUrlData;", "<init>", "(Ljava/util/List;)V", "getFileUrlList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileUrlRespData {

    @SerializedName("file_urls")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<FileUrlData> fileUrlList;

    /* JADX WARN: Multi-variable type inference failed */
    public FileUrlRespData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FileUrlRespData copy$default(FileUrlRespData r100, List r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.fileUrlList;
    L6:
        return r100.copy(r101);
    }

    public final List<FileUrlData> component1() {
        return this.fileUrlList;
    }

    public final FileUrlRespData copy(List<FileUrlData> r100) {
        return new FileUrlRespData(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FileUrlRespData) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.fileUrlList, ((FileUrlRespData) r100).fileUrlList) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List<FileUrlData> r100 = this.fileUrlList;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "FileUrlRespData(fileUrlList=" + this.fileUrlList + ')';
    }

    public final List<FileUrlData> getFileUrlList() {
        return this.fileUrlList;
    }

    public FileUrlRespData(List<FileUrlData> r100) {
        this.fileUrlList = r100;
    }

    public /* synthetic */ FileUrlRespData(List r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = CollectionsKt.emptyList();
    L5:
        this(r100);
    }
}
