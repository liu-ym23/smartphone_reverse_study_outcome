package com.ss.android.lark.flow.chat.message.mergeforward;

import android.view.View;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.blueprint.k;
import com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.ThreadReplyExposureView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements k<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f422651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f422652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f422653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ThreadReplyExposureView f422654d;

    @Override // com.ss.android.lark.blueprint.k
    public final View getView() {
        return this.f422651a;
    }

    public a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f422651a = r100;
        this.f422652b = r100.findViewById(R.id.root);
        this.f422653c = (TextView) r100.findViewById(R.id.merge_forward_title);
        this.f422654d = (ThreadReplyExposureView) r100.findViewById(R.id.merge_forward_content);
    }
}
