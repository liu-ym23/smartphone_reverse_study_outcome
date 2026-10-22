package com.obric.aivoice.sdk;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/obric/aivoice/sdk/FileAsrTaskEvent;", "", "event", "", "extra", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getEvent", "()Ljava/lang/Integer;", "setEvent", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getExtra", "()Ljava/lang/String;", "setExtra", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/obric/aivoice/sdk/FileAsrTaskEvent;", "equals", "", "other", "hashCode", "toString", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FileAsrTaskEvent {

    @SerializedName("task_event")
    private Integer event;

    @SerializedName("extra")
    private String extra;

    /* JADX WARN: Multi-variable type inference failed */
    public FileAsrTaskEvent() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ FileAsrTaskEvent copy$default(FileAsrTaskEvent r100, Integer r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.event;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.extra;
    L9:
        return r100.copy(r101, r102);
    }

    public final Integer component1() {
        return this.event;
    }

    public final String component2() {
        return this.extra;
    }

    public final FileAsrTaskEvent copy(Integer r100, String r101) {
        return new FileAsrTaskEvent(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FileAsrTaskEvent) == true) goto L8;
        return false;
    L8:
        FileAsrTaskEvent r101 = (FileAsrTaskEvent) r100;
        if (Intrinsics.areEqual(this.event, r101.event) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.event;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.extra;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "FileAsrTaskEvent(event=" + this.event + ", extra=" + this.extra + ')';
    }

    public final Integer getEvent() {
        return this.event;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final void setEvent(Integer r100) {
        this.event = r100;
    }

    public final void setExtra(String r100) {
        this.extra = r100;
    }

    public FileAsrTaskEvent(Integer r100, String r101) {
        this.event = r100;
        this.extra = r101;
    }

    public /* synthetic */ FileAsrTaskEvent(Integer r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
