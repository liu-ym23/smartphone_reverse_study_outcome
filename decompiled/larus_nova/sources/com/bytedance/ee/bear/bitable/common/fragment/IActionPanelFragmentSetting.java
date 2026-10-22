package com.bytedance.ee.bear.bitable.common.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes15.dex */
public interface IActionPanelFragmentSetting {

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    public static final /* synthetic */ int f209829r1 = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/fragment/IActionPanelFragmentSetting$MenuType;", "", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface MenuType {
        public static final a Companion = null;
        public static final int ICON = 0;
        public static final int TEXT = 1;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f209830a = null;

            static {
                f209830a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f209830a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/fragment/IActionPanelFragmentSetting$PanelHeightSpec;", "", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface PanelHeightSpec {
        public static final a Companion = null;
        public static final int FIXED = 0;
        public static final int SELF_ADAPTIVE = 1;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f209831a = null;

            static {
                f209831a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f209831a;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f209832a = 0;

        static {
        }
    }

    static {
        int r100 = a.f209832a;
    }

    void A40(Class<?> r100, String r101, Integer r102);

    Fragment NG(Class<?> r100, String r101, Bundle r102, Integer r103, boolean r104);

    void dn(Float r100, Float r101, Float r102);
}
