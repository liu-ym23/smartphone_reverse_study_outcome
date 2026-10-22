package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import f06.b;
import f06.c;
import f06.d;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class LocalContentUriFetchProducer extends LocalFetchProducer {
    public static final String PRODUCER_NAME = "LocalContentUriFetchProducer";
    private static final String[] PROJECTION = null;
    private final ContentResolver mContentResolver;

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public String getProducerName() {
        return PRODUCER_NAME;
    }

    static {
        PROJECTION = new String[]{DBDefinition.ID, "_data"};
    }

    @Nullable
    private EncodedImage getCameraImage(Uri r100) throws IOException {
        Cursor r101 = com_facebook_imagepipeline_producers_LocalContentUriFetchProducer_android_content_ContentResolver_query(this.mContentResolver, r100, PROJECTION, null, null, null);
        if (r101 != null) goto L21;
        return null;
    L21:
    L19:
        r101.close();
        return null;
    L16:
        th = move-exception;
        r101.close();
        throw th;
    L6:
        if (r101.getCount() != 0) goto L9;
        r101.close();
        return null;
    L9:
        r101.moveToFirst();     // Catch: Throwable -> L16 FileNotFoundException -> L19
        String r102 = r101.getString(r101.getColumnIndex("_data"));     // Catch: Throwable -> L16 FileNotFoundException -> L19
        if (r102 == null) goto L14;
        EncodedImage r103 = getEncodedImage(new PolarisFileInputStreamWrapper(r102), getLength(r102));     // Catch: Throwable -> L16 FileNotFoundException -> L19
        r101.close();
        return r103;
    L14:
        r101.close();
        return null;
    }

    private static int getLength(String r100) {
        if (r100 != null) goto L5;
        return -1;
    L5:
        return (int) new PolarisFileWrapper(r100).length();
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public EncodedImage getEncodedImage(ImageRequest r100) throws IOException {
        Uri r101 = r100.getSourceUri();
        int r102 = -1;
        if (UriUtil.isLocalContactUri(r101) == false) goto L21;
        if (r101.toString().endsWith("/photo") == false) goto L8;
        InputStream r103 = ContentResolverWrapper.openInputStream(this.mContentResolver, r101);
    L17:
        return getEncodedImage(r103, -1);
    L8:
        if (r101.toString().endsWith("/display_photo") == true) goto L34;
        InputStream r104 = ContactsContract.Contacts.openContactPhotoInputStream(this.mContentResolver, r101);
        if (r104 == null) goto L19;
        r103 = r104;
        goto L17
    L19:
        throw new IOException("Contact photo does not exist: " + r101);
    L34:
        r103 = ContentResolverWrapper.openAssetFileDescriptor(this.mContentResolver, r101, "r").createInputStream();     // Catch: IOException -> L11
    L12:
        throw new IOException("Contact photo does not exist: " + r101);
    L21:
        if (UriUtil.isLocalCameraUri(r101) == false) goto L26;
        EncodedImage r105 = getCameraImage(r101);
        if (r105 == null) goto L26;
        return r105;
    L26:
        if (FrescoCacheMonitorUtil.isEnableFileProviderOpt() == false) goto L33;
        InputStream r106 = ContentResolverWrapper.openInputStream(this.mContentResolver, r101);
        if (r106.available() <= 0) goto L31;
        r102 = r106.available();
    L31:
        return getEncodedImage(r106, r102);
    L33:
        return getEncodedImage(ContentResolverWrapper.openInputStream(this.mContentResolver, r101), -1);
    }

    public LocalContentUriFetchProducer(Executor r100, PooledByteBufferFactory r101, ContentResolver r102) {
        super(r100, r101);
        this.mContentResolver = r102;
    }

    private static Cursor com_facebook_imagepipeline_producers_LocalContentUriFetchProducer_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) throws IOException {
        c r100 = new c();
        Object[] r101 = {r111, r112, r113, r114, r115};
        b r116 = new b();
        d r117 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r116);
        if (r117.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r116, false);
        return (Cursor) r117.f474983b;
    L6:
        Cursor r118 = r110.query(r111, r112, r113, r114, r115);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r118, r116, true);
        return r118;
    }
}
