package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import dma.d;
import dma.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0003TUVB'\b\u0007\u0012\u0006\u0010N\u001a\u00020M\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010O\u0012\b\b\u0002\u0010Q\u001a\u00020\u0002¢\u0006\u0004\bR\u0010SJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\n\u001a\u00020\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007J\u001f\u0010\u000e\u001a\u00020\u00042\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0013J\u0010\u0010\u0019\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0018R\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\"\u0010,\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u00100\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010'\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R\"\u00104\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010\u001b\u001a\u0004\b2\u0010\u001d\"\u0004\b3\u0010\u001fR\"\u00108\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010\u001b\u001a\u0004\b6\u0010\u001d\"\u0004\b7\u0010\u001fR\"\u0010<\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010\u001b\u001a\u0004\b:\u0010\u001d\"\u0004\b;\u0010\u001fR\u0017\u0010B\u001a\u00020=8\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0017\u0010E\u001a\u00020=8\u0006¢\u0006\f\n\u0004\bC\u0010?\u001a\u0004\bD\u0010AR\"\u0010L\u001a\u00020F8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010K¨\u0006W"}, d2 = {"Lcom/obric/oui/indexscrollbar/LettersBar;", "Landroid/view/View;", "", "index", "", "setLetterPaint", "setTouchedLetter", "", "Ldma/b;", "letters", "setLetters", "", "Landroid/graphics/Bitmap;", "bitmaps", "setBitmapsSelected", "([Landroid/graphics/Bitmap;)V", "Lcom/obric/oui/indexscrollbar/LettersBar$b;", "listener", "setListener", "", "settled", "setSettled", "showBg", "setShowBg", "Lcom/obric/oui/indexscrollbar/LettersBar$c;", "setOnBackgroundVisibleChangedListener", OfficeSDKRequestTag.KEY_NEW_USER, "I", "getMHasChosenLetterFontColor", "()I", "setMHasChosenLetterFontColor", "(I)V", "mHasChosenLetterFontColor", "o", "getMNoChosenLetterFontColor", "setMNoChosenLetterFontColor", "mNoChosenLetterFontColor", "", "y", FaceService.girlLabel, "getDownX", "()F", "setDownX", "(F)V", "downX", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "getDownY", "setDownY", "downY", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getTouchSlop", "setTouchSlop", "touchSlop", "B", "getOldChosen", "setOldChosen", "oldChosen", "C", "getNewChosen", "setNewChosen", "newChosen", "Ljava/lang/Runnable;", "D", "Ljava/lang/Runnable;", "getShowPopupTask", "()Ljava/lang/Runnable;", "showPopupTask", ExifInterface.LONGITUDE_EAST, "getDismissPopupTask", "dismissPopupTask", "", "J", "getShowPopupTaskStartTime", "()J", "setShowPopupTaskStartTime", "(J)V", "showPopupTaskStartTime", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class LettersBar extends View {
    public int A;
    public int B;
    public int C;
    public final dma.c D;
    public final d E;
    public long F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f401079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<dma.b> f401080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f401081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f401082d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bitmap[] f401083e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f401084f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f401085g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f401086h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f401087i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f401088j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f401089k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Paint f401090l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Paint f401091m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f401092n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f401093o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Bitmap f401094p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f401095q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public b f401096r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f401097s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public c f401098t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final f f401099u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f401100v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f401101w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f401102x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f401103y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f401104z;

    public static final class a {
    }

    public interface b {
        void a();
    }

    public interface c {
        void a(boolean r100);
    }

    static {
    }

    public LettersBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LettersBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final ArrayList<Integer> c() {
        ArrayList<Integer> r100 = new ArrayList();
        int r101 = this.f401089k;
        List<dma.b> r102 = this.f401080b;
        Intrinsics.checkNotNull(r102);
        if ((r101 / r102.size()) >= this.f401085g) goto L5;
        List<dma.b> r103 = this.f401080b;
        Intrinsics.checkNotNull(r103);
        int r104 = (int) Math.max(2.0d, ((int) Math.ceil(r103.size() / ((this.f401089k / this.f401085g) - 2))) * 2);
    L6:
        r100.add(0);
        List<dma.b> r105 = this.f401080b;
        Intrinsics.checkNotNull(r105);
        if (r104 >= (r105.size() / 2)) goto L12;
        int r106 = r104;
    L9:
        List<dma.b> r107 = this.f401080b;
        Intrinsics.checkNotNull(r107);
        if (r106 >= (r107.size() - 1)) goto L12;
        r100.add(Integer.valueOf(r106));
        r106 = r106 + r104;
    L12:
        List<dma.b> r108 = this.f401080b;
        Intrinsics.checkNotNull(r108);
        if (r104 >= r108.size()) goto L15;
        List<dma.b> r109 = this.f401080b;
        Intrinsics.checkNotNull(r109);
        r100.add(Integer.valueOf(r109.size() - 1));
    L15:
        return r100;
    L5:
        r104 = 1;
        goto L6
    }

    public final Runnable getDismissPopupTask() {
        return this.E;
    }

    public final float getDownX() {
        return this.f401103y;
    }

    public final float getDownY() {
        return this.f401104z;
    }

    public final int getMHasChosenLetterFontColor() {
        return this.f401092n;
    }

    public final int getMNoChosenLetterFontColor() {
        return this.f401093o;
    }

    public final int getNewChosen() {
        return this.C;
    }

    public final int getOldChosen() {
        return this.B;
    }

    public final Runnable getShowPopupTask() {
        return this.D;
    }

    public final long getShowPopupTaskStartTime() {
        return this.F;
    }

    public final int getTouchSlop() {
        return this.A;
    }

    public static void a(LettersBar r100) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        int r101 = r100.B;
        int r102 = r100.C;
        if (r101 == r102) goto L11;
        if (r102 < 0) goto L11;
        List<dma.b> r103 = r100.f401080b;
        Intrinsics.checkNotNull(r103);
        if (r102 >= r103.size()) goto L11;
        r100.d("ACTION_DOWN", r100.C);
        b r104 = r100.f401096r;
        if (r104 == null) goto L10;
        Intrinsics.checkNotNull(r104);
        List<dma.b> r105 = r100.f401080b;
        Intrinsics.checkNotNull(r105);
        String r106 = ((dma.b) ListProtector.get(r105, r100.C)).f469239b;
        r104.a();
    L10:
        bma.a.b(r100, 26);
        r100.setTouchedLetter(r100.C);
    L11:
        r100.F = -1;
    }

    public static void b(LettersBar r100) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        if (r100.f401099u.b() == false) goto L6;
        r100.f401099u.a();
        r100.setTouchedLetter(-1);
        r100.setShowBg(false);
        return;
    }

    private final void setLetterPaint(int r100) {
        if (this.f401081c != r100) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        this.f401090l.setColor(this.f401092n);
    L9:
        this.f401090l.setFakeBoldText(false);
        this.f401090l.setTextSize(this.f401101w);
        List<dma.b> r102 = this.f401080b;
        Intrinsics.checkNotNull(r102);
        if (StringsKt.startsWith$default(((dma.b) ListProtector.get(r102, r100)).f469239b, ".", false, 2, null) == true) goto L16;
        List<dma.b> r103 = this.f401080b;
        Intrinsics.checkNotNull(r103);
        if (((dma.b) ListProtector.get(r103, r100)).getType() != 1) goto L14;
        this.f401090l.setTextSize(this.f401087i);
        this.f401090l.setFakeBoldText(true);
        return;
    L14:
        this.f401090l.setTextSize(this.f401086h);
        return;
    L16:
        return;
    L8:
        this.f401090l.setColor(this.f401093o);
        goto L9
    L5:
        r101 = false;
        goto L6
    }

    private final void setTouchedLetter(int r100) {
        this.f401081c = r100;
        invalidate();
    }

    @Override // android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        super.dispatchTouchEvent(r110);
        int r100 = r110.getAction();
        float r101 = r110.getY();
        this.B = this.f401081c;
        float r102 = (r101 - getPaddingTop()) / ((getHeight() - getPaddingTop()) - getPaddingBottom());
        List<dma.b> r103 = this.f401080b;
        Intrinsics.checkNotNull(r103);
        int r104 = (int) (r102 * r103.size());
        this.C = r104;
        if (r100 != 0) goto L5;
        removeCallbacks(this.E);
        this.f401103y = r110.getX();
        this.f401104z = r110.getY();
        this.A = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        if (this.f401099u.b() == true) goto L49;
        this.F = System.currentTimeMillis();
        postDelayed(this.D, 200);
    L49:
        this.f401102x = null;
        setShowBg(false);
    L50:
        return true;
    L5:
        if (r100 != 1) goto L7;
        removeCallbacks(this.D);
        if ((System.currentTimeMillis() - this.F) >= 100) goto L39;
        if (this.f401099u.b() == true) goto L39;
        this.F = -1;
        this.D.run();
        postDelayed(this.E, 200);
        return true;
    L39:
        if (this.f401099u.b() == false) goto L41;
        removeCallbacks(this.E);
    L41:
        this.F = -1;
        if (this.f401082d == false) goto L44;
        this.f401099u.a();
        setTouchedLetter(-1);
        setShowBg(false);
    L45:
        invalidate();
        goto L50
    L44:
        this.f401099u.a();
        goto L45
    L7:
        if (r100 == 2) goto L16;
        if (r100 != 3) goto L50;
        removeCallbacks(this.D);
        if (this.f401099u.b() == false) goto L14;
        removeCallbacks(this.E);
    L14:
        this.F = -1;
        this.f401099u.a();
        setTouchedLetter(-1);
        goto L50
    L16:
        if (Math.sqrt(Math.pow(r110.getX() - this.f401103y, 2.0d) + Math.pow(r110.getY() - this.f401104z, 2.0d)) >= this.A) goto L19;
        return true;
    L19:
        if (this.f401099u.b() == false) goto L31;
        if (r104 < 0) goto L31;
        List<dma.b> r111 = this.f401080b;
        Intrinsics.checkNotNull(r111);
        if (r104 >= r111.size()) goto L31;
        if (this.f401082d == true) goto L26;
    L30:
        setTouchedLetter(r104);
        goto L31
    L26:
        if (this.B == r104) goto L30;
        if (this.f401096r == null) goto L30;
        removeCallbacks(this.E);
        d("ACTION_MOVE", r104);
        bma.a.b(this, 26);
        b r112 = this.f401096r;
        Intrinsics.checkNotNull(r112);
        List<dma.b> r105 = this.f401080b;
        Intrinsics.checkNotNull(r105);
        String r106 = ((dma.b) ListProtector.get(r105, r104)).f469239b;
        r112.a();
    L31:
        setShowBg(false);
        goto L50
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        this.f401101w = pla.d.q(this, 10);
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        r110.save();
        r110.translate(0.0f, getPaddingTop());
        ArrayList<Integer> r100 = c();
        float r101 = (float) Math.max(this.f401089k / r100.size(), this.f401085g);
        Iterator<Integer> r102 = r100.iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L66;
        Integer r104 = r102.next();
        setLetterPaint(r104.intValue());
        float r105 = this.f401088j;
        Paint r106 = this.f401090l;
        List<dma.b> r107 = this.f401080b;
        Intrinsics.checkNotNull(r107);
        float r111 = 2;
        float r108 = r105 - (r106.measureText(((dma.b) ListProtector.get(r107, r104.intValue())).f469239b) / r111);
        float r109 = (r103 * r101) + (r101 / r111);
        if (this.f401081c != r104.intValue()) goto L8;
        boolean r112 = true;
    L9:
        if (r112 == true) goto L11;
    L13:
        List<dma.b> r113 = this.f401080b;
        Intrinsics.checkNotNull(r113);
        dma.b r114 = null;
        if (((dma.b) ListProtector.get(r113, r104.intValue())).getType() != 2) goto L58;
        int r115 = r104.intValue();
        List<dma.b> r116 = this.f401080b;
        if (r116 == null) goto L19;
        r114 = (dma.b) CollectionsKt.getOrNull(r116, r115);
    L19:
        if (r114 == null) goto L65;
        Bitmap[] r117 = r114.f469240c;
        if (r117 == null) goto L65;
        int r118 = this.f401081c;
        if (r118 != r115) goto L27;
        boolean r119 = true;
    L28:
        if (r119 == true) goto L30;
    L32:
        boolean r120 = false;
    L34:
        if (r118 == (-1)) goto L36;
        boolean r121 = true;
    L37:
        if (r121 == false) goto L39;
    L42:
        boolean r122 = true;
    L43:
        if (r120 == false) goto L45;
        Bitmap r123 = r117[2];
    L47:
        Bitmap r124 = r123;
        char r125 = 0;
    L49:
        if (r124 != null) goto L53;
        r124 = r117[r125];
        if (r124 == null) goto L65;
    L53:
        if (r120 == false) goto L55;
        int r126 = this.f401092n;
    L56:
        float r127 = this.f401088j - (r124.getWidth() / 2);
        float r128 = r109 - (r124.getHeight() / 2);
        this.f401091m.setColorFilter(new PorterDuffColorFilter(r126, PorterDuff.Mode.SRC_IN));
        r110.drawBitmap(r124, r127, r128, this.f401091m);
        goto L65
    L55:
        r126 = this.f401093o;
        goto L56
    L45:
        if (r122 == false) goto L48;
        r123 = r117[1];
        goto L47
    L48:
        r125 = 0;
        r124 = r117[0];
        goto L49
    L39:
        if (this.f401082d == false) goto L42;
        r122 = false;
        goto L43
    L36:
        r121 = false;
        goto L37
    L30:
        if (this.f401082d == false) goto L32;
        r120 = true;
        goto L34
    L27:
        r119 = false;
    L65:
        r103 = r103 + 1;
        goto L4
    L58:
        int r129 = r104.intValue();
        List<dma.b> r130 = this.f401080b;
        Intrinsics.checkNotNull(r130);
        String r131 = ((dma.b) ListProtector.get(r130, r129)).f469239b;
        if (StringsKt.startsWith$default(r131, ".", false, 2, null) == false) goto L64;
        Bitmap r132 = this.f401094p;
        if (r132 == null) goto L65;
        float r133 = r109 - (r132.getHeight() / 2);
        float r134 = this.f401095q;
        this.f401091m.setColorFilter(new PorterDuffColorFilter(this.f401090l.getColor(), PorterDuff.Mode.SRC_IN));
        r110.drawBitmap(r132, r134, r133, this.f401091m);
        goto L65
    L64:
        Paint.FontMetricsInt r135 = this.f401090l.getFontMetricsInt();
        int r136 = r135.bottom;
        int r137 = r135.top;
        r110.drawText(r131, r108, (r109 - ((r136 - r137) / 2)) - r137, this.f401090l);
        goto L65
    L11:
        if (this.f401082d == false) goto L13;
        Paint r138 = new Paint();
        r138.setColor(getContext().getResources().getColor(R.color.Transparent));
        int r139 = pla.d.n(this, 14);
        pla.d.n(this, 14);
        float r140 = r139 / 2.0f;
        float r141 = this.f401088j;
        r110.drawRoundRect(new RectF(r141 - r140, r109 - r140, r141 + r140, r109 + r140), r140, r140, r138);
        goto L13
    L8:
        r112 = false;
        goto L9
    L66:
        r110.restore();
    }

    public final void setBitmapsSelected(Bitmap[] r100) {
        this.f401083e = r100;
    }

    public final void setDownX(float r100) {
        this.f401103y = r100;
    }

    public final void setDownY(float r100) {
        this.f401104z = r100;
    }

    public final void setLetters(List<dma.b> r100) {
        this.f401080b = r100;
    }

    public final void setListener(b r100) {
        this.f401096r = r100;
    }

    public final void setMHasChosenLetterFontColor(int r100) {
        this.f401092n = r100;
    }

    public final void setMNoChosenLetterFontColor(int r100) {
        this.f401093o = r100;
    }

    public final void setNewChosen(int r100) {
        this.C = r100;
    }

    public final void setOldChosen(int r100) {
        this.B = r100;
    }

    public final void setOnBackgroundVisibleChangedListener(c r100) {
        this.f401098t = r100;
    }

    public final void setSettled(boolean r100) {
        this.f401082d = r100;
        if (r100 == false) goto L5;
        setTouchedLetter(-1);
    L5:
        invalidate();
    }

    public final void setShowBg(boolean r100) {
        if (this.f401097s == r100) goto L12;
        this.f401097s = r100;
        if (r100 == false) goto L7;
        Drawable r101 = getResources().getDrawable(R.drawable.letters_bar_background);
    L8:
        setBackground(r101);
        c r102 = this.f401098t;
        if (r102 == null) goto L13;
        Intrinsics.checkNotNull(r102);
        r102.a(this.f401097s);
        return;
    L13:
        return;
    L7:
        r101 = null;
        goto L8
    }

    public final void setShowPopupTaskStartTime(long r100) {
        this.F = r100;
    }

    public final void setTouchSlop(int r100) {
        this.A = r100;
    }

    public final void d(String r110, int r111) {
        float r100 = (float) Math.max(this.f401089k / c().size(), this.f401085g);
        List<dma.b> r101 = this.f401080b;
        Intrinsics.checkNotNull(r101);
        String r102 = ((dma.b) ListProtector.get(r101, r111)).f469239b;
        if (Intrinsics.areEqual(r102, this.f401102x) == false) goto L5;
        return;
    L5:
        wma.b.a("LettersBar", "showPopupWindow, scene: " + r110 + ", c = " + r111 + ", letter = " + r102 + ", lastPopupLetter = " + this.f401102x);
        Bitmap[] r112 = this.f401083e;
        Bitmap r103 = null;
        if (r112 != null) goto L8;
        Integer r113 = null;
    L9:
        List<dma.b> r104 = this.f401080b;
        Intrinsics.checkNotNull(r104);
        if (((dma.b) ListProtector.get(r104, r111)).getType() != 2) goto L15;
        if (r113 == null) goto L15;
        if (CastIntegerProtector.parseInt(r102) > r113.intValue()) goto L15;
        Bitmap[] r114 = this.f401083e;
        Intrinsics.checkNotNull(r114);
        r103 = r114[CastIntegerProtector.parseInt(r102) - 1];
    L15:
        int r115 = getResources().getDimensionPixelSize(R.dimen.oui_h_title_bar_window);
        int r105 = (this.f401100v - getWidth()) - pla.d.n(this, 68);
        int r106 = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r106 <= 0) goto L18;
        r115 = r115 + getResources().getDimensionPixelSize(r106);
    L18:
        int[] r107 = new int[2];
        getLocationInWindow(r107);
        int r116 = (int) (((r107[1] + getPaddingTop()) + (r111 * r100)) + (r100 / 2));
        f r108 = this.f401099u;
        r108.getClass();
        Intrinsics.checkNotNullParameter(this, "anchorView");
        Intrinsics.checkNotNullParameter(r102, "letter");
        if (r103 != null) goto L32;
        TextView r109 = r108.f469250d;
        if (r109 == null) goto L24;
        r109.setText(r102);
    L24:
        ImageView r117 = r108.f469251e;
        if (r117 == null) goto L28;
        r117.setVisibility(8);
    L28:
        TextView r118 = r108.f469250d;
        if (r118 == null) goto L44;
        r118.setVisibility(0);
    L44:
        PopupWindow r119 = r108.f469248b;
        if (r119 != null) goto L47;
        wma.b.h(r108.f469247a, "showPopup skipped: popupWindow is null.");
    L73:
        this.f401102x = r102;
        return;
    L47:
        View r120 = r119.getContentView();
        if (r120 != null) goto L51;
        wma.b.h(r108.f469247a, "showPopup skipped: contentView is null.");
        goto L73
    L51:
        if (isAttachedToWindow() == true) goto L53;
        wma.b.h(r108.f469247a, "showPopup skipped: anchorView is not attached to window.");
        goto L73
    L53:
        int r121 = RangesKt.coerceAtLeast(r116 - (r120.getMeasuredHeight() / 2), r115);
        if (r119.isShowing() == true) goto L67;
        r119.setElevation(pla.d.m(this, 45.0f));
        if (PopupWindowLancet.hasSubWindowToken(this) == false) goto L59;
    L65:
        r120.setElevation(0.0f);
        goto L73
    L59:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r119) == false) goto L61;
        r119.showAtLocation(this, 0, r105, r121);
        goto L65
    L61:
        OverlaySource r122 = PopupWindowLancet.resolveSource(this);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r119, this, r122, 0, r105, r121) == true) goto L65;
        r119.showAtLocation(this, 0, r105, r121);
        PopupWindowLancet.trackAfterShow(r119, r122, this);
        goto L65
    L67:
        if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r119) == false) goto L70;
        r119.update(r105, r121, -2, -2);
        goto L73
    L70:
        if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r119, r105, r121, -2, -2) == true) goto L73;
        r119.update(r105, r121, -2, -2);
        goto L73
    L32:
        TextView r123 = r108.f469250d;
        if (r123 == null) goto L36;
        r123.setVisibility(8);
    L36:
        ImageView r124 = r108.f469251e;
        if (r124 == null) goto L40;
        r124.setVisibility(0);
    L40:
        ImageView r125 = r108.f469251e;
        if (r125 == null) goto L44;
        r125.setImageBitmap(r103);
        goto L44
    L8:
        r113 = Integer.valueOf(r112.length);
        goto L9
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = View.MeasureSpec.getMode(r101);
        int r103 = View.MeasureSpec.getSize(r101);
        if (r102 != Integer.MIN_VALUE) goto L5;
    L7:
        this.f401089k = (r103 - getPaddingTop()) - getPaddingBottom();
        return;
    L5:
        if (r102 == 1073741824) goto L7;
        r103 = 0;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [dma.d] */
    public LettersBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f401081c = -1;
        this.f401082d = true;
        Paint r103 = new Paint();
        this.f401090l = r103;
        Paint r104 = new Paint(1);
        r104.setFilterBitmap(true);
        r104.setDither(true);
        this.f401091m = r104;
        this.f401099u = new f(r100);
        this.f401079a = r100;
        this.f401101w = pla.d.q(this, 10);
        Context r105 = this.f401079a;
        Intrinsics.checkNotNull(r105);
        Resources r106 = r105.getResources();
        this.f401085g = r106.getDimensionPixelSize(R.dimen.letters_bar_single_letter_min_height);
        this.f401084f = pla.d.n(this, 14);
        this.f401086h = r106.getDimensionPixelOffset(R.dimen.letters_bar_letter_font_size);
        this.f401087i = r106.getDimensionPixelOffset(R.dimen.letters_bar_letter_locale_font_size);
        this.f401088j = (this.f401084f / 2) + getPaddingLeft();
        BitmapFactory.decodeResource(r106, R.drawable.letters_bar_highlight_icon);
        Drawable r107 = r106.getDrawable(R.drawable.letters_bar_highlight_icon);
        int r108 = r107.getIntrinsicWidth() / 2;
        r107.getIntrinsicHeight();
        this.f401092n = r106.getColor(R.color.oui_functional_blue_6);
        this.f401093o = r106.getColor(R.color.oui_text_3b);
        Bitmap r109 = BitmapFactory.decodeResource(r106, R.drawable.letters_bar_dot);
        this.f401094p = r109;
        int r110 = this.f401088j;
        Intrinsics.checkNotNull(r109);
        this.f401095q = r110 - (r109.getWidth() / 2);
        r103.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        r103.setTextSize(this.f401086h);
        r103.setAntiAlias(true);
        Resources r111 = r100.getResources();
        this.f401100v = WindowDisplayMetricsOverride.apply(r111, r111.getDisplayMetrics()).widthPixels;
        this.B = -1;
        this.C = -1;
        this.D = new dma.c(this);
        this.E = new d(this);
        this.F = -1;
    }

    public /* synthetic */ LettersBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
