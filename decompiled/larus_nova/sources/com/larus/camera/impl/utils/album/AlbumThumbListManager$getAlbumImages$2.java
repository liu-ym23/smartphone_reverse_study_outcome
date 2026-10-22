package com.larus.camera.impl.utils.album;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Landroid/net/Uri;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.utils.album.AlbumThumbListManager$getAlbumImages$2", f = "AlbumThumbListManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AlbumThumbListManager$getAlbumImages$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<Uri>>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ List<Uri> $imageUris;
    final /* synthetic */ Ref.IntRef $index;
    final /* synthetic */ int $internalLimit;
    final /* synthetic */ Function1<Exception, Unit> $onError;
    final /* synthetic */ Function2<List<? extends Uri>, Integer, Unit> $onSuccess;
    final /* synthetic */ String[] $projection;
    final /* synthetic */ String $sortOrder;
    final /* synthetic */ Uri $uri;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AlbumThumbListManager$getAlbumImages$2(Uri r100, int r101, Context r102, String[] r103, String r104, List<Uri> r105, Function2<? super List<? extends Uri>, ? super Integer, Unit> r106, Function1<? super Exception, Unit> r107, Ref.IntRef r108, Continuation<? super AlbumThumbListManager$getAlbumImages$2> r110) {
        this.$uri = r100;
        this.$internalLimit = r101;
        this.$context = r102;
        this.$projection = r103;
        this.$sortOrder = r104;
        this.$imageUris = r105;
        this.$onSuccess = r106;
        this.$onError = r107;
        this.$index = r108;
        super(2, r110);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r110, Continuation<?> r111) {
        return new AlbumThumbListManager$getAlbumImages$2(this.$uri, this.$internalLimit, this.$context, this.$projection, this.$sortOrder, this.$imageUris, this.$onSuccess, this.$onError, this.$index, r111);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super List<Uri>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super List<Uri>> r101) {
        return ((AlbumThumbListManager$getAlbumImages$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L53;
        ResultKt.throwOnFailure(r110);
        Ref.IntRef r111 = new Ref.IntRef();     // Catch: Exception -> L46
        if (Build.VERSION.SDK_INT < 26) goto L25;
        FLogger.f375446a.i("BotUtils", "getAlbumImages SDK_INT>0");     // Catch: Exception -> L46
        Bundle r100 = new Bundle();     // Catch: Exception -> L46
        r100.putInt("android:query-arg-limit", this.$internalLimit);     // Catch: Exception -> L46
        r100.putStringArray("android:query-arg-sort-columns", new String[]{"date_added"});     // Catch: Exception -> L46
        r100.putInt("android:query-arg-sort-direction", 1);     // Catch: Exception -> L46
        Cursor r101 = a(this.$context.getContentResolver(), this.$uri.buildUpon().appendQueryParameter(VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, String.valueOf(this.$internalLimit)).build(), this.$projection, r100);     // Catch: Exception -> L46
        if (r101 == null) goto L42;
        Cursor r102 = r101;     // Catch: Exception -> L46
        Ref.IntRef r103 = this.$index;     // Catch: Exception -> L46
        int r104 = this.$internalLimit;     // Catch: Exception -> L46
        List<Uri> r105 = this.$imageUris;     // Catch: Exception -> L46
        Cursor r106 = r102;     // Catch: Throwable -> L20
        r111.element = r106.getCount();     // Catch: Throwable -> L20
        int r107 = r106.getColumnIndexOrThrow(DBDefinition.ID);     // Catch: Throwable -> L20
    L13:
        if (r106.moveToNext() == false) goto L17;
        if (r103.element >= r104) goto L17;
        r105.add(ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, r106.getLong(r107)));     // Catch: Throwable -> L20
        r103.element++;     // Catch: Throwable -> L20
    L17:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L20
        CloseableKt.closeFinally(r102, null);     // Catch: Exception -> L46
        goto L42
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.closeFinally(r102, th);     // Catch: Exception -> L46
        throw th;     // Catch: Exception -> L46
    L42:
        FLogger.f375446a.i("BotUtils", "getAlbumImages success size=" + this.$imageUris.size());     // Catch: Exception -> L46
        Function2<List<? extends Uri>, Integer, Unit> r109 = this.$onSuccess;     // Catch: Exception -> L46
        if (r109 == null) goto L51;
        r109.invoke(this.$imageUris, Boxing.boxInt(r111.element));     // Catch: Exception -> L46
    L51:
        return this.$imageUris;
    L25:
        FLogger.f375446a.i("BotUtils", "getAlbumImages SDK_INT<=0");     // Catch: Exception -> L46
        Cursor r112 = c(this.$context.getContentResolver(), this.$uri.buildUpon().appendQueryParameter(VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, String.valueOf(this.$internalLimit)).build(), this.$projection, this.$sortOrder);     // Catch: Exception -> L46
        if (r112 == null) goto L42;
        Cursor r113 = r112;     // Catch: Exception -> L46
        Ref.IntRef r114 = this.$index;     // Catch: Exception -> L46
        int r115 = this.$internalLimit;     // Catch: Exception -> L46
        List<Uri> r116 = this.$imageUris;     // Catch: Exception -> L46
        Cursor r117 = r113;     // Catch: Throwable -> L37
        r111.element = r117.getCount();     // Catch: Throwable -> L37
        int r118 = r117.getColumnIndexOrThrow(DBDefinition.ID);     // Catch: Throwable -> L37
    L30:
        if (r117.moveToNext() == false) goto L34;
        if (r114.element >= r115) goto L34;
        r116.add(ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, r117.getLong(r118)));     // Catch: Throwable -> L37
        r114.element++;     // Catch: Throwable -> L37
    L34:
        Unit r119 = Unit.INSTANCE;     // Catch: Throwable -> L37
        CloseableKt.closeFinally(r113, null);     // Catch: Exception -> L46
        goto L42
    L37:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        CloseableKt.closeFinally(r113, th);     // Catch: Exception -> L46
        throw th;     // Catch: Exception -> L46
    L46:
        e = move-exception;
        FLogger.f375446a.e("BotUtils", "getAlbumImages error msg=" + e.getMessage());
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e);
        Function1<Exception, Unit> r120 = this.$onError;
        if (r120 == null) goto L51;
        r120.invoke(e);
        goto L51
    L53:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public static Cursor a(ContentResolver r110, Uri r111, String[] r112, Bundle r113) {
        f06.c r114 = new f06.c();
        Object[] r115 = {r111, r112, r113, null};
        f06.b r116 = new f06.b();
        f06.d r100 = r114.b(240004, "android/content/ContentResolver", "query", r110, r115, "android.database.Cursor", r116);
        if (r100.f474982a == false) goto L6;
        r114.a(240004, "android/content/ContentResolver", "query", r110, r115, null, r116, false);
        return (Cursor) r100.f474983b;
    L6:
        Cursor r101 = r110.query(r111, r112, r113, null);
        r114.a(240004, "android/content/ContentResolver", "query", r110, r115, r101, r116, true);
        return r101;
    }

    public static Cursor c(ContentResolver r110, Uri r111, String[] r112, String r113) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, null, null, r113};
        f06.b r114 = new f06.b();
        f06.d r115 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r114);
        if (r115.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r114, false);
        return (Cursor) r115.f474983b;
    L6:
        Cursor r116 = r110.query(r111, r112, null, null, r113);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r116, r114, true);
        return r116;
    }
}
