package com.huawei.secure.android.common.webview;

import com.larus.dora.api.model.FlowDoraWifiScene;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public interface WebViewLoadCallBack {

    public static final enum ErrorCode extends Enum<ErrorCode> {
        private static final /* synthetic */ ErrorCode[] $VALUES = null;
        public static final ErrorCode HTTP_URL = null;
        public static final ErrorCode OTHER = null;
        public static final ErrorCode URL_NOT_IN_WHITE_LIST = null;

        static {
            ErrorCode r100 = new ErrorCode("HTTP_URL", 0);
            HTTP_URL = r100;
            ErrorCode r101 = new ErrorCode("URL_NOT_IN_WHITE_LIST", 1);
            URL_NOT_IN_WHITE_LIST = r101;
            ErrorCode r102 = new ErrorCode(FlowDoraWifiScene.OTHER, 2);
            OTHER = r102;
            $VALUES = new ErrorCode[]{r100, r101, r102};
        }

        public static ErrorCode[] values() {
            return (ErrorCode[]) $VALUES.clone();
        }

        public static ErrorCode valueOf(String r100) {
            return (ErrorCode) a.a(ErrorCode.class, r100);
        }

        private ErrorCode(String r100, int r101) {
            super(r100, r101);
        }
    }

    void onCheckError(String r100, ErrorCode r101);
}
