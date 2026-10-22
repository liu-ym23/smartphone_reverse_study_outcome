package com.larus.bmhome.chat.layout.holder.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.layout.holder.image.n0;
import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.bmhome.chat.layout.holder.video.bean.CoverItem;
import com.larus.bmhome.chat.monitor.IMessageImageLoaderService;
import com.larus.bmhome.chat.monitor.MessageImageLoader;
import com.larus.bmhome.chat.monitor.MessageImageType;
import com.larus.bmhome.databinding.LarusVideoPreviewCardBinding;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.delegate.c0;
import com.larus.image.loader.b0;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y0;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
public final class GenerateVideoBox extends xc8.h {
    public static final /* synthetic */ int C = 0;
    public boolean A;
    public final c B;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Message f304049p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Message f304050q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public AiGenVideoContentData f304051r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public BotModel f304052s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f304053t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public q0.a f304054u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final GenerateVideoBox$actLifecycleObserver$1 f304055v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f304056w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Message f304057x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f304058y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final LarusVideoPreviewCardBinding f304059z;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b extends TypeToken<Map<String, ? extends String>> {
        public b() {
        }
    }

    public static final class c implements n0 {
        public c() {
        }

        @Override // com.larus.bmhome.chat.layout.holder.image.n0
        public final void a() {
        }

        @Override // com.larus.bmhome.chat.layout.holder.image.n0
        public final void b(String r100, int r101) {
        }
    }

    static {
    }

