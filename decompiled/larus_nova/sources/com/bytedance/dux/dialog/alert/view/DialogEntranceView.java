package com.bytedance.dux.dialog.alert.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/dux/dialog/alert/view/DialogEntranceView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/widget/TextView;", "getTextView", "Landroid/widget/ImageView;", "getImageView", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DialogEntranceView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f204958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f204959b;

    public DialogEntranceView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 6);
    }

    public DialogEntranceView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4);
    }

    public final ImageView getImageView() {
        return this.f204959b;
    }

    public final TextView getTextView() {
        return this.f204958a;
    }

    public DialogEntranceView(Context r100, AttributeSet r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        ViewGroup.inflate(r100, R.layout.dux_layout_dialog_entrance, this);
        this.f204958a = (TextView) findViewById(R.id.tv_normal);
        this.f204959b = (ImageView) findViewById(R.id.icon);
    }
}
