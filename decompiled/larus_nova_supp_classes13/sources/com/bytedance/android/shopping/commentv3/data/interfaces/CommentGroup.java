package com.bytedance.android.shopping.commentv3.data.interfaces;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R&\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/data/interfaces/CommentGroup;", "Ljava/io/Serializable;", "()V", "lynx", "Lcom/bytedance/android/shopping/commentv3/data/interfaces/CommentLynxComponent;", "getLynx", "()Lcom/bytedance/android/shopping/commentv3/data/interfaces/CommentLynxComponent;", "setLynx", "(Lcom/bytedance/android/shopping/commentv3/data/interfaces/CommentLynxComponent;)V", "native", "Lcom/bytedance/android/shopping/commentv3/data/interfaces/CommentNativeComponent;", "getNative", "()Lcom/bytedance/android/shopping/commentv3/data/interfaces/CommentNativeComponent;", "setNative", "(Lcom/bytedance/android/shopping/commentv3/data/interfaces/CommentNativeComponent;)V", "sliceId", "", "getSliceId", "()Ljava/lang/String;", "setSliceId", "(Ljava/lang/String;)V", "slices", "", "Lcom/bytedance/android/shopping/commentv3/data/interfaces/CommentSliceComponent;", "getSlices", "()Ljava/util/List;", "setSlices", "(Ljava/util/List;)V", "viewType", "getViewType", "setViewType", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentGroup implements Serializable {

    @SerializedName("lynx")
    private CommentLynxComponent lynx;

    /* JADX INFO: renamed from: native, reason: not valid java name */
    @SerializedName("native")
    private CommentNativeComponent f3native;

    @SerializedName("slice_id")
    private String sliceId;

    @SerializedName("slices")
    private List<CommentSliceComponent> slices;

    @SerializedName("view_type")
    private String viewType;

    public CommentGroup() {
    }

    public final CommentLynxComponent getLynx() {
        return this.lynx;
    }

    public final CommentNativeComponent getNative() {
        return this.f3native;
    }

    public final String getSliceId() {
        return this.sliceId;
    }

    public final List<CommentSliceComponent> getSlices() {
        return this.slices;
    }

    public final String getViewType() {
        return this.viewType;
    }

    public final void setLynx(CommentLynxComponent r1) {
        this.lynx = r1;
    }

    public final void setNative(CommentNativeComponent r1) {
        this.f3native = r1;
    }

    public final void setSliceId(String r1) {
        this.sliceId = r1;
    }

    public final void setSlices(List<CommentSliceComponent> r1) {
        this.slices = r1;
    }

    public final void setViewType(String r1) {
        this.viewType = r1;
    }
}
