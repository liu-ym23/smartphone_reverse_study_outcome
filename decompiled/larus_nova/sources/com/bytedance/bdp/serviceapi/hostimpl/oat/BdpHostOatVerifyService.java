package com.bytedance.bdp.serviceapi.hostimpl.oat;

import com.bytedance.ai.file.AppletFileError;
import com.bytedance.bdp.bdpbase.service.IBdpService;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/bdp/serviceapi/hostimpl/oat/BdpHostOatVerifyService;", "Lcom/bytedance/bdp/bdpbase/service/IBdpService;", "OatVerificationResult", "bdp-service-api_release"}, k = 1, mv = {1, 4, 0})
public interface BdpHostOatVerifyService extends IBdpService {

    /* JADX INFO: loaded from: classes11.dex */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/bdp/serviceapi/hostimpl/oat/BdpHostOatVerifyService$OatVerificationResult;", "", "NO_NEED", "VALID", "INVALID_NO_ENOUGH_LENGTH", "INVALID_ELF_MAGIC", "INVALID_OAT_MAGIC", AppletFileError.CODE_NOT_EXIST, "EXCEPTION", "bdp-service-api_release"}, k = 1, mv = {1, 4, 0})
    public static final enum OatVerificationResult extends Enum<OatVerificationResult> {
        public static final OatVerificationResult EXCEPTION = null;
        public static final OatVerificationResult INVALID_ELF_MAGIC = null;
        public static final OatVerificationResult INVALID_NO_ENOUGH_LENGTH = null;
        public static final OatVerificationResult INVALID_OAT_MAGIC = null;
        public static final OatVerificationResult NOT_EXIST = null;
        public static final OatVerificationResult NO_NEED = null;
        public static final OatVerificationResult VALID = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ OatVerificationResult[] f201613a = null;

        static {
            OatVerificationResult r100 = new OatVerificationResult("NO_NEED", 0);
            NO_NEED = r100;
            OatVerificationResult r101 = new OatVerificationResult("VALID", 1);
            VALID = r101;
            OatVerificationResult r102 = new OatVerificationResult("INVALID_NO_ENOUGH_LENGTH", 2);
            INVALID_NO_ENOUGH_LENGTH = r102;
            OatVerificationResult r103 = new OatVerificationResult("INVALID_ELF_MAGIC", 3);
            INVALID_ELF_MAGIC = r103;
            OatVerificationResult r104 = new OatVerificationResult("INVALID_OAT_MAGIC", 4);
            INVALID_OAT_MAGIC = r104;
            OatVerificationResult r105 = new OatVerificationResult(AppletFileError.CODE_NOT_EXIST, 5);
            NOT_EXIST = r105;
            OatVerificationResult r106 = new OatVerificationResult("EXCEPTION", 6);
            EXCEPTION = r106;
            f201613a = new OatVerificationResult[]{r100, r101, r102, r103, r104, r105, r106};
        }

        public static OatVerificationResult valueOf(String r100) {
            return (OatVerificationResult) a.a(OatVerificationResult.class, r100);
        }

        public static OatVerificationResult[] values() {
            return (OatVerificationResult[]) f201613a.clone();
        }

        public OatVerificationResult(String r100, int r101) {
            super(r100, r101);
        }
    }
}
