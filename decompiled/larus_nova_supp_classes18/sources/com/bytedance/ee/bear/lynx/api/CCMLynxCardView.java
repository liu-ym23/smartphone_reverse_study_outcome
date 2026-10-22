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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    public static final class a {
        public static /* synthetic */ void a(CCMLynxCardView r6, ViewGroup r7, int r8, Map r9, ViewGroup.LayoutParams r10) {
            r6.d(r7, r8, r9, r10, null);
        }
    }

    public interface b {
        void H();

        void a(Map<String, String> r1);

        void onShow();
    }

    void a(ViewGroup r1, String r2, Map<String, ? extends Object> r3, ViewGroup.LayoutParams r4, String r5);

    void b();

    void c(i5 r1);

    void d(ViewGroup r1, int r2, Map<String, ? extends Object> r3, ViewGroup.LayoutParams r4, String r5);

    void destroy();

    b e();

    void f(b r1);

    void g(Map<String, ? extends Object> r1);

    void h(String r1, XBridgeMethod r2);

    <T> void registerWeakHolder(Class<T> r1, T r2);

    void sendEvent(String r1, List<? extends Object> r2);
}
