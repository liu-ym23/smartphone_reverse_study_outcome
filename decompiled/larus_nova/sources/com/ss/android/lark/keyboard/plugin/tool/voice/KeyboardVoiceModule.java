package com.ss.android.lark.keyboard.plugin.tool.voice;

import android.content.Context;
import com.ss.android.lark.biz.im.api.param.IMConstants$NetworkLevel;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes36.dex */
public final class KeyboardVoiceModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f429827a = null;

    public interface a {
        IMConstants$NetworkLevel getCurNetWorkLevel();

        Locale getCurrentLocale();

        c getProfileDependency();

        d getVcDependency();

        boolean isCurrentFeatureEnable(String r100);

        boolean isEn();

        boolean isFeatureGatingEnable(String r100);

        boolean isZh();
    }

    public interface b {
    }

    public interface c {
        void a(Context r100, String r101);
    }

    public interface d {
        void a();

        void b();
    }

    static {
        f429827a = LazyKt.lazy(KeyboardVoiceModule$dependency$2.INSTANCE);
    }

    public static final a a() {
        return (a) f429827a.getValue();
    }
}
