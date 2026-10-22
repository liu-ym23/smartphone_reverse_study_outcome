package com.bytedance.awemeopen.apps.framework.comment.write.emojichoose;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.apps.framework.comment.write.emojichoose.choose.EmojiChooseParams;
import com.larus.nova.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class EmojiGridPage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m44.d f194427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f194428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f194429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EmojiChooseParams f194430d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f194431e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f194432f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RecyclerView f194433g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f194434h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DmtTextView f194435i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public DmtTextView f194436j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f194437k;

    public final void a(boolean r100) {
        if (r100 == false) goto L19;
        DmtTextView r101 = this.f194435i;
        if (r101 == null) goto L7;
        r101.setAlpha(1.0f);
    L7:
        DmtTextView r102 = this.f194436j;
        if (r102 == null) goto L11;
        r102.setAlpha(1.0f);
    L11:
        DmtTextView r103 = this.f194435i;
        if (r103 == null) goto L15;
        r103.setEnabled(true);
    L15:
        DmtTextView r104 = this.f194436j;
        if (r104 == null) goto L37;
        r104.setEnabled(true);
        return;
    L37:
        return;
    L19:
        DmtTextView r105 = this.f194435i;
        if (r105 == null) goto L23;
        r105.setAlpha(0.5f);
    L23:
        DmtTextView r106 = this.f194436j;
        if (r106 == null) goto L27;
        r106.setAlpha(0.5f);
    L27:
        DmtTextView r107 = this.f194435i;
        if (r107 == null) goto L31;
        r107.setEnabled(false);
    L31:
        DmtTextView r108 = this.f194436j;
        if (r108 == null) goto L38;
        r108.setEnabled(false);
        return;
    }

    public EmojiGridPage(m44.d r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "inputApi");
        Intrinsics.checkNotNullParameter(r101, "emojiGridPageParams");
        this.f194427a = r100;
        this.f194428b = r101;
        this.f194429c = r101.f194454a;
        EmojiChooseParams r102 = r101.f194457d;
        Intrinsics.checkNotNull(r102);
        this.f194430d = r102;
        this.f194431e = r101.f194456c;
        View r103 = r101.f194455b;
        Intrinsics.checkNotNull(r103);
        this.f194432f = r103;
        this.f194433g = (RecyclerView) r103.findViewById(R.id.recyclerView);
        this.f194434h = LazyKt.lazy(new EmojiGridPage$mAdapter$2(this));
    }
}
