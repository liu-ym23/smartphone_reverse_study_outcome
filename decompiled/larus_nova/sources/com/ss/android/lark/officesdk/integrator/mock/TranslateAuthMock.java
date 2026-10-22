package com.ss.android.lark.officesdk.integrator.mock;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import rua.a;

/* JADX INFO: loaded from: classes37.dex */
@ClaymoreImpl(a.class)
public class TranslateAuthMock implements a {
    private static final String TAG = "OfficeSdkMock";

    public TranslateAuthMock() {
    }

    public boolean isHyperTranslateEnable() {
        return false;
    }

    @Override // rua.a
    public boolean isImageTranslateEnable() {
        return false;
    }

    public boolean isMessageTranslateEnable() {
        return false;
    }

    public boolean isTranslateSettingEnable() {
        return false;
    }
}
