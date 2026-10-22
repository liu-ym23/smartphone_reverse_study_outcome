package com.obric.assistant.interaction.api.service;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\"\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/interaction/api/service/ActivityProxyListener;", "", "onActivityReady", "", "activity", "Landroid/app/Activity;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onFragmentCreate", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "onFragmentStart", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ActivityProxyListener {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onFragmentCreate(ActivityProxyListener r100, Fragment r101) {
            Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        }

        public static void onFragmentStart(ActivityProxyListener r100, Fragment r101) {
            Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        }
    }

    void onActivityReady(Activity r100);

    void onActivityResult(int r100, int r101, Intent r102);

    void onFragmentCreate(Fragment r100);

    void onFragmentStart(Fragment r100);
}
