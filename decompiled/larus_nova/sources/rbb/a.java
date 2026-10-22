package rbb;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f537002a = 0;

    static {
    }

    public static Context f() {
        Activity r100 = AppLifecycle.a.f408803a.f();
        if (r100 == null) goto L6;
        return r100;
    L6:
        return LarkContext.getApplication();
    }

    public static Bitmap a() {
        Context r100 = f();
        if (r100 == null) goto L7;
        return BitmapFactory.decodeResource(r100.getResources(), kac.a.b(R.drawable.ud_icon_file_round_unknow_colorful));
    L7:
        return Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
    }

    public static Bitmap e(Bitmap r100) {
        Context r101 = f();
        if (r101 == null) goto L16;
        if (r100 == null) goto L16;
        Drawable r102 = AppCompatResources.getDrawable(r101, kac.a.b(R.drawable.ud_icon_wiki_shortcutarrow_colorful));
        if (r102 != null) goto L9;
        Log.e("DOCS_ICON_BitmapHelper", "shortcutDrawable null");
    L9:
        Bitmap r103 = r100.copy(Bitmap.Config.ARGB_8888, true);
        Canvas r104 = new Canvas(r103);
        if (r102 == null) goto L12;
        r102.setBounds(0, 0, r104.getWidth(), r104.getHeight());
    L12:
        if (r102 == null) goto L14;
        r102.draw(r104);
    L14:
        Intrinsics.checkNotNull(r103);
        return r103;
    L16:
        Log.e("DOCS_ICON_BitmapHelper", "activity " + r101 + " or bitmap " + r100 + ", bitmap create fail");
        return a();
    }

    public static Bitmap b(int r100, Integer r101) {
        if (r100 <= 0) goto L4;
        Context r102 = f();
        if (r102 == null) goto L19;
        int r103 = kac.a.b(r100);
        if (idb.f.a().isEnable("ccm.bitable.use_new_gradation_logo_enable") == false) goto L10;
        Drawable r104 = AppCompatResources.getDrawable(r102, r103);
    L11:
        if (r104 == null) goto L17;
        if (r101 == null) goto L14;
        DrawableCompat.setTint(r104, ContextCompat.getColor(r102, r101.intValue()));
    L14:
        int r105 = UIUtils.dp2px(f(), 44.0f);
        Bitmap r106 = Bitmap.createBitmap(r105, r105, Bitmap.Config.ARGB_8888);
        Canvas r107 = new Canvas(r106);
        r104.setBounds(0, 0, r107.getWidth(), r107.getHeight());
        r104.draw(r107);
        return r106;
    L17:
        return a();
    L10:
        r104 = r102.getDrawable(r103);
        goto L11
    L19:
        return a();
    L4:
        return a();
    }

    public static Bitmap c(int r100, int r101, Integer r102) {
        Context r103 = f();
        if (r103 == null) goto L19;
        Drawable r104 = AppCompatResources.getDrawable(r103, kac.a.b(r100));
        if (r104 == null) goto L17;
        if (r102 == null) goto L9;
        DrawableCompat.setTint(r104, ContextCompat.getColor(r103, r102.intValue()));
    L9:
        if (h18.f.a(r103) == true) goto L11;
    L13:
        float r105 = 1.0f;
    L14:
        int r106 = d(r103, r101, r105);
        int r107 = UIUtils.dp2px(r103, 44.0f);
        Bitmap r108 = Bitmap.createBitmap(r107, r107, Bitmap.Config.ARGB_8888);
        Canvas r109 = new Canvas(r108);
        r109.drawColor(0, PorterDuff.Mode.CLEAR);
        Paint r110 = new Paint();
        r110.setColor(r106);
        r110.setStyle(Paint.Style.FILL_AND_STROKE);
        r110.setAntiAlias(true);
        r109.drawCircle(r109.getWidth() / 2.0f, r109.getHeight() / 2.0f, r109.getWidth() / 2.0f, r110);
        int r111 = UIUtils.dp2px(r103, 10.0f);
        r104.setBounds(r111, r111, r109.getWidth() - r111, r109.getHeight() - r111);
        r104.draw(r109);
        return r108;
    L11:
        if (kac.a.a() == true) goto L13;
        r105 = 0.2f;
        goto L14
    L17:
        return a();
    L19:
        return a();
    }

    public static int d(Context r100, int r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Configuration r103 = new Configuration(r100.getResources().getConfiguration());
        if (kac.a.a() == true) goto L5;
        r103.uiMode = 16;
    L5:
        Context r104 = r100.createConfigurationContext(r103);
        NewMiraResourcesManager.getInstance().install(r104);
        Intrinsics.checkNotNull(r104);
        return UDColorUtils.getAlphaColor(r104, r101, r102);
    }
}
