package com.larksuite.component.ui.avatar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public class AvatarModel {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f284041k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f284042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f284043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f284044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f284045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Drawable f284046e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f284047f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Size f284048g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f284049h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Biz f284050i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Scene f284051j;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u0010"}, d2 = {"Lcom/larksuite/component/ui/avatar/AvatarModel$Size;", "", "dpValue", "", "<init>", "(Ljava/lang/String;II)V", "getDpValue", "()I", "MINI", "SMALL", "MIDDLE", "LARGE", "ORIGIN", "getPxValue", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "avatar-badge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Size extends Enum<Size> {
        public static final Size LARGE = null;
        public static final Size MIDDLE = null;
        public static final Size MINI = null;
        public static final Size ORIGIN = null;
        public static final Size SMALL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Size[] f284052a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f284053b = null;
        private final int dpValue;

        public static EnumEntries<Size> getEntries() {
            return f284053b;
        }

        static {
            Size r100 = new Size("MINI", 0, 22);
            MINI = r100;
            Size r101 = new Size("SMALL", 1, 30);
            SMALL = r101;
            Size r102 = new Size("MIDDLE", 2, 48);
            MIDDLE = r102;
            Size r103 = new Size("LARGE", 3, 300);
            LARGE = r103;
            Size r104 = new Size("ORIGIN", 4, -1);
            ORIGIN = r104;
            Size[] r105 = {r100, r101, r102, r103, r104};
            f284052a = r105;
            f284053b = EnumEntriesKt.enumEntries(r105);
        }

        public static Size[] values() {
            return (Size[]) f284052a.clone();
        }

        public final int getDpValue() {
            return this.dpValue;
        }

        public static Size valueOf(String r100) {
            return (Size) r27.a.a(Size.class, r100);
        }

        public final int getPxValue(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return (int) j08.b.a(r100, this.dpValue);
        }

        public Size(String r100, int r101, int r102) {
            super(r100, r101);
            this.dpValue = r102;
        }
    }

    public static class a<T extends a<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Drawable f284054a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f284055b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f284056c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f284057d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Drawable f284058e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f284059f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Size f284060g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f284061h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Biz f284062i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Scene f284063j;

        public a() {
            GradientDrawable r100 = new GradientDrawable();
            r100.setShape(1);
            r100.setColor(AvatarModel.f284041k);
            this.f284058e = r100;
            this.f284060g = Size.MIDDLE;
            this.f284062i = Biz.Messenger;
            this.f284063j = Scene.Chat;
        }

        public final void a(boolean r100) {
            this.f284061h = r100;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.ui.avatar.AvatarModel.Builder");
        }

        public final void b(String r100) {
            this.f284056c = r100;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.ui.avatar.AvatarModel.Builder");
        }

        public final void c(Biz r100) {
            Intrinsics.checkNotNullParameter(r100, "biz");
            this.f284062i = r100;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.ui.avatar.AvatarModel.Builder");
        }

        public final void d(int r100) {
            this.f284055b = r100;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.ui.avatar.AvatarModel.Builder");
        }

        public final void e(Drawable r100) {
            this.f284054a = r100;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.ui.avatar.AvatarModel.Builder");
        }

        public final void f(String r100) {
            this.f284057d = r100;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.ui.avatar.AvatarModel.Builder");
        }

        public final void g(Scene r100) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            this.f284063j = r100;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.ui.avatar.AvatarModel.Builder");
        }

        public final void h(Size r100) {
            Intrinsics.checkNotNullParameter(r100, "size");
            this.f284060g = r100;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.larksuite.component.ui.avatar.AvatarModel.Builder");
        }
    }

    public static final class b {
    }

    static {
        f284041k = ColorProtector.parseColor("#EFF0F1");
    }

    public AvatarModel(a<?> r110) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        Drawable r100 = r110.f284054a;
        int r101 = r110.f284055b;
        String r102 = r110.f284056c;
        String r103 = r110.f284057d;
        Drawable r104 = r110.f284058e;
        int r105 = r110.f284059f;
        Size r106 = r110.f284060g;
        boolean r107 = r110.f284061h;
        Biz r108 = r110.f284062i;
        Scene r111 = r110.f284063j;
        this.f284042a = r100;
        this.f284043b = r101;
        this.f284044c = r102;
        this.f284045d = r103;
        this.f284046e = r104;
        this.f284047f = r105;
        this.f284048g = r106;
        this.f284049h = r107;
        this.f284050i = r108;
        this.f284051j = r111;
    }

    public final Drawable a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Drawable r101 = this.f284046e;
        if (r101 != null) goto L11;
        int r102 = this.f284047f;
        if (r102 > 0) goto L10;
        return null;
    L10:
        return UDIconUtils.getIconDrawable(r100, r102);
    L11:
        return r101;
    }
}
