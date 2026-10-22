package com.ss.android.lark.officesdk.integrator.mock;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.maintab.export.TabAppInfo;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import vqb.a;

/* JADX INFO: loaded from: classes37.dex */
@ClaymoreImpl(a.class)
public class MainTabApiMock implements a {
    private static final String TAG = "OfficeSdkMock";

    public MainTabApiMock() {
    }

    @Override // vqb.a
    public void addFavoriteTab(com.ss.android.lark.maintab.export.a r100, IGetDataCallback<Unit> r101, boolean r102) {
    }

    public void addFavoriteTab(String r100, String r101, Map<String, String> r102, IGetDataCallback<Unit> r103) {
    }

    public void addFavoriteTabBySlide(Activity r100, Function0<com.ss.android.lark.maintab.export.a> r101) {
    }

    @Override // vqb.a
    public void addVisitRecord(com.ss.android.lark.maintab.export.a r100) {
    }

    public void addVisitRecordV2(com.ss.android.lark.maintab.export.a r100) {
    }

    @Override // vqb.a
    public boolean enableFgMainTabContainer() {
        return false;
    }

    public boolean enableSearchForseti() {
        return false;
    }

    @Override // vqb.a
    public String getConversationTabKey() {
        return "";
    }

    public Boolean getMainTabFragmentVisibility() {
        return null;
    }

    public void makeLaunchBarSharedElementAbility(FragmentActivity r100, View r101) {
    }

    public void moveTabToPosition(int r100, Function1<? super TabAppInfo, Boolean> r101) {
    }

    public void observerMainTabFragmentVisibility(LifecycleOwner r100, Observer<Boolean> r101) {
    }

    public void prefetchFullMainTabData(String r100, String r101) {
    }

    public void setRegisterRole(String r100) {
    }

    public void startNavLauncherActivity(Context r100, View r101) {
    }

    @Override // vqb.a
    public void getAllTabs(IGetDataCallback<List<TabAppInfo>> r100) {
        if (r100 == null) goto L5;
        r100.onSuccess(Collections.emptyList());
        return;
    }

    @Override // vqb.a
    public void deleteFavoriteTab(String r100, TabAppInfo.BizType r101, IGetDataCallback<Unit> r102) {
        if (r102 == null) goto L5;
        r102.onSuccess(Unit.INSTANCE);
        return;
    }

    public void deleteFavoriteTabForMultiSync(String r100, TabAppInfo.BizType r101, IGetDataCallback<Unit> r102) {
        if (r102 == null) goto L5;
        r102.onSuccess(Unit.INSTANCE);
        return;
    }

    @Override // vqb.a
    public void isExistFavoriteTab(String r100, TabAppInfo.BizType r101, IGetDataCallback<Boolean> r102) {
        if (r102 == null) goto L5;
        r102.onSuccess(Boolean.FALSE);
        return;
    }

    public void isExistFavoriteTabForMultiSync(String r100, TabAppInfo.BizType r101, IGetDataCallback<Boolean> r102) {
        if (r102 == null) goto L5;
        r102.onSuccess(Boolean.FALSE);
        return;
    }

    @Override // vqb.a
    public void deleteFavoriteTab(String r100, String r101, TabAppInfo.BizType r102, IGetDataCallback<Unit> r103) {
        if (r103 == null) goto L5;
        r103.onSuccess(Unit.INSTANCE);
        return;
    }

    @Override // vqb.a
    public void isExistFavoriteTab(String r100, String r101, TabAppInfo.BizType r102, IGetDataCallback<Boolean> r103) {
        if (r103 == null) goto L5;
        r103.onSuccess(Boolean.FALSE);
        return;
    }
}
