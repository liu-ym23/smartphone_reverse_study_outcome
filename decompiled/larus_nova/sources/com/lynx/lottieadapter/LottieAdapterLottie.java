package com.lynx.lottieadapter;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import b6a.j;
import b6a.k;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.d;
import com.airbnb.lottie.h;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import m0.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class LottieAdapterLottie implements b6a.b {
    private final LottieAnimationView mLottieView;

    /* JADX INFO: loaded from: classes32.dex */
    public class a implements d {
        public a() {
        }

        @Override // com.airbnb.lottie.d
        public final Bitmap q(h r100) {
            throw null;
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public class b extends com.airbnb.lottie.c {
        public b() {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: loaded from: classes32.dex */
    public class c<T> extends e6a.b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e6a.d f381423a;

        public c(e6a.d r100) {
            this.f381423a = r100;
        }

        @Override // e6a.b
        public final T a(e6a.a<T> r100) {
            return (T) this.f381423a.getValue();
        }
    }

    public static /* synthetic */ Object a(e6a.b r100, v0.b r101) {
        return lambda$addValueCallback$0(r100, r101);
    }

    @Override // b6a.b
    public void setMaxFrameRate(float r100) {
    }

    @Override // b6a.b
    public /* bridge */ /* synthetic */ void setOption(k r100) {
    }

    @Override // b6a.b
    public void cancelAnimation() {
        this.mLottieView.cancelAnimation();
    }

    @Override // b6a.b
    public ColorFilter getColorFilter() {
        return this.mLottieView.getColorFilter();
    }

    @Override // b6a.b
    public c6a.c getComposition() {
        if (this.mLottieView.getComposition() != null) goto L7;
        return null;
    L7:
        return new c6a.c(this.mLottieView.getComposition());
    }

    @Override // b6a.b
    public long getDuration() {
        return this.mLottieView.getDuration();
    }

    @Override // b6a.b
    public int getFrame() {
        return this.mLottieView.getFrame();
    }

    @Override // b6a.b
    public String getImageAssetsFolder() {
        return this.mLottieView.getImageAssetsFolder();
    }

    @Override // b6a.b
    public float getMaxFrame() {
        return this.mLottieView.getMaxFrame();
    }

    @Override // b6a.b
    public float getMinFrame() {
        return this.mLottieView.getMinFrame();
    }

    @Override // b6a.b
    public float getProgress() {
        return this.mLottieView.getProgress();
    }

    @Override // b6a.b
    public int getRepeatCount() {
        return this.mLottieView.getRepeatCount();
    }

    @Override // b6a.b
    public int getRepeatMode() {
        return this.mLottieView.getRepeatMode();
    }

    @Override // b6a.b
    public float getScale() {
        return this.mLottieView.getScale();
    }

    @Override // b6a.b
    public float getSpeed() {
        return this.mLottieView.getSpeed();
    }

    @Override // b6a.b
    public boolean isAnimating() {
        return this.mLottieView.isAnimating();
    }

    @Override // b6a.b
    public void pauseAnimation() {
        this.mLottieView.pauseAnimation();
    }

    @Override // b6a.b
    public void playAnimation() {
        this.mLottieView.playAnimation();
    }

    public void removeAllAnimatorListeners() {
        this.mLottieView.removeAllAnimatorListeners();
    }

    public void removeAllLottieOnCompositionLoadedListener() {
        this.mLottieView.removeAllLottieOnCompositionLoadedListener();
    }

    public void removeAllUpdateListeners() {
        this.mLottieView.removeAllUpdateListeners();
    }

    @Override // b6a.b
    public void resumeAnimation() {
        this.mLottieView.resumeAnimation();
    }

    @Override // b6a.b
    public AnimationType getContentType() {
        return AnimationType.LOTTIE;
    }

    public LottieAdapterLottie(Context r100) {
        this.mLottieView = new LottieAnimationView(r100);
    }

    private Object toLottieProperty(Object r100) {
        if (r100 != c6a.d.f22604a) goto L7;
        return com.airbnb.lottie.k.f24786a;
    L7:
        if (r100 != c6a.d.f22605b) goto L11;
        return com.airbnb.lottie.k.f24787b;
    L11:
        if (r100 != c6a.d.f22606c) goto L15;
        return com.airbnb.lottie.k.f24788c;
    L15:
        if (r100 != c6a.d.f22607d) goto L19;
        return com.airbnb.lottie.k.f24789d;
    L19:
        if (r100 != c6a.d.f22608e) goto L23;
        return com.airbnb.lottie.k.f24790e;
    L23:
        if (r100 != c6a.d.f22609f) goto L27;
        return com.airbnb.lottie.k.f24791f;
    L27:
        if (r100 != c6a.d.f22610g) goto L31;
        return com.airbnb.lottie.k.f24792g;
    L31:
        if (r100 != c6a.d.f22611h) goto L35;
        return com.airbnb.lottie.k.f24793h;
    L35:
        if (r100 != c6a.d.f22612i) goto L39;
        return com.airbnb.lottie.k.f24794i;
    L39:
        if (r100 != c6a.d.f22613j) goto L43;
        return com.airbnb.lottie.k.f24795j;
    L43:
        if (r100 != c6a.d.f22614k) goto L47;
        return com.airbnb.lottie.k.f24796k;
    L47:
        if (r100 != c6a.d.f22615l) goto L51;
        return com.airbnb.lottie.k.f24797l;
    L51:
        if (r100 != c6a.d.f22616m) goto L55;
        return com.airbnb.lottie.k.f24798m;
    L55:
        if (r100 != c6a.d.f22617n) goto L59;
        return com.airbnb.lottie.k.f24799n;
    L59:
        if (r100 != c6a.d.f22618o) goto L63;
        return com.airbnb.lottie.k.f24800o;
    L63:
        if (r100 != c6a.d.f22619p) goto L67;
        return com.airbnb.lottie.k.f24801p;
    L67:
        if (r100 != c6a.d.f22620q) goto L71;
        return com.airbnb.lottie.k.f24802q;
    L71:
        if (r100 != c6a.d.f22621r) goto L75;
        return com.airbnb.lottie.k.f24803r;
    L75:
        if (r100 != c6a.d.f22622s) goto L79;
        return com.airbnb.lottie.k.f24804s;
    L79:
        if (r100 != c6a.d.f22623t) goto L83;
        return com.airbnb.lottie.k.f24805t;
    L83:
        if (r100 != c6a.d.f22624u) goto L87;
        return com.airbnb.lottie.k.f24806u;
    L87:
        if (r100 != c6a.d.f22625v) goto L91;
        return com.airbnb.lottie.k.f24807v;
    L91:
        if (r100 != c6a.d.f22626w) goto L95;
        return com.airbnb.lottie.k.f24808w;
    L95:
        if (r100 != c6a.d.f22627x) goto L99;
        return com.airbnb.lottie.k.f24809x;
    L99:
        if (r100 != c6a.d.f22628y) goto L103;
        return com.airbnb.lottie.k.f24810y;
    L103:
        if (r100 != c6a.d.f22629z) goto L107;
        return com.airbnb.lottie.k.f24811z;
    L107:
        if (r100 != c6a.d.A) goto L111;
        return com.airbnb.lottie.k.A;
    L111:
        if (r100 != c6a.d.B) goto L115;
        return com.airbnb.lottie.k.B;
    L115:
        if (r100 != c6a.d.C) goto L119;
        return com.airbnb.lottie.k.C;
    L119:
        if (r100 == c6a.d.D) goto L121;
        return null;
    L121:
        return com.airbnb.lottie.k.D;
    }

    public void addAnimatorListener(Animator.AnimatorListener r100) {
        this.mLottieView.addAnimatorListener(r100);
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener r100) {
        this.mLottieView.addAnimatorUpdateListener(r100);
    }

    public void removeAnimatorListener(Animator.AnimatorListener r100) {
        this.mLottieView.removeAnimatorListener(r100);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener r100) {
        this.mLottieView.removeUpdateListener(r100);
    }

    public List<d6a.a> resolveKeyPath(d6a.a r100) {
        List<e> r101 = this.mLottieView.resolveKeyPath(new e((String[]) r100.f467213a.toArray(new String[0])));
        ArrayList r102 = new ArrayList();
        Iterator<e> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L12;
        e r104 = r103.next();
        Field r105 = e.class.getDeclaredField(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);     // Catch: IllegalAccessException -> L8 NoSuchFieldException -> L10
        r105.setAccessible(true);     // Catch: IllegalAccessException -> L8 NoSuchFieldException -> L10
        r102.add(new d6a.a((String[]) ((List) r105.get(r104)).toArray(new String[0])));     // Catch: IllegalAccessException -> L8 NoSuchFieldException -> L10
    L8:
        e = move-exception;
        e.printStackTrace();
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L12:
        return r102;
    }

    @Override // b6a.b
    public void setAnimation(int r100) {
        this.mLottieView.setAnimation(r100);
    }

    @Override // b6a.b
    public void setAnimationFromJson(String r100) {
        this.mLottieView.setAnimationFromJson(r100);
    }

    @Override // b6a.b
    public void setAnimationFromUrl(String r100) {
        this.mLottieView.setAnimationFromUrl(r100);
    }

    @Override // b6a.b
    public void setAutoPlay(boolean r100) {
        Field r101 = LottieAnimationView.class.getDeclaredField("autoPlay");     // Catch: Exception -> L4
        r101.setAccessible(true);     // Catch: Exception -> L4
        r101.setBoolean(this.mLottieView, r100);     // Catch: Exception -> L4
        Field r102 = LottieAnimationView.class.getDeclaredField("wasAnimatingWhenDetached");     // Catch: Exception -> L4
        r102.setAccessible(true);     // Catch: Exception -> L4
        r102.setBoolean(this.mLottieView, r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // b6a.b
    public void setColorFilter(ColorFilter r100) {
        this.mLottieView.setColorFilter(r100);
    }

    @Override // b6a.b
    public void setComposition(c6a.c r100) {
        Object r101 = r100.f22603a;
        if ((r101 instanceof LottieComposition) == false) goto L6;
        this.mLottieView.setComposition((LottieComposition) r101);
        return;
    }

    @Override // b6a.b
    public void setFontAssetDelegate(c6a.a r100) {
        this.mLottieView.setFontAssetDelegate(new b());
    }

    @Override // b6a.b
    public void setFrame(int r100) {
        this.mLottieView.setFrame(r100);
    }

    @Override // b6a.b
    public void setImageAssetDelegate(c6a.b r100) {
        if (r100 != null) goto L5;
        this.mLottieView.setImageAssetDelegate(null);
        return;
    L5:
        this.mLottieView.setImageAssetDelegate(new a());
    }

    @Override // b6a.b
    public void setImageAssetsFolder(String r100) {
        this.mLottieView.setImageAssetsFolder(r100);
    }

    @Override // b6a.b
    public void setImageDrawable(Drawable r100) {
        this.mLottieView.setImageDrawable(r100);
    }

    @Override // b6a.b
    public void setImageResource(int r100) {
        this.mLottieView.setImageResource(r100);
    }

    @Override // b6a.b
    public void setMaxFrame(int r100) {
        this.mLottieView.setMaxFrame(r100);
    }

    @Override // b6a.b
    public void setMaxProgress(float r100) {
        this.mLottieView.setMaxProgress(r100);
    }

    @Override // b6a.b
    public void setMinFrame(int r100) {
        this.mLottieView.setMinFrame(r100);
    }

    @Override // b6a.b
    public void setMinProgress(float r100) {
        this.mLottieView.setMinProgress(r100);
    }

    @Override // b6a.b
    public void setParentView(ViewGroup r100) {
        FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(-1, -1);
        r100.addView(this.mLottieView, r101);
    }

    @Override // b6a.b
    public void setProgress(float r100) {
        this.mLottieView.setProgress(r100);
    }

    @Override // b6a.b
    public void setRepeatCount(int r100) {
        this.mLottieView.setRepeatCount(r100);
    }

    @Override // b6a.b
    public void setRepeatMode(int r100) {
        this.mLottieView.setRepeatMode(r100);
    }

    @Override // b6a.b
    public void setScale(float r100) {
        this.mLottieView.setScale(r100);
    }

    @Override // b6a.b
    public void setScaleType(ImageView.ScaleType r100) {
        LottieAnimationView r101 = this.mLottieView;
        if (r101 == null) goto L6;
        r101.setScaleType(r100);
        return;
    }

    @Override // b6a.b
    public void setSpeed(float r100) {
        this.mLottieView.setSpeed(r100);
    }

    @Override // b6a.b
    public void setAnimation(String r100) {
        this.mLottieView.setAnimation(r100);
    }

    @Override // b6a.b
    public void setAnimation(JSONObject r100) {
        this.mLottieView.setAnimation(r100);
    }

    public LottieAdapterLottie(Context r100, k r101) {
        this(r100);
    }

    private static Object lambda$addValueCallback$0(e6a.b r100, v0.b r101) {
        e6a.a r102 = new e6a.a();
        float r103 = r101.f552288a;
        T r104 = r101.f552289b;
        T r105 = r101.f552290c;
        r102.f471151a = r104;
        r102.f471152b = r105;
        return r100.a(r102);
    }

    public void setMinAndMaxFrame(int r100, int r101) {
        this.mLottieView.setMinAndMaxFrame(r100, r101);
    }

    @Override // b6a.b
    public void setMinAndMaxProgress(float r100, float r101) {
        this.mLottieView.setMinAndMaxProgress(r100, r101);
    }

    public Bitmap updateBitmap(String r100, Bitmap r101) {
        return this.mLottieView.updateBitmap(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void addValueCallback(d6a.a r100, T r101, final e6a.b<T> r102) {
        Object r103 = toLottieProperty(r101);
        if (r103 != null) goto L5;
        return;
    L5:
        this.mLottieView.addValueCallback(new e((String[]) r100.f467213a.toArray(new String[0])), r103, new j(r102));
    }

    @Override // b6a.b
    public <T> void addValueCallback(d6a.a r100, T r101, e6a.d<T> r102) {
        addValueCallback(r100, r101, new c(r102));
    }
}
