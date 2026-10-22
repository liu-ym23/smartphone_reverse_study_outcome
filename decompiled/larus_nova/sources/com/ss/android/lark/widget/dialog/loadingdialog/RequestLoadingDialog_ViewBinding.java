package com.ss.android.lark.widget.dialog.loadingdialog;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes38.dex */
public class RequestLoadingDialog_ViewBinding implements Unbinder {
    @Override // butterknife.Unbinder
    public final void unbind() {
        throw new IllegalStateException("Bindings already cleared.");
    }

    public RequestLoadingDialog_ViewBinding(RequestLoadingDialog r100, View r101) {
        r100.f445805a = (ImageView) Utils.findRequiredViewAsType(r101, R.id.img_bot_reply, "field 'imgBotReply'", ImageView.class);
        r100.f445806b = (ImageView) Utils.findRequiredViewAsType(r101, R.id.img_bot_replying, "field 'imgBotReplying'", ImageView.class);
        r100.f445807c = (TextView) Utils.findRequiredViewAsType(r101, R.id.text_bot_reply, "field 'replyText'", TextView.class);
    }
}
