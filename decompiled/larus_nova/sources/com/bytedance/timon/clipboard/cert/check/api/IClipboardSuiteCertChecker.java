package com.bytedance.timon.clipboard.cert.check.api;

import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.basics.Cert;
import com.ss.texturerender.TextureRenderKeys;
import kotlin.Metadata;
import qc4.d;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\n"}, d2 = {"Lcom/bytedance/timon/clipboard/cert/check/api/IClipboardSuiteCertChecker;", "", "Lcom/bytedance/bpea/basics/Cert;", TextureRenderKeys.KEY_IS_CERT, "", "entryToken", "", "apiId", "Lqc4/d;", "check", "clipboard-cert-check-api_release"}, k = 1, mv = {1, 4, 0})
public interface IClipboardSuiteCertChecker {
    d check(Cert r100, String r101, int r102) throws BPEAException;
}
