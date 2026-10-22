package com.ss.android.lark.locationmessage.ui.navigation;

import android.content.Context;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.mvp.IModel;
import com.ss.android.lark.location.dto.Scene;

/* JADX INFO: loaded from: classes36.dex */
public interface b extends IModel {
    void S(Context r100, Token r101, Scene r102, u r103);

    boolean isAdminGpsEnabled();
}
