package com.larus.bmhome.bot.dialog;

import android.view.KeyEvent;
import android.widget.TextView;
import com.larus.bmhome.databinding.LarusDialogNicknameInputBottomBinding;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class m implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BotNickNameEditDialog f296583a;

    public m(BotNickNameEditDialog r100) {
        this.f296583a = r100;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
        if (r101 != 6) goto L16;
        FLogger r103 = FLogger.f375446a;
        int r104 = BotNickNameEditDialog.f296558n;
        r103.d("BotNickNameEditDialog", "onEditorAction : IME_ACTION_DONE");
        LarusDialogNicknameInputBottomBinding r105 = this.f296583a.f296559d;
        LarusDialogNicknameInputBottomBinding r106 = null;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r105 = null;
    L8:
        if (r105.f310857d.isEnabled() == false) goto L18;
        BotNickNameEditDialog r107 = this.f296583a;
        LarusDialogNicknameInputBottomBinding r108 = r107.f296559d;
        if (r108 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L13:
        r107.W90(r106.f310858e.getText().toString());
        return true;
    L12:
        r106 = r108;
        goto L13
    L18:
        return true;
    L16:
        return false;
    }
}