    public final JSONObject n() {
        Message r100 = this.f304050q;
        String r101 = null;
        if (r100 == null) goto L29;
        Map<String, String> r102 = r100.getExt();
        if (r102 == null) goto L29;
        String r103 = r102.get("creation_template");
        if (r103 == null) goto L29;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L23
        zd9.h r105 = zd9.h.f571481a;     // Catch: Throwable -> L23
        if (StringsKt.isBlank(r103) == false) goto L49;
    L10:
        Object r106 = null;
    L21:
        Object r107 = Result.m9449constructorimpl((Map) r106);     // Catch: Throwable -> L23
    L26:
        if (Result.m9455isFailureimpl(r107) == false) goto L28;
        r107 = null;
    L28:
        Map r108 = (Map) r107;
    L30:
        JSONObject r109 = new JSONObject();
        if (r108 == null) goto L33;
        String r110 = (String) r108.get("recommend_from");
    L35:
        if (r108 == null) goto L37;
        String r111 = (String) r108.get("from_template_id");
    L39:
        if (r108 == null) goto L41;
        String r112 = (String) r108.get("template_rec_extra");
    L43:
        if (r108 == null) goto L45;
        r101 = (String) r108.get("template_rec_req_id");
    L45:
        r109.put("recommend_from", r110);
        r109.put("from_template_id", r111);
        r109.put("template_rec_req_id", r101);
        r109.put("template_rec_extra", r112);
        return r109;
    L41:
        r112 = null;
        goto L43
    L37:
        r111 = null;
        goto L39
    L33:
        r110 = null;
        goto L35
    L49:
        r105.getClass();     // Catch: Throwable -> L13
        r106 = Result.m9449constructorimpl(zd9.h.f571482b.fromJson(r103, new b().getType()));     // Catch: Throwable -> L13
    L15:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r106);     // Catch: Throwable -> L23
        if (r113 == null) goto L19;
        c0 r114 = c0.f348199b;     // Catch: Throwable -> L23
        StringBuilder r115 = new StringBuilder("fromJson failed, stack: ");     // Catch: Throwable -> L23
        Intrinsics.checkNotNullParameter(r113, "<this>");     // Catch: Throwable -> L23
        r115.append(ExceptionsKt.stackTraceToString(r113));     // Catch: Throwable -> L23
        r114.e("GsonHolder", r115.toString());     // Catch: Throwable -> L23
    L19:
        if (Result.m9455isFailureimpl(r106) == false) goto L21;
    L13:
        th = move-exception;
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L23
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L29:
        r108 = null;
        goto L30
    }

    public final void q() {
        if (this.f304053t == false) goto L5;
        return;
    L5:
        AiGenVideoContentData r100 = this.f304051r;
        if (r100 != null) goto L8;
        return;
    L8:
        SimpleDraweeView r101 = this.f304059z.f311276c;
        CoverItem r102 = r100.getVideoCover();
        String r103 = null;
        if (r102 == null) goto L11;
        String r104 = ff8.b.b(r102);
    L12:
        Uri r105 = b0.a(r104, "chat.video_cover.thumb", false, false, 6);
        AiGenVideoContentData r106 = this.f304051r;
        if (r106 == null) goto L17;
        CoverItem r107 = r106.getVideoCover();
        if (r107 == null) goto L17;
        r103 = ff8.b.a(r107);
    L17:
        o(r101, r105, b0.a(r103, "chat.video_cover", false, false, 6), this.B);
        return;
    L11:
        r104 = null;
        goto L12
    }

    @Override // com.larus.bmhome.chat.layout.item.i, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        q();
        Context r100 = getContext();
        if ((r100 instanceof ComponentActivity) == false) goto L5;
        ComponentActivity r101 = (ComponentActivity) r100;
    L6:
        if (r101 == null) goto L11;
        Lifecycle r102 = r101.getLifecycle();
        if (r102 == null) goto L12;
        r102.addObserver(this.f304055v);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Context r100 = getContext();
        if ((r100 instanceof ComponentActivity) == false) goto L5;
        ComponentActivity r101 = (ComponentActivity) r100;
    L6:
        if (r101 == null) goto L11;
        Lifecycle r102 = r101.getLifecycle();
        if (r102 == null) goto L12;
        r102.removeObserver(this.f304055v);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public int getBoxType() {
        return this.f304056w;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.bmhome.chat.layout.holder.video.GenerateVideoBox$actLifecycleObserver$1] */
    public GenerateVideoBox(Context r110) {
        super(r110);
        this.f304055v = new GenerateVideoBox$actLifecycleObserver$1(this);
        this.f304056w = -1;
        new ResizeOptions(i5.P(), i5.P());
        this.f304058y = "GenerateVideoBox";
        View r111 = LayoutInflater.from(r110).inflate(R.layout.larus_video_preview_card, this, false);
        addView(r111);
        int r100 = R.id.cover_container;
        FrameLayout r101 = (FrameLayout) ViewBindings.findChildViewById(r111, R.id.cover_container);
        if (r101 == null) goto L19;
        r100 = R.id.cover_image;
        SimpleDraweeView r102 = (SimpleDraweeView) ViewBindings.findChildViewById(r111, R.id.cover_image);
        if (r102 == null) goto L19;
        r100 = R.id.play_btn;
        if (((ImageView) ViewBindings.findChildViewById(r111, R.id.play_btn)) == null) goto L19;
        r100 = R.id.regenerate_btn;
        if (((TextView) ViewBindings.findChildViewById(r111, R.id.regenerate_btn)) == null) goto L19;
        r100 = R.id.video_download;
        ImageView r103 = (ImageView) ViewBindings.findChildViewById(r111, R.id.video_download);
        if (r103 == null) goto L19;
        r100 = R.id.video_download_loading;
        ProgressBar r104 = (ProgressBar) ViewBindings.findChildViewById(r111, R.id.video_download_loading);
        if (r104 == null) goto L19;
        r100 = R.id.video_extend;
        TextView r105 = (TextView) ViewBindings.findChildViewById(r111, R.id.video_extend);
        if (r105 == null) goto L19;
        this.f304059z = new LarusVideoPreviewCardBinding((ConstraintLayout) r111, r101, r102, r103, r104, r105);
        this.B = new c();
        return;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r111.getResources().getResourceName(r100)));
    }

    @Override // com.larus.bmhome.chat.layout.item.i
    public void setBoxType(int r100) {
        this.f304056w = r100;
    }

    public final void o(final SimpleDraweeView r110, final Uri r111, Uri r210, final c r211) {
        if (r111 != null) goto L7;
        if (r210 != null) goto L7;
        FLogger.f375446a.e(this.f304058y, "loadImage url is invalid ");
        r110.setActualImageResource(R.drawable.larus_generate_image_error);
        return;
    L7:
        final Ref.BooleanRef r100 = new Ref.BooleanRef();
        final String r101 = y0.k(r210);
        Message r102 = this.f304049p;
        ImageDecodeOptions r103 = ImageDecodeOptions.newBuilder().setBitmapConfig(Bitmap.Config.RGB_565).build();
        if (r111 == null) goto L10;
        final ImageRequest r104 = ImageRequestBuilder.newBuilderWithSource(r111).setImageDecodeOptions(r103).build();
    L11:
        if (r102 == null) goto L13;
        String r112 = r102.getMessageId();
    L14:
        MessageImageLoader r113 = MessageImageLoader.f308183a;
        MessageImageType r114 = MessageImageType.VIDEO;
        if (r210 == null) goto L17;
        String r115 = r210.toString();
    L18:
        final String r105 = r112;
        IMessageImageLoaderService.a.a(r113, r112, r114, r110, r115, null, new d(r104, r110, r100, r101, this, r111, r211, r105), 48);
        return;
    L17:
        r115 = null;
        goto L18
    L13:
        r112 = null;
        goto L14
    L10:
        r104 = null;
        goto L11
    }
}
