package com.bytedance.awemeopen.apps.framework.feed.pinch.event;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pinch/event/PinchScaleEvent;", "", "Companion", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public @interface PinchScaleEvent {
    public static final a Companion = null;
    public static final int ON_EXIT_SCALE = 3;
    public static final int ON_PAGE_SELECTED = 6;
    public static final int ON_RESET_TO_MAX_SCALE = 4;
    public static final int ON_SCALE = 1;
    public static final int ON_SCALE_BEGIN = 0;
    public static final int ON_SCALE_END = 2;
    public static final int ON_TAP = 5;
    public static final int RESET_NAVIGATION = 8;
    public static final int SLIDES_CLICK_HOLDER_ENTER = 7;

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
