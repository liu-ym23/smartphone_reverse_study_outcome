package com.bytedance.ee.drive.model.transfer;

import androidx.lifecycle.LiveData;
import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
public interface IDriveTransferTask {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/drive/model/transfer/IDriveTransferTask$EStatus;", "", ErrorCode.INIT, "PENDING", "TRANSFERRING", "SUCCESS", "STOPPED", "FAILED", "drive-model_release"}, k = 1, mv = {1, 7, 1})
    public static final enum EStatus extends Enum<EStatus> {
        public static final EStatus FAILED = null;
        public static final EStatus INIT = null;
        public static final EStatus PENDING = null;
        public static final EStatus STOPPED = null;
        public static final EStatus SUCCESS = null;
        public static final EStatus TRANSFERRING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EStatus[] f242663a = null;

        public static EStatus valueOf(String r100) {
            return (EStatus) a.a(EStatus.class, r100);
        }

        public static EStatus[] values() {
            return (EStatus[]) f242663a.clone();
        }

        static {
            EStatus r100 = new EStatus(ErrorCode.INIT, 0);
            INIT = r100;
            EStatus r101 = new EStatus("PENDING", 1);
            PENDING = r101;
            EStatus r102 = new EStatus("TRANSFERRING", 2);
            TRANSFERRING = r102;
            EStatus r103 = new EStatus("SUCCESS", 3);
            SUCCESS = r103;
            EStatus r104 = new EStatus("STOPPED", 4);
            STOPPED = r104;
            EStatus r105 = new EStatus("FAILED", 5);
            FAILED = r105;
            f242663a = new EStatus[]{r100, r101, r102, r103, r104, r105};
        }

        public EStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    LiveData<EStatus> getStatusLiveData();

    String getTaskId();
}
