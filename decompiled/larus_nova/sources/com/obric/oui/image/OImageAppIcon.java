package com.obric.oui.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import cma.b;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0001\u001cB'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u00042\b\b\u0001\u0010\t\u001a\u00020\u0006J\u0010\u0010\f\u001a\u00020\u00042\b\b\u0001\u0010\u000b\u001a\u00020\u0006J\u0010\u0010\u000e\u001a\u00020\u00042\b\b\u0001\u0010\r\u001a\u00020\u0006J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012¨\u0006\u001d"}, d2 = {"Lcom/obric/oui/image/OImageAppIcon;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "enableClipToMask", "", "setClipToMask", "", "backgroundColor", "setImageBackgroundColor", "backgroundColorRes", "setImageBackgroundColorRes", "strokeColor", "setStrokeColor", "strokeColorRes", "setStrokeColorRes", "Landroid/graphics/drawable/Drawable;", "drawable", "setImageDrawable", "", "packageName", "setImagePackageName", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OImageAppIcon extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f401077a;

    public static final class a {
    }

    static {
    }

    public OImageAppIcon(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OImageAppIcon(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void j() {
        if (getDrawable() == null) goto L19;
        Drawable r100 = getDrawable();
        if ((r100 instanceof cma.a) == false) goto L7;
        cma.a r101 = (cma.a) r100;
    L8:
        if (r101 == null) goto L20;
        b r102 = this.f401077a;
        if (r102 != null) goto L13;
        boolean r103 = false;
    L15:
        if (r101.f24231e == r103) goto L21;
        r101.f24231e = r103;
        r101.invalidateSelf();
        return;
    L21:
        return;
    L13:
        r103 = r102.f24243e;
        goto L15
    L20:
        return;
    L7:
        r101 = null;
        goto L8
    }

    public final void l() {
        if (getDrawable() == null) goto L27;
        Drawable r100 = getDrawable();
        Integer r101 = null;
        if ((r100 instanceof cma.a) == false) goto L7;
        cma.a r102 = (cma.a) r100;
    L8:
        if (r102 == null) goto L28;
        b r103 = this.f401077a;
        if (r103 == null) goto L15;
        r101 = r103.f24241c;
    L15:
        if (Intrinsics.areEqual(r102.f24228b, r101) == true) goto L29;
        r102.f24228b = r101;
        if (r101 == null) goto L20;
        boolean r104 = true;
    L21:
        r102.f24234h = r104;
        Intrinsics.stringPlus("backgroundAvoidsStroke =  ", Boolean.valueOf(r104));
        if (r101 == null) goto L25;
        r102.f24233g.setColor(r101.intValue());
    L25:
        r102.invalidateSelf();
        return;
    L20:
        r104 = false;
        goto L21
    L29:
        return;
    L28:
        return;
    L7:
        r102 = null;
        goto L8
    }

    public final void m() {
        if (getDrawable() == null) goto L22;
        Drawable r100 = getDrawable();
        Integer r101 = null;
        if ((r100 instanceof cma.a) == false) goto L7;
        cma.a r102 = (cma.a) r100;
    L8:
        if (r102 == null) goto L23;
        b r103 = this.f401077a;
        if (r103 == null) goto L14;
        r101 = r103.f24242d;
    L14:
        if (r101 != null) goto L16;
        int r104 = ContextCompat.getColor(getContext(), R.color.oui_line_1);
    L18:
        if (r102.f24229c == r104) goto L24;
        r102.f24229c = r104;
        r102.f24232f.setColor(r104);
        r102.invalidateSelf();
        return;
    L24:
        return;
    L16:
        r104 = r101.intValue();
        goto L18
    L23:
        return;
    L7:
        r102 = null;
        goto L8
    }

    public final void setClipToMask(boolean r100) {
        b r101 = this.f401077a;
        if (r101 == null) goto L6;
        r101.f24243e = r100;
    L6:
        j();
    }

    public final void setImageBackgroundColor(int r100) {
        Integer r101 = Integer.valueOf(r100);
        b r102 = this.f401077a;
        if (r102 == null) goto L6;
        r102.f24241c = r101;
    L6:
        l();
    }

    public final void setImageBackgroundColorRes(int r100) {
        setImageBackgroundColor(ContextCompat.getColor(getContext(), r100));
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable r100) {
        Integer r101 = null;
        if (r100 != null) goto L6;
        Drawable r102 = null;
    L30:
        super.setImageDrawable(r102);
        return;
    L6:
        if (Build.VERSION.SDK_INT >= 33) goto L32;
        r102 = r100;
        goto L30
    L32:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L24
        Context r104 = getContext();     // Catch: Throwable -> L24
        b r105 = this.f401077a;     // Catch: Throwable -> L24
        if (r105 != null) goto L11;
        Integer r106 = null;
    L12:
        if (r105 == null) goto L15;
        r101 = r105.f24242d;     // Catch: Throwable -> L24
    L15:
        if (r101 != null) goto L17;
        int r107 = ContextCompat.getColor(getContext(), R.color.oui_line_1);     // Catch: Throwable -> L24
    L18:
        int r108 = r107;
        b r109 = this.f401077a;     // Catch: Throwable -> L24
        if (r109 != null) goto L21;
        boolean r110 = false;
    L22:
        Object r111 = Result.m9449constructorimpl(new cma.a(r104, r100, r106, r108, r110));     // Catch: Throwable -> L24
    L26:
        Result.m9452exceptionOrNullimpl(r111);
        Object r112 = r100;
        if (Result.m9452exceptionOrNullimpl(r111) != null) goto L29;
        r112 = r111;
    L29:
        r102 = (Drawable) r112;
        goto L30
    L21:
        r110 = r109.f24243e;     // Catch: Throwable -> L24
        goto L22
    L17:
        r107 = r101.intValue();     // Catch: Throwable -> L24
        goto L18
    L11:
        r106 = r105.f24241c;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    }

    public final void setImagePackageName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "packageName");
        if (StringsKt.isBlank(r100) == false) goto L16;
        return;
    L16:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        Object r102 = Result.m9449constructorimpl(getContext().getPackageManager().getApplicationIcon(r100));     // Catch: Throwable -> L7
    L10:
        if (Result.m9452exceptionOrNullimpl(r102) == null) goto L13;
        Intrinsics.stringPlus("Failed to load application icon for packageName=", r100);
    L13:
        if (Result.m9456isSuccessimpl(r102) == false) goto L18;
        setImageDrawable((Drawable) r102);
        return;
    L18:
        return;
    L7:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final void setStrokeColor(int r100) {
        b r101 = this.f401077a;
        if (r101 == null) goto L6;
        r101.f24242d = Integer.valueOf(r100);
    L6:
        m();
    }

    public final void setStrokeColorRes(int r100) {
        setStrokeColor(ContextCompat.getColor(getContext(), r100));
    }

    public OImageAppIcon(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        b r103 = b.a.a(b.f24238f, r100, r101, r102);
        this.f401077a = r103;
        j();
        l();
        m();
        OImageShape r104 = r103.f24239a;
        if (r104 == OImageShape.STANDARD) goto L6;
        Objects.toString(r104);
        return;
    }

    public /* synthetic */ OImageAppIcon(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
