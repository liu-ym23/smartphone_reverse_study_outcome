package com.bytedance.ee.bear.drive.services;

import com.bytedance.ee.bear.contract.drive.DriveCache;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.ss.android.lark.passportc.entity.UserSession;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public interface c {

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    public static final String f224603s1 = null;

    boolean B9(List<String> r100);

    boolean H(String r100, String r101);

    List<DriveCache> K4(long r100, String r101, String r102, UserSession r103);

    boolean M9(DriveCache r100, String r101, UserSession r102);

    boolean Re(long r100, long r101);

    boolean S(String r100);

    boolean T5(String r100, int r101, int r102, UserSession r103);

    boolean Va(long r100);

    List<DriveCache> X2(UserSession r100);

    DriveCache Zc(String r100, boolean r101, UserSession r102);

    long d5(int r100);

    boolean h1();

    long l2();

    List o2(int r100);

    boolean p1(v85.a r100, String r101, String r102, UserSession r103);

    boolean remove(String r100);

    boolean removeAll();

    boolean y9(String r100);

    static {
        f224603s1 = ("drive" + File.separator) + OperationName.OPERATION_OFFLINE_AVAILABLE;
    }
}
