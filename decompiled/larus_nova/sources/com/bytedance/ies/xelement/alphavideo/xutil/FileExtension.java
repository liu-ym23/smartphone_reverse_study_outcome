package com.bytedance.ies.xelement.alphavideo.xutil;

import com.ss.android.lark.inv.export.router.InvRouter;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final enum FileExtension extends Enum<FileExtension> {
    public static final FileExtension Json = null;
    public static final FileExtension Zip = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FileExtension[] f249732a = null;
    public final String extension;

    static {
        FileExtension r100 = new FileExtension("Json", 0, InvRouter.FLOW_SUFFIX);
        Json = r100;
        FileExtension r101 = new FileExtension("Zip", 1, ".zip");
        Zip = r101;
        f249732a = new FileExtension[]{r100, r101};
    }

    public static FileExtension[] values() {
        return (FileExtension[]) f249732a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.extension;
    }

    public static FileExtension valueOf(String r100) {
        return (FileExtension) a.a(FileExtension.class, r100);
    }

    public FileExtension(String r100, int r101, String r102) {
        super(r100, r101);
        this.extension = r102;
    }
}
