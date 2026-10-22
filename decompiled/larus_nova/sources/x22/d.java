package x22;

import android.util.LongSparseArray;
import com.bytedance.android.livesdk.interactivity.api.comment.CommentComponentType;
import com.bytedance.android.livesdk.interactivity.api.comment.data.InputDraftType;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements t22.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CommentComponentType f562233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LongSparseArray<com.bytedance.android.livesdk.interactivity.api.comment.data.e> f562234b;

    public static final class a {
    }

    static {
    }

    @Override // t22.a
    public final void onLoad() {
    }

    @Override // t22.a
    public final void onUnload() {
        this.f562234b.clear();
    }

    public d() {
        this.f562233a = CommentComponentType.Draft;
        this.f562234b = new LongSparseArray();
    }

    @Override // t22.a
    public CommentComponentType getType() {
        return this.f562233a;
    }

    public final com.bytedance.android.livesdk.interactivity.api.comment.data.e a(long r100) {
        com.bytedance.android.livesdk.interactivity.api.comment.data.e r101 = this.f562234b.get(r100);
        if (r100 <= 0) goto L5;
        InputDraftType r102 = InputDraftType.Channel;
    L6:
        if (r101 != null) goto L9;
        com.bytedance.android.livesdk.interactivity.api.comment.data.e r103 = new com.bytedance.android.livesdk.interactivity.api.comment.data.e("", r102, r100);
        this.f562234b.put(r100, r103);
        return r103;
    L9:
        return r101;
    L5:
        r102 = InputDraftType.Default;
        goto L6
    }
}
