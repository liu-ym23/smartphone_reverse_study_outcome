package com.ss.android.lark.vfs;

import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\"J\u0017\u0010\u0003\u001a\u0002H\u0004\"\b\b\u0000\u0010\u0004*\u00020\u0005H&¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0000H&J\u0010\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rH&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0000H&J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0000H&J\b\u0010\u0011\u001a\u00020\rH&J\b\u0010\u0012\u001a\u00020\rH&J\b\u0010\u0013\u001a\u00020\rH&J\b\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0016\u001a\u00020\u0017H&J\u001d\u0010\u0018\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0019\u001a\u00020\rH&¢\u0006\u0002\u0010\u001aJ\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eH&J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!H&¨\u0006#"}, d2 = {"Lcom/ss/android/lark/vfs/VFSPath;", "Ljava/io/Serializable;", "", "getSchemeFileSystem", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/ss/android/lark/vfs/FileSystem;", "()Lcom/ss/android/lark/vfs/FileSystem;", "getFileSystem", "isRoot", "", "getRoot", "subPath", "name", "", "getParent", "isParentOf", "path", "getRealPath", "getAbsolutePath", "getName", "toUri", "Landroid/net/Uri;", "toFile", "Lcom/ss/android/lark/vfs/VFSFile;", "getTag", "key", "(Ljava/lang/String;)Ljava/lang/Object;", "setTag", "", "tagObj", "", "setPathTransformer", "pathTransformer", "Lcom/ss/android/lark/vfs/VFSPath$FinalPathTransformer;", "FinalPathTransformer", "unistore_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface VFSPath extends Serializable, Comparable<VFSPath> {

    public interface a {
        String transform(String r100);
    }

    String getAbsolutePath();

    FileSystem getFileSystem();

    String getName();

    VFSPath getParent();

    String getRealPath();

    VFSPath getRoot();

    <T extends FileSystem> T getSchemeFileSystem();

    <T> T getTag(String r100);

    boolean isParentOf(VFSPath r100);

    boolean isRoot();

    void setPathTransformer(a r100);

    void setTag(String r100, Object r101);

    VFSPath subPath(String r100);

    VFSFile toFile();

    Uri toUri();
}
