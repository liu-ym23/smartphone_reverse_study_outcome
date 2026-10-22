package com.larus.camera.impl.utils.album;

import android.content.Context;
import android.net.Uri;
import android.provider.MediaStore;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes26.dex */
public final class AlbumThumbListManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AlbumThumbListManager f322715a = null;

    static {
        f322715a = new AlbumThumbListManager();
    }

    public AlbumThumbListManager() {
    }

    public final Object b(Context r100, Continuation<? super Boolean> r101) {
        if ((r101 instanceof AlbumThumbListManager$hasAlbumImages$1) == false) goto L7;
        AlbumThumbListManager$hasAlbumImages$1 r102 = (AlbumThumbListManager$hasAlbumImages$1) r101;
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
    L18:
        return Boxing.boxBoolean(!((List) r104).isEmpty());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        r102.label = 1;
        r104 = a(r100, 1, null, null, r102);
        if (r104 != r105) goto L18;
        return r105;
    L7:
        r102 = new AlbumThumbListManager$hasAlbumImages$1(this, r101);
        goto L8
    }

    public static Object a(Context r110, int r111, Function2 r112, Function1 r113, Continuation r114) {
        ArrayList r100 = new ArrayList();
        String[] r101 = {DBDefinition.ID, "date_added"};
        Uri r102 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Ref.IntRef r103 = new Ref.IntRef();
        return BuildersKt.withContext(Dispatchers.getIO(), new AlbumThumbListManager$getAlbumImages$2(r102, r111, r110, r101, "date_added DESC", r100, r112, r113, r103, null), r114);
    }
}
