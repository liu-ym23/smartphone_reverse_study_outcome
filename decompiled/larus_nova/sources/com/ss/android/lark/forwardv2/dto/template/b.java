package com.ss.android.lark.forwardv2.dto.template;

import android.content.Intent;
import android.os.Bundle;
import com.ss.android.lark.forwardv2.dto.ForwardTarget;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public interface b {

    public interface a {
        void a(String r100, String r101, boolean r102);

        void b(String r100, boolean r101);

        void onSuccess(int r100, Intent r101);
    }

    void a(List<ForwardTarget> r100, Bundle r101, a r102);
}
