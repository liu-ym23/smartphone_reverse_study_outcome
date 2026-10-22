package com.larus.drive.sdk.impl.gallery.datasource;

import com.larus.bmhome.bigimg.m1;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.impl.service.t;
import com.larus.gallery.api.GalleryType;
import e89.d;
import java.util.List;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.text.StringsKt;
import nr9.f;
import nr9.g;
import z79.c;

/* JADX INFO: loaded from: classes27.dex */
public final class DriveDataSourceHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DriveDataSourceHelper f341800a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f341801a = null;

        static {
            int[] r100 = new int[DriveFileType.values().length];
            r100[DriveFileType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[DriveFileType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f341801a = r100;
        }
    }

    static {
        f341800a = new DriveDataSourceHelper();
    }

    public DriveDataSourceHelper() {
    }

    public final Object a(DriveFileItem r210, Continuation<? super c> r211) {
        DriveFileItem r100 = r210;
        if ((r211 instanceof DriveDataSourceHelper$convertToGalleryData$1) == false) goto L7;
        DriveDataSourceHelper$convertToGalleryData$1 r101 = (DriveDataSourceHelper$convertToGalleryData$1) r211;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = true;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        d r107 = (d) r101.L$1;
        DriveFileItem r108 = (DriveFileItem) r101.L$0;
        ResultKt.throwOnFailure(r103);
        d r109 = r107;
        r100 = r108;
        Object r110 = r103;
    L23:
        String r111 = (String) r110;
        String r112 = r109.f(r100.f341565b, 360, 360);
        if (r111 != null) goto L26;
    L29:
        if (r106 == false) goto L31;
        DriveFileItem r113 = r100;
    L51:
        return new c(r113, null, new g(null, null, r111, null, null, null, new f(r112, r112, null, null, null, null, 60), null, null, null, 955), GalleryType.Video, r100.f341565b, 2);
    L31:
        r113 = DriveFileItem.a(r100, null, r111, null, 4079);
        goto L51
    L26:
        if (StringsKt.isBlank(r111) == true) goto L29;
        r106 = false;
        goto L29
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        d r114 = (d) r101.L$1;
        DriveFileItem r115 = (DriveFileItem) r101.L$0;
        ResultKt.throwOnFailure(r103);
        r109 = r114;
        r100 = r115;
        Object r116 = r103;
    L36:
        String r117 = (String) r116;
        String r118 = r109.f(r100.f341565b, 120, 120);
        if (r117 != null) goto L39;
    L42:
        if (r106 == false) goto L44;
        DriveFileItem r119 = r100;
    L45:
        String r120 = r119.f341568e;
        if (r118 != null) goto L48;
        String r121 = r120;
    L50:
        return new c(r119, new m1(r120, r121, r120, null, null, null, 56), null, GalleryType.Image, r100.f341565b, 4);
    L48:
        r121 = r118;
        goto L50
    L44:
        r119 = DriveFileItem.a(r100, null, r117, null, 4079);
        goto L45
    L39:
        if (StringsKt.isBlank(r117) == true) goto L42;
        r106 = false;
        goto L42
    L16:
        ResultKt.throwOnFailure(r103);
        r109 = t.b();
        DriveFileType r122 = r100.f341573j;
        int r123 = a.f341801a[r122.ordinal()];
        if (r123 == 1) goto L33;
        if (r123 != 2) goto L52;
        String r124 = r100.f341565b;
        r101.L$0 = r100;
        r101.L$1 = r109;
        r101.label = 2;
        r110 = r109.b(r124, r101);
        if (r110 != r104) goto L23;
        return r104;
    L52:
        return null;
    L33:
        String r125 = r100.f341565b;
        r101.L$0 = r100;
        r101.L$1 = r109;
        r101.label = 1;
        r116 = r109.e(r125, r101);
        if (r116 != r104) goto L36;
        return r104;
    L7:
        r101 = new DriveDataSourceHelper$convertToGalleryData$1(this, r211);
        goto L8
    }

    public final Object b(DriveFileItem r100, Continuation<? super List<c>> r101) {
        if ((r101 instanceof DriveDataSourceHelper$transformDriveFileToGalleryData$1) == false) goto L7;
        DriveDataSourceHelper$transformDriveFileToGalleryData$1 r102 = (DriveDataSourceHelper$transformDriveFileToGalleryData$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L22:
        return CollectionsKt.listOfNotNull(r104);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        if (r100 == null) goto L17;
        r102.label = 1;
        r104 = a(r100, r102);
        if (r104 != r105) goto L22;
        return r105;
    L17:
        return CollectionsKt.emptyList();
    L7:
        r102 = new DriveDataSourceHelper$transformDriveFileToGalleryData$1(this, r101);
        goto L8
    }
}
