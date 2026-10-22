package com.bytedance.ee.bear.drive.biz.preview.block;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes16.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/block/DriveBlockFailedType;", "", "Companion", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface DriveBlockFailedType {
    public static final a Companion = null;
    public static final int TYPE_DENIED_PERMISSION = 4;
    public static final int TYPE_FAILED_TO_RETRY = 3;
    public static final int TYPE_FILE_NOT_FOUND = 5;
    public static final int TYPE_FILE_SIZE_ERROR = 2;
    public static final int TYPE_NOT_SUPPORT = 1;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f223237a = null;

        static {
            f223237a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f223237a;
    }
}
