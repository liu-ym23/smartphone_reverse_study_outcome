package com.ss.android.bytedcert.config;

import android.app.Activity;
import android.os.Bundle;

/* JADX INFO: loaded from: classes34.dex */
public interface ICnNetIdService {

    public interface Callback {
        void onResult(boolean r100, Bundle r101);
    }

    public interface Key {
        public static final String AUTH_TYPE = "authType";
        public static final String BIZ_SEQ = "bizSeq";
        public static final String CERT_PWD_DATA = "certPwdData";
        public static final String EXTRAS = "extrasData";
        public static final String ID_CARD_AUTH_DATA = "idCardAuthData";
        public static final String RESULT_CODE = "resultCode";
        public static final String RESULT_DESC = "resultDesc";
    }

    public interface ResultCode {
        public static final String CANCEL = "C0412003";
        public static final String UNINSTALL = "C0412002";
    }

    void startAuth(Activity r100, String r101, String r102, int r103, Callback r104);
}
