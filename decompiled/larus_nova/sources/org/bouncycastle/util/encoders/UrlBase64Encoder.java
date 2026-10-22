package org.bouncycastle.util.encoders;

/* JADX INFO: loaded from: classes42.dex */
public class UrlBase64Encoder extends Base64Encoder {
    public UrlBase64Encoder() {
        byte[] r100 = this.encodingTable;
        r100[r100.length - 2] = 45;
        r100[r100.length - 1] = 95;
        this.padding = 46;
        initialiseDecodingTable();
    }
}
