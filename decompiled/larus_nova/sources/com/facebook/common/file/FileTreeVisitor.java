package com.facebook.common.file;

import java.io.File;

/* JADX INFO: loaded from: classes22.dex */
public interface FileTreeVisitor {
    void postVisitDirectory(File r100);

    void preVisitDirectory(File r100);

    void visitFile(File r100);
}
