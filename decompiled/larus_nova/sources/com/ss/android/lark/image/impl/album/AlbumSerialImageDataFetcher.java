package com.ss.android.lark.image.impl.album;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.image.entity.AlbumSerialImage;
import com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.p;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import wkb.b;

/* JADX INFO: loaded from: classes36.dex */
public class AlbumSerialImageDataFetcher extends ResourceImageDataFetcher<AlbumSerialImage> {
    private final int height;
    private final int width;

    @Override // com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher
    public String getLogTag() {
        return "AlbumSerialImageDataFetcher";
    }

    private String getThumbPath(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "";
    L6:
        VFSFile r101 = VFSFiles.f444819b.i(r100);
        return b.a().getRealPath() + File.separator + r100.hashCode() + "_" + r101.lastModified() + "_" + (this.width + "*" + this.height) + ".jpg";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getResourceStream, reason: avoid collision after fix types in other method */
    public InputStream getResourceStream2(AlbumSerialImage r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        String r101 = r100.getPath();
        String r102 = getThumbPath(r101);     // Catch: Exception -> L11
        if (FileUtils.r(r102) == true) goto L9;
        p.i((Bitmap) Glide.with(LarkContext.getApplication()).asBitmap().load(r101).override(this.width, this.height).diskCacheStrategy(DiskCacheStrategy.RESOURCE).submit().get(), r102, Bitmap.CompressFormat.JPEG, 75);     // Catch: Exception -> L11
    L9:
        return VFSFiles.f444819b.k(r102);
    L11:
        e = move-exception;
        Log.e("AlbumSerialImageDataFetcher", "getResourceStream error: " + e.getMessage() + ", path: " + r101);
        return null;
    }

    @Override // com.ss.android.lark.image.impl.resource.ResourceImageDataFetcher
    public /* bridge */ /* synthetic */ InputStream getResourceStream(AlbumSerialImage r100) throws FileNotFoundException {
        return getResourceStream2(r100);
    }

    public AlbumSerialImageDataFetcher(AlbumSerialImage r100, int r101, int r102) {
        super(r100);
        this.width = r101;
        this.height = r102;
    }
}
