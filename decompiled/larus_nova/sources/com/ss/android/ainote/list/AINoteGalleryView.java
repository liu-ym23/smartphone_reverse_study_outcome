package com.ss.android.ainote.list;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.render.view.basic.GXImageView;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.ainote.model.AINoteImageUploadState;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFiles;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 Q2\u00020\u0001:\u0006QRSTUVB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u00108\u001a\u00020\r2\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0007H\u0014J\u0014\u0010;\u001a\u00020\r2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00160=J\u0010\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\fH\u0002J\u0012\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020\u0016H\u0002J\b\u0010D\u001a\u00020BH\u0002J\b\u0010E\u001a\u00020BH\u0002J\u0010\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010J\u001a\u00020B2\u0006\u0010C\u001a\u00020\u0016H\u0002J\u0010\u0010K\u001a\u00020&2\u0006\u0010C\u001a\u00020\u0016H\u0002J\u0018\u0010L\u001a\u00020\r2\u0006\u0010C\u001a\u00020\u00162\u0006\u0010M\u001a\u00020\fH\u0002J\u0018\u0010N\u001a\u00020\r2\u0006\u0010O\u001a\u00020B2\u0006\u0010P\u001a\u00020\u0007H\u0002R(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R(\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011R(\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001f\"\u0004\b(\u0010!R\u000e\u0010)\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010/\u001a\u000600R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R*\u00101\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f02j\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f`3X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/ss/android/ainote/list/AINoteGalleryView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onImageDelete", "Lkotlin/Function1;", "", "", "getOnImageDelete", "()Lkotlin/jvm/functions/Function1;", "setOnImageDelete", "(Lkotlin/jvm/functions/Function1;)V", "onImageRetry", "getOnImageRetry", "setOnImageRetry", "onImageClick", "Lcom/ss/android/ainote/model/AINoteGalleryImage;", "getOnImageClick", "setOnImageClick", "onImageLongClick", "getOnImageLongClick", "setOnImageLongClick", "onBlankClick", "Lkotlin/Function0;", "getOnBlankClick", "()Lkotlin/jvm/functions/Function0;", "setOnBlankClick", "(Lkotlin/jvm/functions/Function0;)V", "onBlankLongClick", "getOnBlankLongClick", "setOnBlankLongClick", "canHandleLongPress", "", "getCanHandleLongPress", "setCanHandleLongPress", "spanCount", "cornerRadiusPx", "", "itemSpacingPx", "maxItemWidthPx", "maxGridWidthPx", "adapter", "Lcom/ss/android/ainote/list/AINoteGalleryView$GalleryAdapter;", "lastOverlayLogKeyByImageId", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "blankLongPressDetector", "Landroid/view/GestureDetector;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "bind", "images", "", "resolveUri", "Landroid/net/Uri;", "pathOrUri", "createStatusView", "Landroid/view/View;", "image", "createUploadLoadingView", "createUploadLoadingIconBackground", "createUploadLoadingIconView", "Landroidx/appcompat/widget/AppCompatImageView;", "loadingDrawable", "Lcom/larksuite/component/universe_design/loading/UDLoadingDrawable;", "createUploadRetryView", "canRetry", "logOverlayDecision", "decision", "expandTouchArea", "view", "extraDp", "Companion", "GalleryAdapter", "GalleryDiffCallback", "GalleryViewHolder", "SquareFrameLayout", "GridSpacingItemDecoration", "ai-note_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AINoteGalleryView extends FrameLayout {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f406894n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super String, Unit> f406895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super String, Unit> f406896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super xra.b, Unit> f406897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super xra.b, Unit> f406898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f406899e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f406900f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function0<Boolean> f406901g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f406902h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f406903i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f406904j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final HashMap<String, String> f406905k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final RecyclerView f406906l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final GestureDetector f406907m;

    public static final class a {
    }

    public final class b extends ListAdapter<xra.b, d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AINoteGalleryView f406909a;

        public b(AINoteGalleryView r100) {
            this.f406909a = r100;
            super(c.f406910a);
            setHasStableIds(true);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final long getItemId(int r100) {
            return getItem(r100).f564919a.hashCode();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onViewRecycled(RecyclerView.ViewHolder r100) {
            d r101 = (d) r100;
            Intrinsics.checkNotNullParameter(r101, "holder");
            r101.f406914d = null;
            r101.f406915e = false;
            r101.f406911a.a();
            r101.T3();
            super.onViewRecycled(r101);
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
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
            d r100 = (d) r110;
            Intrinsics.checkNotNullParameter(r100, "holder");
            xra.b r101 = getItem(r111);
            r100.getClass();
            Intrinsics.checkNotNullParameter(r101, "image");
            com.ss.android.ainote.b r102 = com.ss.android.ainote.b.f406680a;
            com.ss.android.ainote.b.e(r100.f406911a, r101.f564926h.name());
            com.ss.android.ainote.b.e(r100.f406912b, r101.f564926h.name());
            com.ss.android.ainote.b.c(r102, r100.f406913c, "vc-personal-notes-image-delete", "Personal Notes Image Delete Button", "Tap to remove this image from the personal note", "vc-personal-notes-note-item");
            r100.f406911a.a();
            boolean r103 = false;
            r100.f406915e = false;
            String r104 = r101.f564920b;
            if (r104.length() != 0) goto L5;
            boolean r105 = true;
        L6:
            if (r105 == false) goto L8;
            r104 = r101.f564921c;
        L8:
            com.ss.android.ainote.s r106 = r101.b();
            if (r104.length() <= 0) goto L11;
            boolean r107 = true;
        L12:
            FrameLayout r108 = null;
            r108 = null;
            Drawable r109 = null;
            if (r107 == false) goto L31;
            String r112 = GXImageView.LOCAL_PREFIX.concat(r104);
            if (Intrinsics.areEqual(r100.f406914d, r112) == true) goto L17;
        L19:
            boolean r113 = false;
        L20:
            r100.f406914d = r112;
            r100.f406912b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            r100.f406912b.setBackground(null);
            if (r113 == true) goto L47;
            r100.f406912b.setImageDrawable(null);
            IRequestCreator r114 = ImageLoader.with(r100.f406912b.getContext());
            AINoteGalleryView r115 = r100.f406916f;
            int r116 = AINoteGalleryView.f406894n;
            r115.getClass();
            if (StringsKt.startsWith$default(r104, "content://", false, 2, null) == false) goto L25;
        L28:
            Uri r117 = UriProtector.parse(r104);
            Intrinsics.checkNotNull(r117);
        L29:
            r114.load(r117).into(r100.f406912b);
            goto L47
        L25:
            if (StringsKt.startsWith$default(r104, MSkiaImageRegionDecoder.FILE_PREFIX, false, 2, null) == true) goto L28;
            r117 = Uri.fromFile(VFSFiles.f444819b.i(r104));
            Intrinsics.checkNotNull(r117);
        L47:
            r100.f406912b.setOnClickListener(new com.ss.android.ainote.list.e(r100.f406916f, r101));
            com.ss.android.ainote.list.g r118 = new com.ss.android.ainote.list.g(r100.f406916f, r101);
            r100.f406911a.setLongClickable(true);
            r100.f406911a.setOnLongClickListener(r118);
            r100.f406912b.setLongClickable(true);
            r100.f406912b.setOnLongClickListener(r118);
            r100.T3();
            r100.f406913c.setOnClickListener(new com.ss.android.ainote.list.f(r100.f406916f, r101));
            if (r100.f406913c.getVisibility() != 0) goto L56;
            AINoteGalleryView r119 = r100.f406916f;
            AppCompatImageView r120 = r100.f406913c;
            r119.getClass();
            Object r121 = r120.getParent();
            if ((r121 instanceof View) == false) goto L52;
            View r122 = (View) r121;
        L53:
            if (r122 == null) goto L56;
            r122.post(new l(r120, com.ss.android.ainote.util.a.b(r119.getContext(), 4), r122));
            goto L56
        L52:
            r122 = null;
        L56:
            AINoteGalleryView r123 = r100.f406916f;
            r123.getClass();
            String r124 = r101.f564920b;
            if (r124.length() != 0) goto L59;
            boolean r125 = true;
        L60:
            if (r125 == false) goto L63;
            r124 = r101.f564921c;
        L63:
            if (r124.length() != 0) goto L65;
            boolean r126 = true;
        L66:
            if (r126 == true) goto L68;
        L70:
            int r127 = g.f406922a[r101.f564926h.ordinal()];
            if (r127 != 1) goto L73;
        L80:
            String r128 = "loading(upload_state=" + r101.f564926h + ')';
        L81:
            r123.b(r101, r128);
            if (StringsKt.startsWith$default(r128, "loading", false, 2, null) == false) goto L91;
            com.ss.android.ainote.t.d("AINoteGalleryView", "createUploadLoadingView");
            FrameLayout r129 = new FrameLayout(r123.getContext());
            r129.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            r129.setBackgroundColor(ColorProtector.parseColor("#4D000000"));
            UDLoadingDrawable r130 = new UDLoadingDrawable(r129.getContext());
            r130.setColorSchemeColors(new int[]{ContextCompat.getColor(r129.getContext(), R.color.static_white)});
            Drawable r131 = ContextCompat.getDrawable(r123.getContext(), R.drawable.ai_note_long_click_menu_item_bg);
            if (r131 == null) goto L86;
            r109 = r131.mutate();
        L86:
            if (r109 == null) goto L88;
            r109.setAlpha(180);
        L88:
            View r132 = new View(r123.getContext());
            r132.setLayoutParams(new FrameLayout.LayoutParams(com.ss.android.ainote.util.a.b(r132.getContext(), 32), com.ss.android.ainote.util.a.b(r132.getContext(), 32), 17));
            r132.setBackground(r109);
            j r133 = new j(r130);
            AppCompatImageView r134 = new AppCompatImageView(r123.getContext());
            r134.setLayoutParams(new FrameLayout.LayoutParams(com.ss.android.ainote.util.a.b(r134.getContext(), 24), com.ss.android.ainote.util.a.b(r134.getContext(), 24), 17));
            r134.setImageDrawable(r130);
            r134.addOnAttachStateChangeListener(r133);
            r129.addView(r132);
            r129.addView(r134);
            r108 = r129;
        L89:
            boolean r135 = true;
            View r136 = r108;
        L96:
            if (r136 == null) goto L99;
            r136.setLongClickable(r135);
            r136.setOnLongClickListener(r118);
            r100.f406911a.b(r136);
            return;
        L99:
            return;
        L91:
            if (StringsKt.startsWith$default(r128, EventConstant.Value.RETRY, false, 2, null) == false) goto L89;
            int r137 = com.ss.android.ainote.t.f407207a;
            StringBuilder r138 = new StringBuilder("createUploadRetryView, imageId=");
            r138.append(r101.f564919a);
            r138.append(", uploadState=");
            r138.append(r101.f564926h);
            r138.append(", hasLocal=");
            r138.append(!StringsKt.isBlank(r101.f564920b));
            r138.append(", hasRemote=");
            if (r101.b() == null) goto L95;
            r103 = true;
        L95:
            r138.append(r103);
            r138.append(", lastError=");
            r138.append(r101.f564928j);
            com.ss.android.ainote.t.d("AINoteGalleryView", r138.toString());
            Drawable r139 = UDIconUtils.getIconDrawable(r123.getContext(), R.drawable.ud_icon_refresh_outlined, new UDDimension.Dp(24));
            r139.setTint(ContextCompat.getColor(r123.getContext(), R.color.static_white));
            AppCompatImageView r140 = new AppCompatImageView(r123.getContext());
            r140.setLayoutParams(new FrameLayout.LayoutParams(com.ss.android.ainote.util.a.b(r140.getContext(), 24), com.ss.android.ainote.util.a.b(r140.getContext(), 24), 17));
            com.ss.android.ainote.b.c(r102, r140, "vc-personal-notes-image-retry", "Personal Notes Image Retry Button", "Tap to retry uploading this image", "vc-personal-notes-image");
            r140.setImageDrawable(r139);
            r135 = true;
            r140.setClickable(true);
            r140.setFocusable(true);
            r140.setOnClickListener(new k(r101, r123));
            r136 = r140;
            goto L96
        L73:
            if (r127 == 2) goto L80;
            if (r127 == 3) goto L79;
            if (r127 == 4) goto L78;
            r128 = "none";
            goto L81
        L78:
            r128 = "none(upload_state=FAILED_FATAL)";
            goto L81
        L79:
            r128 = "retry(upload_state=FAILED_RETRYABLE)";
            goto L81
        L68:
            if (r101.b() != null) goto L70;
            r123.b(r101, "none(no_local_no_remote)");
            goto L89
        L65:
            r126 = false;
            goto L66
        L59:
            r125 = false;
            goto L60
        L17:
            if (r100.f406912b.getDrawable() == null) goto L19;
            r113 = true;
            goto L20
        L31:
            if (r106 == null) goto L46;
            String r141 = "remote:" + r106.f407200a + ':' + r106.f407204e + Permission.EXECUTE + r106.f407205f;
            if (Intrinsics.areEqual(r100.f406914d, r141) == true) goto L35;
        L37:
            boolean r142 = false;
        L38:
            r100.f406914d = r141;
            r100.f406912b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            r100.f406912b.setBackground(null);
            if (r142 == true) goto L47;
            r100.f406912b.setImageDrawable(null);
            r100.f406912b.setBackgroundColor(ContextCompat.getColor(r100.f406916f.getContext(), R.color.bg_body_overlay));
            r100.f406915e = true;
            f r143 = r100.f406911a;
            UDLoadingDrawable r144 = new UDLoadingDrawable(r100.f406916f.getContext());
            r144.setColorSchemeColors(new int[]{ContextCompat.getColor(r100.f406916f.getContext(), R.color.static_white)});
            AppCompatImageView r145 = new AppCompatImageView(r100.f406916f.getContext());
            r145.setLayoutParams(new FrameLayout.LayoutParams(com.ss.android.ainote.util.a.b(r145.getContext(), 24), com.ss.android.ainote.util.a.b(r145.getContext(), 24), 17));
            r145.setImageDrawable(r144);
            r145.addOnAttachStateChangeListener(new com.ss.android.ainote.list.h(r144));
            r143.b(r145);
            r100.T3();
            IRequestCreator r146 = ImageLoader.with(r100.f406912b.getContext()).load(new EncryptImage(r106.f407200a, r106.f407201b, r106.f407202c));
            int r147 = r106.f407204e;
            if (r147 <= 0) goto L45;
            int r148 = r106.f407205f;
            if (r148 <= 0) goto L45;
            r146.override(r147, r148);
        L45:
            r146.into(new com.ss.android.ainote.list.i(r100, r141, r100.f406916f));
            goto L47
        L35:
            if (r100.f406912b.getDrawable() == null) goto L37;
            r142 = true;
            goto L38
        L46:
            r100.f406914d = null;
            r100.f406915e = false;
            r100.f406911a.a();
            r100.T3();
            r100.f406912b.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            Drawable r149 = UDIconUtils.getIconDrawable(r100.f406916f.getContext(), R.drawable.ud_icon_image_fail_outlined, new UDDimension.Dp(24));
            r149.setTint(ContextCompat.getColor(r100.f406916f.getContext(), R.color.static_white));
            r100.f406912b.setImageDrawable(r149);
            r100.f406912b.setBackgroundColor(ContextCompat.getColor(r100.f406916f.getContext(), R.color.bg_body_overlay));
            goto L47
        L11:
            r107 = false;
            goto L12
        L5:
            r105 = false;
            goto L6
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            f r102 = new f(r100.getContext(), this.f406909a.f406902h);
            r102.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            r102.setForeground(ContextCompat.getDrawable(r102.getContext(), R.drawable.ai_note_gallery_item_border));
            AppCompatImageView r103 = new AppCompatImageView(r100.getContext());
            r103.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            r103.setScaleType(ImageView.ScaleType.CENTER_CROP);
            AppCompatImageView r104 = new AppCompatImageView(r100.getContext());
            FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(com.ss.android.ainote.util.a.b(r104.getContext(), 20), com.ss.android.ainote.util.a.b(r104.getContext(), 20), 8388661);
            r105.topMargin = com.ss.android.ainote.util.a.b(r104.getContext(), 4);
            r105.setMarginEnd(com.ss.android.ainote.util.a.b(r104.getContext(), 4));
            r104.setLayoutParams(r105);
            Drawable r106 = UDIconUtils.getIconDrawable(r104.getContext(), R.drawable.ud_icon_error_filled, new UDDimension.Dp(20));
            r104.setAlpha(0.7f);
            r104.setImageDrawable(r106);
            r104.setVisibility(8);
            r102.addView(r103);
            r102.addView(r104);
            return new d(this.f406909a, r102, r103, r104);
        }
    }

    public static final class c extends DiffUtil.ItemCallback<xra.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f406910a = null;

        static {
            f406910a = new c();
        }

        public c() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public final boolean areContentsTheSame(xra.b r100, xra.b r101) {
            xra.b r102 = r100;
            xra.b r103 = r101;
            Intrinsics.checkNotNullParameter(r102, "oldItem");
            Intrinsics.checkNotNullParameter(r103, "newItem");
            return Intrinsics.areEqual(r102, r103);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public final boolean areItemsTheSame(xra.b r100, xra.b r101) {
            xra.b r102 = r100;
            xra.b r103 = r101;
            Intrinsics.checkNotNullParameter(r102, "oldItem");
            Intrinsics.checkNotNullParameter(r103, "newItem");
            return Intrinsics.areEqual(r102.f564919a, r103.f564919a);
        }
    }

    public final class d extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f406911a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AppCompatImageView f406912b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AppCompatImageView f406913c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f406914d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f406915e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ AINoteGalleryView f406916f;

        public final void T3() {
            AppCompatImageView r100 = this.f406913c;
            if (this.f406916f.getOnImageDelete() != null) goto L5;
        L7:
            int r101 = 8;
        L8:
            r100.setVisibility(r101);
            return;
        L5:
            if (this.f406915e == true) goto L7;
            r101 = 0;
            goto L8
        }

        public d(AINoteGalleryView r100, f r101, AppCompatImageView r102, AppCompatImageView r103) {
            Intrinsics.checkNotNullParameter(r101, RootDescription.ROOT_ELEMENT);
            Intrinsics.checkNotNullParameter(r102, "imageView");
            Intrinsics.checkNotNullParameter(r103, "deleteView");
            this.f406916f = r100;
            super(r101);
            this.f406911a = r101;
            this.f406912b = r102;
            this.f406913c = r103;
        }
    }

    public static final class e extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f406917a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f406918b;

        public e(int r100) {
            this.f406917a = 3;
            this.f406918b = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
            Intrinsics.checkNotNullParameter(r100, "outRect");
            Intrinsics.checkNotNullParameter(r101, "view");
            Intrinsics.checkNotNullParameter(r102, "parent");
            Intrinsics.checkNotNullParameter(r103, "state");
            int r104 = r102.getChildAdapterPosition(r101);
            if (r104 != (-1)) goto L5;
            return;
        L5:
            int r105 = this.f406917a;
            int r106 = r104 % r105;
            int r107 = this.f406918b;
            r100.left = (r106 * r107) / r105;
            r100.right = r107 - (((r106 + 1) * r107) / r105);
            if (r104 >= r105) goto L9;
            r107 = 0;
        L9:
            r100.top = r107;
            r100.bottom = 0;
        }
    }

    public static final class f extends FrameLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f406919a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View f406920b;

        public static final class a extends ViewOutlineProvider {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ f f406921a;

            public a(f r100) {
                this.f406921a = r100;
            }

            @Override // android.view.ViewOutlineProvider
            public final void getOutline(View r100, Outline r101) {
                Intrinsics.checkNotNullParameter(r100, "view");
                Intrinsics.checkNotNullParameter(r101, "outline");
                r101.setRoundRect(0, 0, r100.getWidth(), r100.getHeight(), this.f406921a.f406919a);
            }
        }

        public final void a() {
            View r100 = this.f406920b;
            if (r100 == null) goto L5;
            removeView(r100);
        L5:
            this.f406920b = null;
        }

        public final void b(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            a();
            this.f406920b = r100;
            int r101 = RangesKt.coerceAtMost(1, getChildCount());
            ViewGroup.LayoutParams r102 = r100.getLayoutParams();
            if ((r102 instanceof FrameLayout.LayoutParams) == false) goto L6;
            FrameLayout.LayoutParams r103 = (FrameLayout.LayoutParams) r102;
        L9:
            addView(r100, r101, r103);
            return;
        L6:
            if (r102 == null) goto L8;
            r103 = new FrameLayout.LayoutParams(r102.width, r102.height, 17);
            goto L9
        L8:
            r103 = new FrameLayout.LayoutParams(-1, -1, 17);
            goto L9
        }

        public f(Context r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100);
            this.f406919a = r101;
            setClipToOutline(true);
            setOutlineProvider(new a(this));
        }

        @Override // android.widget.FrameLayout, android.view.View
        public final void onMeasure(int r100, int r101) {
            int r102 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r100), 1073741824);
            super.onMeasure(r102, r102);
        }
    }

    public /* synthetic */ class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f406922a = null;

        static {
            int[] r100 = new int[AINoteImageUploadState.values().length];
            r100[AINoteImageUploadState.UPLOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[AINoteImageUploadState.QUEUED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[AINoteImageUploadState.FAILED_RETRYABLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[AINoteImageUploadState.FAILED_FATAL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f406922a = r100;
        }
    }

    public static final class h extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AINoteGalleryView f406923a;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            return true;
        }

        public h(AINoteGalleryView r100) {
            this.f406923a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            if (this.f406923a.f406906l.findChildViewUnder(r100.getX(), r100.getY()) != null) goto L15;
            Function0<Boolean> r101 = this.f406923a.getCanHandleLongPress();
            if (r101 != null) goto L7;
        L9:
            boolean r102 = false;
        L10:
            if (r102 == true) goto L16;
            com.ss.android.ainote.t.d("AINoteGalleryView", "blank long click");
            this.f406923a.f406906l.performHapticFeedback(0);
            Function0<Unit> r103 = this.f406923a.getOnBlankLongClick();
            if (r103 == null) goto L17;
            r103.invoke();
            return;
        L17:
            return;
        L16:
            return;
        L7:
            if (r101.invoke().booleanValue() == true) goto L9;
            r102 = true;
            goto L10
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "e");
            if (this.f406923a.f406906l.findChildViewUnder(r100.getX(), r100.getY()) != null) goto L9;
            com.ss.android.ainote.t.d("AINoteGalleryView", "blank click");
            Function0<Unit> r101 = this.f406923a.getOnBlankClick();
            if (r101 == null) goto L10;
            r101.invoke();
            return false;
        L10:
            return false;
        L9:
            return false;
        }
    }

    public static final class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f406924a;

        public i(Function0 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f406924a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f406924a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public AINoteGalleryView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AINoteGalleryView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final Function0<Boolean> getCanHandleLongPress() {
        return this.f406901g;
    }

    public final Function0<Unit> getOnBlankClick() {
        return this.f406899e;
    }

    public final Function0<Unit> getOnBlankLongClick() {
        return this.f406900f;
    }

    public final Function1<xra.b, Unit> getOnImageClick() {
        return this.f406897c;
    }

    public final Function1<String, Unit> getOnImageDelete() {
        return this.f406895a;
    }

    public final Function1<xra.b, Unit> getOnImageLongClick() {
        return this.f406898d;
    }

    public final Function1<String, Unit> getOnImageRetry() {
        return this.f406896b;
    }

    public final void a(List<xra.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "images");
        if (r100.isEmpty() == false) goto L5;
        int r101 = 8;
    L6:
        setVisibility(r101);
        if (r100.isEmpty() == false) goto L9;
        return;
    L9:
        b r102 = this.f406904j;
        Function0<Unit> r103 = new AINoteGalleryView$bind$1(this);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "images");
        r102.submitList(r100, new i(r103));
        return;
    L5:
        r101 = 0;
        goto L6
    }

    public final void setCanHandleLongPress(Function0<Boolean> r100) {
        this.f406901g = r100;
    }

    public final void setOnBlankClick(Function0<Unit> r100) {
        this.f406899e = r100;
    }

    public final void setOnBlankLongClick(Function0<Unit> r100) {
        this.f406900f = r100;
    }

    public final void setOnImageClick(Function1<? super xra.b, Unit> r100) {
        this.f406897c = r100;
    }

    public final void setOnImageDelete(Function1<? super String, Unit> r100) {
        this.f406895a = r100;
    }

    public final void setOnImageLongClick(Function1<? super xra.b, Unit> r100) {
        this.f406898d = r100;
    }

    public final void setOnImageRetry(Function1<? super String, Unit> r100) {
        this.f406896b = r100;
    }

    public final void b(xra.b r100, String r110) {
        StringBuilder r101 = new StringBuilder("u=");
        r101.append(r100.f564926h);
        r101.append("|local=");
        boolean r102 = true;
        r101.append(!StringsKt.isBlank(r100.f564920b));
        r101.append("|originLocal=");
        r101.append(!StringsKt.isBlank(r100.f564921c));
        r101.append("|remote=");
        if (r100.b() == null) goto L5;
        boolean r103 = true;
    L6:
        r101.append(r103);
        r101.append("|err=");
        r101.append(r100.f564928j);
        String r104 = r101.toString();
        if (Intrinsics.areEqual(r104, this.f406905k.get(r100.f564919a)) == false) goto L9;
        return;
    L9:
        this.f406905k.put(r100.f564919a, r104);
        String r105 = r100.f564920b;
        if (r105.length() != 0) goto L12;
        boolean r106 = true;
    L13:
        if (r106 == false) goto L16;
        r105 = r100.f564921c;
    L16:
        if (r105.length() != 0) goto L18;
        boolean r107 = true;
    L19:
        Boolean r108 = null;
        if (r107 == false) goto L23;
        String r109 = "none";
    L30:
        if (Intrinsics.areEqual(r109, "file") == false) goto L52;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L45
        String r112 = UriProtector.parse(r105).getPath();     // Catch: Throwable -> L45
        if (r112 != null) goto L35;
        r112 = "";
    L35:
        if (r112.length() <= 0) goto L37;
        boolean r113 = true;
    L38:
        if (r113 == true) goto L40;
    L42:
        boolean r114 = false;
    L43:
        Object r115 = Result.m9449constructorimpl(Boolean.valueOf(r114));     // Catch: Throwable -> L45
    L47:
        Boolean r116 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r115) == false) goto L50;
        r115 = r116;
    L50:
        r108 = (Boolean) r115;
    L61:
        int r117 = com.ss.android.ainote.t.f407207a;
        StringBuilder r118 = new StringBuilder("statusOverlay, imageId=");
        r118.append(r100.f564919a);
        r118.append(", decision=");
        r118.append(r110);
        r118.append(", uploadState=");
        r118.append(r100.f564926h);
        r118.append(", localEmpty=");
        if (r100.f564920b.length() != 0) goto L64;
        boolean r119 = true;
    L65:
        r118.append(r119);
        r118.append(", originLocalEmpty=");
        if (r100.f564921c.length() != 0) goto L68;
        boolean r120 = true;
    L69:
        r118.append(r120);
        r118.append(", effectiveLocalEmpty=");
        if (r105.length() != 0) goto L72;
        boolean r121 = true;
    L73:
        r118.append(r121);
        r118.append(", scheme=");
        r118.append(r109);
        r118.append(", fileExists=");
        r118.append(r108);
        r118.append(", remote=");
        if (r100.b() != null) goto L77;
        r102 = false;
    L77:
        r118.append(r102);
        r118.append(", lastError=");
        r118.append(r100.f564928j);
        com.ss.android.ainote.t.d("AINoteGalleryView", r118.toString());
        return;
    L72:
        r121 = false;
        goto L73
    L68:
        r120 = false;
        goto L69
    L64:
        r119 = false;
        goto L65
    L40:
        if (VFSFiles.f444819b.i(r112).exists() == false) goto L42;
        r114 = true;
        goto L43
    L37:
        r113 = false;
    L45:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L47
    L52:
        if (Intrinsics.areEqual(r109, "path") == false) goto L61;
        Result.Companion r123 = Result.Companion;     // Catch: Throwable -> L55
        Object r124 = Result.m9449constructorimpl(Boolean.valueOf(VFSFiles.f444819b.i(r105).exists()));     // Catch: Throwable -> L55
    L57:
        Boolean r125 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r124) == false) goto L60;
        r124 = r125;
    L60:
        r108 = (Boolean) r124;
    L55:
        th = move-exception;
        Result.Companion r126 = Result.Companion;
        r124 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L57
    L23:
        if (StringsKt.startsWith$default(r105, "content://", false, 2, null) == false) goto L26;
        r109 = "content";
        goto L30
    L26:
        if (StringsKt.startsWith$default(r105, MSkiaImageRegionDecoder.FILE_PREFIX, false, 2, null) == false) goto L28;
        r109 = "file";
        goto L30
    L28:
        r109 = "path";
        goto L30
    L18:
        r107 = false;
        goto L19
    L12:
        r106 = false;
        goto L13
    L5:
        r103 = false;
        goto L6
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = RangesKt.coerceAtLeast(View.MeasureSpec.getSize(r100) - this.f406903i, 0);
        if (this.f406906l.getPaddingLeft() == 0) goto L5;
    L6:
        RecyclerView r103 = this.f406906l;
        r103.setPadding(0, r103.getPaddingTop(), r102, this.f406906l.getPaddingBottom());
    L7:
        super.onMeasure(r100, r101);
        return;
    L5:
        if (this.f406906l.getPaddingRight() == r102) goto L7;
        goto L6
    }

    public AINoteGalleryView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f406902h = com.ss.android.ainote.util.a.b(r100, 8);
        int r103 = com.ss.android.ainote.util.a.b(r100, 6);
        this.f406903i = (com.ss.android.ainote.util.a.b(r100, 132) * 3) + (2 * r103);
        b r104 = new b(this);
        this.f406904j = r104;
        this.f406905k = new HashMap();
        RecyclerView r105 = new RecyclerView(r100);
        r105.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        r105.setLayoutManager(new GridLayoutManager(r100, 3));
        r105.setItemAnimator(null);
        r105.setOverScrollMode(2);
        r105.setNestedScrollingEnabled(false);
        r105.setAdapter(r104);
        r105.addItemDecoration(new e(r103));
        this.f406906l = r105;
        this.f406907m = new GestureDetector(r100, new h(this));
        addView(r105);
        r105.addOnItemTouchListener(new AnonymousClass1(this));
    }

    public /* synthetic */ AINoteGalleryView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
