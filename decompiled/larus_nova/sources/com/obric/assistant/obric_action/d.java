package com.obric.assistant.obric_action;

import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import java.util.LinkedHashSet;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f390403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashSet<String> f390404b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f390405a = null;

        static {
            d r100 = new d("activity.finish_current_page");
            r100.f390404b.add("finish_current_page");
            f390405a = r100;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f390406a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f390407b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f390408c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d f390409d = null;

        public b() {
        }

        static {
            f390406a = new b();
            d r100 = new d("android.activity");
            r100.f390404b.add("activity");
            f390407b = r100;
            d r101 = new d("android.service");
            r101.f390404b.add("service");
            f390408c = r101;
            d r102 = new d("android.broadcast");
            r102.f390404b.add("broadcast");
            f390409d = r102;
        }

        public final d getActivity() {
            return f390407b;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f390410a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f390411b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f390412c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d f390413d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final d f390414e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final d f390415f = null;

        static {
            f390410a = new d("auth.dismiss_keyguard");
            f390411b = new d("auth.session_auth_status");
            f390412c = new d("auth.keyguard_status");
            f390413d = new d("auth.request_voice_print_auth");
            f390414e = new d("auth.request_biometric_auth");
            f390415f = new d("auth.request_device_credential_auth");
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.obric_action.d$d, reason: collision with other inner class name */
    public static final class C4614d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f390416a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f390417b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f390418c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d f390419d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final d f390420e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final d f390421f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final d f390422g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final d f390423h = null;

        static {
            f390416a = new d("chat_page.open_window");
            f390417b = new d("chat_page.pop_window");
            f390418c = new d("chat_page.stash_window");
            f390419d = new d("chat_page.open_new_task_panel");
            d r100 = new d("chat_page.open_clarify_input_panel");
            r100.f390404b.add("open_clarify_input_panel");
            f390420e = r100;
            f390421f = new d("chat_page.open_addition_input_panel");
            f390422g = new d("chat_page.show_keyboard");
            f390423h = new d("chat_page.hide_keyboard");
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f390424a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f390425b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f390426c = null;

        static {
            f390424a = new d("feedback.toast");
            f390425b = new d("feedback.haptic");
            f390426c = new d("feedback.sound");
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f390427a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f390428b = null;

        static {
            d r100 = new d("message.send_message");
            r100.f390404b.add("send_message");
            f390427a = r100;
            d r101 = new d("message.resend_message");
            r101.f390404b.add("resend_message");
            f390428b = r101;
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f390429a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f390430b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f390431c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d f390432d = null;

        static {
            d r100 = new d("omni_task.feedback");
            r100.f390404b.add("omni_task_feed_back");
            f390429a = r100;
            d r101 = new d("omni_task.open_create_shortcut");
            r101.f390404b.add("open_create_shortcut");
            f390430b = r101;
            d r102 = new d("omni_task.open_event_task_detail");
            r102.f390404b.add("open_event_task_detail");
            f390431c = r102;
            f390432d = new d("omni_task.stop");
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f390433a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f390434b = null;

        static {
            f390433a = new d("prompt.confirm_dialog");
            f390434b = new d("prompt.options_dialog");
        }
    }

    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f390435a = null;

        static {
            d r100 = new d("router.deeplink");
            r100.f390404b.add(MemorySourceLinkType.DEEPLINK);
            f390435a = r100;
        }
    }

    public static final class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f390436a = null;

        static {
            d r100 = new d("server.short_link_api");
            r100.f390404b.add("short_link_api");
            f390436a = r100;
        }
    }

    public static final class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f390437a = null;

        static {
            d r100 = new d("settings.open_auto_gui_settings");
            r100.f390404b.add("open_auto_gui_settings");
            f390437a = r100;
        }
    }

    public static final class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f390438a = null;

        static {
            d r100 = new d("skill.open_skill_detail");
            r100.f390404b.add("open_skill_detail");
            f390438a = r100;
        }
    }

    public d(String r100) {
        this.f390403a = r100;
        this.f390404b = SetsKt.linkedSetOf(new String[]{r100});
    }
}
