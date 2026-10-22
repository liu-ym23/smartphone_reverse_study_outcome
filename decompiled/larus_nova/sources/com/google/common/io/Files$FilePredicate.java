package com.google.common.io;

import com.google.common.base.n;
import java.io.File;

/* JADX INFO: loaded from: classes23.dex */
abstract enum Files$FilePredicate extends Enum<Files$FilePredicate> implements n<File> {
    public static final Files$FilePredicate IS_DIRECTORY = null;
    public static final Files$FilePredicate IS_FILE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Files$FilePredicate[] f275621a = null;

    public Files$FilePredicate() {
        throw null;
    }

    @Override // com.google.common.base.n
    public abstract /* synthetic */ boolean apply(@com.google.common.base.ParametricNullness File r100);

    static {
        final String r100 = "IS_DIRECTORY";
        final int r101 = 0;
        Files$FilePredicate r102 = new AnonymousClass1(r100, r101);
        IS_DIRECTORY = r102;
        final String r103 = "IS_FILE";
        final int r104 = 1;
        Files$FilePredicate r105 = new AnonymousClass2(r103, r104);
        IS_FILE = r105;
        f275621a = new Files$FilePredicate[]{r102, r105};
    }

    public static Files$FilePredicate[] values() {
        return (Files$FilePredicate[]) f275621a.clone();
    }

    public static Files$FilePredicate valueOf(String r100) {
        return (Files$FilePredicate) r27.a.a(Files$FilePredicate.class, r100);
    }

    public Files$FilePredicate(String r100, int r101, a r102) {
        super(r100, r101);
    }
}
