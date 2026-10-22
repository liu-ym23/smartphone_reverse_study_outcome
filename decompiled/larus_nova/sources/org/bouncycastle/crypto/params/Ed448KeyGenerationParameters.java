package org.bouncycastle.crypto.params;

import com.ss.bduploader.BDVideoUploaderBase;
import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

/* JADX INFO: loaded from: classes42.dex */
public class Ed448KeyGenerationParameters extends KeyGenerationParameters {
    public Ed448KeyGenerationParameters(SecureRandom r100) {
        super(r100, BDVideoUploaderBase.KeyIsDynamicSliceLowSize);
    }
}
