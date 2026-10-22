package com.bytedance.ee.bear.lynx.api;

import android.view.ViewGroup;
import com.bytedance.ee.bear.document.i5;
import com.bytedance.ies.xbridge.XBridgeMethod;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* JADX INFO: loaded from: classes18.dex */
public interface CCMLynxCardView {

    @Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ee/bear/lynx/api/CCMLynxCardView$ViewType;", "", "Companion", "features-lynx-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FUNCTION, AnnotationTarget.LOCAL_VARIABLE})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ViewType {
        public static final int BANNER = 1000;
        public static final int BITABLE_AUTO_NUMBER = 2;
        public static final int BITABLE_CALENDAR_VIEW = 6;
        public static final int BITABLE_FORM_SHARE_LINK_SETTING_VIEW = 5;
        public static final int BITABLE_PRO = 7;
        public static final int BITABLE_PRO_MANAGER_MEMBER = 8;
        public static final int BITABLE_STATISTICS_VIEW = 1;
        public static final int BITABLE_TIME_ZONE_LIST_VIEW = 4;
        public static final int BITABLE_TIME_ZONE_PAGE_VIEW = 3;
        public static final a Companion = null;
        public static final int DOC_TTS_PLAYER_VIEW = 9;
        public static final int DOC_TTS_PLAYLIST_VIEW = 10;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f229859a = null;

            static {
                f229859a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f229859a;
        }
    }

    public static final class a {
        public static /* synthetic */ void a(CCMLynxCardView r100, ViewGroup r101, int r102, Map r103, ViewGroup.LayoutParams r110) {
            r100.d(r101, r102, r103, r110, null);
        }
    }

    public interface b {
        void H();

        void a(Map<String, String> r100);

        void onShow();
    }

    void a(ViewGroup r100, String r101, Map<String, ? extends Object> r102, ViewGroup.LayoutParams r103, String r104);

    void b();

    void c(i5 r100);

    void d(ViewGroup r100, int r101, Map<String, ? extends Object> r102, ViewGroup.LayoutParams r103, String r104);

    void destroy();

    b e();

    void f(b r100);

    void g(Map<String, ? extends Object> r100);

    void h(String r100, XBridgeMethod r101);

    <T> void registerWeakHolder(Class<T> r100, T r101);

    void sendEvent(String r100, List<? extends Object> r101);
}
