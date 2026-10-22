package com.google.zxing.multi.qrcode;

import com.google.zxing.ResultMetadataType;
import com.google.zxing.c;
import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes23.dex */
final class QRCodeMultiReader$SAComparator implements Comparator<c>, Serializable {
    private QRCodeMultiReader$SAComparator() {
    }

    public /* synthetic */ QRCodeMultiReader$SAComparator(a r100) {
        this();
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(c r100, c r101) {
        return compare2(r100, r101);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(c r100, c r101) {
        r100.getClass();
        ResultMetadataType r102 = ResultMetadataType.STRUCTURED_APPEND_SEQUENCE;
        throw null;
    }
}
