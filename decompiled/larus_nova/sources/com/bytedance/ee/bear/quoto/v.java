package com.bytedance.ee.bear.quoto;

import com.larksuite.framework.mvp.IView;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public interface v extends IView<a> {

    public interface a extends IView.IViewDelegate {
    }

    void A1(long r100, long r101, List<QuotaInfoResult.DataDTO.ContactsDTO> r102, int r103);

    void C5(QuotaInfoResult.DataDTO.UrlLink r100, long r101, long r102);

    void k5(QuotaInfoResult.DataDTO.ContactsDTO r100, long r101, long r102);

    void n4(QuotaInfoResult.DataDTO.ContactsDTO r100);

    void w0();

    void x5(long r100, List<QuotaInfoResult.DataDTO.ContactsDTO> r101, String r102, int r103);

    void y5(QuotaInfoResult.DataDTO.UrlLink r100, String r101, long r102);
}
