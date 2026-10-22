package com.bytedance.bpea.entry.auth;

import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.basics.EntryCategory;
import com.bytedance.bpea.entry.common.BaseAuthEntry;
import com.ss.texturerender.TextureRenderKeys;
import java.util.LinkedHashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;
import qc4.c;
import qc4.d;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/bpea/entry/auth/CertAuthEntry;", "", "()V", "Companion", "cert-auth-entry_release"}, k = 1, mv = {1, 1, 16})
public final class CertAuthEntry {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J;\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\n\u0010\u000bJC\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\n\u0010\rJ\u000e\u0010\u000f\u001a\u0004\u0018\u00010\u000e*\u00020\tH\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/bpea/entry/auth/CertAuthEntry$Companion;", "", "Lcom/bytedance/bpea/basics/Cert;", TextureRenderKeys.KEY_IS_CERT, "", "", "dataTypes", "sdkName", "methodName", "Lqc4/d;", "checkSDKCert", "(Lcom/bytedance/bpea/basics/Cert;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lqc4/d;", "domain", "(Lcom/bytedance/bpea/basics/Cert;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lqc4/d;", "Lorg/json/JSONObject;", "getTranslateResult", "<init>", "()V", "cert-auth-entry_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final JSONObject getTranslateResult(d r100) {
            Object r101 = ((LinkedHashMap) r100.f532472a).get("certConfig");
            if ((r101 instanceof JSONObject) == true) goto L6;
            r101 = null;
        L6:
            return (JSONObject) r101;
        }

        @Deprecated(message = "")
        @JvmStatic
        public final d checkSDKCert(Cert r100, String[] r101, String r102, String r110) throws BPEAException {
            return checkSDKCert(r100, r101, r102, r110, "Collect");
        }

        @JvmStatic
        public final d checkSDKCert(Cert r100, String[] r101, String r102, String r103, String r104) throws BPEAException {
            c r105 = new c(r100, r102 + '_' + r103, r101, Integer.valueOf(EntryCategory.DIRECT_AUTH.getType()));
            r105.f532471f.put("sdkName", r102);
            r105.f532471f.put("methodName", r103);
            BaseAuthEntry.f202194a.getClass();
            com.bytedance.bpea.entry.common.d.b(r105);
            return null;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CertAuthEntry() {
    }

    @Deprecated(message = "")
    @JvmStatic
    public static final d checkSDKCert(Cert r100, String[] r101, String r102, String r103) throws BPEAException {
        return Companion.checkSDKCert(r100, r101, r102, r103);
    }

    @JvmStatic
    public static final d checkSDKCert(Cert r100, String[] r101, String r102, String r103, String r110) throws BPEAException {
        return Companion.checkSDKCert(r100, r101, r102, r103, r110);
    }

    @JvmStatic
    public static final JSONObject getTranslateResult(d r100) {
        return Companion.getTranslateResult(r100);
    }
}
