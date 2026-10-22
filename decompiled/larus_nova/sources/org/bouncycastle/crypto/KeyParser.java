package org.bouncycastle.crypto;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: classes42.dex */
public interface KeyParser {
    AsymmetricKeyParameter readKey(InputStream r100) throws IOException;
}
