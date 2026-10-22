package com.bytedance.ee.bear.share.export;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.share.newshare.ShareFragmentExtend;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public interface d {
    void AB(String r100);

    void Ax(int r100);

    void K80();

    void L30(List<? extends ShareItemModel> r100);

    LinearLayout Pf();

    void X9();

    void YH();

    void ZB(com.bytedance.ee.bear.bizwidget.shareview.b r100);

    ShareFragmentExtend c90();

    void gN();

    ShareParams l80();

    FragmentActivity requireActivity();

    Context requireContext();

    List<ShareItemModel> ul();
}
