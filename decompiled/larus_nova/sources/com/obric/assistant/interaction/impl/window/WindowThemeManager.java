package com.obric.assistant.interaction.impl.window;

import android.content.Context;
import android.content.res.Configuration;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fJ\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/WindowThemeManager;", "", "<init>", "()V", "lastDarkMode", "", "lastSystemNightMode", "hasThemeChanged", "", "base", "Landroid/content/Context;", "configuration", "Landroid/content/res/Configuration;", "getThemedContext", "resolveNightMode", "darkMode", "systemNightMode", "resolveSystemNightMode", "resolveThemeResId", "nightMode", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowThemeManager {
    public static final Companion Companion = null;
    private static final int INVALID_DARK_MODE = Integer.MIN_VALUE;
    private static final int INVALID_NIGHT_MODE = -100;
    private static final String TAG = "WindowThemeManager";
    private volatile int lastDarkMode;
    private volatile int lastSystemNightMode;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/WindowThemeManager$Companion;", "", "<init>", "()V", "TAG", "", "INVALID_DARK_MODE", "", "INVALID_NIGHT_MODE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final int resolveNightMode(int r100, int r101) {
        if (r100 != (-1)) goto L5;
        return r101;
    L5:
        if (r100 != 1) goto L7;
    L8:
        return 16;
    L7:
        if (r100 != 2) goto L8;
        return 32;
    }

    private final int resolveThemeResId(int r100) {
        if (r100 != 32) goto L5;
        return R.style.Theme_OApp_Dark;
    L5:
        return R.style.Theme_OApp_Light;
    }

    public WindowThemeManager() {
        this.lastDarkMode = Integer.MIN_VALUE;
        this.lastSystemNightMode = -100;
    }

    private final int resolveSystemNightMode(Context r100, Configuration r101) {
        Integer r102 = Integer.valueOf(r101.uiMode);
        if ((r102.intValue() & 48) == 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L9;
        r102 = null;
    L9:
        if (r102 == null) goto L11;
        int r104 = r102.intValue();
    L13:
        if ((r104 & 48) == 32) goto L17;
        return 16;
    L17:
        return 32;
    L11:
        r104 = r100.getResources().getConfiguration().uiMode;
        goto L13
    L5:
        r103 = false;
        goto L6
    }

    public final Context getThemedContext(Context r100, Configuration r101) {
        Intrinsics.checkNotNullParameter(r100, "base");
        Intrinsics.checkNotNullParameter(r101, "configuration");
        Lazy r102 = we8.j.f559406a;
        int r103 = we8.j.f559408c;
        int r104 = resolveSystemNightMode(r100, r101);
        int r105 = resolveNightMode(r103, r104);
        this.lastDarkMode = r103;
        this.lastSystemNightMode = r104;
        int r106 = resolveThemeResId(r105);
        FLogger.f375446a.i(TAG, "getThemedContext: darkMode=" + r103 + ", systemNightMode=" + r104 + ", resolvedNightMode=" + r105 + ", themeResId=" + r106 + ", configurationUiMode=" + r101.uiMode + ", baseUiMode=" + r100.getResources().getConfiguration().uiMode);
        Configuration r107 = new Configuration();
        r107.uiMode = (r100.getResources().getConfiguration().uiMode & (-49)) | r105;
        Context r108 = r100.createConfigurationContext(r107);
        NewMiraResourcesManager.getInstance().install(r108);
        boolean r109 = v19.h.f552477a;
        if (r105 != 32) goto L5;
        boolean r110 = true;
    L6:
        v19.h.f552477a = r110;
        Intrinsics.checkNotNull(r108);
        return new AssistantWindowContext(r108, r106);
    L5:
        r110 = false;
        goto L6
    }

    public final boolean hasThemeChanged(Context r110, Configuration r111) {
        Intrinsics.checkNotNullParameter(r110, "base");
        Intrinsics.checkNotNullParameter(r111, "configuration");
        Lazy r100 = we8.j.f559406a;
        int r101 = we8.j.f559408c;
        boolean r102 = false;
        if (this.lastDarkMode != Integer.MIN_VALUE) goto L7;
        FLogger.f375446a.i(TAG, "hasThemeChanged: false, reason=no_last_theme, currentDarkMode=" + r101 + ", lastDarkMode=" + this.lastDarkMode + ", configUiMode=" + r111.uiMode + ", baseUiMode=" + r110.getResources().getConfiguration().uiMode);
        return false;
    L7:
        if (this.lastDarkMode == r101) goto L11;
        FLogger.f375446a.i(TAG, "hasThemeChanged: true, reason=dark_mode_setting_changed, currentDarkMode=" + r101 + ", lastDarkMode=" + this.lastDarkMode + ", configUiMode=" + r111.uiMode + ", baseUiMode=" + r110.getResources().getConfiguration().uiMode);
        return true;
    L11:
        if (r101 == (-1)) goto L14;
        FLogger.f375446a.i(TAG, "hasThemeChanged: false, reason=fixed_dark_mode_no_change, currentDarkMode=" + r101 + ", lastDarkMode=" + this.lastDarkMode + ", configUiMode=" + r111.uiMode + ", baseUiMode=" + r110.getResources().getConfiguration().uiMode);
        return false;
    L14:
        int r103 = resolveSystemNightMode(r110, r111);
        if (this.lastSystemNightMode == (-100)) goto L20;
        if (this.lastSystemNightMode == r103) goto L20;
        r102 = true;
    L20:
        if (this.lastSystemNightMode != (-100)) goto L22;
        String r104 = "no_last_system_night_mode";
    L25:
        FLogger.f375446a.i(TAG, "hasThemeChanged: " + r102 + ", reason=" + r104 + ", currentDarkMode=" + r101 + ", lastDarkMode=" + this.lastDarkMode + ", currentSystemNightMode=" + r103 + ", lastSystemNightMode=" + this.lastSystemNightMode + ", configUiMode=" + r111.uiMode + ", baseUiMode=" + r110.getResources().getConfiguration().uiMode);
        return r102;
    L22:
        if (r102 == false) goto L24;
        r104 = "system_night_mode_changed";
        goto L25
    L24:
        r104 = "follow_system_no_change";
        goto L25
    }

    public static /* synthetic */ Context getThemedContext$default(WindowThemeManager r100, Context r101, Configuration r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = r101.getResources().getConfiguration();
    L6:
        return r100.getThemedContext(r101, r102);
    }

    public static /* synthetic */ boolean hasThemeChanged$default(WindowThemeManager r100, Context r101, Configuration r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = r101.getResources().getConfiguration();
    L6:
        return r100.hasThemeChanged(r101, r102);
    }
}
