package org.bouncycastle.util.test;

import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes42.dex */
public class TestRandomData extends FixedSecureRandom {
    public TestRandomData(String r100) {
        super(new FixedSecureRandom.Source[]{new FixedSecureRandom.Data(Hex.decode(r100))});
    }

    public TestRandomData(byte[] r100) {
        super(new FixedSecureRandom.Source[]{new FixedSecureRandom.Data(r100)});
    }
}
