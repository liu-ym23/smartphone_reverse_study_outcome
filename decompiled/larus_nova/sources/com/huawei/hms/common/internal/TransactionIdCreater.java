package com.huawei.hms.common.internal;

import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.StringUtil;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes23.dex */
public class TransactionIdCreater {
    public TransactionIdCreater() {
    }

    private static SecureRandom a() {
        return SecureRandom.getInstance("SHA1PRNG");
    L4:
        HMSLog.e("TransactionIdCreater", "SecureRandom getInstance happpened NoSuchAlgorithmException!");
        return new SecureRandom();
    }

    public static String getId(String r100, String r101) {
        StringBuilder r102 = new StringBuilder();
        r102.append(StringUtil.addByteForNum(r100, 9, '0'));
        r102.append(StringUtil.addByteForNum(r101, 6, '0'));
        Locale r103 = Locale.ENGLISH;
        r102.append(new SimpleDateFormat("yyyyMMddHHmmssSSS", r103).format(new Date()));
        r102.append(String.format(r103, "%06d", new Object[]{Integer.valueOf(a().nextInt(1000000))}));
        return r102.toString();
    }
}
