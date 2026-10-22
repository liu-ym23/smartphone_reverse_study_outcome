package com.larus.platform.api;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH&J\u001a\u0010\u000b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH&J \u0010\u000b\u001a\u00020\u00032\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH&J0\u0010\f\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\r"}, d2 = {"Lcom/larus/platform/api/IFlowChatThemeConfigProvider;", "", "disableFeature", "", "srcFeature", "Lkotlin/Function0;", "", "featureKey", "Lcom/larus/platform/model/apptheme/AdaptThemeFeatureKey;", "entryView", "Landroid/view/View;", "enableFeature", "changeFeature", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IFlowChatThemeConfigProvider {
    boolean a(Function0<Unit> r100, AdaptThemeFeatureKey r101);

    boolean b(View r100, AdaptThemeFeatureKey r101);

    boolean c(AppCompatImageView r100, AdaptThemeFeatureKey r101);

    boolean d(Function0<Unit> r100, Function0<Unit> r101, AdaptThemeFeatureKey r102);

    boolean e(Function0<Unit> r100, AdaptThemeFeatureKey r101);
}
