package org.apache.commons.compress.archivers.sevenz;

import java.util.HashMap;
import org.tukaani.xz.ARMOptions;
import org.tukaani.xz.ARMThumbOptions;
import org.tukaani.xz.IA64Options;
import org.tukaani.xz.PowerPCOptions;
import org.tukaani.xz.SPARCOptions;
import org.tukaani.xz.X86Options;

/* JADX INFO: loaded from: classes42.dex */
final class Coders$1 extends HashMap<SevenZMethod, CoderBase> {
    private static final long serialVersionUID = 1664829131806520867L;

    public Coders$1() {
        put(SevenZMethod.COPY, new Coders$CopyDecoder());
        put(SevenZMethod.LZMA, new LZMADecoder());
        put(SevenZMethod.LZMA2, new LZMA2Decoder());
        put(SevenZMethod.DEFLATE, new Coders$DeflateDecoder());
        put(SevenZMethod.DEFLATE64, new Coders$Deflate64Decoder());
        put(SevenZMethod.BZIP2, new Coders$BZIP2Decoder());
        put(SevenZMethod.AES256SHA256, new AES256SHA256Decoder());
        SevenZMethod r100 = SevenZMethod.BCJ_X86_FILTER;
        final X86Options r101 = new X86Options();
        put(r100, new Coders$BCJDecoder(r101));
        SevenZMethod r102 = SevenZMethod.BCJ_PPC_FILTER;
        final PowerPCOptions r103 = new PowerPCOptions();
        put(r102, new Coders$BCJDecoder(r103));
        SevenZMethod r104 = SevenZMethod.BCJ_IA64_FILTER;
        final IA64Options r105 = new IA64Options();
        put(r104, new Coders$BCJDecoder(r105));
        SevenZMethod r106 = SevenZMethod.BCJ_ARM_FILTER;
        final ARMOptions r107 = new ARMOptions();
        put(r106, new Coders$BCJDecoder(r107));
        SevenZMethod r108 = SevenZMethod.BCJ_ARM_THUMB_FILTER;
        final ARMThumbOptions r109 = new ARMThumbOptions();
        put(r108, new Coders$BCJDecoder(r109));
        SevenZMethod r110 = SevenZMethod.BCJ_SPARC_FILTER;
        final SPARCOptions r111 = new SPARCOptions();
        put(r110, new Coders$BCJDecoder(r111));
        put(SevenZMethod.DELTA_FILTER, new DeltaDecoder());
    }
}
