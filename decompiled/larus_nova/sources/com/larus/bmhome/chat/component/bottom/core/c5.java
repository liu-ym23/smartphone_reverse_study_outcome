package com.larus.bmhome.chat.component.bottom.core;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import com.larus.input.impl.databinding.LarusWidgetInputBinding;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class c5 implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EditText f298459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CoreInputComponent f298460b;

    public /* synthetic */ c5(EditText r100, CoreInputComponent r101, LarusWidgetInputBinding r102) {
        this.f298459a = r100;
        this.f298460b = r101;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
        EditText r103 = this.f298459a;
        CoreInputComponent r104 = this.f298460b;
        int r105 = CoreInputComponent.f298338d3;
        if (r101 != 4) goto L5;
        FLogger.f375446a.i("CoreInputComponent", "actionId == EditorInfo.IME_ACTION_SEND， text=" + r103.getText());
        r104.x5();
        return true;
    L5:
        return false;
    }
}
