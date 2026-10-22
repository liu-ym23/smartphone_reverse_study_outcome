package com.facebook.common.file;

import java.io.File;

/* JADX INFO: loaded from: classes22.dex */
public class FileTree {
    public FileTree() {
    }

    public static boolean deleteContents(File r100) {
        File[] r101 = r100.listFiles();
        boolean r102 = true;
        if (r101 == null) goto L7;
        int r103 = r101.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L7;
        r102 = r102 & deleteRecursively(r101[r104]);
        r104 = r104 + 1;
    L7:
        return r102;
    }

    public static boolean deleteRecursively(File r100) {
        if (r100.isDirectory() == false) goto L6;
        deleteContents(r100);
    L6:
        return r100.delete();
    }

    public static void walkFileTree(File r100, FileTreeVisitor r101) {
        r101.preVisitDirectory(r100);
        File[] r102 = r100.listFiles();
        if (r102 == null) goto L11;
        int r103 = r102.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L11;
        File r105 = r102[r104];
        if (r105.isDirectory() == false) goto L9;
        walkFileTree(r105, r101);
    L10:
        r104 = r104 + 1;
        goto L5
    L9:
        r101.visitFile(r105);
    L11:
        r101.postVisitDirectory(r100);
    }
}
