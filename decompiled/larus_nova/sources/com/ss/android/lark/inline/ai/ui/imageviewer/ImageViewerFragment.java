package com.ss.android.lark.inline.ai.ui.imageviewer;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larksuite.component.universe_design.button.UDButton;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.imagewidget.largeimage.LargeImageView;
import com.ss.android.lark.inline.ai.ui.f0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import nlb.g;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 8*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u000389:B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\r2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u001a\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010+\u001a\u00020)2\u0006\u0010*\u001a\u00020\"H\u0002J\u0010\u0010,\u001a\u00020)2\u0006\u0010*\u001a\u00020\"H\u0003J\b\u0010-\u001a\u00020)H\u0002J\b\u0010.\u001a\u00020)H\u0002J\b\u0010/\u001a\u00020)H\u0002J\b\u00100\u001a\u00020)H\u0002J\b\u00101\u001a\u00020)H\u0002J\u000e\u00102\u001a\u000203H\u0082@¢\u0006\u0002\u00104J\b\u00105\u001a\u00020)H\u0017J\u0010\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020'H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0018\u00010\u0014R\b\u0012\u0004\u0012\u00028\u00000\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/imageviewer/ImageViewerFragment;", "ITEM_TYPE", "Landroidx/fragment/app/DialogFragment;", "config", "Lcom/ss/android/lark/inline/ai/imageviewer/ImageViewConfig;", "<init>", "(Lcom/ss/android/lark/inline/ai/imageviewer/ImageViewConfig;)V", "mViewPager", "Landroidx/viewpager2/widget/ViewPager2;", "mCancelText", "Landroid/widget/TextView;", "mImageIndex", "mCheckedRegion", "Landroid/view/ViewGroup;", "mChecked", "Landroidx/appcompat/widget/AppCompatCheckBox;", "mSaveWrapper", "mConfirmButton", "Lcom/larksuite/component/universe_design/button/UDButton;", "mAdapter", "Lcom/ss/android/lark/inline/ai/ui/imageviewer/ImageViewerFragment$ImageAdapter;", "mItems", "", "mCheckedItems", "", "mCurrentIndex", "", "mCallback", "Lcom/ss/android/lark/inline/ai/imageviewer/IImageCallback;", "mCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/ss/android/lark/vfs/VFSPath;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "findViews", "initViews", "initListeners", "updateChecked", "updateImageIndex", "updateConfirmButton", "updateSaveButton", "doSave", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", WidgetCostModule.TYPE_ON_START, "onSaveInstanceState", "outState", "Companion", "ImageAdapter", "ImageViewHolder", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageViewerFragment<ITEM_TYPE> extends DialogFragment {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f427535r = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ylb.c<ITEM_TYPE> f427536d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewPager2 f427537e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f427538f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f427539g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewGroup f427540h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AppCompatCheckBox f427541i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ViewGroup f427542j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public UDButton f427543k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ImageViewerFragment<ITEM_TYPE>.ImageAdapter f427544l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<? extends ITEM_TYPE> f427545m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<ITEM_TYPE> f427546n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f427547o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ylb.a<ITEM_TYPE> f427548p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ConcurrentHashMap<String, VFSPath> f427549q;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/imageviewer/ImageViewerFragment$ImageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/inline/ai/ui/imageviewer/ImageViewerFragment$ImageViewHolder;", "<init>", "(Lcom/ss/android/lark/inline/ai/ui/imageviewer/ImageViewerFragment;)V", "mGlide", "Lcom/bumptech/glide/RequestManager;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ImageAdapter extends RecyclerView.Adapter<ImageViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RequestManager f427550a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImageViewerFragment<ITEM_TYPE> f427551b;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return this.f427551b.f427545m.size();
        }

        public ImageAdapter(ImageViewerFragment r100) {
            this.f427551b = r100;
            this.f427550a = Glide.with(r100);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
            ImageViewHolder r112 = (ImageViewHolder) r110;
            Intrinsics.checkNotNullParameter(r112, "holder");
            Object r100 = CollectionsKt.getOrNull(this.f427551b.f427545m, r111);
            if (r100 == null) goto L12;
            String r101 = this.f427551b.f427536d.f568347b.invoke(r100);
            if (r101 == null) goto L12;
            r112.f427552a.setTag(r101);
            VFSPath r113 = this.f427551b.f427549q.get(r101);
            if (r113 == null) goto L10;
            LargeImageView r102 = r112.f427552a;
            g r103 = new g();
            r103.f519575a = r113;
            r102.o(r103);
        L11:
            r112.f427552a.setOnClickListener(new com.ss.android.lark.inline.ai.ui.imageviewer.a(this.f427551b));
            return;
        L10:
            BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new ImageViewerFragment$ImageAdapter$onBindViewHolder$2$1(r101, r112, this, this.f427551b, null), 2, null);
        L12:
            Log.e("ImageViewerFragment", "imageItem is null! position = " + r111 + ", data size = " + this.f427551b.f427545m.size());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            return new ImageViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.inline_ai_large_image_item, r100, false));
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/imageviewer/ImageViewerFragment$ImageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "imageView", "Lcom/ss/android/lark/imagewidget/largeimage/LargeImageView;", "getImageView", "()Lcom/ss/android/lark/imagewidget/largeimage/LargeImageView;", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ImageViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LargeImageView f427552a;

        public ImageViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f427552a = (LargeImageView) r100.findViewById(R.id.image_view);
        }
    }

    public static final class a {
    }

    static {
    }

    public final void S90() {
        Object r100 = CollectionsKt.getOrNull(this.f427545m, this.f427547o);
        if (r100 != null) goto L6;
        Log.e("ImageViewerFragment", "updateChecked with wrong data! mItems.size = " + this.f427545m.size() + ", mCurrentIndex = " + this.f427547o);
        return;
    L6:
        int r101 = this.f427546n.indexOf(r100);
        if (r101 < 0) goto L14;
        AppCompatCheckBox r102 = this.f427541i;
        if (r102 == null) goto L11;
        r102.setChecked(true);
    L11:
        AppCompatCheckBox r103 = this.f427541i;
        if (r103 == null) goto L21;
        r103.setText(String.valueOf(r101 + 1));
        return;
    L21:
        return;
    L14:
        AppCompatCheckBox r104 = this.f427541i;
        if (r104 == null) goto L17;
        r104.setChecked(false);
    L17:
        AppCompatCheckBox r105 = this.f427541i;
        if (r105 == null) goto L23;
        r105.setText(null);
        return;
    }

    public final void T90() {
        if (this.f427546n.size() != 0) goto L5;
        this.f427536d.getClass();
        this.f427536d.getClass();
    L6:
        UDButton r100 = this.f427543k;
        if (r100 != null) goto L9;
    L13:
        UDButton r101 = this.f427543k;
        if (r101 != null) goto L16;
        return;
    L16:
        if (this.f427546n.size() <= 0) goto L18;
        boolean r102 = true;
    L19:
        r101.setEnabled(r102);
        return;
    L18:
        r102 = false;
        goto L19
    L9:
        if (this.f427546n.size() != 0) goto L11;
        int r103 = R.string.LarkCCM_Docs_Cover_AIGC_InsertToDocs_0_Button;
    L12:
        r100.setText(UIHelper.mustacheFormat(r103, "number", String.valueOf(this.f427546n.size())));
        goto L13
    L11:
        r103 = R.string.LarkCCM_Docs_Cover_AIGC_InsertToDocs_Button;
        goto L12
    L5:
        this.f427536d.getClass();
        goto L6
    }

    public final void U90() {
        TextView r100 = this.f427539g;
        if (r100 == null) goto L6;
        StringBuilder r101 = new StringBuilder();
        r101.append(this.f427547o + 1);
        r101.append('/');
        r101.append(this.f427545m.size());
        r100.setText(r101.toString());
        return;
    }

    public final void V90() {
        Object r100 = CollectionsKt.getOrNull(this.f427545m, this.f427547o);
        int r101 = 8;
        if (r100 != null) goto L8;
        Log.e("ImageViewerFragment", "updateSaveButton with wrong data! mItems.size = " + this.f427545m.size() + ", mCurrentIndex = " + this.f427547o);
        ViewGroup r102 = this.f427542j;
        if (r102 == null) goto L22;
        r102.setVisibility(8);
        return;
    L22:
        return;
    L8:
        ViewGroup r103 = this.f427542j;
        if (r103 == null) goto L23;
        ylb.c<ITEM_TYPE> r104 = this.f427536d;
        ylb.c.a r105 = r104.f568350e;
        if (r105 == null) goto L15;
        boolean r106 = true;
        if (r105.f568352a != true) goto L15;
    L16:
        if (r106 == true) goto L18;
    L20:
        r103.setVisibility(r101);
        return;
    L18:
        if (this.f427549q.get(r104.f568347b.invoke(r100)) == null) goto L20;
        r101 = 0;
    L15:
        r106 = false;
        goto L16
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        if (r100 == null) goto L15;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L16;
        WindowManager.LayoutParams r102 = r101.getAttributes();
        r102.width = -1;
        r102.height = -1;
        r101.setAttributes(r102);
        r101.setWindowAnimations(R.style.ImageViewerAnimationDialog);
        r101.setBackgroundDrawable(new ColorDrawable(0));
        WindowCompat.setDecorFitsSystemWindows(r101, false);
        View r103 = r101.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L11;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r104 = ThreadMethodProxy.currentThread();
        if (r104 == com.larus.home.impl.utils.c.f346341a) goto L11;
        com.larus.home.impl.utils.c.a(r104, "getDecorView");
    L11:
        WindowInsetsControllerCompat r105 = ViewCompat.getWindowInsetsController(r103);
        if (r105 == null) goto L17;
        r105.hide(WindowInsetsCompat.Type.systemBars());
        r105.setSystemBarsBehavior(2);
        return;
    L17:
        return;
    L16:
        return;
    }

    public ImageViewerFragment(ylb.c<ITEM_TYPE> r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f427536d = r100;
        List<? extends ITEM_TYPE> r101 = r100.f568346a;
        this.f427545m = r101;
        this.f427546n = r100.f568348c;
        this.f427547o = Math.min(Math.max(0, r100.f568349d), CollectionsKt.getLastIndex(r101));
        this.f427548p = r100.f568351f;
        this.f427549q = new ConcurrentHashMap();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "outState");
        Log.i("ImageViewerFragment", "onSaveInstanceState");
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r110);
        this.f427537e = (ViewPager2) r100.findViewById(R.id.view_pager);
        this.f427538f = (TextView) r100.findViewById(R.id.cancel_text);
        this.f427539g = (TextView) r100.findViewById(R.id.image_index);
        this.f427540h = (ViewGroup) r100.findViewById(R.id.v_selected_region);
        this.f427541i = (AppCompatCheckBox) r100.findViewById(R.id.v_selected);
        this.f427542j = (ViewGroup) r100.findViewById(R.id.save_wrapper);
        this.f427543k = (UDButton) r100.findViewById(R.id.confirm_button);
        Context r101 = r100.getContext();
        this.f427544l = new ImageAdapter(this);
        ViewPager2 r111 = this.f427537e;
        if (r111 == null) goto L5;
        r111.setPageTransformer(new MarginPageTransformer(f0.a(15)));
    L5:
        ViewPager2 r112 = this.f427537e;
        if (r112 == null) goto L8;
        r112.setAdapter(this.f427544l);
    L8:
        ViewPager2 r113 = this.f427537e;
        if (r113 == null) goto L11;
        r113.setCurrentItem(this.f427547o, false);
    L11:
        ViewGroup r114 = this.f427542j;
        if (r114 == null) goto L23;
        ylb.c.a r102 = this.f427536d.f568350e;
        if (r102 != null) goto L16;
    L18:
        boolean r103 = false;
    L19:
        if (r103 == false) goto L21;
        int r104 = 0;
    L22:
        r114.setVisibility(r104);
        goto L23
    L21:
        r104 = 8;
        goto L22
    L16:
        if (r102.f568352a != true) goto L18;
        r103 = true;
    L23:
        UDButton r115 = this.f427543k;
        if (r115 == null) goto L26;
        this.f427536d.getClass();
        StateListDrawable r105 = new StateListDrawable();
        int[] r106 = {android.R.attr.state_pressed};
        Drawable r107 = AppCompatResources.getDrawable(r101, R.drawable.ai_primary_fill_pressed);
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable r108 = (GradientDrawable) r107;
        r108.setCornerRadius(f0.a(6));
        Unit r109 = Unit.INSTANCE;
        r105.addState(r106, r108);
        GradientDrawable r116 = new GradientDrawable();
        r116.setColor(AppCompatResources.getColorStateList(r101, R.color.fill_disable));
        r116.setCornerRadius(f0.a(6));
        r105.addState(new int[]{-16842910}, r116);
        Drawable r117 = AppCompatResources.getDrawable(r101, R.drawable.ai_primary_fill_default);
        Intrinsics.checkNotNull(r117, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable r118 = (GradientDrawable) r117;
        r118.setCornerRadius(f0.a(6));
        r105.addState(new int[0], r118);
        r115.setBackground(r105);
    L26:
        S90();
        U90();
        T90();
        V90();
        ViewPager2 r119 = this.f427537e;
        if (r119 == null) goto L29;
        r119.registerOnPageChangeCallback(new ImageViewerFragment$initListeners$1(this));
    L29:
        ViewGroup r120 = this.f427542j;
        if (r120 == null) goto L32;
        r120.setOnClickListener(new ImageViewerFragment$initListeners$2(this));
    L32:
        ViewGroup r121 = this.f427540h;
        if (r121 == null) goto L35;
        r121.setOnClickListener(new b(this));
    L35:
        AppCompatCheckBox r122 = this.f427541i;
        if (r122 == null) goto L38;
        r122.setOnClickListener(new c(this));
    L38:
        UDButton r123 = this.f427543k;
        if (r123 == null) goto L41;
        r123.setOnClickListener(new d(this));
    L41:
        TextView r124 = this.f427538f;
        if (r124 == null) goto L45;
        r124.setOnClickListener(new e(this));
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.inline_ai_image_viewer, r101, false);
    }
}
