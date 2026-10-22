package com.ss.android.lark.officesdk.qrcode.api;

import android.content.Context;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes37.dex */
public interface IQRCodeResultHandler {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/officesdk/qrcode/api/IQRCodeResultHandler$QrCodeSource;", "", "Companion", "qrcode-officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface QrCodeSource {
        public static final a Companion = null;
        public static final int PARSE_CODE = 2;
        public static final int PHOTO_CAMERA = 3;
        public static final int SCAN = 1;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f437159a = null;

            static {
                f437159a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f437159a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/officesdk/qrcode/api/IQRCodeResultHandler$ScanFormat;", "", "Companion", "qrcode-officesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ScanFormat {
        public static final int BARCODE = 1;
        public static final a Companion = null;
        public static final int QRCODE = 0;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f437160a = null;

            static {
                f437160a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f437160a;
        }
    }

    boolean a(String r100, Context r101);
}
