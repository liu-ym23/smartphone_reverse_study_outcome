package com.bytedance.bdinstall;

import com.bytedance.frameworks.encryptor.EncryptorUtil;

/* JADX INFO: loaded from: classes3.dex */
public interface b0 {

    public static class a implements b0 {
        public a() {
        }

        @Override // com.bytedance.bdinstall.b0
        public final byte[] encrypt(byte[] r100, int r101) {
            return EncryptorUtil.b(r100, r101);
        L4:
            th = move-exception;
            th.printStackTrace();
            return null;
        }
    }

    byte[] encrypt(byte[] r100, int r101);
}
