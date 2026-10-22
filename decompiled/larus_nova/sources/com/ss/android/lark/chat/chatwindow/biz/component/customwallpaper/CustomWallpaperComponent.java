package com.ss.android.lark.chat.chatwindow.biz.component.customwallpaper;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.ss.android.lark.chat.chatwindow.biz.component.ChatBaseComponent;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import rkb.g;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0016\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00029:B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\r\u0010\u0007\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\tJ\u001e\u0010$\u001a\u0018\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020'0&\u0012\u0004\u0012\u00020'\u0018\u00010%H\u0016J\b\u0010(\u001a\u00020)H\u0016J\u0018\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\bH\u0002J\u0010\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020\u001eH\u0002J\b\u0010/\u001a\u00020)H\u0002J\b\u00100\u001a\u00020)H\u0002J\u0010\u00101\u001a\u00020)2\u0006\u00102\u001a\u00020 H\u0002J\u001c\u0010*\u001a\u00020)2\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u000104H\u0016J\u0010\u0010*\u001a\u00020)2\u0006\u00106\u001a\u00020\bH\u0016J\u001c\u00107\u001a\u00020)2\b\u00102\u001a\u0004\u0018\u00010 2\b\u00108\u001a\u0004\u0018\u00010\"H\u0016R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/component/customwallpaper/CustomWallpaperComponent;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/ChatBaseComponent;", "Lcom/ss/android/lark/chat/chatwindow/biz/component/customwallpaper/ICustomWallpaperComponent;", "<init>", "()V", "hasView", "", "getLayoutResId", "", "()Ljava/lang/Integer;", "mIVCustomWallpaper", "Landroidx/appcompat/widget/AppCompatImageView;", "getMIVCustomWallpaper", "()Landroidx/appcompat/widget/AppCompatImageView;", "setMIVCustomWallpaper", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "mIVMaskCustomWallpaper", "getMIVMaskCustomWallpaper", "setMIVMaskCustomWallpaper", "mWallpaperWrapper", "Lcom/ss/android/lark/chat/chatwindow/biz/component/customwallpaper/DetectSizeChangeFrameLayout;", "getMWallpaperWrapper", "()Lcom/ss/android/lark/chat/chatwindow/biz/component/customwallpaper/DetectSizeChangeFrameLayout;", "setMWallpaperWrapper", "(Lcom/ss/android/lark/chat/chatwindow/biz/component/customwallpaper/DetectSizeChangeFrameLayout;)V", "wallpaperViewModel", "Lcom/ss/android/lark/chat/chatwindow/biz/component/customwallpaper/WallpaperViewModel;", "mWallPaperHeight", "mWallPaperWidth", "bitmapDrawable", "Landroid/graphics/drawable/BitmapDrawable;", "mContext", "Landroid/content/Context;", "mImageEntity", "Lcom/ss/android/lark/chat/entity/wallpaper/ChatBackgroundEntity;", "oldOrientation", "provideWidgetExport", "", "Ljava/lang/Class;", "Lcom/ss/android/lark/framework/larkwidget/WidgetExport;", WidgetCostModule.TYPE_ON_CREATE, "", "updateCustomWallpaper", "viewWidth", "viewHeight", "loadWallpaper", "drawable", "showMaskInDarkMode", "hideMaskInLightMode", "showMaskIfNeed", PerfLog.PARAM_KEY_CONTEXT_ID, "localPath", "", "fsUnit", "coloRes", "updateCustomWallpaperByEntity", "imageEntity", "Companion", ExifInterface.TAG_ORIENTATION, "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CustomWallpaperComponent extends ChatBaseComponent implements ICustomWallpaperComponent {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f411988l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f411989m;

    @BindView(9813)
    public AppCompatImageView mIVCustomWallpaper;

    @BindView(10600)
    public AppCompatImageView mIVMaskCustomWallpaper;

    @BindView(9814)
    public DetectSizeChangeFrameLayout mWallpaperWrapper;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public BitmapDrawable f411990n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f411991o;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/biz/component/customwallpaper/CustomWallpaperComponent$Orientation;", "", "orientationValue", "", "<init>", "(Ljava/lang/String;II)V", "getOrientationValue", "()I", "PORTRAIT", "LANDSCAPE", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Orientation extends Enum<Orientation> {
        public static final a Companion = null;
        public static final Orientation LANDSCAPE = null;
        public static final Orientation PORTRAIT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Orientation[] f411992a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f411993b = null;
        private final int orientationValue;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<Orientation> getEntries() {
            return f411993b;
        }

        static {
            Orientation r100 = new Orientation("PORTRAIT", 0, 1);
            PORTRAIT = r100;
            Orientation r101 = new Orientation("LANDSCAPE", 1, 2);
            LANDSCAPE = r101;
            Orientation[] r102 = {r100, r101};
            f411992a = r102;
            f411993b = EnumEntriesKt.enumEntries(r102);
            Companion = new a();
        }

        public static Orientation[] values() {
            return (Orientation[]) f411992a.clone();
        }

        public final int getOrientationValue() {
            return this.orientationValue;
        }

        @JvmStatic
        public static final Orientation fromValue(int r100) {
            Companion.getClass();
            if (r100 == 1) goto L9;
            if (r100 == 2) goto L11;
            return PORTRAIT;
        L11:
            return LANDSCAPE;
        L9:
            return PORTRAIT;
        }

        public static Orientation valueOf(String r100) {
            return (Orientation) r27.a.a(Orientation.class, r100);
        }

        public Orientation(String r100, int r101, int r102) {
            super(r100, r101);
            this.orientationValue = r102;
        }
    }

    public static final class a {
    }

    public static final class b implements g<Object, Object> {
        public b() {
        }

        @Override // rkb.g
        public final boolean onLoadFailed(Exception r100, Object r101, Target<Object> r102, boolean r103) {
            Log.e("CustomWallpaperComponent", "image load failed", r100);
            return false;
        }

        @Override // rkb.g
        public final boolean onResourceReady(Object r100, Object r101, Target<Object> r102, DataSource r103, boolean r104) {
            Log.i("CustomWallpaperComponent", "load image success");
            return false;
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomWallpaperComponent f411994a;

        public c(CustomWallpaperComponent r100) {
            this.f411994a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            BitmapDrawable r101 = (BitmapDrawable) r100;
            CustomWallpaperComponent r102 = this.f411994a;
            r102.f411990n = r101;
            Intrinsics.checkNotNull(r101);
            r102.E0(r101);
        }
    }

    public static final class d implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomWallpaperComponent f411995a;

        public d(CustomWallpaperComponent r100) {
            this.f411995a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            int r109 = r103 - r101;
            int r110 = r104 - r102;
            int r111 = r108 - r106;
            if (r109 != (r107 - r105)) goto L5;
            if (r110 != r111) goto L5;
            return;
        L5:
            CustomWallpaperComponent r112 = this.f411995a;
            r112.f411989m = r109;
            r112.f411988l = r110;
            FrameLayout.LayoutParams r113 = new FrameLayout.LayoutParams(r112.f411989m, r112.f411988l);
            FrameLayout.LayoutParams r114 = new FrameLayout.LayoutParams(r112.f411989m, r112.f411988l);
            AppCompatImageView r115 = r112.mIVCustomWallpaper;
            AppCompatImageView r116 = null;
            if (r115 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("mIVCustomWallpaper");
            r115 = null;
        L9:
            r115.setLayoutParams(r113);
            AppCompatImageView r117 = r112.mIVMaskCustomWallpaper;
            if (r117 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("mIVMaskCustomWallpaper");
            r117 = null;
        L13:
            r117.setLayoutParams(r114);
            AppCompatImageView r118 = r112.mIVCustomWallpaper;
            if (r118 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("mIVCustomWallpaper");
            r118 = null;
        L17:
            r118.requestLayout();
            AppCompatImageView r119 = r112.mIVMaskCustomWallpaper;
            if (r119 == null) goto L20;
            r116 = r119;
        L21:
            r116.requestLayout();
            BitmapDrawable r120 = r112.f411990n;
            if (r120 == null) goto L26;
            r112.E0(r120);
            return;
        L26:
            return;
        L20:
            Intrinsics.throwUninitializedPropertyAccessException("mIVMaskCustomWallpaper");
            goto L21
        }
    }

    static {
    }

    @Override // com.ss.android.lark.framework.larkwidget.Widget
    public final boolean v0() {
        return true;
    }

    @Override // com.ss.android.lark.scaffold.Component, com.ss.android.lark.framework.larkwidget.Widget
    public final Map<Class<? extends com.ss.android.lark.framework.larkwidget.c>, com.ss.android.lark.framework.larkwidget.c> z0() {
        return MapsKt.mapOf(TuplesKt.to(ICustomWallpaperComponent.class, this));
    }

    public CustomWallpaperComponent() {
        this.f411991o = 1;
    }

    @Override // com.ss.android.lark.framework.larkwidget.Widget
    public final void onCreate() {
        super.onCreate();
        View r100 = this.f425740e;
        if (r100 == null) goto L5;
        ButterKnife.bind(this, r100);
    L5:
        this.f411991o = LarkContext.getApplication().getResources().getConfiguration().orientation;
        StringBuilder r101 = new StringBuilder("onCreate: current orientation is: ");
        Orientation.a r102 = Orientation.Companion;
        int r103 = this.f411991o;
        r102.getClass();
        if (r103 != 1) goto L8;
        Orientation r104 = Orientation.PORTRAIT;
    L12:
        r101.append(r104);
        Log.i("CustomWallpaperComponent", r101.toString());
        com.ss.android.lark.chat.chatwindow.chat.v2.extension.b.b(new WallpaperViewModel().getOriginImageLiveData(), this, new c(this));
        Fragment r105 = getFragment();
        if (r105 == null) goto L18;
        View r106 = r105.getView();
        if (r106 == null) goto L19;
        r106.addOnLayoutChangeListener(new d(this));
        return;
    L19:
        return;
    L18:
        return;
    L8:
        if (r103 == 2) goto L10;
        r104 = Orientation.PORTRAIT;
        goto L12
    L10:
        r104 = Orientation.LANDSCAPE;
        goto L12
    }

    @Override // com.ss.android.lark.framework.larkwidget.Widget
    public final Integer r0() {
        return Integer.valueOf(R.layout.chat_window_component_customwallpaper);
    }

    public final void E0(BitmapDrawable r100) {
        b r101 = new b();
        com.ss.android.lark.framework.larkwidget.b r102 = this.f425736a;
        AppCompatImageView r103 = null;
        if (r102 == null) goto L5;
        Context r104 = r102.getContext();
    L6:
        IRequestCreator r105 = ImageLoader.with(r104).load(r100).listener(r101).centerCrop().override(this.f411989m, this.f411988l);
        AppCompatImageView r106 = this.mIVCustomWallpaper;
        if (r106 == null) goto L9;
        r103 = r106;
    L10:
        r105.into(r103);
        return;
    L9:
        Intrinsics.throwUninitializedPropertyAccessException("mIVCustomWallpaper");
        goto L10
    L5:
        r104 = null;
        goto L6
    }
}
