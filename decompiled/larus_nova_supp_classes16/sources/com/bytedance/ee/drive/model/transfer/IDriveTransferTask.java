package com.bytedance.ee.drive.model.transfer;

import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface IDriveTransferTask {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/drive/model/transfer/IDriveTransferTask$EStatus;", "", "INIT", "PENDING", "TRANSFERRING", "SUCCESS", "STOPPED", "FAILED", "drive-model_release"}, k = 1, mv = {1, 7, 1})
    public static final enum EStatus extends Enum<EStatus> {
        public static final EStatus FAILED = null;
        public static final EStatus INIT = null;
        public static final EStatus PENDING = null;
        public static final EStatus STOPPED = null;
        public static final EStatus SUCCESS = null;
        public static final EStatus TRANSFERRING = null;
        public static final /* synthetic */ EStatus[] a = null;

        public static EStatus valueOf(String r1) {
            return (EStatus) a.a(EStatus.class, r1);
        }

        public static EStatus[] values() {
            return (EStatus[]) a.clone();
        }

        static {
            EStatus r0 = new EStatus("INIT", 0);
            INIT = r0;
            EStatus r1 = new EStatus("PENDING", 1);
            PENDING = r1;
            EStatus r3 = new EStatus("TRANSFERRING", 2);
            TRANSFERRING = r3;
            EStatus r5 = new EStatus("SUCCESS", 3);
            SUCCESS = r5;
            EStatus r7 = new EStatus("STOPPED", 4);
            STOPPED = r7;
            EStatus r9 = new EStatus("FAILED", 5);
            FAILED = r9;
            a = new EStatus[]{r0, r1, r3, r5, r7, r9};
        }

        public EStatus(String r1, int r2) {
            super(r1, r2);
        }
    }

    LiveData<EStatus> getStatusLiveData();

    String getTaskId();
}
