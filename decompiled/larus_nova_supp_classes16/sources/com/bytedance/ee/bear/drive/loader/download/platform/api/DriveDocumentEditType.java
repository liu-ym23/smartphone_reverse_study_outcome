package com.bytedance.ee.bear.drive.loader.download.platform.api;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/api/DriveDocumentEditType;", "", "<init>", "()V", "Companion", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveDocumentEditType {
    public static final Companion Companion = null;
    public static final int EDIT_TYPE_PROCESSING = 0;
    public static final int EDIT_TYPE_SHEET_OR_SLIDES = 2;
    public static final int EDIT_TYPE_UNKNOWN = 3;
    public static final int EDIT_TYPE_WPS = 1;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\u0010\fJ\u0017\u0010\u000e\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/drive/loader/download/platform/api/DriveDocumentEditType$Companion;", "", "<init>", "()V", "EDIT_TYPE_PROCESSING", "", "EDIT_TYPE_WPS", "EDIT_TYPE_SHEET_OR_SLIDES", "EDIT_TYPE_UNKNOWN", "isTypeNeedTrain", "", "editType", "(Ljava/lang/Integer;)Z", "isTypeUseSheetOrSlides", "isTypeUseWpsOnlyRead", "isTypeUseWpsCanWrite", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final boolean isTypeNeedTrain(Integer r1) {
            if (r1 != null) goto L5;
        L7:
            return false;
        L5:
            if (r1.intValue() != 0) goto L7;
            return true;
        }

        @JvmStatic
        public final boolean isTypeUseSheetOrSlides(Integer r2) {
            if (r2 != null) goto L5;
        L7:
            return false;
        L5:
            if (r2.intValue() != 2) goto L7;
            return true;
        }

        @JvmStatic
        public final boolean isTypeUseWpsCanWrite(Integer r2) {
            if (r2 != null) goto L5;
        L7:
            return false;
        L5:
            if (r2.intValue() != 1) goto L7;
            return true;
        }

        @JvmStatic
        public final boolean isTypeUseWpsOnlyRead(Integer r2) {
            if (r2 != null) goto L5;
        L7:
            return false;
        L5:
            if (r2.intValue() != 3) goto L7;
            return true;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public DriveDocumentEditType() {
    }

    @JvmStatic
    public static final boolean isTypeNeedTrain(Integer r1) {
        return Companion.isTypeNeedTrain(r1);
    }

    @JvmStatic
    public static final boolean isTypeUseSheetOrSlides(Integer r1) {
        return Companion.isTypeUseSheetOrSlides(r1);
    }

    @JvmStatic
    public static final boolean isTypeUseWpsCanWrite(Integer r1) {
        return Companion.isTypeUseWpsCanWrite(r1);
    }

    @JvmStatic
    public static final boolean isTypeUseWpsOnlyRead(Integer r1) {
        return Companion.isTypeUseWpsOnlyRead(r1);
    }
}
