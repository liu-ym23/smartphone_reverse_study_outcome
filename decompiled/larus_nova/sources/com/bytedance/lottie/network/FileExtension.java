package com.bytedance.lottie.network;

import com.bytedance.lottie.c;
import com.ss.android.lark.inv.export.router.InvRouter;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
public final enum FileExtension extends Enum<FileExtension> {
    public static final FileExtension Json = null;
    public static final FileExtension Zip = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FileExtension[] f264577a = null;
    public final String extension;

    static {
        FileExtension r100 = new FileExtension("Json", 0, InvRouter.FLOW_SUFFIX);
        Json = r100;
        FileExtension r101 = new FileExtension("Zip", 1, ".zip");
        Zip = r101;
        f264577a = new FileExtension[]{r100, r101};
    }

    public static FileExtension[] values() {
        return (FileExtension[]) f264577a.clone();
    }

    public String tempExtension() {
        return ".temp" + this.extension;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.extension;
    }

    public static FileExtension forFile(String r100) {
        FileExtension[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        FileExtension r104 = r101[r103];
        if (r100.endsWith(r104.extension) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        c.b("Unable to find correct extension for " + r100);
        return Json;
    }

    public static FileExtension valueOf(String r100) {
        return (FileExtension) a.a(FileExtension.class, r100);
    }

    public FileExtension(String r100, int r101, String r102) {
        super(r100, r101);
        this.extension = r102;
    }
}
