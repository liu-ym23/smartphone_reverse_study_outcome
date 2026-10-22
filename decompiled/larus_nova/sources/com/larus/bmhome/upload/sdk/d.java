package com.larus.bmhome.upload.sdk;

import com.larus.platform.model.upload.UploadDataType;

/* JADX INFO: loaded from: classes26.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f314831a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f314832a = null;

        static {
            int[] r100 = new int[UploadDataType.values().length];
            r100[UploadDataType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[UploadDataType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[UploadDataType.FILE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[UploadDataType.UNCLEAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f314832a = r100;
        }
    }

    static {
    }
}
