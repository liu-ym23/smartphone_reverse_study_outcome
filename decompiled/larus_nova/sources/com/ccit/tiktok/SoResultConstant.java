package com.ccit.tiktok;

/* JADX INFO: loaded from: classes22.dex */
public class SoResultConstant {
    private static SoResultConstant soResultConstant;

    public SoResultConstant() {
    }

    public static SoResultConstant getInstance() {
        if (soResultConstant != null) goto L15;
        monitor-enter(SoResultConstant.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (soResultConstant != null) goto L9;
        soResultConstant = new SoResultConstant();     // Catch: Throwable -> L11
    L9:
        monitor-exit(SoResultConstant.class);     // Catch: Throwable -> L11
    L15:
        return soResultConstant;
    }

    public MKeyResultVo transferSOFResultVo(int r100) {
        MKeyResultVo r101 = new MKeyResultVo();
        if (r100 != 0) goto L6;
        String r102 = "成功";
    L99:
        r101.setResultCode(r100);
        r101.setResultDesc(r102);
        return r101;
    L6:
        if (r100 != 22153) goto L9;
        r102 = "CALLOC_ERROR";
        goto L99
    L9:
        if (r100 < 2000) goto L14;
        if (r100 > 2100) goto L14;
        r102 = "安全通讯数据解析失败";
    L14:
        if (r100 < 3000) goto L19;
        if (r100 > 3100) goto L19;
        r102 = "Base64操作失败";
    L19:
        if (r100 < 4000) goto L24;
        if (r100 > 4002) goto L24;
        r102 = "随机数操作失败";
    L24:
        if (r100 < 5000) goto L29;
        if (r100 > 5010) goto L29;
        r102 = "HAMC操作失败";
    L29:
        if (r100 < 6000) goto L34;
        if (r100 > 6010) goto L34;
        r102 = "HASH操作失败";
    L34:
        if (r100 < 7000) goto L39;
        if (r100 > 7028) goto L39;
        r102 = "对称运算操作失败";
    L39:
        if (r100 < 9000) goto L44;
        if (r100 > 9300) goto L44;
        r102 = "ECC运算操作失败";
    L44:
        if (r100 < 12000) goto L49;
        if (r100 > 12999) goto L49;
        r102 = "密码模块操作失败";
    L49:
        if (r100 < 13000) goto L54;
        if (r100 > 13100) goto L54;
        r102 = "操作本地文件失败";
    L54:
        if (r100 < 14000) goto L59;
        if (r100 > 14010) goto L59;
        r102 = "ASN1操作失败";
    L59:
        if (r100 < 15000) goto L64;
        if (r100 > 15100) goto L64;
        r102 = "公钥操作失败";
    L64:
        if (r100 < 16000) goto L69;
        if (r100 > 16100) goto L69;
        r102 = "证书解析失败";
    L69:
        if (r100 < 18000) goto L74;
        if (r100 > 18999) goto L74;
        r102 = "PIN检验失败";
    L74:
        if (r100 < 21000) goto L79;
        if (r100 > 21300) goto L79;
        r102 = "签名操作失败";
    L79:
        if (r100 < 22000) goto L84;
        if (r100 > 22299) goto L84;
        r102 = "参数检查失败";
    L84:
        if (r100 < 31000) goto L89;
        if (r100 > 31100) goto L89;
        r102 = "Math运算失败";
    L89:
        if (r100 < 34000) goto L94;
        if (r100 > 34010) goto L94;
        r102 = "X509操作失败";
    L94:
        if (r100 >= 167772160) goto L96;
    L98:
        r102 = "SO操作失败";
        goto L99
    L96:
        if (r100 > 167772170) goto L98;
        r102 = "密码句柄操作失败";
        goto L99
    }
}
