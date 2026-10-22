package com.ttnet.org.chromium.net;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.io.File;
import java.io.FileFilter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes41.dex */
public class MimeTypeFilter implements FileFilter {
    private boolean mAcceptAllMimeTypes;
    private boolean mAcceptDirectory;
    private HashSet<String> mExtensions;
    private HashSet<String> mMimeSupertypes;
    private MimeTypeMap mMimeTypeMap;
    private HashSet<String> mMimeTypes;

    private static String getMimeSupertype(String r100) {
        return r100.split(HTTP.URL_DEFAULT, 2)[0];
    }

    private String getMimeTypeFromExtension(String r100) {
        String r101 = this.mMimeTypeMap.getMimeTypeFromExtension(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.toLowerCase(Locale.US);
    }

    @Override // java.io.FileFilter
    public boolean accept(File r100) {
        if (r100.isDirectory() == false) goto L7;
        return this.mAcceptDirectory;
    L7:
        return accept(Uri.fromFile(r100), null);
    }

    public MimeTypeFilter(List<String> r100, boolean r101) {
        this.mExtensions = new HashSet();
        this.mMimeTypes = new HashSet();
        this.mMimeSupertypes = new HashSet();
        Iterator<String> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L17;
        String r103 = r102.next().trim().toLowerCase(Locale.US);
        if (r103.startsWith(".") == true) goto L7;
        if (r103.equals("*/*") == true) goto L10;
        if (r103.endsWith("/*") == true) goto L13;
        if (r103.contains(HTTP.URL_DEFAULT) == false) goto L4;
        this.mMimeTypes.add(r103);
        goto L4
    L13:
        this.mMimeSupertypes.add(r103.substring(0, r103.length() - 2));
        goto L4
    L10:
        this.mAcceptAllMimeTypes = true;
        goto L4
    L7:
        this.mExtensions.add(r103.substring(1));
        goto L4
    L17:
        this.mMimeTypeMap = MimeTypeMap.getSingleton();
        this.mAcceptDirectory = r101;
    }

    public boolean accept(Uri r100, String r101) {
        if (r100 == null) goto L9;
        String r102 = MimeTypeMap.getFileExtensionFromUrl(r100.toString()).toLowerCase(Locale.US);
        if (this.mExtensions.contains(r102) == false) goto L7;
        return true;
    L7:
        if (r101 != null) goto L9;
        r101 = getMimeTypeFromExtension(r102);
    L9:
        if (r101 != null) goto L11;
        return false;
    L11:
        if (this.mAcceptAllMimeTypes == false) goto L13;
    L16:
        return true;
    L13:
        if (this.mMimeTypes.contains(r101) == true) goto L16;
        if (this.mMimeSupertypes.contains(getMimeSupertype(r101)) == true) goto L16;
        return false;
    }
}
