package com.ss.android.lark.inline.ai.ui.view;

import android.graphics.drawable.Drawable;
import android.widget.EditText;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class e extends ncc.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EditText f427688b;

    public e(EditText r100) {
        this.f427688b = r100;
        super(r100);
    }

    @Override // ncc.d, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "who");
        super.invalidateDrawable(r100);
        int r101 = this.f427688b.getSelectionStart();
        int r102 = this.f427688b.getSelectionEnd();
        EditText r103 = this.f427688b;
        r103.setText(r103.getText());
        this.f427688b.setSelection(r101, r102);
        Log.i("URLRecognition", "invalidateDrawable");
    }
}
