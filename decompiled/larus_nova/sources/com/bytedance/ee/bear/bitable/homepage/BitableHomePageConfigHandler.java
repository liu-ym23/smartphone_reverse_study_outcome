package com.bytedance.ee.bear.bitable.homepage;

import com.bytedance.ee.bear.list.homepage.banner.BitableBannerConfig;
import com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler;
import com.ss.android.lark.larkconfig.export.plugin.AppSettingPlugin;
import java.util.Collection;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableHomePageConfigHandler extends AbstractBaseSettingHandler {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final BitableHomePageConfigHandler f212174i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static b f212175j;

    @AppSettingPlugin
    public static final class a implements npb.a {
        public a() {
        }

        @Override // npb.a
        public final void a() {
        }

        @Override // npb.a
        public final Collection<AbstractBaseSettingHandler> b() {
            return SetsKt.mutableSetOf(new BitableHomePageConfigHandler[]{BitableHomePageConfigHandler.f212174i});
        }

        @Override // npb.a
        public final String getTag() {
            return "BitableHomePageConfigHandler";
        }
    }

    public interface b {
        void a(BitableBannerConfig r100);
    }

    @Override // com.ss.android.lark.larkconfig.export.handler.a
    public final String a() {
        return "ccm_base_homepage";
    }

    @Override // com.ss.android.lark.larkconfig.export.handler.AbstractBaseSettingHandler
    public final String f() {
        return "BitableHomePageConfigHandler";
    }

    static {
        BitableHomePageConfigHandler r100 = new BitableHomePageConfigHandler();
        f212174i = r100;
        AbstractBaseSettingHandler.a r101 = r100.f431105d;
        r101.c(AnonymousClass1.INSTANCE);
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r100.f431107f = r101;
    }

    public BitableHomePageConfigHandler() {
    }
}
