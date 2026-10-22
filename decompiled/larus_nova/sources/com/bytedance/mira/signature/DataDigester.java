package com.bytedance.mira.signature;

import java.nio.ByteBuffer;
import java.security.DigestException;

/* JADX INFO: loaded from: classes21.dex */
interface DataDigester {
    void consume(ByteBuffer r100) throws DigestException;
}
