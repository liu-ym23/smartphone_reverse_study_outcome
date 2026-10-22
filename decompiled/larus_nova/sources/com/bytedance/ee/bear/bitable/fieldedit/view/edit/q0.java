package com.bytedance.ee.bear.bitable.fieldedit.view.edit;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.CommonActionType;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.FieldExtendConfigs;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.FieldExtendInfo;
import com.bytedance.ee.bear.bitable.common.model.field.AllowedEditModes;
import com.bytedance.ee.bear.bitable.common.model.field.FieldProperty;
import com.bytedance.ee.bear.bitable.common.model.field.OptionItem;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.ee.bear.bitable.fieldedit.model.FieldEditPanelData;
import com.bytedance.ee.bear.bitable.fieldedit.view.edit.extendfield.ExtendFieldPropertyEditView;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import io.reactivex.Observable;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public interface q0 {

    public interface a {
        vv4.k c();

        void d(boolean r100);

        Observable<List<OptionItem>> e(String r100, String r101, String r102);

        com.bytedance.ee.bear.bitable.a f();

        Fragment g(String r100, Bundle r101);

        FragmentManager getFragmentManager();

        Lifecycle getLifecycle();

        PluginHost getPluginHost();

        ExtendFieldPropertyEditView h();

        void i(int r100, boolean r101);

        void j(String r100, Object r101);

        <T> Observable<T> k(CommonActionType r100, JSONObject r101, Class<T> r102);

        void l(Object r100);

        FieldEditPanelData m();

        void n(Bundle r100);

        String o();

        BitableFieldEditAnalytic q0();
    }

    void a(FieldExtendConfigs r100);

    boolean b();

    boolean c();

    Observable<Boolean> e();

    AllowedEditModes f();

    boolean g();

    void h();

    Observable<FieldProperty> i();

    FieldExtendInfo j();

    boolean k();

    void l(Object r100);

    void onConfigurationChanged(Configuration r100);

    void onDetach();
}
