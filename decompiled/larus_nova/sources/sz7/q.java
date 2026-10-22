package sz7;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class q extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f544008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f544009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f544010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f544011d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f544012e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f544013f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ColorFilter f544014g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f544015h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f544016i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f544017j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f544018k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f544019l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f544020m;

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable r100 = this.f544011d;
        if (this.f544012e > 0) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L14;
        if (r100 == null) goto L13;
        return r100.getIntrinsicHeight();
    L13:
        return super.getIntrinsicHeight();
    L14:
        return this.f544013f;
    L5:
        if (this.f544013f <= 0) goto L7;
        r101 = true;
        goto L8
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable r100 = this.f544011d;
        int r101 = this.f544012e;
        if (r101 > 0) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L15;
        if (r100 == null) goto L13;
        return r100.getIntrinsicWidth();
    L13:
        return super.getIntrinsicWidth();
    L15:
        return r101;
    L5:
        if (this.f544013f <= 0) goto L7;
        r102 = true;
        goto L8
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable r100 = this.f544011d;
        if (r100 != null) goto L7;
        return -3;
    L7:
        return r100.getOpacity();
    }

    public final int hashCode() {
        int r100 = (((this.f544012e + 31) * 31) + this.f544013f) * 31;
        ColorFilter r101 = this.f544014g;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L6:
        int r103 = (r100 + r102) * 31;
        int r104 = 1231;
        if (this.f544015h == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (((((r103 + r105) * 31) + this.f544016i.hashCode()) * 31) + this.f544017j.hashCode()) * 31;
        if (this.f544018k == true) goto L15;
        r104 = 1237;
    L15:
        return r106 + r104;
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final Context getContext() {
        return this.f544008a;
    }

    public q(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, false);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f544009b == false) goto L17;
        Object r101 = this.f544010c;
        monitor-enter(r101);
        Drawable r102 = this.f544011d;     // Catch: Throwable -> L14
        if (r102 == null) goto L9;
        r102.setBounds(getBounds());     // Catch: Throwable -> L14
    L9:
        Drawable r103 = this.f544011d;     // Catch: Throwable -> L14
        if (r103 == null) goto L12;
        r103.draw(r100);     // Catch: Throwable -> L14
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L14
    L12:
        monitor-exit(r101);
        return;
    L14:
        th = move-exception;
        throw th;
    L17:
        Drawable r105 = this.f544011d;
        if (r105 == null) goto L20;
        r105.setBounds(getBounds());
    L20:
        Drawable r106 = this.f544011d;
        if (r106 == null) goto L26;
        r106.draw(r100);
        return;
    }

    public final void e(Drawable r100) {
        if (this.f544009b == false) goto L30;
        Object r101 = this.f544010c;
        monitor-enter(r101);
    L26:
        th = move-exception;
        throw th;
    L7:
        if ((r100 instanceof BitmapDrawable) == true) goto L9;
    L13:
        this.f544011d = r100;     // Catch: Throwable -> L26
    L14:
        Drawable r102 = this.f544011d;     // Catch: Throwable -> L26
        if (r102 == null) goto L17;
        r102.setColorFilter(this.f544014g);     // Catch: Throwable -> L26
    L17:
        Drawable r103 = this.f544011d;     // Catch: Throwable -> L26
        if (r103 == null) goto L20;
        r103.setCallback(getCallback());     // Catch: Throwable -> L26
    L20:
        Drawable r104 = this.f544011d;     // Catch: Throwable -> L26
        if (r104 == null) goto L23;
        r104.invalidateSelf();     // Catch: Throwable -> L26
    L23:
        invalidateSelf();     // Catch: Throwable -> L26
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L26
        monitor-exit(r101);
        return;
    L9:
        if ((r100 instanceof RoundedBitmapDrawable) == true) goto L13;
        if (this.f544015h == false) goto L13;
        RoundedBitmapDrawable r106 = RoundedBitmapDrawableFactory.create(this.f544008a.getResources(), ((BitmapDrawable) r100).getBitmap());     // Catch: Throwable -> L26
        r106.setCircular(true);     // Catch: Throwable -> L26
        this.f544011d = r106;     // Catch: Throwable -> L26
        goto L14
    L30:
        if ((r100 instanceof BitmapDrawable) == true) goto L32;
    L36:
        this.f544011d = r100;
    L37:
        Drawable r107 = this.f544011d;
        if (r107 == null) goto L40;
        r107.setColorFilter(this.f544014g);
    L40:
        Drawable r108 = this.f544011d;
        if (r108 == null) goto L43;
        r108.setCallback(getCallback());
    L43:
        Drawable r109 = this.f544011d;
        if (r109 == null) goto L46;
        r109.invalidateSelf();
    L46:
        invalidateSelf();
        return;
    L32:
        if ((r100 instanceof RoundedBitmapDrawable) == true) goto L36;
        if (this.f544015h == false) goto L36;
        RoundedBitmapDrawable r110 = RoundedBitmapDrawableFactory.create(this.f544008a.getResources(), ((BitmapDrawable) r100).getBitmap());
        r110.setCircular(true);
        this.f544011d = r110;
        goto L37
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(q.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.larksuite.component.ui.avatar.IconKeyDrawable");
        q r102 = (q) r100;
        if (this.f544012e == r102.f544012e) goto L16;
        return false;
    L16:
        if (this.f544013f == r102.f544013f) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.f544014g, r102.f544014g) == true) goto L22;
        return false;
    L22:
        if (this.f544015h == r102.f544015h) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.f544016i, r102.f544016i) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f544017j, r102.f544017j) == true) goto L31;
        return false;
    L31:
        if (this.f544018k == r102.f544018k) goto L33;
        return false;
    L33:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        Drawable r101 = this.f544011d;
        if (r101 == null) goto L6;
        r101.setAlpha(r100);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "bounds");
        if (this.f544009b == false) goto L15;
        Object r101 = this.f544010c;
        monitor-enter(r101);
        super.setBounds(r100);     // Catch: Throwable -> L12
        Drawable r102 = this.f544011d;     // Catch: Throwable -> L12
        if (r102 == null) goto L9;
        r102.setBounds(r100);     // Catch: Throwable -> L12
    L9:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r101);
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        super.setBounds(r100);
        Drawable r104 = this.f544011d;
        if (r104 == null) goto L21;
        r104.setBounds(r100);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f544014g = r100;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList r100) {
        super.setTintList(r100);
        Drawable r101 = this.f544011d;
        if (r101 == null) goto L6;
        r101.setTintList(r100);
        return;
    }

    public q(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f544008a = r100;
        this.f544009b = r101;
        this.f544010c = new Object();
        this.f544012e = -1;
        this.f544013f = -1;
        this.f544016i = "";
        this.f544017j = "";
        this.f544020m = UIHelper.dp2px(2.0f);
    }

    public static final Drawable a(q r100, Drawable r101, Drawable r102) {
        if (r101 == null) goto L4;
        r100.getClass();
        return r101;
    L4:
        if (r100.f544019l == true) goto L9;
        return null;
    L9:
        return r102;
    }

    public final void b(String r100, int r101, int r102, Drawable r103, boolean r104, Integer r105) {
        this.f544012e = r101;
        this.f544013f = r102;
        String r106 = this.f544016i;
        String r107 = "";
        if (r106 != null) goto L5;
        r106 = "";
    L5:
        this.f544016i = r106;
        String r108 = this.f544017j;
        if (r108 == null) goto L9;
        r107 = r108;
    L9:
        this.f544017j = r107;
        this.f544018k = r104;
        if (r100 != null) goto L12;
    L15:
        boolean r109 = true;
    L16:
        boolean r110 = true ^ r109;
        if (this.f544019l == false) goto L20;
        if (r110 == false) goto L20;
        Drawable r111 = null;
    L21:
        e(r111);
        if (r100 == null) goto L25;
        ImageLoader.with(this.f544008a).load(r100).override(r101, r102).asDrawable().into(new p(r105, this, r103));
        return;
    L25:
        return;
    L20:
        r111 = r103;
        goto L21
    L12:
        if (r100.length() == 0) goto L15;
        r109 = false;
        goto L16
    }

    public static /* synthetic */ void d(q r110, String r111, String r112, int r113, int r114, Drawable r115, boolean r116, Integer r117) {
        r110.c(r111, r112, r113, r114, r115, r116, r117, false, null);
    }

    public final void c(String r110, String r111, int r112, int r113, Drawable r114, boolean r210, Integer r211, boolean r212, Integer r213) {
        this.f544012e = r112;
        this.f544013f = r113;
        if (r110 != null) goto L5;
        String r115 = "";
    L6:
        this.f544016i = r115;
        if (r111 != null) goto L9;
        String r116 = "";
    L10:
        this.f544017j = r116;
        this.f544018k = r210;
        boolean r117 = false;
        if (r212 == true) goto L21;
        if (r110 != null) goto L14;
    L17:
        boolean r118 = true;
    L18:
        if (r118 == false) goto L21;
        boolean r119 = false;
    L23:
        if (this.f544019l == false) goto L26;
        if (r119 == false) goto L26;
        Drawable r120 = null;
    L27:
        e(r120);
        if (r212 != true) goto L30;
        ImageLoader.with(this.f544008a).load(r213).asDrawable().into(new m(r211, this, r114));
        return;
    L30:
        if (r110 != null) goto L32;
        return;
    L32:
        if (r110.length() != 0) goto L34;
        boolean r100 = true;
    L35:
        if (r100 == true) goto L59;
        if (r210 == true) goto L39;
        ImageLoader.with(this.f544008a).load(new EncryptImage(r110)).asDrawable().into(new n(r211, this, r114));
        return;
    L39:
        boolean r101 = v.f544033a;
        if (v.a.a() == false) goto L50;
        int r102 = t.f544031a;
        s r103 = t.a.a(this.f544008a);
        r103.f544027e = r110;
        r103.f544028f = "";
        r103.f544029g = r111;
        r103.f544025c = r112;
        r103.f544026d = r113;
        r103.f544030h = r114;
        o r104 = new o(r211, this, r114);
        Intrinsics.checkNotNullParameter(r104, PickerReporterConstants.KEY.TARGET);
        String r105 = r103.f544027e;
        if (r105 != null) goto L44;
    L45:
        r117 = true;
    L46:
        if (r117 == false) goto L48;
        r104.setIcon(r103.f544030h);
        return;
    L48:
        r103.f544024b.b(r103.f544023a, r105, r103.f544028f, r103.f544029g, r103.f544025c, r103.f544026d, new r(r104, r103));
        return;
    L44:
        if (r105.length() != 0) goto L46;
    L50:
        if (this.f544019l == false) goto L58;
        e(r114);
        return;
    L58:
        return;
    L59:
        return;
    L34:
        r100 = false;
    L26:
        r120 = r114;
        goto L27
    L14:
        if (r110.length() == 0) goto L17;
        r118 = false;
    L21:
        r119 = true;
        goto L23
    L9:
        r116 = r111;
        goto L10
    L5:
        r115 = r110;
        goto L6
    }
}
