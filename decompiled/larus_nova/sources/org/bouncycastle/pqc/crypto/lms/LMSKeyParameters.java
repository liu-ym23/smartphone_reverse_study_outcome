package org.bouncycastle.pqc.crypto.lms;

import java.io.IOException;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.util.Encodable;

/* JADX INFO: loaded from: classes42.dex */
public abstract class LMSKeyParameters extends AsymmetricKeyParameter implements Encodable {
    public LMSKeyParameters(boolean r100) {
        super(r100);
    }

    public abstract byte[] getEncoded() throws IOException;
}
