package com.bytedance.bdp.appbase.netapi.base;

import com.ss.mediakit.medialoader.AVMDLDataLoader;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014H\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u000fj\b\u0012\u0004\u0012\u00020\u0004`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/bdp/appbase/netapi/base/DefServerErrorCode;", "", "()V", "errErrInvalidAId", "Lcom/bytedance/bdp/appbase/netapi/base/ErrorCode;", "errErrInvalidAppId", "errErrInvalidSession", "errErrNilAId", "errErrNilAppId", "errErrNilOpenId", "errErrNilSession", "errErrNilSessionId", "errErrNilTTCode", "errErrSystem", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "paramErr", "permissionErr", "codeList", "", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
public final class DefServerErrorCode {
    public static final DefServerErrorCode INSTANCE = null;
    public static final ErrorCode errErrInvalidAId = null;
    public static final ErrorCode errErrInvalidAppId = null;
    public static final ErrorCode errErrInvalidSession = null;
    public static final ErrorCode errErrNilAId = null;
    public static final ErrorCode errErrNilAppId = null;
    public static final ErrorCode errErrNilOpenId = null;
    public static final ErrorCode errErrNilSession = null;
    public static final ErrorCode errErrNilSessionId = null;
    public static final ErrorCode errErrNilTTCode = null;
    public static final ErrorCode errErrSystem = null;
    private static final ArrayList<ErrorCode> list = null;
    public static final ErrorCode paramErr = null;
    public static final ErrorCode permissionErr = null;

    private DefServerErrorCode() {
    }

    static {
        INSTANCE = new DefServerErrorCode();
        ArrayList<ErrorCode> r100 = new ArrayList();
        list = r100;
        ErrorCode r101 = new ErrorCode(-1, "ErrErrSystem");
        r100.add(r101);
        errErrSystem = r101;
        ErrorCode r102 = new ErrorCode(1, "ParamErr");
        r100.add(r102);
        paramErr = r102;
        ErrorCode r103 = new ErrorCode(2, "PermissionErr");
        r100.add(r103);
        permissionErr = r103;
        ErrorCode r104 = new ErrorCode(10001, "ErrErrNilAppId");
        r100.add(r104);
        errErrNilAppId = r104;
        ErrorCode r105 = new ErrorCode(10002, "ErrErrNilAId");
        r100.add(r105);
        errErrNilAId = r105;
        ErrorCode r106 = new ErrorCode(10003, "ErrErrNilSessionId");
        r100.add(r106);
        errErrNilSessionId = r106;
        ErrorCode r107 = new ErrorCode(10004, "ErrErrNilOpenId");
        r100.add(r107);
        errErrNilOpenId = r107;
        ErrorCode r108 = new ErrorCode(10005, "ErrErrNilTTCode");
        r100.add(r108);
        errErrNilTTCode = r108;
        ErrorCode r109 = new ErrorCode(10006, "ErrErrNilSession");
        r100.add(r109);
        errErrNilSession = r109;
        ErrorCode r110 = new ErrorCode(11001, "ErrErrInvalidAppId");
        r100.add(r110);
        errErrInvalidAppId = r110;
        ErrorCode r111 = new ErrorCode(11002, "ErrErrInvalidAId");
        r100.add(r111);
        errErrInvalidAId = r111;
        ErrorCode r112 = new ErrorCode(AVMDLDataLoader.KeyIsSetVdpExtDynamicInfo, "ErrErrInvalidSession");
        r100.add(r112);
        errErrInvalidSession = r112;
    }

    @JvmStatic
    public static final List<ErrorCode> codeList() {
        return list;
    }
}
