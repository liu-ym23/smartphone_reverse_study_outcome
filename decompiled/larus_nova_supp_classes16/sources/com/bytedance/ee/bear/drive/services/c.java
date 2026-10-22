package com.bytedance.ee.bear.drive.services;

import com.bytedance.ee.bear.contract.drive.DriveCache;
import com.ss.android.lark.passportc.entity.UserSession;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface c {
    public static final String s1 = null;

    boolean B9(List<String> r1);

    boolean H(String r1, String r2);

    List<DriveCache> K4(long r1, String r3, String r4, UserSession r5);

    boolean M9(DriveCache r1, String r2, UserSession r3);

    boolean Re(long r1, long r3);

    boolean S(String r1);

    boolean T5(String r1, int r2, int r3, UserSession r4);

    boolean Va(long r1);

    List<DriveCache> X2(UserSession r1);

    DriveCache Zc(String r1, boolean r2, UserSession r3);

    long d5(int r1);

    boolean h1();

    long l2();

    List o2(int r1);

    boolean p1(v85.a r1, String r2, String r3, UserSession r4);

    boolean remove(String r1);

    boolean removeAll();

    boolean y9(String r1);

    static {
        s1 = ("drive" + File.separator) + "offline";
    }
}
