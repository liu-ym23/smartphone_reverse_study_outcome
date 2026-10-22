package com.ss.android.lark.forwardv3.forward.mediaforward;

import com.ss.android.lark.forwardv3.configuration.ConvertShareParamsHandler;
import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes36.dex */
@ConvertShareParamsHandler
public final class c implements com.ss.android.lark.forwardv3.configuration.h<MediaForwardContent> {
    public c() {
    }

    @Override // com.ss.android.lark.forwardv3.configuration.h, com.ss.android.lark.forwardv3.configuration.a
    public int getType() {
        return 7;
    }

    @Override // com.ss.android.lark.forwardv3.configuration.h
    public final Object b(IForwardContent r100) {
        MediaForwardContent r101 = (MediaForwardContent) r100;
        if (r101 != null) goto L5;
        return null;
    L5:
        ArrayList r102 = new ArrayList();
        r102.add(new pib.c(r101.f425369d, r101.f425366a, r101.f425368c));
        return r102;
    }
}
