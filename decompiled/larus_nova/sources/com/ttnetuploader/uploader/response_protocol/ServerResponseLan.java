package com.ttnetuploader.uploader.response_protocol;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ttnetuploader.uploader.api.Parameters;
import com.ttnetuploader.uploader.api.ULLog;
import com.ttnetuploader.uploader.api.a;
import com.ttnetuploader.uploader.net.INetResponse;
import com.ttnetuploader.uploader.slice_task.Range;
import com.ttnetuploader.uploader.utils.CommonTools;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes41.dex */
public class ServerResponseLan extends ServerResponseBase {
    static final String LAN_CLIENT_IP = "t-u-l-n-client-ip";
    static final String LAN_CODE = "t-u-l-n-code";
    static final String LAN_MESSAGE = "t-u-l-n-message";
    static final String LAN_RANGE_LIST = "t-u-l-n-range-list";
    static final String LAN_REMAIN_DISK = "t-u-l-n-remain-disk";
    static final String LAN_TOTAL_DISK = "t-u-l-n-total-disk";

    public ServerResponseLan(INetResponse r100, Parameters r101) {
        super(r100, r101);
        this.mErrorLog = r100.getRequestLog();
        String r102 = r100.getResponseHeaders().get(LAN_CODE);
        if (r102 == null) goto L27;
        this.mCode = CastIntegerProtector.parseInt(r102);
        if (r100.getCode() < 200) goto L25;
        if (r100.getCode() >= 300) goto L25;
        int r103 = r100.getSliceConfig().getSliceType();
        int r104 = this.mCode;
        if (r104 != 0) goto L11;
    L23:
        this.mIsSuccess = true;
        goto L25
    L11:
        if (r103 != 3) goto L15;
        if (r104 == 40000) goto L23;
    L15:
        if (r104 == 40001) goto L23;
        if (r104 != 20202) goto L21;
        this.mIsSuccess = true;
        this.mIsHadUploaded = true;
        goto L25
    L21:
        if (r104 != 40004) goto L25;
        this.mIsSingleSliceSucceed = true;
    L25:
        if (this.mIsSuccess == true) goto L27;
        this.mErrorLog += r100.getResponseHeaders().get(LAN_MESSAGE);
    L27:
        String r105 = r100.getResponseHeaders().get(LAN_REMAIN_DISK);
        if (r105 == null) goto L30;
        this.mServerRemainDisk = CastLongProtector.parseLong(r105);
    L30:
        String r106 = r100.getResponseHeaders().get(LAN_TOTAL_DISK);
        if (r106 == null) goto L33;
        this.mServerTotalDisk = CastLongProtector.parseLong(r106);
    L33:
        String r107 = r100.getResponseHeaders().get(LAN_CLIENT_IP);
        if (r107 == null) goto L36;
        this.mClientIpv4 = r107;
    L36:
        String r108 = r100.getResponseHeaders().get(LAN_RANGE_LIST);
        if (r108 == null) goto L42;
        ArrayList<Range> r109 = CommonTools.getNeedRangeList(r108);
        this.mNeedUploadRangeArray = r109;
        if (r109 == null) goto L42;
        this.mUnuploadedLength = CommonTools.getUnuploadLen(r109);
    L42:
        if (ULLog.debug() == false) goto L49;
        long r110 = ((Long) CommonTools.getNonnullValue(this.mParam, new a(), 0L)).longValue();
        StringBuilder r111 = new StringBuilder("mIsSuccess=");
        r111.append(this.mIsSuccess);
        r111.append(",mIsHadUploaded=");
        r111.append(this.mIsHadUploaded);
        r111.append(",mCode=");
        r111.append(this.mCode);
        r111.append(",mErrorLog=");
        r111.append(this.mErrorLog);
        r111.append(",mNeedUploadRangeArray size=");
        ArrayList<Range> r112 = this.mNeedUploadRangeArray;
        if (r112 != null) goto L46;
        int r113 = 0;
    L47:
        r111.append(r113);
        ULLog.taskDebug("Task", r110, "getServerInfoInternal", r111.toString());
        return;
    L46:
        r113 = r112.size();
        goto L47
    }
}
