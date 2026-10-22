package com.ss.android.lark.locationmessage.ui.navigation;

import android.content.Context;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.mvp.IView;
import com.ss.android.lark.location.dto.Scene;

/* JADX INFO: loaded from: classes36.dex */
public interface c extends IView.IViewDelegate {
    void S(Context r100, Token r101, Scene r102, u r103);

    boolean isAdminGpsEnabled();
}
