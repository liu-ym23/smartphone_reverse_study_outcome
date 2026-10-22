package com.bytedance.awemeopen.apps.framework.comment.write.emojichoose;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.apps.framework.comment.write.emojichoose.choose.EmojiChooseParams;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class EmojiGridPage {
    public final m44.d a;
    public final d b;
    public final Context c;
    public final EmojiChooseParams d;
    public final e e;
    public final View f;
    public final RecyclerView g;
    public final Lazy h;
    public DmtTextView i;
    public DmtTextView j;
    public View k;

    public final void a(boolean r2) {
        if (r2 == false) goto L19;
        AppCompatTextView r3 = this.i;
        if (r3 == null) goto L7;
        r3.setAlpha(1.0f);
    L7:
        AppCompatTextView r4 = this.j;
        if (r4 == null) goto L11;
        r4.setAlpha(1.0f);
    L11:
        AppCompatTextView r5 = this.i;
        if (r5 == null) goto L15;
        r5.setEnabled(true);
    L15:
        AppCompatTextView r6 = this.j;
        if (r6 == null) goto L37;
        r6.setEnabled(true);
        return;
    L37:
        return;
    L19:
        AppCompatTextView r7 = this.i;
        if (r7 == null) goto L23;
        r7.setAlpha(0.5f);
    L23:
        AppCompatTextView r8 = this.j;
        if (r8 == null) goto L27;
        r8.setAlpha(0.5f);
    L27:
        AppCompatTextView r9 = this.i;
        if (r9 == null) goto L31;
        r9.setEnabled(false);
    L31:
        AppCompatTextView r10 = this.j;
        if (r10 == null) goto L38;
        r10.setEnabled(false);
        return;
    }

    public EmojiGridPage(m44.d r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "inputApi");
        Intrinsics.checkNotNullParameter(r3, "emojiGridPageParams");
        this.a = r2;
        this.b = r3;
        this.c = r3.a;
        EmojiChooseParams r4 = r3.d;
        Intrinsics.checkNotNull(r4);
        this.d = r4;
        this.e = r3.c;
        View r5 = r3.b;
        Intrinsics.checkNotNull(r5);
        this.f = r5;
        this.g = r5.findViewById(2131384071);
        this.h = LazyKt.lazy(new EmojiGridPage$mAdapter$2(this));
    }
}
