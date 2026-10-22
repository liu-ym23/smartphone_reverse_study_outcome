package com.bytedance.mira.signature;

import java.io.IOException;
import java.security.DigestException;

/* JADX INFO: loaded from: classes21.dex */
interface DataSource {
    void feedIntoDataDigester(DataDigester r100, long r101, int r102) throws IOException, DigestException;

    long size();
}
