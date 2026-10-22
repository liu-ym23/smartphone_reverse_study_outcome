package com.bytedance.ee.bear.quoto;

import com.larksuite.framework.mvp.IView;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface v extends IView<a> {

    public interface a extends IView.IViewDelegate {
    }

    void A1(long r1, long r3, List<QuotaInfoResult.DataDTO.ContactsDTO> r5, int r6);

    void C5(QuotaInfoResult.DataDTO.UrlLink r1, long r2, long r4);

    void k5(QuotaInfoResult.DataDTO.ContactsDTO r1, long r2, long r4);

    void n4(QuotaInfoResult.DataDTO.ContactsDTO r1);

    void w0();

    void x5(long r1, List<QuotaInfoResult.DataDTO.ContactsDTO> r3, String r4, int r5);

    void y5(QuotaInfoResult.DataDTO.UrlLink r1, String r2, long r3);
}
