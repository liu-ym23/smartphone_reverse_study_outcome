package com.larus.bmhome.chat.component.bottom.core;

import android.view.View;
import com.larus.nova.R;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public interface g9 {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function1<c, Boolean> f298533a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super c, Boolean> r100) {
            Intrinsics.checkNotNullParameter(r100, "config");
            this.f298533a = r100;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f298534a;

        public b(View r100) {
            this.f298534a = r100;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f298535a;

        public final h9 a() {
            b r100 = this.f298535a;
            r100.getClass();
            return new h9(r100, R.id.action_entrance);
        }

        public final h9 b() {
            b r100 = this.f298535a;
            r100.getClass();
            return new h9(r100, R.id.action_entrance_iv);
        }

        public final h9 c() {
            b r100 = this.f298535a;
            r100.getClass();
            return new h9(r100, R.id.action_entrance_red_dot);
        }

        public final h9 d() {
            b r100 = this.f298535a;
            r100.getClass();
            return new h9(r100, R.id.action_input);
        }

        public final h9 e() {
            b r100 = this.f298535a;
            r100.getClass();
            return new h9(r100, R.id.action_menu_entrance);
        }

        public final h9 f() {
            b r100 = this.f298535a;
            r100.getClass();
            return new h9(r100, R.id.action_modify_cancel);
        }

        public final h9 g() {
            b r100 = this.f298535a;
            r100.getClass();
            return new h9(r100, R.id.action_modify_confirm);
        }

        public final h9 h() {
            b r100 = this.f298535a;
            r100.getClass();
            return new h9(r100, R.id.action_send);
        }

        public final h9 i() {
            b r100 = this.f298535a;
            r100.getClass();
            return new h9(r100, R.id.action_speak_group);
        }

        public final h9 j() {
            b r100 = this.f298535a;
            r100.getClass();
            return new h9(r100, R.id.input_text);
        }

        public final h9 k() {
            b r100 = this.f298535a;
            r100.getClass();
            return new h9(r100, R.id.speak_area);
        }

        public c(b r100) {
            Intrinsics.checkNotNullParameter(r100, "finder");
            this.f298535a = r100;
        }
    }

    View root();
}
