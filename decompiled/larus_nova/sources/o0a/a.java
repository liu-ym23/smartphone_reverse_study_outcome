package o0a;

import com.larus.ugc.feed.api.tracker.params.MobFeedStaytimeParamsKmp;
import com.larus.ugc.feed.api.tracker.params.MobSessionClickParamsKmp;
import com.larus.ugc.feed.api.tracker.params.MobSessionSlideParamsKmp;
import com.larus.ugc.feed.api.tracker.params.MobTemplateClickParamsKmp;
import com.larus.ugc.feed.api.tracker.params.MobTemplateMenuClickParamsKmp;
import com.larus.ugc.feed.api.tracker.params.MobTemplateMenuElementShowParamsKmp;
import com.larus.ugc.feed.api.tracker.params.MobTemplateShowParamsKmp;
import com.larus.ugc.feed.api.tracker.params.MobUseTemplateMenuShowParamsKmp;

/* JADX INFO: loaded from: classes31.dex */
public interface a {
    void a(MobUseTemplateMenuShowParamsKmp r100);

    void b(MobTemplateClickParamsKmp r100);

    void c(MobFeedStaytimeParamsKmp r100);

    void d(MobSessionClickParamsKmp r100);

    void e(MobTemplateMenuClickParamsKmp r100);

    void f(MobSessionSlideParamsKmp r100);

    void g(MobTemplateShowParamsKmp r100);

    void h(MobTemplateMenuElementShowParamsKmp r100);
}
