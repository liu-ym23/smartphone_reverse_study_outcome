package j2c;

import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f497051a;

    /* JADX INFO: renamed from: j2c.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC6385a {

        /* JADX INFO: renamed from: j2c.a$a$a, reason: collision with other inner class name */
        public static final class C6386a extends AbstractC6385a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C6386a f497052a = null;

            static {
                f497052a = new C6386a();
            }

            public C6386a() {
            }
        }

        /* JADX INFO: renamed from: j2c.a$a$b */
        public static final class b extends AbstractC6385a {
        }

        public AbstractC6385a() {
        }
    }

    public static final class b {
        public b() {
            e.b r100 = e.b.f497066a;
            new d.C6388a();
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f497053a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f497054b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ColorStateList f497055c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Function1<ViewGroup, View> f497056d;

        /* JADX INFO: renamed from: j2c.a$c$a, reason: collision with other inner class name */
        public static final class C6387a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f497057a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f497058b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final ColorStateList f497059c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Function1<? super ViewGroup, ? extends View> f497060d;

            public C6387a() {
                this.f497057a = UIHelper.getColor(R.color.quick_launch_bar_button_border);
                this.f497058b = UIHelper.getDimens(R.dimen.quick_launch_bar_button_border_width);
                this.f497059c = ContextCompat.getColorStateList(UIHelper.getContext(), R.color.quick_launch_bar_button_bg);
            }
        }

        public c(int r100, int r101, ColorStateList r102, Function1 r103) {
            this.f497053a = r100;
            this.f497054b = r101;
            this.f497055c = r102;
            this.f497056d = r103;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f497061a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Integer f497062b;

        /* JADX INFO: renamed from: j2c.a$d$a, reason: collision with other inner class name */
        public static final class C6388a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f497063a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Integer f497064b;

            public C6388a() {
                this.f497063a = R.drawable.ic_quick_launch_bar_item_placeholder;
            }
        }

        public d(int r100, Integer r101) {
            this.f497061a = r100;
            this.f497062b = r101;
        }
    }

    public static abstract class e {

        /* JADX INFO: renamed from: j2c.a$e$a, reason: collision with other inner class name */
        public static final class C6389a extends e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final c f497065a;

            public C6389a() {
                c.C6387a r100 = new c.C6387a();
                this(new c(r100.f497057a, r100.f497058b, r100.f497059c, r100.f497060d));
            }

            public C6389a(c r100) {
                Intrinsics.checkNotNullParameter(r100, "buttonAttrs");
                this.f497065a = r100;
            }
        }

        public static final class b extends e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f497066a = null;

            static {
                f497066a = new b();
            }

            public b() {
            }
        }

        public e() {
        }
    }

    public final d a() {
        return null;
    }

    public final boolean b() {
        throw null;
    }
}
