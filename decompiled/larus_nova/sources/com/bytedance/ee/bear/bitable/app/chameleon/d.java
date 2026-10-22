package com.bytedance.ee.bear.bitable.app.chameleon;

import android.content.res.Configuration;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.app.model.AppTheme;
import com.bytedance.ee.bear.bitable.app.model.NavigationBarColor;
import com.bytedance.ee.bear.browser.plugin.i;
import com.bytedance.ee.bear.document.restore.DocDeletedCtrlView;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public interface d extends i {
    void Ha();

    void Hf(DocDeletedCtrlView r100);

    void S2(AppTheme r100);

    boolean Y4();

    void destroy();

    void ed(NavigationBarColor r100);

    void gc(qo4.a r100);

    void hl(boolean r100);

    boolean jc(boolean r100);

    void kk(FragmentActivity r100, m r101);

    boolean mo();

    void n5();

    boolean onBackPressed();

    void onConfigurationChanged(Configuration r100);

    void p9();

    void w0();

    void y();
}
