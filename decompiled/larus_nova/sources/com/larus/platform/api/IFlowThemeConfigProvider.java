package com.larus.platform.api;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J;\u0010\u0002\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0002\u0010\u0011J*\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J?\u0010\u0002\u001a\u0004\u0018\u00010\u00122\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H'¢\u0006\u0002\u0010\u0014J6\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J6\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J$\u0010\u0018\u001a\u00020\u00122\b\b\u0001\u0010\u0019\u001a\u00020\u00122\b\b\u0001\u0010\u001a\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bH'J*\u0010\u001b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J*\u0010\u001d\u001a\u00020\u00122\b\b\u0001\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH'¨\u0006\u001f"}, d2 = {"Lcom/larus/platform/api/IFlowThemeConfigProvider;", "", "adaptTintColor", "", "view", "Landroid/widget/ImageView;", "key", "Lcom/larus/platform/api/ThemeColorKey;", "scene", "Lcom/larus/platform/api/ThemeConfigScene;", "featureKey", "Lcom/larus/platform/model/apptheme/AdaptThemeFeatureKey;", "resetTintColor", "srcDrawable", "Landroid/graphics/drawable/Drawable;", "isDarkMode", "", "(Landroid/graphics/drawable/Drawable;Lcom/larus/platform/api/ThemeColorKey;Lcom/larus/platform/api/ThemeConfigScene;Lcom/larus/platform/model/apptheme/AdaptThemeFeatureKey;Ljava/lang/Boolean;)V", "", "srcTintColor", "(Ljava/lang/Integer;Lcom/larus/platform/api/ThemeColorKey;Lcom/larus/platform/api/ThemeConfigScene;Lcom/larus/platform/model/apptheme/AdaptThemeFeatureKey;Ljava/lang/Boolean;)Ljava/lang/Integer;", "adaptTintColorToDrawable", "keepLayerDrawable", "resetTintColorToDrawable", "adaptDrawableRes", "srcResId", "targetResId", "adaptTextColor", "Landroid/widget/TextView;", "adaptViewColor", "srcColor", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IFlowThemeConfigProvider {

    /* JADX INFO: loaded from: classes31.dex */
    public static final class a {
        public static /* synthetic */ void a(IFlowThemeConfigProvider r100, Drawable r101, ThemeColorKey r102, ThemeConfigScene r103, AdaptThemeFeatureKey r110) {
            r100.g(r101, r102, r103, r110, null);
        }
    }

    int a(int r100, ThemeColorKey r101, ThemeConfigScene r102, AdaptThemeFeatureKey r103);

    Drawable b(Drawable r100, ThemeColorKey r101, ThemeConfigScene r102, AdaptThemeFeatureKey r103);

    void c(ImageView r100, ThemeColorKey r101, ThemeConfigScene r102, AdaptThemeFeatureKey r103);

    void d(TextView r100, ThemeColorKey r101, ThemeConfigScene r102, AdaptThemeFeatureKey r103);

    Drawable e(Drawable r100, Drawable r101, ThemeColorKey r102, ThemeConfigScene r103, AdaptThemeFeatureKey r104);

    Integer f(Integer r100, ThemeColorKey r101, ThemeConfigScene r102, AdaptThemeFeatureKey r103, Boolean r104);

    void g(Drawable r100, ThemeColorKey r101, ThemeConfigScene r102, AdaptThemeFeatureKey r103, Boolean r104);

    int h(AdaptThemeFeatureKey r100);
}
