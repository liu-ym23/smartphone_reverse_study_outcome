package com.ss.ugc.effectplatform.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/ss/ugc/effectplatform/model/InspirationModel;", "", "video", "Lcom/ss/ugc/effectplatform/model/VideoModel;", "author", "Lcom/ss/ugc/effectplatform/model/AuthorModel;", "(Lcom/ss/ugc/effectplatform/model/VideoModel;Lcom/ss/ugc/effectplatform/model/AuthorModel;)V", "getAuthor", "()Lcom/ss/ugc/effectplatform/model/AuthorModel;", "setAuthor", "(Lcom/ss/ugc/effectplatform/model/AuthorModel;)V", "getVideo", "()Lcom/ss/ugc/effectplatform/model/VideoModel;", "setVideo", "(Lcom/ss/ugc/effectplatform/model/VideoModel;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public final class InspirationModel {
    private AuthorModel author;
    private VideoModel video;

    /* JADX WARN: Multi-variable type inference failed */
    public InspirationModel() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ InspirationModel copy$default(InspirationModel r100, VideoModel r101, AuthorModel r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.video;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.author;
    L9:
        return r100.copy(r101, r102);
    }

    public final VideoModel component1() {
        return this.video;
    }

    public final AuthorModel component2() {
        return this.author;
    }

    public final InspirationModel copy(VideoModel r100, AuthorModel r101) {
        return new InspirationModel(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof InspirationModel) == false) goto L10;
        InspirationModel r101 = (InspirationModel) r100;
        if (Intrinsics.areEqual(this.video, r101.video) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.author, r101.author) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        VideoModel r100 = this.video;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        AuthorModel r104 = this.author;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "InspirationModel(video=" + this.video + ", author=" + this.author + ")";
    }

    public final AuthorModel getAuthor() {
        return this.author;
    }

    public final VideoModel getVideo() {
        return this.video;
    }

    public final void setAuthor(AuthorModel r100) {
        this.author = r100;
    }

    public final void setVideo(VideoModel r100) {
        this.video = r100;
    }

    public InspirationModel(VideoModel r100, AuthorModel r101) {
        this.video = r100;
        this.author = r101;
    }

    public /* synthetic */ InspirationModel(VideoModel r100, AuthorModel r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
