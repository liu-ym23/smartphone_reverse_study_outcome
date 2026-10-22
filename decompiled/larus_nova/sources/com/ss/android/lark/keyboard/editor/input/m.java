package com.ss.android.lark.keyboard.editor.input;

import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes36.dex */
public final class m extends com.ss.android.lark.keyboard.edittext2.edittors.e {
    @Override // com.ss.android.lark.keyboard.edittext2.edittors.e
    public final void V() {
        if (this.f429056d != 1) goto L6;
        UDToast.show(context(), R.string.Lark_Chat_TopicCreateSelectVideoError);
        return;
    }

    public m() {
    }
}
